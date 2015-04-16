 
I General Questions: 
1) What is the Java Collections API? List down its advantages? 
2) Explain Collections hierarchy? 
3) Why Collection interface does not extend Cloneable and Serializable interface? 
4) Why Map interface does not extend Collection interface? 
 
II List interface related: 
1) Why we use List interface? What are main classes implementing List interface? 
2) How to convert an array of String to ArrayList? 
3) How to reverse the list? 
4). ArrayList 
5). LinkedList 
 
III Set interface related: 
1) Why we use Set interface? What are main classes implementing Set interface? 
2) How HashSet store elements? 
3) Can a null element added to a TreeSet or HashSet? 
4) TreeSet 
 
IV: Map interface related 
1) Why we use Map interface? What are main classes implementing Map interface? 
2) What are IdentityHashMap and WeakHashMap? 
3) HashMap, HashTable, and ConcurrentHashMap? 
4) How hashmap works? 
5) How to design a good key for hashmap? 
6) What are different Collection views provided by Map interface? 
7) When to use HashMap or TreeMap? 
 
V Tell the difference questions:  
1) Difference between Set and List? 
2) Difference between List and Map? 
3) Difference between HashMap and HashTable? 
4) Difference between Vector and ArrayList? 
5) Difference between Iterator and Enumeration? 
6) Difference between HashMap and HashSet? 
7) Difference between Iterator and ListIterator? 
8) Difference between TreeSet and SortedSet? 
9) Difference between ArrayList and LinkedList? 
 
VI: More questions:  
1) How to make a collection read only? 
2) How to make a collection thread safe? 
3) Why there is no method like Iterator.add() to add elements to the collection? 
4) What are different ways to iterate over a list? 
5) What do you understand by iterator fail-fast property? 
6) What is difference between fail-fast and fail-safe? 
7) How to avoid ConcurrentModificationException while iterating a collection? 
8) What is UnsupportedOperationException? 
9) Which collection classes provide random access of it’s elements? 
10) What is BlockingQueue? 
11) What is Queue and Stack, list their differences? 
12) What is Comparable and Comparator interface? 
13) What are Collections and Arrays class? 
14) Tell me an application scenario of ConcurrencyHashmap? 
 
General question 
1) What is the Java Collection framework? List down its advantages? 
A collection is an object that represents a group of objects.  
Like in set theory, a set is group of elements.  
 
The collections framework was designed and developed primarily by Joshua Bloch, and was introduced in JDK 1.2. 
 
Its most noticeable advantages can be listed as: 
Reduced programming effort due to ready to use code 
Increased performance because of high-performance implementations of data structures and algorithms 
Provides interoperability between unrelated APIs by establishing a common language to pass collections back and forth 
Easy to learn APIs by learning only some top level interfaces and supported operations 
2) Explain Collection’s hierarchy? 
Java Collection Hierarchy 
Java Collection Hierarchy 
Collection. It is extended by Set, List and Queue interfaces.  
 
Remember the signature of Collection interface. It will help you in many question. 
http://howtodoinjava.com/2013/07/09/useful-java-collection-interview-questions/# 
 
 
 
public interface Collection extends Iterable { 
//method definitions 
} 
Framework also consist of Map interface, which is part of collection framework. but it does not extend Collection interface. 
 
3) Why Collection interface does not extend Cloneable and Serializable interface? 
Well, simplest answer is “there is no need to do it“.  
Extending an interface simply means that you are creating a subtype of interface, in other words a more specialized behavior and Collection interface is not expected to do what Cloneable and Serializable interfaces do. 
 
Another reason is that not everybody will have a reason to have Cloneable collection because if it has very large data, then every unnecessary clone operation will consume a big memory. Beginners might use it without knowing the consequences. 
 
Another reason is that Cloneable and Serializable are very specialized behavior and so should be implemented only when required. For example, many concrete classes in collection implement these interfaces. So if you want this feature. use these collection classes otherwise use their alternative classes. 
 
4) Why Map interface does not extend Collection interface? 
 Because they are incompatible.  
