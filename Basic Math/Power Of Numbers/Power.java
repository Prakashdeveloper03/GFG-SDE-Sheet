import java.util.Scanner;

class Solution {
  public int reverseExponentiation(int n) {
    int rem = 0, rev = 0, original = n;
    while (n > 0) {
      rem = n % 10;
      rev = rev * 10 + rem;
      n /= 10;
    }
    return (int) Math.pow(original, rev);
  }
}

class Power {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    Solution ob = new Solution();
    while (T-- > 0) {
      int n = sc.nextInt();
      int ans = ob.reverseExponentiation(n);
      System.out.println(ans);
    }
    sc.close();
  }
}
