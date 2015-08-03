package CodingHire.StringAndArray;


public class IntToString {

    public static String intToString(int i) {
        String result = "";
        boolean flag = false;
        if (i < 0) {
            flag = true;
            i = -i;
        }
        while(i > 0) {
            int digit = i % 10;
            result = digit + result;
            i /= 10;
        }

        if (flag) {
            return "-" + result;
        }
        return result;
    }
}
