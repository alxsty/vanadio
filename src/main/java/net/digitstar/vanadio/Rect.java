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
