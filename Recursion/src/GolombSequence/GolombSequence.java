package GolombSequence;

public class GolombSequence {
    static final int DEFAULT = 1;
    static final int AMOUNT_OF_INPUT = 4;


    public static int recursiveGolomb(int quantity) {
        if (quantity == DEFAULT)
            return DEFAULT;
        else
            return 1 + recursiveGolomb(quantity - recursiveGolomb(recursiveGolomb(quantity - 1)));


    }

    public static int golombWithoutRecursion(int quantity) {
        int[] sequence = new int [quantity + 1];

        sequence[1] = 1;

        for (int i = 2; i <= quantity; i++) {
            sequence[i] = 1 + sequence[i - sequence[sequence[i - 1]]];
        }

        return sequence[quantity];
    }

    public static void main(String[] args) {
        System.out.println(recursiveGolomb(AMOUNT_OF_INPUT));
        System.out.println(golombWithoutRecursion(AMOUNT_OF_INPUT));
    }

}
