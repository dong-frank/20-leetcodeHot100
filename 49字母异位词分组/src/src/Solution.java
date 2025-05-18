import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            if (hashMap.containsKey(Arrays.toString(tmp))) {
                List<String> ls = hashMap.getOrDefault(Arrays.toString(tmp), new ArrayList<>());
                ls.add(str);
                hashMap.put(Arrays.toString(tmp), ls);
            } else {
                List<String> ls = new ArrayList<>();
                ls.add(str);
                hashMap.put(Arrays.toString(tmp), ls);
            }
        }
        return new ArrayList<>(hashMap.values());
    }

}
