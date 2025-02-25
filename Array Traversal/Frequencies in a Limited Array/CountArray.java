import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Geeks {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int g = 0; g < t; g++) {
      String[] str = (br.readLine()).trim().split(" ");
      int arr[] = new int[str.length];
      for (int i = 0; i < str.length; i++) {
        arr[i] = Integer.parseInt(str[i]);
      }
      List<Integer> result = new Solution().frequencyCount(arr);
      if (result.isEmpty()) {
        System.out.println("[]");
      } else {
        for (int i = 0; i < result.size(); i++) {
          if (i != 0) System.out.print(" ");
          System.out.print(result.get(i));
        }
        System.out.println();
      }
    }
  }
}

class Solution {
  public List<Integer> frequencyCount(int[] arr) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int x : arr) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }
    for (int i = 1; i <= arr.length; i++) {
      result.add(map.getOrDefault(i, 0));
    }
    return result;
  }
}
