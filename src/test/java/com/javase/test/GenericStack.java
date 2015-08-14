package com.javase.test;

import java.util.Stack;

/**
 * Created by limeng on 8/11/15.
 */
public class GenericStack<E> {

    Stack<E> stack = new Stack<E>();

    public void push(E obj) {
        stack.push(obj);
    }

    public E pop(){
        E obj = stack.pop();
        System.out.println(obj);
        return obj;
    }
}
