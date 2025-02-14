import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
  public int reverseDigits(int n) {
    int rem = 0, rev = 0;
    while (n > 0) {
      rem = n % 10;
      rev = rev * 10 + rem;
      n /= 10;
    }
    return rev;
  }
}

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());
      Solution ob = new Solution();
      int ans = ob.reverseDigits(n);
      System.out.println(ans);
      System.out.println("~");
    }
  }
}
