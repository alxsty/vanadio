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

package net.digitstar.vanadio.styles;

/**
 * Author: alx
 * Date: 7-nov-2010
 * <p/>
 * Vanadio a useful pdf report generator code driven
 */

public abstract class Rect<E>
{
	private E top;
	private E left;
	private E right;
	private E bottom;

	private E _zero;

	protected abstract E zero();

	protected Rect(Rect<E> rect)
	{
		this();
		if(rect != null)
		{
			this.top = rect.top;
			this.left = rect.left;
			this.right = rect.right;
			this.bottom = rect.bottom;
		}
	}

	public Rect()
	{
		this._zero = zero();
		init(_zero);
	}

	public Rect(E top)
	{
		this();
		init(top);
	}

	public Rect(E top, E left)
	{
		this();
		init(top, left);
	}

	public Rect(E top, E left, E right)
	{
		this();
		init(top, left, right);
	}

	public Rect(E top, E left, E right, E bottom)
	{
		this();
		init(top, left, right, bottom);
	}


	private void init(E top)
	{
		init(top, _zero);
	}

	private void init(E top, E left)
	{
		init(top, left, _zero);
	}

	private void init(E top, E left, E right)
	{
		init(top, left, right, _zero);
	}


	private void init(E top, E left, E right, E bottom)
	{
		this.top = top;
		this.left = left;
		this.right = right;
		this.bottom = bottom;
	}


	public E getTop()
	{
		return top;
	}

	public Rect setTop(E top)
	{
		this.top = top;
		return this;
	}

	public E getLeft()
	{
		return left;
	}

	public Rect setLeft(E left)
	{
		this.left = left;
		return this;
	}

	public E getRight()
	{
		return right;
	}

	public Rect setRight(E right)
	{
		this.right = right;
		return this;
	}

	public E getBottom()
	{
		return bottom;
	}

	public Rect setBottom(E bottom)
	{
		this.bottom = bottom;
		return this;
	}

	public boolean isAllSideEqual()
	{

		return this.left == null || (this.left.equals(this.top)
			&& this.top == null || (this.top.equals(this.right)
			&& this.right == null || this.right.equals(this.bottom)
			&& this.bottom == null));
	}

	public E getValue()
	{
		E v = this._zero;
		if(isAllSideEqual())
			v = this.left;
		return v;
	}

	@Override
	public String toString()
	{
		return "Rect{" +
			"top=" + top +
			", left=" + left +
			", right=" + right +
			", bottom=" + bottom +
			'}';
	}
}
