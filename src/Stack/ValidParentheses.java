package Stack;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() <= 1) return false;
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            switch (currChar) {
                case '{', '(', '[' -> list.add(currChar);
                case '}' -> {
                    if (list.isEmpty() || list.removeLast() != '{') return false;
                }
                case ']' -> {
                    if (list.isEmpty() || list.removeLast() != '[') return false;
                }
                case ')' -> {
                    if (list.isEmpty() || list.removeLast() != '(') return false;
                }
            }
        }
        return list.isEmpty();
    }
}
