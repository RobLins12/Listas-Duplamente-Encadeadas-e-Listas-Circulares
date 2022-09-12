package br.unicap.ed1.atividade04;

public class CircularListNode {
    private CircularListNode previous;
    private CircularListNode next;
    private Integer value;

    public CircularListNode(Integer value, CircularListNode next, CircularListNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public CircularListNode getPrevious() {
        return previous;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public CircularListNode getNext() {
        return next;
    }

    public void setNext(CircularListNode next) {
        this.next = next;
    }

    public void setPrevious(CircularListNode previous) {
        this.previous = previous;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj instanceof CircularListNode){
            CircularListNode other = (CircularListNode) obj;
            if (this.value.equals(other.value)){
                return true;
            }
       }   
       return false; 
    } 
}

