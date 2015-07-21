#####1. Scope of variables 
```
1) Local variables: must be initialized. 
 
2) Instance variables:  is available for the life of an object. These are the values that need to be 
accessed by multiple methods. It has a default value. 
 
3) Class variables (static variables): are used to store values that should be shared by 
all the objects of a class. 
```
#####2. overloaded methods 
```
Overloaded methods are methods with the same name but different method parameter lists. 
Overloaded methods accept different lists of arguments. The argument lists can differ 
in terms of any of the following: 
 
1) Change in the number of parameters that are accepted 
2) Change in the types of parameters that are accepted 
3) Change in the positions of the parameters that are accepted (based on parameter type, not variable names) 
```

#####3. What is Overriding? 
```
When a class defines a method using the same name, return type, and arguments as a method 
in its superclass, the method in the class overrides the method in the superclass. 
 
When the method is invoked for an object of the class, it is the new definition of the 
method that is called, and not the method definition from superclass. Methods may be overridden 
to be more public, not more private. (private->default->protected->public) 
``` 
 
#####4. Constructors of a class 
```
default, and user-defined constructors, and create overloaded constructors. 
 
4.1) why you can’t define a return type for a constructor? 
It creates and returns an object of its class. 
 
4.2)  initializer block is used to initialize the variables of anonymous classes. 
An anonymous class is a type of inner class. In the absence of a name, anonymous classes can’t 
define a constructor and rely on an initializer block to initialize their variables upon the 
creation of an object of their class.  
 
A lot of action can happen within an initializer block:  
a. It can create local variables. 
b. It can access and assign values to instance and static variables.  
c. It can call methods and define loops, conditional statements, and 
try-catch-finally blocks. Unlike constructors, an initializer block can’t accept 
method parameters. 

Example:  
class Employee { 
Employee() { 
System.out.println("Employee:constructor"); 
} 
{ 
System.out.println("Employee:initializer"); 
} 
} 
class TestEmp { 
public static void main(String args[]) { 
Employee e = new Employee(); 
} 
} 
Output:  
Employee:initializer 
Employee:constructor 
 
4.3) Default constructor 
Java defines a default, no-argument constructor if and only if you don’t define a constructor.  
 
It calls the constructor of the super (parent) class and assigns default values to all the instance variables. 
 
But if you modify the class later by adding a constructor to it, the Java compiler will remove the default, 
no argument constructor that it initially added to the class. 
 
4.4)  Overloaded constructors 
Here’s a quick list of rules to remember for the exam for defining and using overloaded constructors: 
 
a. Overloaded constructors must be defined using different argument lists. 
b. Overloaded constructors can’t be defined by just a change in the access modifiers. 
c. Overloaded constructors may be defined using different access modifiers. 
d. A constructor can call another overloaded constructor by using the keyword this. 
e. A constructor can’t invoke a constructor by using its class’s name. 
f. If present, the call to another constructor must be the first statement in a constructor. 
``` 
 
#####5. Encapsulation
```
The terms encapsulation and information hiding are used interchangeably. One of the best ways to 
create a well-encapsulated class is to define its instance variables as private variables and 
allow access to these variables using public methods. 
``` 
 
#####6 . Passing objects and primitives to methods 
```
6.1. Passing primitives to methods: value is not modified. 
 
6.2 Passing object references to methods: value is modified. 
```

#####7. Inheritance 
```
7.1 Which base class members are inherited by a derived class? 
A derived class inherits all the non-private members of its base class.  
 
Default— accessible to same package. 
protected—accessible to all the derived classes, regardless of the package 
public—visible to all the other classes. 
 
7.2 A derived class can call a base class’s constructors using the implicit reference super, 
but it doesn’t inherit them. 
 
7.3 Implementing inheritance using an abstract base class: 
a. You can never create objects of an abstract class. 
b. A base class can be defined as an abstract class, even if it doesn’t define any abstract methods. 
c. A derived class should implement all the abstract methods of its base class. If it doesn’t, 
it must be defined as an abstract derived class. 
d. You can use variables of an abstract base class to refer to objects of its derived class. 
```

