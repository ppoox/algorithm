package top50_string_array;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solve(list));
    }

    public static List<List<String>> solve(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();

        if(strs == null || strs.length == 0) {
            return resultList;
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            System.out.println(str);
            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            String key = String.valueOf(chars);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);

            }
        }
        resultList.addAll(map.values());

        return resultList;
    }

}
