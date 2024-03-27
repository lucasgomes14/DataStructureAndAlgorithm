package OrderedDoublLinkedList;

import Nodo.Nodo;

public class OrderedDoublLinkedList {
    private int length;
    private Nodo head;
    private Nodo tail;

    public OrderedDoublLinkedList() {
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
            newNodo.setNext(head.getNext());
            newNodo.setPrevious(tail.getNext());
        } else {
            if(value < head.getNext().getValue()) {
                newNodo.setNext(head.getNext());
                newNodo.setPrevious(tail.getNext());
                head.getNext().setPrevious(newNodo);
                head.setNext(newNodo);
                tail.getNext().setNext(newNodo);
            } else if(value > tail.getNext().getValue()) {
                newNodo.setPrevious(tail.getNext());
                newNodo.setNext(head.getNext());
                tail.getNext().setNext(newNodo);
                tail.setNext(newNodo);
                head.getNext().setPrevious(newNodo);
            } else {
                Nodo position = sortPosition(value);

                newNodo.setNext(position);
                newNodo.setPrevious(position.getPrevious());
                position.getPrevious().setNext(newNodo);
                position.setPrevious(newNodo);
            }

        }
        length++;
    }

    public Nodo sortPosition(int value) {
        Nodo position = head.getNext();

        for(int i = 0; i < length; i++) {
            if(value < position.getValue()) {
                return position;
            }

            position = position.getNext();
        }
        return position;
    }

    public Nodo getNodo(int index) {
        Nodo position = head.getNext();

        if(index >= length) {
            return null;
        }

        for(int i = 0; i < index; i++) {
            position = position.getNext();
        }
        return position;
    }

    public int remove() {
        Nodo firstNodo = head.getNext();
        if(length > 0) {
            if(length == 1) {
                firstNodo.setNext(null);
                firstNodo.setPrevious(null);

                head.setNext(null);
                tail.setNext(null);

                length--;

                return 0;
            }
            head.setNext(firstNodo.getNext());
            head.getNext().setPrevious(tail.getNext());
            tail.getNext().setNext(head.getNext());

            length--;

            firstNodo.setPrevious(null);
            firstNodo.setNext(null);

            return 0;
        }
        return 1;
    }

    public int remove(int index) {
        if(length > 0 && index < length && index >= 0) {
            if(index == 0) {
                return remove();
            } else if(index == length - 1){
                Nodo lastNodo = tail.getNext();

                tail.setNext(lastNodo.getPrevious());
                tail.getNext().setNext(head.getNext());
                head.getNext().setPrevious(tail.getNext());

                length--;

                lastNodo.setPrevious(null);
                lastNodo.setNext(null);

                return 0;
            } else {
                Nodo position = getNodo(index);

                position.getNext().setPrevious(position.getPrevious());
                position.getPrevious().setNext(position.getNext());

                length--;

                position.setNext(null);
                position.setPrevious(null);

                return 0;
            }
        }
        return 1;
    }
}
