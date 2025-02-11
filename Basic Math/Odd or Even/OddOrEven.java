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
      if (ob.isEven(N)) System.out.println("true");
      else System.out.println("false");
    }
  }
}

class Solution {
  boolean isEven(int n) {
    return (n % 2 == 0);
  }
}
