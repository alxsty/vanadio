package net.digitstar.vanadio;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;

import java.text.Format;

import static net.digitstar.vanadio.Styles.*;


/**
 * <p>Title: AscotWeb Elezioni</p>
 * <p/>
 * <p>Description: Gestione consultazioni elettorali</p>
 * <p/>
 * <p>Copyright: Copyright (c) 2001-2009</p>
 * <p/>
 * <p>Company: Insiel S.p.A.</p>
 *
 * @author Alex Svetina
 * @author Tino Pratticò
 * @version 2009 rel. 2009
 */

public class CellStyle
{
	public enum Align
	{
		UNDEFINED(-1),
		LEFT(0),
		CENTER(1),
		RIGHT(2),
		JUSTIFIED(3),
		TOP(4),
		MIDDLE(5),
		BOTTOM(6),
		BASELINE(7),
		JUSTIFIED_ALL(8);

		private int value = -1;

		Align(int value)
		{
			this.value = value;
		}

		public int getValue()
		{
			return value;
		}

		public static Align setValue(int value)
		{
			Align a = UNDEFINED;
			for (Align item : Align.values())
			{
				if (item.getValue() == value)
				{
					a = item;
					break;
				}
			}

			return a;
		}
	}

	public enum Border
	{
		UNDEFINED(-1),
		NONE(0),
		LEFT(4),
		TOP(1),
		RIGHT(8),
		BOTTOM(2),
		BOX(TOP.getValue() + LEFT.getValue() + RIGHT.getValue() + BOTTOM.getValue());

		private int value = -1;

		Border(int value)
		{
			this.value = value;
		}

		public int getValue()
		{
			return value;
		}
	}

	public enum Rotation
	{
		NONE(0),
		VERTICAL_UP(90),
		UPSIDE(180),
		VERTICAL_DOWN(270);

		private int value = 0;

		Rotation(int value)
		{
			this.value = value;
		}

		public int getValue()
		{
			return value;
		}
	}

	//PdfPCell
	private Align vertAlign;
	private Align horizAlign;
	private Alignment alignment;
	private Rect<Float> padding;
	private boolean noWrap;
	private PdfPTable nestedTable;
	private int colspan;
	private int rowspan;
	private Image image;
	private boolean fitImage;
	private boolean useBorderPadding;
	private Phrase text;

	private float fixedHeight;
	private float minimumHeight;
	//Rectangle
	private Rotation rotation;
	private Border border;
	private BaseColor backgroundColor;
	private boolean useVariableBorders;
	private float greyFill;
	private Rect<BaseColor> borderColor;
	private Rect<Float> borderWidth;

	private Font cellFont;

	private boolean alternateColor;
	private Format format;

	public CellStyle()
	{
		reset();
	}

	public CellStyle(CellStyle style)
	{
		this();
		if(style != null)
		{
			this.nestedTable = style.nestedTable;
			this.image = style.image;
			this.text = style.text;

			this.fitImage = style.fitImage;
			this.vertAlign = style.vertAlign;
			this.horizAlign = style.horizAlign;
			this.padding = new Rect<Float>(style.padding)
			{
				protected Float zero()
				{
					return 0f;
				}
			};
			this.noWrap = style.noWrap;
			this.colspan = style.colspan;
			this.rowspan = style.rowspan;
			this.useBorderPadding = style.useBorderPadding;
			this.fixedHeight = style.fixedHeight;
			this.minimumHeight = style.minimumHeight;
			//Rectangle
			this.rotation = style.rotation;
			this.border = style.border;
			this.backgroundColor = style.backgroundColor;
			this.useVariableBorders = style.useVariableBorders;
			this.greyFill = style.greyFill;
			this.borderColor = new Rect<BaseColor>(style.borderColor)
			{
				protected BaseColor zero()
				{
					return null;
				}
			};
			this.borderWidth = new Rect<Float>(style.borderWidth)
			{
				protected Float zero()
				{
					return -1f;
				}
			};
			this.cellFont = style.cellFont;

			this.alternateColor = style.alternateColor;
			this.format = style.format;
		}

	}

	public CellStyle reset()
	{

		nestedTable = null;
		image = null;
		text = null;

		fitImage = true;
		vertAlign = Align.UNDEFINED;
		horizAlign = Align.UNDEFINED;
		alignment = new Alignment(horizAlign,vertAlign);
		padding = new Rect<Float>(2f, 2f, 2f, 2f)
		{
			protected Float zero()
			{
				return 0f;
			}
		};
		noWrap = false;
		colspan = 1;
		rowspan = 1;
		useBorderPadding = false;
		fixedHeight = 0;
		minimumHeight = 0;
		//Rectangle
		rotation = Rotation.NONE;
		border = Border.BOX;
		backgroundColor = null;
		useVariableBorders = true;
		greyFill = -1f;
		borderColor = new Rect<BaseColor>()
		{
			protected BaseColor zero()
			{
				return null;
			}
		};
		borderWidth = new Rect<Float>(0.2f, 0.2f, 0.2f, 0.2f)
		{
			protected Float zero()
			{
				return -1f;
			}
		};
		cellFont = Styles.FontType.NORMAL.getFont();

		alternateColor = false;
		format = null;

		return this;
	}

	public Align getVertAlign()
	{
		return vertAlign;
	}

	public CellStyle setVertAlign(Align vertAlign)
	{
		this.vertAlign = vertAlign;
		this.alignment.resetConverted();
		return this;
	}

