package datastructures;
import java.util.*;
public class ArrayList<T> implements List<T> {
    private final double GROW = 2;
    private final int CAP = 10;
    private T[] arr;
    private int size;
    private int next;
    @Override
    public int size() {
        return size;
    }
    public ArrayList() {
        size = 0;
        next = (int)(CAP * GROW);
        arr = (T[])new Object[CAP];
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public T get(int index) {
        assert index >= 0 && index < size;
        return arr[index];
    }
    @Override
    public T set(int index, T element) {
        T temp = arr[index];
        arr[index] = element;
        return temp;
    }
    @Override
    public void add(int index, T element) {
        assert index >= 0 && index <= size;
        if (++size > arr.length) {
            T[] temp = (T[])new Object[next];
            next = (int)(next * GROW);
            temp[index] = element;
            for (int i = 0; i < index; i++) {
                temp[i] = arr[i];
            }
            for (int i = index + 1; i < size; i++) {
                temp[i] = arr[i - 1];
            }
        } else {
            for (int i = size; i >= index; i++) {
                arr[i + 1] = arr[i];
            }
            arr[index] = element;
        }
    }
    @Override
    public boolean add(T element) {
        add(size, element);
        return true;
    }
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, arr[i])) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, arr[i])) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(o, arr[i])) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }
    private class ArrayListIterator implements Iterator<T> {
        private int ptr;
        private ArrayListIterator() {
            ptr = -1;
        }
        public boolean hasNext() {
            return ptr < size - 1;
        }
        public T next() {
            return get(++ptr);
        }
    }
    @Override
    public Object[] toArray() {
        return null;
    }
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }
    @Override
    public boolean remove(Object o) {
        return false;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    @Override
    public void clear() {}
    @Override
    public T remove(int index) {
        return null;
    }
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
