import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    TreeMap<String, Integer> map = new TreeMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    for (int n : map.values()) {
      maxheap.add(n);
    }

    ArrayList<String> list = new ArrayList<>();
    for (int i = 1; i <= k; ++i) {
      int n = maxheap.poll();
      String str = findword(map, n);
      map.remove(str);
      list.add(str);
    }
    return list;
  }

  public String findword(TreeMap<String, Integer> map, int n) {
    for (String s : map.keySet()) {
      if (map.get(s) == n) {
        return s;
      }
    }
    return " ";
  }
}

class KFrequentWords {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = Integer.parseInt(sc.nextLine());
    while (tc-- > 0) {
      int n = Integer.parseInt(sc.nextLine());
      String[] words = new String[n];
      for (int i = 0; i < n; i++) {
        words[i] = sc.nextLine();
      }
      int k = Integer.parseInt(sc.nextLine());
      Solution obj = new Solution();
      List<String> res = obj.topKFrequent(words, k);
      for (String word : res) {
        System.out.print(word + " ");
      }
      System.out.println();
    }

    sc.close();
  }
}
