package HashMap;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        HashMap<Character, String> patternToWord = new HashMap<>();
        HashMap<String, Character> wordToPattern = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char currChar = pattern.charAt(i);
            String currWord = words[i];

            if (patternToWord.containsKey(currChar)) {
                if (!patternToWord.get(currChar).equals(currWord)) {
                    return false;
                }
            } else {
                patternToWord.put(currChar, currWord);
            }

            if (wordToPattern.containsKey(currWord)) {
                if (!wordToPattern.get(currWord).equals(currChar)) {
                    return false;
                }
            } else {
                wordToPattern.put(currWord, currChar);
            }
        }
        return true;
    }
}
