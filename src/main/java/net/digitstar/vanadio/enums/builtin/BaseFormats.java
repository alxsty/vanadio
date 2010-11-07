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

package net.digitstar.vanadio.enums.builtin;

import net.digitstar.vanadio.enums.Formats;

import java.text.Format;
import java.util.Locale;

/**
 * public static final Author: alx
 * Date: 3-nov-2010
 *
 * Vanadio a useful pdf report generator code driven
 */
public class BaseFormats extends Formats {

    public static final Formats NUMBER = new BaseFormats(-1, false)
                                            .addLocalization(Locale.ITALIAN,-1,false);
    public static final Formats INTEGER = new BaseFormats(0, true)
                                            .addLocalization(Locale.ITALIAN,0,true);
    public static final Formats FRACTIONAL = new BaseFormats( 2, true)
                                            .addLocalization(Locale.ITALIAN,2,true);
    public static final Formats DATE = new BaseFormats("MM/dd/yyyy")
                                            .addLocalization(Locale.ITALIAN,"dd/MM/yyyy");
    public static final Formats DATEEXTENDED = new BaseFormats( "MMM d yyyy")
                                            .addLocalization(Locale.ITALIAN,"d MMM yyyy");

    public static final Formats YEARDATE = new BaseFormats("yyyy");
    public static final Formats YEARDATE2 = new BaseFormats("yy");
    public static final Formats DAYDATE = new BaseFormats("d");
    public static final Formats DAYDATE2 = new BaseFormats("dd");
    public static final Formats MONTHDATE = new BaseFormats("M");
    public static final Formats MONTHDATE2 = new BaseFormats("MM");
    public static final Formats MONTHDATE3 = new BaseFormats("MMM")
                                            .addLocalization(Locale.ITALIAN,"MMM");
    public static final Formats MONTHDATEFULL = new BaseFormats("MMMM")
                                            .addLocalization(Locale.ITALIAN,"MMMM");
    public static final Formats WEEKDATE3 = new BaseFormats("EEE")
                                             .addLocalization(Locale.ITALIAN,"EEE");
    public static final Formats WEEKDATEFULL = new BaseFormats("EEEE")
                                            .addLocalization(Locale.ITALIAN,"EEEE");

    public static final Formats DATETIME = new BaseFormats("MM/dd/yyyy HH:mm:ss")
                                            .addLocalization(Locale.ITALIAN,"dd/MM/yyyy HH:mm:ss");

    public static final Formats TIME = new BaseFormats("HH:mm:ss");

    public static final Formats HOUR = new BaseFormats("H");
    public static final Formats HOUR2 = new BaseFormats("HH");
    public static final Formats MINUTE = new BaseFormats("m");
    public static final Formats MINUTE2 = new BaseFormats("mm");
    public static final Formats SECOND = new BaseFormats("s");
    public static final Formats SECOND2 = new BaseFormats("ss");
    public static final Formats HOURMINUTES = new BaseFormats("HH:mm");

    public static final Formats DATETITLE= new BaseFormats("{0} - {1}",false);

    private BaseFormats(Format format) {
        super(format);
    }

    private BaseFormats(String format, boolean isDate) {
        super(format,isDate);
    }

    private BaseFormats(int numDecimali, boolean raggruppo1000) {
        super(numDecimali, raggruppo1000);
    }

    private BaseFormats(String format) {
        super(format);
    }
}
