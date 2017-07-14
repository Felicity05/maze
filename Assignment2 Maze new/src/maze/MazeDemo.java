package maze;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class MazeDemo {

    public static void main(String args[]) throws FileNotFoundException, IOException {
        int i = 0, j = 0;

        char[][] m = {
            {'*', ' ', '*', '*', '*', '*', '*', '*', '*'},
            {'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*'},
            {'*', ' ', '*', '*', '*', '*', '*', ' ', '*'},
            {'*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*'},
            {'*', ' ', '*', ' ', '*', '*', '*', ' ', '*'},
            {'*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*'},
            {'*', '*', '*', ' ', '*', ' ', '*', '*', '*'},
            {'*', ' ', ' ', '*', ' ', ' ', '*', ' ', '*'},
            {'*', '*', '*', '*', '*', '*', '*', ' ', '*'}};

        Maze maze = new Maze(m);

        maze.createFile();
        maze.writetoFile(10);
        
        //add flies from MazeGenerator
        ArrayList<String> filesname = maze.getFiles();
       // filesname.add("maze6.txt");
      //  filesname.add("maze7.txt");

        

       int mazeCount = 0;
      
      for (String files : filesname)
      {
          maze.loadMaze(files);
          System.out.println("Maze size: " + maze.mazeSize());
          
          JOptionPane.showMessageDialog(null, "Maze: " + ++mazeCount);
          i = Integer.parseInt(JOptionPane.showInputDialog(null, 
                  "Insert the starting row"));
          j = Integer.parseInt(JOptionPane.showInputDialog(null, 
                  "Insert the starting column"));
          
          System.out.println("Starting point: (" + i + "," + j+ ")");
          if(i >= maze.mazeSize() || j >= maze.mazeSize())
            {
                System.out.println("Sorry, that's not a valid stating point"); 
            }
            else 
            {
                System.out.println("Valid point to start: " + maze.escapeMaze(i,j));
                maze.printMaze();
                System.out.print("====================================");
            }
      }
    }
}
