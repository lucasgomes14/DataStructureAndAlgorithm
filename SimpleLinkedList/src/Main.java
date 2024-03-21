import LinkedSList.LinkedSList;

public class Main {
    public static void main(String[] args) {
        LinkedSList ls = new LinkedSList();

        //Size
        System.out.println(ls.size());

        //add at the end(element)
        ls.add(5);
        ls.add(6);

        //getNodo(index)
        System.out.println(ls.getNodo(0));

        //add position(element, index)
        ls.add(2, 1);

        System.out.println(ls.getValue(1));

        //remove(index)
        ls.remove(0);
        System.out.println(ls.getValue(0));

        //getValue(index)
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        for(int i = 0; i < ls.size(); i++) {
            System.out.println(ls.getValue(i));
        }
    }
}
