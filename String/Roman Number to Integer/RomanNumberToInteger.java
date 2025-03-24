import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class RomanNumberToInteger {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine().trim());
    while (tc-- > 0) {
      String s = br.readLine().trim();
      Solution ob = new Solution();
      System.out.println(ob.romanToDecimal(s));

      System.out.println("~");
    }
  }
}

class Solution {
  public int romanToDecimal(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    int res = map.get(s.charAt(s.length() - 1));
    for (int i = 0; i < s.length() - 1; i++) {
      if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) res -= map.get(s.charAt(i));
      else res += map.get(s.charAt(i));
    }
    return res;
  }
}
