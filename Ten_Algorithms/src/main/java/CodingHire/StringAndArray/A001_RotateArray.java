package CodingHire.StringAndArray;

/**
 * Problem: Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4]. How many different ways do you know to solve this problem?
 */
public class A001_RotateArray {

    public static void main(String[] args){

    }

    public static int[] rotate(int[] arr, int k) {

        reverse(arr, 0, arr.length - k -1);
        reverse(arr, arr.length - k, arr.length);

        return null;
    }

    public static int[] reverse(int[] arr, int start, int end) {
        for(int i = start; i < end - start; i++) {
            int temp = arr[i];
            arr[i] = arr[end - i];
            arr[end - i] = temp;
        }
        return arr;
    }

}
