package customstack;

public interface StackInterface<E> {
	public int push(E newItem);
	public E pop();
	public E top();
	public boolean isEmpty();
	public void popAll();
} // 코드 6-1
