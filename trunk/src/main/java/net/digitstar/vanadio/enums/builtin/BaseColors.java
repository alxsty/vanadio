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
import net.digitstar.vanadio.enums.Colors;

/**
 * Author: alx
 * Date: 3-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class BaseColors extends Colors {

    	public static final Colors HEAD = new BaseColors(new BaseColor(0.7f, 0.7f, 0.7f));
		public static final Colors ODDROW = new BaseColors(new BaseColor(0.8f, 0.8f, 0.8f));
		public static final Colors  TITLE = new BaseColors(new BaseColor(0.8f, 0.8f, 0.8f));
		public static final Colors  EVENROW = new BaseColors(null);

    private BaseColors(BaseColor color) {
        super(color);
    }
}
