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
public class DoublyLinkedList {
    
    private Node head;
    private Node tail;
    private int size;
    
    
    public DoublyLinkedList()
    {
       this.head = null;
       this.tail = null;
       this.size = 0;
    }
    
//    public DoublyLinkedList(Node head, Node tail, int size)
//    {
//       this.head = head;
//       this.tail = tail;
//       this.size = size;
//    }
    
    public void addFront(int newData){
        if (head == null)
            head = new Node(null, newData, null);
        else
        { 
            Node n = new Node (null, newData, head); 
            head.setPrev(n);
            head = n; 
        }  
    }
    
    public void addLast(int newData)
    {
        if(tail == null)
         tail = new Node()   
    }
    
}
