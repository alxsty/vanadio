/*******************************************************************************
 * /*
 *  * Copyright $today.ear DiGiTsTar.NeT (dTs)
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *  */

package net.digitstar.vanadio.decorators;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import net.digitstar.vanadio.decorators.builtin.BuiltInFontFamily;

/**
 * FontFamily Tester.
 *
 * @author <Authors name>
 * @since <pre>11/04/2010</pre>
 * @version 1.0
 */
public class FontFamilyTest extends TestCase {
    public FontFamilyTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     *
     * Method: getName()
     *
     */
    public void testGetName() throws Exception {
        String s1 = BuiltInFontFamily.COURIER.getName();
        String s2 = TestCustomFontFamily.FAMILYA.getName();
        assert(!s1.equals(s2));
    }

    /**
     *
     * Method: getDefaultFontFamily()
     *
     */
    public void testGetDefaultFontFamily() throws Exception {
        FontFamily f1 = BuiltInFontFamily.getDefaultFontFamily();
        FontFamily f2 = TestCustomFontFamily.getDefaultFontFamily();

       assertNotSame(f1,f2);

    }



    public static Test suite() {
        return new TestSuite(FontFamilyTest.class);
    }
}
