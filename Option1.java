import java.util.Scanner;

/*
* Write a word guessing code, “Guess My Word”
* that allows user to guess a word by 5-8 attempts in choosing letters.
* The program secretly picks a random word from the dictionary
* such as: 'apple', 'oracle', 'amazon', 'microsoft' (or use your own dictionary).
* Our player then tries to figure out what word was picked within 5-8 attempts.
* If the player succeeds, display “You win!”, otherwise: “Sorry, you lost!”

* Implement the problem in either Java, C or Python.
    Find out the execution time and memory used for the program code.
    Submit your document containing:
    the snippets of word guessing code, runtime displays of player guessing a word.
    Execution time and memory allocation.
* */
public class Option1 {
    public static void main(String[] args) {
        guessWord ();
    }
    public static void guessWord () {
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long beginTime = System.currentTimeMillis();

        String[] wordArr = {"apple", "oracle", "amazon", "microsoft"};
        String keyWord =  "amazon";

        int[] attemptTimesArr = {5,6,7,8};
        int attemptIndex = (int)(Math.random() * wordArr.length);
        int playerAttemptTimes = attemptTimesArr[attemptIndex];
        System.out.println("you have totally " + playerAttemptTimes + " times to guess a word");
        System.out.println("please guess in the filed : such as: 'apple', 'oracle', 'amazon', 'microsoft'");

        for (int i = 0; i < playerAttemptTimes; i++) {
            Scanner playerGuess = new Scanner(System.in);
            String payerWord = playerGuess.nextLine();
            if(payerWord.equals(keyWord)){
                System.out.println("You win!");
                break;
            }
            if(i < playerAttemptTimes -1 ){
                System.out.println("you have left " + (playerAttemptTimes - i - 1) + " times to guess a word");
                continue;
            }
            if(i == playerAttemptTimes -1 ){
                System.out.println("Sorry, you lost!");
                break;
            }
        }

        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long actualMemUsed=afterUsedMem-beforeUsedMem;
        long endTime = System.currentTimeMillis();
        long timeUsed = endTime-beginTime;

        System.out.println("memory allocation: " + actualMemUsed);
        System.out.println("time allocation: " + timeUsed);

        return;
    }
}
