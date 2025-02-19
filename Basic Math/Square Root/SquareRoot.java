import java.util.Scanner;

class SquartRoot {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int a = sc.nextInt();
      Solution obj = new Solution();
      System.out.println(obj.floorSqrt(a));
      t--;
    }
    sc.close();
  }
}

class Solution {
  int floorSqrt(int n) {
    int low = 1, high = n, mid;
    while (low <= high) {
      mid = low + (high - low) / 2;
      if (mid * mid <= n) low = mid + 1;
      else high = mid - 1;
    }
    return high;
  }
}
