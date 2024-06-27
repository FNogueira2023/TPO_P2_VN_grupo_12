package Ejercicio01;

public class QueueOfStacks {
    private final FixedStack[] array;
    private int count;
    private int max;

    public int getMax() {
        return max;
    }

    public QueueOfStacks(int n) {
        this.array = new FixedStack[n];
        this.count = 0;
        this.max = n;
    }

    public void add(FixedStack stack) {
        this.array[this.count] = stack;
        this.count++;
    }

    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desacolar una cola vacia");
            return;
        }
        for (int i = 0; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public FixedStack getFirst() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el primero de una cola vacia");
            return null;
        }
        return this.array[0];
    }




}
