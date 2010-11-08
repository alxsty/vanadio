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

import net.digitstar.vanadio.enums.core.Label;
import net.digitstar.vanadio.enums.core.LocalizableEnum;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class Labels extends LocalizableEnum<Label> {

    public static final Labels PAGE = new Labels("Page {0}", "Pag. {0}")
                                          .addLocalization(Locale.ITALIAN,"Pagina {0}", "Pag. {0}");
    public static final Labels PAGE_TOTAL = new Labels("Pag. {0} of {1}", "Pag. {0}/{1}");
    public static final Labels PRINTED = new Labels("Printed on: {0}", null)
                                          .addLocalization(Locale.ITALIAN,"Stampato il: {0}", null);


    private static final String WORD_SEP = " ";
    private static final String EMPTY = "";

    Labels()
    {
        super(Label.class);
    }
    protected Labels(Locale locale,String label, String abbreviation)
    {
        this();
        addLocalization(locale,label,abbreviation);
    }

    protected Labels(String label, String abbreviation)
    {
        this(null,label,abbreviation);
    }

    protected Labels(Class<Label> clazz) {
        super(clazz);
    }

    protected final Labels addLocalization(Locale locale, String label, String abbreviation)
    {
        addLocalization(locale,new Label(label,abbreviation));
        return this;
    }

    public final String getLabel(Locale locale)
    {
        return normalize(getValue(locale).getLabel());
    }

    public final String getLabel()
    {
        return getLabel(null);
    }

    public final String getAbbreviation(Locale locale)
    {
        return ifNotValid(getValue(locale).getAbbreviation(),getValue(locale).getLabel());
    }
    public final String getAbbreviation()
    {
        return getAbbreviation(null);
    }

    public final String getLabelJoined(Locale locale, Object s)
    {
        return join(getLabel(locale), s);
    }

    public final String getLabelJoined(Object s)
    {
        return getLabelJoined(null,s);
    }

    public final String getAbbreviationJoined(Locale locale, Object s)
    {
        return join(getAbbreviation(locale), s);
    }
    public final String getAbbreviationJoined(Object s)
    {
        return getAbbreviationJoined(null,s);
    }

    public final String getLabelFormatted(Locale locale, Object... s)
    {
        return format(getLabel(locale), s);
    }
    public final String getLabelFormatted(Object... s)
    {
        return getLabelFormatted(null,s);
    }

    public final String getAbbreviationFormatted(Locale locale, Object... s)
    {
        return format(getAbbreviation(locale), s);
    }
    public final String getAbbreviationFormatted(Object... s)
    {
        return getAbbreviationFormatted(null,s);
    }

    private static String format(String label, Object...  s)
    {
            return MessageFormat.format(normalize(label),s);
    }

    private static String join(String s1, Object s2)
    {

        s1 = normalize(s1);
        String s = normalize(s2);
        return isValid(s) ? s1.concat(Labels.WORD_SEP).concat(s) : s1;

    }

    private static boolean isValid(String s)
    {
        return isValid((Object)s)&& s.trim().length() > 0;
    }

    private static boolean isValid(Object s)
    {
        return s != null;
    }

    private static String normalize(String s)
    {
        return Labels.isValid(s) ? s.trim() : Labels.EMPTY;
    }
    private static String normalize(Object o)
    {
        return isValid(o) ? normalize(o.toString()) : Labels.EMPTY;
    }

    private static String ifNotValid(String s, String def)
    {
        return isValid(s) ? normalize(s) : normalize(def);
    }

}
