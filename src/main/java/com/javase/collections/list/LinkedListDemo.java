package com.javase.collections.list;

/**
 *
 *Implements all optional list operations, and permits all elements (including null).
 All of the operations perform as could be expected for a doubly-linked list. Operations that index into the list will traverse the list from the beginning or the end, whichever is closer to the specified index.

 Note that this implementation is not synchronized. If multiple threads access a linked list concurrently, and at least one of the threads modifies the list structurally, it must be synchronized externally. (A structural modification is any operation that adds or deletes one or more elements; merely setting the value of an element is not a structural modification.) This is typically accomplished by synchronizing on some object that naturally encapsulates the list. If no such object exists, the list should be "wrapped" using the Collections.synchronizedList method. This is best done at creation time, to prevent accidental unsynchronized access to the list:

 List list = Collections.synchronizedList(new LinkedList(...));
 The iterators returned by this class's iterator and listIterator methods are fail-fast: if the list is structurally modified at any time after the iterator is created, in any way except through the Iterator's own remove or add methods, the iterator will throw a ConcurrentModificationException. Thus, in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.

 Note that the fail-fast behavior of an iterator cannot be guaranteed as it is, generally speaking, impossible to make any hard guarantees in the presence of unsynchronized concurrent modification. Fail-fast iterators throw ConcurrentModificationException on a best-effort basis. Therefore, it would be wrong to write a program that depended on this exception for its correctness: the fail-fast behavior of iterators should be used only to detect bugs.
 *
 *
 */

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

        java.util.LinkedList link = new java.util.LinkedList();

        link.addFirst("abc1");
        link.addFirst("abc2");
        link.addFirst("abc3");
        link.addFirst("abc4");
//		System.out.println(link);
//		System.out.println(link.getFirst());//return the first but does not delete it
//		System.out.println(link.getFirst());

//		System.out.println(link.removeFirst());//return the first and delete it
//		System.out.println(link.removeFirst());

        while(!link.isEmpty()){
            System.out.println(link.removeLast());
        }


        System.out.println(link);
//		Iterator it = link.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
    }

}