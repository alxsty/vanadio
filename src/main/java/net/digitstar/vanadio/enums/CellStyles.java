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

package net.digitstar.vanadio.enums;

import com.itextpdf.text.BaseColor;
import net.digitstar.vanadio.styles.CellStyle;
import net.digitstar.vanadio.ReportOptions;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public abstract class CellStyles
{
    private CellStyle style;

    protected CellStyles(CellStyle style)
    {
        this.style = style;
    }

    public final CellStyle getStyle()
    {
        return new CellStyle(style);
    }

    public static CellStyle getRowStyle(ReportOptions reportOptions, int row)
    {
        CellStyle cell = getDefault().getStyle();
        if(reportOptions != null)
        {
            if(reportOptions.isAlternateRow() && row >= 0)
            {
                boolean isEven = (row % 2 == 1);
                BaseColor c = isEven ? reportOptions.getOddBackColor() : reportOptions.getEvenBackColor();
                cell.setBackgroundColor(c);
            }
        }

        return cell;
    }

    public static CellStyles getDefault()
    {
        throw new RuntimeException("You must redefine the getDefault() in your claas.");
    }

}
