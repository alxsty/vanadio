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

package net.digitstar.vanadio.helpers;

import java.lang.reflect.*;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */
public final class BeanHelper
{
	private BeanHelper()
	{/**/}

	private static final String GET = "get";
	private static final String IS = "is";

	public static Object getBeanValue(String prop, Object bean)
	{
		Object value = null;

		if(bean != null && prop != null && prop.length() > 0)
		{
			Class<?> cls = bean.getClass();
			String getter = GET.concat(capitalizeFirst(prop));
			Method m;
			try
			{
				m = cls.getMethod(getter, (Class<?>[]) null);
			}
			catch(NoSuchMethodException e)
			{
				m = null;
			}
			if(m == null)
			{
				getter = IS.concat(capitalizeFirst(prop));
				try
				{
					m = cls.getMethod(getter, (Class<?>[]) null);
				}
				catch(NoSuchMethodException e)
				{
					m = null;
				}
			}
			if(m != null)
			{
				try
				{
					value = m.invoke(bean, (Object[]) null);
				}
				catch(IllegalAccessException e)
				{/**/}
				catch(InvocationTargetException e)
				{/**/}
			}
		}

		return value;
	}

	private static String capitalizeFirst(String s)
	{
		String out = s;

		if(s != null)
		{
			if(s.length() > 1)
			{
				out = s.substring(0, 1).toUpperCase().concat(s.substring(1));
			} else
			{
				out = s.toUpperCase();
			}
		}
		return out;
	}
}
