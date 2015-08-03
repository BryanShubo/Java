package CodingHire.StringAndArray;

/**
 * Created by Shubo on 8/1/2015.
 */
public class ReverseString {

    public static void main(String[] args) {
        String s = "This is a simple; question.";
        reverseString(s);
    }

    public static void reverseString(String s) {

        String[] strings = s.split(" ");

        String result = "";
        for(int i = strings.length - 1; i >= 0; i--) {
             result += strings[i] + " ";
        }

        System.out.println(result);
    }
}
