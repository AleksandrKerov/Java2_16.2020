package Lesson4;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
        thirdMethod();
        forthMethod();
    }

    public static void firstMethod() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();

        System.out.println("Last number is: " + arr[size - 1]);
        System.out.println("First method without Thread: " + (System.currentTimeMillis() - a));
    }

    private static void secondMethod() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5)
                        * Math.cos(0.4f + (i + h) / 2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.currentTimeMillis();

        System.out.println("Last number is: " + arr[size - 1]);
        System.out.println("Second method with Thread: " + (System.currentTimeMillis() - a));
    }

    private static void thirdMethod(){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = (size-1); i >= h; i--) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.currentTimeMillis();

        System.out.println("Last number is: " + arr[size-1]);
        System.out.println("Third method with Thread: " + (System.currentTimeMillis() - a));
    }

    private static void forthMethod(){
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < size/4; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = size/4; i < size/2; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = size/2; i < size*3/4; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = (size-1); i >= size*3/4; i--) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.currentTimeMillis();

        System.out.println("Last number is: " + arr[size-1]);
        System.out.println("Forth method with Thread: " + (System.currentTimeMillis() - a));
    }
}
