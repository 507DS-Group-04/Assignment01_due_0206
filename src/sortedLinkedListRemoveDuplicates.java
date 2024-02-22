import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class sortedLinkedListRemoveDuplicates {
    public static void main(String[] args) {
        // create data
        Character[] strArr = {'N', 'Y','Y','I','T','T'};
        LinkedList<Character> lkList = new LinkedList<Character>();
        for (int i = 0; i < strArr.length; i++) {
            lkList.add(strArr[i]);
        }
        // deal data
        System.out.println(dealDuplicate(lkList));
    }
    public static LinkedList dealDuplicate(LinkedList lkList) {
        LinkedList<Character> newLkList = new LinkedList<Character>();
        // TODO can use JAVA hash like javascript {} to deal with the duplicate elements
        for (int i = 0; i < lkList.size(); i++) {
            Integer markDup = -1;
            for (int j = i+1; j < lkList.size(); j++) {
                if(lkList.get(i).equals(lkList.get(j))){
                    markDup = i;
                    break;
                }
            }
            if(markDup == -1){
                newLkList.add((Character) lkList.get(i));
            }
        }
        return newLkList;
    }
}
