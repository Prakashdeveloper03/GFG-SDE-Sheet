import java.io.IOException;
import java.util.Scanner;

class LemonadeChange {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }

      Solution obj = new Solution();
      boolean ans = obj.lemonadeChange(n, a);
      System.out.println(ans ? "True" : "False");
    }
    sc.close();
  }
}

class Solution {
  boolean lemonadeChange(int N, int bills[]) {
    int five = 0;
    int ten = 0;
    for (int bill : bills) {
      if (bill == 5) {
        five++;
      } else if (bill == 10) {
        if (five > 0) {
          five--;
          ten++;
        } else {
          return false;
        }
      } else {
        if (five > 0 && ten > 0) {
          ten--;
          five--;
        } else if (five >= 3) {
          five -= 3;
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
