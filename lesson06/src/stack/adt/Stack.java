package stack.adt;

public interface Stack {
    /**
     * Puts the given element on the top of the Stack.
     *
     * @param value element to be added on the top of the Stack
     */
    public void push(int value);

    /**
     * Removes and returns the top most element of the Stack
     *
     * @return the top most element of the Stack
     * @throws Exception if the Stack is empty
     */
    public int pop() throws Exception;

    /**
     * @return the size of the Stack
     */
    public int getSize();

    /**
     * Removes all elements from the Stack
     */
    public void clear();

    /**
     * @return a String representation of the Stack
     */
    @Override
    public String toString();
}
