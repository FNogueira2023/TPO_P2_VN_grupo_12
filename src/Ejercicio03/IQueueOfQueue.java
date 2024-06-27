package Ejercicio03;

import models.IQueue;
import models.Queue;

import java.util.List;

public interface IQueueOfQueue {
    void add(IQueue queue);

    void remove();

    boolean isEmpty();

    IQueue getFirst();

    QueueOfQueue concatenate(List<QueueOfQueue> instancias);

    Queue flat();

    void reverseWithDepth(QueueOfQueue queueOfQueue, Queue[] array);
}
