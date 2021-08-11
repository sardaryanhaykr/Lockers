package UnisexBathroom;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Hayk on 09.08.2021.
 */
public class Bathroom {
    private final Deque<Thread> deque;
    private final Semaphore semaphore = new Semaphore(3);

    public Bathroom() {
        this.deque = new ArrayDeque<>();
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public int size() {
        return deque.size();
    }

    public void add(Thread thread) {

        try {
            semaphore.acquire();
            while (deque.isEmpty()) {
                deque.addFirst(thread);
            }
            while (deque.size() < 3 && ((deque.peek() instanceof Male && thread instanceof Male) || (deque.peek() instanceof Female && thread instanceof Female))) {
                deque.addFirst(thread);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void remove() {

        while (!deque.isEmpty()) {

            deque.pollLast();
            semaphore.release();
        }
    }

    public synchronized boolean isEmpty() {
        return deque.isEmpty();
    }

}
