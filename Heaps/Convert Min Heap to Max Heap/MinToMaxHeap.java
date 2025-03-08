import java.io.IOException;
import java.util.Scanner;

class MinToMaxHeap {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      Solution obj = new Solution();
      obj.convertMinToMaxHeap(n, a);
      for (int e : a) {
        System.out.print(e + " ");
      }
      System.out.println();

      System.out.println("~");
    }
    sc.close();
  }
}

class Solution {
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static void downheap(int[] arr, int n, int index) {
    int max = index;
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    if (left < n && arr[left] > arr[max]) {
      max = left;
    }
    if (right < n && arr[right] > arr[max]) {
      max = right;
    }
    if (max != index) {
      swap(arr, index, max);
      downheap(arr, n, max);
    }
  }

  void convertMinToMaxHeap(int N, int arr[]) {
    for (int i = N / 2 + 1; i >= 0; i--) {
      downheap(arr, N, i);
    }
  }
}
