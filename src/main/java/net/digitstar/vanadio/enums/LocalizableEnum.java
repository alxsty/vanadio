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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
abstract class LocalizableEnum<E>
{
    private E empty;
    private final Map<Locale,E> values = new HashMap<Locale,E>();

    protected LocalizableEnum(Class<E> clazz)
    {
        try {empty = clazz.newInstance();} catch (Exception e) { /*do nothing*/ }
    }

    protected final E  addLocalization(E value)
    {
        return addLocalization(null,value);
    }
    protected final E  addLocalization(Locale locale, E value)
    {
        if (value != null)
        {
            values.put(getLocale(locale),value);
        }
        return value;
    }

    protected E getValue(Locale locale)
    {
        E e = values.get(getLocale(locale));
        if (e == null) e = values.get(getLocale(null));
        return e != null  ? e : empty;
    }

    static Locale getLocale(Locale locale)
    {
        return locale == null ? Locale.getDefault() : locale;
    }

}

