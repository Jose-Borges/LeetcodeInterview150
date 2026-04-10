package ArrayString;

import java.util.*;

class RandomizedSet {

    private final Random random;
    private final List<Integer> list;

    public RandomizedSet() {
        random = new Random();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (list.contains(val)) {
            return false;
        }
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!list.contains(val)) {
            return false;
        }
        list.remove(Integer.valueOf(val));
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
