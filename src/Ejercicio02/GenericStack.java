package Ejercicio02;

public class GenericStack<S> {
    private final S[] array;
    private int count;

    public GenericStack() {
        this.array = (S[]) new Object[10000];
        this.count = 0;
    }

    public void add(S s) {
        this.array[this.count] = s;
        this.count++;
    }

    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desapilar una pila vacia");
            return;
        }
        this.count--;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public S getTop() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el tope de una pila vacia");
            return null;
        }
        return this.array[this.count - 1];
    }

}
