package impl;
import adt.Queue;
import adt.Stack;

public class Bal {
    public static boolean isBalanced(Queue<Character> q) throws Exception {
        boolean curly = false, square = false, parenth = false;
        char temp = 0, temp2 = 0;
        Stack<Character> ch = new LinkedListStack<Character>();
        int size = q.getSize();

        while(size != 0){

            try{

                temp = q.dequeue();
                size--;
                q.enqueue(temp);
                if(temp != '(' && temp != '{' && temp != '[' && temp != ']' && temp != '}' && temp != ')'){
                    throw new Exception("INCORRECT INPUT");
                }
                if(temp2 - 2 == temp || temp2 - 1 == temp){
                    ch.pop();
                    temp2 = ch.pop();
                    ch.push(temp2);
                    continue;
                }
                ch.push(temp);
                temp2 = temp;

            } catch (Exception ex) {
                break;
            }
        }

        if(ch.getSize() == 0 ) return true;
        return false;
    }
}
