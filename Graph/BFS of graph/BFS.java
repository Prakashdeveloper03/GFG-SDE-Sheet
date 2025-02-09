import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Solution {
  public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> bfs = new ArrayList<>();
    boolean visited[] = new boolean[adj.size()];
    Queue<Integer> q = new ArrayDeque<>();
    q.add(0);
    visited[0] = true;
    while (!q.isEmpty()) {
      Integer node = q.poll();
      bfs.add(node);
      for (Integer it : adj.get(node)) {
        if (visited[it] == false) {
          visited[it] = true;
          q.add(it);
        }
      }
    }
    return bfs;
  }
}

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine().trim());
    while (tc-- > 0) {
      int V = Integer.parseInt(br.readLine().trim());
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < V; i++) {
        String[] input = br.readLine().trim().split(" ");
        ArrayList<Integer> node = new ArrayList<>();
        for (String s : input) {
          if (!s.isEmpty()) {
            node.add(Integer.parseInt(s));
          }
        }
        adj.add(node);
      }
      Solution obj = new Solution();
      ArrayList<Integer> ans = obj.bfs(adj);
      for (int num : ans) System.out.print(num + " ");
      System.out.println();
      System.out.println("~");
    }
  }
}
