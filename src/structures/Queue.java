package structures;

import java.util.EmptyStackException;
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
			size = 0;
    }
	
	public Queue(Queue<T> other) {
            // TODO 2
			head = null;
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
				//tail = newNode;
				size++;
				
			}
			else{
				Node<T> curNode = head;
				while (curNode.next != null){
					curNode = curNode.next;
				}
				curNode.next = newNode;
				size++;
			}
			

	}

	@Override
	public T dequeue() throws NoSuchElementException {
            // TODO 6
			if (head == null) throw new NoSuchElementException("abc");
			
			T curHead = head.data;

			if (head.next == null){
				head = null;
				size--;
				return curHead;
			}

			head = head.next;
			size--;

			return curHead;
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

		Queue<T> reversedQ = new Queue<T>();
		Node<T> curNode = head;

		while (curNode != null){
			reversedQ.enqueue(curNode.data);
			curNode = curNode.next;
		}

		return reversedQ;
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
