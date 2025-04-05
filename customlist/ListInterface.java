package customlist;

public interface ListInterface<E> {
	public int add(int i, E x);
	public int append(E x);
	public E remove(int i);
	public boolean removeItem(E x);
	public E get(int i);
	public int set(int i, E x);
	public int indexOf(E x);
	public int len();
	public boolean isEmpty();
	public void clear();
} 
