package SlidingWindow;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || words == null || words.length == 0) return result;

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        if (s.length() < totalLength) return result;

        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // We try wordLength different starting offsets
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            int count = 0;

            Map<String, Integer> window = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (!freq.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                window.put(word, window.getOrDefault(word, 0) + 1);
                count++;

                while (window.get(word) > freq.get(word)) {
                    String leftWord = s.substring(left, left + wordLength);
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLength;
                    count--;
                }

                if (count == wordCount) {
                    result.add(left);
                }
            }
        }

        return result;
    }
}
