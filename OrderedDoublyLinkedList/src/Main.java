import OrderedDoublLinkedList.OrderedDoublLinkedList;
import Nodo.Nodo;

public class Main {
    public static void main(String[] args) {
        OrderedDoublLinkedList ls = new OrderedDoublLinkedList();

        ls.add(5);
        ls.add(3);
        ls.add(2);
        ls.add(4);
        ls.add(1);
        ls.add(0);  //[0, 1, 2, 3, 4, 5]

        Nodo a = ls.getNodo(0);

        System.out.println(a.getValue());   // print = 0

        System.out.println(ls.remove());    // print = 0(return confirm) [X, 1, 2, 3, 4, 5]
        a = ls.getNodo(0);
        System.out.println(a.getValue());   // print = 1

        ls.remove(0);                 // [X, X, 2, 3, 4, 5]
        a = ls.getNodo(0);
        System.out.println(a.getValue());   // print = 2

        ls.remove(3);                 // [X, X, 2, 3, 4, X]
        a = ls.getNodo(2);
        System.out.println(a.getValue());   // print = 4

        ls.remove(1);                 // [X, X, 2, X, 4, X]
        a = ls.getNodo(1);
        System.out.println(a.getValue());   // print = 4

        ls.add(9);
        ls.add(8);
        ls.add(7);
        ls.add(6);
        ls.add(5);
        ls.add(4);
        ls.add(3);
        ls.add(2);
        ls.add(1);
        ls.add(0);

        System.out.print("[");

        for(int i = 0; i < ls.size(); i++) {    // [0, 1, 2, 2, 3, 4, 4, 5, 6, 7, 8, 9]
            if(i == ls.size() - 1) {
                System.out.print(ls.getNodo(i).getValue() + "]");
            } else {
                System.out.print(ls.getNodo(i).getValue() + ", ");
            }
        }

        while(ls.size() > 0) {
            ls.remove();
        }
    }
}