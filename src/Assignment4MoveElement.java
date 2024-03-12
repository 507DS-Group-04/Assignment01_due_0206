import java.util.LinkedList;
/*
* Move last element to front of a given linked list
* */
public class Assignment4MoveElement {
    public static void main(String[] args) {


        LinkedList<String> lkList = new LinkedList<String>();
        long startTime = System.nanoTime();
        lkList.add("N");
        lkList.add("Y");
        lkList.add("I");
        lkList.add("T");

        int lastIndex = lkList.size() - 1;
        String lastItem = lkList.get(lastIndex);
        lkList.remove(lastIndex);
        lkList.add(0,lastItem);

        System.out.println(lkList);

        long endTime = System.nanoTime();
        long time = (endTime - startTime);
        long mem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 ;
        System.out.println("memory requirement: "+ mem +"KB and CPU execution time " + time + " ns");
    }
}
