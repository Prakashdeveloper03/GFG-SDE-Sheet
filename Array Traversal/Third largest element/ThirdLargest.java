import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class ThirdLargest {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      String line = br.readLine();
      String[] tokens = line.split(" ");
      ArrayList<Long> array = new ArrayList<>();
      for (String token : tokens) {
        array.add(Long.parseLong(token));
      }
      int[] arr = new int[array.size()];
      int idx = 0;
      for (long i : array) arr[idx++] = (int) i;
      Solution obj = new Solution();
      System.out.println(obj.thirdLargest(arr));
      System.out.println("~");
    }
  }
}

class Solution {
  int thirdLargest(int arr[]) {
    int n = arr.length;
    if (n <= 2) return -1;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < arr.length; i++) {
      maxHeap.add(arr[i]);
    }
    for (int i = 1; i < 3; i++) {
      maxHeap.remove();
    }
    return maxHeap.peek();
  }
}
