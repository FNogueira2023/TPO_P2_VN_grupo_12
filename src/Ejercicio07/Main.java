//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Ejercicio07;

import java.io.PrintStream;
import models.PriorityQueue;
import models.StaticPriorityQueue;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        PriorityQueue queue = new StaticPriorityQueue();
        queue.add(3, 3);
        queue.add(7, 7);
        queue.add(4, 4);
        queue.add(2, 2);

        while(!queue.isEmpty()) {
            PrintStream var10000 = System.out;
            int var10001 = queue.getFirst();
            var10000.println("" + var10001 + " " + queue.getPriority());
            queue.remove();
        }

    }

    public static void editValue(PriorityQueue queue, int[] par, int[] parModificar) {
        new StaticPriorityQueue();
    }
}
