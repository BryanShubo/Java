package com.javase.string.manipulation;

import java.util.Arrays;

/**
 * An anagram of a string is another string that contains same characters,
 * only the order of characters can be different.
 * For example, “abcd” and “dabc” are anagram of each other.
 */
public class Anagrams {


    public static void main(String[] args){

        System.out.println(isAnagram("abc", "abcc"));
    }


    /*
* Check if two Strings are anagram in Java
* Assumption: both Strings are not null and only contain lowercase letters
* @Return true if both strings are anagram
*/
    public static boolean isAnagram(String str1, String str2) {
        char[] str1CharArray = str1.toCharArray();
        char[] str2CharArray = str2.toCharArray();
        Arrays.sort(str1CharArray);
        Arrays.sort(str2CharArray);
        return Arrays.equals(str1CharArray, str2CharArray);
    }

}
