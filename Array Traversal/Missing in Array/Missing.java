import java.io.BufferedReader;
import java.io.InputStreamReader;

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
      System.out.println(new Solution().missingNumber(arr));
      System.out.println("~");
    }
  }
}

class Solution {
  int missingNumber(int arr[]) {
    int n = arr.length + 1;
    int sum = n * (n + 1) / 2;
    int given_sum = 0;
    for (int i = 0; i <= arr.length - 1; i++) {
      given_sum += arr[i];
    }
    int result = sum - given_sum;
    return result;
  }
}
