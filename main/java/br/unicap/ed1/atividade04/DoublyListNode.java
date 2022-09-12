package br.unicap.ed1.atividade04;

public class DoublyListNode {
    private DoublyListNode previous;
    private DoublyListNode next;
    private Integer value;
    
    public DoublyListNode(Integer value, DoublyListNode next, DoublyListNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }
    
    public DoublyListNode getPrevious() {
        return previous;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public DoublyListNode getNext() {
        return next;
    }
    public void setNext(DoublyListNode next) {
        this.next = next;
    }
    public void setPrevious(DoublyListNode previous) {
        this.previous = previous;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj instanceof DoublyListNode){
            DoublyListNode other = (DoublyListNode) obj;
            if (this.value.equals(other.value)){
                return true;
            }
       }   
       return false; 
    } 
    
}
