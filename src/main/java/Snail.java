public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (!isPerfectSquare(array2d)) {
            return new int[0];
        }
        int length = array2d.length;
        int[] output = new int [length^2];
        int cnt =0;

        int top = 0;
        int bottom = length-1;
        int left = 0;
        int right = length-1;

        while(top<=bottom &&left <=right){
            for(int i=left;i<right;i++){
                output[cnt]=array2d[top][i];
                cnt++;
            }
        }
        top++;
        for (int i=top;i<=bottom;i++) {
            output[cnt]=array2d[i][right];
        }
        right--;
        if(top<=bottom){
            for(int i=right;i>=left;i--){
                output[cnt]=array2d[i][left];
            }
        }
        bottom--;
        if(left<=right){
            for(int i=bottom;i>=top;i--){
                output[cnt] = array2d[i][left];
            }
        }
        left++;
        return output;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if(array1d==null){
            return new int[0][0];
        }
        if (!isPerfectSquare(array1d)) {
            return new int[0][0];
        }
        int length = array1d.length;
        int size = (int) Math.sqrt(length);
        int[][] output = new int[size][size];

        int top = 0;
        int bottom = size - 1;
        int left = 0;
        int right = size - 1;
        int cnt = 0;

        while (top<=bottom && left<=right) {
            for (int i = left; i <= right; i++) {
                output[top][i] = array1d[cnt++];
            }
            top++;
            for (int i=top; i<=bottom; i++) {
                output[i][right] = array1d[cnt++];
            }
            right--;
            if (top<=bottom) {
                for (int i = right; i >= left; i--) {
                    output[bottom][i] = array1d[cnt++];
                }
            }
            bottom--;
            if (left<=right) {
                for (int i=bottom; i>=top;i--) {
                    output[i][left] = array1d[cnt++];
                }
            }
            left++;
        }

        return output;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
            System.out.print("[");
            for (int i=0; i<array1d.length;i++) {
                System.out.print(array1d[i]);
                if (i !=array1d.length-1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        System.out.println("{");
        for (int[]row : array2d) {
            System.out.print(" {");
            for (int i=0; i<row.length; i++) {
                System.out.print(row[i]);
                if (i!= row.length-1) {
                    System.out.print(", ");
                }
            }
            System.out.println("},");
        }
        System.out.println("}");
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int length = array1d.length;
        int sqrt = (int) Math.sqrt(length);
        if(sqrt * sqrt!=length){
            return false;
        }
        return true;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        int rows = array2d.length;
        if (rows == 0) {
            return false;
        }
        int cols = array2d[0].length;
        for (int[] row : array2d) {
            if (row.length!= cols) {
                return false;
            }
        }
        return rows == cols;
    }


}
