package Main;

import java.util.List;

public class Consumer implements Runnable {

    List<Integer> products = null;


    public Consumer(List<Integer> products) {
        this.products = products;
    }

    public void ConsumeItems() throws InterruptedException {


        synchronized (products) {
            while (products.isEmpty()) {
                System.out.println("No products..... waiting the producer to get products ");
                products.wait();

            }
        }

        synchronized (products) {

            products.remove(0);
            System.out.println("Costumer consumed : " + products.size());
            products.notify();
            Thread.sleep(200);
        }
    }


    @Override
    public void run() {


        while (true) {

            try {
                ConsumeItems();
            } catch (InterruptedException e) {
            }
        }
    }
}