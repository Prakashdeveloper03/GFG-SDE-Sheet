import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(read.readLine());
      Solution ob = new Solution();
      if (ob.isPrime(n)) {
        System.out.println("true");
      } else {
        System.out.println("false");
      }
      System.out.println("~");
    }
  }
}

class Solution {
  boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= n / i; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }
}
