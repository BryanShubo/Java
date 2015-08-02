
###Collection Features:
```
Store Object
Varied-size
Cannot store primitive type data
Un-synchronized : basically all collection type are uns-ynchronized. Only these three are synchronized Hashtable 
(not from collection), Vector, Stack.

How to make a collection synchronized: Collections.synchronizedCollection(Collection<T> c)
```
###Collection APIs:
```
Add:

boolean add (Object obj);
boolean addAll(Collection coll);

Remove:

boolean remove(object obj):
boolean removeAll(Collection coll);
void clear();


Check:

boolean contains(object obj):
boolean containsAll(Colllection coll);
boolean isEmpty()

Fetch:
    int size():
	Iterator iterator():取出元素的方式：迭代器。
	该对象必须依赖于具体容器，因为每一个容器的数据结构都不同。
	所以该迭代器对象是在容器中进行内部实现的。
	对于使用容器者而言，具体的实现不重要，只要通过容器获取到该实现的迭代器的对象即可，
	也就是iterator方法。
	
	Iterator接口就是对所有的Collection容器进行元素取出的公共接口。
	其实就是抓娃娃游戏机中的夹子！
	
	
Others：
	boolean retainAll(Collection coll); // get cross set。
	Object[] toArray()// convert collection to array将集合转成数组。 
	
Iterator:

interface Iterator
{
	public abstract boolean hasNext();
	public abstract Object next();
}
interface Collection
{
	boolean add();
	Iterator getIns();
}

class MyRongqi implements Collection
{
	add()
	{}
	
	private class hehe implements Iterator
	{
		public boolean hasNext(){}
		public Object next(){}
	}
	public Iterator getIns()
	{
		return new hehe();
	}
	
}

 MyRongqi.hehe a = new MyRongqi().getIns();
Iterator it = new MyRongqi().getIns();

class MyRongqi2  implements Collection
{
	add(){}
	private class hehe implements Iterator
	{
		public boolean hasNext(){}
		public Object next(){}
	}
	public Iterator getIns()
	{
		return new hehe();
	}
	
}
method(new MyRongqi());
public void method(Collection coll)
{
	Iterator it = coll.getIns():
}

 MyRongqi2.hehe a = new MyRongqi2().getIns();
 
 Iterator it = new MyRongqi2().getIns();
```


###Collection: List, Set
```
    List：keep insert-order, duplicates allowed, and have index.
    Set：unordered, no duplicates.
```	
###List APIs
```	
Add:
	void add(index,element);
	void add(index,collection);


Remove:
	Object remove(index):


Update:
	Object set(index,element);
	
Fetch:
	Object get(index);
	int indexOf(object);
	int lastIndexOf(object);
	List subList(from,to);


List:
	|--Vector:synchronized, CRUD performance is low.
	|--ArrayList:un-synchronized, CRUD performance is faster than Vector (designed to replace vector).
	|--LinkedList:un-synchronized, 。增删元素的速度很快。
	
	
	LinkedList store elements within a doubly-linked list data structure. 
	LinkedList allows for constant-time insertions or removals, but only sequential access of elements. 
	LinkedList costs more memory
    
    
    ArrayList: allow random access, so you can grab any element in constant time. 
    ArrayList: adding and removing are slower than LinkedList. 
 ```   
    
    
```
集合类的由来：
	对象用于封装特有数据，对象多了需要存储，如果对象的个数不确定。
	就使用集合容器进行存储。

集合特点：
1，用于存储对象的容器。
2，集合的长度是可变的。
3，集合中不可以存储基本数据类型值。



集合容器因为内部的数据结构不同，有多种具体容器。
不断的向上抽取，就形成了集合框架。

框架的顶层Collection接口：

Collection的常见方法：

1，添加。
	boolean add(Object obj):
	boolean addAll(Collection coll):


2，删除。
	boolean remove(object obj):
	boolean removeAll(Collection coll);
	void clear();

3，判断：
	boolean contains(object obj):
	boolean containsAll(Colllection coll);
	boolean isEmpty():判断集合中是否有元素。

4，获取：
	int size():
	Iterator iterator():取出元素的方式：迭代器。
	该对象必须依赖于具体容器，因为每一个容器的数据结构都不同。
	所以该迭代器对象是在容器中进行内部实现的。
	对于使用容器者而言，具体的实现不重要，只要通过容器获取到该实现的迭代器的对象即可，
	也就是iterator方法。

	Iterator接口就是对所有的Collection容器进行元素取出的公共接口。
	其实就是抓娃娃游戏机中的夹子！


5，其他：
	boolean retainAll(Collection coll);取交集。
	Object[] toArray():将集合转成数组。
```

