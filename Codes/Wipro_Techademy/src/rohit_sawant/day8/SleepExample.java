package rohit_sawant.day8;

public class SleepExample implements Runnable {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {

        SleepExample task1 = new SleepExample();
        SleepExample task2 = new SleepExample();

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.setName("Thread-1"); // works on Thread object
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}
