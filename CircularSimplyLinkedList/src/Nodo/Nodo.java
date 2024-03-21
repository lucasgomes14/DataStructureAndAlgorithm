package Nodo;

public class Nodo {
    private int value;
    private Nodo next;

    public Nodo(int valor) {
        this.value = valor;
        this.next = null;
    }

    public Nodo() {
        this.next = null;
        this.value = 0;
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