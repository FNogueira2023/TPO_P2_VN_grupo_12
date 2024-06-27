package Ejercicio04;

import models.IStack;

public class StackModified implements IStack {

    private int[] array;
    private int count;

    public StackModified(int[] array, int count) {
        this.array = new int[10000];
        this.count = 0;
    }

    public int[] getArray() {
        return array;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public StackModified() {
        this.array = new int[10000];
        this.count = 0;
    }

    @Override
    public void add(int a) {
        StackBuilder builder = new StackBuilder(this);
        builder.add(a).build();

    }

    @Override
    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desapilar una pila vacia");
            return;
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getTop() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el tope de una pila vacia");
            return -1;
        }
        return this.array[this.count - 1];
    }

}
