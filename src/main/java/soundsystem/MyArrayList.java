package soundsystem;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
	
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	
	private T[] theItems;
	
	public MyArrayList() {
		clear();
	}
	
	public int size() {
		return theSize;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void trimToSize(){
		ensureCapacity(size());
	}
	
	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public  T get(int idx) {
		if (idx < 0 || idx>=size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[idx];
	}
	
	public <T> T set(int idx,T newVal) {
		return null;
	}
	
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize) 
			return;
		T[] old = theItems;
		theItems = (T[]) new Object[newCapacity];
		for(int i = 0;i < size();i++) {
			theItems[i] = old[i];
		}
	}
	
	public Iterator<T> iterator() {
		
		return null;
	}

}
