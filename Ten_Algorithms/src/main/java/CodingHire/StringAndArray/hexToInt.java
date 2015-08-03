package CodingHire.StringAndArray;

/**
 * Created by Shubo on 8/2/2015.
 */
public class HexToInt {

  /*  public static void main(String[] args) {
        String s = "13abf";
        int len = s.length();
        int sum = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(len - 1 - i);
            int n = Character.digit(c, 16);
            sum += n*(1<<(4*i));
        }
    }*/

    public static void main(String[] args){
        System.out.println(new HexToInt().test()); // print 1
    }

    private int test() {
        int x = 1;
        try {
            return x;
        } finally {
            ++x;
            System.out.println("finally");
        }
    }
}


/*
* step 1: return 1 to main method
* step 2: run finally, but the local variable x modification won't affect the value in main method.
* */

/*public class Test {
    *//**
     * @param args add by zxx ,Dec 9, 2008
     *//*
    public static void main(String[] args) {
// TODO Auto-generated method stub
        System.out.println(new Test().test());;
    }
    int test()
    {
        try
        {
            return func1();
        }
        finally
        {
            return func2();
        }
    }
    int func1()
    {
        System.out.println("func1");
        return 1;
    }
    int func2()
    {
        System.out.println("func2");
        return 2;
    }
}
-----------执行结果-------------
        func1
        func2
        2
        结论：finally 中的代码比 return  和 break 语句后执行*/

