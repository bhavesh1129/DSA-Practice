package challengeQns.goldman;

import java.util.*;

public class AnagramsTogether {
    public static void main(String[] args) {
        String[] words = {"act", "god", "cat", "dog", "tac"};
        List<List<String>> ans = anagrams(words);
        System.out.println(ans);
    }

    private static List<List<String>> anagrams(String[] words) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String i : words) {
            char[] wordsArr = i.toCharArray();
            Arrays.sort(wordsArr);

            String reqStr = new String(wordsArr);
            List<String> valueList = map.getOrDefault(reqStr, new ArrayList<>());
            valueList.add(i);
            map.put(reqStr, valueList);
        }
        List<List<String>> ans = new ArrayList<>();
        ans.addAll(map.values());
        return ans;
    }
}
