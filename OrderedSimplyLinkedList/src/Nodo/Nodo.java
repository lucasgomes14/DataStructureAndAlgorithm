package Nodo;

public class Nodo {
    private int value;
    private Nodo next;

    public Nodo() {
        this.value = 0;
        this.next = null;
    }

    public Nodo(int value) {
        this.value = value;
        this.next = null;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Nodo getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }
}
