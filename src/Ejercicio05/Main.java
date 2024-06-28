package Ejercicio05;

import models.DynamicIStack;
import models.DynamicSet;
import models.ISet;
import models.IStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    //      2.5.4 / 2.5.5
    public static void main(String[] args) {


        SetCoordenadas set = conjuntoCoordenadas();

        double radio = 1.0;
        RegionCuadrada region = new RegionCuadrada(new Coordenada(100, 150), 50);
        MonteCarlo monteCarlo = new MonteCarlo(region);

        double piAproximado = aproximarPI(set, monteCarlo);
        System.out.println(piAproximado);
    }

    //  2.5.1 Algoritmo
    public static IStack OrderedUniqueStack(IStack IStack) {
        IStack result = new DynamicIStack(); // O(C)
        ISet setAux = new DynamicSet(); // O(C)
        List<Integer> listAux = new ArrayList<>(); // O(C)

        while (!IStack.isEmpty()) { // O(n)
            int element = IStack.getTop(); // O(C)
            setAux.add(element); // O(C)
            IStack.remove(); // O(C)
        }

        while (!setAux.isEmpty()) { // O(n)
            int element = setAux.choose(); // O(C)
            listAux.add(element); // O(C)
            setAux.remove(element); // O(C)
        }

        Collections.sort(listAux); // O(nlog(n))

        for (int element : listAux) { // O(n)
            result.add(element); // O(C)
        }

        return result; // O(C)
    }

//  total: O(C)+O(n)+O(n)+O(nlog(n))+O(n) = O(nlog(n))




    public static double aproximarPI(SetCoordenadas coordenadas, MonteCarlo monteCarlo) {
        int totalPuntos = size(coordenadas);
        double radio = (double) monteCarlo.getRegion().getLongitudLado() / 2;

        while (!coordenadas.isEmpty()) {
            Coordenada coordenada = coordenadas.choose();
            monteCarlo.agregarCoordenada(coordenada);
            coordenadas.remove(coordenada);
        }

        return 4.0 * monteCarlo.getCoordenadas().size() / totalPuntos;
    }

    public static SetCoordenadas conjuntoCoordenadas() {
        SetCoordenadas set = new SetCoordenadas();
        Random random = new Random();

        while (size(set) <= 1000) {
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);

            Coordenada coordenada = new Coordenada(x, y);
            set.add(coordenada);
        }
        return set;
    }

    private static int size(SetCoordenadas set) {
        SetCoordenadas copy = copy(set);
        int counter = 0;

        while (!copy.isEmpty()) {
            counter++;

            Coordenada element = copy.choose();
            copy.remove(element);
        }
        return counter;
    }

    private static SetCoordenadas copy(SetCoordenadas a) {
        SetCoordenadas copy = new SetCoordenadas();
        SetCoordenadas aux = new SetCoordenadas();

        while (!a.isEmpty()) {
            Coordenada element = a.choose();
            copy.add(element);
            aux.add(element);
            a.remove(element);
        }

        while (!aux.isEmpty()) {
            Coordenada element = aux.choose();
            a.add(element);
            aux.remove(element);
        }
        return copy;
    }
}
