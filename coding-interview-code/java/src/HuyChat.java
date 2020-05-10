import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class HuyChat {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    Set<String> a = new HashSet<>();
    int result = 0;
    while(input != null && input.length() > 0) {
      char command = input.charAt(0);
      if(command == '+') {
        if(input.length() > 1) {
          a.add(input.substring(1));
        }
      } else if(command == '-') {
        if(input.length() > 1)
          a.remove(input.substring(1));
      } else {
        String[] messages = input.split(":");
        if(messages.length == 2 && a.contains(messages[0]))
          result+= (a.size() * (messages[1].length() + 1));
      }
      input = br.readLine();
    }
    System.out.println(result);
  }
}
