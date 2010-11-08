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

/**
 * Author: alx
 * Date: 3-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class FontStyle {


    public static final FontStyle UNDEFINED = new FontStyle(-1);
    public static final FontStyle NORMAL = new FontStyle(0);
    public static final FontStyle  BOLD = new FontStyle(1);
    public static final FontStyle  ITALIC = new FontStyle(2);
    public static final FontStyle  UNDERLINE = new FontStyle(4);
    public static final FontStyle  STRIKETHRU = new FontStyle(8);
    public static final FontStyle  BOLDITALIC = new FontStyle(BOLD.getValue() | ITALIC.getValue());

    private int value;

    FontStyle()
    {
        this(-1);
    }
    protected FontStyle(int value)
    {
        this.value = value;
    }

    public final int getValue()
    {
        return value;
    }

    public static FontStyle getStyle(FontStyle ... styles)
    {
        int style = NORMAL.getValue();
        for (FontStyle item : styles)
        {
            if (item != null)
                style |= item.getValue();
        }
        return new FontStyle(style);
    }
}
