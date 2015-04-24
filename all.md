
#####Following features of C++ are not there in Java. 
```
No pointers 
No sizeof operator 
No scope resolution operator 
Local variables in functions cannot be static 
No Multiple Inheritance 
No Operator Overloading 
No preprocessor and macros 
No user suggested inline functions 
No goto 
No default arguments 
No unsigned int in Java 
No -> operator in java 
No stack allocated objects in java 
No delete operator in java due to java’s garbage collection 
No destructor in java 
No typedef in java 
No global variables, no global function because java is pure OO. 
No friend functions 
No friend classes 
No templates in java 
```
 
#####Final variables in Java 
```
In Java, when final keyword is used with a variable of primitive data types (int, float, .. etc), value of the variable cannot be changed. 
For example following program gives error because i is final. 
public class Test { 
    public static void main(String args[]) { 
        final int i = 10; 
        i = 30; // Error because i is final. 
    } 
} 
When final is used with non-primitive variables (Note that non-primitive variables are always references to objects in Java), the members of the referred object can be changed. final for non-primitive variables just mean that they cannot be changed to refer to any other object 
class Test1 { 
   int i = 10; 
} 
  
public class Test2 { 
    public static void main(String args[]) { 
      final Test1 t1 = new Test1(); 
      t1.i = 30;  // Works 
    } 
} 
```
 
 
#####How are Java objects stored in memory? 
```
In Java, all objects are dynamically allocated. When we only declare a variable of a class type, Java just creates a reference. To allocate memory to an object, we must use new(). 
```

```
New features in Java SE 8 
Lambda Expressions; Pipelines and Streams; Date and Time API; Default Methods; Type Annotations; Nashhorn JavaScript Engine; Concurrent Accumulators; Parallel operations; PermGen Error Removed; TLS SNI 
New features in Java SE 7 
Strings in switch Statement; Type Inference for Generic Instance Creation; Multiple Exception Handling; Support for Dynamic Languages; Try with Resources; Java nio Package; Binary Literals, underscore in literals; Diamond Syntax; Automatic null Handling 
New features in Java SE 6 
Scripting Language Support; JDBC 4.0 API; Java Compiler API; Pluggable Annotations; Native PKI, Java GSS, Kerberos and LDAP support; Integrated Web Services; Lot more enhancements. 
New features in J2SE 5.0 
Generics; Enhanced for Loop; Autoboxing/Unboxing; Typesafe Enums; Varargs; Static Import; Metadata (Annotations); Instrumentation 
```

