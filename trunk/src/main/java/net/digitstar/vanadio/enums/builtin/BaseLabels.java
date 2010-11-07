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

import net.digitstar.vanadio.enums.Labels;

import java.util.Locale;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public class BaseLabels extends Labels {

    public static final Labels PAGE = new BaseLabels("Page {0}", "Pag. {0}")
                                          .addLocalization(Locale.ITALIAN,"Pagina {0}", "Pag. {0}");
    public static final Labels PAGE_TOTAL = new BaseLabels("Pag. {0} of {1}", "Pag. {0}/{1}");
    public static final Labels PRINTED = new BaseLabels("Printed on: {0}", null)
                                          .addLocalization(Locale.ITALIAN,"Stampato il: {0}", null);


    private BaseLabels(String label, String abbreviation) {
        super(label, abbreviation);
    }
}
