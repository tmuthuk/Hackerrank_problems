package ctci.linked_list.utils;

import java.util.ArrayList;

/**
 * Created by Tamilthaaragai on 12/12/2017.
 */
public class LinkedList {
    public Node head;
    public Node tail;

    public void initializeLinkedList (ArrayList<Integer> list) {
        for(Integer a : list) {
            Node node = new Node();
            node.data = a;
            node.next = null;

            if (head == null && tail == null) {
                head = new Node();
                head.data = node.data;
            } else if (tail == null){
                tail = new Node();
                tail.data = node.data;
                head.next = tail;
            } else {
                tail.next = node;
                tail = node;
            }
        }
    }
}




