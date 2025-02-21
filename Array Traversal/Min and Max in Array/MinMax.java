import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {
  @SuppressWarnings({"rawtypes", "unchecked"})
  public Pair<Integer, Integer> getMinMax(int[] arr) {
    int minElement = arr[0], maxElement = arr[0];
    for (int i = 1; i < arr.length; i++) {
      minElement = (arr[i] < minElement) ? arr[i] : minElement;
      maxElement = (arr[i] > maxElement) ? arr[i] : maxElement;
    }
    return new Pair(minElement, maxElement);
  }
}

class Pair<K, V> {
  private final K key;
  private final V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t;
    t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      String line = br.readLine();
      String[] tokens = line.split(" ");
      ArrayList<Integer> array = new ArrayList<>();
      for (String token : tokens) {
        array.add(Integer.parseInt(token));
      }
      int[] arr = new int[array.size()];
      int idx = 0;
      for (int i : array) arr[idx++] = i;
      Solution ob = new Solution();
      Pair<Integer, Integer> pp = ob.getMinMax(arr);
      System.out.println(pp.getKey() + " " + pp.getValue());
      System.out.println("~");
    }
  }
}
