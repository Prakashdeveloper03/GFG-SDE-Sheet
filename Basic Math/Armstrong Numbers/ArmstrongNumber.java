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
      boolean flag = ob.armstrongNumber(n);
      if (flag) {
        System.out.println("true");

      } else {
        System.out.println("false");
      }

      System.out.println("~");
    }
  }
}

class Solution {
  boolean armstrongNumber(int n) {
    int num = n, rem = 0, res = 0;
    while (n > 0) {
      rem = n % 10;
      res = res + (rem * rem * rem);
      n /= 10;
    }
    return (res == num);
  }
}
