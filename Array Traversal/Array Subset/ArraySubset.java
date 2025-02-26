import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine().trim());
    while (t-- > 0) {
      String line = read.readLine().trim();
      String[] numsStr = line.split(" ");
      int[] a = new int[numsStr.length];
      for (int i = 0; i < numsStr.length; i++) {
        a[i] = Integer.parseInt(numsStr[i]);
      }
      line = read.readLine().trim();
      numsStr = line.split(" ");
      int[] b = new int[numsStr.length];
      for (int i = 0; i < numsStr.length; i++) {
        b[i] = Integer.parseInt(numsStr[i]);
      }
      Solution ob = new Solution();
      if (ob.isSubset(a, b)) System.out.println("true");
      else System.out.println("false");
      System.out.println("~");
    }
  }
}

class Solution {
  public boolean isSubset(int a[], int b[]) {
    Map<Integer, Integer> mapA = new HashMap<>();
    Map<Integer, Integer> mapB = new HashMap<>();
    for (int x : a) {
      mapA.put(x, mapA.getOrDefault(x, 0) + 1);
    }
    for (int x : b) {
      mapB.put(x, mapB.getOrDefault(x, 0) + 1);
    }
    for (int x : mapB.keySet()) {
      if (mapB.get(x) > mapA.getOrDefault(x, 0)) {
        return false;
      }
    }
    return true;
  }
}
