package Lesson_3;

public class main {
    public static void main(String[] args) {
        PingPong pp = new PingPong();
        System.out.println("++++++++++PingPong+++++++++++++");
        new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                pp.ping();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                pp.pong();
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("++++++++++Counter+++++++++++++");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    Counter.increment();
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter: " + Counter.getCounter());

    }

}
