package net.digitstar.vanadio;


/**
 * <p>Title: AscotWeb Elezioni</p>
 * <p/>
 * <p>Description: Gestione consultazioni elettorali</p>
 * <p/>
 * <p>Copyright: Copyright (c) 2001-2009</p>
 * <p/>
 * <p>Company: Insiel S.p.A.</p>
 *
 * @author Alex Svetina
 * @author Tino Pratticò
 * @version 2009 rel. 2009
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
