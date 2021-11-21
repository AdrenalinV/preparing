package Lesson_3;

public class PingPong {
    boolean ping = true;

    public synchronized void ping() {
        while (!ping) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ping");
        ping = false;
        notifyAll();

    }

    public synchronized void pong() {
        while (ping) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("pong");
        ping = true;
        notifyAll();
    }
}
