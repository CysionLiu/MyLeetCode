package com.cysion.java.study.primary;

import com.cysion.java.study.MyIterable;
import com.cysion.java.study.MyIterator;

public class MyStack<T> implements MyIterable<T>{

    private T[] arr;
    private static final int DEFAULT = 5;
    private int size = 0;
    private boolean mAutoSize = true;

    public MyStack() {
        arr = (T[]) new Object[DEFAULT];
    }

    public MyStack(boolean autoSize) {
        mAutoSize = autoSize;
    }

    public void push(T t) {
        if (size < arr.length) {
            arr[size] = t;
            size++;
        } else {
            if (mAutoSize) {
                resize(2 * arr.length);
                arr[size] = t;
                size++;
            }
            System.out.println("length: " + arr.length);
        }
    }


    public T pop() {
        if (size > 0) {
            if (size > DEFAULT && size <= arr.length / 3) {
                resize(arr.length / 3);
            }
            size--;
            T t = arr[size];
            arr[size] = null;
            return t;
        }
        return null;
    }

    private void resize(int newLength) {
        T[] tmp = (T[]) new Object[newLength];
        for (int i = 0; i < size; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index < size) {
            return arr[index];
        }
        return null;
    }

    @Override
    public MyIterator<T> iterator() {
        return new Iterator();
    }

    class Iterator implements MyIterator{
        private int curIndex = 0;

        @Override
        public T next() {
            return (T) arr[curIndex++];
        }

        @Override
        public boolean hasNext() {
            return curIndex < size;
        }
    }
}
