package models;

public class Queue implements IQueue {

    private int[] array;
    private int count;


    @Override
    public void add(int a) {
        array[this.count] = a;
        count++;
    }

    @Override
    public void remove() {
        if (count == 0) {
            System.out.println("Cola esta vacia");
        }

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int getFirst() {
        if (count == 0) {
            System.out.println("Cola esta vacia");
            return -1;
        }
        return array[0];
    }

    public void print(Queue queue){
        while(!queue.isEmpty()){
            System.out.println(queue.getFirst());
            queue.remove();
        }
    }

    public Queue copy(Queue queue){
        Queue copy = new Queue();
        Queue aux = new Queue();

        while(!queue.isEmpty()){
            aux.add(queue.getFirst());
            copy.add(queue.getFirst());
            queue.remove();
        }
        while(!aux.isEmpty()){
            queue.add(aux.getFirst());
            aux.remove();
        }

        return copy;
    }
}
