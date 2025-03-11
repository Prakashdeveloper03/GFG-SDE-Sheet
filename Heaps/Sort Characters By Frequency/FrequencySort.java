import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
  public String frequencySort(String s) {
    Map<Character, Integer> hm = new HashMap<>();

    for (char c : s.toCharArray()) {
      hm.put(c, hm.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> pq =
        new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

    pq.addAll(hm.entrySet());

    StringBuilder result = new StringBuilder();
    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> entry = pq.poll();
      result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
    }

    return result.toString();
  }
}

class FrequencySort {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = Integer.parseInt(sc.nextLine());
    Solution obj = new Solution();
    while (tc-- > 0) {
      String s = sc.nextLine();
      String result = obj.frequencySort(s);
      System.out.println(result);
    }
    sc.close();
  }
}
