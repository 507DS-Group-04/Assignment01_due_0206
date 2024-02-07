import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main (String[] args) {
//        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//        long startTime = System.nanoTime();
//
//        Scanner userInputGradeArr = new Scanner(System.in);
//        System.out.println("please input a string of 10 students stored,use format like this: <1,2,3,4,5,6,7,8,9,10>");
//        // TODO try catch the no formal input
//        String[] myList = userInputGradeArr.nextLine().split(",");
//        int findMaxNum = 0;
//        for (int i = 0;i<myList.length;i++) {
//            Integer itemValue = Integer.parseInt(myList[i]);
//            if (findMaxNum < itemValue) {
//                findMaxNum =  itemValue;
//            }
//        }
//        System.out.println(findMaxNum);
//        System.out.println("for time is O(n) and for space is O(n)");
//        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//        // totalMemory() is converted to bytes
//        long actualMemUsed=(afterUsedMem-beforeUsedMem) / (1024);
//        long endTime = System.nanoTime();
//        System.out.println("Took "+(endTime - startTime) + " ns");
//        System.out.println("for the real memory is " + actualMemUsed + "kb");

//        String foo = "yunlong li";
//        Stack<Character> reversed = new Stack<Character> ();
//        for (int i = foo.length () - 1; i >= 0; i--) {
//            reversed.push((foo.charAt (i)));
//        }
//        String stStr = reversed.stream().map(s -> s.toString()).collect(Collectors.joining(""));
//        System.out.println(stStr);

        long startTime = System.nanoTime();
        String foo = "yunlong li";
        Stack<Character> stackmaster = new Stack<Character> ();

        for (int i = 0; i < foo.length(); i++) {
            stackmaster.push(foo.charAt(i));
        }

        StringBuilder reversed = new StringBuilder();
        while (!stackmaster.isEmpty()) {
            reversed.append(stackmaster.pop());
        }
        long endTime = System.nanoTime ();
        System.out.println("The reversed string is " + reversed+ "\n" + "Took " + (endTime - startTime) + " ns");



    }
}
