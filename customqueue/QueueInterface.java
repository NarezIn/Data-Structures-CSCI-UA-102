package customqueue;

public interface QueueInterface<E> {
	public int enqueue(E x);
	public E dequeue();
	public E front();
	public boolean isEmpty();
	public void dequeueAll();
} 