Collection has a method add(Object o). Map can not have such method because it need key-value pair.  
There are other reasons also such as Map supports keySet, valueSet etc. Collection classes does not have such views. 
Due to such big differences, Collection interface was not used in Map interface, and it was build in separate hierarchy. 
 
List interface related 
1) Why we use List interface? What are main classes implementing List interface? 
list is an “ordered” collection of elements.  
This ordering is a zero based index.  
It allows duplicates. 
Apart from methods defined in Collection interface, it does have its own methods also which are largely to manipulate the collection based on index location of element. These methods can be grouped as search, get, iteration and range view. All above operations support index locations. 
The main classes implementing List interface are: Stack, Vector, ArrayList and LinkedList. 
 
2) How to convert an array of String to arraylist? 
For now, lets learn that there are two utility classes in Collection framework which are mostly seen in interviews i.e. Collections and Arrays. 
Collections class provides some static functions to perform specific operations on collection types. And Arrays provide utility functions to be performed on array types.http://howtodoinjava.com/2013/07/09/useful-java-collection-interview-questions/# 
1 
2 
3 
4 
5 
//String array 
String[] words = {"ace", "boom", "crew", "dog", "eon"}; 
//Use Arrays utility class 
List wordList = Arrays.asList(words); 
//Now you can iterate over the list 
Please not that this function is not specific to String class, it will return List of element of any type, of which the array is. e.g.http://howtodoinjava.com/2013/07/09/useful-java-collection-interview-questions/# 
1 
2 
3 
4 
//String array 
Integer[] nums = {1,2,3,4}; 
//Use Arrays utility class 
List numsList = Arrays.asList(nums); 
 
3) How to reverse the list? 
Use it reverse() method to reverse the list.http://howtodoinjava.com/2013/07/09/useful-java-collection-interview-questions/# 
1 
Collections.reverse(list); 
 
 
4) ArrayList: 
* Resizable-array implementation of the List interface. Allow null. 
* Unsynchronized 
* List list = Collections.synchronizedList(new ArrayList(...)); or Synchronized object 
* if the list is structurally modified, iterator fail-fast.  Throw ConcurrentModificationException (throw is not guaranteed) 
 
vectory is synchronized. 
 
5). LinkedList: 
* Doubly-linked list implementation of the List and Deque interfaces. Allow  null. 
* All of the operations perform as could be expected for a doubly-linked list.  
* Operations that index into the list will traverse the list from the beginning or the end, whichever is closer to the specified index. 
* Unsynchronized.  
* List list = Collections.synchronizedList(new LinkedList()) or Synchronized object 
* if the list is structurally modified, iterator fail-fast.  Throw ConcurrentModificationException (throw is not guaranteed) 
 
9ef 
 
Set interface related 
1) Why we use Set interface? What are main classes implementing Set interface? 
* It is not ordered collection , no duplicates (uniqueness), and at most one null. 
* Set also adds a stronger contract on the behavior of the equals and hashCode operations, allowing Set instances to be compared meaningfully even if their implementation types differ.  
 
* Two Set instances are equal if they contain the same elements. 
Based on above reasons, it does not have operations based on indexes of elements like List. It only has methods which are inherited by Collection interface. 
 
2) How HashSet store elements? 
 
* At most one null. 
*You must know that HashMap store key-value pairs, with one condition i.e. keys will be unique. HashSet uses Map’s this feature to ensure uniqueness of elements.  
http://howtodoinjava.com/2013/07/09/useful-java-collection-interview-questions/# 
 
 
 
 
private transient HashMap<E,Object> map; 
  
//This is added as value for each key 
private static final Object PRESENT = new Object(); 
So when you store a element in HashSet, it stores the element as key in map and “PRESENT” object as value. (See declaration above). 
http://howtodoinjava.com/2013/07/09/useful-java-collection-interview-questions/# 
 
 
 
public boolean add(E e) { 
return map.put(e, PRESENT)==null; 
} 
* unsynchronized: Set s = Collections.synchronizedSet(new HashSet(...)); 
fail-fast and throws ConcurrentModificationException (not guaranteed) 
 
