package ShellSort;

public class ShellSort {
    private int[] array;

    public ShellSort(int[] array){
        this.array = array;
    }

    public int[] shellSort() {
        int interval = array.length / 2;

        while(interval < array.length / 3) {
            interval *= 3 + 1;
        }

        while(interval > 0) {
            for(int outer = interval; outer < array.length; outer++) {
                int valueInsert = array[outer];
                int inner = outer;

                while(inner > interval - 1 &&  array[inner - interval] >= valueInsert) {
                    array[inner] = array[inner - interval];
                    inner -= interval;
                }

                array[inner] = valueInsert;
            }

            interval = (interval - 1) / 3;
        }

        return array;
    }
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        ShellSort shell = new ShellSort(array);

        System.out.println("unordered array: ");

        for(int unorderedNumbers : array) {
            System.out.print(unorderedNumbers + " ");
        }

        System.out.println("\nsorted array");

        for(int sortedNumbers : shell.shellSort()) {
            System.out.print(sortedNumbers + " ");
        }
    }
}
