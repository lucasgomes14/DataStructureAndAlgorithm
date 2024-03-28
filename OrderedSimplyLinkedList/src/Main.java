import OrderedSimplyLinkedList.OrderedSimplyLinkedList;

public class Main {
    public static void main(String[] args) {
        OrderedSimplyLinkedList ls = new OrderedSimplyLinkedList();

        ls.add(10);
        ls.add(8);
        ls.add(9);
        ls.add(6);
        ls.add(7);
        ls.add(5);
        ls.add(3);
        ls.add(4);
        ls.add(1);
        ls.add(2);

        System.out.print("[");

        for(int i = 0; i < ls.size(); i++) {
            if(i == ls.size() - 1) {
                System.out.print(ls.getNodo(i).getValue() + "]");
            } else {
                System.out.print(ls.getNodo(i).getValue() + ", ");
            }
        }

        ls.remove();
        ls.remove();
        ls.remove();
        ls.remove();

        System.out.print("\n[");

        for(int i = 0; i < ls.size(); i++) {
            if(i == ls.size() - 1) {
                System.out.print(ls.getNodo(i).getValue() + "]");
            } else {
                System.out.print(ls.getNodo(i).getValue() + ", ");
            }
        }
    }
}