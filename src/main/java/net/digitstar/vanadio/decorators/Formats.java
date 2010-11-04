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

package net.digitstar.vanadio.decorators;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Author: alx
 * Date: 3-nov-2010
 *
 * Vanadio a useful pdf report generator code driven
 */
public abstract class Formats {


    private Format format;

    protected Formats(Format format) 
    {
        this.format = format;
    }

    protected Formats(String format)
    {
        this.format = new MessageFormat(format);
    }

    protected Formats(Locale locale, int numDecimali, boolean raggruppo1000)
    {
        this.format = getFormatNumber(locale, numDecimali, numDecimali, raggruppo1000);

    }

    protected Formats(Locale locale, String format)
    {
        this.format = getFormatDate(locale, format);
    }

    public final Format getFormat()
    {
        return format;
    }


    public final String format(Object... arguments)
    {
        String result = "";
        if(arguments != null)
        {
            if(!(this.format instanceof MessageFormat))
            {
                if(arguments.length > 0)
                {
                    result = this.format.format(arguments[0]);
                }
            }
            else
            {
                result = this.format.format(arguments);
            }
        }

        return result;
    }


    public static NumberFormat getFormatNumber(int numDec)
    {
        return getFormatNumber(numDec, true);
    }

    public static NumberFormat getFormatNumber(int numDec, boolean group1000)
    {
        return getFormatNumber(numDec, numDec, group1000);
    }

    public static NumberFormat getFormatNumber(int minDec, int maxDec, boolean group1000)
    {
        return getFormatNumber(Locale.getDefault(), minDec, maxDec, group1000);
    }

    public static NumberFormat getFormatNumber(Locale locale, int minDec, int maxDec, boolean group1000)
    {
        NumberFormat nf = getFormatNumber(locale, "");
        nf.setGroupingUsed(group1000);
        if(minDec >= 0)
        {
            nf.setMinimumFractionDigits(minDec);
        }
        if(maxDec >= 0)
        {
            nf.setMaximumFractionDigits(maxDec);
        }

        return nf;

    }

    public static NumberFormat getFormatNumber()
    {
        return getFormatNumber(Locale.getDefault(), "");
    }

    public static NumberFormat getFormatNumber(String format)
    {
        return getFormatNumber(Locale.getDefault(), format);
    }

    public static NumberFormat getFormatNumber(Locale locale, String format)
    {
        return new DecimalFormat(format, DecimalFormatSymbols.getInstance(locale));
    }

    public static DateFormat getFormatDate()
    {
        return getFormatDate(Locale.getDefault(), "");
    }

    public static DateFormat getFormatDate(String format)
    {
        return getFormatDate(Locale.getDefault(), format);
    }

    public static DateFormat getFormatDate(Locale locale, String format)
    {
        return new SimpleDateFormat(format, DateFormatSymbols.getInstance(locale));
    }
}
