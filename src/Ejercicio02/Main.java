package Ejercicio02;

public class Main {
    public static void main(String[] args) {

    }

    public static void reverseGenericStack(GenericStack<Object> stack) {
        GenericStack<Object> aux = new GenericStack<>();

        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }
        while (!aux.isEmpty()) {
            stack.add(aux.getTop());
            aux.remove();
        }
    }

    public static GenericSet<Object> copyGenericSet(GenericSet<Object> set) {
        GenericSet<Object> copy = new GenericSet<>();
        GenericSet<Object> aux = new GenericSet<>();

        while (!set.isEmpty()) {
            Object obj = set.choose();
            copy.add(obj);
            aux.add(obj);
            set.remove(obj);
        }
        while(!aux.isEmpty()){
            Object obj = aux.choose();
            set.add(obj);
            aux.remove(obj);
        }
        return copy;
    }
}
