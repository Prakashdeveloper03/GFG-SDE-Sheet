import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
  public void bubbleSort(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      int flag = 0;
      for (int j = 0; j < n - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          flag = 1;
        }
      }
      if (flag == 0) break;
    }
  }
}

class Sorting {
  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
    while (t > 0) {
      String inputLine[] = br.readLine().trim().split(" ");
      int n = inputLine.length;
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(inputLine[i]);
      }
      new Solution().bubbleSort(arr);
      printArray(arr);
      t--;
    }
  }
}
