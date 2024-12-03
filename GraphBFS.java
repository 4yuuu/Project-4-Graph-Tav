import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
    private int vertices;
    private LinkedList<Integer> adjList[];
    private char nodes[];
public GraphBFS(int v){
    vertices = v;
    adjList = new LinkedList[v];
    nodes = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

    //initialize adjacency lists for all vertices
    for(int i = 0; i < v; i++){
        adjList[i] = new LinkedList<>();
    }
}

//method to add edge to graph
   public void addEdge(char v, int e){
      int vIndex = v - 'A'; //convert char to index
      int eIndex = e - 'A'; //covert char to index
      adjList[vIndex].add(eIndex); //add edge to adjacency list
    }

    //method to perform BFS traversal starting from given vertex
    public void BFS(char startVertexchar){
        int startVertex = startVertexchar - 'A'; //convert start vertex char to index
        boolean visited[] = new boolean[vertices]; //array to keep track of visited vertices
        Queue<Integer> queue = new LinkedList<>(); //queue for BFS

        visited[startVertex] = true; //mark start vertex as visited
        queue.add(startVertex); //add start vertex to queue

        //BFS loop
        while(!queue.isEmpty()){
            int vertex = queue.remove(); //dequeue vertex from queue
            System.out.print(nodes[vertex] + " "); //print visited vertex

            //gets all adjacent vertices of dequeued vertex
            int size = adjList[vertex].size();
            for(int i = 0; i < size; i++){
                int n = adjList[vertex].get(i);
                if(!visited[n]){ //if adjacent vertex has not been visited
                    visited[n] = true; //mark as visited
                    queue.add(n); //enqueue it 
                }
            }
        }
    }
}
