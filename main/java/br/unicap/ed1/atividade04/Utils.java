package br.unicap.ed1.atividade04;

public class Utils {

    public static boolean isPalindrome(DoublyLinkedList list) {
        int count = 0;
        Integer [] l1 = new Integer [list.size()];
        Integer [] l2 = new Integer [list.size()];
        DoublyListNode currentNode = list.getHead();
        while(currentNode != null){
            l1[count] = currentNode.getValue();
            count++;
            currentNode = currentNode.getNext();
        }
        DoublyListNode currentNode2 = list.getTail();
        count = 0;
        while(currentNode2 != null){
            l2[count] = currentNode2.getValue();
            count++;
            currentNode2 = currentNode2.getPrevious();
        }
        for (int i = 0; i < list.size(); i++) {
            if (l1[i] != l2[i]) {
                return false;
            }
        }
        return true;  
    }
}
