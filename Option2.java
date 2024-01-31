/*
* Write a code to find the highest grade of 10 students stored in a linear array.
* Implement the problem in either Java, C or Python.
    Find out the execution time and memory used for the program code.
    Submit your document containing:
    the snippets of word guessing code, runtime displays of player guessing a word.
    Execution time and memory allocation.
* */
public class Option2 {
    public static void main(String[] args) {
        System.out.println("the highest grade of 10 students stored in a linear array {10,20,30,40,50,60,70,80,90,100} is :"+findHighestGrade());
    }
    public static int findHighestGrade() {
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long beginTime = System.currentTimeMillis();

        // test for a long array list to show memory and time, new int [100000000];
        int[] stuGradesArr = {10,20,30,40,50,60,70,80,90,100};
        int findMaxNum = 0;
        for (int i = 0;i<stuGradesArr.length;i++) {
            Integer itemValue = stuGradesArr[i];
            if (findMaxNum <= itemValue) {
                findMaxNum =  itemValue;
            }
        }

        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long actualMemUsed=afterUsedMem-beforeUsedMem;
        long endTime = System.currentTimeMillis();
        long timeUsed = endTime-beginTime;

        System.out.println("memory allocation: " + actualMemUsed);
        System.out.println("time allocation: " + timeUsed);

        return  findMaxNum;
    }
}
