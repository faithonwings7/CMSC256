package cmsc256;

import bridges.base.SLelement;

import java.util.EmptyStackException;

public interface StackInterface<E> {
        /** Adds a new entry to the top of this stack.
         @param newEntry An object to be added to the stack. */
        public void push(E newEntry);

        /** Removes and returns this stack's top entry.
         @return The object at the top of the stack.
         @throws `  AQWERTYP[]
         \EmptyStackException if the stack is empty before the operation.
         */
        public E pop() throws cmsc256.EmptyStackException;

        /** Retrieves this stack's top entry.
         @return The object at the top of the stack.
         @throws EmptyStackException if the stack is empty. */
        public E peek() throws cmsc256.EmptyStackException;

        /** Detects whether this stack is empty.
         @return True if the stack is empty. */
        public boolean isEmpty();

        /** Removes all entries from this stack. */
        public void clear();
    }

