
package robot_world;

import java.io.IOException;
import adt.Stack;
import impl.LinkedListStack;

public class SuperRobotWorld extends RobotWorld {
    Stack<Character> stk1 = new LinkedListStack();
    Stack<Character> stk2 = new LinkedListStack();

    public SuperRobotWorld(String mapFile) throws IOException {
        super(mapFile);
    }

    @Override
    public void rotateClockwise(){
        stk1.push('R');
        super.rotateClockwise();
    }

    @Override
    public void rotateCounterClockwise(){
        stk1.push('L');
        super.rotateCounterClockwise();
    }

    @Override
    public void moveForward(){
        stk1.push('F');
        try{
            super.moveForward();
        } catch (Exception ex){
        }
    }
    /**
     * Undo the last move or rotation command that put the robot
     * in its current state.  If no commands have been issued yet,
     * do nothing.
     */
    public void undoCommand() {
        try{
            Character c = stk1.pop();
            stk2.push(c);
            if(c == 'R') super.rotateCounterClockwise();
            if(c == 'L') super.rotateClockwise();
            if(c == 'F') super.moveBackward();
        } catch (Exception ex){
        }
    }



    /**
     * Undo the last n commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to undo
     */
    public void undoCommands(int n) {
    	for(int i = 0; i < n; i++) undoCommand();
    }
    
    /**
     * For previously undone commands, redo the last command that was
     * undone
     */
    public void redoUndoneCommand() {
        try{
            Character c = stk2.pop();
            if(c == 'R') super.rotateClockwise();
            if(c == 'L') super.rotateCounterClockwise();
            if(c == 'F') super.moveForward();
        } catch (Exception ex){
        }
    }
    
    /**
     * Redo the last n undone commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to redo
     */
    public void redoUndoneCommands(int n) {
        for(int i = 0; i < n; i++) redoUndoneCommand();
    }
}
