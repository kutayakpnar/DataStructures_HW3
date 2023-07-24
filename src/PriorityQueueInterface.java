
public interface PriorityQueueInterface<T> {
	public void enqueue(T newItem);

    public T dequeue();

    public T getFront();

    public boolean isEmpty();

    public void clear();

}