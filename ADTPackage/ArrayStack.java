package ADTPackage;

import java.util.Arrays;
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
       
    }