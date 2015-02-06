package com.week01;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubo on 2/2/2015.
 */
public class MergeSort {

    public static int[] temp;

    public static void main(String[] args) {

        In in = new In("data\\IntegerArray.txt");
        int[] a = in.readAllInts();
        int length = a.length;

        temp = new int[a.length];

        merge_sort(a, 0, length-1);

        for(int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

    public static void merge_sort(int[] a, int p, int r) {

        if (p < r) {
            int mid = (p + r)/2;
            merge_sort(a,p,mid);
            merge_sort(a,mid+1,r);
            merge(a, p, r);
        }

    }

    public static void merge(int[] input, int p, int r) {
        int mid = ((p + r) / 2);
        int left = p;
        int right = mid + 1;

        int counter = 0;


        // Merge in sorted form the 2 arrays
        while ( left <= mid && right <= r ){
            if ( input[left] < input[right] )
                temp[counter++] = input[left++];
            else {
                temp[counter++] = input[right++];
            }
        }

        // Merge the remaining elements in left array
        while ( left <= mid )
            temp[counter++] = input[left++];

        // Merge the remaining elements in right array
        while ( right <= r )
            temp[counter++] = input[right++];

        // Move from temp array to master array
        for ( int i = p; i <= r; i++ )
            input[i] = temp[i-p];
    }
}
