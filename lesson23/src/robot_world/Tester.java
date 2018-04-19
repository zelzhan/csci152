
package robot_world;

public class Tester {
    
    public static void main(String[] args) throws Exception {
        
        RobotWorld rw = new RobotWorld("/home/stayal0ne/csci152/lesson23/src/robot_world/map1.txt");
        SuperRobotWorld rw2 = new SuperRobotWorld("/home/stayal0ne/csci152/lesson23/src/robot_world/map1.txt");
        rw2.printCurrentWorldMap();
        rw2.moveForward();
        rw2.rotateClockwise();
        rw2.moveForward();
        rw2.moveForward();
        rw2.moveForward();
        rw2.printCurrentWorldMap();
        rw2.moveForward();
        rw2.moveForward();
        rw2.moveForward();
        rw2.rotateClockwise();
        rw2.undoCommands(4);
        rw2.redoUndoneCommands(4);
        rw2.printCurrentWorldMap();
    }
}
