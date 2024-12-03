import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class GraphBFS {
    private int vertices;
    private LinkedList<Integer> adjList[];
    private char nodes[];

@SuppressWarnings("unchecked")
public GraphBFS(int v){
    vertices = v;
    adjList = new LinkedList[v];
    nodes = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

    for(int i = 0; i < v; i++){
        adjList[i] = new LinkedList<>();
    }
}
   public void addEdge(char v, int e){
      int vIndex = v - 'A';
      int eIndex = e - 'A';
      adjList[vIndex].add(eIndex);
    }
    public void BFS(char startVertexchar){
        List<Character> traversalOrder = breadthFirstTrav(startVertexchar);
            for (char vertex : traversalOrder) {
                System.out.print(vertex + " ");
            }
        }

    public List<Character> breadthFirstTrav(char startVertexChar) {
        int startVertex = startVertexChar - 'A';
        boolean visited[] = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        List<Character> traversalOrder = new ArrayList<>();
        
        visited[startVertex] = true;
        queue.add(startVertex);

        while(!queue.isEmpty()){
            int vertex = queue.remove();
            System.out.print(nodes[vertex] + " ");

            int size = adjList[vertex].size();
            for(int i = 0; i < size; i++){
                int n = adjList[vertex].get(i);
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return traversalOrder;
    }

}


