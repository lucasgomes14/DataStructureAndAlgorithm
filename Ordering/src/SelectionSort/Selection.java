package SelectionSort;

public class Selection {
    public Selection() {
    }

    public int[] selectionSort(int[] array) {

        int size = array.length;

        for(int i = 0; i < size - 1; i++) {
            int minimumPosition = i;

            for(int j = i + 1; j < size; j++) {
                if(array[j] < array[minimumPosition])
                    minimumPosition = j;
            }

            int assistant = array[i];
            array[i] = array[minimumPosition];
            array[minimumPosition] = assistant;
        }
        return array;
    }

    public static void main(String[] args) {
        Selection selection = new Selection();

        int[] array = {8, 5, 2, 6, 9, 3, 1, 4, 0, 7};

        System.out.println("unordered array: ");

        for(int unorderedNumbers : array) {
            System.out.print(unorderedNumbers + " ");
        }

        System.out.println("\nsorted array");

        for(int sortedNumbers : selection.selectionSort(array)) {
            System.out.print(sortedNumbers + " ");
        }
    }

}
