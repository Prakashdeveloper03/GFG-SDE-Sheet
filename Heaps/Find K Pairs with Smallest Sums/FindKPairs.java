import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

    for (int i = 0; i < nums1.length && i < k; i++) minHeap.add(new int[] {nums1[i], nums2[0], 0});

    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
      int[] curr = minHeap.poll();
      result.add(List.of(curr[0], curr[1]));
      int nums2Idx = curr[2];
      if (nums2Idx < nums2.length - 1)
        minHeap.add(new int[] {curr[0], nums2[nums2Idx + 1], nums2Idx + 1});
    }
    return result;
  }
}

class KFrequent {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    Solution obj = new Solution();
    while (tc-- > 0) {
      int n1 = sc.nextInt();
      int[] nums1 = new int[n1];
      for (int i = 0; i < n1; i++) {
        nums1[i] = sc.nextInt();
      }
      int n2 = sc.nextInt();
      int[] nums2 = new int[n2];
      for (int i = 0; i < n2; i++) {
        nums2[i] = sc.nextInt();
      }
      int k = sc.nextInt();
      List<List<Integer>> res = obj.kSmallestPairs(nums1, nums2, k);
      for (List<Integer> x : res) {
        for (int y : x) {
          System.out.printf("%d ", y);
        }
      }
    }
    sc.close();
  }
}