3) Can a null element added to a TreeSet or HashSet? 
* At most one null for HashSet, no null for TreeSet. 
* TreeSet uses the same concept as HashSet for internal logic, but uses NavigableMap for storing the elements. 
http://howtodoinjava.com/2013/07/09/useful-java-collection-interview-questions/# 
 
 
 
 
private transient NavigableMap<E,Object> m; 
  
// Dummy value to associate with an Object in the backing Map 
private static final Object PRESENT = new Object(); 
NavigableMap is subtype of SortedMap which does not allow null keys. So essentially, TreeSet also does not support null keys. It will throw NullPointerException if you try to add null element in TreeSet. 
 
4) TreeSet 
*The elements are ordered using their natural ordering, or by a Comparator provided at set creation time, depending on which constructor is used. 
 
* unsynchronized: SortedSet s = Collections.synchronizedSortedSet(new TreeSet(...)); 
Fail-fast, throw ConcurrentModificationException 
 
Map interface related 
1) Why we use Map interface? What are main classes implementing Map interface? 
* Map interface is a special type of collection which is used to store key-value pairs.  
* It does not extend Collection interface for this reason.  
* This interface provides methods to add, remove, search or iterate over various views of Map. 
* Main classes implementing Map interface are: HashMap, Hashtable, EnumMap, IdentityHashMap, LinkedHashMap and Properties. 
2) What are IdentityHashMap and WeakHashMap? 
* IdentityHashMap is similar to HashMap except that it uses reference equality when comparing elements.  
* IdentityHashMap is designed for use only in the rare cases wherein reference-equality semantics are required. 
* IdentityHashMap class is not a widely used Map implementation. While this class implements the Map interface, it intentionally violates Map’s general contract, which mandates the use of the equals() method when comparing objects.  
 
* WeakHashMap is an implementation of the Map interface that stores only weak references to its keys. 
* Storing only weak references allows a key-value pair to be garbage collected when its key is no longer referenced outside of the WeakHashMap.  
* This class is intended primarily for use with key objects whose equals methods test for object identity using the == operator.  
* Once such a key is discarded it can never be recreated, so it is impossible to do a look-up of that key in a WeakHashMap at some later time and be surprised that its entry has been removed. 
3) HashMap, HashTable, and ConcurrentHashMap? 
#HashTable: 
* no null key or value 
* To successfully store and retrieve objects from a hashtable, the objects used as keys must implement the hashCode method and the equals method. 
* An instance of Hashtable has two parameters: initial capacity and load factor.  
* The capacity is the number of buckets in the hash table. 
 * hash table is open: in the case of a "hash collision", a single bucket stores multiple entries, which must be searched sequentially.  
* The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased.  
* fail-fast; throw ConcurrentModificationException (not guaranteed) 
*  The Enumerations returned by Hashtable's keys and elements methods are not fail-fast. 
* fail-fast behavior of iterators should be used only to detect bugs. 
* Hashtable is synchronized. If a thread-safe implementation is not needed, it is recommended to use HashMap in place of Hashtable. If a thread-safe highly-concurrent implementation is desired, then it is recommended to use ConcurrentHashMap in place of Hashtable. 
 
# HastMap 
* The HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls. 
* This implementation provides constant-time performance for the basic operations (get and put). 
* HashMap implementation is not synchronized. If multiple threads access a hash map concurrently, and at least one of the threads modifies the map structurally, it must be synchronized externally.  
* This is typically accomplished by synchronizing on some object that naturally encapsulates the map. or 
  Map m = Collections.synchronizedMap(new HashMap(...)); 
* fail-fast: throw ConcurrentModificationException.  
 
* Iteration over collection views requires time proportional to the "capacity" of theHashMap instance (the number of buckets) plus its size (the number of key-value mappings). Thus, it's very important not to set the initial capacity too high (or the load factor too low) if iteration performance is important. 
 
