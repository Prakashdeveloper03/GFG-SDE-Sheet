import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      int N = Integer.parseInt(read.readLine());
      Solution ob = new Solution();
      if (ob.isPerfectNumber(N)) System.out.println("true");
      else System.out.println("false");
      System.out.println("~");
    }
  }
}

class Solution {
  boolean isPerfectNumber(int n) {
    long res = 0;
    for (int i = 1; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        res += i;
        if (n / i != n) res = res + n / i;
      }
    }
    return (res == n);
  }
}
;
