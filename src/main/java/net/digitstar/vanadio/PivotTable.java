package net.digitstar.vanadio;


import java.util.*;

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

public abstract class PivotTable<C, V>
{
	private Map<C, List<V>> pivot = new LinkedHashMap<C, List<V>>();
	private String column;
	private List<String> values;

	private Matrix<V> matrix = null;

	boolean rowTotal = false;
	boolean colTotal = false;

	private Map<C, V> columnTotals = null;
	private List<V> rowTotals = null;
	private V grandTotal = null;

	public PivotTable(String column, String values)
	{
		this(column, new String[]{values});
	}

	public PivotTable(String column, String... values)
	{
		this(column, Arrays.asList(values));
	}

	public PivotTable(String column, List<String> values)
	{
		this.column = column;
		this.values = values;

	}

	public PivotTable setRowTotal(boolean total)
	{
		this.rowTotal = total;
		if(this.rowTotal)
		{
			this.rowTotals = new ArrayList<V>();
		}

		return this;
	}

	public PivotTable setColTotal(boolean total)
	{
		this.colTotal = total;
		if(this.colTotal)
		{
			columnTotals = new LinkedHashMap<C, V>();
		}
		return this;
	}

	public void addValue(C column, V value)
	{
		List<V> v = pivot.get(column);

		if(v == null)
		{
			v = new ArrayList<V>();
			pivot.put(column, v);
		}

		v.add(value);
		if(this.colTotal)
		{
			sumColumns(column, value);
		}

		if(this.rowTotal)
		{
			sumRows(v.size() - 1, value);
		}

		if(this.rowTotal && this.colTotal)
		{
			if(grandTotal == null)
			{
				grandTotal = init();
			}
			grandTotal = add(grandTotal, value);
		}
	}

	@SuppressWarnings({"unchecked"})
	public void addValue(Object obj)
	{
		C cvalue = (C) BeanHelper.getBeanValue(this.column, obj);

        
        V value = init();
        for(String v : this.values)
		{
            Object x = BeanHelper.getBeanValue(v, obj);
            value = put(v, value,x);
		}

        addValue(cvalue, value);
	}

    public void create(List<?> eb)
	{
		for(Object item : eb)
		{
			addValue(item);
		}
	}

	private void sumRows(int i, V value)
	{
		List<V> tot = this.rowTotals;
		if(tot != null)
		{
			if(i > tot.size() - 1)
			{
				tot.add(init());
			}

			V t = add(tot.get(i), value);
			tot.remove(i);
			tot.add(i, t);
		}
	}

	private void sumColumns(C column, V value)
	{
		V tot = columnTotals.get(column);

		if(tot == null)
		{
			tot = init();
		}
		tot = add(tot, value);
		columnTotals.put(column, tot);
	}

	private Matrix<V> buildMatrix()
	{
		if(matrix == null)
		{
			matrix = new Matrix<V>(getRowCount());
			Collection<List<V>> cc = pivot.values();
			List<V> r;
			for(List<V> vv : cc)
			{
				for(int i = 0; i < vv.size(); i++)
				{
					if(i > matrix.size() - 1)
					{
						r = new ArrayList<V>(getColumnCount());
						matrix.add(r);
					}
					r = matrix.get(i);
					r.add(vv.get(i));
				}
			}
		}

		return matrix;
	}

	public int getColumnCount()
	{
		return pivot.keySet().size();
	}

	public Collection<C> getColumns()
	{
		return pivot.keySet();
	}

	public int getRowCount()
	{
		int i;

		try
		{
			i = pivot.values().iterator().next().size();
		}
		catch(Exception e)
		{
			i = 0;
		}

		return i;
	}

	public Matrix<V> getRows()
	{
		return buildMatrix();

	}

	public int currentRowIndex()
	{
		// return getRows().getMatrixRowIndex() + 1;
		return getRows().getMatrixRowIndex();
	}


	public Collection<V> getRows(C column)
	{
		return pivot.get(column);
	}

	public Collection<V> getRowTotals()
	{
		return rowTotals;
	}

	public Collection<V> getColumnTotals()
	{
		return columnTotals.values();
	}

	public V getRowTotal(int i)
	{
		V v = null;
		Collection<V> vv = getRowTotals();
		i--;

		if(i >= 0 && i < vv.size())
		{
			v = new ArrayList<V>(vv).get(i);
		}

		return v;
	}

	public V getColumnTotal(C column)
	{
		return columnTotals.get(column);
	}

	public V getGrandTotal()
	{
		return grandTotal;
	}

	protected abstract V add(V t, V v);

    protected abstract V put(String name, V value, Object x);

    protected abstract V init();


	public class Matrix<V>
		implements Iterator<List<V>>, Iterable<List<V>>, List<List<V>>
	{

		private int matrixRowIndex = 0;
		private List<List<V>> data = null;


		Matrix(int initialCapacity)
		{
			data = new ArrayList<List<V>>(initialCapacity);
		}

		Matrix()
		{
			data = new ArrayList<List<V>>();
		}

		Matrix(Collection<? extends List<V>> c)
		{
			data = new ArrayList<List<V>>(c);
		}

		public int size()
		{
			return data.size();
		}

		public boolean isEmpty()
		{
			return data.isEmpty();
		}

		public boolean contains(Object o)
		{
			return data.contains(o);
		}

		public Iterator<List<V>> iterator()
		{
			matrixRowIndex = 0;
			return data.iterator();

		}

		public Object[] toArray()
		{
			return data.toArray();
		}

		public <T> T[] toArray(T[] a)
		{
			return data.toArray(a);
		}

		public boolean add(List<V> vs)
		{
			return data.add(vs);
		}

		public boolean remove(Object o)
		{
			return data.remove(o);
		}

		public boolean containsAll(Collection<?> c)
		{
			return data.containsAll(c);
		}

		public boolean addAll(Collection<? extends List<V>> c)
		{
			return data.addAll(c);
		}

		public boolean addAll(int index, Collection<? extends List<V>> c)
		{
			return data.addAll(index, c);
		}

		public boolean removeAll(Collection<?> c)
		{
			return data.removeAll(c);
		}

		public boolean retainAll(Collection<?> c)
		{
			return data.retainAll(c);
		}

		public void clear()
		{
			data.clear();
		}

		public List<V> get(int index)
		{
			return data.get(index);
		}

		public List<V> set(int index, List<V> element)
		{
			return data.set(index, element);
		}

		public void add(int index, List<V> element)
		{
			data.add(index, element);
		}

		public List<V> remove(int index)
		{
			return data.remove(index);
		}

		public int indexOf(Object o)
		{
			return data.indexOf(o);
		}

		public int lastIndexOf(Object o)
		{
			return data.lastIndexOf(o);
		}

		public ListIterator<List<V>> listIterator()
		{
			return data.listIterator();
		}

		public ListIterator<List<V>> listIterator(int index)
		{
			return data.listIterator(index);
		}

		public List<List<V>> subList(int fromIndex, int toIndex)
		{
			return data.subList(fromIndex, toIndex);
		}

		public boolean hasNext()
		{

			return data.iterator().hasNext();
		}

		public List<V> next()
		{
			if(hasNext())
			{
				matrixRowIndex++;
				//return  data.iterator().next();
				return data.get(matrixRowIndex - 1);
			}

			return null;
		}

		public void remove()
		{
			throw new Error("Operation not supported");
		}

		public int getMatrixRowIndex()
		{
			return matrixRowIndex;
		}
	}


}



