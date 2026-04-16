package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    ValidAnagram validAnagram = new ValidAnagram();

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listAnagrams = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].equals(" ")) {
                List<String> groupAnagram = new ArrayList<>();
                groupAnagram.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (validAnagram.isAnagram(strs[i], strs[j])) {
                        groupAnagram.add(strs[j]);
                        strs[j] = " ";
                    }
                }
                listAnagrams.add(groupAnagram);
                strs[i] = " ";
            }
        }
        return listAnagrams;
    }

    public List<List<String>> groupAnagramsImproved(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
