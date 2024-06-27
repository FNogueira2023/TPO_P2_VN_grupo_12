package models;

public interface IQueue {
    void add(int a);

    void remove();

    boolean isEmpty();

    int getFirst();
}
