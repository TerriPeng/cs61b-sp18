public interface Deque<T> {
    void addFirst(T Item);
    void addLast(T Item);
    boolean isEmpty();
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);
}
