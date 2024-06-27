package Ejercicio04;

import models.ISet;

import java.util.Random;

public class SetModified implements ISet {
    private static final int MAX = 10000;

    private int[] array;
    private int count;

    public SetModified() {
        this.array = new int[MAX];
        this.count = 0;
    }

    public int[] getArray() {
        return array;
    }

    public int getCount() {
        return count;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void add(int a) {
        SetBuilder builder = new SetBuilder(this);
        builder.add(a).build();
    }

    public void addAll(ISet set) {
        SetBuilder builder = new SetBuilder(this);
        builder.addAll(set).build();
    }

    @Override
    public void remove(int a) {
        for (int i = 0; i < count; i++) {
            if (this.array[i] == a) {
                this.array[i] = this.array[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if (this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacio");
        }
        return this.array[new Random().nextInt(this.count)];
    }
}
