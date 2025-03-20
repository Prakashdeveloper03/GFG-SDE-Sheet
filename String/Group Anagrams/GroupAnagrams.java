import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> groupedAnagrams = new HashMap<>();
    for (String word : strs) {
      char[] characters = word.toCharArray();
      Arrays.sort(characters);
      String sortedWord = new String(characters);
      groupedAnagrams.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
    }
    return new ArrayList<>(groupedAnagrams.values());
  }
}

public class GroupAnagrams {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = Integer.parseInt(scanner.nextLine());
    Solution solution = new Solution();
    for (int t = 0; t < testCases; t++) {
      int n = Integer.parseInt(scanner.nextLine());
      String[] input = new String[n];
      for (int i = 0; i < n; i++) {
        input[i] = scanner.nextLine();
      }
      List<List<String>> result = solution.groupAnagrams(input);
      for (List<String> x : result) {
        for (String s : x) {
          System.out.print(s + " ");
        }
      }
    }
    scanner.close();
  }
}
