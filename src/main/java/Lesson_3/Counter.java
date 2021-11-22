package Lesson_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final Lock l = new ReentrantLock();
    private int counter = 0;

    public  int getCounter() {
        return counter;
    }

    public  void increment() {
        l.lock();
        counter++;
        l.unlock();
    }
}
