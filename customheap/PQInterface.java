package customheap;

public interface PQInterface<E> {
	public int insert(E newItem);
	public E deleteMax() ;
	public E max();
	public boolean isEmpty();
	public void clear();
} 
