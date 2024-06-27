package Ejercicio01;

public class FixedStack {

    private final int[] array;
    private int count;

    public FixedStack(int n) {
        this.array = new int[n];
        this.count = 0;
    }

    public void add(int a) {
        this.array[this.count] = a;
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

    public int getTop() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el tope de una pila vacia");
            return -1;
        }
        return this.array[this.count - 1];
    }

}