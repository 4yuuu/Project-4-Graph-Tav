import java.util.*;

public class graphMain {
    public static void main (String[] args) {
        DirectedGraph<String> graph = new DirectedGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");

        graph.addEdge("A", "B");
        graph.addEdge("A", "D");
        graph.addEdge("A", "E");
        graph.addEdge("B", "E");
        graph.addEdge("D", "G");
        graph.addEdge("E", "F");
        graph.addEdge("E", "H");
        graph.addEdge("G", "H");
        graph.addEdge("F", "C");
        graph.addEdge("F", "H");
        graph.addEdge("H", "I");
        graph.addEdge("C", "B");
        graph.addEdge("I", "F");

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
        
        //graph.depthFirstTrav("A");

        //get traversal orders of Breadth first and DepthFirst
        List<Character> breadthFirstOrder = graphBFS.breadthFirstTrav('A');

        //List<String> depthFirstOrder = graph.depthFirstTrav("A");

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
