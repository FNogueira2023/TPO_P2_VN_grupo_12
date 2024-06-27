package Ejercicio06;

import models.Node;

public class LimitedDynamicStack {

    private Node first;
    private final int max;
    private int counter;

    public LimitedDynamicStack(int max) {
        this.max = max;
    }

    public void add(int a) {
        if (this.counter < this.max) {
            this.first = new Node(a, this.first);
            this.counter++;
            return;
        }
        System.out.println("Ya se alcanzo el máximo de la pila");
    }

    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede remover el tope de una pila vacia");
        }
        this.first = this.first.getNext();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacia");
        }
        return this.first.getValue();
    }


}
