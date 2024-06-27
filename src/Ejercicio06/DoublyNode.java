package Ejercicio06;

import java.util.Objects;

public class DoublyNode {

    private int value;
    private DoublyNode next;
    private DoublyNode last;

    public DoublyNode() {
    }

    public DoublyNode(int value, DoublyNode next, DoublyNode last) {
        this.value = value;
        this.next = next;
        this.last = last;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoublyNode getNext() {
        return next;
    }

    public DoublyNode getLast() {
        return last;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }

    public void setLast(DoublyNode last) {
        this.last = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoublyNode node)) return false;
        return value == node.value && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }
}
