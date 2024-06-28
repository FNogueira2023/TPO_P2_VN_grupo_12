package Ejercicio03;

import models.DynamicIStack;
import models.IQueue;
import models.IStack;
import models.Queue;

import java.util.ArrayList;
import java.util.List;

public class QueueOfQueue implements IQueueOfQueue {

    private IQueue[] array;
    private int count;

    @Override
    public void add(IQueue queue) {
        array[this.count] = queue;
        count++;
    }

    @Override
    public void remove() {
        if (count == 0) {
            System.out.println("Cola esta vacia");
        }

        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public IQueue getFirst() {
        if (count == 0) {
            System.out.println("Cola esta vacia");
            return null;
        }
        return array[0];
    }

//  2.3.1
    @Override
    public QueueOfQueue concatenate(List<QueueOfQueue> instances) {
        QueueOfQueue result = new QueueOfQueue();
        List<IQueue> listOfElements = new ArrayList<>();

        for (IQueueOfQueue queueOfQueue : instances) {
            IQueue current = queueOfQueue.getFirst();
            listOfElements.add(current);
            queueOfQueue.remove();
        }

        for (IQueue queue : listOfElements) {
            result.add(queue);
        }
        return result;
    }

//  2.3.2
    @Override
    public Queue flat() {
        Queue result = new Queue();

        for (int i = 0; i < this.array.length; i++) {
            while (!this.array[i].isEmpty()) {
                result.add(this.array[i].getFirst());
                this.array[i].remove();
            }
        }
        return result;
    }

//  2.3.3
    @Override
    public void reverseWithDepth(QueueOfQueue queueOfQueue, Queue[] array) {

        // Reverse array
        int i = 0;
        int j = this.array.length - 1;

        while (i < j) {
            IQueue temp = this.array[i];
            this.array[i] = this.array[j];
            this.array[j] = temp;
            i++;
            j--;
        }

        //Reverse queues
        for (int k = 0; i < this.array.length; k++) {
            IStack IStackAux = new DynamicIStack();
            while (!this.array[i].isEmpty()) {
                IStackAux.add(this.array[i].getFirst());
                this.array[i].remove();
            }
            while (!IStackAux.isEmpty()) {
                this.array[i].add(IStackAux.getTop());
                IStackAux.remove();
            }
        }
    }
}
