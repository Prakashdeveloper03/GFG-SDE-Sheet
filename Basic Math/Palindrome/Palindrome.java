import java.util.Scanner;

class Palindrome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    Solution ob = new Solution();
    while (T-- > 0) {
      int n = sc.nextInt();
      boolean ans = ob.isPalindrome(n);
      System.out.println(ans ? "true" : "false");
      System.out.println("~");
    }
    sc.close();
  }
}

class Solution {
  public boolean isPalindrome(int n) {
    int num = n, rem = 0, res = 0;
    while (n > 0) {
      rem = n % 10;
      res = res * 10 + rem;
      n /= 10;
    }
    return (res == num);
  }
}
