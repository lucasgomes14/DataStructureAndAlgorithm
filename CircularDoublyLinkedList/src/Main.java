import CircularLinkedDList.CircularLinkedDList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CircularLinkedDList ls = new CircularLinkedDList();

        //Size
        System.out.println(ls.size());

        //add at the end(element)
        ls.add(5);
        ls.add(6);
        ls.add(7);
        ls.add(8);
        ls.add(9);

        //getNodo(index)
        System.out.println(ls.getNodo(10));
        System.out.println(ls.getValue(10));

        //add position(element, index)
        ls.add(2, 1);

        System.out.println(ls.getValue(11));

        //remove(index)
        ls.remove(0);
        ls.remove(1);
        ls.remove(2);

        System.out.println(ls.getValue(12));

        //getValue(index)
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        for(int i = 0; i < 20; i++) {
            System.out.println(ls.getValue(i));
        }
    }
}