import java.util.Scanner;

class Solution {
  static class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    MaxHeap(int cap) {
      heap = new int[cap];
      size = 0;
      capacity = cap;
    }

    void heapify(int i) {
      int largest = i;
      int left = 2 * i + 1;
      int right = 2 * i + 2;

      if (left < size && heap[left] > heap[largest]) {
        largest = left;
      }

      if (right < size && heap[right] > heap[largest]) {
        largest = right;
      }

      if (largest != i) {
        swap(i, largest);
        heapify(largest);
      }
    }

    void swap(int i, int j) {
      int temp = heap[i];
      heap[i] = heap[j];
      heap[j] = temp;
    }

    int extractMaxElement() {
      if (size == 0) {
        return -1;
      }
      int ans = heap[0];
      swap(0, size - 1);
      size--;
      heapify(0);
      return ans;
    }

    void deleteElement(int ind) {
      if (ind >= size) {
        return;
      }
      swap(ind, size - 1);
      size--;
      heapify(ind);
    }

    void insert(int val) {
      if (size == capacity) {
        return;
      }
      heap[size] = val;
      int ind = size;
      size++;

      while (ind > 0) {
        int parent = (ind - 1) / 2;
        if (heap[parent] < heap[ind]) {
          swap(parent, ind);
          ind = parent;
        } else {
          break;
        }
      }
    }

    void printHeap() {
      for (int i = 0; i < size; i++) {
        System.out.print(heap[i] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt(); // number of test cases

    for (int t = 0; t < tc; t++) {
      int cap = sc.nextInt(); // capacity of heap
      int ops = sc.nextInt(); // number of operations
      MaxHeap heap = new MaxHeap(cap);

      for (int i = 0; i < ops; i++) {
        String cmd = sc.next();
        if (cmd.equals("insert")) {
          int val = sc.nextInt();
          heap.insert(val);
        } else if (cmd.equals("extractMax")) {
          System.out.println(heap.extractMaxElement());
        } else if (cmd.equals("delete")) {
          int ind = sc.nextInt();
          heap.deleteElement(ind);
        } else if (cmd.equals("print")) {
          heap.printHeap();
        }
      }
    }
    sc.close();
  }
}
