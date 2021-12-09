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
        firstPos = -1;
        lastPos = 0;
    }

    /** Resize function */
    private void resize(int capacity) {
        if (size / capacity < USAGERATIO) {
            capacity = capacity / 2;
        }
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, lastPos + 1);
        System.arraycopy(items, items.length + firstPos,
                         a, items.length + firstPos, -firstPos);
        items = a;
    }

    /**  Add an item of type T to the front of deque */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[items.length + firstPos] = item;
        firstPos -= 1;
        size += 1;
    }

    /** Adds an items of type T to the back of deque */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[lastPos] = item;
        lastPos += 1;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        }
        return true;
    }

    /** Returns the number of items in the deque */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last */
    public void printDeque() {
        for (int i = items.length + firstPos + 1; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        for (int i = 0; i < lastPos; i++) {
            System.out.print(items[i] + " ");
        }
    }

    /** Removes and returns the item at the front of the deque, if none, return null */
    public T removeFirst() {
        T firstItem = items[items.length + firstPos + 1];
        items[items.length + firstPos + 1] = null;
        size -= 1;
        return firstItem;
    }

    /** Removes and returns the item at the back of the deque, if none, return null */
    public T removeLast() {
        T lastItem = items[lastPos - 1];
        items[lastPos - 1] = null;
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

//    public static void main(String[] args) {
//        ArrayDeque test = new ArrayDeque();
//        test.addFirst(5);
//        test.addFirst(6);
//        test.addLast(12);
//        test.printDeque();
//        System.out.println();
//        System.out.println(test.size());
//        System.out.println(test.isEmpty());
//    }
}
