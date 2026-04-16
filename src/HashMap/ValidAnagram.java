package HashMap;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char currChar = t.charAt(i);
            int currCount = map.getOrDefault(currChar, -1);
            if (currCount <= 0) {
                return false;
            }
            map.put(currChar, currCount - 1);
        }

        return true;
    }
}
