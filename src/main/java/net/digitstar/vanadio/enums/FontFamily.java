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

import com.itextpdf.text.pdf.BaseFont;

/**
 * Author: alx
 * Date: 3-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class FontFamily
{

    public static final FontFamily UNDEFINED = new FontFamily(null);
    public static final FontFamily COURIER = new FontFamily(BaseFont.COURIER);
    public static final FontFamily HELVETICA = new FontFamily(BaseFont.HELVETICA);
    public static final FontFamily TIMES_ROMAN = new FontFamily(BaseFont.TIMES_ROMAN);
    public static final FontFamily SYMBOL = new FontFamily(BaseFont.SYMBOL);
    public static final FontFamily ZAPFDINGBATS = new FontFamily(BaseFont.ZAPFDINGBATS);
    public static final FontFamily ARIAL = new FontFamily("Arial");

    private static FontFamily _default = ARIAL;

    private String name;

    FontFamily()
    {
        this(null);
    }
    protected FontFamily(String name)
    {
        this.name = name;
    }



    public final String getName()
    {

        return name;
    }

    public static FontFamily setDefault(FontFamily _default)
    {
        FontFamily._default = _default;
        return FontFamily._default;
    }

    public static FontFamily getDefault()
    {
        return _default;
    }
}

