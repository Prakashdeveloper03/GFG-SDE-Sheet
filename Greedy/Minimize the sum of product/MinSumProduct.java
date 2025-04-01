import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
  public long minValue(List<Integer> arr1, List<Integer> arr2) {
    Collections.sort(arr1);
    Collections.sort(arr2, Collections.reverseOrder());
    long minSum = 0;
    int size = arr1.size();
    for (int i = 0; i < size; i++) minSum += (long) (arr1.get(i) * arr2.get(i));
    return minSum;
  }
}

class MinSumProduct {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    while (t-- > 0) {
      List<Integer> arr1 = new ArrayList<>();
      List<Integer> arr2 = new ArrayList<>();
      String input1 = sc.nextLine();
      StringTokenizer st1 = new StringTokenizer(input1);
      while (st1.hasMoreTokens()) {
        arr1.add(Integer.parseInt(st1.nextToken()));
      }
      String input2 = sc.nextLine();
      StringTokenizer st2 = new StringTokenizer(input2);
      while (st2.hasMoreTokens()) {
        arr2.add(Integer.parseInt(st2.nextToken()));
      }
      Solution ob = new Solution();
      long ans = ob.minValue(arr1, arr2);
      System.out.println(ans);
    }
    sc.close();
  }
}
