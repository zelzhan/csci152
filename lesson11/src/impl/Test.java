package impl;
import impl.Node;
import impl.LinkedListQueue;
import adt.Queue;

public class Test {
    public static void main(String[] args){
        Queue<Character> que = new LinkedListQueue<Character>();
        que.enqueue(')');
        que.enqueue('}');
        que.enqueue(']');
        que.enqueue('{');
        que.enqueue('[');
        que.enqueue('(');
//        que.enqueue(']');
//        que.enqueue('}');
//        que.enqueue('{');
//        que.enqueue('[');


//( ) [ ] { }               ( { [ ] } [ ] )              [ { } ] ( [ ] [ ] )             ( [ { ] } )
        System.out.println(que);
        try{
            System.out.println(Bal.isBalanced(que));
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
