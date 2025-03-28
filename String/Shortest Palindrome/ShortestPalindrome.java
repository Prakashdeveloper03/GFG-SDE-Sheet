import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
  public String shortestPalindrome(String s) {
    int count = kmp(new StringBuilder(s).reverse().toString(), s);
    return new StringBuilder(s.substring(count)).reverse().toString() + s;
  }

  private int kmp(String txt, String patt) {
    String newString = patt + '#' + txt;
    int[] pi = new int[newString.length()];
    int i = 1, k = 0;
    while (i < newString.length()) {
      if (newString.charAt(i) == newString.charAt(k)) {
        k++;
        pi[i] = k;
        i++;
      } else {
        if (k > 0) {
          k = pi[k - 1];
        } else {
          pi[i] = 0;
          i++;
        }
      }
    }
    return pi[newString.length() - 1];
  }
}

class ShortestPalindrome {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine().trim());
    while (tc-- > 0) {
      String s = br.readLine().trim();
      Solution ob = new Solution();
      System.out.println(ob.shortestPalindrome(s));
    }
  }
}
