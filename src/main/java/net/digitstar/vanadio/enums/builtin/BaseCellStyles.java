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

import net.digitstar.vanadio.styles.CellStyle;
import net.digitstar.vanadio.enums.CellStyles;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class BaseCellStyles extends CellStyles{


    public static final CellStyles HEAD = new BaseCellStyles(new CellStyle().setHorizAlign(CellStyle.Align.CENTER)
        .setVertAlign(CellStyle.Align.MIDDLE)
        .setCellFont(BaseFontType.HEAD.getFont())
        .setBorder(CellStyle.Border.BOX)
        .setBackgroundColor(BaseColors.HEAD.getColor())
    );
    public static final CellStyles TOTAL =  new BaseCellStyles(new CellStyle().setHorizAlign(CellStyle.Align.CENTER)
        .setVertAlign(CellStyle.Align.MIDDLE)
        .setCellFont(BaseFontType.TOTAL.getFont())
        .setBorder(CellStyle.Border.BOX)
    );
    public static final CellStyles ROW = new BaseCellStyles(new CellStyle().setVertAlign(CellStyle.Align.MIDDLE)
        .setCellFont(BaseFontType.NORMAL.getFont())
        .setBorder(CellStyle.Border.BOX)
        .setAlternateColor(true)
        .setBackgroundColor(BaseColors.EVENROW.getColor()));


    private BaseCellStyles(CellStyle style) {
        super(style);
    }

    public static CellStyles getDefault()
    {
        return BaseCellStyles.ROW;
    }

}
