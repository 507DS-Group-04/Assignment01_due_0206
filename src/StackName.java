import java.util.Stack;

public class StackName {
        public static String reverseString(String input) {
            Stack<Character> stack = new Stack<>();

            // Push each character of the input string onto the stack
            for (int i = 0; i < input.length(); i++) {
                stack.push(input.charAt(i));
            }

            // Pop characters from the stack to form the reversed string
            StringBuilder reversed = new StringBuilder();
            while (!stack.isEmpty()) {
                reversed.append(stack.pop());
            }

            return reversed.toString();
        }

    }
