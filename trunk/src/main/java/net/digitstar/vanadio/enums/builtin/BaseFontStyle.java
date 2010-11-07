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

import net.digitstar.vanadio.enums.FontStyle;

/**
 * Author: alx
 * Date: 3-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class BaseFontStyle extends FontStyle {

    	public static final FontStyle UNDEFINED = new BaseFontStyle(-1);
		public static final BaseFontStyle NORMAL = new BaseFontStyle(0);
		public static final FontStyle  BOLD = new BaseFontStyle(1);
		public static final FontStyle  ITALIC = new BaseFontStyle(2);
		public static final FontStyle  UNDERLINE = new BaseFontStyle(4);
		public static final FontStyle  STRIKETHRU = new BaseFontStyle(8);
		public static final FontStyle  BOLDITALIC = new BaseFontStyle(BOLD.getValue() | ITALIC.getValue());

    private BaseFontStyle(int value) {
        super(value);
    }
}
