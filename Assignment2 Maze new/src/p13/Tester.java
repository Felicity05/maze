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
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        char[][] m = {
            {'*', ' ', '*', '*', '*', '*', '*', '*', '*'},
            {'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*'},
            {'*', ' ', '*', '*', '*', '*', '*', ' ', '*'},
            {'*', ' ', '*', ' ', '*', ' ', ' ', ' ', '*'},
            {'*', ' ', '*', ' ', '*', '*', '*', ' ', '*'},
            {'*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*'},
            {'*', '*', '*', ' ', '*', ' ', '*', ' ', '*'},
            {'*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*'},
            {'*', '*', '*', '*', '*', '*', '*', ' ', '*'}};
        
        maze mymaze = new maze(m);
        System.out.println(m.length);
        
        System.out.println("Escape (3, 4) expected: false");
        System.out.println(mymaze.escapeMaze(3, 4));
        mymaze.printMaze();
        System.out.println("==================================");
        System.out.println("Escape (3, 3) expected: true");
        System.out.println(mymaze.escapeMaze(3, 3));
        mymaze.printMaze();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Escape (1, 5) expected: true");
        System.out.println(mymaze.escapeMaze(1, 5));
        mymaze.printMaze();
    }
    
}
