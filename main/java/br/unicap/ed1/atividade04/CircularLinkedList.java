package br.unicap.ed1.atividade04;

public class CircularLinkedList {
    private CircularListNode sentinel;

    public CircularLinkedList(){
        this.sentinel = new CircularListNode(null, null, null);
        this.sentinel.setNext(this.sentinel);
        this.sentinel.setPrevious(this.sentinel);
    }

    public CircularListNode getHead() {
        return this.sentinel.getNext();
    }
    public CircularListNode getTail() {
        return this.sentinel.getPrevious();
    }
    public void setTail(CircularListNode tail) {
        this.sentinel.setPrevious(tail);
    }
    public void setHead(CircularListNode head) {
        this.sentinel.setNext(head);
    }

    public boolean isEmpty(){
        return this.getHead() == this.sentinel && this.getTail() == this.sentinel;
    }

    public void addFirst(Integer value){
        CircularListNode currentNode = this.getHead();
        CircularListNode newHead = new CircularListNode(value, currentNode, sentinel);
        sentinel.setNext(newHead);
        currentNode.setPrevious(newHead);
    }  

    public int size() {
        int size = 0;
        if (isEmpty()){
            return 0;
        }
        CircularListNode node = this.getHead();
        while (node != sentinel){
            size++;
            node = node.getNext();
        }
        return size;
    }


    public void addLast(Integer value) {
        CircularListNode currentNode = this.getTail();
        CircularListNode newTail = new CircularListNode(value, sentinel, currentNode);
        currentNode.setNext(newTail);
        sentinel.setPrevious(newTail);
        
    }  

    public void reverse() {
        CircularListNode current = this.getHead();
        CircularListNode head = this.getHead();
        do{
            CircularListNode next = current.getNext();
            CircularListNode previous = current.getPrevious();
            current.setPrevious(current.getNext());
            current.setNext(previous);
            current = next;   
        }while(current != head);
    }

    public boolean isOrdered(boolean ascending) {
        if (isEmpty()) {
            return true;
        }
        CircularListNode node = this.getHead();
        while (node.getNext() != sentinel){
            if (ascending) {
                if (node.getValue() > node.getNext().getValue()) {
                    return false;
                }
            }
            if (!ascending) {
                if (node.getValue() < node.getNext().getValue()) {
                    return false;
                }
            }
            node = node.getNext();
        }
        return true;
    }    

    public CircularListNode search(Integer elem) {
        CircularListNode currentNode = this.getHead();
        while(currentNode != sentinel){
            if(currentNode.getValue().equals(elem)){
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public void delete(CircularListNode nodeDelete) {
        CircularListNode nextNode = nodeDelete.getNext();
        CircularListNode previous = nodeDelete.getPrevious();
        nextNode.setPrevious(previous);
        previous.setNext(nextNode);
    }

    public boolean isEquals(CircularLinkedList otherList) {
        if(otherList instanceof CircularLinkedList){
            CircularListNode currentNode1 = this.getHead();
            CircularListNode currentNode2 = otherList.getHead();
            while (currentNode1 != sentinel && currentNode2 != sentinel){
                if (!currentNode1.getValue().equals(currentNode2.getValue())){
                    return false;
                }
                currentNode1 = currentNode1.getNext();
                currentNode2 = currentNode2.getNext();
            }
       }   
       return true; 
    } 

    public CircularLinkedList copy() {
        CircularLinkedList listCopied = new CircularLinkedList();
        CircularListNode currentNode = this.getHead();
        while(currentNode != sentinel){
            listCopied.addLast(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        return listCopied;
    }

    public int get(int index) throws Exception{
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
        CircularListNode currentNode = this.getHead();
        for (int i = 0; i < index; i++) {
           currentNode = this.getSuccessor(currentNode);
        }
        return currentNode.getValue();
    }

    public CircularListNode getSuccessor(CircularListNode currentNode) {
        //Should jump sentinel
        if (isEmpty()) {
            throw new RuntimeException ("Circular list is empty");
        }
        if (currentNode.getNext() == sentinel) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getNext();
    }
}