#####Java Interview Questions 1 
```
1. Are main, next, delete, goto, and exit keywords in Java? 
A： No. Delete is not a keyword in Java. Java does not make use of explicit destructors the way C++ does. To exit a program explicitly you use exit method in System object. 
2. Java VS C++  
A: pointer, multi-inheritance, virtual function, operation overload are not in Java. 
3. What are pass by reference and pass by value? 
A: Pass by reference means the passing the address itself rather than passing the value. Pass by value means passing a copy of the value to be passed. Java is pass by value. 
4. What is the difference between a constructor and a method? 
A: A constructor is a member function of a class that is used to create objects of that class. It has the same name as the class itself, has no return type, and is invoked using the new operator. A method is an ordinary member function of a class. It has its own name, a return type (which may be void), and is invoked using the dot operator. 
5. State the significance of public, private, protected, default modifiers both singly and in combination and state the effect of package relationships on declared items qualified by these modifiers. 
Private : Private variables or methods may be used only by an instance of the same class that declares the variable or method. A private feature may only be accessed by the class that owns the feature. 
Default :What you get by default , without any access modifier (ie, public private or protected).It means that it is visible to all within a particular package. 
Protected : is available to all classes in the same package and also available to all subclasses of the class that owns the protected feature. This access is provided even to subclasses that reside in a different package from the class that owns the protected feature. 
Public : Public class is visible in other packages, field is visible everywhere (class must be public too) 
6. What is an abstract class? 
A: Abstract class must be extended / subclassed (to be useful). It serves as a template. A class that is abstract may not be instantiated (ie, you may not call its constructor), abstract class may contain static data. Any class with an abstract method is automatically abstract itself, and must be declared as such. A class may be declared abstract even if it has no abstract methods. This prevents it from being instantiated. 
7. What is static in java? 
A: Static means one per class, not one for each object no matter how many instance of a class might exist. This means that you can use them without creating an instance of a class. 
 
 
Static methods are implicitly final, because overriding is done based on the type of the object, and static methods are attached to a class, not an object. A static method in a superclass can be shadowed by another static method in a subclass, as long as the original method was not declared final. However, you can’t override a static method with a nonstatic method. In other words, you can’t change a static method into an instance method in a subclass. 
8.  What is final? 
A final class can’t be extended ie., final class may not be subclassed. A final method can’t be overridden when its class is inherited. You can’t change value of a final variable (is a constant). 
9. What if the main method is declared as private? 
A: The program compiles properly but at run time it will give “Main method not public.” message. 
10. What if the static modifier is removed from the signature of the main method? 
Program compiles. But at run time throws an error “NoSuchMethodError”. 
11. What if I write static public void instead of public static void? 
Program compiles and runs properly. 
12. What if I do not provide the String array as the argument to the main method? 
Program compiles but throws a run time error “NoSuchMethodError”. 
13. What is the first argument of the String array in main method? 
The String array is empty. It does not have any element. This is unlike C/C++ where the first element by default is the program name. 
14. If I do not provide any arguments on the command line, then the String array of Main method will be empty or null? 
It is empty. But not null. 
15. How can one prove that the array is not null but empty using one line of code? 
Print args.length. It will print 0. That means it is empty. But if it would have been null then it would have thrown a NullPointerException on attempting to print args.length. 
16. What environment variables do I need to set on my machine in order to be able to run Java programs? 
CLASSPATH and PATH are the two variables. 
17. Can an application have multiple classes having main method? 
Yes, it is possible. While starting the application we mention the class name to be run. The JVM will look for the Main method only in the class whose name you have mentioned. Hence there is not conflict among the multiple classes having main method. 
18. What is the difference between these two lines? 
String s = "text"; String s = new String("text"); 
The latter explicitly creates a new and referentially distinct instance of a String object; the former may reuse a instance from the string pool if one is available. 
You are  very rarely would ever want to use the new String(anotherString) constructor. From the API: String(String original) : Initializes a newly created String object so that it represents the same sequence of characters as the argument; in other words, the newly created string is a copy of the argument string. Unless an explicit copy of original is needed, use of this constructor is unnecessary since strings are immutable. 
Examine the following snippet: 
   String s1 = "foobar";[Text Wrapping Break]    String s2 = "foobar";[Text Wrapping Break]    System.out.println(s1 == s2);      // true[Text Wrapping Break]    s2 = new String("foobar");[Text Wrapping Break]    System.out.println(s1 == s2);      // false[Text Wrapping Break]    System.out.println(s1.equals(s2)); // true 
== on two reference types is a reference identity comparison. Two objects that are equals are not necessarily ==. It is usually wrong to use == on reference types; most of the time equals need to be used instead. 
Nonetheless, if for whatever reason you need to create two equals but not == string, you can use thenew String(anotherString) constructor. It needs to be said again, however, that this is verypeculiar, and is rarely the intention. 
  
19. What is the purpose of garbage collection in Java, and when is it used? 
The purpose of garbage collection is to identify and discard objects that are no longer needed by a program so that their resources can be reclaimed and reused. A Java object is subject to garbage collection when it becomes unreachable to the program in which it is used. 
20. Can a top level class be private or protected? 
No. A top level class can not be private or protected. It can have either “public” or no modifier. If it does not have a modifier it is supposed to have a default access.If a top level class is declared as private the compiler will complain that the “modifier private is not allowed here”. This means that a top level class can not be private. Same is the case with protected. 
21. What type of parameter passing does Java support? 
A: In Java the arguments are always passed by value . 
22. Primitive data types are passed by reference or pass by value? 
Primitive data types are passed by value. 
23. Objects are passed by value or by reference? 
Java only supports pass by value. With objects, the object reference itself is passed by value and so both the original reference and parameter copy both refer to the same object . 
24. Does Java provide any construct to find out the size of an object? 
No there is not sizeof operator in Java. So there is not direct way to determine the size of an object directly in Java. 
25. Give a simplest way to find out the time a method takes for execution without using any profiling tool? 
Read the system time just before the method is invoked and immediately after method returns. Take the time difference, which will give you the time taken by a method for execution. To put it in code… 
long start = System.currentTimeMillis ();[Text Wrapping Break]<method ();[Text Wrapping Break]long end = System.currentTimeMillis ();[Text Wrapping Break]System.out.println ("Time taken for execution is " + (end - start));[Text Wrapping Break] 
Remember that if the time taken for execution is too small, it might show that it is taking zero milliseconds for execution. Try it on a method which is big enough, in the sense the one which is doing considerable amount of processing. 
26. What are wrapper classes? 
Java provides specialized classes corresponding to each of the primitive data types. These are called wrapper classes. They are e.g. Integer, Character, Double etc. 
27. Why do we need wrapper classes? 
It is sometimes easier to deal with primitives as objects. Moreover most of the collection classes store objects and not primitive data types. And also the wrapper classes provide many utility methods also. Because of these reasons we need wrapper classes. And since we create instances of these classes we can store them in any of the collection classes and pass them around as a collection. Also we can pass them around as method parameters where a method expects an object. 
28. What is the difference between static and non-static variables? 
A static variable is associated with the class as a whole rather than with specific instances of a class. Non-static variables take on unique values with each object instance. 
29. What does it mean that a method or field is “static”? 
Static variables and methods are instantiated only once per class. In other words they are class variables, not instance variables. If you change the value of a static variable in a particular object, the value of that variable changes for all instances of that class. 
Static methods can be referenced with the name of the class rather than the name of a particular object of the class (though that works too). That’s how library methods like System.out.println() work out is a static field in the java.lang.System class. 
30. Is Empty .java file a valid source file? 
A: Yes, an empty .java file is a perfectly valid source file. 
31. Can a .java file contain more than one java classes? 
Yes, a .java file contain more than one java classes, provided at the most one of them is a public class. 
32. Is String a primitive data type in Java? 
No String is not a primitive data type in Java, even though it is one of the most extensively used object. Strings in Java are instances of String class defined in java.lang package. 
33. What happens if you don’t initialize an instance variable of any of the primitive types in Java? 
Java by default initializes it to the default value for that primitive type. Thus an int will be initialized to 0, a boolean will be initialized to false. 
34. What will be the initial value of an object reference which is defined as an instance variable? 
The object references are all initialized to null in Java. However in order to do anything useful with these references, you must set them to a valid object, else you will get NullPointerExceptions everywhere you try to use such default initialized references. 
35. What are the different scopes for Java variables? 
A: The scope of a Java variable is determined by the context in which the variable is declared. Thus a java variable can have one of the three scopes at any given point in time. 

1. Instance : – These are typical object level variables, they are initialized to default values at the time of creation of object, and remain accessible as long as the object accessible. 
 
 
2. Local : – These are the variables that are defined within a method. They remain accessible only during the course of method exececution. When the method finishes execution, these variables fall out of scope. 
 
 
3. Static: – These are the class level variables. They are initialized when the class is loaded in JVM for the first time and remain there as long as the class remains loaded. They are not tied to any particular object instance. 
36. What is the default value of the local variables? 
A: The local variables are not initialized to any default value, neither primitives nor object references. If you try to use these variables without initializing them explicitly, the java compiler will not compile the code. It will complain abt the local varaible not being initilized.. 
37. How many objects are created in the following piece of code? 
MyClass c1, c2, c3;[Text Wrapping Break]c1 = new MyClass ();[Text Wrapping Break]c3 = new MyClass ();[Text Wrapping Break] 
A: Only 2 objects are created, c1 and c3. The reference c2 is only declared and not initialized. 
38. Can a public class MyClass be defined in a source file named YourClass.java? 
A: No the source file name, if it contains a public class, must be the same as the public class name itself with a .java extension. 
39. Can main method be declared final? 
A: Yes, the main method can be declared final, in addition to being public static. 
40. What will be the output of the following statement? 
System.out.println ("1" + 3); 
A: It will print 13. 
41. What will be the default values of all the elements of an array defined as an instance variable? 
A: If the array is an array of primitive types, then all the elements of the array will be initialized to the default value corresponding to that primitive type. e.g. All the elements of an array of int will be initialized to 0, while that of boolean type will be initialized to false. Whereas if the array is an array of references (of any type), all the elements will be initialized to null. 


```

