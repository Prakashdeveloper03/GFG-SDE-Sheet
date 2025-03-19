import java.util.Scanner;
import java.util.Stack;

class Solution {
  public int countMinReversals(String s) {
    if (s.length() % 2 != 0) return -1;
    int ans = 0;
    Stack<Character> st = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '{') {
        st.push('{');
      } else {
        if (st.isEmpty()) {
          ans++;
          st.push('{');
        } else {
          st.pop();
        }
      }
    }
    return ans + st.size() / 2;
  }
}

class CountReversals {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution sol = new Solution();
    int t = sc.nextInt();
    sc.nextLine();
    while (t-- > 0) {
      String s = sc.nextLine();
      System.out.println(sol.countMinReversals(s));
      System.out.println("~");
    }
    sc.close();
  }
}
