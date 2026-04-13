package HashMap;

import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char currChar = magazine.charAt(i);
            int currCount = map.getOrDefault(currChar, 0);
            map.put(currChar, currCount + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char currChar = ransomNote.charAt(i);
            int currCount = map.getOrDefault(currChar, 0);
            if (currCount == 0) {
                return false;
            } else {
                map.put(currChar, currCount - 1);
            }
        }
        return true;
    }

    /*Works because it's only lower letters*/
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] countArray = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char currChar = magazine.charAt(i);
            countArray[currChar - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char currChar = ransomNote.charAt(i);
            int currCount = --countArray[currChar - 'a'];
            if (currCount < 0) {
                return false;
            }
        }
        return true;
    }
}