-------------------------------
```
Collection
	|--List：有序(存入和取出的顺序一致),元素都有索引(角标)，元素可以重复。
	|--Set：元素不能重复,无序。


List:特有的常见方法：有一个共性特点就是都可以操作角标。

1，添加
	void add(index,element);
	void add(index,collection);


2，删除；
	Object remove(index):


3，修改：
	Object set(index,element);


4，获取：
	Object get(index);
	int indexOf(object);
	int lastIndexOf(object);
	List subList(from,to);


list集合是可以完成对元素的增删改查。


List:
	|--Vector:内部是数组数据结构，是同步的。增删，查询都很慢！
	|--ArrayList:内部是数组数据结构，是不同步的。替代了Vector。查询的速度快。
	|--LinkedList:内部是链表数据结构，是不同步的。增删元素的速度很快。



LinkedList:

	addFirst();
	addLast():
	jdk1.6
	offerFirst();
	offetLast();


	getFirst();.//获取但不移除，如果链表为空，抛出NoSuchElementException.
	getLast();
	jdk1.6
	peekFirst();//获取但不移除，如果链表为空，返回null.
	peekLast():

	removeFirst();//获取并移除，如果链表为空，抛出NoSuchElementException.
	removeLast();
	jdk1.6
	pollFirst();//获取并移除，如果链表为空，返回null.
	pollLast();
```

---------------------------------------------
```

Set:元素不可以重复，是无序。
	Set接口中的方法和Collection一致。
	|--HashSet: 内部数据结构是哈希表 ，是不同步的。
		如何保证该集合的元素唯一性呢？
		是通过对象的hashCode和equals方法来完成对象唯一性的。
		如果对象的hashCode值不同，那么不用判断equals方法，就直接存储到哈希表中。
		如果对象的hashCode值相同，那么要再次判断对象的equals方法是否为true。
		如果为true，视为相同元素，不存。如果为false，那么视为不同元素，就进行存储。

		记住：如果元素要存储到HashSet集合中，必须覆盖hashCode方法和equals方法。
		一般情况下，如果定义的类会产生很多对象，比如人，学生，书，通常都需要覆盖equals，hashCode方法。
		建立对象判断是否相同的依据。




	|--TreeSet:可以对Set集合中的元素进行排序。是不同步的。
				判断元素唯一性的方式：就是根据比较方法的返回结果是否是0，是0，就是相同元素，不存。

	TreeSet对元素进行排序的方式一：
	让元素自身具备比较功能，元就需要实现Comparable接口。覆盖compareTo方法。

	如果不要按照对象中具备的自然顺序进行排序。如果对象中不具备自然顺序。怎么办？
	可以使用TreeSet集合第二种排序方式二：
	让集合自身具备比较功能，定义一个类实现Comparator接口，覆盖compare方法。
	将该类对象作为参数传递给TreeSet集合的构造函数。




if(this.hashCode()== obj.hashCode() && this.equals(obj))



哈希表确定元素是否相同
1，判断的是两个元素的哈希值是否相同。
	如果相同，在判断两个对象的内容是否相同。

2，判断哈希值相同，其实判断的是对象的hashCode的方法。判断内容相同，用的是equals方法。

注意：如果哈希值不同，是不需要判断equals。
```
===========================================================
```
集合的一些技巧：

需要唯一吗？
需要：Set
	需要制定顺序：
			需要： TreeSet
			不需要：HashSet
			但是想要一个和存储一致的顺序(有序):LinkedHashSet
不需要：List
	需要频繁增删吗？
		需要：LinkedList
		不需要：ArrayList

如何记录每一个容器的结构和所属体系呢？

看名字！


List
	|--ArrayList
	|--LinkedList

Set
	|--HashSet
	|--TreeSet

后缀名就是该集合所属的体系。

前缀名就是该集合的数据结构。

看到array：就要想到数组，就要想到查询快，有角标.
看到link：就要想到链表，就要想到增删快，就要想要 add get remove+frist last的方法
看到hash:就要想到哈希表，就要想到唯一性，就要想到元素需要覆盖hashcode方法和equals方法。
看到tree：就要想到二叉树，就要想要排序，就要想到两个接口Comparable，Comparator 。

而且通常这些常用的集合容器都是不同步的。
```

============================================
```
Map：一次添加一对元素。Collection 一次添加一个元素。
	Map也称为双列集合，Collection集合称为单列集合。
	其实map集合中存储的就是键值对。
	map集合中必须保证键的唯一性。


常用方法：
1，添加。
	value put(key,value):返回前一个和key关联的值，如果没有返回null.

2，删除。
	void  clear():清空map集合。
	value remove(key):根据指定的key翻出这个键值对。

3，判断。
	boolean containsKey(key):
	boolean containsValue(value):
	boolean isEmpty();

4，获取。
	value get(key):通过键获取值，如果没有该键返回null。
					当然可以通过返回null，来判断是否包含指定键。
	int size(): 获取键值对的个数。



Map常用的子类：
	|--Hashtable :内部结构是哈希表，是同步的。不允许null作为键，null作为值。
		|--Properties：用来存储键值对型的配置文件的信息，可以和IO技术相结合。
	|--HashMap : 内部结构是哈希表，不是同步的。允许null作为键，null作为值。
	|--TreeMap : 内部结构是二叉树，不是同步的。可以对Map集合中的键进行排序。
```


