import java.util.Scanner;

class Solution {
  public int nthSuperUglyNumber(int n, int[] primes) {
    long[] dp = new long[n];
    dp[0] = 1;
    int k = primes.length;
    int[] indices = new int[k];
    long[] next = new long[k];
    for (int i = 0; i < k; i++) {
      next[i] = primes[i];
    }
    for (int i = 1; i < n; i++) {
      long min = Long.MAX_VALUE;
      for (int j = 0; j < k; j++) {
        min = Math.min(min, next[j]);
      }
      dp[i] = min;
      for (int j = 0; j < k; j++) {
        if (next[j] == min) {
          indices[j]++;
          next[j] = dp[indices[j]] * primes[j];
        }
      }
    }
    return (int) dp[n - 1];
  }
}

class SuperUglyNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = Integer.parseInt(sc.nextLine());
    Solution obj = new Solution();
    while (tc-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] primes = new int[k];
      for (int i = 0; i < n; i++) {
        primes[i] = sc.nextInt();
      }
      System.out.println(obj.nthSuperUglyNumber(n, primes));
    }
    sc.close();
  }
}
