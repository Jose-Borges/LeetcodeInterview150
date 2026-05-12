package ArrayString;

import java.util.Arrays;

public class H_Index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int counter = 0;
        int length = citations.length;
        for (int i = 0; i < length; i++) {
            if (citations[i] >= length - i) {
                counter = length - i;
                break;
            }
        }
        return counter;
    }
}
