package Ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        QueueOfStacks queue = new QueueOfStacks(3);

        FixedStack stack01 = new FixedStack(3);
        stack01.add(7);
        stack01.add(4);
        stack01.add(1);

        FixedStack stack02 = new FixedStack(3);
        stack02.add(8);
        stack02.add(5);
        stack02.add(2);

        FixedStack stack03 = new FixedStack(3);
        stack03.add(9);
        stack03.add(6);
        stack03.add(3);

        queue.add(stack01);
        queue.add(stack02);
        queue.add(stack03);

        QueueOfStacks queueB = new QueueOfStacks(3);

        FixedStack stack001 = new FixedStack(3);
        stack001.add(7);
        stack001.add(4);
        stack001.add(1);

        FixedStack stack002 = new FixedStack(3);
        stack002.add(8);
        stack002.add(5);
        stack002.add(2);

        FixedStack stack003 = new FixedStack(3);
        stack003.add(9);
        stack003.add(6);
        stack003.add(3);

        queueB.add(stack001);
        queueB.add(stack002);
        queueB.add(stack003);


        int[][] matriz = matrixAddition(queue,queueB);

        System.out.println("Valores de la matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static List<Integer> calculateTrace(QueueOfStacks queue) {
        List<Integer> trace = new ArrayList<>();
        int outerCounter = 0;

        while (!queue.isEmpty()) {
            int stackCounter = 0;
            while (!queue.getFirst().isEmpty()) {
                if (stackCounter == outerCounter) {
                    trace.add(queue.getFirst().getTop());
                }
                queue.getFirst().remove();
                stackCounter++;
            }
            outerCounter++;
            queue.remove();
        }
        return trace;
    }

    public static int[][] calculateTransposed(QueueOfStacks queue) {
        int[][] matrix = new int[queue.getMax()][queue.getMax()];
        int lineCounter = 0;

        while (!queue.isEmpty()) {
            int columnCounter = 0;
            while (!queue.getFirst().isEmpty()) {
                matrix[lineCounter][columnCounter] = queue.getFirst().getTop();
                queue.getFirst().remove();
                columnCounter++;
            }
            lineCounter++;
            queue.remove();
        }
        return matrix;
    }

    public static int[][] matrixAddition(QueueOfStacks queueA, QueueOfStacks queueB){
        int[][] result = new int[queueA.getMax()][queueA.getMax()];
        int columnCounter = 0;

        while(!queueA.isEmpty()){
            int lineCounter = 0;
            while(!queueA.getFirst().isEmpty()){
               result[lineCounter][columnCounter] = queueA.getFirst().getTop();
                lineCounter++;
                queueA.getFirst().remove();
            }
            columnCounter++;
            queueA.remove();
        }

        columnCounter = 0;
        while(!queueB.isEmpty()){
            int lineCounter = 0;
            while(!queueB.getFirst().isEmpty()){
                result[lineCounter][columnCounter] += queueB.getFirst().getTop();
                lineCounter++;
                queueB.getFirst().remove();
            }
            columnCounter++;
            queueB.remove();
        }
        return result;
    }
}
