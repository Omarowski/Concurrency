package Main;

import java.util.List;

public class Producer implements Runnable {

    final int LIMIT = 5;
    List<Integer> products = null;
    private int productNo;

    public Producer(List<Integer> products) {
        this.products = products;
    }

    public void Market(int productNo) throws InterruptedException {

        synchronized (products) {
            while (products.size() == LIMIT) {
                //System.out.println("Limit reached.....awaiting for new products " );
                products.wait();

            }
        }
        synchronized (products) {


            System.out.println("Product :" + products.size());
            products.add(productNo);
            Thread.sleep(1000);
            products.notify();
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                Market(productNo++);
            } catch (InterruptedException ignored) {


            }

        }
    }
}
