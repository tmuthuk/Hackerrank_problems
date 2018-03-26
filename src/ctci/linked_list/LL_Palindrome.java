package ctci.linked_list;

import utils.LinkedList.LinkedList;
import utils.LinkedList.Node;

import java.util.ArrayList;

/**
 * Linked List Problem: 2.6
 */
public class LL_Palindrome {
    static  StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) {
        LinkedList sll = new LinkedList();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);

        sll.initializeLinkedList(al);

        sb2.append(findIfPalindrome(sll.head));
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        System.out.println("Is " +(s1.equals(s2)?"":"not ") + "palindrome");


        LinkedList sll_1 = new LinkedList();
        ArrayList<Integer> al_1 = new ArrayList<>();
        al_1.add(1);
        al_1.add(2);
        al_1.add(3);
        al_1.add(4);
        al_1.add(3);
        al_1.add(2);
        al_1.add(1);

        sll_1.initializeLinkedList(al_1);
        sb1 = new StringBuilder();
        sb2 = new StringBuilder();

        sb2.append(findIfPalindrome(sll_1.head));
        String s11 = sb1.toString();
        String s22 = sb2.toString();
        System.out.println("Is " +(s11.equals(s22)?"":"not ") + "palindrome");
    }

    public static String findIfPalindrome(Node node) {
        sb1.append(String.valueOf(node.data));
        if (node.next == null) {
            return String.valueOf(node.data);
        }
        sb2.append(findIfPalindrome(node.next));
        return String.valueOf(node.data);
    }
}
