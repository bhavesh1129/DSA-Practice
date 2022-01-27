package challengeQns.amazon;

import java.util.*;

public class FirstNonRepeatingCharInAStream {
    public static void main(String[] args) {
        String str = "abadbc";
        System.out.println(firstNonRepeating(str));
    }

    private static String firstNonRepeating(String str) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<Character>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            queue.add(ch);

            while (!queue.isEmpty()) {
                if (map.containsKey(queue.peek()) && map.get(queue.peek()) > 1) {
                    queue.poll();
                } else {
                    break;
                }
            }
            if (queue.isEmpty()) {
                sb.append('#');
            } else {
                sb.append(queue.peek());
            }
        }
        return sb.toString();
    }
}
