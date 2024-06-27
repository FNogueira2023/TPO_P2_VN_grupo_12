package Ejercicio04;

import models.IQueue;

public class QueueModified implements IQueue {
    private int[] array;
    private int count;

    private static final int MAX = 10000;

    public QueueModified() {
        this.array = new int[MAX];
        this.count = 0;
    }

    public QueueModified(int... elements) {
        this();
        QueueBuilder builder = new QueueBuilder(this);
        for (int element : elements) {
            builder.add(element);
        }
        builder.build();
    }

    @Override
    public void add(int a) {
        if (count == 10000) {
            throw new RuntimeException("No se puede agregar el elemento");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for (int i = 0; i < count - 1; i++) {
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
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return array[0];
    }
}
