import java.util.*;

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

        
        
        //perform BFS
        GraphBFS graphBFS = new GraphBFS(9);

        graphBFS.addEdge('A', 'B');
        graphBFS.addEdge('A', 'D');
        graphBFS.addEdge('A', 'E');
        graphBFS.addEdge('B', 'E');
        graphBFS.addEdge('D', 'G');
        graphBFS.addEdge('E', 'F');
        graphBFS.addEdge('E', 'H');
        graphBFS.addEdge('G', 'H');
        graphBFS.addEdge('F', 'C');
        graphBFS.addEdge('F', 'H');
        graphBFS.addEdge('H', 'I');
        graphBFS.addEdge('C', 'B');
        graphBFS.addEdge('I', 'F');
    
        System.out.println("Breadth First Traversal: ");
        graphBFS.BFS('A');
            
    
            //get traversal orders of Breadth first
            List<Character> breadthFirstOrder = graphBFS.breadthFirstTrav('A');
    
    
            //create and display the trees
            System.out.println("Breadth First Traversal Tree:");
            Map<String, List<String>> breadthFirstTree = constructTree(convertToListString(breadthFirstOrder));
            printTree(breadthFirstTree);
            
    
            //for Depth tree, continue later
            //System.out.println("\nDepth First Traversal Tree:");
            //Map<String, List<String>> depthFirstTree = constructTree(depthFirstOrder);
            //printTree(depthFirstTree);
        }
    
        //method to convert List<Character> into List<String>
        private static List<String> convertToListString(List<Character> list) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                result.add(String.valueOf(list.get(i)));
            }
            return result;
        }
        
        //Method to construct tree from traversal order
        private static Map<String, List<String>> constructTree(List<String> traversalOrder) {
            Map<String, List<String>> tree = new HashMap<>();
            Set<String> added = new HashSet<>();
    
            //first vertex is the root
            String root = traversalOrder.get(0);
            tree.put(root, new ArrayList<>());
            added.add(root);
    
            //create the tree by assigning the chldren to parents
            for (int i = 1; i < traversalOrder.size(); i++) {
                String child = traversalOrder.get(i);
    
                //find nearest parent that hasn't filled the neighboring spot
                for (int j = i - 1; j >= 0; j--) {
                    String possibleParent = traversalOrder.get(j);
    
                    //check if parent is already in the tree and child isn't added
                    if (tree.containsKey(possibleParent) && !added.contains(child)) {
                        tree.get(possibleParent).add(child);
                        tree.putIfAbsent(child, new ArrayList<>());
                        added.add(child);
                        break;
                    }
                }
            }
            return tree;
        }
    
    
        //Method to print tree
        private static void printTree(Map<String, List<String>> tree) {
            for (String parent : tree.keySet()) {
                System.out.print(parent + " ->");
                System.out.println(tree.get(parent));
            }
        }
    }