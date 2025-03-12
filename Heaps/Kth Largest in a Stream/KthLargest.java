import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Solution {
  int[] kthLargest(int k, int[] arr, int n) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int ans[] = new int[n];
    for (int i = 0; i < n; i++) {
      pq.add(arr[i]);
      if (pq.size() < k) ans[i] = -1;
      else {
        while (pq.size() > k) pq.remove();
        ans[i] = pq.peek();
      }
    }
    return ans;
  }
}
;

class KthLargest {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String S[] = read.readLine().split(" ");

      int k = Integer.parseInt(S[0]);
      int n = Integer.parseInt(S[1]);

      String S1[] = read.readLine().split(" ");

      int[] arr = new int[n];

      for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(S1[i]);

      Solution ob = new Solution();
      int[] ptr = ob.kthLargest(k, arr, n);
      for (int i = 0; i < n; i++) System.out.print(ptr[i] + " ");
      System.out.println();

      System.out.println("~");
    }
  }
}
