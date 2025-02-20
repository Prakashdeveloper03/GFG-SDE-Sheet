import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t;
    t = Integer.parseInt(br.readLine());
    while (t-- > 0) {

      int a;
      a = Integer.parseInt(br.readLine());

      int b;
      b = Integer.parseInt(br.readLine());

      Solution obj = new Solution();
      int res = obj.gcd(a, b);

      System.out.println(res);

      System.out.println("~");
    }
  }
}

class Solution {
  public int gcd(int a, int b) {
    if (a == b) return a;
    if (a == 0) return b;
    if (b == 0) return a;
    else return gcd(b, a % b);
  }
}
