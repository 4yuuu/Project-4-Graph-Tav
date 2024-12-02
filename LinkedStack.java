import java.util.EmptyStackException;
/**
    A class of stacks whose entries are stored in a chain of nodes.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode; // References the first node in the chain
  
   public LinkedStack()
   {
      topNode = null;
   } // end default constructor
  
//  < Implementations of the stack operations go here. >
//  . . .

//public
	public T pop() {
      if (isEmpty()) {
         throw new EmptyStackException();
      } else {
         T top = topNode.getData();
         topNode = topNode.getNextNode();
         return top;
      }
      }
      public T peek() {
         if (isEmpty()) {
            throw new EmptyStackException();
         } else{
            return topNode.getData();
         }
         }
         public boolean isEmpty() {
            return topNode == null;
         }
         public void clear() {
            topNode = null;
         }
//private
         private class Node {
            private T data;
            private Node next;
            private Node(T dataPortion) {
               this(dataPortion, null);
            }
            private Node(T dataPortion, Node linkPortion) {
               data = dataPortion;
               next = linkPortion;
            }
            private T getData() {
               return data;
            }
            @SuppressWarnings("unused")
            private void setData(T newData) {
               data = newData;
            }
            private Node getNextNode() {
               return next;
            }
            @SuppressWarnings("unused")
            private void setNextNode(Node nextNode) {
               next = nextNode;
            }
         }

      }
   