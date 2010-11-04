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

import com.itextpdf.text.pdf.BaseFont;
import net.digitstar.vanadio.decorators.Default;
import net.digitstar.vanadio.decorators.FontFamily;

/**
 * Author: alx
 * Date: 3-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class BuiltInFontFamily extends FontFamily {


    public static final FontFamily UNDEFINED = new BuiltInFontFamily(null);
    public static final FontFamily COURIER = new BuiltInFontFamily(BaseFont.COURIER);
    public static final FontFamily HELVETICA = new BuiltInFontFamily(BaseFont.HELVETICA);
    public static final FontFamily TIMES_ROMAN = new BuiltInFontFamily(BaseFont.TIMES_ROMAN);
    public static final FontFamily SYMBOL = new BuiltInFontFamily(BaseFont.SYMBOL);
    public static final FontFamily ZAPFDINGBATS = new BuiltInFontFamily(BaseFont.ZAPFDINGBATS);
    @Default
    public static final FontFamily ARIAL = new BuiltInFontFamily("Arial");

    private BuiltInFontFamily(String name) {
        super(name);
    }
}
