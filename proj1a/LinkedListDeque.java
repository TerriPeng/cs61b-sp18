/** First deque implementation */
public class LinkedListDeque<T> {
    private class TNode<T> {
        public T item;
        public TNode<T> next;
        public TNode<T> prev;

        public TNode(T i, TNode n, TNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private TNode<T> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T x) {
        sentinel = new TNode(null, null, null);
        sentinel.next = new TNode(x, null, sentinel);
        size = 1;
    }

    /** Adds an item of type T to the front of the queue */
    public void addFirst(T item) {
        sentinel.next = new TNode(item, sentinel.next.next, sentinel);
        size += 1;
    }

    /** Adds an item of type T to the back of the queue */
    public void addLast(T item) {
        sentinel.prev = new TNode(item, sentinel, sentinel.prev.prev);
        size += 1;
    }

    /** Checks if deque is empty */
    public boolean isEmpty() {
        if (size > 0) {
            return false;
        }
        return true;
    }

    /** Return number of items in deque */
    public int size() {
        return size;
    }

    /** Print items in deque, first to last */
    public void printDeque() {
        TNode<T> current = sentinel.next;
        while (current != sentinel) {
            System.out.print(current.item + " ");
            current = current.next;
        }
    }

    /** Removes and returns item at front, if no item, return null */
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T returnItem = sentinel.next.item;
        size -= 1;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return returnItem;
    }

    /** Removes and returns last item, if no item, return null */
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        T returnItem = sentinel.prev.item;
        size -= 1;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return returnItem;
    }

    /** Gets the item at the given index, if no item, return null */
    public T get(int index) {
        TNode<T> current = sentinel.next;
        int count = 0;
        if (index < 0) {
            return null;
        }
        if (index >= size) {
            return null;
        }
        while (count != index) {
            count += 1;
            current = current.next;
        }
        return current.item;
    }

    /** Gets the item at the given index using recursion, if no item, return null */
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(index, sentinel.next);
    }

    public T getRecursiveHelper(int index, TNode<T> current) {
        if (index == 0) {
            return current.item;
        }
        return getRecursiveHelper(index - 1, current.next);
    }


}
