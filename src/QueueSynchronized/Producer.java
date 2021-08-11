package QueueSynchronized;

/**
 * Created by Hayk on 05.08.2021.
 */
public class Producer extends Thread {
    private final QueueContainer queueContainer;

    public Producer(QueueContainer queueContainer) {
        this.queueContainer = queueContainer;
    }


    public void run(){
        while (true){
            String value = StringGenerator.generate();
            System.out.println(Thread.currentThread().getName()+" Add : "+value);
            this.queueContainer.add(value);
        }
    }
}
