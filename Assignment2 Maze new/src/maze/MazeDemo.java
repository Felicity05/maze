
package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MazeDemo
{
   public static void main(String args[]) throws FileNotFoundException
   {
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
      //add flies from MazeGenerator
      ArrayList<String> filesname = maze.getFiles();
      filesname.add("maze6.txt");
      filesname.add("maze7.txt");
      
      for (String s: filesname){
          System.out.println(s);
      }
      
     
     /* int mazeCount = 0;
      
      for (String files : filesname)
      {
          maze.loadMaze(files);
          System.out.println("Maze size: " + maze.mazeSize());
          
          JOptionPane.showMessageDialog(null, "Maze: " + ++mazeCount);
          i = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the starting row"));
          j = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the starting column"));
          
          
          if(i >= maze.mazeSize() || j >= maze.mazeSize())
            {
                System.out.println("Sorry, that's not a valid stating point"); 
            }
            else 
            {
                System.out.println(maze.escapeMaze(i,j));
                 maze.printMaze();
                 System.out.println("====================================");
            }
      }*/
    }   
}

