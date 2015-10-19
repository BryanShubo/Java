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