	public Align getHorizAlign()
	{
		return horizAlign;
	}

	public CellStyle setHorizAlign(Align horizAlign)
	{
		this.horizAlign = horizAlign;
		this.alignment.resetConverted();
		return this;
	}

	public Rect<Float> getPadding()
	{
		return padding;
	}

	public CellStyle setPadding(Rect<Float> padding)
	{
		this.padding = padding;
		return this;
	}

	public boolean isNoWrap()
	{
		return noWrap;
	}

	public CellStyle setNoWrap(boolean noWrap)
	{
		this.noWrap = noWrap;
		return this;
	}

	public PdfPTable getNestedTable()
	{
		return nestedTable;
	}

	public CellStyle setNestedTable(PdfPTable nestedTable)
	{
		this.nestedTable = nestedTable;
		return this;
	}

	public int getColspan()
	{
		return colspan;
	}

	public CellStyle setColspan(int colspan)
	{
		this.colspan = colspan;
		return this;
	}

	public int getRowspan()
	{
		return rowspan;
	}

	public CellStyle setRowspan(int rowspan)
	{
		this.rowspan = rowspan;
		return this;
	}

	public Image getImage()
	{
		return image;
	}

	public CellStyle setImage(Image image)
	{
		this.image = image;
		return this;
	}

	public boolean isUseBorderPadding()
	{
		return useBorderPadding;
	}

	public CellStyle setUseBorderPadding(boolean useBorderPadding)
	{
		this.useBorderPadding = useBorderPadding;
		return this;
	}

	public Phrase getText()
	{
		return text;
	}

	public CellStyle setText(String text)
	{
		return setText(new Phrase(text, this.cellFont));
	}

	public CellStyle setText(Phrase text)
	{
		this.text = text;
		return this;
	}

	public Rotation getRotation()
	{
		return rotation;
	}

	public CellStyle setRotation(Rotation rotation)
	{
		this.rotation = rotation;
		this.alignment.resetConverted();
		return this;
	}

	public Border getBorder()
	{
		return border;
	}

	public CellStyle setBorder(Border border)
	{
		this.border = border;
		return this;
	}

	public BaseColor getBackgroundColor()
	{
		return backgroundColor;
	}

	public CellStyle setBackgroundColor(BaseColor backgroundColor)
	{
		this.backgroundColor = backgroundColor;
		return this;
	}

	public boolean isUseVariableBorders()
	{
		return useVariableBorders;
	}

	public CellStyle setUseVariableBorders(boolean useVariableBorders)
	{
		this.useVariableBorders = useVariableBorders;
		return this;
	}

	public float getGreyFill()
	{
		return greyFill;
	}

	public CellStyle setGreyFill(float greyFill)
	{
		this.greyFill = greyFill;
		return this;
	}

	public Rect<BaseColor> getBorderColor()
	{
		return borderColor;
	}

	public CellStyle setBorderColor(Rect<BaseColor> borderColor)
	{
		this.borderColor = borderColor;
		return this;
	}

	public Rect<Float> getBorderWidth()
	{
		return borderWidth;
	}

	public CellStyle setBorderWidth(Rect<Float> borderWidth)
	{
		this.borderWidth = borderWidth;
		return this;
	}

	public Font getCellFont()
	{
		return cellFont;
	}

	public CellStyle setCellFont(Font cellFont)
	{
		this.cellFont = cellFont;
		return this;
	}

	public CellStyle setCellFont(FontType cellFont)
	{
		return setCellFont(cellFont.getFont());
	}

	public boolean isFitImage()
	{
		return fitImage;
	}

	public CellStyle setFitImage(boolean fitImage)
	{
		this.fitImage = fitImage;
		return this;
	}

	public float getFixedHeight()
	{
		return fixedHeight;
	}

	public CellStyle setFixedHeight(float fixedHeight)
	{
		this.fixedHeight = fixedHeight;
		return this;
	}

	public float getMinimumHeight()
	{
		return minimumHeight;
	}

	public CellStyle setMinimumHeight(float minimumHeight)
	{
		this.minimumHeight = minimumHeight;
		return this;
	}


	public Alignment getAlignment()
	{
		return alignment;
	}

	public boolean isAlternateColor()
	{
		return alternateColor;
	}

	public CellStyle setAlternateColor(boolean alternateColor)
	{
		this.alternateColor = alternateColor;
		return this;
	}

	public Format getFormat()
	{
		return format;
	}

	public CellStyle setFormat(Format format)
	{
		this.format = format;
		return this;
	}

	@Override
	public String toString()
	{
		return "CellStyle{" +
			"vertAlign=" + vertAlign +
			", horizAlign=" + horizAlign +
			", alignment=" + alignment +
			", padding=" + padding +
			", noWrap=" + noWrap +
			", nestedTable=" + nestedTable +
			", colspan=" + colspan +
			", rowspan=" + rowspan +
			", image=" + image +
			", fitImage=" + fitImage +
			", useBorderPadding=" + useBorderPadding +
			", text=" + text +
			", fixedHeight=" + fixedHeight +
			", minimumHeight=" + minimumHeight +
			", rotation=" + rotation +
			", border=" + border +
			", backgroundColor=" + backgroundColor +
			", useVariableBorders=" + useVariableBorders +
			", greyFill=" + greyFill +
			", borderColor=" + borderColor +
			", borderWidth=" + borderWidth +
			", cellFont=" + cellFont +
			", alternateColor=" + alternateColor +
			", format=" + format +
			'}';
	}
}
