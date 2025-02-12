import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      int N = Integer.parseInt(read.readLine());
      Solution ob = new Solution();
      System.out.println(ob.evenlyDivides(N));
      System.out.println("~");
    }
  }
}

class Solution {
  int evenlyDivides(int n) {
    List<Integer> list = new ArrayList<>();
    int num = n;
    while (num > 0) {
      int ld = num % 10;
      if (ld != 0 && n % ld == 0) {
        list.add(ld);
      }
      num = num / 10;
    }
    return list.size();
  }
}
