/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datstructure;

/**
 *
 * @author arelysalvarezpadilla
 */
public class Node {
    public Node next;
    public Node prev;
    public Object data;

    public Node() {
        this.prev = null;
        this.data = null;
        this.next = null;
    }

    public Node(Object d) {
        this.prev = null;
        this.data = d;
        this.next = null;
    }
}