#####8. Interface 
```
a. Interfaces are abstract classes taken to extremes.  
b. An interface can define only abstract methods and constants. 
c. All the members of an interface are implicitly public.  
d. The variables of an interface are implicitly public, final, and static. So, it is must be initialized 
   and once it is assigned, you cannot change the value of a constant. 
 
8.1 Implementing multiple interfaces 
a. A class can implement multiple interfaces. Also, an interface can "extend" multiple interfaces. 
b. However, a class cannot extends many classes. Because a derived class may inherit different 
   implementations for the same method signature from multiple base classes, multiple inheritance 
   is not allowed in Java. For implementing multiple interfaces, the abstract method has no body 
   part, so it is no problem to override. 
 
8.2 An interface extending multiple interfaces 
class extends class(only one) implements interface…interface(multiple) 
interface extends interface…interface(multiple) 
a. Java interfaces cannot extend classes, which makes sense since classes contain implementation 
details that cannot be specified within an interface.  
 
b. What happens if the base interface and subinterface define methods with the same signatures? 
Or when an interface extends more than one interface that defines the same method? 
 
The answer is that which of the method is inherited is irrelevant. Because the methods don’t 
have a method body. 
 
c. POINTS TO NOTE ABOUT CLASS AND INTERFACE INHERITANCE: 
 
A class can inherit zero or one class. 
A class uses the keyword extends to inherit a class. 
A class can implement multiple interfaces. 
A class uses the keyword implements to implement an interface. 
An interface can’t implement any class. 
An interface can inherit zero or more interfaces. 
An interface uses the keyword extends to inherit interfaces. 
An abstract class can extend a concrete class and vice versa. 
An abstract class can implement interfaces. 
An abstract class can extend another abstract class. 
The first concrete class in the hierarchy must supply actual method implementations for all abstract methods. 
```

interface vs abstract class
```
When To Use Interfaces

An interface allows somebody to start from scratch to implement your interface or implement your interface 
in some other code whose original or primary purpose was quite different from your interface. To them, your 
interface is only incidental, something that have to add on to the their code to be able to use your package.
The disadvantage is every method in the interface must be public. You might not want to expose everything.

When To Use Abstract classes

An abstract class, in contrast, provides more structure. It usually defines some default implementations and 
provides some tools useful for a full implementation. The catch is, code using it must use your class as the 
base. That may be highly inconvenient if the other programmers wanting to use your package have already 
developed their own class hierarchy independently. In Java, a class can inherit from only one base class.

When to Use Both

You can offer the best of both worlds, an interface and an abstract class. Implementors can ignore your abstract 
class if they choose. The only drawback of doing that is calling methods via their interface name is slightly 
slower than calling them via their abstract class name.

```

#####9. Reference variable and object types 
```
You can use a reference variable of a base class/ derived class to refer to an object of its 
derived class / base class. It’s interesting to note that these variables can’t access all the 
variables and methods defined in the derived class or the class that implements the interface. 
 
9.1 Using a variable of the derived class to access its own object 
 
When you access an object of the subclass using its own type, you can access all the variables and 
methods that are defined in its base class and interface—the class Employee and the interface Interviewer. 
 
9.2 Using a variable of the base class to access an object of a derived class 
All members of a derived class can’t be accessed using an object of the base class, it isn't allowed. 
 
9.3 Using a variable of an implemented interface to access a derived class object 
Cannot access to members of subclass or super class. 
```

#####10. Casting 
```
Casting is the process of forcefully making a variable behave as a variable of another type. 
If a class shares an IS-A or inheritance relationship with another class or interface, 
their variables can be cast to each other’s type. 
```

#####11. Use this and super to access objects and constructors 
```
11.1 this() 
a. USING THIS TO ACCESS VARIABLES AND METHODS: You can use the keyword this to refer to 
all methods and variables that are accessible to a class. 
 
b. this refers to the instance of the class in which it’s used. this can be used to access 
the inherited members of a base class in the derived class. 
 
11.2 super() 
super refers to the parent or base class of a class. 
 
11.21 USING SUPER TO ACCESS CONSTRUCTORS OF BASE CLASS 
If present, a call to a superclass’s constructor must be the first statement in a derived 
class’s constructor. Otherwise, a call to super(); (the no-arg constructor) is inserted 
automatically by the compiler. 
 
11.22 USING SUPER AND THIS IN STATIC METHODS 
The keywords super and this are implicit object references. Because static methods belong 
to a class, not to objects of a class, you can’t use this and super in static methods.  

11.3 Call base class method from derived class (the method has been overridded)

super.method // this will run the method in base class
```

#####12. RULES TO REMEMBER WHEN DEFINING OVERRIDDEN METHODS 
```
1) Overridden methods are defined by classes and interfaces that share inheritance relationships. 
2) The name of the overridden method must be the same in both the base class and the derived class. 
3)The argument list passed to the overridden method must be the same in both the base class and 
derived class. 
4)The return type of an overriding method in the derived class can be the same, or a subclass of the 
return type of the overridden method in the base class. When the overriding method returns a subclass 
of the return type of the overridden method, it is known as a covariant return type. 
5) An overridden method defined in the base class can be an abstract method or a non-abstract method. 
6) Access modifiers for an overriding method can be the same or less restrictive than the method being 
overridden, but they can’t be more restrictive. 
7): To implement polymorphism with classes, you can define abstract or non-abstract methods in the base 
class and override them in the derived classes. 
#: DO POLYMORPHIC METHODS ALWAYS HAVE TO BE ABSTRACT? No, polymorphic methods don’t always have to be 
abstract. 
8): CAN POLYMORPHISM WORK WITH OVERLOADED METHODS? No, polymorphism works only with overridden methods. 
Overridden methods have the same number and type of method arguments, whereas overloaded methods define 
a method argument list with either a different number or type of method parameters. 
```

