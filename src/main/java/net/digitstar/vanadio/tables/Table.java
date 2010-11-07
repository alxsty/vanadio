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

package net.digitstar.vanadio.tables;

import com.itextpdf.text.pdf.PdfPTable;
import net.digitstar.vanadio.styles.TableStyle;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class Table
{
	private String name;
	private PdfPTable pdfTable;
	private int columnNumber;
	private int cellCount;
	private int row;
	private boolean completed;
	private TableStyle style;

	public Table(String name, PdfPTable table)
	{
		this(name,table,null);
	}

	public Table(String name, PdfPTable table, TableStyle style)
	{
		if(name != null && table != null)
		{
			if (style  == null) style = new TableStyle();

			this.name = name;
			this.pdfTable = table;
			this.columnNumber = this.pdfTable.getNumberOfColumns();
			this.cellCount = 0;
			this.row = 0;
			this.completed = false;
			this.style = style;
		}
	}

	public void addCell()
	{
		this.cellCount++;
		computeRow();
	}

	private void computeRow()
	{
		this.row = this.cellCount / this.columnNumber ;
	}

	public int getRow()
	{
		return row;
	}

	public void setRow(int row)
	{
		this.row = row;
	}

	public String getName()
	{
		return name;
	}

	public boolean isCompleted()
	{
		return completed;
	}

	public void clearCompleted()
	{
		completed = false;
	}

	public void setCompleted()
	{
		completed = true;
	}


	public PdfPTable getPdfTable()
	{
		return pdfTable;
	}

	public TableStyle getStyle()
	{
		return style;
	}
}
