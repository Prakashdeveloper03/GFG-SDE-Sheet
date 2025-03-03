import java.util.Scanner;
import java.util.Stack;

class Driverclass {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String st = sc.next();
      if (new Solution().isBalanced(st) == true) System.out.println("true");
      else System.out.println("false");

      System.out.println("~");
    }
    sc.close();
  }
}

class Solution {
  boolean isBalanced(String s) {
    Stack<Character> paren = new Stack<>();
    boolean flag = true;
    int n = s.length();
    paren.push(s.charAt(0));
    for (int i = 1; i < n; ++i) {
      if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
        if (paren.isEmpty()) {
          flag = false;
          break;
        } else if ((s.charAt(i) == ')' && paren.peek() != '(')
            || (s.charAt(i) == '}' && paren.peek() != '{')
            || (s.charAt(i) == ']' && paren.peek() != '[')) {
          flag = false;
          break;
        } else {
          paren.pop();
        }
      } else {
        paren.push(s.charAt(i));
      }
    }
    return flag && paren.isEmpty();
  }
}
