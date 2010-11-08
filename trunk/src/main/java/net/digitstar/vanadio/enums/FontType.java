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
import com.itextpdf.text.pdf.BaseFont;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class FontType {


    public static final FontType NORMAL = new FontType(FontFamily.getDefault(),
                                                        FontCharEncoding.getDefault(),
                                                        BaseFont.EMBEDDED, 7.0f, FontStyle.UNDEFINED, null);
    public static final FontType HEADERFOOTER = new FontType(FontFamily.getDefault(),
                                                        FontCharEncoding.getDefault(),
                                                        BaseFont.EMBEDDED, 6.0f, FontStyle.UNDEFINED, null);
    public static final FontType HEAD = new FontType(FontFamily.getDefault(),
                                                        FontCharEncoding.getDefault(),
                                                        BaseFont.EMBEDDED, 8.0f, FontStyle.BOLD, null);
    public static final FontType TOTAL = new FontType(FontFamily.getDefault(),
                                                        FontCharEncoding.getDefault(),
                                                        BaseFont.EMBEDDED, 7.0f, FontStyle.BOLD, null);
    public static final FontType TITLE = new FontType(FontFamily.getDefault(),
                                                          FontCharEncoding.getDefault(),
                                                          BaseFont.EMBEDDED, 11.0f, FontStyle.BOLD, null);
    public static final FontType TITLE9 = new FontType(FontFamily.getDefault(),
                                                          FontCharEncoding.getDefault(),
                                                          BaseFont.EMBEDDED, 9.0f, FontStyle.UNDEFINED, null);
    public static final FontType TITLE12 = new FontType(FontFamily.getDefault(),
                                                          FontCharEncoding.getDefault(),
                                                          BaseFont.EMBEDDED, 12.0f, FontStyle.BOLD, null);
    public static final FontType TITLE16 = new FontType(FontFamily.getDefault(),
                                                          FontCharEncoding.getDefault(),
                                                          BaseFont.EMBEDDED, 16.0f, FontStyle.ITALIC, null);
    public static final FontType TITLE20 = new FontType(FontFamily.getDefault(),
                                                          FontCharEncoding.getDefault(),
                                                          BaseFont.EMBEDDED, 20.0f, FontStyle.BOLD, null);

    private Font font;

    FontType()
    {
        this.font = null;
    }
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
        return new Font (this.font);
    }

    public final Font getFont(FontStyle style)
    {
        Font f = getFont();
        f.setStyle(style.getValue());
        return f;
    }

    public final Font getFont(float size)
    {
        Font f = getFont();
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
