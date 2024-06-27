package Ejercicio04;

public class StackBuilder {
    private final StackModified stack;


    public StackBuilder(StackModified stack) {
        this.stack = stack;
    }

    public StackBuilder add(int a) {
        stack.getArray()[stack.getCount()] = a;
        stack.setCount(stack.getCount() + 1);
        return this;
    }

    public StackModified build() {
        return stack;
    }
}
