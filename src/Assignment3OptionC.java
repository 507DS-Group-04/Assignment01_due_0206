import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* Priority queueing
* */
public class Assignment3OptionC {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        Queue<Integer> priorityQ = new PriorityQueue<>() {
        };
        Integer[] intArr = {3,0,5,6};
        for (int  i= 0; i < intArr.length;i ++) {
            priorityQ.offer(intArr[i]);
        }
        while (!priorityQ.isEmpty()){
            System.out.println(priorityQ.poll());
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 1000000;
        long mem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
        System.out.println("memory requirement: "+ mem +"KB and CPU execution time " + time + " ms");
    }
}
