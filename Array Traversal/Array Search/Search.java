import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());

    while (t-- > 0) {
      String line = read.readLine().trim();
      String[] numsStr = line.split(" ");
      int[] nums = new int[numsStr.length];
      for (int i = 0; i < numsStr.length; i++) {
        nums[i] = Integer.parseInt(numsStr[i]);
      }

      int x = Integer.parseInt(read.readLine());

      Solution obj = new Solution();

      System.out.println(obj.search(nums, x));

      System.out.println("~");
    }
  }
}

class Solution {
  int search(int arr[], int x) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {

        return i;
      }
    }
    return -1;
  }
}
