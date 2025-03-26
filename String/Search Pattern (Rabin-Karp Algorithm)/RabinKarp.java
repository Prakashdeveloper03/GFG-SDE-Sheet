import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class RabinKarp {
  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String s, patt;
      s = sc.next();
      patt = sc.next();

      Solution ob = new Solution();

      ArrayList<Integer> res = ob.search(patt, s);

      for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
      System.out.println();
    }
    sc.close();
  }
}

class Solution {
  ArrayList<Integer> search(String pattern, String text) {
    ArrayList<Integer> arr = new ArrayList<>();
    int i = 0, n = text.length();
    int nn = pattern.length();
    while (i <= n - nn) {
      if (Objects.equals(text.substring(i, i + nn), pattern)) {
        arr.add(i + 1);
      }
      i++;
    }
    return arr;
  }
}
