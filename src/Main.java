import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();

        Scanner userInputGradeArr = new Scanner(System.in);
        System.out.println("please input a string of 10 students stored,use format like this: <1,2,3,4,5,6,7,8,9,10>");
        // TODO try catch the no formal input
        String[] myList = userInputGradeArr.nextLine().split(",");
        int findMaxNum = 0;
        for (int i = 0;i<myList.length;i++) {
            Integer itemValue = Integer.parseInt(myList[i]);
            if (findMaxNum < itemValue) {
                findMaxNum =  itemValue;
            }
        }
        System.out.println(findMaxNum);
        System.out.println("for time is O(n) and for space is O(n)");
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        // totalMemory() is converted to bytes
        long actualMemUsed=(afterUsedMem-beforeUsedMem) / (1024);
        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
        System.out.println("for the real memory is " + actualMemUsed + "kb");

    }

}