#: ConcurrentHashMap() 
*A hash table supporting full concurrency of retrievals and adjustable expected concurrency for updates.  
*This class obeys the same functional specification as Hashtable, and includes versions of methods corresponding to each method of Hashtable.  
* However, even though all operations are thread-safe, retrieval operations do not entail locking, and there is not any support for locking the entire table in a way that prevents all access.  
* This class is fully interoperable with Hashtable in programs that rely on its thread safety but not on its synchronization details. 
* Retrieval operations (including get) generally do not block, so may overlap with update operations (including put and remove). Retrievals reflect the results of the most recently completed update operations holding upon their onset. 
* Similarly, Iterators and Enumerations return elements reflecting the state of the hash table at some point at or since the creation of the iterator/enumeration.  
* They do not throw ConcurrentModificationException. However, iterators are designed to be used by only one thread at a time. 
* The allowed concurrency among update operations is guided by the optional concurrencyLevel constructor argument (default 16), which is used as a hint for internal sizing. The table is internally partitioned to try to permit the indicated number of concurrent updates without contention.  
* Because placement in hash tables is essentially random, the actual concurrency will vary. Ideally, you should choose a value to accommodate as many threads as will ever concurrently modify the table. Using a significantly higher value than you need can waste space and time, and a significantly lower value can lead to thread contention.  
* But overestimates and underestimates within an order of magnitude do not usually have much noticeable impact. A value of one is appropriate when it is known that only one thread will modify and all others will only read. Also, resizing this or any other kind of hash table is a relatively slow operation, so, when possible, it is a good idea to provide estimates of expected table sizes in constructors. 
* not allow null to be used as a key or value. 
 
4) How hashmap works? 
For now, lets remember that HashMap works on principle of Hashing. A map by definition is : “An object that maps keys to values”. To store such structure, it uses an inner class Entry: 
? 
1 
2 
3 
4 
5 
6 
7 
8 
static class Entry implements Map.Entry 
{ 
final K key; 
V value; 
Entry next; 
final int hash; 
...//More code goes here 
} 
Here key and value variables are used to store key-value pairs. Whole entry object is stored in an array. 
? 
1 
2 
3 
4 
/** 
* The table, re-sized as necessary. Length MUST Always be a power of two. 
*/ 
transient Entry[] table; 
The index of array is calculated on basis on hashcode of Key object. Read more of linked topic. 
5) How to design a good key for hashmap? 
Another good question usually followed up after answering how hashmap works. Well, the most important constraint is you must be able to fetch the value object back in future. Otherwise, there is no use of having such a data structure. If you understand the working of hashmap, you will find it largely depends on hashCode() and equals() method of Key objects. 
So a good key object must provide same hashCode() again and again, no matter how many times it is fetched. Similarly, same keys must return true when compare with equals() method and different keys must return false. 
For this reason, immutable classes are considered best candidate for HashMap keys. 
Read more : How to design a good key for HashMap? 
6) What are different Collection views provided by Map interface? 
Map interface provides 3 views of key-values pairs stored in it: 
key set view 
value set view 
entry set view 
All the views can be navigated using iterators. 
7) When to use HashMap or TreeMap? 
HashMap is well known class and all of us know that. So, I will leave this part by saying that it is used to store key-value pairs and allows to perform many operations on such collection of pairs. 
TreeMap is special form of HashMap. It maintains the ordering of keys which is missing in HashMap class. This ordering is by default “natural ordering”. The default ordering can be override by providing an instance of Comparator class, whose compare method will be used to maintain ordering of keys. 
Please note that all keys inserted into the map must implement the Comparable interface (this is necessary to decide the ordering). Furthermore, all such keys must be mutually comparable: k1.compareTo(k2) must not throw a ClassCastException for any keys k1 and k2 in the map. If the user attempts to put a key into the map that violates this constraint (for example, the user attempts to put a string key into a map whose keys are integers), the put(Object key, Object value) call will throw a ClassCastException. 
 
Tell the difference questions 
1) Difference between Set and List? 
The most noticeable differences are : 
Set is unordered collection where List is ordered collection based on zero based index. 
List allow duplicate elements but Set does not allow duplicates. 
List does not prevent inserting null elements (as many you like), but Set will allow only one null element. 
 
