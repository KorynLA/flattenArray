/**
 * FlattenArray class used to call flattenArray.
 */
public class FlattenArray {
    /**
     * Takes in a 2D array and returns the 1D array. Also displays on the screen the lowest and highest values.
     * @param int[][] array
     * @return int[] flattenedArray
     */
    public static int[] flattenArray(int[][] array) throws Exception {
        if(array == null) {
            throw new NullPointerException();
        }
        int size = 0;
        int highestVal = Integer.MIN_VALUE;
        int lowestVal  = Integer.MAX_VALUE;
        int flattenedArrayPointer = 0;

        for(int[] each : array) {
            size+=each.length;
        }

        int flattenedArray[] = new int[size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                flattenedArray[flattenedArrayPointer] = array[i][j];
                if(array[i][j] > highestVal) {
                    highestVal = array[i][j];
                }
                if(array[i][j] < lowestVal) {
                    lowestVal = array[i][j];
                }
                flattenedArrayPointer++;
            }
        }

        System.out.println("Highest Value: "+ highestVal);
        System.out.println("Lowest Value: "+ lowestVal);
        return flattenedArray;
    }

    /**
     * Main function to run flattenArray(), int [][] array can be updated with other 2D arrays.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //int [][] array can be updated with your own 2D arrays
        int[][] array = {{1}, {2}, {3}, {4, 5}, {6}, {7, 8}, {9}};
        int[] flattenedArr = {};
        try {
            flattenedArr = flattenArray(array);
        }
        catch (Exception ex) {
            System.out.println("Cannot use empty array");
        }
        for(int i=0; i < flattenedArr.length; i++) {
            System.out.print(flattenedArr[i]);
        }

    }
}
