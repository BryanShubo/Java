
###Collection Features:
Store Object
Varied-size
Cannot store primitive type data
Unsynchronized : basically all collection type are unsynchronized. Only these three are synchronized Hashtable (not from
collection), Vector, Stack.

How to make a collection synchronized: Collections.synchronizedCollection(Collection<T> c)
###Collection APIs:

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



###Collection: List, Set
    List：keep insert-order, duplicates allowed. 
	Set：unordered, no duplicates.
	
###List APIs
	
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
	|--ArrayList:un-synchronized, CRUD performance is faster than Vector
	|--LinkedList:un-synchronized, 。增删元素的速度很快。
	
	
	LinkedList store elements within a doubly-linked list data structure. 
	LinkedList allows for constant-time insertions or removals, but only sequential access of elements. 
	LinkedList costs more memory
    
    
    ArrayList: allow random access, so you can grab any element in constant time. 
    ArrayList: adding and removing are slower than LinkedList. 
    
    
    
###Set:
    
    
    ![alt text](https://github.com/iluwatar/java-design-patterns/blob/master/abstract-factory/etc/abstract-factory_1.png "Abstract Factory")
