import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Assignment2OptionC {

    //three towers, the goal is to move all the disks from tower A to tower B; each integer represent a disk; the disk with larger number can't be put above the disk with lower number
    static int count = 0; //used to count how many steps
    public static void process(int n, char towerA, char towerB, char towerC) {
        if (n == 0){
        return;
    }

     process(n-1, towerA, towerC, towerB);
     System.out.println("Move disk " + n + " from " + towerA + " to " + towerC);
     count += 1;
     process(n-1, towerB, towerA, towerC);
    }
    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long beginTime = System.currentTimeMillis();
        int numDisk;
        Scanner disks = new Scanner(System.in);
        System.out.println("Type in number of disks: ");
        numDisk = disks.nextInt();

        process(numDisk, 'A', 'B', 'C');

        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long actualMemUsed = (afterUsedMem - beforeUsedMem) / 1024;
        long endTime = System.currentTimeMillis();
        long timeUsed = endTime - beginTime;
        System.out.println("The total steps: " + count + "\n" + "Took " + timeUsed + " ns" + "\n" + "for the real memory is " + actualMemUsed + "kb");
    }
}





















