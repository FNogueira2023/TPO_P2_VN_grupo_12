package models;

import java.util.Objects;

public class Node {

    private int value;
    private Node next;

    public Node() {
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return value == node.value && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }
}
