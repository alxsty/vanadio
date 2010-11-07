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
import com.itextpdf.text.pdf.PdfPCell;
import net.digitstar.vanadio.helpers.PdfHelper;
import net.digitstar.vanadio.styles.CellStyle;
import net.digitstar.vanadio.styles.TableStyle;
import net.digitstar.vanadio.tables.Table;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class TableMap   implements Iterator<Table>, Iterable<Table>
{
	public Iterator<Table> iterator()
	{
		return tables.values().iterator();

	}

	private Map<String, Table> tables = new LinkedHashMap<String, Table>();

	public Table add(Table table)
	{
		tables.put(table.getName(), table);
		return table;
	}

	public PdfPTable createTable(String tablename, TableStyle styles)
	{
		PdfPTable tabella = null;
		if(tablename != null)
		{
			tabella = add(new Table(tablename, PdfHelper.newTable(styles),styles)).getPdfTable();
		}

		return tabella;
	}

	public PdfPCell addCell(String tableName, Object content, CellStyle style)
	{
		PdfPCell cell = PdfHelper.newCell(content, style);

		if(cell != null)
		{
			Table t = tables.get(tableName);
			if(t != null)
			{
				PdfPTable pdfPTable = t.getPdfTable();
				if(pdfPTable != null)
					pdfPTable.addCell(cell);

				if (style.isAlternateColor())
				{
					t.addCell();
				}
			}
		}
		return cell;

	}

	public Table getTable(String tableName)
	{
		Table t = null;
		if(tableName != null)
		{
			t = tables.get(tableName);
		}

		return t;
	}

	public boolean hasNext()
	{
		return tables.values().iterator().hasNext();
	}

	public Table next()
	{
		return tables.values().iterator().next();
	}

	public void remove()
	{
		tables.values().iterator().remove();
	}

	public boolean isEmpty()
	{
		return tables.isEmpty();
	}


}
