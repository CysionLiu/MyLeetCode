package com.cysion.java.study.primary;

import com.cysion.java.study.MyIterable;
import com.cysion.java.study.MyIterator;

public class MyLinkedStack<T> implements MyIterable<T> {


    private int size = 0;
    private Node first = new Node(null, null);

    public void push(T t) {
        Node old = first;
        first = new Node(t, old);
        size++;
    }

    public void pop() {
        if (first != null) {
            first = first.next;
            size--;
        }
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public int size() {
        return size;
    }

    @Override
    public MyIterator<T> iterator() {
        return new Iterator();
    }

    class Iterator implements MyIterator {

        Node curIndex = first;

        @Override
        public T next() {
            T t = curIndex.item;
            curIndex = curIndex.next;
            return t;
        }

        @Override
        public boolean hasNext() {
            return curIndex.item!= null;
        }
    }

    class Node {
        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        T item;
        Node next;
    }
}
