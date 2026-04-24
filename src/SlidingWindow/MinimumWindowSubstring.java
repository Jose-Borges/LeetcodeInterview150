package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {

    //Exceeded Time
    public String minWindow(String s, String t) {
        String minSubstring = "";
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int count = 0;
            int left = 0;
            HashMap<Character, Integer> window = new HashMap<>();
            if (freq.containsKey(currChar)) {
                if (t.length() == 1) {
                    return t;
                }
                window.put(currChar, 1);
                count++;
                for (int j = i + 1; j < s.length(); j++) {
                    currChar = s.charAt(j);
                    if (freq.containsKey(currChar)) {
                        if (window.isEmpty() || window.size() == 1 && window.containsValue(1)) {
                            left = j;
                        }
                        window.put(currChar, window.getOrDefault(currChar, 0) + 1);

                        if (window.get(currChar) <= freq.get(currChar)) count++;

                        if (count == t.length()) {
                            char leftChar = s.charAt(i);
                            int charCount = window.getOrDefault(leftChar, -1);
                            // Remove duplicates at beginning
                            while (charCount != -1 && window.put(leftChar, charCount - 1) > freq.get(leftChar)){
                                leftChar = s.charAt(++i);
                                charCount = window.getOrDefault(leftChar, -1);
                            }
                            if (minSubstring.isEmpty() || minSubstring.length() > j - i) {
                                minSubstring = s.substring(i, j + 1);
                            }
                            i = left - 1;
                            break;
                        }
                    }
                }
            }
        }
        return minSubstring;
    }

    public String minWindowII(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int formed = 0;
        int required = need.size();

        HashMap<Character, Integer> window = new HashMap<>();

        int minLen = -1;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                formed++;
            }

            // Try to shrink the window
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == -1 ? "" : s.substring(start, start + minLen);
    }
}
