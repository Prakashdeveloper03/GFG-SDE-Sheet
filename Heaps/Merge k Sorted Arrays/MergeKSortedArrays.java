import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class MergeKSortedArrays {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int n = sc.nextInt();
      int[][] a = new int[n][n];
      for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();
      Solution T = new Solution();
      ArrayList<Integer> arr = T.mergeKArrays(a, n);
      for (int i = 0; i < n * n; i++) System.out.print(arr.get(i) + " ");
      System.out.println();

      t--;

      System.out.println("~");
    }
    sc.close();
  }
}

class Solution {
  public ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < k; j++) {
        pq.add(arr[i][j]);
      }
    }
    ArrayList<Integer> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(pq.poll());
    }
    return result;
  }
}
