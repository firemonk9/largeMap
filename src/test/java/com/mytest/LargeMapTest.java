package com.mytest;

import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by dhiraj on 8/6/16.
 */
public class LargeMapTest {


    @Test
    public void testAdd() throws Exception {
        Map<String, Integer> map = new HashMap<String, Integer>(20);
        final Random random = new Random();
        Runtime runtime = Runtime.getRuntime();
        int k = 1;
        long time = System.nanoTime();
        for (int i = 0; i < 60000000; i++) {
            k = random.nextInt();
            String key = new BigInteger(130, random).toString(50);
            int value = random.nextInt();

            if (i % 1000000 == 0) {
                long l = System.nanoTime();
                System.out.println("the counter is " + i + " ," + (l - time));
                time = l;
                map.put(key, value);
            }

            LargeMap.add(key, value);
            int value1 = LargeMap.get(key);

            if (value != value1)
                assert (false);

        }

        for (String s : map.keySet()) {
            if (LargeMap.get(s) != map.get(s))
                assert (false);

            if (LargeMap.get(s + s) != -1)
                assert (false);

        }
    }

//    @Test
//    public void testAddTiming() throws Exception {
//        Map<String, Integer> map = new HashMap<String, Integer>(20);
//        final Random random = new Random();
//        Runtime runtime = Runtime.getRuntime();
//        int k = 1;
//        System.gc();
//        long time = System.nanoTime();
//        long freeMemory = Runtime.getRuntime().freeMemory();
//        long totalMemory = Runtime.getRuntime().totalMemory();
//        long t1 = System.nanoTime();
//        for (int i = 0; i < 60000000; i++) {
//            k = random.nextInt();
//            String key = new BigInteger(130, random).toString(50);
//            int value = random.nextInt();
//
//            if (i % 1000000 == 0) {
//                long l = System.nanoTime();
//                System.out.println("the counter is " + i + " ," + (l - time));
//                time = l;
//
//            }
//            LargeMap.add(key, value);
//        }
//        long t2 = System.nanoTime();
//        long freeMemory1 = Runtime.getRuntime().freeMemory();
//        System.gc();
//        System.out.println("time taken to add is : " + (t2 - t1));
//        System.out.println("initial Free Memory :"+freeMemory);
//        System.out.println("final Free Memory :"+freeMemory1);
//        System.out.println("total Memory :"+totalMemory);
//    }


}