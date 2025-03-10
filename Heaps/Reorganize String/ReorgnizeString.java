import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
  public String reorganizeString(String s) {
    HashMap<Character, Integer> freqMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Character> maxHeap =
        new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
    maxHeap.addAll(freqMap.keySet());
    StringBuilder res = new StringBuilder();
    while (maxHeap.size() >= 2) {
      char char1 = maxHeap.poll();
      char char2 = maxHeap.poll();
      res.append(char1);
      res.append(char2);
      freqMap.put(char1, freqMap.get(char1) - 1);
      freqMap.put(char2, freqMap.get(char2) - 1);

      if (freqMap.get(char1) > 0) maxHeap.add(char1);
      if (freqMap.get(char2) > 0) maxHeap.add(char2);
    }

    if (!maxHeap.isEmpty()) {
      char ch = maxHeap.poll();
      if (freqMap.get(ch) > 1) return "";
      res.append(ch);
    }

    return res.toString();
  }
}

class FrequencySort {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = Integer.parseInt(sc.nextLine());
    Solution obj = new Solution();
    while (tc-- > 0) {
      String s = sc.nextLine();
      String result = obj.reorganizeString(s);
      System.out.println(result);
    }
    sc.close();
  }
}
