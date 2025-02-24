import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      String input = br.readLine();
      String[] inputArray = input.split("\\s+");
      int a[] = new int[inputArray.length];
      for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);
      Solution ob = new Solution();
      ob.sort012(a);
      for (int num : a) {
        System.out.print(num + " ");
      }
      System.out.println();
      System.out.println("~");
    }
  }
}

class Solution {
  public void sort012(int[] arr) {
    int c0 = 0, c1 = 0, c2 = 0;
    for (int x : arr) {
      if (x == 0) c0++;
      if (x == 1) c1++;
      if (x == 2) c2++;
    }
    int idx = 0;

    for (int i = 0; i < c0; i++) arr[idx++] = 0;

    for (int i = 0; i < c1; i++) arr[idx++] = 1;

    for (int i = 0; i < c2; i++) arr[idx++] = 2;
  }
}
