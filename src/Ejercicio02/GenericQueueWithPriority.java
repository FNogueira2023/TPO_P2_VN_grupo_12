package Ejercicio02;

public class GenericQueueWithPriority<P> {

    private final P[] array;
    private final int[] priorities;
    private int count;

    public GenericQueueWithPriority() {
        this.array = (P[]) new Object[10000];
        this.priorities = new int[10000];
        this.count = 0;
    }

    public void add(P item, int priority) {
        int index = binarySearch(priority);

        for (int i = this.count; i > index; i--) {
            this.array[i] = this.array[i - 1];
            this.priorities[i] = this.priorities[i - 1];
        }

        this.array[index] = item;
        this.priorities[index] = priority;

        this.count++;
    }

    private int binarySearch(int priority) {
        int low = 0;
        int high = this.count - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (this.priorities[mid] == priority) {
                return mid;
            } else if (this.priorities[mid] < priority) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desacolar una cola vacia");
            return;
        }
        for (int i = 0; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
            this.priorities[i] = this.priorities[i + 1];
        }
        this.count--;
    }


    public boolean isEmpty() {
        return this.count == 0;
    }


    public P getFirst() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el primero de una cola vacia");
            return null;
        }
        return this.array[0];
    }


    public int getPriority() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener la prioridad del primero de una cola vacia");
            return -1;
        }
        return this.priorities[0];
    }
}
