
### String
Question:
```java
public class Barn {
public static void main(String[] args) {
new Barn().go("hi", 1);
new Barn().go("hi", "world", 2);
}
public void go(String... y, int x) {
System.out.print(y[y.length - 1] + " ");
}
}
```
What is the result?
<ul>A. hi hi</ul>
<ul>B. hi world</ul>
<ul>C. world world</ul>
<ul>D. Compilation fails.</ul>
<ul>E. An exception is thrown at runtime.</ul>
Answer: D
Explanation: The method go(String[], int) in the type Barn is not applicable for the arguments (String, int). The variable argument type String of the method go must be the last parameter.
<br/>

Question:
```java
public static void parse(String str) {
try {
float f = Float.parseFloat(str);
} catch (NumberFormatException nfe) {
f = 0;
} finally {
System.out.println(f);
}
}
public static void main(String[] args) {
parse("invalid");
}
```
What is the result?
<ul>A. 0.0</ul>
<ul>B. Compilation fails.</ul>
<ul>C. A ParseException is thrown by the parse method at runtime.</ul>
<ul>D. A NumberFormatException is thrown by the parse method at runtime.</ul>
Answer: B
Explanation/Reference: f cannot be resolved
<br/>

Question:
```java
public class TestString1 {
public static void main(String[] args) {
String str = "420";
str += 42;
System.out.print(str);
}
}
```
What is the output?
<ul>A. 42</ul>
<ul>B. 420</ul>
<ul>C. 462</ul>
<ul>D. 42042</ul>
<ul>E. Compilation fails.</ul>
<ul>F. An exception is thrown at runtime.</ul>
Answer: D
Explanation/Reference:
<br/>


Question:
```java
 StringBuilder sb1 = new StringBuilder("123");
 String s1 = "123";
 // insert code here
. System.out.println(sb1 + " " + s1);
```
Which code fragment, inserted at line 24, outputs "123abc 123abc"?
<ul>A. sb1.append("abc"); s1.append("abc");</ul>
<ul>B. sb1.append("abc"); s1.concat("abc");</ul>
<ul>C. sb1.concat("abc"); s1.append("abc");</ul>
<ul>D. sb1.concat("abc"); s1.concat("abc");</ul>
<ul>E. sb1.append("abc"); s1 = s1.concat("abc");</ul>
<ul>F. sb1.concat("abc"); s1 = s1.concat("abc");</ul>
<ul>G. sb1.append("abc"); s1 = s1 + s1.concat("abc");</ul>
<ul>H. sb1.concat("abc"); s1 = s1 + s1.concat("abc");</ul>
Answer: E
Explanation/Reference:
<br/>

Question:
```java
 public class Person {
 private String name;
 public Person(String name) { this.name = name; }
 public boolean equals(Person p) {
 return p.name.equals(this.name);
 }
 }
```
Which statement is true?
<ul>A. The equals method does NOT properly override the Object.equals method.</ul>
<ul>B. Compilation fails because the private attribute p.name cannot be accessed in line 5.</ul>
<ul>C. To work correctly with hash-based data structures, this class must also implement the hashCode
method.</ul>
<ul>D. When adding Person objects to a java.util.Set collection, the equals method in line 4 will prevent
duplicates.</ul>
Answer: A
Explanation/Reference:
<br/>

Question:
```java
String[] elements = { "for", "tea", "too" };
String first = (elements.length > 0) ? elements[0] : null;
```
What is the result?
A. Compilation fails.
B. An exception is thrown at runtime.
C. The variable first is set to null.
D. The variable first is set to elements[0].
Answer: D
Explanation/Reference:
<br/>

Question:
```java
 public class TestString3 {
 public static void main(String[] args) {
 // insert code here
 System.out.println(s);
 }
 }
```
Which two code fragments, inserted independently at line 3, generate the output 4247? (Choose two.)
A. String s = "123456789";
s = (s-"123").replace(1,3,"24") - "89";
B. StringBuffer s = new StringBuffer("123456789");
s.delete(0,3).replace(1,3,"24").delete(4,6);
C. StringBuffer s = new StringBuffer("123456789");
s.substring(3,6).delete(1,3).insert(1, "24");
D. StringBuilder s = new StringBuilder("123456789");
s.substring(3,6).delete(1,2).insert(1, "24");
E. StringBuilder s = new StringBuilder("123456789");
delete(0,3).delete(1,3).delete(2,5).insert(1, "24");
Answer: BE
Explanation/Reference:
The operator - is undefined for argument type(s) String, String
The metod delete(int, int) is undefined for type String
<br/>

Question:
```java
 String test = "Test A. Test B. Test C.";
 // insert code here
 String[] result = test.split(regex);
```
Which regular expression, inserted at line 12, correctly splits test into "Test A", "Test B", and "Test C"?
A. String regex = "";
B. String regex = " ";
C. String regex = ".*";
D. String regex = "\\s";
E. String regex = "\\.\\s*";
F. String regex = "\\w[ \.] +";
Answer: E
Explanation/Reference:
<br/>

Question:
```java
public class Person {
private String name;
public Person(String name) {
this.name = name;
}
public boolean equals(Object o) {
if ( ! ( o instanceof Person) ) return false;
Person p = (Person) o;
return p.name.equals(this.name);
}
}
```
Which statement is true?
A. Compilation fails because the hashCode method is not overridden.
B. A HashSet could contain multiple Person objects with the same name.
C. All Person objects will have the same hash code because the hashCode method is not overridden.
D. If a HashSet contains more than one Person object with name="Fred", then removing another Person,
also with name="Fred", will remove them all.
Answer: B
Explanation/Reference:
<br/>

Question:
```java
NumberFormat nf = NumberFormat.getInstance();
nf.setMaximumFractionDigits(4);
nf.setMinimumFractionDigits(2);
String a = nf.format(3.1415926);
String b = nf.format(2);
```
Which two statements are true about the result if the default locale is Locale.US? (Choose two.)
A. The value of b is 2.
B. The value of a is 3.14.
C. The value of b is 2.00.
D. The value of a is 3.141.
E. The value of a is 3.1415.
F. The value of a is 3.1416.
G. The value of b is 2.0000.
Answer: CF
Explanation/Reference:
<br/>

Question:
```java
 String csv = "Sue,5,true,3";
 Scanner scanner = new Scanner( csv );
 scanner.useDelimiter(",");
 int age = scanner.nextInt();
```
What is the result?
A. Compilation fails.
B. After line 15, the value of age is 5.
C. After line 15, the value of age is 3.
D. An exception is thrown at runtime.
Answer: D
Explanation/Reference: // scanner has strings in it.
Exception in thread "main" java.util.InputMismatchException
at java.util.Scanner.throwFor(Unknown Source)
at java.util.Scanner.next(Unknown Source)
at java.util.Scanner.nextInt(Unknown Source)
at java.util.Scanner.nextInt(Unknown Source)
at Breaker.main(Breaker.java:8)
<br/>

Question:
```java
 String test = "a1b2c3";
 String[] tokens = test.split("\\d");
 for(String s: tokens) System.out.print(s + " ");
```
What is the result?
A. a b c
B. 1 2 3
C. a1b2c3
D. a1 b2 c3
E. Compilation fails.
F. The code runs with no output.
G. An exception is thrown at runtime.
Answer: A
Explanation/Reference:
