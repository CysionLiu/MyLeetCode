package com.cysion.java.study.primary;

import com.cysion.java.study.MyIterable;
import com.cysion.java.study.MyIterator;

public class MyQueue<T> implements MyIterable<T> {

    class Node {
        T t;
        Node next;

         Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }
    }

    private int size;
    private Node last;
    private Node first;

    public MyQueue() {
        first = new Node(null, null);
        last = first;
        first.next = last;
    }

    public void enqueue(T t) {
        Node oldLast = last;
        last = new Node(t, null);
        oldLast.next = last;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T t = first.next.t;
        size--;
        if (size == 0) {
            first = new Node(null, null);
            last = first;
            first.next = last;
        } else {
            first.next = first.next.next;
        }
        return t;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public MyIterator<T> iterator() {
        return new Iterator();
    }


    class Iterator implements MyIterator {

       Node curIndex = first.next;

        @Override
        public T next() {
            T t = curIndex.t;
            curIndex = curIndex.next;
            return t;
        }

        @Override
        public boolean hasNext() {
            return curIndex!= null&&curIndex.t!=null;
        }
    }
}
