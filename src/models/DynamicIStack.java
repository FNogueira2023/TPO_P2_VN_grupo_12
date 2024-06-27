package models;


public class DynamicIStack implements IStack {

    private Node first;

    @Override
    public void add(int a) {
        this.first = new Node(a, this.first);
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede remover el tope de una pila vacia");
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacia");
        }
        return this.first.getValue();
    }
}
