
import java.util.LinkedList;
import java.util.Queue;

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
        int startVertex = startVertexchar - 'A';
        boolean visited[] = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
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
    }
public static void main(String args[]){
    GraphBFS graph = new GraphBFS(9);

    graph.addEdge('A', 'B');
    graph.addEdge('A', 'D');
    graph.addEdge('A', 'E');
    graph.addEdge('B', 'E');
    graph.addEdge('D', 'G');
    graph.addEdge('E', 'F');
    graph.addEdge('E', 'H');
    graph.addEdge('G', 'H');
    graph.addEdge('F', 'C');
    graph.addEdge('F', 'H');
    graph.addEdge('H', 'I');
    graph.addEdge('C', 'B');
    graph.addEdge('I', 'F');

    System.out.println("Breadth First Traversal: ");
    graph.BFS('A');
}

}
