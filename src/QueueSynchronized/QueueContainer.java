package QueueSynchronized;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Hayk on 05.08.2021.
 */
public class QueueContainer {

    private  Queue<String> queue=new PriorityQueue<>();

    public QueueContainer(){}

    public synchronized void add(String elem){
        while (this.size()>100){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.add(elem);
        notifyAll();
    }

    public synchronized String pool(){
        while (this.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String result = queue.poll();
        notifyAll();
        return result;
    }

    public synchronized int size(){
        return queue.size();
    }

    public synchronized boolean isEmpty(){
        return queue.isEmpty();
    }

}
