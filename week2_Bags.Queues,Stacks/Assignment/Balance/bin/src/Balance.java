import java.util.HashMap;
import java.util.Scanner;
import edu.princeton.cs.algs4.Stack;


public class Balance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (isBalanced(input)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        sc.close();
    }

    /**
     * Check if the input string is balanced.
     * The input string contains only the following characters: (, ), [, ], {, }.
        * The string is balanced if the following conditions are met:
        * 1. For every opening bracket (i.e., (, [, or {) there is a matching closing bracket (i.e., ), ], or }) of the same type (i.e., ( matches ), [ matches ], and { matches }).
        * 2. An opening bracket must appear before (to the left of) its matching closing bracket (e.g., ]{}[ is not balanced).
        * 3. No unmatched braces lie between some pair of matched braces. Each opening brace must have a corresponding closing brace (e.g., ({} is balanced, but {}( is not balanced).
        * 4. No unmatched bracket is permitted.
     *The Stack class is provided by the algs4.jar library. The HashMap map is used to store the matching pairs of brackets.
     *The loop is used to iterate through the input string. If the current character is an opening bracket, it is pushed onto the stack.
     *If the current character is a closing bracket, the top element of the stack is popped. 
     *If the popped element is not the matching opening bracket, the input string is not balanced. 
     *If the stack is empty when a closing bracket is encountered, the input string is not balanced. 
     *If the stack is not empty after the loop, the input string is not balanced.
     * 
     * @param input
     *            the input string
     * @return true if the input string is balanced, false otherwise
     */

    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.containsValue(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (map.get(top) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
