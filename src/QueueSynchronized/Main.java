package QueueSynchronized;

public class Main {

    public static void main(String[] args) {
        QueueContainer queueContainer = new QueueContainer();
     Consumer consumer1 = new Consumer(queueContainer);
     Consumer consumer2 = new Consumer(queueContainer);
     Consumer consumer3 = new Consumer(queueContainer);
     Consumer consumer4 = new Consumer(queueContainer);

     Producer producer1 = new Producer(queueContainer);
     Producer producer2 = new Producer(queueContainer);
     Producer producer3 = new Producer(queueContainer);
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();

        producer1.start();
        producer2.start();
        producer3.start();
    }
}
