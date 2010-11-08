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

/**
 * Author: alx
 * Date: 3-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class Colors {

    public static final Colors HEAD = new Colors(new BaseColor(0.7f, 0.7f, 0.7f));
    public static final Colors ODDROW = new Colors(new BaseColor(0.8f, 0.8f, 0.8f));
    public static final Colors  TITLE = new Colors(new BaseColor(0.8f, 0.8f, 0.8f));
    public static final Colors  EVENROW = new Colors(null);

    private BaseColor color;

    protected Colors(BaseColor color)
    {
        setColor(color);
    }

    public final Colors setColor(BaseColor color)
    {
        this.color = color;
        return this;
    }
    public final BaseColor getColor()
    {
        return color != null ? new BaseColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()) : null;
    }
}
