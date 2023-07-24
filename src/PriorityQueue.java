
import java.util.NoSuchElementException;
//This implementation is getting by our text book.
public class PriorityQueue<T> implements PriorityQueueInterface<T> {
	 private Node firstNode;
	    private Node lastNode;

	    public PriorityQueue(){

	        firstNode = null;
	        lastNode = null;
	    }

	    public void enqueue(T newEntry) {

	        Node newNode = new Node(newEntry, null);
	        if (isEmpty()) {
	            firstNode = newNode;
	        }
	        else {
	            lastNode.setNext(newNode);
	        }
	        lastNode = newNode;
	    }

	    public T getFront()
	    {
	        if (isEmpty())
	            throw new NoSuchElementException();
	        else
	            return firstNode.getData();
	    } 

	    public T dequeue(){

	        T front = getFront();
	        assert firstNode != null;
	        firstNode.setData(null);
	        firstNode = firstNode.getNext();

	        if(firstNode == null)
	            lastNode = null;

	        return front;

	    }

	    public void displayItems(){
	        Node temp = firstNode;
	        for( int a = 0; a < 20; a ++){
	            if(firstNode == null){
	                continue;
	            }
	            System.out.println(firstNode.getData());
	            firstNode = firstNode.getNext();
	        }
	        firstNode = temp;

	    }


	    public boolean isEmpty() {
	        return (firstNode == null) && (lastNode == null);
	    }

	    public void clear(){

	        firstNode = null;
	        lastNode = null;
	    }

	    private class Node{

	        private T data;
	        private Node next;

	        private Node(T dataPortion){
	            this(dataPortion, null);
	        }
	        private Node(T dataPortion, Node nextNode){
	            data = dataPortion;
	            next = nextNode;
	        }

	        public T getData() {
	            return data;
	        }

	        public void setData(T data) {
	            this.data = data;
	        }

	        public Node getNext() {
	            return next;
	        }

	        public void setNext(Node next) {
	            this.next = next;
	        }
	    }

}