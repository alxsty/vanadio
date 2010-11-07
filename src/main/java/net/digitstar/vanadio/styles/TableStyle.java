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

package net.digitstar.vanadio.styles;

import java.util.Arrays;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
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
