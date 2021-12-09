public class ArrayDeque<T> {
    private static int RFACTOR = 2;
    private static double USAGERATIO = 0.25;
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates empty list */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = -1;
        nextLast = 0;
    }

    /** Resize function */
    private void resize(int capacity) {
        double doubleCapacity = capacity;
        if (size / doubleCapacity < USAGERATIO) {
            capacity = capacity / 2;
        }
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, nextLast);
        System.arraycopy(items, items.length + nextFirst + 1,
                         a, a.length + nextFirst + 1, -(nextFirst + 1));
        items = a;
    }

    /**  Add an item of type T to the front of deque */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[items.length + nextFirst] = item;
        nextFirst -= 1;
        size += 1;
    }

    /** Adds an items of type T to the back of deque */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[nextLast] = item;
        nextLast += 1;
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
        for (int i = items.length + nextFirst + 1; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        for (int i = 0; i < nextLast; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque, if none, return null */
    public T removeFirst() {
        T firstItem = items[items.length + nextFirst + 1];
        items[items.length + nextFirst + 1] = null;
        size -= 1;
        nextFirst += 1;
        return firstItem;
    }

    /** Removes and returns the item at the back of the deque, if none, return null */
    public T removeLast() {
        T lastItem = items[nextLast - 1];
        items[nextLast - 1] = null;
        size -= 1;
        nextLast -= 1;
        return lastItem;
    }

    /** Gets the item at given index, if none, return null */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index < -(nextFirst + 1)) {
            return items[items.length + (nextFirst + 1) + index];
        } else {
            return items[index + (nextFirst + 1)];
        }
    }

//    public static void main(String[] args){
//    ArrayDeque<Integer> a = new ArrayDeque<>();
//    a.addLast(5);
//    a.addLast(6);
//    a.addLast(7);
//    a.addFirst(4);
//
//    a.addLast(8);
//    a.addLast(9);
//    a.addLast(10);
//    a.addFirst(3);
//    a.addFirst(2);
//    a.addFirst(1);
//
//    a.printDeque();
//
//    a.removeFirst();
//    a.removeLast();
//    a.removeLast();
//    a.removeLast();
//    a.removeLast();
//    a.removeLast();
//    a.removeLast();
//    a.removeFirst();
//    a.removeFirst();
//    a.removeFirst();
//
//    a.printDeque();
//
//    a.addLast(5);
//    a.addLast(6);
//    a.addLast(7);
//    a.addFirst(4);
//
//    a.addLast(8);
//    a.addLast(9);
//    a.addLast(10);
//    a.addFirst(3);
//    a.addFirst(2);
//    a.addFirst(1);
//
//    a.printDeque();
//
//    for (int i = 0; i < a.size(); i++) {
//        System.out.println(a.get(i));
//        }
//    }
}
