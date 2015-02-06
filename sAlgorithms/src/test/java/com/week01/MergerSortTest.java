package com.week01;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by Shubo on 2/3/2015.
 */


public class MergerSortTest {

    private Collection collection;

    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time initialization code
        System.out.println("@BeforeClass - oneTimeSetUp");
    }

    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
        System.out.println("@AfterClass - oneTimeTearDown");
    }

    @Before
    public void setUp() {
        collection = new ArrayList();
        System.out.println("@Before - setUp");
    }

    @After
    public void tearDown() {
        collection.clear();
        System.out.println("@After - tearDown");
    }

    @Test
    public void mergerSortTest(){

        MergeSort ms = new MergeSort();
        /*In in = new In("data\\IntegerArray.txt");
        int[] a = in.readAllInts();*/
        int[] a = {10, 2, 8, 1,6,5,4,3,9,7,0};
        int length = a.length;

        ms.temp = new int[a.length];

        ms.merge_sort(a, 0, length-1);

        //ms.merge(a, 0, length - 1);

        for(int i = 0; i < ms.temp.length; i++) {
            System.out.println(ms.temp[i]);
        }
    }

    @Test(expected = ArithmeticException.class)
    public void divisionWithException() {
        int i = 1/0;
    }

}
