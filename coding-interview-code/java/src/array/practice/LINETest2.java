package array.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LINETest2 {
  static class SizedQueue {
    Queue<String> q;
    int maxSize;

    public SizedQueue(int maxSize) {
      q = new LinkedList<>();
      this.maxSize = maxSize;
    }

    public int getSize() {
      return q.size();
    }

    public boolean push(String value) {
      if(q.size() >= maxSize) return false;
      q.add(value);
      return true;
    }

    public String take() {
      return q.isEmpty() ? null : q.poll();
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine().trim();
    String[] numbers = input.split(" ");
    int numberOfCommands = Integer.valueOf(numbers[0]);
    int maxSize = Integer.valueOf(numbers[1]);

    SizedQueue queue = new SizedQueue(maxSize);
    for(int i = 0; i < numberOfCommands; i++) {
      String commandStr = br.readLine().trim();
      String[] token = commandStr.split(" ");
      String command = token[0];
      if(command.equals("OFFER")) {
        System.out.println(queue.push(token[1]));
      } else if(command.equals("TAKE")) {
        String value = queue.take();
        if(value != null) {
          System.out.println(value);
        }
      } else if(command.equals("SIZE")) {
        System.out.println(queue.getSize());
      }
    }
  }
}

