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

package net.digitstar.vanadio.enums.builtin;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.BaseFont;
import net.digitstar.vanadio.enums.FontCharEncoding;
import net.digitstar.vanadio.enums.FontFamily;
import net.digitstar.vanadio.enums.FontStyle;
import net.digitstar.vanadio.enums.FontType;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class BaseFontType extends FontType{

    public static final FontType NORMAL = new BaseFontType(BaseFontFamily.getDefault(),
                                                        BaseFontCharEncoding.getDefault(),
                                                        BaseFont.EMBEDDED, 7.0f, BaseFontStyle.UNDEFINED, null);
    public static final FontType HEADERFOOTER = new BaseFontType(BaseFontFamily.getDefault(),
                                                        BaseFontCharEncoding.getDefault(),
                                                        BaseFont.EMBEDDED, 6.0f, BaseFontStyle.UNDEFINED, null);
    public static final FontType HEAD = new BaseFontType(BaseFontFamily.getDefault(),
                                                        BaseFontCharEncoding.getDefault(),
                                                        BaseFont.EMBEDDED, 8.0f, BaseFontStyle.BOLD, null);
    public static final FontType TOTAL = new BaseFontType(BaseFontFamily.getDefault(),
                                                        BaseFontCharEncoding.getDefault(),
                                                        BaseFont.EMBEDDED, 7.0f, BaseFontStyle.BOLD, null);
    public static final FontType TITLE = new BaseFontType(BaseFontFamily.getDefault(),
                                                          BaseFontCharEncoding.getDefault(),
                                                          BaseFont.EMBEDDED, 11.0f, BaseFontStyle.BOLD, null);
    public static final FontType TITLE9 = new BaseFontType(BaseFontFamily.getDefault(),
                                                          BaseFontCharEncoding.getDefault(),
                                                          BaseFont.EMBEDDED, 9.0f, BaseFontStyle.UNDEFINED, null);
    public static final FontType TITLE12 = new BaseFontType(BaseFontFamily.getDefault(),
                                                          BaseFontCharEncoding.getDefault(),
                                                          BaseFont.EMBEDDED, 12.0f, BaseFontStyle.BOLD, null);
    public static final FontType TITLE16 = new BaseFontType(BaseFontFamily.getDefault(),
                                                          BaseFontCharEncoding.getDefault(),
                                                          BaseFont.EMBEDDED, 16.0f, BaseFontStyle.ITALIC, null);
    public static final FontType TITLE20 = new BaseFontType(BaseFontFamily.getDefault(),
                                                          BaseFontCharEncoding.getDefault(),
                                                          BaseFont.EMBEDDED, 20.0f, BaseFontStyle.BOLD, null);


    private BaseFontType(FontFamily fontFamily, FontCharEncoding characterEncoding, boolean embedded, float size, FontStyle style, BaseColor color) {
        super(fontFamily, characterEncoding, embedded, size, style, color);
    }
}
