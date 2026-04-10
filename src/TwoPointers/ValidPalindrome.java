package TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String regexPattern = "[^a-zA-Z0-9]";
        s = s.replaceAll(regexPattern, "").toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
