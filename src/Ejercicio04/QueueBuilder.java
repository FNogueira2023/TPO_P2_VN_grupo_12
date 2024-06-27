package Ejercicio04;

public class QueueBuilder {
    private final QueueModified queueModified;

    public QueueBuilder() {
        this.queueModified = new QueueModified();
    }

    public QueueBuilder(QueueModified queueModified) {
        this.queueModified = queueModified;
    }

    public QueueBuilder add(int a) {
        queueModified.add(a);
        return this;
    }

    public QueueModified build() {
        return queueModified;
    }
}
