import java.util.*;
public class MyQueue<T> implements Iterable<T> {
	private LinkedList<T> list;
	private int maxsize;

	public MyQueue(int size) {
		list = new LinkedList<T> ();
		maxsize = size;
	}

	public boolean add (T e) {
		if (list.size() == maxsize) {
			throw new java.lang.IllegalStateException();
		} else {
			list.append(e);
			return true;
		}
	}

	public T element() {
		return list.getThing(list.getHead());
	}

	public boolean offer (T e) {
		if (list.size() < maxsize) {
			list.append(e);
			return true;
		}
		return false;
	}

	public T peek() {
		if (list.size() == 0) {
			return null;
		}
		return list.getThing(list.getHead());
	}

	public T poll() {
		if (list.size() == 0){
			return null;
		}
		T item = list.getThing(list.getHead());
		list.remove(item);
		return item;
	}

	public T remove() {
		T item = list.getThing(list.getHead());
		list.remove(item);
		return item;
	}

	public Iterator<T> iterator() {
		return list.iterator();
	}

	public int size() {
		return list.size();
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue(5);
		queue.add(3);
		queue.add(5);
		queue.offer(6);
		queue.offer(7);
		System.out.println(queue.size());
		System.out.println(queue.element());
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		System.out.println(queue.remove());
	}
}