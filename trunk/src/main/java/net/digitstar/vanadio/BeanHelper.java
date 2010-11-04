package net.digitstar.vanadio;

import java.lang.reflect.*;

/**
 * Created by IntelliJ IDEA.
 * User: 908190
 * Date: 12-giu-2009
 * Time: 15.45.59
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
