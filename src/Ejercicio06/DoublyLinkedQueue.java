package Ejercicio06;

public class DoublyLinkedQueue {

    private DoublyNode first;
    private DoublyNode last;


    public void add(int a) {
        DoublyNode newNode = new DoublyNode(a, null, null);
        if (this.first == null) {
            first = newNode;
            last = newNode;
            first.setNext(first);
            first.setLast(first);
        } else {
            newNode.setLast(last);
            newNode.setNext(first);
            last.setNext(newNode);
            first.setLast(newNode);
            last = newNode;
        }
    }

    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        if (first == last) {
            first = null;
            last = null;
            return;
        }
        first = first.getNext();
        first.setLast(last);
        last.setNext(first);
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getFirst() {
        if (isEmpty()) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return -1;
        }
        return first.getValue();
    }


}
