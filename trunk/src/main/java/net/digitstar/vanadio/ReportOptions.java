package net.digitstar.vanadio;

import com.itextpdf.text.BaseColor;


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
public class ReportOptions
{

	enum PageType
	{
		TYPE_AUTO,
		TYPE_A4,
		TYPE_A3
	}

	enum PageOrientation
	{
		PAGE_VERTICAL,
		PAGE_HORIZONTAL
	}

	private boolean showHeader;                //  visualizza testata
	private boolean showFooter;                //  visualizza pie di pagina
	private boolean showHeaderOnFirstPage;     //  mostra testata sulla prima  pag.
	private boolean showFooterOnFirstPage;     //  mostra pie di pag. sulla prima pag.
    private boolean showPageNumber;            //  visualizza num. pagina
    private boolean showPageTotal;             //  visualizza num paginaa X di Y
    private boolean showPageNumberIfOnePage;   //  visualizza num paginaa anche se solo una pag.
	private boolean showPrintDate;             //  mostra data di stampa
	private boolean useHrRuler;                //  visualizza riga  orizz. su testata / pie pag.
	private boolean alternateRow;              //  visualizza righe tabelle a colori alternati
	private BaseColor oddBackColor;                //  colore righe pari
	private BaseColor evenBackColor;               //  colre righe dispari

	private PageType pageType;                 //  formato pag. (A4, A3, AUTO(
	private PageOrientation pageOrientation;   //  orienamento pagina (VERT., ORIZ)

	public ReportOptions()
	{
		setShowHeader(false)
			.setShowFooter(true)
			.setShowHeaderOnFirstPage(true)
			.setShowFooterOnFirstPage(true)
			.setShowPageNumber(false)
            .setShowPageTotal(false)
            .setShowPageNumberIfOnePage(true)
			.setShowPrintDate(true)
			.setUseHrRuler(false)
			.setPageType(PageType.TYPE_AUTO)
			.setPageOrientation(PageOrientation.PAGE_VERTICAL)
			.setAlternateRow(true)
			.setEvenBackColor(Styles.Colors.EVENROW.getColor())
			.setOddBackColor(Styles.Colors.ODDROW.getColor());
	}


	public boolean isShowHeader()
	{
		return showHeader;
	}

	public ReportOptions setShowHeader(boolean showHeader)
	{
		this.showHeader = showHeader;
		return this;
	}

	public boolean isShowFooter()
	{
		return showFooter;
	}

	public ReportOptions setShowFooter(boolean showFooter)
	{
		this.showFooter = showFooter;
		return this;
	}

	public boolean isShowHeaderOnFirstPage()
	{
		return showHeaderOnFirstPage;
	}

	public ReportOptions setShowHeaderOnFirstPage(boolean showHeaderOnFirstPage)
	{
		this.showHeaderOnFirstPage = showHeaderOnFirstPage;
		return this;
	}

	public boolean isShowFooterOnFirstPage()
	{
		return showFooterOnFirstPage;
	}

	public ReportOptions setShowFooterOnFirstPage(boolean showFooterOnFirstPage)
	{
		this.showFooterOnFirstPage = showFooterOnFirstPage;
		return this;

	}

	public boolean isShowPageNumber()
	{
		return showPageNumber;
	}

	public ReportOptions setShowPageNumber(boolean showPageNumber)
	{
		this.showPageNumber = showPageNumber;
		return this;
	}

    public boolean isShowPageTotal()
    {
        return showPageTotal;
    }

    public ReportOptions setShowPageTotal(boolean showPageTotal)
    {
        this.showPageTotal = showPageTotal;
        return this;
    }

    public boolean isShowPrintDate()
	{
		return showPrintDate;
	}

    public boolean isShowPageNumberIfOnePage()
    {
        return showPageNumberIfOnePage;
    }

    public ReportOptions setShowPageNumberIfOnePage(boolean showPageNumberIfOnePage)
    {
        this.showPageNumberIfOnePage = showPageNumberIfOnePage;
        return this;
    }

    public ReportOptions setShowPrintDate(boolean showPrintDate)
	{
		this.showPrintDate = showPrintDate;
		return this;
	}

	public boolean isUseHrRuler()
	{
		return useHrRuler;
	}

	public ReportOptions setUseHrRuler(boolean useHrRuler)
	{
		this.useHrRuler = useHrRuler;
		return this;
	}

	public PageType getPageType()
	{
		return pageType;
	}

	public ReportOptions setPageType(PageType pageType)
	{
		this.pageType = pageType;
		return this;
	}

	public PageOrientation getPageOrientation()
	{
		return pageOrientation;
	}

	public ReportOptions setPageOrientation(PageOrientation pageOrientation)
	{
		this.pageOrientation = pageOrientation;
		return this;
	}

	public boolean isAlternateRow()
	{
		return alternateRow;
	}

	public ReportOptions setAlternateRow(boolean alternateRow)
	{
		this.alternateRow = alternateRow;
		return this;
	}

	public BaseColor getOddBackColor()
	{
		return oddBackColor;
	}

	public ReportOptions setOddBackColor(BaseColor oddBackColor)
	{
		this.oddBackColor = oddBackColor;
		return this;
	}

	public BaseColor getEvenBackColor()
	{
		return evenBackColor;
	}

	public ReportOptions setEvenBackColor(BaseColor evenBackColor)
	{
		this.evenBackColor = evenBackColor;
		return this;
	}
}
