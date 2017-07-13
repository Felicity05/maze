/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Color;
import static java.awt.SystemColor.text;
import java.awt.font.TextAttribute;
import java.io.File;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author aalva456
 */
public class MazeGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       char[][] maze = generator(15);       

        printMaze(maze);
        
        System.out.println("\033[0m BLACK");
        System.out.println("\033[31m RED");
        System.out.println("\033[32m GREEN");
        System.out.println("\033[33m YELLOW");
        System.out.println("\033[34m BLUE");
        System.out.println("\033[35m MAGENTA");
        System.out.println("\033[36m CYAN");
        System.out.println("\033[37m WHITE");
        
        
    }

    public static char[][] generator(int n)
    {
        Random r = new Random();
        char[][] m = new char[n][n];
        
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                int rnum = 1 + r.nextInt(10);
            
                if (rnum > 5)
                    m[i][j] = '_';
                else
                    m[i][j] = '*';
            }
        }
        
        return m;
        
    }
    
    public static void printMaze(char[][] m)
    {
        for (char[] c : m)
            System.out.println(c);
        System.out.println();
    }
}
   

