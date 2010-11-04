package net.digitstar.vanadio;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by IntelliJ IDEA.
 * User: 908190
 * Date: 1-lug-2009
 * Time: 10.31.47
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
