package GraphPackage;
import java.util.Iterator;
import ADTPackage.*; // Classes that implement various ADTs
import GraphPackage.VertexInterface;

import java.util.LinkedList;
import java.util.List;
/**
   A class that implements the ADT directed graph.
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public class DirectedGraph<T> implements GraphInterface<T>
{
	private DictionaryInterface<T, VertexInterface<T>> vertices;
	private int edgeCount;
	
	public DirectedGraph()
	{
		vertices = new LinkedDictionary<>();
		edgeCount = 0;
	} // end default constructor

/* Implementations of the graph operations go here. 
   . . . */
  public void addVertex(T vertexLabel) {
	vertices.add(vertexLabel, new Vertex<>(vertexLabel));
  }

  public boolean addEdge(T begin, T end) {
	boolean result = false;
	VertexInterface<T> beginVertex = vertices.getValue(begin);
	VertexInterface<T> endVertex = vertices.getValue(end);
	if ((beginVertex != null) && (endVertex != null))
	result = beginVertex.connect(endVertex);
	if (result)
	edgeCount++;
	return result;
  }
  public void depthFirstTrav(T startVertexLabel) {
	StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>();
	VertexInterface<T> startVertex = vertices.getValue(startVertexLabel);

	if (startVertex == null) {
		System.out.println("Start vertex not found.");
		return;
	}
	Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
	while (vertexIterator.hasNext()) {
		vertexIterator.next().unvisit();
	}
	List<T> traversalOrder = new LinkedList<>();
	startVertex.visit();
	traversalOrder.add(startVertex.getLabel());
	vertexStack.push(startVertex);

	while (!vertexStack.isEmpty()) {
		VertexInterface<T> topVertex = vertexStack.peek();
		VertexInterface<T> unvisitedNeighbor = topVertex.getUnvisitedNeighbor();

		if (unvisitedNeighbor != null) {
			unvisitedNeighbor.visit();
			traversalOrder.add(unvisitedNeighbor.getLabel());
			vertexStack.push(unvisitedNeighbor);
		}else{
			vertexStack.pop();
		}
	}
	System.out.println("Depth-First Traversal Order: " + traversalOrder);
  }

} // end DirectedGraph
