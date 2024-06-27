package Ejercicio02;

import java.util.Arrays;
import java.util.Random;

public class GenericSet<T> {

    private final T[] array;
    private int count;

    public GenericSet() {
        this.array = (T[]) new Object[10000];
        this.count = 0;
    }


    public void add(T t) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i].equals(t)) {
                return;
            }
        }
        this.array[this.count] = t;
        this.count++;
    }


    public void remove(T t) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i].equals(t)) {
                if (i == this.count - 1) {
                    this.count--;
                    return;
                }
                this.array[i] = this.array[this.count - 1];
                this.count--;
            }
        }
    }


    public boolean isEmpty() {
        return this.count == 0;
    }

    public T choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
            return null;
        }
        int randomIndex = (new Random()).nextInt(this.count);
        return this.array[randomIndex];
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericSet<?> set = (GenericSet<?>) o;
        if (count != set.count) return false;

        T[] array1Copy = Arrays.copyOf(array, array.length);
        T[] array2Copy = (T[]) Arrays.copyOf(set.array, set.array.length);
        Arrays.sort(array1Copy);
        Arrays.sort(array2Copy);

        for (int i = 0; i < count; i++) {
            if (!array1Copy[i].equals(array2Copy[i])) {
                return false;
            }
        }
        return true;
    }
}
