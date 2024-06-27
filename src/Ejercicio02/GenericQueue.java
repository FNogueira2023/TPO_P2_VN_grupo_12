package Ejercicio02;

public class GenericQueue <Q>{

    private Q[] array;
    private int count;

    public GenericQueue(){
        this.array = (Q[]) new Object[10000];
        this.count = 0;
    }

    public void add(Q q) {
        array[this.count] = q;
        count++;
    }

    public void remove() {
        if (count == 0) {
            System.out.println("Cola esta vacia");
        }

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public Q getFirst() {
        if (count == 0) {
            System.out.println("Cola esta vacia");
            return null; // Changed return type to handle generic type T
        }
        return array[0];
    }


}
