package Nodo;

public class Nodo {
    private int value;
    private Nodo next;
    private Nodo previous;

    public Nodo(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public Nodo() {
        this.value = 0;
        this.next = null;
        this.previous = null;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }

    public Nodo getNext() {
        return next;
    }

    public Nodo getPrevious() {
        return previous;
    }

    public int getValue() {
        return value;
    }
}
