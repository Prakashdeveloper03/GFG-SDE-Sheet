import java.util.ArrayList;
import java.util.Scanner;

class BoyerMooreAlgorithm {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCases = Integer.parseInt(scanner.nextLine());
    for (int t = 1; t <= testCases; t++) {
      String text = scanner.nextLine();
      String pattern = scanner.nextLine();
      ArrayList<Integer> result = Solution.patternSearch(text, pattern);
      for (int pos : result) {
        System.out.print(pos + " ");
      }
      System.out.println();
    }
    scanner.close();
  }
}

class Solution {
  public static ArrayList<Integer> patternSearch(String text, String pattern) {
    int textLength = text.length();
    int patternLength = pattern.length();
    ArrayList<Integer> matchPositions = new ArrayList<>();
    if (patternLength == 0 || textLength == 0 || patternLength > textLength) {
      matchPositions.add(-1);
      return matchPositions;
    }
    int ALPHABET_SIZE = 256;
    int[] badCharTable = new int[ALPHABET_SIZE];
    for (int i = 0; i < ALPHABET_SIZE; i++) {
      badCharTable[i] = -1;
    }
    for (int i = 0; i < patternLength; i++) {
      badCharTable[pattern.charAt(i)] = i;
    }

    int shift = 0;
    while (shift <= (textLength - patternLength)) {
      int indexInPattern = patternLength - 1;
      while (indexInPattern >= 0
          && pattern.charAt(indexInPattern) == text.charAt(shift + indexInPattern)) {
        indexInPattern--;
      }
      if (indexInPattern < 0) {
        matchPositions.add(shift);
        shift +=
            (shift + patternLength < textLength)
                ? patternLength - badCharTable[text.charAt(shift + patternLength)]
                : 1;
      } else {
        shift += Math.max(1, indexInPattern - badCharTable[text.charAt(shift + indexInPattern)]);
      }
    }
    if (matchPositions.isEmpty()) {
      matchPositions.add(-1);
    }
    return matchPositions;
  }
}
