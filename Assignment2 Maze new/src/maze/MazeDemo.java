package maze;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class MazeDemo {

    public static void main(String args[]) throws IOException {

        String fileinfo = "mazeinfo.txt";
        boolean printpath = true;
        boolean printmaze = true;

        for (String s : args) {
            //System.out.println(s);

            if (s.substring(0, 6) == "-info:") {
                fileinfo = s.substring(6);
            }
            if (s.equals("-printpath:no")) {
                printpath = false;
            }
            if (s.equals("-printmaze:no")) {
                printmaze = false;
            }
        }

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
        // filesname.add("maze7.txt");

        int mazeCount = 0;
        Scanner scan = new Scanner(new File("mazeinfo.txt"));
        System.out.println("\nInformation read from file: \"mazeinfo.txt\": ");
        while (scan.hasNext()) {
            String info = scan.nextLine();
            //   System.out.println(info);
            if (info.charAt(0) != '#') {
                System.out.println(info);
            }
        }

        for (String files : filesname) {
            maze.loadMaze(files);
            System.out.println("\033[35m Maze size: " + maze.mazeSize());

            JOptionPane.showMessageDialog(null, "Maze: " + ++mazeCount);
            i = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Insert the starting row"));
            j = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Insert the starting column"));

            System.out.println("\033[35m Starting point: (" + i + "," + j + ")");
            if (i >= maze.mazeSize() || j >= maze.mazeSize()) {
                System.out.println("\033[31m Sorry, that's not a valid stating point");
            } else {
                System.out.println("\033[35m Valid point: " + maze.escapeMaze(i, j) + "\n");
                if(printmaze)
                maze.printMaze();
                System.out.print("====================================");
            }
        }
    }
}
