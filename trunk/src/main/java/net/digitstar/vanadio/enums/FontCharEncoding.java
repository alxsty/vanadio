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

import com.itextpdf.text.pdf.BaseFont;

/**
 * Author: alx
 * Date: 3-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class FontCharEncoding
{

    public static final FontCharEncoding CP1250 = new FontCharEncoding("Cp1250");            // europa centrale(null);
    public static final FontCharEncoding CP1252 = new FontCharEncoding("Cp1252");            // europa occidentale
    public static final FontCharEncoding UTF8 = new FontCharEncoding(BaseFont.IDENTITY_H);  // unicode

    private static FontCharEncoding _default = UTF8;

    private String name;

    FontCharEncoding()
    {
        this(null);
    }
    protected FontCharEncoding(String name)
    {
        this.name = name;
    }


    public final String getName()
    {

        return name;
    }

    public static FontCharEncoding setDefault(FontCharEncoding _default )
    {
        FontCharEncoding._default = _default;
        return FontCharEncoding._default;
    }
    public static FontCharEncoding getDefault()
    {
        return _default;
    }
}

