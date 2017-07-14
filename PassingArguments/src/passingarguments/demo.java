/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passingarguments;

/**
 *
 * @author aalva456
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Amount of arguments: " + args.length);
        
        for (String s: args){
            System.out.println(s);
        }
    }
    
}
