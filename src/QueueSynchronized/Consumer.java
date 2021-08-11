package QueueSynchronized;

/**
 * Created by Hayk on 05.08.2021.
 */
public class Consumer extends Thread {
    private final QueueContainer queueContainer;

    public Consumer(QueueContainer queueContainer) {
        this.queueContainer = queueContainer;
    }

    @Override
    public void run(){
        while (true){
            System.out.println(Thread.currentThread().getName()+" Delete : "+this.queueContainer.pool());
        }
    }
}
