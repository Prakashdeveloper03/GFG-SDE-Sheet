import java.util.Scanner;
import java.util.Stack;

class RemoveAdjacentDuplicates {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while (tc-- > 0) {
      String chars = sc.nextLine();
      Solution ob = new Solution();
      System.out.println(ob.removeDuplicates(chars));
    }
    sc.close();
  }
}

class Solution {
  public String removeDuplicates(String chars) {
    if (chars.length() == 1) return chars;
    Stack<Character> s = new Stack<>();
    for (char ch : chars.toCharArray()) {
      if (s.isEmpty() || s.peek() != ch) s.push(ch);
      else s.pop();
    }
    String res = "";
    while (!s.isEmpty()) res = s.pop() + res;
    return res;
  }
}
