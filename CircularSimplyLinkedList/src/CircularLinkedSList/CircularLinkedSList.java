package CircularLinkedSList;

import Nodo.Nodo;

public class CircularLinkedSList {
    private int length;
    private Nodo head;
    private Nodo tail;

    public CircularLinkedSList() {
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
            nodo.setNext(nodo);
            head.setNext(nodo);
        } else {
            Nodo nodoPrevious = getNodo(length - 1);
            nodoPrevious.setNext(nodo);
            tail.setNext(nodo);
            nodo.setNext(head.getNext());
        }
        length++;
    }

    public Nodo getNodo(int index) {
        Nodo nodoPosition = head.getNext();

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

        int aux = index;

        while(aux > length) {
            aux -= index;
        }

        if(index == length || aux == length) {
            add(value);
        } else if(index == 0 || aux == 0) {
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
        if(index >= 0 && length > 0) {
            Nodo nodoRemove = getNodo(index);
            Nodo nodoPrevious = getNodo(index - 1);

            int aux = index;

            while(aux > length) {
                aux -= index;
            }

            if(index == 0 || aux == 0) {
                Nodo lastNodo = getNodo(length - 1);
                head.setNext(nodoRemove.getNext());
                lastNodo.setNext(nodoRemove.getNext());
            } else if(index == length - 1 || aux == length - 1) {
                tail.setNext(nodoPrevious);
                nodoPrevious.setNext(head.getNext());
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
