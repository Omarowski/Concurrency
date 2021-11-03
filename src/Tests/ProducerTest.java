package Tests;

import Main.Consumer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ProducerTest {

    @Test
    public void Producer_Empty_List() {
        java.util.List<Integer> products = new ArrayList<Integer>();

        Thread CustomerB = new Thread(new Consumer(products));
        CustomerB.start();
        int capacity = products.size();
        Assert.assertEquals(capacity, 0);


    }

    @Test
    public void Producer_Full_List() throws InterruptedException {
        java.util.List<Integer> products = new ArrayList<Integer>();
        products.add(1);
        products.add(1);
        products.add(1);
        products.add(1);
        products.add(1);

        Thread consuming = new Thread(new Consumer(products));
        Thread.sleep(2000);
        consuming.start();
        int capacity = products.size();
        Assert.assertEquals(capacity, 5);


    }
}