package ru.netology;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        int[] tax1 = taxService.arrayGenerate();
        int[] tax2 = taxService.arrayGenerate();
        int[] tax3 = taxService.arrayGenerate();

        Thread thread1 = new Thread(null, () -> taxService.sum(tax1), "Shop №1");
        Thread thread2 = new Thread(null, () -> taxService.sum(tax2), "Shop №2");
        Thread thread3 = new Thread(null, () -> taxService.sum(tax3), "Shop №3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread3.join();
            thread2.join();
            thread1.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        System.out.println("Налоги с магазина Shop№1 - " + Arrays.toString(tax1));
        System.out.println("Налоги с магазина Shop№2 - " + Arrays.toString(tax2));
        System.out.println("Налоги с магазина Shop№3 - " + Arrays.toString(tax3));
        System.out.println("Общая сумма налога составила: " + taxService.getCurrent());
    }
}

