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
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public abstract class FontType {
    private Font font;


    protected FontType(FontFamily fontFamily,
             FontCharEncoding characterEncoding,
             boolean embedded,
             float size,
             FontStyle style,
             BaseColor color)
    {

        this.font = FontType.getFont(fontFamily, characterEncoding, embedded, size, style, color);

    }

    public final Font getFont()
    {
        return font;
    }

    public final Font getFont(FontStyle style)
    {
        Font f = new Font(this.font);
        f.setStyle(style.getValue());
        return f;
    }

    public final Font getFont(float size)
    {
        Font f = new Font(this.font);
        f.setSize(size);
        return f;
    }

    public static Font getFont(FontFamily fontFamily,
                               FontCharEncoding characterEncoding,
                               boolean embedded,
                               float size,
                               FontStyle style,
                               BaseColor color)
    {
        return FontFactory.getFont(fontFamily.getName(),
            characterEncoding.getName(),
            embedded,
            size,
            style.getValue(),
            color);
    }
}
