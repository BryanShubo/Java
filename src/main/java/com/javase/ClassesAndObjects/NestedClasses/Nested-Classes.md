**Nested class**
I. Definition:
```
A nested class is a class which is defined within another class.

Nestes classes
    static nested classes
    
    non-static nested classes
        local classes
        anonymous classes



Nested classes are divided into two categories: static nested classes and non-static nested classes(inner classes)

* Non-static nested classes (inner classes) have access to other members of the enclosing class, even if they are declared private.

* Static nested classes do not have access to other members of the enclosing class. It can use them only through an object reference.

As a member of the OuterClass, a nested class can be declared private, public, protected, or package private.
(Recall that outer classes can only be declared public or package private)


class OuterClass {
    ...
    static class StaticNestedClass {
        ...
    }
    class InnerClass {
        ...
    }
}

OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();

OuterClass.InnerClass innerObject = outerObject.new InnerClass();

There are two special kinds of inner classes: local classes and anonymous classes.



```

II: Why use nested classes?
```
It is a way of logically grouping classes that are only used in one place: 
If a class is useful to only one other class, then it is logical to embed it in that class and keep the two together. 
Nesting such "helper classes" makes their package more streamlined.

It increases encapsulation: Consider two top-level classes, A and B, where B needs access to members of 
A that would otherwise be declared private. By hiding class B within class A, A's members can be declared private and 
B can access them. In addition, B itself can be hidden from the outside world.

It can lead to more readable and maintainable code: Nesting small classes within top-level classes places the code 
closer to where it is used.

1. Inner classes are used to get functionality which can be get as object better than method.

2. They can be used in case when a set of multiple operation are required and chances of reusability are good inside 
class and they have no use outside the class.

3. Inner classes are made to achieve multiple inheritance also.

4. Inner classes are used when they are useful in class context.

5. They are used to separate logic inside class.

Think of it this way - the inner class will live and die with the outer class, so any functionality that is 
specifically needed for the outer class can be added to the inner class. Popular examples are - Listeners in most cases
 - Types of KeyListeners, MouseListeners, eventListeners.

=================

There are two additional types of inner classes. You can declare an inner class within the body of a method. 
These classes are known as local classes. You can also declare an inner class within the body of a method 
without naming the class. These classes are known as anonymous classes.

Local class: Use it if you need to create more than one instance of a class, access its constructor, or 
introduce a new, named type (because, for example, you need to invoke additional methods later).

Anonymous class: Use it if you need to declare fields or additional methods.

```


III. Local Class
```
A local class has access to the members of its enclosing class. In the previous example, 
the PhoneNumber constructor accesses the member LocalClassExample.regularExpression.

In addition, a local class has access to local variables. However, a local class can only 
access local variables that are declared final. When a local class accesses a local variable
 or parameter of the enclosing block, it captures that variable or parameter. For example, the 
 PhoneNumber constructor can access the local variable numberLength because it is declared final; 
 numberLength is a captured variable.

However, starting in Java SE 8, a local class can access local variables and parameters of the 
enclosing block that are final or effectively final. A variable or parameter whose value is never 
changed after it is initialized is effectively final.


Starting in Java SE 8, if you declare the local class in a method, it can access the method's parameters. 

You cannot declare an interface inside a block; interfaces are inherently static. 

You cannot declare static initializers or member interfaces in a local class.


A local class can have static members provided that they are constant variables.
```

IV. Anonymous Classes
```
Anonymous classes are often used in graphical user interface (GUI) applications.

Anonymous classes enable you to make your code more concise. They enable you to declare and instantiate 
a class at the same time. They are like local classes except that they do not have a name. Use them 
if you need to use a local class only once.


Like local classes, anonymous classes can capture variables; they have the same access to local variables of the enclosing scope:

An anonymous class has access to the members of its enclosing class.

An anonymous class cannot access local variables in its enclosing scope that are not declared as final or effectively final.

Like a nested class, a declaration of a type (such as a variable) in an anonymous class shadows any other 
declarations in the enclosing scope that have the same name. See Shadowing for more information.

Anonymous classes also have the same restrictions as local classes with respect to their members:

You cannot declare static initializers or member interfaces in an anonymous class.

An anonymous class can have static members provided that they are constant variables.

Note that you can declare the following in anonymous classes:

Fields

Extra methods (even if they do not implement any methods of the supertype)

Instance initializers

Local classes

However, you cannot declare constructors in an anonymous class.
```



V. When to Use Nested Classes, Local Classes, Anonymous Classes, and Lambda Expressions
```
   
As mentioned in the section Nested Classes, nested classes enable you to logically group classes that are only used
in one place, increase the use of encapsulation, and create more readable and maintainable code. Local classes, 
anonymous classes, and lambda expressions also impart these advantages; however, they are intended to be used for 
more specific situations:

Local class: Use it if you need to create more than one instance of a class, access its constructor, or introduce a
new, named type (because, for example, you need to invoke additional methods later).

Anonymous class: Use it if you need to declare fields or additional methods.

Lambda expression:

Use it if you are encapsulating a single unit of behavior that you want to pass to other code. For example, 
you would use a lambda expression if you want a certain action performed on each element of a collection, 
when a process is completed, or when a process encounters an error.

Use it if you need a simple instance of a functional interface and none of the preceding criteria apply 
(for example, you do not need a constructor, a named type, fields, or additional methods).

Nested class: Use it if your requirements are similar to those of a local class, you want to make the 
type more widely available, and you don't require access to local variables or method parameters.

Use a non-static nested class (or inner class) if you require access to an enclosing instance's 
non-public fields and methods. Use a static nested class if you don't require this access.
   
```