2) Difference between List and Map? 
Perhaps most easy question. List is collection of elements where as map is collection of key-value pairs. There is actually lots of differences which originate from first statement. They have separate top level interface, separate set of generic methods, different supported methods and different views of collection. 
I will take much time hear as answer to this question is enough as first difference only. 
3) Difference between HashMap and HashTable? 
There are several differences between HashMap and Hashtable in Java: 
Hashtable is synchronized, whereas HashMap is not. 
Hashtable does not allow null keys or values. HashMap allows one null key and any number of null values. 
The third significant difference between HashMap vs Hashtable is that Iterator in the HashMap is a fail-fast iterator while the enumerator for the Hashtable is not. 
4) Difference between Vector and ArrayList? 
Lets note down the differences: 
All the methods of Vector is synchronized. But, the methods of ArrayList is not synchronized. 
Vector is a Legacy class added in first release of JDK. ArrayList was part of JDK 1.2, when collection framework was introduced in java. 
By default, Vector doubles the size of its array when it is re-sized internally. But, ArrayList increases by half of its size when it is re-sized. 
5) Difference between Iterator and Enumeration? 
Iterators differ from enumerations in three ways: 
Iterators allow the caller to remove elements from the underlying collection during the iteration with its remove() method. You can not add/remove elements from a collection when using enumerator. 
Enumeration is available in legacy classes i.e Vector/Stack etc. whereas Iterator is available in all modern collection classes. 
Another minor difference is that Iterator has improved method names e.g. Enumeration.hasMoreElement() has become Iterator.hasNext(), Enumeration.nextElement() has become Iterator.next() etc. 
6) Difference between HashMap and HashSet? 
HashMap is collection of key-value pairs whereas HashSet is un-ordered collection of unique elements. That’s it. No need to describe further. 
7) Difference between Iterator and ListIterator? 
There are three Differences are there: 
We can use Iterator to traverse Set and List and also Map type of Objects. But List Iterator can be used to traverse for List type Objects, but not for Set type of Objects. 
By using Iterator we can retrieve the elements from Collection Object in forward direction only whereas List Iterator, which allows you to traverse in either directions using hasPrevious() and previous() methods. 
ListIterator allows you modify the list using add() remove() methods. Using Iterator you can not add, only remove the elements. 
8) Difference between TreeSet and SortedSet? 
SortedSet is an interface which TreeSet implements. That’ it !! 
9) Difference between ArrayList and LinkedList? 
LinkedList store elements within a doubly-linked list data structure. ArrayList store elements within a dynamically resizing array. 
LinkedList allows for constant-time insertions or removals, but only sequential access of elements. In other words, you can walk the list forwards or backwards, but grabbing an element in the middle takes time proportional to the size of the list. ArrayLists, on the other hand, allow random access, so you can grab any element in constant time. But adding or removing from anywhere but the end requires shifting all the latter elements over, either to make an opening or fill the gap. 
LinkedList has more memory overhead than ArrayList because in ArrayList each index only holds actual object (data) but in case of LinkedList each node holds both data and address of next and previous node. 
 
