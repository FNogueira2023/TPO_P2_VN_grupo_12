package Ejercicio04;

import models.ISet;


public class SetBuilder {
    private final SetModified set;

    private static final int MAX = 10000;

    public SetBuilder(SetModified set) {
        this.set = set;
    }

    public SetBuilder add(int a) {
        if(set.getCount() == MAX) {
            throw new RuntimeException("Límite de elementos alcanzado");
        }
        for(int i = 0; i < set.getCount(); i++) {
            if(set.getArray()[i] == a) {
                return this;
            }
        }
        set.getArray()[set.getCount()] = a;
        set.setCount(set.getCount() + 1);
        return this;
    }

    public SetBuilder addAll(ISet setToAdd){
        ISet auxSet = copy(setToAdd);

        while(!auxSet.isEmpty()){
            int element = auxSet.choose();
            this.set.add(element);
            auxSet.remove(element);
        }
        return this;
    }



    public SetModified build() {
        return set;
    }


    private static ISet copy(ISet a) {
        ISet copy = new SetModified();
        ISet aux = new SetModified();

        while (!a.isEmpty()) {
            int element = a.choose();
            copy.add(element);
            aux.add(element);
            a.remove(element);
        }

        while (!aux.isEmpty()) {
            int element = aux.choose();
            a.add(element);
            aux.remove(element);
        }

        return copy;
    }
}

