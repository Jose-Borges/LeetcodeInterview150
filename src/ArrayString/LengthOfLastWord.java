package ArrayString;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int emptyLast = 0;
        while (s.charAt(i) == ' ') {
            i--;
            emptyLast++;
        }
        while (i >= 0 && s.charAt(i) != ' ') i--;
        return s.length() - i - 1 - emptyLast;
    }
}
