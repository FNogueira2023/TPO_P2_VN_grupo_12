package Ejercicio06;

import models.DynamicSet;
import models.ISet;
import models.Node;

import java.util.Objects;
import java.util.Random;

public class UniversalSet implements ISet {

    private Node first;
    private int count;


    public boolean isSubset(ISet set) {
        ISet setAux = new DynamicSet();
        boolean result = true;

        while (!set.isEmpty()) {
            int element = set.choose();
            if (!in(this, element)) {
                result = false;
                break;
            }
            set.remove(element);
        }

        while (!setAux.isEmpty()) {
            int element = setAux.choose();
            set.add(element);
            setAux.remove(element);
        }
        return result;
    }

    public ISet getComplement(ISet set) {
        ISet compliments = new DynamicSet();
        ISet aux = new UniversalSet();

        if (!isSubset(set)) {
            System.out.println("El conjunto no es un subconjunto");
            return null;
        }

        while (!this.isEmpty()) {
            int element = this.choose();
            aux.add(element);
            if (!in(set, element)) {
                compliments.add(element);
            }
            this.remove(element);
        }

        while (!aux.isEmpty()) {
            int element = aux.choose();
            this.add(element);
            aux.remove(element);
        }

        return compliments;
    }

    private static boolean in(ISet a, int element) {
        ISet aux = new DynamicSet();
        boolean exists = false;
        while (!a.isEmpty()) {
            int value = a.choose();
            if (element == value) {
                exists = true;
                break;
            }
            aux.add(value);
            a.remove(value);
        }
        while (!aux.isEmpty()) {
            int value = aux.choose();
            a.add(value);
            aux.remove(value);
        }
        return exists;
    }

    public int choose() {
        if (this.isEmpty()) { // C
            throw new RuntimeException("No se puede obtener el elemento de un conjunto vacio"); // C
        }
        Random random = new Random();
        int index = random.nextInt(count);

        int i = 0;
        Node current = this.first;
        while (current != null) {
            if (i == index) {
                return current.getValue();
            }
            i++;
            current = current.getNext();
        }

        return 0;
    }

    public void add(int a) {
        if (this.isEmpty()) { // C
            this.first = new Node(a, null);
            this.count++;
            return;
        }
        Node current = this.first;
        while (current.getNext() != null) {
            if (current.getValue() == a) {
                return;
            }
            current = current.getNext();
        }
        current.setNext(new Node(a, null));
        this.count++;
    }

    public void remove(int a) {
        if (this.isEmpty()) {
            return;
        }
        if (this.first.getNext() == null) {
            if (this.first.getValue() == a) {
                this.first = null;
                this.count--;
            }
            return;
        }
        if (this.first.getValue() == a) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }
        Node backup = this.first;
        Node current = this.first.getNext();
        while (current.getNext() != null) {
            if (current.getValue() == a) {
                backup.setNext(current.getNext());
                this.count--;
                return;
            }
            backup = current;
            current = current.getNext();
        }

        if (current.getValue() == a) {
            backup.setNext(current.getNext());
            this.count--;
        }
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DynamicSet that)) return false;
        return count == that.count && Objects.equals(first, that.first);
    }

    public int hashCode() {
        return Objects.hash(first, count);
    }


}
