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

package net.digitstar.vanadio.enums;

import net.digitstar.vanadio.enums.core.LocalizableEnum;

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
public class Formats extends LocalizableEnum<Format> {

    public static final Formats NUMBER = new Formats(-1, false)
                                            .addLocalization(Locale.ITALIAN,-1,false);
    public static final Formats INTEGER = new Formats(0, true)
                                            .addLocalization(Locale.ITALIAN,0,true);
    public static final Formats FRACTIONAL = new Formats( 2, true)
                                            .addLocalization(Locale.ITALIAN,2,true);
    public static final Formats DATE = new Formats("MM/dd/yyyy")
                                            .addLocalization(Locale.ITALIAN,"dd/MM/yyyy");
    public static final Formats DATEEXTENDED = new Formats( "MMM d yyyy")
                                            .addLocalization(Locale.ITALIAN,"d MMM yyyy");

    public static final Formats YEARDATE = new Formats("yyyy");
    public static final Formats YEARDATE2 = new Formats("yy");
    public static final Formats DAYDATE = new Formats("d");
    public static final Formats DAYDATE2 = new Formats("dd");
    public static final Formats MONTHDATE = new Formats("M");
    public static final Formats MONTHDATE2 = new Formats("MM");
    public static final Formats MONTHDATE3 = new Formats("MMM")
                                            .addLocalization(Locale.ITALIAN,"MMM");
    public static final Formats MONTHDATEFULL = new Formats("MMMM")
                                            .addLocalization(Locale.ITALIAN,"MMMM");
    public static final Formats WEEKDATE3 = new Formats("EEE")
                                             .addLocalization(Locale.ITALIAN,"EEE");
    public static final Formats WEEKDATEFULL = new Formats("EEEE")
                                            .addLocalization(Locale.ITALIAN,"EEEE");

    public static final Formats DATETIME = new Formats("MM/dd/yyyy HH:mm:ss")
                                            .addLocalization(Locale.ITALIAN,"dd/MM/yyyy HH:mm:ss");

    public static final Formats TIME = new Formats("HH:mm:ss");

    public static final Formats HOUR = new Formats("H");
    public static final Formats HOUR2 = new Formats("HH");
    public static final Formats MINUTE = new Formats("m");
    public static final Formats MINUTE2 = new Formats("mm");
    public static final Formats SECOND = new Formats("s");
    public static final Formats SECOND2 = new Formats("ss");
    public static final Formats HOURMINUTES = new Formats("HH:mm");

    public static final Formats DATETITLE= new Formats("{0} - {1}",false);



    Formats()
    {
        super(Format.class);
    }

    protected Formats(Locale locale,Format format)
     {
         this();
         addLocalization(locale,format);
     }
    protected Formats(Format format)
    {
        this(null,format);
    }

    protected Formats(Locale locale, String format, boolean isDate)
    {
        this();
        addLocalization(locale,format,isDate);
    }
    protected Formats(String format, boolean isDate)
    {
        this(null,format,isDate);
    }

    protected Formats(Locale locale, String format)
    {
        this(locale,format,true);
    }

    protected Formats(String format)
    {
        this(format,true);
    }

    protected Formats(Locale locale, int numDecimal, boolean groupByo1000)
    {
        this();
        addLocalization(locale,numDecimal,groupByo1000);

    }

    protected Formats(int numDecimal, boolean groupByo1000)
    {
        this(null,numDecimal,groupByo1000);

    }

    protected final Formats addLocalization(Locale locale,String format, boolean isDate)
    {
       if (!isDate)
          addLocalization(locale,new MessageFormat(format));
        else
           addLocalization(locale,getFormatDate(locale, format));

        return this;
    }

    protected final Formats addLocalization(Locale locale, String format)
    {
        return addLocalization(locale,format,true);
    }

    protected final Formats addLocalization(Locale locale, int numDecimal, boolean groupByo1000)
    {
        addLocalization(locale,getFormatNumber(locale, numDecimal, numDecimal, groupByo1000));
        return this;
    }
    public final Format getFormat(Locale locale)
    {
        return getValue(locale);
    }
    public final Format getFormat()
    {
        return getValue(null);
    }


    public final String format(Locale locale, Object... arguments)
    {
        String result = "";
        if(arguments != null)
        {
            Format format = getFormat(locale);
            if(!(format instanceof MessageFormat))
            {
                if(arguments.length > 0)
                {
                    result = format.format(arguments[0]);
                }
            }
            else
            {
                result = format.format(arguments);
            }
        }

        return result;
    }
    public final String format(Object... arguments)
    {
        return format(null,arguments);
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
        return getFormatNumber(null, minDec, maxDec, group1000);
    }

    public static NumberFormat getFormatNumber(Locale locale, int minDec, int maxDec, boolean group1000)
    {
        NumberFormat nf = getFormatNumber(locale, null);
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

    private static String getPattern(String pattern)
    {
        return pattern != null ? pattern : "";
    }
    public static NumberFormat getFormatNumber()
    {
        return getFormatNumber(null, null);
    }

    public static NumberFormat getFormatNumber(String format)
    {
        return getFormatNumber(null, format);
    }

    public static NumberFormat getFormatNumber(Locale locale, String format)
    {
        return new DecimalFormat(getPattern(format), DecimalFormatSymbols.getInstance(getLocale(locale)));
    }

    public static DateFormat getFormatDate()
    {
        return getFormatDate(null, null);
    }

    public static DateFormat getFormatDate(String format)
    {
        return getFormatDate(null, format);
    }

    public static DateFormat getFormatDate(Locale locale, String format)
    {
        return new SimpleDateFormat(getPattern(format), DateFormatSymbols.getInstance(getLocale(locale)));
    }
}
