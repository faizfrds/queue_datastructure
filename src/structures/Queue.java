package structures;

import java.util.NoSuchElementException;

/**************************************************************************************
 * NOTE: before starting to code, check support/structures/UnboundedQueueInterface.java
 * for detailed explanation of each interface method, including the parameters, return
 * values, assumptions, and requirements
 ***************************************************************************************/
public class Queue<T> implements UnboundedQueueInterface<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public Queue() {		
            // TODO 1
			head = null;
			tail = null;
			size = 0;


    }
	
	public Queue(Queue<T> other) {
            // TODO 2
			head = null;
			tail = null;
			size = 0;
			Node<T> curNode = other.head;

			while (curNode != null){
				enqueue(curNode.data);
				curNode = curNode.next;
			}

	}
	
	@Override
	public boolean isEmpty() {
            // TODO 3
			if (head == null){
				return true;
			}
            return false;
	}

	@Override
	public int getSize() {
            // TODO 4
            return size;
	}

	@Override
	public void enqueue(T element) {
            // TODO 5
		
			Node<T> newNode = new Node<T>(element, null);

			if (head == null){
				head = newNode;
				tail = newNode;
				size++;
			}
			else{
				tail.next = newNode;
				tail = newNode;
			}

	}

	@Override
	public T dequeue() throws NoSuchElementException {
            // TODO 6
			if (head == null) throw new NoSuchElementException();
			
			Node<T> curHead = head;
			head = head.next;
			size--;

			if (head == null) tail = null;

			return curHead.data;
	}

	@Override
	public T peek() throws NoSuchElementException {
            // TODO 7
			if (head == null) throw new NoSuchElementException();

			T elem = head.data;
			return elem;
	}

	
	@Override
	public UnboundedQueueInterface<T> reversed() {
            // TODO 8
			

	}

}

class Node<T> {
	public T data;
	public Node<T> next;
	public Node(T data) { this.data=data;}
	public Node(T data, Node<T> next) {
		this.data = data; this.next=next;
	}
}

