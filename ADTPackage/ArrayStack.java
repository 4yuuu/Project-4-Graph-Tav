package ADTPackage;

import java.util.EmptyStackException;

/**
    A class of stacks whose entries are stored in an array.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class ArrayStack<T> implements StackInterface<T>
{
	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
  
   public ArrayStack()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
  
   public ArrayStack(int initialCapacity)
   {
      integrityOK = false;
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
		topIndex = -1;
      integrityOK = true;
  } // end constructor
  
//  < Implementations of the stack operations go here. >
public void push (T newEntry) {
   checkIntegrity();
   ensureCapaciy();
   stack [topIndex+1] = newEntry;
   topIndex++;
}

public T pop() {
   checkIntegrity();
   if (isEmpty())
   throw new EmptyStackException();
   else {
      T top = stack[topIndex];
      stack[topIndex] = null;
      topIndex--;
      return top;
   }
}

public T peek() {
   checkIntegrity();
   if (isEmpty()) 
   throw new EmptyStackException();
   else 
      return stack[topIndex];
   
}

public boolean isEmpty() {
   return topIndex < 0;
}

public void clearr() {
   checkIntegrity();
   while (topIndex > -1) {
      stack[topIndex] = null;
      topIndex--;
   }
}
//  < Implementations of the private methods go here; checkCapacity and checkIntegrity
//    are analogous to those in Chapter 2. >
//  . . .
private void ensureCapaciy() {
   if (topIndex >= stack.length - 1) {
      int newLength = 2 * stack.length;
      checkCapacity(newLength);
      stack = Arrays.copyOf(stack, newLength);
   }
}

private void checkIntegrity() {
   if(!integrityOK)
   throw new SecurityException("Stack object corrupted.");
}

private void checkCapacity(int capacity) {
   if (capacity > MAX_CAPACITY)
   throw new IllegalStateException("Attempt to create a stack which exceeds capacity of " + MAX_CAPACITY);
}

} // end ArrayStack