Synchronization:
```

List list = new ArrayList();//非同步的。

list = MyCollections.synList(list);//返回一个同步的list.







给非同步的集合加锁。

class MyCollections{

	public static  List synList(List list){

		return new MyList(list);
	}

	private class MyList implements List{
	private List list;

	private static final Object lock = new Object();
	MyList(List list){
		this.list = list;
	}

	public boolean add(Object obj){
		synchronized(lock)
		{
			return list.add(obj);
		}
	}

	public boolean remove(Object obj){
		synchronized(lock)
		{
			return list.remove(obj);
		}
	}

}
}
```


### HashCode

```
hashCode = 31 * hashCode + (father == null ? 0 : father.hashCode());
hashCode = 31 * hashCode + depth;
hashCode = 31 * hashCode + cost;
hashCode = 31 * hashCode + matrix.hashCode();
hashCode = 31 * hashCode + java.util.Arrays.hashCode(coordinates);



```


### fail-fast vs fail-safe
1. What is Concurrent Modification?
```
When one or more thread is iterating over the collection, in between, one thread changes the
structure of the collection (either adding the element to the collection or by deleting the
element in the collection or by updating the value at particular position in the collection)
is known as Concurrent Modification

**NOTE**: structural modification is any operation that **ADD** or **delete** element;
**NOT A STRUCTURAL MODIFICATION**: merely setting the value of an element (in case of list) or
changing the value associated with an existing key (in case of map) is .

```

2. Fail fast Iterator
```
1) Fail fast iterator while iterating through the collection , instantly throws Concurrent Modification
Exception if there is structural modification  of the collection .

Advantage: in the face of concurrent modification, the iterator fails quickly and cleanly, rather than risking arbitrary,
non-deterministic behavior at an undetermined time in the future.

2) Fail-fast iterator can throw ConcurrentModificationException in two scenarios :
*Single Threaded Environment: After the creation of the iterator , if a thread modifies a collection directly while it
is iterating over the collection with a fail-fast iterator, the iterator will throw this exception.

*Multiple Threaded Environment: If one thread is modifying the structure of the collection while other thread
is iterating over it .

3) fail-fast iterator supports remove, set, and add operations.

**Note**: According to  Oracle docs , the fail-fast behavior of an iterator cannot be guaranteed in the presence of
unsynchronized concurrent modification.
Fail-fast iterators throw ConcurrentModificationException on a best-effort basis.
Therefore, it would be wrong to write a program that depended on this exception for its correctness:
the fail-fast behavior of iterators should be used only to detect bugs.


4) How  Fail  Fast Iterator  come to know that the internal structure is modified ?
Iterator read internal data structure (object array) directly . To ensure that internal structure is not modified,
it maintains an internal  flag "mods".Iterator checks the "mods" flag whenever it gets the next value (using hasNext()
method and next() method). Value of mods flag changes whenever there is an structural modification.
Thus indicating iterator to throw ConcurrentModificationException.
```

3. Fail Safe Iterator :
```
1) Fail Safe Iterator makes copy of the internal data structure (object array) and iterates over the copied data structure.
So , original data structure remains  structurally unchanged. Hence , no ConcurrentModificationException throws by the
fail safe iterator.

2) Two issues associated with Fail Safe Iterator are :
*Overhead of maintaining the copied data structure i.e memory.

3) fail-safe iterator does not support remove, set, and add operations.

*Fail safe iterator does not guarantee that the data being read is the data currently in the original data structure.

**Note**: According to Oracle docs , fail safe iterator is ordinarily too costly, but may be more efficient than alternatives
when traversal operations vastly outnumber mutations, and is useful when you cannot or don’t want to synchronize traversals,
yet need to preclude interference among concurrent threads. The "snapshot" style iterator method uses a reference to the
state of the array at the point that the iterator was created. This array never changes during the lifetime of the iterator,
so interference is impossible and the iterator is guaranteed not to throw ConcurrentModificationException.The iterator
will not reflect additions, removals, or changes to the list since the iterator was created. Element-changing operations
on iterators themselves (remove(), set(), and add()) are not supported. These methods throw UnsupportedOperationException.
```


4. Fail-Fast Iterator vs Fail-Safe Iterator
```
1) An iterator is considered fail-fast if it throws a ConcurrentModificationException in case the underlying
collection's structure is modified.

2) While iterating a list or a map values can be updated, only if an attempt is made to add or remove from the
collection ConcurrentModificationException will be thrown by fail-fast iterator.

3) Fail-fast iterators throw ConcurrentModificationException on a best-effort basis and fail-fast behavior of
an iterator cannot be guaranteed.

4) fail-safe iterator works with a copy of the collection rather than the original collection thus interference
is impossible and the iterator is guaranteed not to throw ConcurrentModificationException.

5) remove, set, and add operations are not supported with fail-safe iterator.

```













