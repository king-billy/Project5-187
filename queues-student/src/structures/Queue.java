package structures;

import java.util.NoSuchElementException;

/**************************************************************************************
 * NOTE: before starting to code, check support/structures/UnboundedQueueInterface.java
 * for detailed explanation of each interface method, including the parameters, return
 * values, assumptions, and requirements
 ***************************************************************************************/
public class Queue<T> implements UnboundedQueueInterface<T> {

	private int size;
	private Node<T> head;
	private Node<T> tail;
	private Queue<T> reversed = new Queue<>();

	public Queue() {		
		this.head = null;
		this.tail = null;
		size = 0;
            // TODO 1
    }
	
	public Queue(Queue<T> other) {
		Queue<T> newQueue = other;
            // TODO 2
	}
	
	@Override
	public boolean isEmpty() {
            // TODO 3
		return (this.size==0);
	}

	@Override
	public int getSize() {
            // TODO 4
			return this.size;
	}

	@Override
	public void enqueue(T element) {
		this.head = new Node<>(element, head);
		this.size++;

		if(this.size==1)
			this.tail = this.head;

            // TODO 5
	}

	@Override
	public T dequeue() throws NoSuchElementException {
            // TODO 6
		if(isEmpty()) throw new NoSuchElementException();
		T temp = this.tail.data;
		if(this.size==1){
			this.head = null;
			this.tail = null;
			this.size--;
			return temp;
		}
		this.tail = this.tail.prev;
		this.size--;
        return temp;
	}

	@Override
	public T peek() throws NoSuchElementException {
            // TODO 7
			if(isEmpty()) throw new NoSuchElementException();
            return this.tail.data;
	}

	
	@Override
	public UnboundedQueueInterface<T> reversed() {
            // TODO 8
			if(isEmpty()) throw new NoSuchElementException();
			return reversedHelper(this.size);
	}

	public UnboundedQueueInterface<T> reversedHelper(int size){

		if(size == 0)
			return this.reversed;
		if(size==1){
			this.reversed.enqueue(this.tail.data);
			return this.reversed;
		}
		this.reversed.enqueue(this.head.data);
		this.head = this.head.next;
		return reversedHelper(size-1);


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

