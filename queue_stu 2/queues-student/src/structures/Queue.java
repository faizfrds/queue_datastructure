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
	private int size;

	public Queue() {		
		head = null;
		size = 0;
	}
	
	public Queue(Queue<T> other) {
		head = null;
		Node<T> curNode = other.head;

		while (curNode != null){
			enqueue(curNode.data);
			curNode = curNode.next;
		}

		size = other.size;
	}
	
	@Override
	public boolean isEmpty() {
		if (head == null){
			return true;
		}
		return false;
	}

	@Override
	public int getSize() {
		if (size < 0) throw new NoSuchElementException();
		return size;
	}

	@Override
	public void enqueue(T element) {
		if (element == null) throw new NullPointerException();
		
		Node<T> newNode = new Node<T>(element, null);

		if (head == null){
			head = newNode;
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
		if (head == null) throw new NoSuchElementException("Cannot dequeue from empty queue.");
		
		T curHead = head.data;

		if (head.next == null){
			head = null;
			size = 0;
		}
		else{
			head = head.next;
			size--;
		}

		return curHead;
	}

	@Override
	public T peek() throws NoSuchElementException {
		if (head == null) throw new NoSuchElementException("Cannot peek into empty queue.");

		T elem = head.data;
		return elem;
	}

	
	@Override
	public UnboundedQueueInterface<T> reversed() {
            // TODO 8

		//if (head == null) throw new NullPointerException();
		UnboundedQueueInterface<T> reversedQ = new Queue<T>();
		reverseHelper(head, reversedQ);
		return reversedQ;
	}

	public UnboundedQueueInterface<T> reverseHelper(Node<T> curNode, UnboundedQueueInterface<T> reversedQ){

		if (curNode == null){
			return reversedQ;
		}
		else{
			reverseHelper(curNode.next, reversedQ);
			reversedQ.enqueue(curNode.data);

			return reversedQ;

		}

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