More questions 
1) How to make a collection read only? 
Use following methods: 
Collections.unmodifiableList(list); 
Collections.unmodifiableSet(set); 
Collections.unmodifiableMap(map); 
These methods takes collection parameter and return a new read-only collection with same elements as in original collection. 
2) How to make a collection thread safe? 
Use below methods: 
Collections.synchronizedList(list); 
Collections.synchronizedSet(set); 
Collections.synchronizedMap(map); 
Above methods take collection as parameter and return same type of collection which are synchronized and thread safe. 
3) Why there is no method like Iterator.add() to add elements to the collection? 
The sole purpose of an Iterator is to enumerate through a collection. All collections contain the add() method to serve your purpose. There would be no point in adding to an Iterator because the collection may or may not be ordered. And add() method can not have same implementation for ordered and unordered collections. 
4) What are different ways to iterate over a list? 
You can iterate over a list using following ways: 
Iterator loop 
For loop 
For loop (Advance) 
While loop 
Read more : http://www.mkyong.com/java/how-do-loop-iterate-a-list-in-java/ 
5) What do you understand by iterator fail-fast property? 
Fail-fast Iterators fail as soon as they realized that structure of Collection has been changed since iteration has begun. Structural changes means adding, removing or updating any element from collection while one thread is Iterating over that collection. 
Fail-fast behavior is implemented by keeping a modification count and if iteration thread realizes the change in modification count it throws ConcurrentModificationException. 
6) What is difference between fail-fast and fail-safe? 
You have understood fail-fast in previous question. Fail-safe iterators are just opposite to fail-fast. They never fail if you modify the underlying collection on which they are iterating, because they work on clone of Collection instead of original collection and that’s why they are called as fail-safe iterator. 
Iterator of CopyOnWriteArrayList is an example of fail-safe Iterator also iterator written by ConcurrentHashMap keySet is also fail-safe iterator and never throw ConcurrentModificationException. 
7) How to avoid ConcurrentModificationException while iterating a collection? 
You should first try to find another alternative iterator which are fail-safe. For example if you are using List and you can use ListIterator. If it is legacy collection, you can use enumeration. 
If above options are not possible then you can use one of three changes: 
If you are using JDK1.5 or higher then you can use ConcurrentHashMap and CopyOnWriteArrayList classes. It is the recommended approach. 
You can convert the list to an array and then iterate on the array. 
You can lock the list while iterating by putting it in a synchronized block. 
Please note that last two approaches will cause a performance hit. 
8) What is UnsupportedOperationException? 
This exception is thrown on invoked methods which are not supported by actual collection type. 
For example, if you make a read-only list list using “Collections.unmodifiableList(list)” and then call add() or remove() method, what should happen. It should clearly throw UnsupportedOperationException. 
9) Which collection classes provide random access of it’s elements? 
ArrayList, HashMap, TreeMap, Hashtable classes provide random access to it’s elements. 
10) What is BlockingQueue? 
A Queue that additionally supports operations that wait for the queue to become non-empty when retrieving an element, and wait for space to become available in the queue when storing an element. 
BlockingQueue methods come in four forms: one throws an exception, the second returns a special value (either null or false, depending on the operation), the third blocks the current thread indefinitely until the operation can succeed, and the fourth blocks for only a given maximum time limit before giving up. 
Read the example usage of blocking queue in post : How to use blocking queue? 
11) What is Queue and Stack, list down their differences? 
A collection designed for holding elements prior to processing. Besides basic Collection operations, queues provide additional insertion, extraction, and inspection operations. 
Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner. 
Stack is also a form of Queue but one difference, it is LIFO (last-in-first-out). 
Whatever the ordering used, the head of the queue is that element which would be removed by a call to remove() or poll(). Also note that Stack and Vector are both synchronized. 
Usage: Use a queue if you want to process a stream of incoming items in the order that they are received.Good for work lists and handling requests. 
Use a stack if you want to push and pop from the top of the stack only. Good for recursive algorithms. 
12) What is Comparable and Comparator interface? 
In java. all collection which have feature of automatic sorting, uses compare methods to ensure the correct sorting of elements. For example classes which use sorting are TreeSet, TreeMap etc. 
To sort the data elements a class needs to implement Comparator or Comparable interface. That’s why all Wrapper classes like Integer,Double and String class implements Comparable interface. 
Comparable helps in preserving default natural sorting, whereas Comparator helps in sorting the elements in some special required sorting pattern. The instance of comparator if passed usually as collection’s constructor argument in supporting collections. 
13) What are Collections and Arrays classes? 
Collections and Arrays classes are special utility classes to support collection framework core classes. They provide utility functions to get read-only/ synchronized collections, sort the collection on various ways etc. 
Arrays also helps array of objects to convert in collection objects. Arrays also have some functions which helps in copying or working in part of array objects. 
14) Tell me an application scenario of  ConcurrencyHashmap? 
 
 
 
 
