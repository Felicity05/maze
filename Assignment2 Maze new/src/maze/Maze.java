package maze;

import java.io.*;
import java.util.*;

/**
 *
 * @author aalva456
 */
public class Maze {

    private char[][] maze;
    private ArrayList<String> mazeSaver;
    ArrayList<String> list;

    public Maze(char[][] m) {
        this.maze = m;
        list = new ArrayList<>();
    }

    //create 5 new emty files
    public void createFile() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            String filename = "maze" + ++count + ".txt";
            File file = new File(filename);
            try {
                file.createNewFile();
                list.add(filename);
                System.out.println("File " + file + " created");
            } catch (Exception e) {
                System.out.println("There is an error with the file");
            }
        }
    }

    //write to each file
    public void writetoFile(int n) throws IOException {
        // FileWriter filew;

        for (String file : list) {
            FileWriter filew = new FileWriter(file);
            BufferedWriter bufw = new BufferedWriter(filew);
            Random r = new Random();
            char[][] m = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                  int rnum = 1 + r.nextInt(10);
                  if (rnum > 5) {
                    bufw.write(m[i][j] = ' ');
                  } 
                  else {
                    bufw.write(m[i][j] = '*');
                  }
                }
                bufw.newLine();
            }
            bufw.flush();
        }
    }

    public ArrayList<String> getFiles() {
        return list;
    }

    public void loadMaze(String filename) {
        mazeSaver = new ArrayList<String>();
        int numcol = 0;
        try {
            Scanner scanfile = new Scanner(new File(filename));
            while (scanfile.hasNext()) {
                String nextline = scanfile.nextLine();
                mazeSaver.add(nextline);
                if (nextline.length() >= numcol) {
                    numcol = nextline.length();
                }
            }
        } catch (Exception e) {
            System.out.println(filename + " has an error");
        }

        int numrows = mazeSaver.size();
        maze = new char[numrows][numcol];
        for (int i = 0; i < numrows; i++) {
            String rows = mazeSaver.get(i);
            for (int j = 0; j < numcol; j++) {
                if (rows.length() >= numcol) {
                    maze[i][j] = rows.charAt(j);
                } else {
                    maze[i][j] = '*';
                }
            }
        }
        System.out.println("\nMaze loaded from file:" + " \"" + filename + "\"");
    }

    public int mazeSize() {
        return mazeSaver.size();
    }

    public void printMaze() {
        for (char[] rows : maze) {
            System.out.println(rows);
        }
        System.out.println();
    }

    public boolean isExit(int i, int j) {

        if (maze[i][j] == ' ' && maze[i][j] != '.') {
            if (i == 0 || j == 0 || i == maze.length - 1 || j == maze.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean escapeMaze(int i, int j) {
        if (i < 0 || j < 0 || i > mazeSaver.size() - 1 || j > mazeSaver.size() - 1) { //cambie cosas aqui 
            //you are out of bounds
            return false;
        }
        if (isExit(i, j)) {
            maze[i][j] = 'E';
            return true;
        }
        if (maze[i][j] != ' ') {
            //you've hit a wall
            return false;
        }

        maze[i][j] = '.';

        if (escapeMaze(i - 1, j)) {
            //maze[i][j] = 'P';
            return true;
        }
        if (escapeMaze(i + 1, j)) {
            //maze[i][j] = 'P';
            return true;
        }
        if (escapeMaze(i, j - 1)) {
            //maze[i][j] = 'P';
            return true;
        }
        if (escapeMaze(i, j + 1)) {
            //maze[i][j] = 'P';
            return true;
        }

        maze[i][j] = ' ';

        return false;

    }

}
