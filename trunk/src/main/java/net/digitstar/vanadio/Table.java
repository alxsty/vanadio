package net.digitstar.vanadio;

import com.itextpdf.text.pdf.PdfPTable;

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
