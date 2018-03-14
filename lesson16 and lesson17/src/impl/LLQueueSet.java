package impl;
import adt.Set;

public class LLQueueSet<T> implements Set<T>{
    private LinkedListQueue<T> queue;
    public LLQueueSet(){
        queue = new LinkedListQueue<>();
    }
    @Override
    public void add(T value) {
        if(!contains(value)){
            queue.enqueue(value);
        }
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < queue.getSize(); i++){
            try{
                T x = queue.dequeue();
                queue.enqueue(x);

                if(x.equals(value)) return true;
            } catch (Exception ex){
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        boolean bool = false;
        T var;
        for(int i = 0; i<queue.getSize(); i++) {
            try {
                var = queue.dequeue();
                if(var.equals(value)) {
                    bool = true;
                    break;
                }
                queue.enqueue(var);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return bool;
    }

    @Override
    public T removeAny() throws Exception {
        if (queue.getSize() == 0) throw new Exception("Exception");
        T result = queue.dequeue();
        return result;
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
