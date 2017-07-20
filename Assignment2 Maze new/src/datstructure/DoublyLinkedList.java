package datstructure;

import java.util.*;

/**
 *
 * @author aalva456
 */


public class DoublyLinkedList {

    private Node first;
    private Node last;
    private Node sorted;
    private int size;

    /**
     * Constructs an empty Doubly LinkedList
     */
    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.sorted = null;
        this.size = 0;
    }

    /**
     * Check if the list is empty
     * @return false if is not empty
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Return the size of the list
     * @return the size
     */
    public int size() {
        return size;
    }

    /**
     * Returns the first element of the list if not throws an exception
     * @return the first element
     */
    public Object getFirst() {
        if (first == null) { throw new NoSuchElementException(); }
        else 
            return first.data;
    }

    /**
     * Returns the last element of the list if not throws an exception
     * @return the last element
     */
    public Object getLast() {
        if (last == null) { throw new NoSuchElementException(); }
        else 
            return last.data;
    }

    /**
     * Add an element at the front of the list
     * @param newData element to be added
     */
    public void addFirst(Object element) {

        Node newNode = new Node(element);
        
        if (first == null) {
            first = newNode;
            last = first;
        } else {
            first.prev = newNode;        
            newNode.next = first;           
            first = newNode;
        }
        
        Node current = first;
        
        while(current != null)
        {
            last = current;
            current = current.next;
        }
        
        size++;
    }

    /**
     * Add an element at the end of the list
     * @param newData element to be added
     */
    public void addLast(Object newData) {
        Node newNode = new Node(newData);
        if (first == null) 
        {
            first = newNode;
            last = first;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    /**
     * Removes the first element in the list
     * @return the first element
     */
    public Object removeFirst() {
        if (first == null) { throw new NoSuchElementException(); }
        Object element = first.data;
        first = first.next;
        size--;
        return element;
    }

    /**
     * Removes the last element in the list
     * @return the last element
     */
    public Object removeLast() {
        if (last == null) { throw new NoSuchElementException(); }
        Object element = last.data;
        last = last.prev;
        last = last.next = null;
        size--;
        return element;
    }

    /**
     * Returns an iterator for iterating through this list.
     * @return an iterator for iterating through this list
     */
    public ListIterator listIterator() {
        return new LinkedListIterator();
    }

    /**
     * Sort the data in the list, using insertion sort. Use the private compare
     * method to compare nodes.
     */
    public void sort() 
    {
        if (first != null)
        {
            sorted = first;
            first = first.next;
            sorted.next = null;
            
            while (first != null)
            {
                Node current = first;
                first = first.next;
                
                if (compare(current.data, sorted.data) < 1)
                {
                    current.next = sorted;
                    current.prev = sorted.prev;
                    sorted.prev = current;
                    sorted.next = first;
                    first.prev = sorted;
                    sorted = current;
                }
                else
                {
                    Node search = sorted;
                    
                    while (search.next != null && compare(current.data, search.next.data) > 1)
                    {
                        search = search.next;
                    }
                    
                    current.next = search.next;
                    search.next = current;
                }
            }
        }
        
        first = sorted;
        
    }
        

    // This helper method allows you to compare two objects
    // The annotation supresses warnings because of possible 
    // "unsafe" comparisons between different object types.
    // For information on making your data structures safe, 
    // see Chapter 18 on Generics.
    @SuppressWarnings("unchecked")
    private int compare(Object a, Object b) {
        if (!(a instanceof Comparable && b instanceof Comparable)) {
            throw new RuntimeException("Cannot compare non-comparable types.");
        }
        return ((Comparable) a).compareTo((Comparable) b);
    }

    /**
     * Return the contents of the list.
     */
    @Override
    public String toString() {
        String result = "[";
        ListIterator iter = listIterator();
        if (iter.hasNext()) {
            result += iter.next();
        }
        while (iter.hasNext()) {
            result += ", " + iter.next();
        }
        result += "]";
        return result;
    }
    
     class LinkedListIterator implements ListIterator
   {
      private Node position;
      private Node previous;
      private boolean isAfterNext;

      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {
         position = null;
         previous = null;
         isAfterNext = false;
      }

      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {
         if (!hasNext()) { throw new NoSuchElementException(); }
         previous = position; // Remember for remove
         isAfterNext = true;

         if (position == null)
         {
            position = first;
         }
         else
         {
            position = position.next;
         }

         return position.data;
      }

      /**
         Tests if there is an element after the iterator position.
         @return true if there is an element after the iterator position
      */
      public boolean hasNext()
      {
         if (position == null)
         {
            return first != null;
         }
         else
         {
            return position.next != null;
         }
      }

      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public void add(Object element)
      {
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else
         {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }

         isAfterNext = false;
      }

      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {
         if (!isAfterNext) { throw new IllegalStateException(); }

         if (position == first)
         {
            removeFirst();
         }
         else
         {
            previous.next = position.next;
         }
         position = previous;
         isAfterNext = false;
      }

      /**
         Sets the last traversed element to a different value.
         @param element the element to set
      */
      public void set(Object element)
      {
         if (!isAfterNext) { throw new IllegalStateException(); }
         position.data = element;
      }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object previous() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

       
   }

}
