package Lesson_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private static final Lock l = new ReentrantLock();
    private static int counter = 0;

    public static int getCounter() {
        return counter;
    }

    public static void increment() {
        l.lock();
        counter++;
        l.unlock();
    }
}
