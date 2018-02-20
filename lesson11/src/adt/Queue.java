
package adt;

/**
 * A generic queue
 * @param <X>
 */
public interface Queue<X> {

    /**
     * Adds an element to the end of the queue.
     *
     * @param value element to be added to the end of the queue
     */
    public void enqueue(X value);

    /**
     * Removes and returns the front most element of the queue
     *
     * @return the front most element of the queue
     * @throws Exception if the queue is empty
     */
    public X dequeue() throws Exception;

    /**
     * @return the size of the queue
     */
    public int getSize();

    /**
     * Removes all elements from the queue
     */
    public void clear();

    /**
     * @return a String representation of the queue
     */
    @Override
    public String toString();
}
