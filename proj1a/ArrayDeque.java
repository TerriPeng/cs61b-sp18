public class ArrayDeque<T> {
    private static int RFACTOR = 2;
    private static double USAGERATIO = 0.25;
    private T[] items;
    private int size;
    private int firstPos;
    private int lastPos;

    /** Creates empty list */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        firstPos = 0;
        lastPos = 0;
    }

    /** Resize function */
    private void resize(int capacity) {
        if (size / capacity < USAGERATIO) {
            capacity = capacity / 2;
        }
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, lastPos);
        System.arraycopy(items, items.length + firstPos,
                         a, items.length + firstPos, -firstPos);
        items = a;
    }

    /**  Add an item of type T to the front of deque */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        firstPos -= 1;
        items[items.length + firstPos] = item;
        size += 1;
    }

    /** Adds an items of type T to the back of deque */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        lastPos += 1;
        items[lastPos] = item;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        if (size > 0) {
            return true;
        }
        return false;
    }

    /** Returns the number of items in the deque */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last */
    public void printDeque() {
        for (int i = items.length + firstPos; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        for (int i = 0; i < lastPos; i++) {
            System.out.print(items[i] + " ");
        }
    }

    /** Removes and returns the item at the front of the deque, if none, return null */
    public T removeFirst() {
        T firstItem = items[items.length + firstPos];
        items[items.length + firstPos] = null;
        size -= 1;
        return firstItem;
    }

    /** Removes and returns the item at the back of the deque, if none, return null */
    public T removeLast() {
        T lastItem = items[lastPos];
        items[lastPos] = null;
        size -= 1;
        return lastItem;
    }

    /** Gets the item at given index, if none, return null */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index < -firstPos) {
            return items[items.length + firstPos + index];
        } else {
            return items[index + firstPos];
        }
    }
}
