import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinJumps {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t;
    t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      String line = br.readLine();
      String[] tokens = line.split(" ");
      ArrayList<Integer> array = new ArrayList<>();
      for (String token : tokens) {
        array.add(Integer.parseInt(token));
      }
      int[] arr = new int[array.size()];
      int idx = 0;
      for (int i : array) arr[idx++] = i;
      System.out.println(new Solution().minJumps(arr));
    }
  }
}

class Solution {
  int minJumps(int[] arr) {
    int jumps = 0;
    int curr_limit = 0;
    int max_limit = 0;
    for (int i = 0; i < arr.length - 1 && i <= curr_limit; i++) {
      max_limit = Math.max(max_limit, arr[i] + i);
      if (i >= curr_limit) {
        jumps++;
        curr_limit = max_limit;
      }
    }
    return curr_limit >= arr.length - 1 ? jumps : -1;
  }
}
