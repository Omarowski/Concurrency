package Main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> products = new ArrayList<Integer>();

        Thread production = new Thread(new Producer(products));
        Thread production1 = new Thread(new Producer(products));
        Thread production2 = new Thread(new Producer(products));
        Thread production3 = new Thread(new Producer(products));
        Thread production4 = new Thread(new Producer(products));

        Thread consuming = new Thread(new Consumer(products));
        Thread consuming1 = new Thread(new Consumer(products));
        Thread consuming2 = new Thread(new Consumer(products));
        Thread consuming3 = new Thread(new Consumer(products));
        Thread consuming4 = new Thread(new Consumer(products));
        Thread consuming5 = new Thread(new Consumer(products));
        Thread consuming6 = new Thread(new Consumer(products));
        Thread consuming7 = new Thread(new Consumer(products));
        Thread consuming8 = new Thread(new Consumer(products));

        production.start();
        production1.start();
        production2.start();
        production3.start();
        production4.start();

        consuming.start();
        consuming1.start();
        consuming2.start();
        consuming3.start();
        consuming4.start();
        consuming5.start();
        consuming6.start();
        consuming7.start();
        consuming8.start();



    }
}
