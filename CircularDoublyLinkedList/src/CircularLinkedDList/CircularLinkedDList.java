package CircularLinkedDList;

import Nodo.Nodo;

public class CircularLinkedDList {
    private int length;
    private Nodo head;
    private Nodo tail;

    public CircularLinkedDList() {
        length = 0;
        this.head = new Nodo();
        this.tail = new Nodo();
    }

    public int size() {
        return length;
    }

    public void add(int value) {
        Nodo newNodo = new Nodo(value);

        if(tail.getNext() == null) {
            tail.setNext(newNodo);
            head.setNext(newNodo);
            newNodo.setNext(head.getNext());
            newNodo.setPrevious(tail.getNext());
        } else {
            tail.getNext().setNext(newNodo);
            newNodo.setPrevious(tail.getNext());
            tail.setNext(newNodo);
            newNodo.setNext(head.getNext());
            head.getNext().setPrevious(newNodo);
        }
        length++;
    }

    public Nodo getNodo(int index) {
        Nodo position = head.getNext();

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

        int aux = index;

        while(aux > length) {
            aux -= length;
        }

        if(index == length || aux == length) {
            add(value);
        } else if(index == 0 || aux == 0) {
            Nodo firstNodo = head.getNext();
            firstNodo.setPrevious(newNodo);
            newNodo.setNext(firstNodo);
            head.setNext(newNodo);
            newNodo.setPrevious(tail.getNext());
            tail.getNext().setNext(newNodo);
            length++;
        } else if(index > 0) {
            Nodo oldPositionNodo = getNodo(index);
            oldPositionNodo.getPrevious().setNext(newNodo);
            newNodo.setPrevious(oldPositionNodo.getPrevious());
            newNodo.setNext(oldPositionNodo);
            oldPositionNodo.setPrevious(newNodo);
            length++;
        }
    }

    public void remove(int index) {
        if(index >= 0 && length > 0) {
            Nodo oldPositionNode = getNodo(index);

            int aux = index;

            while (aux > length) {
                aux -= length;
            }

            if(index == 0 || aux == 0) {
                head.setNext(oldPositionNode.getNext());
                oldPositionNode.getNext().setPrevious(tail.getNext());
                tail.getNext().setNext(oldPositionNode.getNext());
            } else if(index == length - 1 || aux == length - 1) {
                tail.setNext(oldPositionNode.getPrevious());
                oldPositionNode.getPrevious().setNext(head.getNext());
                head.getNext().setPrevious(tail.getNext());
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
