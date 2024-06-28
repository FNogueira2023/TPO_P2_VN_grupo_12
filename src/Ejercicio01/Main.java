package Ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    }

    //    2.1.1
    public static List<Integer> calculateTrace(QueueOfStacks queue) {
        List<Integer> trace = new ArrayList<>();
        int outerCounter = 0; // O(C)

        while (!queue.isEmpty()) { // O(n)
            int stackCounter = 0; // O(C)
            while (!queue.getFirst().isEmpty()) { // O(n)
                if (stackCounter == outerCounter) {
                    trace.add(queue.getFirst().getTop()); // O(C)
                }
                queue.getFirst().remove(); // O(C)
                stackCounter++;
            }
            outerCounter++;
            queue.remove(); // O(n)
        }
        return trace;
    }

//   total: O(n²) + O(n) = O(n²)


    //    2.1.2
    public static int[][] calculateTransposed(QueueOfStacks queue) {
        int[][] matrix = new int[queue.getMax()][queue.getMax()]; // O(C)
        int lineCounter = 0; // O(C)

        while (!queue.isEmpty()) { // O(n)
            int columnCounter = 0; // O(C)
            while (!queue.getFirst().isEmpty()) { // O(n)
                matrix[lineCounter][columnCounter] = queue.getFirst().getTop(); // O(C)
                queue.getFirst().remove(); // O(C)
                columnCounter++;
            }
            lineCounter++;
            queue.remove(); // O(n)
        }
        return matrix;
    }

//    total: O(n) * O(n) + O(n) = O(n²)

    //    2.1.3
    public static int[][] matrixAddition(QueueOfStacks queueA, QueueOfStacks queueB) {
        int[][] result = new int[queueA.getMax()][queueA.getMax()]; // O(C)
        int columnCounter = 0; // O(1)

        // Primer bucle para sumar elementos de queueA a result
        while (!queueA.isEmpty()) { // O(n)
            int lineCounter = 0; // O(C)
            while (!queueA.getFirst().isEmpty()) { // O(n)
                result[lineCounter][columnCounter] = queueA.getFirst().getTop(); // O(C)
                lineCounter++; // O(C)
                queueA.getFirst().remove(); // O(C)
            }
            columnCounter++; // O(C)
            queueA.remove(); // O(C)
        }

        columnCounter = 0; // O(C)
        // Segundo bucle para sumar elementos de queueB a result
        while (!queueB.isEmpty()) { // O(n)
            int lineCounter = 0; // O(C)
            while (!queueB.getFirst().isEmpty()) { // O(n)
                result[lineCounter][columnCounter] += queueB.getFirst().getTop(); // O(C)
                lineCounter++; // O(C)
                queueB.getFirst().remove(); // O(C)
            }
            columnCounter++; // O(C)
            queueB.remove(); // O(C)
        }
        return result; // O(1)
    }

//    total : O(n²)+O(n²)=O(n²)
}
