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

package net.digitstar.vanadio.tables;

import net.digitstar.vanadio.helpers.BeanHelper;


/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */

public class Group
{
	private String fieldNameValue;
	private String fieldNameDescription;
	private Object oldValue;
	private Object currentValue;
	private Object oldDescription;
	private Object currentDescription;


	public Group(String fieldNameValue)
	{
		this(fieldNameValue, null);
	}

	public Group(String fieldNameValue, Object oldValue)
	{
		this(fieldNameValue,null,oldValue,null);
	}

	public Group(String fieldNameValue, String fieldNameDescription, Object oldValue, Object oldDescription)
	{
		this.fieldNameValue = fieldNameValue;
		this.fieldNameDescription = fieldNameDescription;
		this.currentValue = oldValue;
		this.currentDescription = oldDescription;
	}


	public String getFieldNameValue()
	{
		return fieldNameValue;
	}

	public String getFieldNameDescription()
	{
		return fieldNameDescription;
	}

	public Object getOldValue()
	{
		return oldValue;
	}

	public Object getCurrentValue()
	{
		return currentValue;
	}

	public Object getCurrentDescription()
	{
		return currentDescription;
	}

	public Object getOldDescription()
	{
		return oldDescription;
	}

	public boolean isValueChanged()
	{
		if (this.currentValue != null)
		{
			return this.oldValue == null || !this.currentValue.equals(this.oldValue);
		}
		else
		{
			return this.oldValue != null;
		}

	}

	public boolean evaluate(Object bean)
	{
		this.oldValue = this.currentValue;
		this.currentValue = BeanHelper.getBeanValue(this.fieldNameValue, bean);
		this.oldDescription = this.currentDescription;
		this.currentDescription =  BeanHelper.getBeanValue(this.fieldNameDescription, bean);

		return isValueChanged();
	}

}
