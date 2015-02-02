package com.week01;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubo on 2/1/2015.
 */
public class Inversion {

    public static double pairs = 0;

    public static void main(String[] args) {

        In in = new In("data\\IntegerArray.txt");
        int[] a = in.readAllInts();
        //int [] a = {10,9,8,7,6,5,4,3,2,1,0};
        int length = a.length;


        merge_sort(a, 0, length-1);
        StdOut.println("The result is: " + pairs);


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

        List<Integer> temp = new ArrayList<Integer>();

        // Merge in sorted form the 2 arrays
        while ( left <= mid && right <= r ){
            if ( input[left] < input[right] )
                temp.add(input[left++]);
            else {
                temp.add(input[right++]);
                pairs += (mid-left+1);
            }
        }

        // Merge the remaining elements in left array
        while ( left <= mid )
            temp.add(input[left++]);

        // Merge the remaining elements in right array
        while ( right <= r )
            temp.add(input[right++]);

        // Move from temp array to master array
        for ( int i = p; i <= r; i++ )
            input[i] = temp.get(i-p);

    }
}
