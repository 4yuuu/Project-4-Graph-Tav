
import java.util.*;
/* 
 class to perform BFS traversal
*/
public class GraphBFS {
    private int vertices; //number of vertices im graph
    private LinkedList<Integer> adjList[]; //adjacency list to represent graph edges
    private char nodes[]; //character representation of graph noses

@SuppressWarnings("unchecked")
public GraphBFS(int v){
    vertices = v;
    adjList = new LinkedList[v]; //initialize adjacency list for each vertex
    nodes = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'}; //node labels

    for(int i = 0; i < v; i++){
        adjList[i] = new LinkedList<>(); //creates new list for each vertex
    }
}
   public void addEdge(char v, int e){
      int vIndex = v - 'A'; //converts character to index
      int eIndex = e - 'A'; //converts character to index
      adjList[vIndex].add(eIndex); //add edge to adjacency list
    }
    public void BFS(char startVertexchar){
        List<Character> traversalOrder = breadthFirstTrav(startVertexchar); //performs BFS traversal
            for (char vertex : traversalOrder) {
                System.out.print(vertex + " "); //prints traversal order
            }
        }

    public List<Character> breadthFirstTrav(char startVertexChar) {
        int startVertex = startVertexChar - 'A'; //converts start vertex to index
        boolean visited[] = new boolean[vertices]; //tracks visited vertices
        Queue<Integer> queue = new LinkedList<>(); //queue for BFS
        List<Character> traversalOrder = new ArrayList<>(); //stores traversal order
        
        visited[startVertex] = true; //marks start vertex as visited
        queue.add(startVertex); //enqueues start vertex

        while(!queue.isEmpty()){
            int vertex = queue.remove(); //dequeues a vertex
            System.out.print(nodes[vertex] + " "); //processes vertex

            int size = adjList[vertex].size();
            for(int i = 0; i < size; i++){
                int n = adjList[vertex].get(i); //gets adjacent vertex
                if(!visited[n]){
                    visited[n] = true; //marks as visited
                    queue.add(n); //enqueues vertex
                }
            }
        }
        return traversalOrder; //returns order of traversal
    }

}