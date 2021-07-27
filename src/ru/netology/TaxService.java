package ru.netology;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TaxService {
    AtomicInteger taxResult = new AtomicInteger(0);

    public void sum(int[] array) {
        for (int j : array) {
            taxResult.addAndGet(j);
        }
    }

    public int[] arrayGenerate() {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    public long getCurrent() {
        return taxResult.get();
    }
}
