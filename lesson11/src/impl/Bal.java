package impl;
import adt.Queue;
import adt.Stack;

public class Bal {
    public static boolean isBalanced(Queue<Character> q) throws Exception {
        boolean curly = false, square = false, parenth = false;
        char temp = 0, temp2;
        Stack<Character> ch = new LinkedListStack<Character>();
        int size = q.getSize();
        while(size != 0){
            try{
                if (curly == true )
                temp = q.dequeue();
                ch.push(temp);
                q.enqueue(temp);
                temp2 = ch.pop();
                if(temp2 == ')') curly = true;
                if(temp2 == ']') square = true;
                if(temp2 == '}') parenth = true;
            } catch (Exception ex) {
                break;
            }
        }

    }
}
