package GraphPackage;

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
        
        graph.depthFirstTrav("A");

        //get traversal orders of Breadth first and DepthFirst
        List<String> breadthFirstOrder = graph.breadthFirstTrav("A");
        List<String> depthFirstOrder = graph.depthFirstTrav("A");

        //create and display the trees
        System.out.println("Breadth First Traversal Tree:");
        Map<String, List<String>> breadthFirstTree = constructTree(breadthFirstOrder);
        printTree(breadthFirstTree);
        
        System.out.println("\nBreadth First Traversal Tree:");
        Map<String, List<String>> depthFirstTree = constructTree(breadthFirstOrder);
        printTree(breadthFirstTree);
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
                String potentialParent = traversalOrder.get(j);

                //check if parent is already in the tree and child isn't added
                if (tree.containsKey(potentialParent) && !added.contains(child)) {
                    tree.get(potentialParent).add(child);
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
