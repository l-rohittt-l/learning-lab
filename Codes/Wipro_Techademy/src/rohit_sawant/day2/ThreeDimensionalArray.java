package rohit_sawant.day2;

public class ThreeDimensionalArray {

    public static void main(String[] args) {

        // Already existing 3D array
        int[][][] arr = {
                {
                        {1, 2, 3},
                        {4, 5, 6}
                },
                {
                        {7, 8, 9},
                        {10, 11, 12}
                }
        };

        // Printing the 3D array
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Block " + i + ":");

            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.println();
            }

            System.out.println();
        }
    }
}
