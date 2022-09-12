package br.unicap.ed1.atividade04;

public class DoublyLinkedList {
    private DoublyListNode head;
    private DoublyListNode tail;
    
    public DoublyListNode getHead() {
        return head;
    }
    public DoublyListNode getTail() {
        return tail;
    }
    public void setTail(DoublyListNode tail) {
        this.tail = tail;
    }
    public void setHead(DoublyListNode head) {
        this.head = head;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int size(){
        if (isEmpty()){
            return 0;
        }
        int size = 0;
        DoublyListNode currentNode = this.head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.getNext();
        }
        return size;
    }

    public void addFirst(Integer value){
        DoublyListNode node = new DoublyListNode(value, null, null);
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        }else{
            this.head.setPrevious(node);
            this.head = node;
        }
    }

    public DoublyListNode search(Integer value){
        DoublyListNode currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public void addLast(Integer value){
        if (isEmpty()) {
            addFirst(value);
        }else{
            DoublyListNode node = new DoublyListNode(value, null, null);
            DoublyListNode currentNode = this.head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(node);
            node.setPrevious(currentNode);
            this.tail = node;
        }
    }

    public void reverse(){
        if (isEmpty()) {
            return;
        }
        DoublyListNode previous = this.head;
        DoublyListNode currentNode = previous.getNext();
        setTail(previous);
        while (currentNode != null) {
            previous.setNext(previous.getPrevious());
            previous.setPrevious(currentNode);
            previous = currentNode;
            currentNode = currentNode.getNext();
        }
        previous.setNext(previous.getPrevious());
        previous.setPrevious(null);
        setHead(previous);
    }

    public void delete(DoublyListNode nodeToBeDeleted){
        if (isEmpty()) {
            return;
        }
        DoublyListNode currentNode = this.head;
        while (currentNode != null && !currentNode.equals(nodeToBeDeleted)) {
            currentNode = currentNode.getNext();
        }
        if(this.size() == 1){
            setHead(null);
            setTail(null);
            return;
        }
        if (currentNode == this.head) {
            currentNode = currentNode.getNext();
            setHead(currentNode);
            currentNode.setPrevious(null);
            return;
        }
        if(currentNode == this.tail){
            currentNode = currentNode.getPrevious();
            currentNode.setNext(null);
            setTail(currentNode);
            return;
        }
        currentNode.getPrevious().setNext(currentNode.getNext());
        currentNode.getNext().setPrevious(currentNode.getPrevious());
    }

    public boolean isOrdered(boolean ascending){
        if (isEmpty()) {
            return true;
        }
        DoublyListNode node = this.head;
        while (node.getNext() != null){
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
}

