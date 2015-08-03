package CodingHire.StringAndArray;

/*
*
* 请设计一个百亿的算器 设计一个百亿的算器 设计一个百亿的算器 设计一个百亿的算器 设计一个百亿的算器 设计一个百亿的算器 设计一个百亿的算器 设计一个百亿的算器 设计一个百亿的算器 设计一个百亿的算器
首先要明白这道题目的考查点是什么， 首先要明白这道题目的考查点是什么， 首先要明白这道题目的考查点是什么， 首先要明白这道题目的考查点是什么， 一是 大家首先要 大家首先要 对计算机原理的底层细节要 清楚、对计算机原理的底层细节要 清楚、对计算机原理的底层细节要 清楚、对计算机原理的底层细节要 清楚、对计算机原理的底层细节要 清楚、知道 加减 法的位运算原理和知道 计算机中的术运会发生越界情况，二是 要具备一定的面向对象设计思想。
首先，计算机中用固定数量的几个字节来存储值所以能够表示是有一范围 首先，计算机中用固定数量的几个字节来存储值所以能够表示是有一范围 首先，计算机中用固定数量的几个字节来存储值所以能够表示是有一范围 首先，
计算机中用固定数量的几个字节来存储值所以能够表示是有一范围 首先，计算机中用固定数量的几个字节来存储值所以能够表示是有一范围 首先，计算机中用固定数量的几个字节来存储值所以能够表示是有一范围 首先，计算机中用固定数量的几个字节来存
储值所以能够表示是有一范围 首先，计算机中用固定数量的几个字节来存储值所以能够表示是有一范围 首先，计算机中用固定数量的几个字节来存储值所以能够表示是有一范围 首先，计算机中用固定数量的几个字节来存储值所以能够表示是有一范围 的，
 为了便于讲解和理，我们先 为了便于讲解和理，我们先 以 byte byte byte 类型的整数为例，它用 类型的整数为例，它用 1个字节进行存储，表示的最大数值范围 个字节进行存储，表示的最大数值范围 个字节进行存储，表示的最大数值范围
 为-128128128到+127+127+127+127。-1在内存中对应的二进制数据为 在内存中对应的二进制数据为 1111111111111111111111111111111111111111111111111111111111111111，如果两个 ，如果两个 -1相加，不考虑 相加，不考虑
 Java JavaJava运
*
*
*升， 运算后会产生进位二进制结果为 1,111111101,111111101,111111101,111111101,111111101,111111101,111111101,111111101,111111101,11111110，由于进位后超过了 由于进位后超过了 bytebytebytebyte类型 的存储空间，所以进位部 的存储空间，所以进位部 分被舍弃，即最终的结果为 1111111011111110111111101111111011111110111111101111111011111110，也就是 -2，这正好利用溢位的方式实现了负数运算。 ，这正好利用溢位的方式实现了负数运算。 -128 在内存 中对应的二进制数据为 1000000010000000100000001000000010000000100000001000000010000000，如果两个 ，如果两个 -128128128相加，不考虑 相加，不考虑 相加，不考虑 Java JavaJava运算时的类型提升， 后会产生进位运算时的类型提升， 后会产生进位运算时的类型提升， 后会产生进位二进制 结果为 1,000000001,000000001,000000001,000000001,000000001,000000001,000000001,000000001,000000001,00000000，由于进位后超过了 ，由于进位后超过了 ，由于进位后超过了 bytebytebyte 类型的存储空间，所以进位部分被舍弃即最终结果 类型的存储空间，所以进位部分被舍弃即最终结果 类型的存储空间，所以进位部分被舍弃即最终结果 类型的存储空间，所以进位部分被舍弃即最终结果 为 0000000000000000000000000000000000000000000000000000000000000000，也就是 ，也就是 0，这样的结果显然不是我们期望，说明 ，这样的结果显然不是我们期望说明 计算机中的术运是会发生越界情况 计算机中的术运是会发生越界情况 计算机中的术运是会发生越界情况 计算机中的术运是会发生越界情况 计算机中的术运是会发生越界情况 计算机中的术运是会发生越界情况 的，两个数值运算结果不能超过计机中该类型范围。 的，两个数值运算结果不能超过计机中该类型范围。 的，两个数值运算结果不能超过计机中该类型范围。 的，两个数值运算结果不能超过计机中该类型范围。 的，两个数值运算结果不能超过计机中该类型范围。 的，两个数值运算结果不能超过计机中该类型范围。 的，两个数值运算结果不能超过计机中该类型范围。 的，两个数值运算结果不能超过计机中该类型范围。 的，两个数值运算结果不能超过计机中该类型范围。 的，两个数值运算结果不能超过计机中该类型范围。 由于 Java JavaJava中涉及表达式运算时的类型自 中涉及表达式运算时的类型自 动提升，我们无法用 动提升，我们无法用 bytebytebyte 类型来做演示这种问题和现象的实验，大家可以用下面一个使整数例 类型来做演示这种问题和现象的实验，大家可以用下面一个使整数例 类型来做演示这种问题和现象的实验，大家可以用下面一个使整数例 子程序体验一下：
int a = Integer.MAX_VALUE; int a = Integer.MAX_VALUE; int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE; int a = Integer.MAX_VALUE; int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;int a = Integer.MAX_VALUE;
int b = Integer.MAX_ int b = Integer.MAX_ int b = Integer.MAX_int b = Integer.MAX_int b = Integer.MAX_int b = Integer.MAX_int b = Integer.MAX_ int b = Integer.MAX_ int b = Integer.MAX_int b = Integer.MAX_int b = Integer.MAX_int b = Integer.MAX_int b = Integer.MAX_int b = Integer.MAX_int b = Integer.MAX_VALUE;VALUE;VALUE;VALUE;
int sum = a + b; int sum = a + b; int sum = a + b; int sum = a + b;int sum = a + b;int sum = a + b;int sum = a + b;int sum = a + b;int sum = a + b;int sum = a + b;int sum = a + b;int sum = a + b;int sum = a + b;
System.out.println(System.out.println(System.out.println( System.out.println(System.out.println(System.out.println(System.out.println(System.out.println(System.out.println( System.out.println(System.out.println( System.out.println(System.out.println( System.out.println(System.out.println(“a= ”+a+ ”,b=,b=,b=”+b++b++b+”,sum=,sum= ,sum=,sum=”+sum); sum);sum);
先不考虑 long longlong类型，由于 int int的正数范围为 2的 31 次方，表示的最大数值约等于 次方，表示的最大数值约等于 2*1000*10002*1000*10002*1000*10002*1000*10002*1000*10002*1000*10002*1000*10002*1000*10002*1000*10002*1000*10002*1000*10002*1000*10002*1000*10002*1000*10002*1000*10002*1000*1000， 也就是 20 亿的大小， 亿的大小， 所以，要实现一个百亿的计算器我们得自己设类 所以，要实现一个百亿的计算器我们得自己设类 所以，要实现一个百亿的计算器我们得自己设类 所以，要实现一个百亿的计算器我们得自己设类 可以用于表示很大的整数 ， 并且提供了与另外一个整数进行加减乘除的功能， 大概功能 如下：
（）这个类内部有两成员变量，一表示符号另用字节数
组值的二进制（） 有一个 构造方法，把一个包含有多位数值的字符串转换到内部号和节组中
（）提供加减乘除的功能
public class BigIntegerpublic class BigIntegerpublic class BigIntegerpublic class BigInteger public class BigIntegerpublic class BigIntegerpublic class BigIntegerpublic class BigInteger public class BigInteger public class BigInteger public class BigInteger public class BigIntegerpublic class BigInteger
{
int sign; int sign; int sign; int sign;int sign;
byte[] val;byte[] val;byte[] val; byte[] val;byte[] val;byte[] val;byte[] val;byte[] val;
public Biginteger(String val)public Biginteger(String val)public Biginteger(String val)public Biginteger(String val) public Biginteger(String val)public Biginteger(String val)public Biginteger(String val) public Biginteger(String val) public Biginteger(String val) public Biginteger(String val)public Biginteger(String val) public Biginteger(String val) public Biginteger(String val)public Biginteger(String val)public Biginteger(String val)public Biginteger(String val)public Biginteger(String val)public Biginteger(String val)
{
sign = sign = sign = sign = sign = ;
val = ;val = ;val = ; val = ;val = ;val = ;
}
public BigInteger add(other)public BigInteger add(other)public BigInteger add(other)public BigInteger add(other) public BigInteger add(other)public BigInteger add(other)public BigInteger add(other) public BigInteger add(other) public BigInteger add(other) public BigInteger add(other)public BigInteger add(other) public BigInteger add(other)public BigInteger add(other)public BigInteger add(other)public BigInteger add(other) public BigInteger add(other) public BigInteger add(other) public BigInteger add(other)public BigInteger add(other) public BigInteger add(other)public BigInteger add(other) public BigInteger add(other)public BigInteger add(other)
{
}
public BigInteger subtract(opublic BigInteger subtract(opublic BigInteger subtract(opublic BigInteger subtract(o public BigInteger subtract(opublic BigInteger subtract(opublic BigInteger subtract(o public BigInteger subtract(o public BigInteger subtract(o public BigInteger subtract(opublic BigInteger subtract(o public BigInteger subtract(o public BigInteger subtract(opublic BigInteger subtract(o public BigInteger subtract(o public BigInteger subtract(opublic BigInteger subtract(o public BigInteger subtract(opublic BigInteger subtract(opublic BigInteger subtract(opublic BigInteger subtract(opublic BigInteger subtract(o public BigInteger subtract(other) ther)ther)
{
}
public BigInteger multiply(other)public BigInteger multiply(other)public BigInteger multiply(other)public BigInteger multiply(other) public BigInteger multiply(other)public BigInteger multiply(other)public BigInteger multiply(other) public BigInteger multiply(other) public BigInteger multiply(other) public BigInteger multiply(other)public BigInteger multiply(other) public BigInteger multiply(other)public BigInteger multiply(other)public BigInteger multiply(other) public BigInteger multiply(other) public BigInteger multiply(other) public BigInteger multiply(other) public BigInteger multiply(other) public BigInteger multiply(other)public BigInteger multiply(other)public BigInteger multiply(other)public BigInteger multiply(other)public BigInteger multiply(other) public BigInteger multiply(other)public BigInteger multiply(other) public BigInteger multiply(other)public BigInteger multiply(other)
{
}
public BigInteger divide(other)public BigInteger divide(other)public BigInteger divide(other)public BigInteger divide(other) public BigInteger divide(other)public BigInteger divide(other)public BigInteger divide(other) public BigInteger divide(other) public BigInteger divide(other) public BigInteger divide(other)public BigInteger divide(other) public BigInteger divide(other)public BigInteger divide(other) public BigInteger divide(other) public BigInteger divide(other)public BigInteger divide(other) public BigInteger divide(other) public BigInteger divide(other) public BigInteger divide(other)public BigInteger divide(other) public BigInteger divide(other)public BigInteger divide(other) public BigInteger divide(other)public BigInteger divide(other)
{
}
}
* */
public class SuperCalculator {
}
