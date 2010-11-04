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

import net.digitstar.vanadio.decorators.FontStyle;

/**
 * Author: alx
 * Date: 3-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class BuiltInFontStyle extends FontStyle {

    	public static final FontStyle UNDEFINED = new BuiltInFontStyle(-1);
		public static final BuiltInFontStyle NORMAL = new BuiltInFontStyle(0);
		public static final FontStyle  BOLD = new BuiltInFontStyle(1);
		public static final FontStyle  ITALIC = new BuiltInFontStyle(2);
		public static final FontStyle  UNDERLINE = new BuiltInFontStyle(4);
		public static final FontStyle  STRIKETHRU = new BuiltInFontStyle(8);
		public static final FontStyle  BOLDITALIC = new BuiltInFontStyle(BOLD.getValue() | ITALIC.getValue());

    private BuiltInFontStyle(int value) {
        super(value);
    }
}
