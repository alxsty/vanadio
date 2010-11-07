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

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
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
