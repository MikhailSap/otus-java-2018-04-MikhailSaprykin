package sap.mikhail.HW03;

import java.util.*;


public class MyArrayList<E> implements List<E>, RandomAccess {


    private static final int DEF_LENGTH = 10;
    private Object[] elements = new Object[DEF_LENGTH];
    private int currentLength = 10;
    private int size;
    private int modCount;

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
        return new Object[0];
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(E e) {
        modCount++;
        if (size==currentLength) {
            currentLength = currentLength * 2;
            Object[] tmpElements = new Object[currentLength];
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
        modCount++;
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

    public void sort(Comparator<? super E> c) {
        final int expectedModCount = modCount;
        Arrays.sort((E[]) elements, 0, size, c);
        if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
        modCount++;
    }

    private class MyIterator implements Iterator<E> {
        private int cursor;
        protected int lastRet = -1;
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor!=size;
        }

        public E next() {
            if (cursor>size)
                throw new NoSuchElementException();
            if (cursor>elements.length)
                throw new ConcurrentModificationException();
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
            if (expectedModCount!=modCount) {
                throw new ConcurrentModificationException();
            }
            try {
                MyArrayList.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }

        }

        public void add(E e) {

        }
    }
}
