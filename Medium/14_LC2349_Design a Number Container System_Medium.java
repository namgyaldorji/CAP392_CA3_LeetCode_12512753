import java.util.*;
class NumberContainers {


    HashMap<Integer, Integer> map;
    HashMap<Integer, TreeSet<Integer>> sets;

public NumberContainers() {
        map = new HashMap<>();
        sets = new HashMap<>();
    }

    public void change(int index, int number) {

        if (map.containsKey(index)) {
            int old = map.get(index);
            sets.get(old).remove(index);
        }
        map.put(index, number);
        sets.putIfAbsent(number, new TreeSet<>());
        sets.get(number).add(index);
    }
    public int find(int number) {
    if (!sets.containsKey(number) || sets.get(number).isEmpty()) {
            return -1;
        }
return sets.get(number).first();
    }
}
