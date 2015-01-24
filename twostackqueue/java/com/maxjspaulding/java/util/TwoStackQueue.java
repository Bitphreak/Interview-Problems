package com.maxjspaulding.java.util;

import java.util.Arrays; 
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

/** FIFO Queue<E> implmented with two stacks
  */
public class TwoStackQueue<E> implements Queue<E> {

	private Stack<E> enqueueStack = new Stack<E>();   // Holds elements as they are queue'd
	private Stack<E> dequeueStack = new Stack<E>();  // Holds elements as they are dequeu'd

	/** Inserts the specified element into this queue if it is possible to do so immediately
	  * returning true upon success. Does not perform capacity checking.
      */
	public boolean add(E element){
		enqueueStack.push(element);

		return true;
	}
	
	/** Retrieves, but does not remove, the head of this queue.
	  * This method differs from peek only in that it throws an exception if this queue is empty.
	  */
	public E element(){
		E element = peek();
		if(element == null)
			throw new NoSuchElementException();
		return element;
	}

	/** Inserts the specified element into this queue returning true upon success.
	  * Does not perform capacity checking.
	  */
	public boolean	offer(E e){
		return add(e);
	}

	/** if the dequeueStack is empty and the enqueueStack contains elements
	  * siphon them all off and put them in the dequeueStack.
	  * returns true if any elements were siphoned from the enqueueStack to the
	  * dequeueStack.
	  */ 
	private boolean siphon(){
		/* This check could be skipped as siphon() is only called when dequeueStack 
		 * is empty but I am an untrusting sort.
		 */ 
		if(dequeueStack.empty()){  
			if(!enqueueStack.empty()){
				while(!enqueueStack.empty()){
					dequeueStack.push(enqueueStack.pop());
				}
				return true;
			}
		}
		
		return false;
	}
	
	/** Retrieves, but does not remove, the head of this queue, or returns null if this queue
	  * is empty.
	  */
	public E peek(){
		if(dequeueStack.empty() && !siphon())
			return null;
		return dequeueStack.peek();
	}

	/** Retrieves and removes the head of this queue, or returns null if this queue is empty.
	  */
	public E poll(){
		if(dequeueStack.empty() && !siphon())
			return null;
		return dequeueStack.pop();
	}

	/** Retrieves and removes the head of this queue.
	  */
	public E remove(){
		E element = poll();
		if(element == null)
			throw new NoSuchElementException();
		return element;
	}

	/** Returns true if this collection contains the specified element.
	  */
	public boolean contains(Object o){
		return dequeueStack.contains(o) || enqueueStack.contains(o);
	}

	/** Adds all of the elements in the specified collection to this collection (optional operation).
	  */
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}
	
	/** Removes all of the elements from this collection (optional operation).
	  */
	public void clear(){
		enqueueStack.clear();
		dequeueStack.clear();
	}
	
	/** Returns true if this collection contains all of the elements in the specified collection.
	  */
	public boolean containsAll(Collection<?> c){
		if(c != null){
			Iterator<?> i = c.iterator();
			while(i.hasNext()){
				Object e = i.next();
				if(!dequeueStack.contains(e) && !enqueueStack.contains(e))
					return false;
			}
		}
		return true;
	}
		
	/** Returns the hash code value for this collection.
	  */
	public int hashCode(){
		return Arrays.deepHashCode(toArray());
	}
	
	/** Returns true if this collection contains no elements.
	  */
	public boolean isEmpty(){
		return dequeueStack.isEmpty() && enqueueStack.isEmpty();
	}
	
	/** Returns an iterator over the elements in this collection.
	  */
	public Iterator<E> iterator(){
		return new TwoStackQueueIterator(toArray());
    }
	/** Removes a single instance of the specified element from this collection, if it is present (optional operation).
	  */
	public boolean remove(Object o){
		throw new UnsupportedOperationException();
	}
	
	/** Removes all of this collection's elements that are also contained in the specified collection (optional operation).
	  */
	public boolean removeAll(Collection<?> c){
		throw new UnsupportedOperationException();
	}
	
	/** Retains only the elements in this collection that are contained in the specified collection (optional operation).
	  */
	public boolean retainAll(Collection<?> c){
		throw new UnsupportedOperationException();
	}
	
	/** Returns the number of elements in this collection.
	  */
	public int size(){
		return dequeueStack.size() + enqueueStack.size();
	}
	
	/** Returns an array containing all of the elements in this collection.
	  */
	public Object[] toArray(){
		return copyElements(new Object[size()]);
	}
	
	/** Returns an array containing all of the elements in this collection; the runtime type of the returned array is that of the specified array.
	  */
	public <T> T[] toArray(T[] a) {
        int size = size();
        if (a.length < size)
            a = (T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        a = copyElements(a);
        if (a.length > size)
            a[size] = null;
        return a;
    }
	
	/**
     * Copies the elements from our element array into the specified array,
     * in order (from first to last element in the deque).  It is assumed
     * that the array is large enough to hold all elements in the deque.
     *
     * @return its argument
     */
    private <E> E[] copyElements(E[] a) {
        E[] elements = (E[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size());
		int i;
		
		Object[] tmp = dequeueStack.toArray();
		for(i = 0; i<tmp.length; i++)
			elements[i] = (E)tmp[tmp.length-(i+1)];
		
		tmp = enqueueStack.toArray();
		for(int offset = i; i < offset+tmp.length; i++)
			elements[i] = (E)tmp[i-offset];

		return elements;
    }
	
	
	private class TwoStackQueueIterator implements Iterator<E>{
		private Object[] elements;
		private int i = 0;

		public TwoStackQueueIterator(Object[] elements){
			this.elements = elements;
		}

		@Override
		public boolean hasNext() {
			return i < elements.length;
		}

		@Override
		public E next() {
			return (E)elements[i++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	};
	
}
