package LinkedDList;

import Nodo.Nodo;

public class LinkedDList {
    private int length;
    private Nodo head;
    private Nodo tail;

    public LinkedDList() {
        length = 0;
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
        }

        if(tail.getNext() == null) {
            tail.setNext(newNodo);
        } else {
            Nodo lastNodo = tail.getNext();
            tail.setNext(newNodo);
            lastNodo.setNext(newNodo);
            newNodo.setPrevious(lastNodo);
        }
        length++;
    }

    public Nodo getNodo(int index) {
        Nodo position = head.getNext();

        if(index > length) {
            return null;
        }

        if(index == 0) {
            return position;
        }

        for(int i = 0; i < index; i++) {
            position = position.getNext();
        }

        return position;
    }

    public void add(int value, int index) {
        Nodo newNodo = new Nodo(value);

        if(index == length) {
            add(value);
        } else if(index == 0) {
            Nodo firstNodo = head.getNext();
            firstNodo.setPrevious(newNodo);
            newNodo.setNext(firstNodo);
            head.setNext(newNodo);
            length++;
        } else if(index < length && index > 0) {
            Nodo oldPositionNodo = getNodo(index);
            oldPositionNodo.getPrevious().setNext(newNodo);
            newNodo.setPrevious(oldPositionNodo.getPrevious());
            newNodo.setNext(oldPositionNodo);
            oldPositionNodo.setPrevious(newNodo);
            length++;
        }
    }

    public void remove(int index) {
        if(index < length && index >= 0) {
            Nodo oldPositionNode = getNodo(index);

            if(index == 0) {
                head.setNext(oldPositionNode.getNext());
                oldPositionNode.getNext().setPrevious(null);
            } else if(index == length - 1) {
                tail.setNext(oldPositionNode.getPrevious());
                oldPositionNode.getPrevious().setNext(null);
            } else {
                oldPositionNode.getPrevious().setNext(oldPositionNode.getNext());
                oldPositionNode.getNext().setPrevious(oldPositionNode.getPrevious());
            }

            length--;
        }
    }

    public int getValue(int index) {
        return getNodo(index).getValue();
    }
}
