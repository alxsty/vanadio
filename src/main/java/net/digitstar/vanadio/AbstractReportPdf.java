/*
 * Copyright 2010 DiGiTsTar.NeT (dTs)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package net.digitstar.vanadio;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import net.digitstar.vanadio.enums.FontType;
import net.digitstar.vanadio.enums.Formats;
import net.digitstar.vanadio.enums.Labels;

import net.digitstar.vanadio.styles.CellStyle;
import net.digitstar.vanadio.styles.TableStyle;

import net.digitstar.vanadio.tables.Group;
import net.digitstar.vanadio.tables.Table;
import net.digitstar.vanadio.tables.TableMap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.text.Format;

import java.util.Date;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public abstract class AbstractReportPdf<E>
	extends AbstractReportBase implements PdfPageEvent
{


	protected static final String TABLE_TITLE = "_title_";

	public void onOpenDocument(PdfWriter writer, Document document)
	{
	}

	public void onCloseDocument(PdfWriter writer, Document document)
	{

	}

	public void onStartPage(PdfWriter writer, Document document)
	{
	}

	public void onEndPage(PdfWriter writer, Document document)
	{
	}


	public void onParagraph(PdfWriter writer, Document document, float paragraphPosition)
	{
	}

	public void onParagraphEnd(PdfWriter writer, Document document, float paragraphPosition)
	{
	}

	public void onChapter(PdfWriter writer, Document document, float paragraphPosition, Paragraph title)
	{
	}

	public void onChapterEnd(PdfWriter writer, Document document, float paragraphPosition)
	{
	}

	public void onSection(PdfWriter writer, Document document, float paragraphPosition, int depth, Paragraph title)
	{
	}

	public void onSectionEnd(PdfWriter writer, Document document, float paragraphPosition)
	{
	}

	public void onGenericTag(PdfWriter writer, Document document, Rectangle rect, String text)
	{
	}


	private Map<String, Group> groups = new LinkedHashMap<String, Group>();
    private Map<String, Group> getGroups() {
        return groups;
    }

    private Class<E> dtoClass = null;
    private Class<E> getDtoClass() {
        return dtoClass;
    }
    private  void initDtoClass(Class<E> dtoClass) {
        this.dtoClass = dtoClass;
    }

    private TableMap tables = new TableMap();
    private TableMap getTables() {
        return tables;
    }

    public AbstractReportPdf()
    {
        this(null);
    }
    public AbstractReportPdf(Class<E> dtoClass)
	{
		this(dtoClass, null);
	}

	public AbstractReportPdf(Class<E> dtoClass, ReportOptions reportOptions)
	{

        setReportOptions(reportOptions);

        initLocale(getReportOptions().getLocalization());

		initDtoClass(dtoClass);
	}

    private Document initDocument(OutputStream out)
        throws Exception
    {
        FontFactory.registerDirectories();
        Document document = new Document();
        PdfWriter.getInstance(document, out).setPageEvent(this);
        openDocument(document);
        return document;
    }

    private void openDocument(Document document)
	{
		if(getReportOptions().getPageType() != ReportOptions.PageType.TYPE_AUTO)
		{
			if(getReportOptions().getPageType() == ReportOptions.PageType.TYPE_A4)
			{
				document.setPageSize(getReportOptions().getPageOrientation() == ReportOptions.PageOrientation.PAGE_VERTICAL ? PageSize.A4 : PageSize.A4.rotate());
			}
			else
			{
				document.setPageSize(getReportOptions().getPageOrientation() == ReportOptions.PageOrientation.PAGE_VERTICAL ? PageSize.A3 : PageSize.A3.rotate());
			}
		}
		document.open();
	}

	private void closeDocument(Document document, ByteArrayOutputStream baos, OutputStream out)
	{
		if(document != null)
		{
			document.close();
            PdfStamper writer = null;
            try
            {
                PdfReader reader = new PdfReader(baos.toByteArray());
                writer = new PdfStamper(reader, out);

                afterCloseDocument(document,reader,writer);
            }
            catch (IOException e) { /**/ }
            catch (DocumentException e) { /**/ }
            finally
            {
                if (writer != null)
                    try { writer.close(); } catch (DocumentException e) {/**/} catch (IOException e) {/**/}
            }
        }
	}

    protected void afterCloseDocument(Document document,PdfReader reader, PdfStamper writer)
    {

        int totalPages = reader.getNumberOfPages();
        for (int pag = 1; pag <= totalPages; pag++ )
        {
            writeHeaderFooter(document,reader,writer,pag,totalPages, getReportOptions());
        }
    }

    protected void writeHeaderFooter(Document document,PdfReader reader, PdfStamper writer, int pag, int totalPages, ReportOptions reportOptions)
    {
        if (reportOptions.isShowHeader())
        {
            if (pag != 1 || reportOptions.isShowHeaderOnFirstPage())
            {
			    PdfPTable header = createHeader(document,pag,totalPages,reportOptions);
				header.writeSelectedRows(0,-1,document.left(),document.top()+header.getTotalHeight(),writer.getOverContent(pag));
            }
        }
        if (reportOptions.isShowFooter())
        {
            if (pag != 1 || reportOptions.isShowFooterOnFirstPage())
            {
				PdfPTable footer = createFooter(document,pag,totalPages,reportOptions);
				footer.writeSelectedRows(0,-1,document.left(),document.bottom()-footer.getTotalHeight(),writer.getOverContent(pag));
            }
        }
    }


    protected void setReportTitle(Document document, String title, int aligment, Font font)
	{

		TableStyle style = new TableStyle();
		style.setSpacingBefore(25f).setWidthPct(TableStyle.FULL_WIDTH);

		if (getTable(TABLE_TITLE) == null)
			addTable(TABLE_TITLE, style);

		addTable(TABLE_TITLE,title,new CellStyle()
												.setHorizAlign(CellStyle.Align.setValue(aligment))
												.setBorder(CellStyle.Border.NONE)
												.setCellFont(font)
																				);
		tableCompleted(TABLE_TITLE);
	}

	protected final PdfPTable addTable(String tableName, TableStyle style)
	{
		return addTable(tableName,style,0,(float[])null);
	}


	protected final PdfPTable addTable(String tableName, TableStyle style, int colnum, float... widths)
	{
		if(style != null)
		{
			if(colnum > 0)
			{
				style.setColumnNumber(colnum);
			}

			if(widths != null)
			{
				style.setColumnWidths(widths);
			}

		}
		return getTables().createTable(tableName, style);
	}


	protected final PdfPCell addTable(String tableName, Object content, CellStyle style)
	{
		return getTables().addCell(tableName, content, style);
	}

	protected final Table getTable(String tableName)
	{
		return getTables().getTable(tableName);
	}

    protected final void tableCompleted(String tableName)
    {
        Table t = getTable(tableName);
        if(t != null)
        {
            t.setCompleted();
        }
    }

	protected final AbstractReportPdf addGroup(String field)
	{
		return addGroup(field, null);
	}

	protected final AbstractReportPdf addGroup(String field, Object initialValue)
	{
		return addGroup(field,null,initialValue,null);
	}

	protected final AbstractReportPdf addGroup(String field, String field2, Object initialValue, Object initialDescription)
	{
		getGroups().put(field, new Group(field, field2,initialValue,initialDescription));
		return this;
	}

	protected final Group getGroup(String field)
	{
		return getGroups().get(field);
	}

	protected final boolean isGroupValueChanged(String field)
	{
		Group grp = getGroup(field);
		return (grp != null) && grp.isValueChanged();
	}

	protected final Object getGroupCurrentValue(String field)
	{
		Group grp = getGroup(field);
		return (grp != null) ? grp.getCurrentValue() : null;
	}

	protected final Object getGroupOldValue(String field)
	{
		Group grp = getGroup(field);
		return (grp != null) ? grp.getOldValue() : null;
	}

	protected final Object getGroupCurrentDescription(String field)
	{
		Group grp = getGroup(field);
		return (grp != null) ? grp.getCurrentDescription() : null;
	}

	protected final Object getGroupOldDescription(String field)
	{
		Group grp = getGroup(field);
		return (grp != null) ? grp.getOldDescription() : null;
	}


	public boolean execute(Map<String, String[]> parameters, OutputStream out)
		throws Exception
	{
		boolean rc = false;
		Document document = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try
		{
			document = initDocument(baos);
			if(document != null)
			{
				rc = fillReport(document, parameters, baos);
			}
		}
		finally
		{
			closeDocument(document, baos, out);
		}
		return rc;
	}

	protected boolean fillReport(Document document, Map<String, String[]> parameters, OutputStream out)
		throws Exception
	{
		boolean ok;
		int count = -1;
		E dto = null;

		if(getDtoClass() != null)
		{
			dto = getDtoClass().newInstance();
        }

		//Viene chiamata prima della query, l'dto passato non contiene nulla
		ok = beforeProcessRow(getReportOptions(), document, dto, parameters, out);

		if(ok)
		{
            Collection<E> source = retrieveData(getReportOptions(), parameters, dto);

			List<E> list = source != null ? new ArrayList<E>(source) : new ArrayList<E>();

			// Chiamato dopo aver eseguito la query
			//il parametro list rappresenta la lista degli dto recuperati
			preProcessData(getReportOptions(), document, list, parameters, out);

			if(!list.isEmpty())
			{
				for(E item : list)
				{
					//valuta l'eventuale rottura dei gruppi impostati
					processGroups(document, item, parameters, out);

					//chiamata ad ogni ciclo di lettura
					//l'dto rappresenta la riga corrente
					ok = processRow(getReportOptions(), document, item, parameters, out);

					if(!ok)
					{
						break;
					}
				}
			}
			else
			{
				ok = processRow(getReportOptions(), document, null, parameters, out);
			}
		}

		if(ok)
		{
			//chiamato al termine del ciclo di lettura
			// il parametro count rappresenta il numero di righe processate
			ok = afterProcessRow(getReportOptions(), document, count, parameters, out);
		}

		if(ok)
		{
			ok = addTablesToDocument(document, getTables());
		}
		return ok;
	}

    private boolean addTablesToDocument(Document document, TableMap tables)
		throws Exception
	{
		boolean ok = false;
		if(document != null && tables != null)
		{
			for(Table t : tables)
			{
				if(t.isCompleted() && t.getPdfTable() != null)
				{
					if (t.getStyle().isPageBreakBefore())
					{
						document.newPage();
					}


					document.add(t.getPdfTable());

					if (t.getStyle().isPageBreakAfter())
					{
						document.newPage();
					}
				}
			}
			ok = tables.isEmpty();
		}
		return ok;
	}

	private void processGroups(Document document, E item, Map<String, String[]> parameters, OutputStream out)
		throws Exception
	{
		for(Group grp : groups.values())
		{
			grp.evaluate(item);
		}
	}

    protected PdfPTable createHeader(Document document,int  page, int pageTotal, ReportOptions reportOptions)
    {
       PdfPTable  header = new PdfPTable(3);
       header.setTotalWidth(document.right()-document.left());
       PdfPCell def = header.getDefaultCell();
       String left = "";
       String center = "";
       String right = "";

       if (reportOptions.isShowPageNumberIfOnePage() || (!reportOptions.isShowPageNumberIfOnePage() &&  pageTotal > 1))
       {
           right = reportOptions.isShowPageTotal() ?
                   Labels.PAGE_TOTAL.getLabelFormatted(page,pageTotal) :
                   Labels.PAGE.getLabelFormatted(page);
       }

	    def.setFixedHeight(computeHeight(FontType.HEADERFOOTER.getFont()));

       def.setBorder(CellStyle.Border.NONE.getValue());
       if (reportOptions.isUseHrRuler())
           def.setBorder(CellStyle.Border.BOTTOM.getValue());

       def.setHorizontalAlignment(CellStyle.Align.LEFT.getValue());
       header.addCell(new Phrase(left,FontType.HEADERFOOTER.getFont()));
       def.setHorizontalAlignment(CellStyle.Align.CENTER.getValue());
       header.addCell(new Phrase(center,FontType.HEADERFOOTER.getFont()));
       def.setHorizontalAlignment(CellStyle.Align.RIGHT.getValue());
       header.addCell(new Phrase(right,FontType.HEADERFOOTER.getFont()));
       return header;
    }

	protected PdfPTable createFooter(Document document, int page, int pageTotal, ReportOptions reportOptions)
    {
       PdfPTable  footer = new PdfPTable(3);
	   footer.setTotalWidth(document.right()-document.left());
       PdfPCell def = footer.getDefaultCell();
       String left = "";
       String center = "";
       String right = "";

       def.setFixedHeight(computeHeight(FontType.HEADERFOOTER.getFont()));
       def.setBorder(CellStyle.Border.NONE.getValue());
       if (reportOptions.isUseHrRuler())
           def.setBorder(CellStyle.Border.TOP.getValue());

        if (reportOptions.isShowPrintDate())
            right = Labels.PRINTED.getLabelFormatted(getDateTimeFormat().format(new Date()));

	    def.setHorizontalAlignment(CellStyle.Align.LEFT.getValue());
	    footer.addCell(new Phrase(left, FontType.HEADERFOOTER.getFont()));
	    def.setHorizontalAlignment(CellStyle.Align.CENTER.getValue());
	    footer.addCell(new Phrase(center,FontType.HEADERFOOTER.getFont()));
	    def.setHorizontalAlignment(CellStyle.Align.RIGHT.getValue());
	    footer.addCell(new Phrase(right,FontType.HEADERFOOTER.getFont()));
       return footer;
    }

	private float computeHeight(Font f)
	{

		return f.getSize() + 4.0f;
	}

    protected abstract Collection<E> retrieveData(ReportOptions reportOptions, Map<String, String[]> parameters, E eb)
        throws Exception;
    protected abstract void preProcessData(ReportOptions reportOptions, Document document, List<E> list, Map<String, String[]> parameters, OutputStream out)
        throws Exception;
    protected abstract boolean beforeProcessRow(ReportOptions reportOptions, Document document, E eb, Map<String, String[]> parameters, OutputStream out)
		throws Exception;

	protected abstract boolean afterProcessRow(ReportOptions reportOptions, Document document, int count, Map<String, String[]> parameters, OutputStream out)
		throws Exception;

	protected abstract boolean processRow(ReportOptions reportOptions, Document document, E item, Map<String, String[]> parameters, OutputStream out)
		throws Exception;


	protected final Font getFont()
	{
		return FontType.NORMAL.getFont();
	}

	protected final Font getFontTitle()
	{
		return FontType.TITLE.getFont();
	}

	protected final Font getFontHead()
	{
		return FontType.HEAD.getFont();
	}

	protected final Format getGenNumberFormat()
	{
        return Formats.NUMBER.getFormat();
	}

	protected final Format getIntNunberFormat()
	{
        return Formats.INTEGER.getFormat();
	}

	protected final Format getFractNunberFormat()
	{
        return Formats.FRACTIONAL.getFormat();
	}

	protected final Format getDateFormat()
	{
        return Formats.DATE.getFormat();
	}

	protected final Format getHourFormat()
	{
        return Formats.HOUR2.getFormat();
	}

	protected final Format getHourMinutesFormat()
	{
        return Formats.HOURMINUTES.getFormat();
	}

	protected final Format getDateTimeFormat()
	{
		return Formats.DATETIME.getFormat();
	}

}


