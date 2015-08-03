package CodingHire.StringAndArray;


public class StringToInteger {


    public int stringToInteger(String s) {
        int result = 0;
        boolean flag = false;
        int startPos = 0;
        char[] num = s.toCharArray();

        if (num[0] == '-') {
            flag = true;
            startPos = 1;
        }

        for (int i = startPos; i < num.length; i++ ) {
            result *= 10;
            result += (num[i] - '0');
        }

        if (flag) {
           return -result;
        }

        return result;
    }
}
