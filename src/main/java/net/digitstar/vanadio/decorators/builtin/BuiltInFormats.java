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

package net.digitstar.vanadio.decorators.builtin;

import net.digitstar.vanadio.decorators.Formats;

import java.text.Format;
import java.util.Locale;

/**
 * public static final Author: alx
 * Date: 3-nov-2010
 *
 * Vanadio a useful pdf report generator code driven
 */
public class BuiltInFormats extends Formats {

    public static final Formats NUMBER = new BuiltInFormats(Locale.getDefault(), -1, false);
    public static final Formats INTEGER = new BuiltInFormats(Locale.getDefault(), 0, true);
    public static final Formats FRACTIONAL = new BuiltInFormats(Locale.getDefault(), 2, true);
    public static final Formats DATE = new BuiltInFormats(Locale.getDefault(), "");
    public static final Formats YEARDATE = new BuiltInFormats(Locale.getDefault(), "yyyy");
    public static final Formats DAYDATE = new BuiltInFormats(Locale.getDefault(), "d");
    public static final Formats MONTHDATE = new BuiltInFormats(Locale.getDefault(), "M");
    public static final Formats DATETIME = new BuiltInFormats(Locale.getDefault(), "dd/MM/yyyy HH:mm:ss");
    public static final Formats DATEFULL = new BuiltInFormats(Locale.ITALIAN, "d MMMM yyyy");
    public static final Formats TIME = new BuiltInFormats(Locale.getDefault(), "HH:mm:ss");
    public static final Formats HOURMINUTES = new BuiltInFormats(Locale.getDefault(), "HH:mm");

    public static final Formats DATETITLE= new BuiltInFormats("{0} - {1}");

    private BuiltInFormats(Format format) {
        super(format);
    }

    private BuiltInFormats(String format) {
        super(format);
    }

    private BuiltInFormats(Locale locale, int numDecimali, boolean raggruppo1000) {
        super(locale, numDecimali, raggruppo1000);
    }

    private BuiltInFormats(Locale locale, String format) {
        super(locale, format);
    }
}
