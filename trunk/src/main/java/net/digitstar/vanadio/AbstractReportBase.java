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

import com.itextpdf.text.Document;
import net.digitstar.vanadio.enums.core.LocalizableEnum;
import net.digitstar.vanadio.styles.Rect;

import java.util.Locale;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public abstract class AbstractReportBase
	implements ReportBase
{
    private ReportOptions reportOptions = new ReportOptions();

	/**
	 * To override if needed
     *
	 * @param reportOptions report options
	 * @return opzioniReport
	 */
	protected ReportOptions customizeReportOptions(ReportOptions reportOptions)
	{
		return reportOptions;
	}

    /**
     * To override if needed
     *
     * @param localization locale
     * @return Locale
     */
    protected Locale customizeLocale(Locale localization)
    {
        return localization;
    }

    protected Rect<Float> customizeMargins(Document document)
    {
        return new Rect<Float>(document.topMargin(),document.topMargin(),document.rightMargin(),document.bottomMargin())
        {
            @Override protected Float zero()
            {
                return 0.0f;
            }
        };
    }

	/**
	 *
     * @param reportOptions report options
	 */
	public final void setReportOptions(ReportOptions reportOptions)
	{
		if (reportOptions != null)
		{
			this.reportOptions = customizeReportOptions(reportOptions);
		}
	}

    /**
     *
     * @param localization locale
     */
    protected final void initLocale(Locale localization)
    {
        LocalizableEnum.setLocaleDefault(customizeLocale(localization));
    }
	/**
	 *
	 * @return opzioniReport
	 */
	public final ReportOptions getReportOptions()
	{
		return this.reportOptions;
	}

}
