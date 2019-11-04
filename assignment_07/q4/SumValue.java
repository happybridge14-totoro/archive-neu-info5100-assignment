package q4;
import java.util.Random;
public class SumValue {
    static private class Worker implements Runnable {
      private int index;
      private int[] data;
      private long[] result;
      Worker(int index, int[] data, long[] result) {
        this.index = index;
        this.data = data;
        this.result = result;
      }
      public void run() {
        final int THREADS_COUNT = 4;
        final int COUNT = 1000000;
        long sumResult = 0;
        for (int i = 0; i < COUNT; i++) {
          sumResult += data[i + index * THREADS_COUNT];
        }
        result[index] = sumResult;
      }
    }

    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
      Random random = new Random();
      for (int i = 0; i < arr.length; i++) {
        arr[i] = random.nextInt();
      }
    }

    /*get sum of an array using 4 threads*/
    static long sum(int[] arr){
        final int THREADS_COUNT = 4;
        long[] ret = new long[THREADS_COUNT];
        Thread[] threadArray = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
          Worker runnable = new Worker(i, arr, ret);
          Thread t = new Thread(runnable);
          threadArray[i] = t;
          t.start();
        }
        long sumResult = 0;
        for (int i = 0; i < THREADS_COUNT; i++) {
          try {
            threadArray[i].join();
          } catch (InterruptedException e) {
            System.out.println(e);
          }
        }
        for (int i = 0; i < THREADS_COUNT; i++) {
          sumResult += ret[i];
        }
        return sumResult;
    }

    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }
}
