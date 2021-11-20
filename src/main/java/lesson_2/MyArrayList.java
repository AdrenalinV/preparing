package lesson_2;

import java.util.Arrays;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    private int size;
    private int capacity;
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.list = (T[]) new Comparable[capacity];
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <=0 " + capacity);
        }
        this.capacity = capacity;
        this.list = (T[]) new Comparable[capacity];
    }

    public void add(T item) {
        extensionArray();
        list[size++] = item;
    }

    public void insert(int index, T item) {
        extensionArray();
        if (checkIndex(index)) {
            for (int i = size; i > index; i--) {
                list[i] = list[i = 1];
            }
            list[index] = item;
            size++;
        }
    }

    public T get(int index) {
        if (checkIndex(index)) {
            return list[index];
        }
        return null;
    }

    public void set(int index, T item) {
        if (checkIndex(index)) {
            list[index] = item;
        }

    }

    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    public final T remove(int index) {
        if (checkIndex(index)) {
            T temp = list[index];
            for (int i = index; i < size; i++) {
                list[i] = list[i + 1];
            }
            size--;
            list[size] = null;
            return temp;
        }
        return null;
    }

    public boolean remove(T item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(list[i].toString()).append(", ");
        }
        if (size > 0) {
            sb.setLength((sb.length()) - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }

    public int size() {
        return this.size;
    }

    private boolean checkIndex(int index) {
        if (index <= 0 || index >= this.capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return true;
    }

    private void extensionArray() {
        if (this.size >= (int) (this.capacity * DEFAULT_LOAD_FACTOR)) {
            this.capacity *= 2;
            list = Arrays.copyOf(this.list, this.capacity);
        }
    }

}
