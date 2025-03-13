import java.util.Scanner;

class Solution {
  public int nthUglyNumber(int n) {
    if (n == 1) return 1;
    int[] dp = new int[n];
    dp[0] = 1;
    int i2 = 0, i3 = 0, i5 = 0;
    for (int i = 1; i < n; i++) {
      int next = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
      dp[i] = next;
      if (next == dp[i2] * 2) i2++;
      if (next == dp[i3] * 3) i3++;
      if (next == dp[i5] * 5) i5++;
    }
    return dp[n - 1];
  }
}

class UglyNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = Integer.parseInt(sc.nextLine());
    Solution obj = new Solution();
    while (tc-- > 0) {
      int n = Integer.parseInt(sc.nextLine());
      System.out.println(obj.nthUglyNumber(n));
    }
    sc.close();
  }
}
