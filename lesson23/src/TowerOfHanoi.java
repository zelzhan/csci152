import adt.Stack;
import impl.ArrayIntStack;

public class TowerOfHanoi {

    private ArrayIntStack[] post = new ArrayIntStack[3];
    private int numMoves = 0;

    public TowerOfHanoi(int numDiscs) {
        post[0] = new ArrayIntStack();
        post[1] = new ArrayIntStack();
        post[2] = new ArrayIntStack();
        for(int i = numDiscs; i > 0; i--) post[0].push(i);
    }

    public void moveDisc(int from, int to) throws Exception {
        int temp1 = 0, temp2 = 0;
        if (from < 0 || to < 0 || from > 2 || to > 2 || post[from].getSize() == 0) throw new Exception("Wrong move");
        if(post[from].getSize() != 0 && post[to].getSize() != 0){
            temp1 = post[from].pop();
            temp2 = post[to].pop();
            post[from].push(temp1);
            post[to].push(temp2);
            if( temp1 > temp2 ) throw new Exception("Wrong move");
        }
        post[to].push(post[from].pop());
        numMoves++;
    }

    public boolean isFinished() {
        if(post[0].getSize() == 0 && post[1].getSize() == 0) return true;
        return false;
    }

    public int getNumMoves() {
        return numMoves;
    }

    public String toString() {
        return post[0].toString() + '\n' + post[1].toString() + '\n' + post[2].toString();
    }

}