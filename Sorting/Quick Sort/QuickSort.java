import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Sorting {
  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      String inputLine[] = br.readLine().trim().split(" ");
      int n = inputLine.length;
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(inputLine[i]);
      }
      new Solution().quickSort(arr, 0, n - 1);
      printArray(arr);
    }
  }
}

class Solution {
  void quickSort(int arr[], int low, int high) {
    int j;
    if (low < high) {
      j = partition(arr, low, high);
      quickSort(arr, low, j - 1);
      quickSort(arr, j + 1, high);
    }
  }

  static int partition(int arr[], int low, int high) {
    int pivot = arr[low];
    int i = low + 1;
    int j = high;
    int temp;
    while (i <= j) {
      while (i <= high && arr[i] <= pivot) {
        i++;
      }
      while (j >= low && arr[j] > pivot) {
        j--;
      }
      if (i < j) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    temp = arr[low];
    arr[low] = arr[j];
    arr[j] = temp;
    return j;
  }
}
