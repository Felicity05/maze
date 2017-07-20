/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p13;

/**
 *
 * @author arelysalvarezpadilla
 */
public class maze {
    
    private char[][] maze;
    
    public maze(char[][] m)
    {
        maze = m;
    }
    
   
    public boolean isExit(int i, int j) {

        if (maze[i][j] == ' ') {
            if (i == 0 || j == 0 || i == maze.length - 1 || j == maze.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean escapeMaze(int i, int j) {
        if (i < 0 || j < 0 || i > maze.length - 1 || j > maze.length - 1) { 
            //you are out of bounds
            return false;
        }
        if (isExit(i, j)) {
            maze[i][j] = 'E';
            return true;
        }
        if (maze[i][j] != ' ' ) {
            //you've hit a wall
            return false;
        }

        maze[i][j] = '.';

        if (escapeMaze(i + 1, j)) {
           // maze[i][j] = 'P';
            return true;
        }
        if (escapeMaze(i - 1, j)) {
           // maze[i][j] = 'P';
            return true;
        }
        if (escapeMaze(i, j - 1)) {
          //  maze[i][j] = 'P';
            return true;
        }
        if (escapeMaze(i, j + 1)) {
          //  maze[i][j] = 'P';
            return true;
        }

        maze[i][j] = ' ';

        return false;
    }
    
     public void printMaze() {
        for (char[] rows : maze) {
            System.out.println(rows);
        }
        System.out.println();
     }
}
