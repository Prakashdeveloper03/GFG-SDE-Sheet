import java.util.Scanner;

class Solution {
  static class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    MinHeap(int cap) {
      heap = new int[cap];
      size = 0;
      capacity = cap;
    }

    void heapify(int i) {
      int smallest = i;
      int left = 2 * i + 1;
      int right = 2 * i + 2;

      if (left < size && heap[left] < heap[smallest]) {
        smallest = left;
      }

      if (right < size && heap[right] < heap[smallest]) {
        smallest = right;
      }

      if (smallest != i) {
        swap(i, smallest);
        heapify(smallest);
      }
    }

    void swap(int i, int j) {
      int temp = heap[i];
      heap[i] = heap[j];
      heap[j] = temp;
    }

    int extractMinElement() {
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
        if (heap[parent] > heap[ind]) {
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
      MinHeap heap = new MinHeap(cap);

      for (int i = 0; i < ops; i++) {
        String cmd = sc.next();
        if (cmd.equals("insert")) {
          int val = sc.nextInt();
          heap.insert(val);
        } else if (cmd.equals("extractMin")) {
          System.out.println(heap.extractMinElement());
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
