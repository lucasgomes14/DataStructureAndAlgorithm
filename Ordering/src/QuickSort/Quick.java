package QuickSort;

public class Quick {
    public Quick() {
    }

    public int[] quickSort(int[] array, int first, int last) {
        if (first < last) {
            int pivot = partition(array, first, last);
            quickSort(array, first, pivot - 1);
            quickSort(array, pivot + 1, last);
        }
        return array;
    }

    public int partition(int[] array, int first, int last) {
        int x = array[last];
        int i = first - 1;

        for (int j = first; j < last; j++) {
            if (array[j] <= x) {
                i++;
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }

        int assistant = array[i + 1];
        array[i + 1] = array[last];
        array[last] = assistant;

        return i + 1;
    }

    public static void main(String[] args) {
        Quick quick = new Quick();

        int[] array = {8, 5, 2, 6, 9, 3, 1, 4, 0, 7};

        System.out.println("unordered array: ");

        for(int unorderedNumbers : array) {
            System.out.print(unorderedNumbers + " ");
        }

        System.out.println("\nsorted array");

        for(int sortedNumbers : quick.quickSort(array, 0, array.length - 1)) {
            System.out.print(sortedNumbers + " ");
        }
    }

}
