package HashMap;

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!mapS.containsKey(sChar)) {
                mapS.put(sChar, i);
            }

            if (!mapT.containsKey(tChar)) {
                mapT.put(tChar, i);
            }

            if (!mapS.get(sChar).equals(mapT.get(tChar))) {
                return false;
            }
        }
        return true;
    }
}
