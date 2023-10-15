package datastructures;
import java.util.*;
public class LinkedList<T> implements List<T> {
    private class Node<V> {
        public V val;
        public Node<V> next;
        public Node<V> prev;
        public Node(V val, Node<V> next, Node<V> prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public int size() {
        return size;
    }
    public LinkedList() {
        size = 0;
        head = null;
        tail = null;
    }
    private Node<T> walkTo(int index) {
        assert index >= 0 && index < size;
        Node<T> curr;
        if (index <= size / 2) {
            curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public T get(int index) {
        return walkTo(index).val;
    }
    @Override
    public T set(int index, T element) {
        Node<T> node = walkTo(index);
        T temp = node.val;
        node.val = element;
        return temp;
    }
    @Override
    public void add(int index, T element) {
        assert 0 <= index && index <= size;
        if (index == 0) {
            head = new Node<>(element, head, null);
        } else if (index == size) {
            tail = new Node<>(element, null, tail);
        } else {
            Node node = walkTo(index - 1);
            node.next = new Node(element, node.next, node);
        }
    }
    @Override
    public boolean add(T element) {
        add(size, element);
        return true;
    }
    @Override
    public boolean contains(Object o) {
        Node<T> curr = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, curr.val)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    @Override
    public int indexOf(Object o) {
        Node<T> curr = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, curr.val)) {
                return i;
            }
            curr = curr.next;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object o) {
        Node<T> curr = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(o, curr.val)) {
                return i;
            }
            curr = curr.prev;
        }
        return -1;
    }
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<T> {
        Node<T> curr;
        private LinkedListIterator() {
            curr = new Node<>(null, head, null);
        }
        public boolean hasNext() {
            return curr.next != null;
        }
        public T next() {
            curr = curr.next;
            return curr.val;
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
