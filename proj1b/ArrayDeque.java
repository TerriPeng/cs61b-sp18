public class ArrayDeque<T> {
    private static int RFACTOR = 2;
    private static double USAGERATIO = 0.25;
    private static int minCapacity = 16;
    private static int cFactor = 2;
    private int capacity;
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates empty list */
    public ArrayDeque() {
        // initial capacity: 8
        capacity = 8;
        items = (T[]) new Object[capacity];
        size = 0;
        nextFirst = capacity - 1;
        nextLast = 0;
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

    /** Decreases index */
    private int oneMinus(int index) {
        if (index == 0) {
            return capacity - 1;
        } else {
            return index - 1;
        }
    }

    /** Increases index */
    private int onePlus(int index) {
        if (index == capacity - 1) {
            return 0;
        } else {
            return index + 1;
        }
    }

    /** Resize function */
    private void resize(int newCapacity) {
        int currentFirst = onePlus(nextFirst);
        int currentLast = oneMinus(nextLast);
        T[] newItems = (T[]) new Object[newCapacity];
        if (currentFirst < currentLast) {
            int length = currentLast - currentFirst + 1;
            System.arraycopy(items, currentFirst, newItems, 0, length);
            nextFirst = newCapacity - 1;
            nextLast = length;
        } else {
            int firstLength = capacity - currentFirst;
            int newFirst = newCapacity - firstLength;
            System.arraycopy(items, currentFirst, newItems, newFirst, firstLength);
            System.arraycopy(items, 0, newItems, 0, nextLast);
            nextFirst = newFirst - 1;
        }
        capacity = newCapacity;
        items = newItems;
    }

    /** Check for resize */
    private void resizeCheck() {
        if (size == capacity) {
            resize(capacity * RFACTOR);
        }
    }

    /** Check for shrink */
    private void shrinkCheck() {
        double ratio = (double) size / capacity;
        if (ratio < USAGERATIO && capacity > minCapacity) {
            resize(capacity/cFactor);
        }
    }

    /**  Add an item of type T to the front of deque */
    public void addFirst(T item) {
        items[nextFirst] = item;
        oneMinus(nextFirst);
        size += 1;
        resizeCheck();
    }

    /** Adds an items of type T to the back of deque */
    public void addLast(T item) {
        items[nextLast] = item;
        onePlus(nextLast);
        size += 1;
        resizeCheck();
    }

    /** Prints the items in the deque from first to last */
    public void printDeque() {
        int currentIndex = onePlus(nextFirst);
        while (currentIndex != nextLast) {
            System.out.print(items[currentIndex] + " ");
            currentIndex = onePlus(currentIndex);
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque, if none, return null */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T removed = items[onePlus(nextFirst)];
        items[onePlus(nextFirst)] = null;
        nextFirst = onePlus(nextFirst);
        size -= 1;
        shrinkCheck();
        return removed;
    }

    /** Removes and returns the item at the back of the deque, if none, return null */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T removed = items[oneMinus(nextLast)];
        items[oneMinus(nextLast)] = null;
        nextLast = oneMinus(nextLast);
        size -= 1;
        shrinkCheck();
        return removed;
    }

    /** Gets the item at given index, if none, return null */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int reindex = nextFirst + 1 + index;
        if (reindex >= capacity) {
            reindex -= capacity;
        }
        return items[reindex];
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
