package Ejercicio05;

import java.util.Random;

public class SetCoordenadas {
    private static final int MAX = 10000;

    private Coordenada[] array;
    private int count;

    public SetCoordenadas() {
        this.array = new Coordenada[MAX];
        this.count = 0;
    }

    public void add(Coordenada coordenada) {
        if (count == MAX) {
            throw new RuntimeException("Límite de elementos alcanzado");
        }
        for (int i = 0; i < count; i++) {
            if (this.array[i].getX() == coordenada.getX() && this.array[i].getY() == coordenada.getY()) {
                return;
            }
        }

        this.array[count] = new Coordenada(coordenada.getX(), coordenada.getY());
        this.count++;
    }

    public void remove(Coordenada coordenada) {
        for (int i = 0; i < count; i++) {
            if (this.array[i].getX() == coordenada.getX() && this.array[i].getY() == coordenada.getY()) {
                this.array[i].setX(this.array[count - 1].getX());
                this.array[i].setY(this.array[count - 1].getY());
                count--;
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public Coordenada choose() {
        if (this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacío");
        }
        return this.array[new Random().nextInt(this.count)];
    }
}
