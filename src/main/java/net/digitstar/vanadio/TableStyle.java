package net.digitstar.vanadio;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: 908190
 * Date: 10-lug-2009
 * Time: 10.54.44
 */
public class TableStyle
{
    public static final float FULL_WIDTH = 100f;

	private int columnNumber;
	private float widthPct;
	private float spacingBefore;
	private float spacingAfter;
	private float[] columnWidths;
	private boolean pageBreakBefore;
	private boolean pageBreakAfter;


	public TableStyle()
	{
		reset();
	}


	public TableStyle(int columnNumber, float ... columnWidths)
	{
		this();
		this.columnNumber = columnNumber;
		this.columnWidths = columnWidths;
	}

	public TableStyle(TableStyle style)
	{
		this();
		if (style != null)
		{
			this.columnNumber = style.columnNumber;
			this.widthPct = style.widthPct;
			this.spacingBefore = style.spacingBefore;
			this.spacingAfter = style.spacingAfter;
			this.columnWidths = style.columnWidths;
			this.pageBreakBefore = style.pageBreakBefore;
			this.pageBreakAfter = style.pageBreakAfter;
		}
	}

	public void reset()
	{
		this.columnNumber = 1;
		this.widthPct = FULL_WIDTH;
		this.spacingBefore = 0f;
		this.spacingAfter = 0f;
		this.columnWidths = null;
		this.pageBreakBefore = false;
		this.pageBreakAfter = false;
	}

	public int getColumnNumber()
	{
		return columnNumber;
	}

	public TableStyle setColumnNumber(int columnNumber)
	{
		this.columnNumber = columnNumber;
		return this;
	}

	public float getWidthPct()
	{
		return widthPct;
	}

	public TableStyle setWidthPct(float widthPct)
	{
		this.widthPct = widthPct;
		return this;
	}

	public float getSpacingBefore()
	{
		return spacingBefore;
	}

	public TableStyle setSpacingBefore(float spacingBefore)
	{
		this.spacingBefore = spacingBefore;
		return this;
	}

	public float getSpacingAfter()
	{
		return spacingAfter;
	}

	public TableStyle setSpacingAfter(float spacingAfter)
	{
		this.spacingAfter = spacingAfter;
		return this;
	}

	public float[] getColumnWidths()
	{
		return columnWidths;
	}

	public TableStyle setColumnWidths(float ... columnWidths)
	{
		this.columnWidths = columnWidths;
		return this;
	}

	public boolean isPageBreakBefore()
	{
		return pageBreakBefore;
	}

	public TableStyle setPageBreakBefore(boolean pageBreakBefore)
	{
		this.pageBreakBefore = pageBreakBefore;
		return this;
	}

	public boolean isPageBreakAfter()
	{
		return pageBreakAfter;
	}

	public TableStyle setPageBreakAfter(boolean pageBreakAfter)
	{
		this.pageBreakAfter = pageBreakAfter;
		return this;
	}

	@Override
	public String toString()
	{
		return "TableStyle{" +
			"columnNumber=" + columnNumber +
			", widthPct=" + widthPct +
			", spacingBefore=" + spacingBefore +
			", spacingAfter=" + spacingAfter +
			", columnWidths=" + (columnWidths == null ? null : Arrays.asList(columnWidths)) +
			", pageBreakBefore=" + pageBreakBefore +
			", pageBreakAfter=" + pageBreakAfter +
			'}';
	}
}
