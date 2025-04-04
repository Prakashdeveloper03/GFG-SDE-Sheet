import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      Stack<Integer> s = new Stack<>();
      int n = sc.nextInt();
      while (n-- > 0) s.push(sc.nextInt());
      GfG g = new GfG();
      Stack<Integer> a = g.sort(s);
      while (!a.empty()) {
        System.out.print(a.peek() + " ");
        a.pop();
      }
      System.out.println();
      System.out.println("~");
    }
    sc.close();
  }
}

class GfG {
  public Stack<Integer> sort(Stack<Integer> s) {
    Stack<Integer> st = new Stack<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    while (!s.isEmpty()) {
      int i = s.pop();
      pq.add(i);
    }
    while (!pq.isEmpty()) {
      int i = pq.remove();
      st.push(i);
    }
    return st;
  }
}
