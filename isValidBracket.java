import java.util.LinkedList;

public class isValidBracket {
    public boolean isValid(String s) {
        if (s.length() == 1) return false;
        LinkedList<Character> stack = new LinkedList<>();
        char c;
        char top;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                top = stack.pop();
                if (top == '(' && c == ')' || top == '{' && c == '}' || top == '[' && c == ']') {
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}
