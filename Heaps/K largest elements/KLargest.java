import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
  public ArrayList<Integer> kLargest(int[] arr, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int num : arr) {
      pq.offer(num);
    }
    ArrayList<Integer> ans = new ArrayList<>();
    while (k-- > 0) {
      int e = pq.poll();
      ans.add(e);
    }
    return ans;
  }
}

class KLargest {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
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
      int k = Integer.parseInt(br.readLine());
      Solution ob = new Solution();
      ArrayList<Integer> ans = ob.kLargest(arr, k);
      for (int num : ans) {
        System.out.print(num + " ");
      }
      System.out.println();
      System.out.println("~");
    }
  }
}
