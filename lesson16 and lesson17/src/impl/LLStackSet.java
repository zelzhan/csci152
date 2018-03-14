package impl;
import adt.Set;
import adt.Stack;


public class LLStackSet<T> implements Set<T> {
    private Stack<T> stack;

    public LLStackSet(){
        stack = new LinkedListStack();
    }

    @Override
    public void add(T value) {
        if(!contains(value)) stack.push(value);
    }

    @Override
    public boolean contains(T value) {
        boolean bool = false;
        Stack<T> tempStack = new LinkedListStack();
        for (int i = 0; i < stack.getSize(); i++){
            try{
                T x = stack.pop();
                tempStack.push(x);
                if(x.equals(value)) bool = true;
            } catch (Exception ex){
            }
        }
        while(tempStack.getSize() != 0){
            try{
                stack.push(tempStack.pop());
            } catch (Exception ex){
            }
        }
        return bool;
    }

    @Override
    public boolean remove(T value) {
        if(!contains(value)) return false;
        Stack<T> tempStack = new LinkedListStack<>();
        while(stack.getSize() != 0){
            try{
                T x = stack.pop();
                if(!x.equals(value)) tempStack.push(x);
            } catch (Exception ex){
            }
        }
        while(tempStack.getSize() != 0){
            try{
                stack.push(tempStack.pop());
            } catch (Exception ex){
            }
        }
        return true;
    }

    @Override
    public T removeAny() throws Exception {
        if(stack.getSize() == 0) throw new Exception("Exception");
        return stack.pop();
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public String toString(){
        return stack.toString();
    }
}
