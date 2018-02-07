
package adt;

/**
 * @param <X>
 */
public interface Stack<X> {

    /**
     * Puts the given element on the top of the stack.
     *
     * @param value element to be added on the top of the stack
     */
    public void push(X value);

    /**
     * Removes and returns the top most element of the stack
     *
     * @return the top most element of the stack
     * @throws Exception if the stack is empty
     */
    public X pop() throws Exception;

    /**
     * @return the size of the stack
     */
    public int getSize();

    /**
     * Removes all elements from the stack
     */
    public void clear();

    /**
     * @return a String representation of the stack
     */
    @Override
    public String toString();
}
