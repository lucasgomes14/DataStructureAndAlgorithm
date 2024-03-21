package LinkedSList;

import Nodo.Nodo;

public class LinkedSList {
    private int length;
    private Nodo head;
    private Nodo tail;

    public LinkedSList() {
        this.length = 0;
        this.head = new Nodo();
        this.tail = new Nodo();
    }

    public int size() {
        return length;
    }

    public void add(int value) {
        Nodo nodo = new Nodo(value);

        if(tail.getNext() == null) {
            tail.setNext(nodo);
        } else {
            Nodo nodoPrevious = getNodo(length - 1);
            nodoPrevious.setNext(nodo);
            tail.setNext(nodo);
        }

        if(head.getNext() == null) {
            head.setNext(nodo);
        }
        length++;
    }

    public Nodo getNodo(int index) {
        Nodo nodoPosition = head.getNext();

        if(index > length) {
            return null;
        }

        if(index == 0) {
            return nodoPosition;
        }

        for(int i = 0; i < index; i++) {
            nodoPosition = nodoPosition.getNext();
        }

        return nodoPosition;
    }

    public void add(int value, int index) {
        Nodo newNodo = new Nodo(value);

        if(index == length) {
            add(value);
        } else if(index == 0) {
            Nodo temp = head.getNext();
            head.setNext(newNodo);
            newNodo.setNext(temp);
            length++;
        } else if(index < length && index > 0){
            Nodo nodo = getNodo(index - 1);
            Nodo temp = nodo.getNext();
            nodo.setNext(newNodo);
            newNodo.setNext(temp);
            length++;
        }

    }

    public void remove(int index) {
        if(index < length && length > 0) {
            Nodo nodoRemove = getNodo(index);
            Nodo nodoPrevious = getNodo(index - 1);

            if(index == 0) {
                head.setNext(nodoRemove.getNext());
            } else if(index == length - 1) {
                tail.setNext(nodoPrevious);
                nodoPrevious.setNext(null);
            } else {
                nodoPrevious.setNext(nodoRemove.getNext());
                nodoRemove.setNext(null);
            }
            length--;
        }
    }

    public int getValue(int index) {
        return getNodo(index).getValue();
    }
}
