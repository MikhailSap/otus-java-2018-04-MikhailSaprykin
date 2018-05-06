package sap.mikhail.HW03;

import java.util.*;


public class MyArrayList<E> implements List<E>, RandomAccess {


    private static final int DEFAULT_LENGTH = 10;
    private Object[] elements = new Object[DEFAULT_LENGTH];
    private int size;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<E> iterator() {
        return new MyIterator();
    }

    public Object[] toArray() {
        Object[] o = new Object[size];
        System.arraycopy(elements, 0, o, 0, size);
        return o;
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(E e) {
        if (size==elements.length) {
            Object[] tmpElements = new Object[elements.length*2];
            System.arraycopy(elements, 0, tmpElements, 0, size);
            elements = tmpElements;
        }

        elements[size] = e;
        size++;
        return true;

    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {return (E) elements[index];}
    }

    public E set(int index, E element) {
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException();
        } else {
            E oldElement = this.get(index);
            elements[index] = element;
            return oldElement;
        }

    }

    public void add(int index, E element) {

    }

    public E remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<E> listIterator() {
        return new MyListIterator();
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private class MyIterator implements Iterator<E> {
        private int cursor;
        protected int lastRet = -1;

        public boolean hasNext() {
            return cursor!=size;
        }

        public E next() {
            if (cursor>size)
                throw new NoSuchElementException();
            return (E) elements[lastRet = cursor++];
        }

        public void remove() {

        }
    }

    private class MyListIterator extends MyIterator implements ListIterator<E> {


        public boolean hasPrevious() {
            return false;
        }

        public E previous() {
            return null;
        }

        public int nextIndex() {
            return 0;
        }

        public int previousIndex() {
            return 0;
        }

        public void remove() {

        }

        public void set(E e) {
            if (lastRet < 0)
                throw new IllegalStateException();
            MyArrayList.this.set(lastRet, e);
        }

        public void add(E e) {

        }
    }

}
