package OrderedSimplyLinkedList;

import Nodo.Nodo;

public class OrderedSimplyLinkedList {
    private int length;
    private Nodo head;
    private Nodo tail;

    public OrderedSimplyLinkedList() {
        this.length = 0;
        this.head = new Nodo();
        this.tail = new Nodo();
    }

    public int size() {
        return length;
    }

    public void add(int value) {
        Nodo newNodo = new Nodo(value);

        if(head.getNext() == null) {
            head.setNext(newNodo);
            tail.setNext(newNodo);
        } else {
            if(length == 1 && value < head.getNext().getValue()) {
                newNodo.setNext(head.getNext());
                head.setNext(newNodo);
            } else if(length == 1) {
                tail.getNext().setNext(newNodo);
                tail.setNext(newNodo);
            } else if(head.getNext().getValue() > value) {
                newNodo.setNext(head.getNext());
                head.setNext(newNodo);
            } else if(tail.getNext().getValue() < value){
                tail.getNext().setNext(newNodo);
                tail.setNext(newNodo);
            } else {
                Nodo position = sortPosition(value);

                newNodo.setNext(position.getNext());
                position.setNext(newNodo);
            }
        }
        length++;
    }

    private Nodo sortPosition(int value) {
        Nodo position = head.getNext();

        for(int i = 0; i < length; i++) {
            if(position.getNext().getValue() > value) {
                return position;
            }
            position = position.getNext();
        }
        return position;
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

    public void remove() {
        if(head != null) {
            head.setNext(head.getNext().getNext());

            length--;
        }
    }
}
