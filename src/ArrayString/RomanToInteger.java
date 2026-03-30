package ArrayString;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int i = 0;
        int total = 0;
        while (i < s.length()) {
            char firstChar = s.charAt(i);
            if (i == s.length() - 1) {
                total += map.get(firstChar);
                break;
            }
            char secondChar = s.charAt(i + 1);
            if (map.get(firstChar) < map.get(secondChar)) {
                total += map.get(secondChar) - map.get(firstChar);
                i += 2;
            } else {
                total += map.get(firstChar);
                i++;
            }
        }
        return total;
    }
}
