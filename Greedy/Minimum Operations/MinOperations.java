import java.util.Scanner;

public class MinOperations {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      Solution ob = new Solution();
      System.out.println(ob.minOperation(n));
    }
    sc.close();
  }
}

class Solution {
  public int minOperation(int n) {
    if (n == 0) return 0;
    int count = 1;
    int k = n;
    while (k != 1) {
      if (k % 2 == 0) {
        k /= 2;
        count++;
      } else {
        k -= 1;
        count++;
      }
    }
    return count;
  }
}
