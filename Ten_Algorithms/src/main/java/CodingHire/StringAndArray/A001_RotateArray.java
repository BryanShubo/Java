package CodingHire.StringAndArray;

/**
 * Problem: Rotate an array of n elements to the right by k steps. For example,
 * with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4]. How many different ways do you know to solve this problem?
 */
public class A001_RotateArray {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;

		int[] reverse = rotate(array, k);

		for (int i = 0; i < reverse.length; i++) {
			System.out.print(reverse[i] + " ");
		}
	}

	public static int[] rotate(int[] arr, int k) {
		int length = arr.length;
		int[] temp = new int[length];

		for (int i = 0; i < length - k; i++) {
			temp[i + k] = arr[i];
		}
		for (int j = length - k; j < length; j++) {
			temp[j - (length - k)] = arr[j];
		}

		return temp;
	}
}
