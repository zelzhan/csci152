
package robot_world;

import java.io.IOException;

public class RobotWorld {
       
	// These are constants representing possible
	// chars in the world map

	public static final char SPACE = ' ';
	public static final char WALL = '#';
	public static final char GOAL = 'G';

	public static final char NORTH = '^';
	public static final char SOUTH = 'V';
	public static final char EAST = '>';
	public static final char WEST = '<';
	
    // Fields 
    
    // The map of the world
	private char[][] worldMap;
    
	// The dimensions of the world map
	private int maxRows, maxColumns;
	
	// The location of the robot
	private int robotRow, robotColumn;
    
	
    public RobotWorld(String mapFileName) throws IOException {
        
    	// This loads the file data into the world map
    	
        WorldMapReader wmr = new WorldMapReader();
        worldMap = wmr.readWorldMap(mapFileName);
        
        // This saves the dimensions of the world map
        maxRows = wmr.getMaxRows();
        maxColumns = wmr.getMaxColumns();
        
        // This sets the location of the robot to the initial position
        // shown in the file
        robotRow = wmr.getInitRobotRow();
        robotColumn = wmr.getInitRobotColumn();
    }
    
 
    /**
     * Changes the direction of the robot by rotating it clockwise
     * 90 degrees
     */
    public void rotateClockwise() {
        if(worldMap[robotRow][robotColumn] == EAST){
            worldMap[robotRow][robotColumn] = SOUTH;
            return;
        }
        if(worldMap[robotRow][robotColumn] == NORTH){
            worldMap[robotRow][robotColumn] = EAST;
            return;
        }
        if(worldMap[robotRow][robotColumn] == WEST){
            worldMap[robotRow][robotColumn] = NORTH;
            return;
        }
        if(worldMap[robotRow][robotColumn] == SOUTH) worldMap[robotRow][robotColumn] = WEST;
    }
    
    
    /**
     * Changes the direction of the robot by rotating it counter-
     * clockwise 90 degrees
     */
    public void rotateCounterClockwise() {
        if(worldMap[robotRow][robotColumn] == EAST){
            worldMap[robotRow][robotColumn] = NORTH;
            return;
        }
        if(worldMap[robotRow][robotColumn] == NORTH){
            worldMap[robotRow][robotColumn] = WEST;
            return;
        }
        if(worldMap[robotRow][robotColumn] == WEST){
            worldMap[robotRow][robotColumn] = SOUTH;
            return;
        }
        if(worldMap[robotRow][robotColumn] == SOUTH) worldMap[robotRow][robotColumn] = EAST;
        worldMap[robotRow][robotColumn] = EAST;
    }
    
    
    /**
     * Moves the robot forward one place, as long as it is not 
     * directly in front of a wall (if it is, throw an exception).
     * Also outputs a message if the robot finds the goal
     */
    public void moveForward() throws Exception {
        if(worldMap[robotRow][robotColumn] == NORTH){
            worldMap[robotRow][robotColumn] = SPACE;
            robotRow-=1;
            if(worldMap[robotRow][robotColumn] == GOAL) System.out.println("SUCCESS!");
            worldMap[robotRow][robotColumn] = NORTH;
        }
        if(worldMap[robotRow][robotColumn] == SOUTH){
            worldMap[robotRow][robotColumn] = SPACE;
            robotRow+=1;
            if(worldMap[robotRow][robotColumn] == GOAL) System.out.println("SUCCESS!");
            worldMap[robotRow][robotColumn] = SOUTH;

        }
        if(worldMap[robotRow][robotColumn] == EAST) {
            worldMap[robotRow][robotColumn] = SPACE;
            robotColumn+=1;
            if(worldMap[robotRow][robotColumn] == GOAL) System.out.println("SUCCESS!");
            worldMap[robotRow][robotColumn] = EAST;
        }
        if(worldMap[robotRow][robotColumn] == WEST) {
            worldMap[robotRow][robotColumn] = SPACE;
            robotColumn-=1;
            if(worldMap[robotRow][robotColumn] == GOAL) System.out.println("SUCCESS!");
            worldMap[robotRow][robotColumn] = WEST;
        }
    }
    protected void moveBackward(){
        if(worldMap[robotRow][robotColumn] == NORTH){
            worldMap[robotRow][robotColumn] = SPACE;
            robotRow+=1;
            worldMap[robotRow][robotColumn] = NORTH;
        }
        if(worldMap[robotRow][robotColumn] == SOUTH){
            worldMap[robotRow][robotColumn] = SPACE;
            robotRow-=1;
            worldMap[robotRow][robotColumn] = SOUTH;

        }
        if(worldMap[robotRow][robotColumn] == EAST) {
            worldMap[robotRow][robotColumn] = SPACE;
            robotColumn-=1;
            worldMap[robotRow][robotColumn] = EAST;
        }
        if(worldMap[robotRow][robotColumn] == WEST) {
            worldMap[robotRow][robotColumn] = SPACE;
            robotColumn+=1;
            worldMap[robotRow][robotColumn] = WEST;
        }
    }

    public void printCurrentWorldMap() {
    	
    	for (int i = 0; i < maxRows; i++) {
    		for (int j = 0; j < maxColumns; j++) {
    			System.out.print(worldMap[i][j]);
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}
