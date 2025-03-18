import java.util.Scanner;

class Solution {
  public String countAndSay(int n) {
    String res = "1";
    for (int i = 1; i < n; i++) {
      StringBuilder temp = new StringBuilder();
      int count = 1;
      for (int j = 1; j < res.length(); j++) {
        if (res.charAt(j) == res.charAt(j - 1)) {
          count++;
        } else {
          temp.append(count).append(res.charAt(j - 1));
          count = 1;
        }
      }
      temp.append(count).append(res.charAt(res.length() - 1));
      res = temp.toString();
    }
    return res;
  }
}

class CountAndSay {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      System.out.println(obj.countAndSay(n));
    }
    sc.close();
  }
}
