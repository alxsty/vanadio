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

package net.digitstar.vanadio;

import com.itextpdf.text.BaseColor;

import net.digitstar.vanadio.enums.Colors;

import java.util.Locale;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class ReportOptions
{
    /**
     * Page format
     */
	enum PageType
	{
		TYPE_AUTO,
		TYPE_A4,
		TYPE_A3
	}

    /**
     * Page orientation
     */
	enum PageOrientation
	{
        PAGE_AUTO,
        PAGE_VERTICAL,
		PAGE_HORIZONTAL
	}

	private boolean showHeader;                //  flag to display page header
	private boolean showFooter;                //  flag to display page footer
	private boolean showHeaderOnFirstPage;     //  flag to display page header on the 1st page
	private boolean showFooterOnFirstPage;     //  flag to display page footer on the 1st page
    private boolean showPageNumber;            //  flag to display page number
    private boolean showPageTotal;             //  flag to display page number X of Y
    private boolean showPageNumberIfOnePage;   //  flag to display page number even if 1 page only
	private boolean showPrintDate;             //  flag to display printing date
	private boolean useHrRuler;                //  flag to use an H rules as separator in header/footer

	private boolean alternateRow;              //  flag to display table rows in alternate colors
	private BaseColor oddBackColor;            //  color to use for odd table rows
	private BaseColor evenBackColor;           //  color to use for even table rows

	private PageType pageType;                 //  page format (A4, A3, AUTO)
	private PageOrientation pageOrientation;   //  page orientation (VERT., ORIZ., AUTO)

    private Locale localization;               //  Locale for display formats and text labels

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
			.setPageOrientation(PageOrientation.PAGE_AUTO)
			.setAlternateRow(true)
			.setEvenBackColor(Colors.EVENROW.getColor())
			.setOddBackColor(Colors.ODDROW.getColor())
            .setLocalization(Locale.getDefault());
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

    public Locale getLocalization()
    {
        return localization;
    }

    public ReportOptions setLocalization(Locale localization)
    {
        this.localization = localization;
        return this;
    }
}
