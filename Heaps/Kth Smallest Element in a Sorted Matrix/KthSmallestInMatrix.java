import java.util.*;

class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        pq.add(matrix[i][j]);
      }
    }
    ArrayList<Integer> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(pq.poll());
    }
    return result.get(k - 1);
  }
}

class KthSmallestInMatrix {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int n = sc.nextInt();
      int[][] matrix = new int[n][n];
      for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
      int k = sc.nextInt();
      Solution obj = new Solution();
      System.out.println(obj.kthSmallest(matrix, k));
    }
    sc.close();
  }
}
