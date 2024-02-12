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
        long startTime = System.nanoTime();
        int numDisk;
        Scanner disks = new Scanner(System.in);
        System.out.println("Type in number of disks: ");
        numDisk = disks.nextInt();

        process(numDisk, 'A', 'B', 'C');

        long endTime = System.nanoTime();
        System.out.println("The total steps: " + count + "\n" + "Took " + (endTime - startTime) + " ns");
    }
}




























   //     StringBuilder reversed = new StringBuilder();
    //    while (!stackmaster.isEmpty()) {
   //         reversed.append(stackmaster.pop());
   //     }
    //    long endTime = System.nanoTime();
       //System.out.println("The reversed string is " + reversed + "\n" + "Took " + (endTime - startTime) + " ns");

