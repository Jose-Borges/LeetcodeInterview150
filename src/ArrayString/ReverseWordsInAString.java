package ArrayString;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int wordsLength = words.length;
        String[] inversedWords = new String[wordsLength];
        for (int i = 0; i < wordsLength; i++) {
            inversedWords[i] = words[wordsLength - i - 1];
        }
        return String.join(" ", inversedWords);
    }
}