#####Java Interview Questions 2 
```
1. Can we execute a java program without a main class? 
A: Yes. The working sequence is 
 
JVM loads class 
execute static blocks 
looks for main class and invokes it 
1 
2 
3 
4 
5 
public final class Test{ 
    static { 
        System.out.println("FOO"); 
}   
} 
 
1 
2 
output: FOO 
java.lang.NoSuchMethod:main 
2. What’s the default value of local variable and field (instance variable and class variable)? 
Standard local variables are stored on the stack and aren’t actually created until they are initialized. The default value for field are ” 0, 0.0, false..” 
 
 
The default value for string is null. Array is an object and all elements in it are instance variables and have a default value. 
3. How to compare primitives and objects? 
To compare two primitives or to see if two references refer to the same object, use == operator. The == operator cares only about the pattern of bits in the variable. 
To see if two different objects are equal, use the equals(). 
1 
2 
3 
4 
5 
6 
7 
8 
9 
10 
11 
12 
13 
14 
15 
16 
17 
18 
int x = 3; 
bit y = 3; 
if(x == y) { // true 
} 
  
Foo a = new Foo(); 
Foo b = new Foo(); 
Foo c = a; 
(a == b) // false 
(b == c) // false 
(a == c) // true 
  
String a = new String("foo"); 
String b = new String("foo"); 
String c = a; 
(a == b) // false 
(a == c) // true 
a.equals(b); // true 
4. Difference between string object and string literal. 
A String literal is java language concept. This is a String literal: 
1 
"a String literal" 
A String object is an individual instance of the java.lang.String class. 
1 
2 
3 
String s1 = "adc"; 
String s2 = new String("adc"); 
String s3 = "adc"; 
are all valid but have a slight difference: s1 will refer to an interned String object. This means, that the character sequence “adc” will be stored at a central place and whenever the same literal “adc” is used again, the JVM will not create a new String object but use reference of the “cached” String. 
s2 is guaranteed to be a new String object, so in this case we have: 
1 
2 
3 
(s1 == s2) // false 
(s1 == s3) // true 
(s1.equals(s2)) //true 
5. Inheritance properties of private, default, protected, and public 
private: Only code within the same class can access the private thing. 
default: Only code within the same package as class with default thing can access the default thing. 
protected: Just work like default, except it allows the subclass from outside package to inherit the protected thing. 
public: Any code can access public things. 
subclass inherits the superclass with instance variables and methods. Only methods can be overridden. 
 
6. Exception 
overridden method does not throw more Exception than super class 
ava Related Questions: 
 
5. What is encapsulation? 
1) The idea is to provide a public interface through which you gain access to this data. You can later change the internal representation of the data without compromising the public interface of the class. 
a.You can limit the values that can be stored in a field (i.e. gender must be F or M). 
b. You can take actions when the field is modified (trigger event, validate, etc). 
c.You can provide thread safety by synchronizing the method. 
d.You can switch to a new data representation (i.e. calculated fields, different data type) 
However, encapsulation is more than hiding fields 
 
2)So,the goal of encapsulation is to minimize interdependence and facilitate change. You maximize encapsulation by minimizing the exposure of implementation details. The state of a class should only be accessed through its public interface. 
 
 
6. What is polymorphism? 
1)Polymorphism means more than one form, same object performing different operations according to the requirement. 
 
2)Polymorphism can be achieved by using two ways, those are 
a)Method overloading means writing two are or more methods in the same class by using same method name, but passing the parameters is different. 
b)Method overriding means we use the method names in the different classes,that means parent class method is used in the child class. 
 
 
 
7. What is concatenation in java? 
String concat() method is another way to concat strings. when concatenating two strings. For more than two I use the StringBuilder. The concat() method builds a char buffer in the exact size of the destination string, fills the buffer from the two original strings' underlying buffers (using System.arraycopy() which is considered to be a very efficient method) and returns a new string based on the newly allocated buffer. 
1)So first conclusion: when concatenating static strings it is totally safe to use the "+" operator. 
2) Second conclusion: dynamic strings concatenating should be done 'manually' (explicit use of the StringBuilder/StringBuffer) and not by the compiler (the + operator). 
3) concat(String str) 
 
 
 
 
8. What are differences between String and StringBuilder? 
1)String is immutable whereas StringBuffer and StringBuilder can change their values. 
2)StringBuffer is synchronized whereas StringBuilder is not. StringBuilder is more efficient than StringBuffer. 
3) StringBuffer accepts all primitive types. concat method only accepts str 
 
Criteria to choose among String, StringBuffer and StringBuilder 
 
1)If your text is not going to change use a string Class because a String object is immutable. 
2) If your text can change and will only be accessed from a single thread, use a StringBuilder because StringBuilder is unsynchronized. 
3) If your text can changes, and will be accessed from multiple threads, use a StringBuffer because StringBuffer is synchronous. 
 
 
 
10. What is singleton design pattern? 
1) Singleton is a class which has only one instance in whole application and provides a getInstance() method to access the singleton instance.  
2) Example: using Singleton pattern like java.lang.Runtime which provides getRuntime() method to get access of it and used to get free memory and total memory in Java. 
```

 
#####IBM: 
``` 
1. JDBC, statement vs prepared statement 
        
Statement :  
        Statement every time compile the SQL and Execute. 
PreparedStatement :  
        1. Prevent SQL Injection, safety 
            pst.setInt(), pst.setString() 
        2. Readable, maintainability 
            dont need to access the initial sql to make changes, similar sql could be reused 
        3. improve efficiency 
            database store the compiled code into the cache.  
If we are using PreparedStatement the execution time will be less. First time RDBMS compile the SQL and PreparedStatement is executed then other calls doesn't compile the SQL only execute the SQL within the connection live. you must use a PreparedStatement object if you want to use large objects like BLOBs or CLOBs. PreparedStatement is its support for batching. Objects can be reused with passing different values to the queries.  
 
 
2. final finally finalize 
    final: A final class cannot be subclassed, A final method cannot be overridden or hidden by     subclasses, A final variable can only be initialized once, either via an initializer or an assignment statement 
    finally: The finally block always executes when the try block exits 
                only if the JVM shut down or face a deadlock in try or catch block 
    finalize: finalize() method is defined in java.lang.Object class, which means it available to all the classes for sake of overriding. finalize method is defined as protected 
 
 
3 assert: using in developing and testing. It should be closed after publish 
 
4. collections, collection 
    collection: the root interface of all collections 
    collections: This class consists exclusively of static methods that operate on or return collections. It contains polymorphic algorithms that operate on collections, "wrappers", which return a new collection backed by a specified collection, and a few other odds and ends. 
 
 
5. Math.round():  
    四舍五入 
    Math.round(-1.5)=-1 
    Math.round(1.5)=2 
 
6.  
    1. sleep()and suspend() release CPU execution priority, but hold the the lock of object.  
    2. sleep() a fixed time suspend() need resume()  
    3. wait() release  both CPU execution priority  and lock of the object  
    4. need notify() to  invoke again. 
     5. join: Thread A invites B for execution using join(). Thread A will be blocked, Thread B gets to    running state. As long as B is alive, A cannot come back. 
 
 
7. error vs exception 
 
Exception and Error are the subclasses of the Throwable class. Exception class is used for exceptional conditions that user program should catch. Error defines exceptions that are not excepted to be caught by the user program. Example is Stack Overflow.  
 
 
8. if x.equals(y)== true, x.hashCode == y.hashCode() 
 
 
 
9. java is pass by value 
    java is pass by value, C++ could pass by value or reference, because C++ could pass address 
 
 
10. int vs Interger 
      int primitive type, Integer could be null. Integer is encapsulation, has method and value.  
 
 
11. String vs StringBuffer VS StringBuilder 
      String: immutable, String class is final class 
      StringBuffer: synchronized 
      StringBuilder: unsynchronized 
 
 
 
12 Heap vs stack 
     Heap space: All live objects are allocated here. 
     Stack space: Stores references to the object for variable in method call or variable instantiation. 
 
Student std = new Student(); 
after executing the line above memory status will be like this. 
Heap: stores "new Student()" 
Stack: stores information about "std" 
stack is much faster 
  
 
 
13. short i = 1;  i = i + 1; vs   short i = 1; i += 1; 
           error                                   good 
 
 
14. String s  = new String(“abc”); // create two objects, one is “abc”, the other is s. 
 
 
15. How does GC work? How to optimize it? 
http://javabook.compuware.com/content/memory/how-garbage-collection-works.aspx 
http://blog.csdn.net/zsuguangh/article/details/6429592 
 
16.  Reflect: java.lang.reflect.Field 
             Using Java Reflection you can inspect the fields (member variables) of classes and get / set them at runtime. This is done via the Java class java.lang.reflect.Field 
java.reflect.Method 
      describe the methods in a class 
java.lang.reflect.constructor 
      The java.lang.reflect.Constructor class provides a way to obtain the  the name, modifiers, parameters, and list of throwable exceptions in constructor 
 
 
17.  stored procedure vs function 
Store procedure is generally defined by user, and it relates to specific table and object. User can invoke it. 
 
 
1.inner class vs nest class? Benefits 
2. proxy: 1 ask all code from interface 2. object’s all method 
 
 
3. CORBA: Common object Request Broker Architecture is used for Object Management Group(OMG). 
 
 
DB: 
18. what is the event in db? 
1) atomic 2)consistant 3) isolate 4) persistent 
 
19. 游标 
 
 
20 trigger   before-trigger(can get latest value of event), after-trigger. 
 
 
 
Core Java: 
 
21. File input out classes 
 
 
22. Socket: TCP vs UDP and java implementation 
 
 
23. Java Proxy and garbage collection concept 
 
 
24: java internationalization 
```

 
 
 
#####Function is generally defined by DB, it receives parameter and return some value. But it does not relate to a specific table. 
 
```
 
1:Use Procedure to take some action. But use function to return some value.  
2:You can call function from sql query but Procedure can't.  
3:Best practice to use Procedure then function if possible. 
 
 
 
 
2. checked vs unchecked exception 
3. set vs list 
4. two ways to use the thread 
5. Difference between extend and implement interface 
6. hashtable vs hashmap 
7. what is facade design pattern ? 
    A facade is an object that provides a simplified interface to a larger body of code, such as a class library 
 
 
 
=============================== 
1.  Can you use protected on the top of class 
2. Can if work without {} bracelet 
3. Vector vs ArrayList 
4. Boxing and unboxing 
5. can automatically use int as double 
6. default constructor provided by JVM 
 
7. HashMap equal method and hasCode 
 
8. How to iterate a large file quickly? 
 
9. checked vs unchecked exception and Error 
 
10. Dynamic loading class 
 
11. Java pass by value or reference 
 
12.  new String and “=” 
 
13. where and how you use multithreading and collection? 
 
14. exception handling 
 
15. override method with some exception 
 
16. Diamond operator 
 
 
 
 
17. Two ways of implementing comparison in Java? 
 
comparator and comparable 
 
```
