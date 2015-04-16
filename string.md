###1. Creating String objects 
###2. Comparison 
###3. String constant pool:  
###4. The class String is immutable 
###5. Methods of the class String:  
###6. StringBuffer vs StringBuilder 
###7. How to put a String into constant String pool? 
 
1.Creating String objects 
String s1 = new String(“Java1”);  
// create a new object in heap. Dynamic allocation, it is given by programmer 
 
String s2 = “Java2”; 
// A new String object gets created only if a matching String object with the same value isn’t found in the String constant pool. Static allocation, memory is assigned by JVM 
 
whether a defined String object put into String constant pool or not ? 
judge whether it can be compiled before runtime in JVM. 
 
reference of String always store in heap, but actual object itself it depends situation: 1. if it can be compiled, it will stored in constant pool. 2. if it can’t (new keyword), it will stored in heap. 
 
2. Comparison 
The operator == compares the addresses of the objects referred to two strings.  
 
equals() method compares the characters of a string. 
 
Example: 
String str1 = new String("Paul"); 
String str2 = new String("Paul"); 
System.out.println(str1 == str2); //false. 
System.out.println(s1.equals(s2)); // true 
-------------------------------------------------------- 
        String str3 = "Harry"; 
        String str4 = "Harry"; 
        System.out.println(str3 == str4); // true 
------------------------------------------------------ 
String morning1 = "Morning"; 
System.out.println("Morning" == morning1); //output: true.   
--------------------------------------------------------------- 
String morning2 = new String("Morning"); 
System.out.println("Morning" == morning2); // false 
 
3. String constant pool:  
The terms “String constant pool” and “String pool” are used interchangeably and refer to the same pool of String objects. Because String objects are immutable, the pool of String objects is also called the “String constant pool.” 
 
4. The class String is immutable 
The immutability of String objects helps the JVM reuse String objects, reducing memory overhead and increasing performance. 
1): STRING USES A CHAR ARRAY TO STORE ITS VALUE: The arrays are fixed in size—they can’t grow once they’re initialized. 
2): STRING USES FINAL VARIABLE TO STORE ITS VALUE 
3): METHODS OF STRING DON’T MODIFY THE CHAR ARRAY: All the methods defined in the class String, such as substring, concat, toLowerCase, toUpperCase, trim, and so on, which seem to modify the contents of the String object on which they’re called, create and return a new String object, rather than modifying the existing value. 
4): Strings are immutable. Once initialized, a String value can’t be modified. All the String methods that return a modified String value return a new String object with the modified value. The original String value always remains the same. 
 
5. Methods of the class String:  
1)charAt(int index): retrieve a character at a specified index of a String. 
2) indexOf(char or String): If the specified char or String is found in the target String, this method returns the first matching position; otherwise, it returns -1; 
3) substring(int start) or substring(int start, end), the first returns a substring of a String from the position you specify to the end of the String. An interesting point of second method is that the return string does not include the last character. For instance, s.substring(2,4) return s[2], s[3]. 
4) trim(): method returns a new String by removing all the leading and trailing white space in a String. White spaces are blanks (new lines, spaces, or tabs). 
5) replace(char, char) or replace(String, String) cannot mix it: This method will return a new String by replacing all the occurrences of a char with another char. Instead of specifying a char to be replaced by another char, you can also specify a sequence of characters—a String to be replaced by another String. 
6) length(): method to retrieve the length of a String. 
7) startsWith(String) or startsWith(String, int) / endsWith(String) 
8) method chaining: evaluated from left to right. 
 
6. StringBuffer vs StringBuilder 
1) They are both  mutable. Dealing with larger strings or modifying the contents of a string often. Doing so will improve the performance of your code. 
 
2)  StringBuffer are synchronized  and thread safe, whereas the methods of the class StringBuilder(add in java 5.0) aren’t. 
 
3) This class [StringBuilder] provides an API compatible with StringBuffer, but with no guarantee of synchronization. This class is designed for use as a drop-in replacement for StringBuffer in places where the string buffer was being used by a single thread (as is generally the case). Where possible, it is recommended that this class be used in preference to StringBuffer as it will be faster under most implementations. 
 
 
7. How to put a String into constant String pool? 
String s = new String(“abc”); 
“abc”.intern(); 
 
 
