package array.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LINETest5 {
  static class Graph {
    int vertices;
    LinkedList<Integer>[] adjList;

    public Graph(int vertices) {
      this.vertices = vertices;
      adjList = new LinkedList[vertices];
      for (int i = 0; i < vertices; i++) {
        adjList[i] = new LinkedList<>();
      }
    }

    public void addEdge(int source, int destination) {
      adjList[source].addFirst(destination);
      adjList[destination].addFirst(source);
    }

    public boolean isCycle() {
      boolean result = false;
      boolean[] visited = new boolean[vertices];
      for (int i = 0; i < vertices; i++) {
        if (!visited[i]) {
          if (isCycleUtil(i, visited, -1)) {
            return true;
          }
        }
      }
      return result;
    }

    boolean isCycleUtil(int currVertex, boolean[] visited, int parent) {

      visited[currVertex] = true;

      for (int i = 0; i < adjList[currVertex].size(); i++) {
        int vertex = adjList[currVertex].get(i);
        if (vertex != parent) {
          if (visited[vertex]) {
            return true;
          } else {
            if (isCycleUtil(vertex, visited, currVertex)) {
              return true;
            }
          }
        }
      }
      return false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int numberOfNodes = Integer.valueOf(br.readLine());
    Graph g = new Graph(numberOfNodes);

    String str;
    while ((str=br.readLine())!=null && str.length()!=0) {
      String[] split = str.split(" ");
      int node1 = Integer.valueOf(split[0]);
      int node2 = Integer.valueOf(split[1]);
      g.addEdge(node1, node2);
    }

    System.out.println(g.isCycle());

  }
}
