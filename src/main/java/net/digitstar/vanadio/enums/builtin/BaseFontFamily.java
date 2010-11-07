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

import com.itextpdf.text.pdf.BaseFont;
import net.digitstar.vanadio.enums.FontFamily;

/**
 * Author: alx
 * Date: 3-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class BaseFontFamily extends FontFamily {


    public static final FontFamily UNDEFINED = new BaseFontFamily(null);
    public static final FontFamily COURIER = new BaseFontFamily(BaseFont.COURIER);
    public static final FontFamily HELVETICA = new BaseFontFamily(BaseFont.HELVETICA);
    public static final FontFamily TIMES_ROMAN = new BaseFontFamily(BaseFont.TIMES_ROMAN);
    public static final FontFamily SYMBOL = new BaseFontFamily(BaseFont.SYMBOL);
    public static final FontFamily ZAPFDINGBATS = new BaseFontFamily(BaseFont.ZAPFDINGBATS);
    public static final FontFamily ARIAL = new BaseFontFamily("Arial");


    BaseFontFamily() {
        super(null);
    }
    BaseFontFamily(String name) {
        super(name);
    }

    public static FontFamily getDefault()
    {
        return BaseFontFamily.ARIAL;
    }

}
