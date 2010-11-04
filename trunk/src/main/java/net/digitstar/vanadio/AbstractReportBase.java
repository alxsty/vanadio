package net.digitstar.vanadio;

/**
 * <p>Title: AscotWeb Elezioni</p>
 * <p/>
 * <p>Description: Gestione consultazioni elettorali</p>
 * <p/>
 * <p>Copyright: Copyright (c) 2001-2009</p>
 * <p/>
 * <p>Company: Insiel S.p.A.</p>
 *
 * @author Tino Pratticò
 * @version 2009 rel. 2010
 */
public abstract class AbstractReportBase
	implements ReportBase
{

	/**
	 *
	 * @param reportOptions opzioni del report
	 * @return opzioniReport
	 */
	protected ReportOptions customizeReportOptions(ReportOptions reportOptions)
	{
		return reportOptions;
	}


	/**
	 *
     * @param reportOptions opzioni del report
	 */
	public void setReportOptions(ReportOptions reportOptions)
	{
		if (reportOptions != null)
		{
			this.reportOptions = customizeReportOptions(reportOptions);
		}
	}

	/**
	 *
	 * @return opzioniReport
	 */
	public ReportOptions getReportOptions()
	{
		return this.reportOptions;
	}

	private ReportOptions reportOptions = new ReportOptions();

}
