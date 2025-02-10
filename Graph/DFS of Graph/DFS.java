import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {
  ArrayList<Integer> result = new ArrayList<>();

  public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
    int n = adj.size();
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(visited, i, adj);
      }
    }
    return result;
  }

  void dfs(boolean[] visited, int node, ArrayList<ArrayList<Integer>> adj) {
    visited[node] = true;
    result.add(node);
    for (int it : adj.get(node)) {
      if (!visited[it]) {
        dfs(visited, it, adj);
      }
    }
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
      ArrayList<Integer> ans = obj.dfs(adj);
      for (int num : ans) {
        System.out.print(num + " ");
      }
      System.out.println();
      System.out.println("~");
    }
  }
}
