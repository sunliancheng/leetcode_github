package LeetCodeUtils;

public class MyPrint {

    /**
     *  print the 2D boolean matrix
     * @param matrix
     */
    public static void print2DMatrix(boolean[][] matrix) {
        System.out.println("*********printing the 2D boolean matrix********");
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    /**
     *  print the 2D int matrix
     * @param matrix
     */
    public static void print2DMatrix(int[][] matrix) {
        System.out.println("*********printing the 2D int matrix********");
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    /**
     *  print the 1D boolean matrix
     * @param matrix
     */
    public static void print1DMatrix(boolean[] matrix) {
        System.out.println("*********printing the 1D boolean matrix********");
        for (int i = 0; i < matrix.length; ++i) {
            System.out.print(matrix[i] + " ");
        }
        System.out.println();
    }

    /**
     *  print the 1D int matrix
     * @param matrix
     */
    public static void print1DMatrix(int[] matrix) {
        System.out.println("*********printing the 1D int matrix********");
        for (int i = 0; i < matrix.length; ++i) {
            System.out.print(matrix[i] + " ");
        }
        System.out.println();
    }


}
