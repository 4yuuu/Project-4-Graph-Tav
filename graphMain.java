import java.util.LinkedList;
import java.util.Stack;

public class graphMain {
    private int vertices;
    private LinkedList<Integer> adjList[];
    private char nodes[];

    public graphMain(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        nodes = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(char v, int e) {
        int vIndex = v - 'A';
        int eIndex = e - 'A';
        adjList[vIndex].add(eIndex);
    }

    public void DFS(char startVertexChar) {
        int startVertex = startVertexChar - 'A';
        boolean visited[] = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                System.out.print(nodes[vertex] + " ");
                visited[vertex] = true;
            }

            for (int i = adjList[vertex].size() - 1; i >= 0; i--) { // Reverse order to mimic recursive DFS
                int neighbor = adjList[vertex].get(i);
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public static void main(String args[]) {
        GraphDFS graph = new GraphDFS(9);

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

        System.out.println("Depth First Traversal: ");
        graph.DFS('A');
    }
}
