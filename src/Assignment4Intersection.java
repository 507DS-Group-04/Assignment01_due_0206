import java.util.LinkedList;

/*
* Intersection of two sorted linked lists
* */
public class Assignment4Intersection {
    public static <Int> void main(String[] args) {
        long startTime = System.nanoTime();

        LinkedList<String> lkListOne = new LinkedList<String>();
        lkListOne.add("N");
        lkListOne.add("Y");
        lkListOne.add("I");
        lkListOne.add("T");
        lkListOne.add("1");
        lkListOne.add("2");
        lkListOne.add("3");
        lkListOne.add("4");
        lkListOne.add("5");

        LinkedList<String> lkListTwo = new LinkedList<String>();
        lkListTwo.add("T");
        lkListTwo.add("1");
        lkListTwo.add("2");
        lkListTwo.add("3");
        lkListTwo.add("6");
        lkListTwo.add("Y");

        LinkedList<String> lkListIntersection = new LinkedList<String>();
        LinkedList<String> lkListLonger = lkListOne.size() >= lkListTwo.size() ?lkListOne:lkListTwo;
        LinkedList<String> lkListShorter = lkListOne.size() <= lkListTwo.size() ?lkListOne:lkListTwo;
        for (int i = 0; i < lkListShorter.size(); i++) {
            if(lkListLonger.contains(lkListShorter.get(i))){
                lkListIntersection.add(lkListShorter.get(i));
            }
        }

        System.out.println(lkListIntersection);

        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 1000000;
        long mem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
        System.out.println("memory requirement: "+ mem +"KB and CPU execution time " + time + " ms");
    }
}
