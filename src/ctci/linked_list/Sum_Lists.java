package ctci.linked_list;

import utils.LinkedList.LinkedList;
import utils.LinkedList.Node;

import java.util.ArrayList;

/**
 * CTCI Linked List Problem 2.5
 */
public class Sum_Lists {
    Node node1;
    Node node2;
    static Node partialSum;

    public static void main (String args[]) {
        LinkedList sll = new LinkedList();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(9);
        al.add(1);
        al.add(5);

        sll.initializeLinkedList(al);

        LinkedList sll_2 = new LinkedList();
        ArrayList<Integer> al2 = new ArrayList<>();

        al2.add(2);
        al2.add(9);
        al2.add(5);
        sll_2.initializeLinkedList(al2);

        int carry = sum(sll.head, sll_2.head);

        if (carry !=0) {
            Node node = new Node();
            node.data = carry;

            node.next = partialSum;
            partialSum = node;
        }
    }


    public static int sum(Node node1, Node node2) {

        if(node1 == null && node2 == null) {
            return 0;
        }

        int carry = sum(node1.next, node2.next);

        Node node = new Node();
        int sum = node1.data + node2.data + carry;
        node.data = ((sum)>9?sum%10:sum);

        carry = sum / 10;

        if(partialSum == null) {
            partialSum = new Node();
            partialSum = node;
        } else {
            node.next = partialSum;
            partialSum = node;
        }

        return carry;
    }

}