#####13. Polymorphism 
```
The literal meaning of the word “polymorphism” is “many forms.” The usefulness of polymorphism lies 
in the ability of an object to behave in its own specific manner when the same action is passed to it. 
 
13.1.  static binding (early binding) and dynamic binding (late binding) 
1) Static binding: binding at the compile time. The instance variables. 
 
Example:  
SuperClass superClass1 = new SuperClass(); 
SuperClass superClass2 = new SubClass(); 
 
System.out.println(superClass1.someVariable); 
System.out.println(superClass2.someVariable); 
... 
 
Output:- 
Some Variable in SuperClass 
Some Variable in SuperClass 
 
2) Dynamic binding: binding at the run-time. All instance methods but all the static methods. 
This is the reason why static methods cannot actually be overriden. 
 
Example: 
SuperClass superClass1 = new SuperClass(); 
SuperClass superClass2 = new SubClass(); 
... 
 
superClass1.someMethod(); // SuperClass version is called 
superClass2.someMethod(); // SubClass version is called 
 
 
13.2 Polymorphism with interfaces 
Whereas polymorphism with classes has a class as the base class, polymorphism with interfaces 
requires a class to implement an interface. Polymorphism with interfaces always involves abstract 
methods from the implemented interface because interfaces can define only abstract methods. 
 
1) overloaded methods don’t participate in polymorphism. Only overridden methods—methods with the 
same method signatures—participate in polymorphism. 
```

#####14. Java OOPs concepts 
```
1) Traditional programming vs. object oriented programming 
 
Encapsulation 
Polymorphism – many forms 
Data abstraction – hiding the data 
Inheritance 
 
2): Every program need to have an input data on which your business logic operates on. This input data 
is stored in variables and objects, which is a DATA part of your program. 
 
3): The business logic is defined in terms of business functions which is called as a CODE part of your 
program. When we combine these data and code together, it forms an encapsulation and gives us something 
called as a Class. 
 
4): In Java, any method which is static, can only access other static members directly and to access 
non-static members, it needs an object. 
 
5): An object in java is always initialized dynamically using “new” keyword. 
 
6): When a class does not have any constructor defined, then JVM provides a default constructor 
which is invoked during object initialization. 
 
7): When a program is having some initialization statements, those can be defined within a constructor. 
 
8): A block which has a same name as a class name, does not have any return type, used to initialize 
global variables and gets invoked automatically whenever an object of that class is dynamically initialized 
is called as a Constructor. 
 
9): A class can have more than one constructor but with a change in their signatures (No. of parameters 
and/or type of parameters). This is called as a constructor overloading. 
 
10): If one constructor of a class is required to invoke another constructor of the same class, you need 
to use a keyword called as “this”. But “this” statement must be declared as the first statement in that 
block. The this statement will run first. super() won’t be invoked in this block. After this statement 
is finished, the rest of statement will be executed. super statement must be also declared as the first 
statement in that block. So it is impossible to use both this and super in a block. 
 
11): A class can have many forms of a method with the same name but with different signatures which is 
called as Method Overloading. We cannot overload a method just by changing the return type. 
 
12): private members are not visible in the sub class. But you can override private method in sub class. 
```

#####15: What is the difference between an Interface and an Abstract class? 
```
interface can multi-implements but class can only extends one abstract 
methods in interface are all claim as public but abstract don’t need to 
class variables in interface are all static & final but abstract not required 
interface don’t allow implemented method, abstract not required 
methods in implement class are all need to be implement, but in extend class don’t need to implement 
except non-abstract modifier. 
```

#####16: What are some alternatives to inheritance? 
```
1): Delegation is an alternative to inheritance.  
2) Delegation means that you include an instance of another class as an instance variable, and forward 
messages to the instance.  
3) It is often safer than inheritance because it forces you to think about each message you forward, 
because the instance is of a known class, rather than a new class, and because it doesn't force you to 
accept all the methods of the super class. 
4) you can provide only the methods that really make sense. On the other hand, it makes you write more code, 
and it is harder to reuse (because it is not a subclass). 
```

#####17. inner class vs nested class 
```
1) Nested class consists of static nested class and not-static nested class (inner class). 
 
2)  An instance of an inner class has access to all of the members of the outer class, even those that 
are marked “private”.  In outer class, it needs an inner class object to access inner class members. 
 
3): If an inner class contains at least one static member, then the inner class must be declared as static. 
4): A static nested class can access only static members of outer class and to access non-static members, 
it needs an object of outer class. 
5): Any static method of outer class can directly access static inner class. 
6):  A nested class can be declared within a loop, if else, method OR anywhere within the class. 
7): An inner class which is defined inside a method can only access final type of variables from within 
the method but everything from outside the method. 
``` 
