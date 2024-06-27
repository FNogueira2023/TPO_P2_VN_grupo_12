package models;

public interface IStack {

    /**
     * Precondición: La pila no esta vacía
     * @return
     */
    int getTop();

    void add(int a);

    /**
     * Precondición: no puede estar vacía la Pila
     */
    void remove();

    boolean isEmpty();

}
