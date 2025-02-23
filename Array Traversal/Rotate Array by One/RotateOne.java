import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class GFG {
  public static void main(String[] args) throws IOException {
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
      Solution ob = new Solution();
      ob.rotate(arr);
      for (int num : arr) {
        System.out.print(num + " ");
      }
      System.out.println();
      System.out.println("~");
    }
  }
}

class Solution {
  public void rotate(int[] arr) {
    int lastElement = arr[arr.length - 1];
    for (int i = arr.length - 1; i > 0; i--) {
      arr[i] = arr[i - 1];
    }
    arr[0] = lastElement;
  }
}
