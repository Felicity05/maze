/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datstructure;

/**
 *
 * @author aalva456
 */
public class Node {
    
     Node next;
     Node prev;
     int data;
    
    public Node(int d)
    {
        this.prev = null;
        this.data = d;
        this.next = null;
    }
    
}
