import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	
	
	private Node start;
	private Node end;
	private int size = 0;
	
	// Implement using a linked list	
	public Deque() {
		
	}
	
	
	public boolean isEmpty() {
		return start == null;
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(Item item) {
		if (item == null) {
			throw new java.lang.IllegalArgumentException();
		}
		
		Node newItem = new Node(item);
		
		if (start == null) {
			end = newItem;			
		} else {
			start.prev = newItem;
			newItem.next = start;
		}
		
		start = newItem;
		
		size++;
	}
	
	public void addLast(Item item) {
		Node newItem = new Node(item);
		
		if (end == null) {
			start = newItem;
		} else {
			end.next = newItem;
			newItem.prev = end;
		}
		
		end = newItem;
		
		size++;
	}
	
	public Item removeFirst() {
		if (size == 0) {
			throw new java.util.NoSuchElementException();
		}
		
		Node first = start;
		start = start.next;
		
		if (start == null) {
			end = null;
		}else {
			start.prev = null;
		}
		
		size--;
		return first.value;
	}
	
	public Item removeLast() {
		if (size == 0) {
			throw new java.util.NoSuchElementException();
		}
		
		Node last = end;		
		end = end.prev;

		if (end == null) {
			start = null;
		}else {
			end.next = null;
		}
		
		size--;
		return last.value;
	}	

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item>{

		private Node current = start;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			Item item = current.value;
			current = current.next;

			return item;  
		}
		
		@Override
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
	}
			
	private class Node{
		Item value;
		Node next;
		Node prev;
		
		public Node(Item item) {
			if (item == null) {
				throw new java.lang.IllegalArgumentException();
			}
			this.value = item;
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> deque = new Deque<Integer>();
		
		deque.addFirst(1);
		
		for(int i : deque) {
			System.out.println(i);
		}

	}
}
