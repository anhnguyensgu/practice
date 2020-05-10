import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombination {
  public List<String> letterCombinations(String digits) {
    char[][] letters = {
        {'a', 'b', 'c', 0},
        {'d', 'e', 'f', 0},
        {'g', 'h', 'i', 0},
        {'j', 'k', 'l', 0},
        {'m', 'n', 'o', 0},
        {'q', 'p', 'r', 's'},
        {'t', 'u', 'v', 0},
        {'w', 'x', 'y', 'z'}
    };
    if (digits.isEmpty()) return new ArrayList<>();
    List<String> result = new ArrayList<>();
    result.add("") ;
    for(char c: digits.toCharArray()) {
      char[] set = letters[c - '2'];
      List<String> temp = new ArrayList<>();
      for(String s : result) {
        for(char c1: set) {
          if(c1 != 0)
            temp.add(s+c1);
        }
      }
      result = temp;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new LetterCombination().letterCombinations("23"));
  }
}
