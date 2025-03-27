import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class SearchPattern {
  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s, patt;
      s = sc.next();
      patt = sc.next();
      Solution ob = new Solution();
      ArrayList<Integer> res = ob.search(patt, s);
      if (res.size() == 0) System.out.print("-1 ");
      else {
        for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
      }
      System.out.println();
    }
    sc.close();
  }
}

class Solution {
  ArrayList<Integer> search(String pattern, String text) {
    int patternLength = pattern.length();
    int textLength = text.length();
    ArrayList<Integer> matchPositions = new ArrayList<>();
    for (int i = 0; i <= textLength - patternLength; i++) {
      String currentSubstring = text.substring(i, i + patternLength);
      if (currentSubstring.equals(pattern)) {
        matchPositions.add(i + 1);
      }
    }
    if (textLength < patternLength || matchPositions.size() == 0) matchPositions.add(-1);
    return matchPositions;
  }
}
