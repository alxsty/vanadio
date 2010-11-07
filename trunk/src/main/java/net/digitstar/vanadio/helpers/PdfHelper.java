/*
 * Copyright 2010 DiGiTsTar.NeT (dTs)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package net.digitstar.vanadio.helpers;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Image;
import net.digitstar.vanadio.styles.Alignment;
import net.digitstar.vanadio.styles.Styles;
import net.digitstar.vanadio.styles.CellStyle;
import net.digitstar.vanadio.styles.TableStyle;

import java.text.Format;
import java.util.Date;
import java.util.Arrays;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public final class PdfHelper
{
	public static String format(Object contenuto)
	{
		return format(contenuto, null);
	}

	public static String format(Object contenuto, Format fmt)
	{
		String testo = "";
		if(contenuto != null)
		{
			fmt = getFormat(fmt, contenuto.getClass());
			testo = (fmt != null) ? fmt.format(contenuto) : contenuto.toString();
		}
		return testo;
	}

	private static Format getFormat(Format fmt, Class<?> clazz)
	{
		if (fmt == null)
			if(Date.class.isAssignableFrom(clazz))
				fmt = Styles.Formats.DATA.getFormato();
			else if(Double.class.isAssignableFrom(clazz) || Float.class.isAssignableFrom(clazz))
				fmt = Styles.Formats.VIRGOLA.getFormato();
			else if(Number.class.isAssignableFrom(clazz))
				fmt = Styles.Formats.INTERO.getFormato();

		return fmt;
	}

	public static PdfPCell newCell(CellStyle style)
	{
		PdfPCell cell = new PdfPCell();
		if(style != null)
		{
			if(style.getNestedTable() != null)
			{
				cell = new PdfPCell(style.getNestedTable());
				style.setNestedTable(null);
			}
			else if(style.getImage() != null)
			{
				cell = new PdfPCell(style.getImage(), style.isFitImage());
				style.setImage(null);
			}
			else if(style.getText() != null)
			{
				cell = new PdfPCell(style.getText());
				style.setText((String) null);
			}

			cell.setColspan(style.getColspan());
			cell.setRowspan(style.getRowspan());

			cell.setMinimumHeight(style.getMinimumHeight());
			cell.setFixedHeight(style.getFixedHeight());

			cell.setNoWrap(style.isNoWrap());

			cell.setRotation(style.getRotation().getValue());

			style = Alignment.assign(style);

			cell.setHorizontalAlignment(style.getHorizAlign().getValue());
			cell.setVerticalAlignment(style.getVertAlign().getValue());

			cell.setUseVariableBorders(style.isUseVariableBorders());
			cell.setUseBorderPadding(style.isUseBorderPadding());

			if(!style.getBorderWidth().isAllSideEqual())
			{
				cell.setBorderWidthBottom(style.getBorderWidth().getBottom());
				cell.setBorderWidthLeft(style.getBorderWidth().getLeft());
				cell.setBorderWidthRight(style.getBorderWidth().getRight());
				cell.setBorderWidthTop(style.getBorderWidth().getTop());
			} else
			{
				cell.setBorderWidth(style.getBorderWidth().getValue());
			}

			cell.setPaddingBottom(style.getPadding().getBottom());
			cell.setPaddingLeft(style.getPadding().getLeft());
			cell.setPaddingRight(style.getPadding().getRight());
			cell.setPaddingTop(style.getPadding().getTop());

			cell.setBorderColorBottom(style.getBorderColor().getBottom());
			cell.setBorderColorLeft(style.getBorderColor().getLeft());
			cell.setBorderColorRight(style.getBorderColor().getRight());
			cell.setBorderColorTop(style.getBorderColor().getTop());

			cell.setBorder(style.getBorder().getValue());

			cell.setBackgroundColor(style.getBackgroundColor());
			if(style.getGreyFill() >= 0)
			{
				cell.setGrayFill(style.getGreyFill());
			}
		}
		return cell;
	}

	public static PdfPCell newCell(Object contenuto, CellStyle style)
	{
		if(contenuto != null && style != null)
		{
			if(contenuto instanceof PdfPTable)
			{
				PdfPTable table = (PdfPTable) contenuto;
				style.setNestedTable(table);
			} else if(contenuto instanceof Image)
			{
				Image image = (Image) contenuto;
				style.setImage(image);
			} else
			{
				String testo = format(contenuto,style.getFormat());
				if(style.getHorizAlign() == CellStyle.Align.UNDEFINED)
				{
					if(contenuto instanceof Number)
					{
						style.setHorizAlign(CellStyle.Align.RIGHT);
					} else if(contenuto instanceof Date)
					{
						style.setHorizAlign(CellStyle.Align.CENTER);
					} else
					{
						style.setHorizAlign(CellStyle.Align.LEFT);
					}
				}
				style.setText(testo);
			}
		}

		return newCell(style);
	}


	public static PdfPTable newTable(TableStyle style)
	{
		PdfPTable t;
		if(style.getColumnWidths() == null)
		{
			t = new PdfPTable(style.getColumnNumber());
		} else
		{
			float[] w = style.getColumnWidths();
			if(style.getColumnWidths().length < style.getColumnNumber())
			{
				w = new float[style.getColumnNumber()];
				System.arraycopy(style.getColumnWidths(), 0, w, 0, style.getColumnWidths().length);
				Arrays.fill(w, style.getColumnWidths().length, w.length, style.getColumnWidths()[style.getColumnWidths().length - 1]);
			}

			t = new PdfPTable(w);
		}
		t.setWidthPercentage(style.getWidthPct());
		t.setSpacingBefore(style.getSpacingBefore());
		t.setSpacingAfter(style.getSpacingAfter());

		return t;
	}

}
