
1. final
final StringBuffer a = new StringBuffer("immutable");

a = new StringBuffer(""); // wrong

a.append("broken!");

2. Accesss modifier
```
private same class
default same class/same package
protected same class/ same package / inherited class
public same class/ same package / inherited class/ other package
```

3. OVERRIDE and OVERLOAD
```
OVERRIDE
1) when derived class override base method, it must throw less exception or sub-exception.
2) overrided method must have a more open access priviledge than base method.

OVERLOAD
1) arguments must be different, return type/access modifier/exception can be the same or different.
But only return type/access modifier/exception differnet, this is not OVERLODA.
```


4. how does ClassLoader load class
```
There are several ClassLoader in JVM
1) bootstrap load: jre/lib/rt.jar(like jdk)
2) extclassloader: jar/lib/ext/*.jar
3) appchassloader: load class path or classes from jar.

Except bootstrap, other loaders are extended from ClassLoader class.
```
5. servlet lifecycle


6. Why do we need Abstract class  

7. Multi-tier design advantages:
```
1) loose couping
2) multi team work independently
3) Easy to maintain
4) Reuseable
5) Easy to new techniques on one tier
6) Easy to scale
7) Adaptive to client's new requirements
```
8. Why serialization
```
1) 对象经常要通过IO进行传送， 把对象的状态数据用某种格式写入到硬盘，Person->“zxx,male,28,30000”->Person，but there is no
standard for this process.
2) sun公司就提出一种统一的解决方案，它会把对象变成某个格式进行输入和输出，这种格式对程序员来说是透明（transparent）的，但是，我们的某个类要想能被sun的这种方案处理，必须实现Serializable接口。
ObjectOutputStream.writeObject(obj);
Object obj = ObjectInputStream.readObject();
3) 假设两年前我保存了某个类的一个对象，这两年来，我修改该类，删除了某个属性和增加了另外一个属性，两年后，我又去读取那个保存的对象，或有什么结果？未知！sun的jdk就会蒙了。为此，一个解决办法就是在类中增加版本后，每一次类的属性修改，都应该把版本号升级一下，这样，在读取时，比较存储对象时的版本号与当前类的版本号，如果不一致，则直接报版本号不同的错!
```

9. clone()
```
the first line of code is : super.clone().
// This means that it needs to copy base members and then derived members.
```

10 OO concepts
```
1) 1封装：
封装 是保证软件部具有优良的模块性基础 保证软件部具有优良的模块性基础 保证软件部具有优良的模块性基础 ，封装  的目标就是要实现软件部“高内聚、低 耦合”， 耦合”， 防止 程序相互依赖性而带来的变动影响。 。 在面向对象的编程语言中， 对象是封装的最基本单 面向对象的封 装比传统语言的封更为清晰、有力 装比传统语言的封更为清晰、有力。面向对象的 封装就是把描述一个对象的属 性和行为的代码封装在一个“模块”中，也就是类属用变量定义方法 进性和行为的代码封装在一个“模块”中，也就是类属用变量定义方法  进可以直接访问同一个对象中的属性。 可以直接访问同一个对象中的属性。


2) Abstract
抽象：
抽象就是找出一些 事物的相似和共性之处，然后将这抽象就是找出一些 事物的相似和共性之处，然后将这事物 归为一个类 ，这归为一个类 ，这归为一个类 ，这只考虑这些事物 只考虑这些事物 的相似和共性之处， 并且会忽略与当前主题和目标无关 的那些方面，将注意力集中在有的方面。 

3)多态
是指程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时
并不确定，而是在程序运行期间才确定，即一个引用变量倒底会指向哪个类的实例对象，该引用变量 发出的方法调用到底是哪个类中实现的方法，必须在由程序运行期间才能决定。因为在程序运行时才 
确定具体的类，这样，不用修改源程序代码，就可以让引用变量绑定到各种不同的类实现上，从 而导致该引用调用的具体方法随之改变，即不修改程序代码就可以改变程序运行时所绑定的具 
体代码，让程序可以选择多个运行状态，这就是多态性。多态性增强了软件的灵活性和扩展性。 

java 中实现多态的机制是什么？
靠的是父类或接口定义的引用变量可以指向子类或具体实现类的实例对象，而程序调用的方法在 运行期才动态绑定，就是引用变量所指向的具体实例对象的方法，也就是内存里正在运行的那个对象 
的方法，而不是引用变量的类型中定义的方法。

```

11 abstract class 和 interface 有什么区别?
```
含有 abstract 修饰符的 class 即为抽象类，abstract  类不能创建的实例对象。含有 abstract 方法的类必须 定义为 abstract class，abstract 
class 类中的方法不必是抽象的。abstract class 类中定义抽象方法必须在具体 (Concrete)子类中实现，所以，不能有抽象构造方法或抽象静态方法。如果的子类没有实现抽象父类中的所 
有抽象方法，那么子类也必须定义为 abstract 类型。
接口（interface）可以说成是抽象类的一种特例，接口中的所有方法都必须是抽象的。接口中的方法定 义默认为 public abstract 类型，接口中的成员变量类型默认为 public 
static final。
下面比较一下两者的语法区别：
1.抽象类可以有构造方法，接口中不能有构造方法。
2.抽象类中可以有普通成员变量，接口中没有普通成员变量
3.抽象类中可以包含非抽象的普通方法，接口中的所有方法必须都是抽象的，不能有非抽象的普通方 法。
4.  抽象类中的抽象方法的访问类型可以是 public，protected 和（默认类型,虽然
eclipse 下不报错，但应该也不行），但接口中的抽象方法只能是 public 类型的，并且默认即为 public abstract 类型。
5.  抽象类中可以包含静态方法，接口中不能包含静态方法
6.  抽象类和接口中都可以包含静态成员变量，抽象类中的静态成员变量的访问类型可以任意，但接口 中定义的变量只能是 public static final 类型，并且默认即为 public 
static final 类型。
7.  一个类可以实现多个接口，但只能继承一个抽象类。
下面接着再说说两者在应用上的区别：
接口更多的是在系统架构设计方法发挥作用，主要用于定义模块之间的通信契约。而抽象类在代码实 现方面发挥作用，可以实现代码的重用，例如，模板方法设计模式是抽象类的一个典型应用，假设某个项 目的所有 
Servlet 类都要用相同的方式进行权限判断、记录访问日志和处理异常，那么就可以定义一个抽象 的基类，让所有的 Servlet 都继承这个抽象基类，在抽象基类的 service 
方法中完成权限判断、记录访问日 志和处理异常的代码，在各个子类中只是完成各自的业务逻辑代码，伪代码如下：

父类方法中间的某段代码不确定，留给子类干，就用模板方法设计模式。
备注：这道题的思路是先从总体解释抽象类和接口的基本概念，然后再比较两者的语法细节，最后再 说两者的应用区别。比较两者语法细节区别的条理是：先从一个类中的构造方法、普通成员变量和方法（包 
括抽象方法），静态变量和方法，继承性等 6 个方面逐一去比较回答，接着从第三者继承的角度的回答，特 别是最后用了一个典型的例子来展现自己深厚的技术功底。

```

9、abstract 的 method 是否可同时是 static,是否可同时是
native，是否可同时是 synchronized?


abstract 的 method  不可以是 static 的，因为抽象的方法是要被子类实现的，而 static 与子类扯不上关系！
native 方法表示该方法要用另外一种依赖平台的编程语言实现的，不存在着被子类实现的问题，所以， 它也不能是抽象的，不能与 abstract 混用。例如，FileOutputSteam 
类要硬件打交道，底层的实现用的是操 作系统相关的 api  实现，例如，在 windows  用 c  语言实现的，所以，查看 jdk  的源代码，可以发现 FileOutputStream 的 
open 方法的定义如下：
private native void open(String name) throws FileNotFoundException;
如果我们要用 java 调用别人写的 c 语言函数，我们是无法直接调用的，我们需要按照 java 的要求写一 个 c 语言的函数，又我们的这个 c 语言函数去调用别人的 c 语言函数。由于我们的 c 
语言函数是按 java 的 要求来写的，我们这个 c 语言函数就可以与 java 对接上，java 那边的对接方式就是定义出与我们这个 c 函


数相对应的方法，java 中对应的方法不需要写具体的代码，但需要在前面声明 native。
关于 synchronized 与 abstract 合用的问题，我觉得也不行，因为在我几年的学习和开发中，从来没见到 过 这 种 情 况， 并 且我 觉 得 synchronized  应 该 
是作 用 在一 个具 体 的 方 法上 才 有意 义 。 而且 ， 方 法 上 的 synchronized 同步所使用的同步锁对象是 this，而抽象方法上无法确定 this 是什么。

2、final, finally, finalize 的区别。


final 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。 内部类要访问局部变量，局部变量必须定义成 final 类型，例如，一段代码……

finally 是异常处理语句结构的一部分，表示总是执行。



finalize 是 Object 类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法， 可以覆盖此方法提供垃圾收集时的其他资源回收，例如关闭文件等。JVM 不保证此方 法总被调用


5、运行时异常与一般异常有何异同？


异常表示程序运行过程中可能出现的非正常状态，运行时异常表示虚拟机的通常操作中可能 遇到的异常，是一种常见运行错误。java 编译器要求方法必须声明抛出可能发生的非运行时 
异常，但是并不要求必须声明抛出未被捕获的运行时异常。

15、error 和 exception 有什么区别?


error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指 望程序能处理这样的情况。 exception 表示一种设计或实现问题。也就是说，它表示如果程 
序运行正常，从不会发生的情况。



50、Java 中的异常处理机制的简单原理和应用。


异常是指 java 程序运行时（非编译）所发生的非正常情况或错误，与现实生活中的事件很 相似，现实生活中的事件可以包含事件发生的时间、地点、人物、情节等信息，可以用一个 对象来表示，Java 
使用面向对象的方式来处理异常，它把程序中发生的每个异常也都分别封 装到一个对象来表示的，该对象中包含有异常的信息。
Java 对异常进行了分类，不同类型的异常分别用不同的 Java 类表示，所有异常的根类为 java.lang.Throwable，Throwable 下面又派生了两个子类：Error 和 
Exception，Error 表示应 用程序本身无法克服和恢复的一种严重问题，程序只有死的份了，例如，说内存溢出和线程 死锁等系统问题。Exception 
表示程序还能够克服和恢复的问题，其中又分为系统异常和普 通异常，系统异常是软件本身缺陷所导致的问题，也就是软件开发人员考虑不周所导致的问 
题，软件使用者无法克服和恢复这种问题，但在这种问题下还可以让软件系统继续运行或者 让软件死掉 ， 例 如 ， 数 组 脚 本 越 界 （ ArrayIndexOutOfBoundsException 
）， 空 指 针 异 常
（NullPointerException）、类转换异常（ClassCastException）；普通异常是运行环境的变化或 
异常所导致的问题，是用户能够克服的问题，例如，网络断线，硬盘空间不够，发生这样的 异常后，程序不应该死掉。
java 为系统异常和普通异常提供了不同的解决方案，编译器强制普通异常必须 try..catch 处 理或用 throws 声明继续抛给上层调用方法处理，所以普通异常也称为 checked 
异常，而系统 异常可以处理也可以不处理，所以，编译器不强制用 try..catch 处理或用 throws 声明，所以 系统异常也称为 unchecked 异常。


提示答题者：就按照三个级别去思考：虚拟机必须宕机的错误，程序可以死掉也可以不死掉 的错误，程序不应该死掉的错误；


33、请写出你最常见到的 5 个 runtime exception。


这道题主要考你的代码量到底多大，如果你长期写代码的，应该经常都看到过一些系统方面的异常， 你不一定真要回答出 5 个具体的系统异常，但你要能够说出什么是系统异常，以及几个系统异常就可以了， 
当然，这些异常完全用其英文名称来写是最好的，如果实在写不出，那就用中文吧，有总比没有强！
所谓系统异常，就是…..，它们都是 RuntimeException 的子类，在 jdk doc 中查 RuntimeException 类， 就 可 以 看 到 其 所 有 的 子 类 列 表 ， 
也 就 是 看 到 了 所 有 的 系 统 异 常 。 我 比 较 有 印 象 的 系 统 异 常 有 ： 
NullPointerException、ArrayIndexOutOfBoundsException、ClassCastException。



99、java 中有几种方法可以实现一个线程？用什么关键字修
饰同步方法? stop()和 suspend()方法为何不推荐使用？



java5 以前，有如下两种： 第一种：
new Thread(){}.start();这表示调用 Thread 子类对象的 run 方法，new Thread(){}表示一个
Thread 的匿名子类的实例对象，子类加上 run 方法后的代码如下：
new Thread(){
public void run(){
}
}.start();

第二种：
new Thread(new Runnable(){}).start();这表示调用 Thread 对象接受的 Runnable 对象的 run 方法，new Runnable(){}表示一个 
Runnable 的匿名子类的实例对象,runnable 的子类加 上 run 方法后的代码如下：
new Thread(new Runnable(){
public void run(){
}
}
).start();
从 java5 开始，还有如下一些线程池创建多线程的方式：
ExecutorService pool = Executors.newFixedThreadPool(3)
for(int i=0;i<10;i++)
{






pool.execute(new Runable(){public void run(){}});
}

Executors.newCachedThreadPool().execute(new Runable(){public void run(){}}); 
Executors.newSingleThreadExecutor().execute(new Runable(){public void run(){}});
有两种实现方法，分别使用 new Thread()和 new Thread(runnable)形式，第一种直接调用 thread 的 run 方法，所以，我们往往使用 Thread 子类，即 new 
SubThread()。第二种调 用 runnable 的 run 方法。


有两种实现方法，分别是继承 Thread 类与实现 Runnable 接口 用 synchronized 关键字修饰同步方法
反对使用 stop()，是因为它不安全。它会解除由线程获取的所有锁定，而且如果对象处 于一种不连贯状态，那么其他线程能在那种状态下检查和修改它们。结果很难检查出 
真正的问题所在。suspend()方法容易发生死锁。调用 suspend()的时候，目标线程会停
下来，但却仍然持有在这之前获得的锁定。此时，其他任何线程都不能访问锁定的资 源，除非被"挂起"的线程恢复运行。对任何线程来说，如果它们想恢复目标线程，同 
时又试图使用任何一个锁定的资源，就会造成死锁。所以不应该使用 suspend()，而应 在自己的 Thread 类中置入一个标志，指出线程应该活动还是挂起。若标志指出线程应 该挂起，便用 
wait()命其进入等待状态。若标志指出线程应当恢复，则用一个 notify() 重新启动线程。


13、sleep() 和 wait() 有什么区别?


（网上的答案：sleep 是线程类（Thread）的方法，导致此线程暂停执行指定时间，给 执行机会给其他线程，但是监控状态依然保持，到时后会自动恢复。调用 sleep 不会释放对 象锁。 wait 
是 Object 类的方法，对此对象调用 wait 方法导致本线程放弃对象锁，进入等待 此对象的等待锁定池，只有针对此对象发出 notify 方法（或 notifyAll）后本线程才进入对象 
锁定池准备获得对象锁进入运行状态。）


sleep 就是正在执行的线程主动让出 cpu，cpu 去执行其他线程，在 sleep 指定的时间过 后，cpu 才会回到这个线程上继续往下执行，如果当前线程进入了同步锁，sleep 方法并不会 
释放锁，即使当前线程使用 sleep 方法让出了 cpu，但其他被同步锁挡住了的线程也无法得 到执行。wait 是指在一个已经进入了同步锁的线程内，让自己暂时让出同步锁，以便其他正 
在等待此锁的线程可以得到同步锁并运行，只有其他线程调用了 notify 方法（notify 并不释


放锁，只是告诉调用过 wait 方法的线程可以去参与获得锁的竞争了，但不是马上得到锁，
因为锁还在别人手里，别人还没释放。如果 notify 方法后面的代码还有很多，需要这些代码 执行完后才会释放锁，可以在 notfiy 方法后增加一个等待和一些代码，看看效果），调用 wait 
方法的线程就会解除 wait 状态和程序可以再次得到锁后继续向下运行。对于 wait 的讲解一 定要配合例子代码来说明，才显得自己真明白。
package com.huawei.interview;


public class MultiThread {
/**
* @param args
*/
public static void main(String[] args) {
// TODO Auto-generated method stub
new Thread(new Thread1()).start();
try {
Thread.sleep(10);
} catch (InterruptedException e) {
// TODO Auto-generated catch block e.printStackTrace();
}
new Thread(new Thread2()).start();
}
private static class Thread1 implements Runnable
{
@Override
public void run() {
// TODO Auto-generated method stub
//由于这里的Thread1和下面的Thread2内部run方法要用同一对象作为监视器，我们这里不 
能用this，因为在Thread2里面的this和这个Thread1的this不是同一个对象。我们用 MultiThread.class这个字节码对象，当前虚拟机里引用这个变量时，指向的都是同一个对 
象。











synchronized (MultiThread.class) {
System.out.println("enter thread1...");


System.out.println("thread1 is waiting");
try {
//释放锁有两种方式，第一种方式是程序自然离开监视器的范围，也就是离开了
synchronized关键字管辖的代码范围，另一种方式就是在synchronized关键字管辖的代码
内部调用监视器对象的wait方法。这里，使用wait方法释放锁。
MultiThread.class.wait();
} catch (InterruptedException e) {
// TODO Auto-generated catch block e.printStackTrace();
}
System.out.println("thread1 is going on...");
System.out.println("thread1 is being over!");
}
}
}
private static class Thread2 implements Runnable
{
@Override
public void run() {
// TODO Auto-generated method stub
synchronized (MultiThread.class) { System.out.println("enter thread2...");
System.out.println("thread2 notify other thread can
release wait status..");
//由于notify方法并不释放锁， 即使thread2调用下面的sleep方法休息了10毫秒，但
thread1仍然不会执行，因为thread2没有释放锁，所以Thread1无法得不到锁。






MultiThread.class.notify();


System.out.println("thread2 is sleeping ten millisecond...");
try {
Thread.sleep(10);
} catch (InterruptedException e) {
// TODO Auto-generated catch block e.printStackTrace();
}
System.out.println("thread2 is going on...");
System.out.println("thread2 is being over!");
}
}
}
}

16、同步和异步有何异同，在什么情况下分别使用他们？举
例说明。
如果数据将在线程间共享。例如正在写的数据以后可能被另一个线程读到，或者正在读的数
据可能已经被另一个线程写过了，那么这些数据就是共享数据，必须进行同步存取。 当应用程序在对象上调用了一个需要花费很长时间来执行的方法，并且不希望让程序等待方 
法的返回时，就应该使用异步编程，在很多情况下采用异步途径往往更有效率。



17. 下面两个方法同步吗？（自己发明）
class Test
{
synchronized static void sayHello3()
{


}
synchronized void getX(){}
}
56、多线程有几种实现方法?同步有几种实现方法?


多线程有两种实现方法，分别是继承 Thread 类与实现 Runnable 接口 同步的实现方面有两种，分别是 synchronized,wait 与 notify 
wait():使一个线程处于等待状态，并且释放所持有的对象的 lock。 sleep():使一个正在运行的线程处于睡眠状态，是一个静态方法，调用此方法要捕捉 InterruptedException 
异常。 notify():唤醒一个处于等待状态的线程，注意的是在调用此方法的时候，并不能确切的唤 醒某一个等待状态的线程，而是由 JVM 确定唤醒哪个线程，而且不是按优先级。 
Allnotity():唤醒所有处入等待状态的线程，注意并不是给所有唤醒线程一个对象的锁，
而是让它们竞争

30、启动一个线程是用 run()还是 start()? .


启动一个线程是调用 start()方法，使线程就绪状态，以后可以被调度为运行状态，一个 线程必须关联一些具体的执行代码，run()方法是该线程所关联的执行代码。



47、当一个线程进入一个对象的一个 synchronized 方法后， 其它线程是否可进入此对象的其它方法?
分几种情况：
1.其他方法前是否加了 synchronized 关键字，如果没加，则能。
2.如果这个方法内部调用了 wait，则可以进入其他 synchronized 方法。
3.如果其他个方法都加了 synchronized 关键字，并且内部没有调用 wait，则不能。
4.如果其他方法是 static，它用的同步锁是当前类的字节码，与非静态的方法不能 同步，因为非静态的方法用的是 this。



58、线程的基本概念、线程的基本状态以及状态之间的关系



一个程序中可以有多条执行线索同时执行，一个线程就是程序中的一条执行线索，每个 线程上都关联有要执行的代码，即可以有多段程序代码同时运行，每个程序至少都有 一个线程，即 main 
方法执行的那个线程。如果只是一个 cpu，它怎么能够同时执行多 段程序呢？这是从宏观上来看的，cpu 一会执行 a 线索，一会执行 b 线索，切换时间 很快，给人的感觉是 a,b 
在同时执行，好比大家在同一个办公室上网，只有一条链接 到外部网线，其实，这条网线一会为 a 传数据，一会为 b 传数据，由于切换时间很短 暂，所以，大家感觉都在同时上网。

状态：就绪，运行，synchronize 阻塞，wait 和 sleep 挂起，结束。wait 必须在 synchronized
内部调用。
调用线程的 start 方法后线程进入就绪状态，线程调度系统将就绪状态的线程转为运行 状态，遇到 synchronized 语句时，由运行状态转为阻塞，当 synchronized 获得锁后， 
由阻塞转为运行，在这种情况可以调用 wait 方法转为挂起状态，当线程关联的代码执 行完后，线程变为结束状态。


71、简述 synchronized 和 java.util.concurrent.locks.Lock 的
异同 ？


主要相同点：Lock 能完成 synchronized 所实现的所有功能
主要不同点：Lock 有比 synchronized 更精确的线程语义和更好的性能。synchronized 会 自动释放锁，而 Lock 一定要求程序员手工释放，并且必须在 finally 
从句中释放。Lock 还有更强大的功能，例如，它的 tryLock 方法可以非阻塞方式去拿锁。 举例说明（对下面的题用 lock 进行了改写）：
package com.huawei.interview;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ThreadTest {
/**
* @param args
*/
private int j;
private Lock lock = new ReentrantLock();
public static void main(String[] args) {
// TODO Auto-generated method stub ThreadTest tt = new ThreadTest(); for(int i=0;i<2;i++)
{
new Thread(tt.new Adder()).start();
new Thread(tt.new Subtractor()).start();
}
}
private class Subtractor implements Runnable
{
@Override
public void run() {
// TODO Auto-generated method stub
while(true)
{
/*synchronized (ThreadTest.this) {
System.out.println("j--=" + j--);
//这里抛异常了，锁能释放吗？
}*/

lock.lock();
try
{
System.out.println("j--=" + j--);
}finally
{
lock.unlock();
}
}
}
}
private class Adder implements Runnable
{
@Override
public void run() {
// TODO Auto-generated method stub
while(true)
{
/*synchronized (ThreadTest.this) {
System.out.println("j++=" + j++);
}*/
lock.lock();
try
{
System.out.println("j++=" + j++);
}finally
{
lock.unlock();
}
}
}
}
}


28、设计 4 个线程，其中两个线程每次对 j 增加 1，另外两
个线程对 j 每次减少 1。写出程序。


以下程序使用内部类实现线程，对 j 增减的时候没有考虑顺序问题。
public class ThreadTest1
{
private int j;
public static void main(String args[]){ ThreadTest1 tt=new ThreadTest1(); Inc inc=tt.new Inc();
Dec dec=tt.new Dec();
for(int i=0;i<2;i++){
Thread t=new Thread(inc);
t.start();
t=new Thread(dec);
t.start();
}
}
private synchronized void inc()
j++;
System.out.println(Thread.currentThread().getName()+"-inc:"+j);
}
private synchronized void dec()
j--;
System.out.println(Thread.currentThread().getName()+"-dec:"+j);
}
class Inc implements Runnable{
public void run(){
for(int i=0;i<100;i++){
inc();
}
}
}

class Dec implements Runnable{
public void run(){
for(int i=0;i<100;i++){
dec();
}
}
}
}
----------随手再写的一个-------------
class
{
JManger j =new JManager();
main()
{
new A().call();
}
void call
{
for(int i=0;i<2;i++)
{
new Thread(
new Runnable(){ public void run(){while(true){j.accumulate()}}}
).start();
new Thread(new Runnable(){ public void run(){while(true){j.sub()}}}).start();
}
}
}
class JMa
{
private j = 0;


public synchronized void subtract()
{
j-
}
public synchronized void accumulate()
{

j++;
}
}







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
   System.out.println(sb1 + " " + s1);
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




### Abstract
public abstract class Shape {
private int x;
private int y;
public abstract void draw();
public void setAnchor(int x, int y) {
this.x = x;
this.y = y;
}
}
[/java]
Which two classes use the Shape class correctly? (Choose two.)
<ul>
A. public class Circle implements Shape {
private int radius;
}</ul>
<ul>
B. public abstract class Circle extends Shape {
private int radius;
}</ul>
<ul>
C. public class Circle extends Shape {
private int radius;
public void draw();
}</ul>
<ul>
D. public abstract class Circle implements Shape {
private int radius;
public void draw();
}</ul>
<ul>
E. public class Circle extends Shape {
private int radius;
public void draw() {/* code here */}
}</ul>
<ul>
F. public abstract class Circle implements Shape {
private int radius;
public void draw() {/* code here */}
}</ul>
Answer: BE
Explanation: To use an abstract class, you have to
	<li>use the keyword extends</li>
	<li>override the abstract method in abstract class. If you don't want to override the abstract methods, you  have to define your class as abstract</li>
<br/>

<strong>Q14: Interface</strong>
[java]
 interface TestA { String toString(); }

 public class Test {
 public static void main(String[] args) {
 System.out.println(new TestA() {
 public String toString() { return "test"; }
 });
 }
}
[/java]
What is the result?
<ul>A. test</ul>
<ul>B. null</ul>
<ul>C. An exception is thrown at runtime.</ul>
<ul>D. Compilation fails because of an error in line 1.</ul>
<ul>E. Compilation fails because of an error in line 5.</ul>
<ul>F. Compilation fails because of an error in line 6.</ul>
Answer: A
Explanation/Reference: You can never instantiate an interface in java. You can, however, refer to an object that implements an interface by the type of the interface. What you did above was create a Anonomous class that implements the interface. You are creating a Anonomous object, not an object of type interface Test.
<br/>

<strong>Q33: Inheritance / static</strong>
[java]
10. public class SuperCalc {
11. protected static int multiply(int a, int b) { return a * b;}
12. }
and:
20. public class SubCalc extends SuperCalc{
21. public static int multiply(int a, int b) {
22. int c = super.multiply(a, b);
23. return c;
24. }
25. }
and:
30. SubCalc sc = new SubCalc ();
31. System.out.println(sc.multiply(3,4));
32. System.out.println(SubCalc.multiply(2,2));
[/java]
What is the result?
<ul>A. 12</ul>
<ul>B. The code runs with no output.</ul>
<ul>C. An exception is thrown at runtime.</ul>
<ul>D. Compilation fails because of an error in line 21.</ul>
<ul>E. Compilation fails because of an error in line 22.</ul>
<ul>F. Compilation fails because of an error in line 31.</ul>
Answer: E
Explanation/Reference: Line 22: error- non-static variable cannot be referenced fro a static context.
<br/>

<strong>Q26: Abstract class</strong>
08. abstract public class Employee {
09. protected abstract double getSalesAmount();
10.
11. public double getCommision() {
12. return getSalesAmount() * 0.15;
13. }
14. }
15
16. class Sales extends Employee {
17. // insert method here
18. }
Which two methods, inserted independently at line 17, correctly complete the Sales class? (Choose two.)
A. double getSalesAmount() { return 1230.45; }
B. public double getSalesAmount() { return 1230.45; }
C. private double getSalesAmount() { return 1230.45; }
D. protected double getSalesAmount() { return 1230.45; }
Answer: BD
Explanation/Reference: First, an abstract method needs be overridden. Second, you can reduce the visibility of method when you override it.
<br/>


<strong>Q37: interface*************</strong>
[java]
11. public interface Status {
12. /* insert code here */ int MY_VALUE = 10;
13. }
[/java]
Which three are valid on line 12? (Choose three.)
A. final
B. static
C. native
D. public
E. private
F. abstract
G. protected
Answer: ABD
Explanation/Reference:
<br/>


<strong>Q60: interface*******************</strong>
[java]
interface DoStuff2 {
float getRange(int low, int high);
}
interface DoMore {
float getAvg(int a, int b, int c);
}
abstract class DoAbstract implements DoStuff2, DoMore {
}
06. class DoStuff implements DoStuff2 {
07. public float getRange(int x, int y) {
08. return 3.14f;
09. }
10. }
11.
12. interface DoAll extends DoMore {
13. float getAvg(int a, int b, int c, int d);
14. }
[/java]
What is the result?
A. The file will compile without error.
B. Compilation fails. Only line 7 contains an error.
C. Compilation fails. Only line 12 contains an error.
D. Compilation fails. Only line 13 contains an error.
E. Compilation fails. Only lines 7 and 12 contain errors.
F. Compilation fails. Only lines 7 and 13 contain errors.
G. Compilation fails. Lines 7, 12, and 13 contain errors.
Answer: A
Explanation/Reference: interface extend interface?


<strong>Q15: Abstract / Interface</strong>
[java]
interface Data { public void load(); }
abstract class Info { public abstract void load(); }
[/java]
Which class correctly uses the Data interface and Info class?
[java]
A. public class Employee extends Info implements Data {
public void load() { /*do something*/ }
}
B. public class Employee implements Info extends Data {
public void load() { /*do something*/ }
}
C. public class Employee extends Info implements Data {
public void load(){ /*do something*/ }
public void Info.load(){ /*do something*/ }
}
D. public class Employee implements Info extends Data {
public void Data.load(){ /*do something*/ }
public void load(){ /*do something*/ }
}
E. public class Employee implements Info extends Data {
public void load(){ /*do something*/ }
public void Info.load(){ /*do something*/ }
}
F. public class Employee extends Info implements Data{
public void Data.load() { /*do something*/ }
public void Info.load() { /*do something*/ }
}
[/java]
Answer: A
Explanation/Reference:
<br/>


<strong>Q20: abstrace / interface </strong>
[java]
public interface A { public void m1(); }
class B implements A { }
class C implements A { public void m1() { } }
class D implements A { public void m1(int x) { } }
abstract class E implements A { }
abstract class F implements A { public void m1() { } }
abstract class G implements A { public void m1(int x) { } }
[/java]
What is the result?
A. Compilation succeeds.
B. Exactly one class does NOT compile.
C. Exactly two classes do NOT compile.
D. Exactly four classes do NOT compile.
E. Exactly three classes do NOT compile.
Answer: C
Explanation/Reference:
[java]
error: B is not abstract and does not override abstract method m1() in A
error: D is not abstract and does not override abstract method m1() in A
[/java]
<br/>


### Inheritance
<strong>Q9: Inheritance</strong>
Which statement is true about the classes and interfaces in the exhibit?
[java]
public interface A {
public void doSomething(String thing);
 }
 public class AImpl implements A {
 public void doSomething(String msg) {}
 }
 public class B {
 public A doit(){
 //more code here
 }
 public String execute(){
 //more code here
 }
 }
 public class C extends B {
 public AImpl doit(){
 //more code here
 }

 public Object execute() {
 //more code here
 }
 }
[/java]
<ul>A. Compilation will succeed for all classes and interfaces.</ul>
<ul>B. Compilation of class C will fail because of an error in line 2.</ul>
<ul>C. Compilation of class C will fail because of an error in line 6.</ul>
<ul>D. Compilation of class AImpl will fail because of an error in line 2.</ul>
Answer: C
Explanation/Reference: The return type is incompatible with B.execute()
<br/>

<strong>Q10: Inheritance************</strong>
What is the result?
[java]
public class Person {
 String name = "No name";
 public Person(String nm) { name = nm; }
 }

 public class Employee extends Person {
 String empID = "0000";
 public Employee(String id) { empID = id; }
 }

 public class EmployeeTest {
 public static void main(String[] args){
 Employee e = new Employee("4321");
 System.out.println(e.empID);
 }
 }
[/java]
<ul>A. 4321</ul>
<ul>B. 0000</ul>
<ul>C. An exception is thrown at runtime.</ul>
<ul>D. Compilation fails because of an error in line 18.</ul>
Answer: D
Explanation/Reference: Implicit super constructor Person() is undefined. Must explicitly invoke another constructor
<br/>

<strong>Q13: Inheritance</strong>
[java]
class Atom {
Atom() { System.out.print("atom "); }
}
class Rock extends Atom {
Rock(String type) { System.out.print(type); }
}
public class Mountain extends Rock {
Mountain() {
super("granite ");
new Rock("granite ");
}
public static void main(String[] a) { new Mountain(); }
}
[/java]
What is the result?
<ul>A. Compilation fails.</ul>
<ul>B. atom granite</ul>
<ul>C. granite granite</ul>
<ul>D. atom granite granite</ul>
<ul>E. An exception is thrown at runtime.</ul>
<ul>F. atom granite atom granite</ul>
Answer: F
Explanation/Reference:
<br/>

<strong>Q16: Inheritance</strong>
[java]
 public class Blip {
 protected int blipvert(int x) { return 0; }
 }
 class Vert extends Blip {
 // insert code here
 }
[/java]
Which five methods, inserted independently at line 5, will compile? (Choose five.)
<ul>A. public int blipvert(int x) { return 0; }</ul>
<ul>B. private int blipvert(int x) { return 0; }</ul>
<ul>C. private int blipvert(long x) { return 0; }</ul>
<ul>D. protected long blipvert(int x) { return 0; }</ul>
<ul>E. protected int blipvert(long x) { return 0; }</ul>
<ul>F. protected long blipvert(long x) { return 0; }</ul>
<ul>G. protected long blipvert(int x, int y) { return 0; }</ul>
Answer: ACEFG
Explanation/Reference: private->default->protected->public
	<li>A. public int blipvert(int x) { return 0; }, you can override the method with public or protected. In this case, it won't reduce the visibility of the inherited method from Blip </li>
	<li>B. private int blipvert(int x) { return 0; } - Cannot reduce the visibility of the inherited method from Blip</li>
	<li>C. private int blipvert(long x) { return 0; }, you create a new overload method, the argument is different.</li>
	<li>D. protected long blipvert(int x) { return 0; }, the argument is same with inherited method, so it is overridding. The return type is incompatible with Blip.blipvert(int), you should define the override method with same argument and return type.</li>
	<li>E. protected int blipvert(long x) { return 0; }, you create a new overload method (with different argument).</li>
	<li>F. protected long blipvert(long x) { return 0; }, see E</li>
	<li>G. protected long blipvert(int x, int y) { return 0; }, see E</li>
Note: for overload method, you must have different argument. It is invalid if the methods only have different return type but same argument.
<br/>


<strong>Q17: Inheritance</strong>
[java]
 class Super {
 private int a;
 protected Super(int a) { this.a = a; }
 }
 class Sub extends Super {
 public Sub(int a) { super(a); }
 public Sub() { this.a = 5; }
 }
[/java]
Which two, independently, will allow Sub to compile? (Choose two.)
<ul>
A. Change line 2 to:
public int a;</ul>

<ul>
B. Change line 2 to:
protected int a;</ul>

<ul>
C. Change line 13 to:
public Sub() { this(5); }</ul>

<ul>
D. Change line 13 to:
public Sub() { super(5); }</ul>

<ul>
E. Change line 13 to:
public Sub() { super(a); }</ul>
Answer: CD
Explanation/Reference: When constructor sub() is created, the super() must be invoked first. Because the super() constructor does not exist, we may invoke another super(a) constructor.
<br/>

<strong>Q18: Inheritance</strong>
Which Man class properly represents the relationship "Man has a best friend who is a Dog"?
<ul>A. class Man extends Dog { }</ul>
<ul>B. class Man implements Dog { }</ul>
<ul>C. class Man { private BestFriend dog; }</ul>
<ul>D. class Man { private Dog bestFriend; }</ul>
<ul>E. class Man { private Dog<bestFriend>; }</ul>
<ul>F. class Man { private BestFriend<dog>; }</ul>
Answer: D
Explanation/Reference:
<br/>

<strong>Q20: Inheritance</strong>
[java]
 abstract class Vehicle { public int speed() { return 0; }
 class Car extends Vehicle { public int speed() { return 60; }
 class RaceCar extends Car { public int speed() { return 150; } ...
 RaceCar racer = new RaceCar();
 Car car = new RaceCar();
 Vehicle vehicle = new RaceCar();
 System.out.println(racer.speed() + ", " + car.speed() + ", " + vehicle.speed());
[/java]
What is the result?
<ul>A. 0, 0, 0</ul>
<ul>B. 150, 60, 0</ul>
<ul>C. Compilation fails.</ul>
<ul>D. 150, 150, 150</ul>
<ul>E. An exception is thrown at runtime.</ul>
Answer: D
Explanation/Reference: Polymorphism, attached with overriding method.
<br/>

<strong>Q21: Inheritance</strong>
[java]
05. class Building { }
06. public class Barn extends Building {
07. public static void main(String[] args) {
08. Building build1 = new Building();
09. Barn barn1 = new Barn();
10. Barn barn2 = (Barn) build1;
11. Object obj1 = (Object) build1;
12. String str1 = (String) build1;
13. Building build2 = (Building) barn1;
14. }
15. }
[/java]
Which is true?
<ul>A. If line 10 is removed, the compilation succeeds.</ul>
<ul>B. If line 11 is removed, the compilation succeeds.</ul>
<ul>C. If line 12 is removed, the compilation succeeds.</ul>
<ul>D. If line 13 is removed, the compilation succeeds.</ul>
<ul>E. More than one line must be removed for compilation to succeed.</ul>
Answer: C
Explanation/Reference: Cannot cast from Building to String
<br/>


<strong>Q22: OO******************* </strong>
A team of programmers is reviewing a proposed API for a new utility class. After some discussion, they realize that they can reduce the number of methods in the API without losing any functionality. If they implement the new design, which two OO principles will they be promoting?
<ul>A. Looser coupling</ul>
<ul>B. Tighter coupling</ul>
<ul>C. Lower cohesion</ul>
<ul>D. Higher cohesion</ul>
<ul>E. Weaker encapsulation</ul>
<ul>F. Stronger encapsulation</ul>
Answer: AD
Explanation/Reference:
<br/>

<strong>Q23: Inheritance</strong>
[java]
21. class Money {
22. private String country = "Canada";
23. public String getC() { return country; }
24. }
25. class Yen extends Money {
26. public String getC() { return super.country; }
27. }
28. public class Euro extends Money {
29. public String getC(int x) { return super.getC(); }
30. public static void main(String[] args) {
31. System.out.print(new Yen().getC() + " " + new Euro().getC());
32. }
33. }
[/java]
What is the result?
<ul>A. Canada</ul>
<ul>B. null Canada</ul>
<ul>C. Canada null</ul>
<ul>D. Canada Canada</ul>
<ul>E. Compilation fails due to an error on line 26.</ul>
<ul>F. Compilation fails due to an error on line 29.</ul>
Answer: E
Explanation/Reference: country has private access in Money --line 26:public String getC() {return super.country; } . In line 22, if we change private to default, protected, or public, the output will be Canada Canada.
<br/>

<strong>Q32: OO****************</strong>
A company has a business application that provides its users with many different reports: receivables reports, payables reports, revenue projects, and so on. The company has just purchased some new, state of-the-art, wireless printers, and a programmer has been assigned the task of enhancing all of the reports to use not only the company's old printers, but the new wireless printers as well. When the programmer starts looking into the application, the programmer discovers that because of the design of the application, it is necessary to make changes to each report to support the new printers. Which two design concepts most likely explain this situation? (Choose two.)
<ul>A. Inheritance</ul>
<ul>B. Low cohesion</ul>
<ul>C. Tight coupling</ul>
<ul>D. High cohesion</ul>
<ul>E. Loose coupling</ul>
<ul>F. Object immutability</ul>
Answer: BC
Explanation/Reference:
<br/>

<strong>Q34: Inheritance *********************</strong>
[java]
class Foo {
public int a = 3;
public void addFive() { a += 5; System.out.print("f "); }
}
class Bar extends Foo {
public int a = 8;
public void addFive() { this.a += 5; System.out.print("b " ); }
}
Invoked with:
Foo f = new Bar();
f.addFive();
System.out.println(f.a);
[/java]
What is the result?
<ul>A. b 3</ul>
<ul>B. b 8</ul>
<ul>C. b 13</ul>
<ul>D. f 3</ul>
<ul>E. f 8</ul>
<ul>F. f 13</ul>
<ul>G. Compilation fails.</ul>
<ul>H. An exception is thrown at runtime.</ul>
Answer: A
Explanation/Reference: Polymorphism, use subclass overriding method, but superclass field.
<br/>

<strong>Q39: Inheritance</strong>
[java]
10. interface Foo {}
11. class Alpha implements Foo {}
12. class Beta extends Alpha {}
13. class Delta extends Beta {
14. public static void main( String[] args ) {
15. Beta x = new Beta();
16. //insert code here
17. }
18. }
[/java]
Which code, inserted at line 16, will cause a java.lang.ClassCastException?
<ul>A. Alpha a = x;</ul>
<ul>B. Foo f = (Delta)x;</ul>
<ul>C. Foo f = (Alpha)x;</ul>
<ul>D. Beta b = (Beta)(Alpha)x;</ul>
Answer: B
Explanation/Reference: x is an object of Beta. Delta is the sub class and you can cast an object to small visibility.
<br/>

<strong>Q51: Inheritance / ClassCastException</strong>
[java]
23. Object [] myObjects = {
24. new Integer(12),
25. new String("foo"),
26. new Integer(5),
27. new Boolean(true)
28. };
29. Arrays.sort(myObjects);
30. for(int i=0; i<myObjects.length; i++) {
31. System.out.print(myObjects[i].toString());
32. System.out.print(" ");
33. }
[/java]
What is the result?
<ul>A. Compilation fails due to an error in line 23.</ul>
<ul>B. Compilation fails due to an error in line 29.</ul>
<ul>C. A ClassCastException occurs in line 29.</ul>
<ul>D. A ClassCastException occurs in line 31.</ul>
<ul>E. The value of all four objects prints in natural order.</ul>
Answer: C
Explanation/Reference:
Exception in thread "main" java.lang.ClassCastException: java.lang.String
cannot be cast to java.lang.Integer
at java.lang.Integer.compareTo(Unknown Source)
at java.util.Arrays.mergeSort(Unknown Source)
at java.util.Arrays.sort(Unknown Source)
at Barn.main(Barn.java:29)
<br/>

<strong>Q5: Inheritance</strong>
[java]
class ClassA {
public int numberOfInstances;
protected ClassA(int numberOfInstances) {
this.numberOfInstances = numberOfInstances;
}
}
public class ExtendedA extends ClassA {
private ExtendedA(int numberOfInstances) {
super(numberOfInstances);
}
public static void main(String[] args) {
ExtendedA ext = new ExtendedA(420);
System.out.print(ext.numberOfInstances);
}
}
[/java]
Which statement is true?
A. 420 is the output.
B. An exception is thrown at runtime.
C. All constructors must be declared public.
D. Constructors CANNOT use the private modifier.
E. Constructors CANNOT use the protected modifier.
Answer: A
Explanation/Reference:
<br/>

<strong>Q10: Inheritance</strong>
[java]
11. //insert code here
12. private N min, max;
13. public N getMin() { return min; }
14. public N getMax() { return max; }
15. public void add(N added) {
16. if (min == null || added.doubleValue() < min.doubleValue())
17. min = added;
18. if (max == null || added.doubleValue() > max.doubleValue())
19 max = added;
20.}
21.}
[/java]
Which two, inserted at line 11, will allow the code to compile? (Choose two.)
A. public class MinMax<?> {
B. public class MinMax<? extends Number> {
C. public class MinMax<N extends Object> {
D. public class MinMax<N extends Number> {
E. public class MinMax<? extends Object> {
F. public class MinMax<N extends Integer> {
Answer: DF
Explanation/Reference:
<br/>

<strong>Q25: Inheritance</strong>
[java]
09. class One {
10. void foo() { }
11. }
12.
13. class Two extends One {
14. //insert method here
15. }
[/java]
Which three methods, inserted individually at line 14, will correctly complete class Two? (Choose three.)
A. int foo() { /* more code here */ }
B. void foo() { /* more code here */ }
C. public void foo() { /* more code here */ }
D. private void foo() { /* more code here */ }
E. protected void foo() { /* more code here */ }
Answer: BCE
Explanation/Reference: overloading and overriding
<br/>

<strong>Q27: Inheritance</strong>
[java]
1. class X {
2. X() { System.out.print(1); }
3.
4. X(int x) {
5. this(); System.out.print(2);
6. }
7. }
8.
9. public class Y extends X {
10. Y() { super(6); System.out.print(3); }
11.
12. Y(int y) {
13. this(); System.out.println(4);
14. }
15.
16. public static void main(String[] a) { new Y(5); }
17.}
[/java]
What is the result?
A. 13
B. 134
C. 1234
D. 2134
E. 2143
F. 4321
Answer: C
Explanation/Reference:
<br/>

<strong>Q29: overloading</strong>
[java]
1. public class A {
2. public void doit() {
3. }
4.
5. public String doit() {
6. return "a";
7. }
8.
9. public double doit(int x) {
10. return 1.0;
11. }
12.}
[/java]
What is the result?
A. An exception is thrown at runtime.
B. Compilation fails because of an error in line 9.
C. Compilation fails because of an error in line 5.
D. Compilation succeeds and no runtime errors with class A occur.
Answer: C
Explanation/Reference: overloading, you must have different arguments. It is invalid if only the return types are different.
<br/>


<strong>Q32: Inheritance</strong>
[java]
public class ClassA {
public void methodA() {
ClassB classB = new ClassB();
classB.getValue();
}
}
class ClassB {
public ClassC classC;
public String getValue() {
return classC.getValue();
}
}
class ClassC {
public String value;
public String getValue() {
value = "ClassB";
return value;
}
}
and:
ClassA a = new ClassA();
a.methodA();
[/java]
What is the result?
A. Compilation fails.
B. ClassC is displayed.
C. The code runs with no output.
D. An exception is thrown at runtime.
Answer: D
Explanation/Reference: Exception in thread "main" java.lang.NullPointerException
at ClassB.getValue() (ClassA.java: 14)
at ClassA.methodA (ClassA.java: 4)
at ClassA.main (ClassA.java: 8)
This means objects are not instaniated.
<br/>

<strong>Q33: interface***************</strong>
[java]
09. interface Foo { int bar(); }
10.
11. public class Sprite {
12. public int fubar( Foo foo ) { return foo.bar(); }
13. public void testFoo() {
14. fubar(
15. //insert code here 15
16. );
17. }
18. }
[/java]
Which code, inserted at line 15, allows the class Sprite to compile?
A. Foo { public int bar() { return 1; }
B. new Foo { public int bar() { return 1; }
C. new Foo() { public int bar() { return 1; }
D. new class Foo { public int bar() { return 1; }
Answer: C
Explanation/Reference:
<br/>

strong>Q36: Inheritance</strong>
[java]
09. class Line {
10. public static class Point {}
11. }
12.
13. class Triangle {
14. public Triangle(){
15. // insert code here
16. }
17. }
[/java]
Which code, inserted at line 15, creates an instance of the Point class defined in Line?
A. Point p = new Point();
B. Line.Point p = new Line.Point();
C. The Point class cannot be instatiated at line 15.
D. Line l = new Line();
l.Point p = new l.Point();
Answer: B
Explanation/Reference:
<br/>

<strong>Q38: Inheritance</strong>
[java]
public class A{
private int counter = 0;
public static int getInstanceCount() {
return counter;
}
public A() {
counter++;
}
}
Given this code from Class B:
25. A a1 = new A();
26. A a2 = new A();
27. A a3 = new A();
28. System.out.println(A.getInstanceCount());
[/java]
What is the result?
A. Compilation of class A fails.
B. Line 28 prints the value 3 to System.out.
C. Line 28 prints the value 1 to System.out.
D. A runtime error occurs when line 25 executes.
E. Compilation fails because of an error on line 28.
Answer: A
Explanation/Reference: error: Non-static variable counter cannot be referenced from a static context
<br/>


<strong>Q40: Inheritance</strong>
Which three code fragments, added individually at line 29, produce the output 100? (Choose three.)
[java]
10. class Inner {
11. private int x;
12. public void setX( int x ){ this.x = x; }
13. public int getX(){ return x;}
14. }
15.
16. class Outer {
17. private Inner y;
18. public void setY( Inner y ){ this.y = y; }
19. public Inner getY() { return y; }
20. }
21.
22. public class Gamma {
23. public static void main(String[] args) {
24. Outer o = new Outer();
25. Inner i = new Inner();
26. int n = 10;
27. i.setX(n);
28. o.setY(i);
29. // insert code here
30. System.out.println(o.getY().getX());
31. }
32.}
[/java]
A. n = 100;
B. i.setX( 100 );
C. o.getY().setX( 100 );
D. i = new Inner();
i.setX( 100 );
E. o.setY( i );
i = new Inner();
i.setX( 100 );
F. i = new Inner();
i.setX( 100 );
o.setY( i );
Answer: BCF
Explanation/Reference:
<br/>

<strong>Q42: Inheritance</strong>
[java]
04. class Payload {
05. private int weight;
06. public Payload (int w) { weight = w; }
07. public void setWeight(int w) { weight = w; }
08. public String toString() { return Integer.toString(weight); }
09. }
10.
11. public class TestPayload {
12. static void changePayload(Payload p) { /* insert code */ }
13. public static void main(String[] args) {
14. Payload p = new Payload(200);
15. p.setWeight(1024);
16. changePayload(p);
17. System.out.println("p is " + p);
18. }
19. }
[/java]
Which code fragment, inserted at the end of line 12, produces the output p is 420?
A. p.setWeight(420);
B. p.changePayload(420);
C. p = new Payload(420);
D. Payload.setWeight(420);
E. p = Payload.setWeight(420);
Answer: A
Explanation/Reference:
<br/>

<strong>Q45: Inheritance</strong>
[java]
public class Pass2 {
public void main(String [] args) {
int x = 6;
Pass2 p = new Pass2();
p.doStuff(x);
System.out.print(" main x = " + x);
}
void doStuff(int x) {
System.out.print(" doStuff x = " + x++);
}
}
And the command-line invocations:
javac Pass2.java
java Pass2 5
[/java]
What is the result?
A. Compilation fails.
B. An exception is thrown at runtime.
C. doStuff x = 6 main x = 6
D. doStuff x = 6 main x = 7
E. doStuff x = 7 main x = 6
F. doStuff x = 7 main x = 7
Answer: B
Explanation/Reference: Missing static in main method signature.
<br/>

<strong>Q52: Inheritance</strong>
[java]
11. static class A {
12. void process() throws Exception { throw new Exception(); }
13. }
14. static class B extends A {
15. void process() { System.out.println("B"); }
16. }
17. public static void main(String[] args) {
18. new B().process();
19. }
[/java]
What is the result?
A. B
B. The code runs with no output.
C. Compilation fails because of an error in line 12.
D. Compilation fails because of an error in line 15.
E. Compilation fails because of an error in line 18.
Answer: A
Explanation/Reference:
<br/>

<strong>Q6: interface / inheritance *******</strong>
[java]
01. interface A { public void aMethod(); }
02. interface B { public void bMethod(); }
03. interface C extends A,B { public void cMethod(); }
04. class D implements B {
05. public void bMethod(){}
06. }
07. class E extends D implements C {
08. public void aMethod(){}
09. public void bMethod(){}
10. public void cMethod(){}
11. }
[/java]
What is the result?
A. Compilation fails because of an error in line 3.
B. Compilation fails because of an error in line 7.
C. Compilation fails because of an error in line 9.
D. If you define D e = new E(), then e.bMethod() invokes the version of bMethod() defined in Line 5.
E. If you define D e = (D)(new E()), then e.bMethod() invokes the version of bMethod() defined in Line 5.
F. If you define D e = (D)(new E()), then e.bMethod() invokes the version of bMethod() defined in Line 9.
Answer: F
Explanation/Reference:
<br/>

<strong>Q7: Inheritance </strong>
[java]
public class SimpleCalc {
public int value;
public void calculate() { value += 7; }
}
and:
}
and:
public class MultiCalc extends SimpleCalc {
public void calculate() { value -= 3; }
public void calculate(int multiplier) {
calculate();
super.calculate();
value *= multiplier;
}
public statuc void main(String[] args) {
MultiCalc calculator = new MultiCalc();
calculator.calculate(2);
System.out.println("Value is: " + calculator.value);
}
}
[/java]
What is the result?
A. Value is: 8
B. Compilation fails.
C. Value is: 12
D. Value is: -12
E. The code runs with no output.
F. An exception is thrown at runtime.
Answer: A
Explanation/Reference: 
<br/>


<strong>Q8: Inheritance / generic ***************</strong>
[java]
public class Base {
public static final String FOO = "foo";
public static void main(String[] args) {
Base b = new Base();
Sub s = new Sub();
System.out.print(Base.FOO);
System.out.print(Sub.FOO);
System.out.print(b.FOO);
System.out.print(s.FOO);
System.out.print(((Base) s).FOO);
}
}
class Sub extends Base {
public static final String FOO = "bar";
}
[/java]
What is the result?
A. foofoofoofoofoo
B. foobarfoobarbar
C. foobarfoofoofoo
D. foobarfoobarfoo
E. barbarbarbarbar
F. foofoofoobarbar
G. foofoofoobarfoo
Answer: D
Explanation/Reference:
<br/>


<strong>Q9: Inheritance</strong>
[java]
class Mammal {
}
class Raccoon extends Mammal {
Mammal m = new Mammal();
}
class BabyRaccoon extends Mammal {
}
[/java]
Which four statements are true? (Choose four.)
A. Raccoon is-a Mammal.
B. Raccoon has-a Mammal.
C. BabyRaccoon is-a Mammal.
D. BabyRaccoon is-a Raccoon.
E. BabyRaccoon has-a Mammal.
F. BabyRaccoon is-a BabyRaccoon.
Answer: ABCF
Explanation/Reference: F?
<br/>


<strong>Q11: Inheritance</strong>
[java]
01. public class Hi {
02. void m1() { }
03. protected void() m2 { }
04. }
05.
06. class Lois extends Hi {
07. // insert code here
08. }
[/java]
Which four code fragments, inserted independently at line 7, will compile? (Choose four.)
A. public void m1() { }
B. protected void m1() { }
C. private void m1() { }
D. void m2() { }
E. public void m2() { }
F. protected void m2() { }
G. private void m2() { }
Answer: ABEF
Explanation/Reference:
<br/>


<strong>Q12: Inheritance</strong>
Which four statements are true? (Choose four.)
A. Has-a relationships should never be encapsulated.
B. Has-a relationships should be implemented using inheritance.
C. Has-a relationships can be implemented using instance variables.
D. Is-a relationships can be implemented using the extends keyword.
E. Is-a relationships can be implemented using the implements keyword.
F. The relationship between Movie and Actress is an example of an is-a relationship.
G. An array or a collection can be used to implement a one-to-many has-a relationship.
Answer: CDEG
Explanation/Reference:
<br/>


<strong>Q13: Inheritance</strong>
[java]
public class Hello {
String title;
int value;
public Hello() {
title += " World";
}
public Hello(int value) {
this.value = value;
title = "Hello";
Hello();
}
}
and:
Hello c = new Hello(5);
System.out.println(c.title);
[/java]
What is the result?
A. Hello
B. Hello World
C. Compilation fails.
D. Hello World 5
E. The code runs with no output.
F. An exception is thrown at runtime.
Answer: C
Explanation/Reference: The method Hello() is undefined for type Hello. If you want this code to compile there should be new Hello();
<br/>


<strong>Q16: Collection</strong>
[java]
class Alligator {
public static void main(String[] args) {
int[] x[] = { { 1, 2 }, { 3, 4, 5 }, { 6, 7, 8, 9 } };
int[][] y = x;
System.out.println(y[2][1]);
}
}
[/java]
What is the result?
A. 2
B. 3
C. 4
D. 6
E. 7
F. Compilation fails.
Answer: E
Explanation/Reference:
<br/>

<strong>Q17: Inheritance</strong>
[java]
abstract class C1 {
public C1() { System.out.print(1); }
}
class C2 extends C1 {
public C2() { System.out.print(2); }
}
class C3 extends C2 {
public C3() { System.out.println(3); }
}
public class Ctest {
public static void main(String[] a) { new C3(); }
}
[/java]
What is the result?
A. 3
B. 23
C. 32
D. 123
E. 321
F. Compilation fails.
G. An exception is thrown at runtime.
Answer: D
Explanation/Reference:
<br/>


<strong>Q18: override / overload </strong>
class One {
public One foo() {
return this;
}
}
class Two extends One {
public One foo() {
return this;
}
}
class Three extends Two {
// insert method here
}
Which two methods, inserted individually, correctly complete the Three class? (Choose two.)
A. public void foo() {}
B. public int foo() { return 3; }
C. public Two foo() { return this; }
D. public One foo() { return this; }
E. public Object foo() { return this; }
Answer: CD
Explanation/Reference:
<br/>


<strong>Q21: Inheritance / inner class</strong>
[java]
class Line {
public class Point {
public int x, y;
}
public Point getPoint() {
return new Point();
}
}
class Triangle {
public Triangle() {
// insert code here
}
}
[/java]
Which code, inserted at line 16, correctly retrieves a local instance of a Point object?
A. Point p = Line.getPoint();
B. Line.Point p = Line.getPoint();
C. Point p = (new Line()).getPoint();
D. Line.Point p = (new Line()).getPoint();
Answer: D
Explanation/Reference:
<br/>


<strong>Q22: inheritance</strong>
[java]
class TestA {
public void start() { System.out.println("TestA"); }
}
public class TestB extends TestA {
public void start() { System.out.println("TestB"); }
public static void main(String[] args) {
((TestA)new TestB()).start();
}
}
[/java]
What is the result?
A. TestA
B. TestB
C. Compilation fails.
D. An exception is thrown at runtime.
Answer: B
Explanation/Reference:
<br/>


<strong>Q34: Inheritance / Generic</strong>
A programmer must create a generic class MinMax and the type parameter of MinMax must implement Comparable. Which implementation of MinMax will compile?
[java]
A. class MinMax<E extends Comparable<E>> {
E min = null;
E max = null;
public MinMax() {}
public void put(E value) { /* store min or max */ }
}
B. class MinMax<E implements Comparable<E>> {
E min = null;
E max = null;
public MinMax() {}
public void put(E value) { /* store min or max */ }
}
C. class MinMax<E extends Comparable<E>> {
<E> E min = null;
<E> E max = null;
public MinMax() {}
public <E> void put(E value) { /* store min or max */ }
}
D. class MinMax<E implements Comparable<E>> {
<E> E min = null;
<E> E max = null;
public MinMax() {}
public <E> void put(E value) { /* store min or max */ }
}
[/java]
Answer: A
Explanation/Reference:
<br/>

<strong>Q36: Inheritance</strong>
[java]
05. class A {
06. void foo() throws Exception { throw new Exception(); }
07. }
08. class SubB2 extends A {
09. void foo() { System.out.println("B "); }
10. }
11. class Tester {
12. public static void main(String[] args) {
13. A a = new SubB2();
14. a.foo();
15. }
16. }
[/java]
What is the result?
A. B
B. B, followed by an Exception.
C. Compilation fails due to an error on line 9.
D. Compilation fails due to an error on line 14.
E. An Exception is thrown with no other output.
Answer: D
Explanation/Reference: line 14- error: Unreported exception type Exception. Must be caught or declared to be thrown.

Need try / catch
<br/>

<strong>Q43: inheritance</strong>
[java]
11. public void testIfA() {
12. if (testIfB("True")) {
13. System.out.println("True");
14. } else {
15. System.out.println("Not true");
16. }
17. }
18. public Boolean testIfB(String str) {
19. return Boolean.valueOf(str);
20. }
[/java]
20. }
What is the result when method testIfA is invoked?
A. True
B. Not true
C. An exception is thrown at runtime.
D. Compilation fails because of an error at line 12.
E. Compilation fails because of an error at line 19.
Answer: A
Explanation/Reference:
<br/>

<strong>Q48: Inheritance</strong>
[java]
public class ItemTest {
private final int id;
public ItemTest(int id) {
this.id = id;
}
public void updateId(int newId) {
id = newId;
}
public static void main(String[] args) {
ItemTest fa = new ItemTest(42);
fa.updateId(69);
System.out.println(fa.id);
}
}
[/java]
What is the result?
A. Compilation fails.
B. An exception is thrown at runtime.
C. The attribute id in the ItemTest object remains unchanged.
D. The attribute id in the ItemTest object is modified to the new value.
E. A new ItemTest object is created with the preferred value in the id attribute.
Answer: A
Explanation/Reference: The final field ItemTest.id cannot be assigned
<br/>

<strong>Q50: Inheritance</strong>
Click the Exhibit button.
[java]
class Foo {
private int x;
public Foo( int x ){ this.x = x;}
public void setX( int x ) { this.x = x; }
public int getX(){ return x;}
}
public class Gamma {
static Foo fooBar(Foo foo) {
foo = new Foo(100);
return foo;
}
public static void main(String[] args) {
Foo foo = new Foo( 300 );
System.out.println( foo.getX() + "-");
Foo fooFoo = fooBar(foo);
System.out.println(foo.getX() + "-");
System.out.println(fooFoo.getX() + "-");
foo = fooBar( fooFoo);
System.out.println( foo.getX() + "-");
System.out.println(fooFoo.getX());
}
}
[/java]
What is the output of the program shown in the exhibit?
A. 300-100-100-100-100
B. 300-300-100-100-100
C. 300-300-300-100-100
D. 300-300-300-300-100
Answer: B
Explanation/Reference:
<br/>

<strong>Q51: Generic / inheritance</strong>
Given classes defined in two different files:
[java]
package packageA;
public class Message {
String getText() {
return "text";
}
}
And:
package packageB;
public class XMLMessage extends packageA.Message {
String getText() {
return "<msg>text</msg>";
}
public static void main(String[] args) {
System.out.println(new XMLMessage().getText());
}
}
[/java]
What is the result of executing XMLMessage.main?
A. text
B. Compilation fails.
C. <msg>text</msg>
D. An exception is thrown at runtime.
Answer: C
Explanation/Reference:
<br/>

<strong>Q52: </strong>
[java]
interface Fish {
}
class Perch implements Fish {
}
class Walleye extends Perch {
}
class Bluegill {
}
public class Fisherman {
public static void main(String[] args) {
Fish f = new Walleye();
Walleye w = new Walleye();
Bluegill b = new Bluegill();
if (f instanceof Perch)
System.out.print("f-p ");
if (w instanceof Fish)
System.out.print("w-f ");
if (b instanceof Fish)
System.out.print("b-f ");
}
}
[/java]
What is the result?
A. w-f
B. f-p w-f
C. w-f b-f
D. f-p w-f b-f
E. Compilation fails.
F. An exception is thrown at runtime.
Answer: B
Explanation/Reference:
<br/>



<strong>Q54: Inheritance / static</strong>
[java]
class Foo {
static void alpha() {
/* more code here */
}
void beta() {
/* more code here */
}
}
[/java]
Which two statements are true? (Choose two.)
A. Foo.beta() is a valid invocation of beta().
B. Foo.alpha() is a valid invocation of alpha().
C. Method beta() can directly call method alpha().
D. Method alpha() can directly call method beta().
Answer: BC
Explanation/Reference:
<br/>


<strong>Q55: Inheritance</strong>
[java]
public class TestSeven extends Thread {
private static int x;
public synchronized void doThings() {
int current = x;
current++;
x = current;
}
public void run() {
doThings();
}
}
[/java]
Which statement is true?
A. Compilation fails.
B. An exception is thrown at runtime.
C. Synchronizing the run() method would make the class thread-safe.
D. The data in variable "x" are protected from concurrent access problems.
E. Declaring the doThings() method as static would make the class thread-safe.
F. Wrapping the statements within doThings() in a synchronized(new Object()) { } block would make the class thread-safe.
Answer: E
Explanation/Reference: instance variable and class variable(static) default value is 0, null.
<br/>

###Collection
<strong>Q31: collection / coparable****************</strong>
[java]
public class Score implements Comparable<Score> {
private int wins, losses;
public Score(int w, int l) { wins = w; losses = l; }
public int getWins() { return wins; }
public int getLosses() { return losses; }
public String toString() {
return "<" + wins + "," + losses + ">";
}
// insert code here
}
[/java]
Which method will complete this class?
<ul>A. public int compareTo(Object o){/*more code here*/}</ul>
<ul>B. public int compareTo(Score other){/*more code here*/}</ul>
<ul>C. public int compare(Score s1,Score s2){/*more code here*/}</ul>
<ul>D. public int compare(Object o1,Object o2){/*more code here*/}</ul>
Answer: B
Explanation/Reference:
<br/>

<strong>Q9: String / HashSet*****************</strong>
[java]
import java.util.*;
public class WrappedString {
private String s;
public WrappedString(String s) { this.s = s; }
public static void main(String[] args) {
HashSet<Object> hs = new HashSet<Object>();
WrappedString ws1 = new WrappedString("aardvark");
WrappedString ws2 = new WrappedString("aardvark");
String s1 = new String("aardvark");
String s2 = new String("aardvark");
hs.add(ws1); hs.add(ws2); hs.add(s1); hs.add(s2);
System.out.println(hs.size()); }
}
[/java]
What is the result?
A. 0
B. 1
C. 2
D. 3
E. 4
F. Compilation fails.
G. An exception is thrown at runtime.
Answer: D
Explanation/Reference: HashSet does not store duplicates.  ws1 and ws2 are two different objects. s1.hashCode() == s2.hashCode(), and s1.equals(s2)==true. So s1 and s2 are duplicates.
<br/>

<strong>Q11: String / List Collection****************</strong>
[java]
3. import java.util.*;
4. public class G1 {
5. public void takeList(List<? extends String> list) {
6. // insert code here
7. }
8. }
[/java]
Which three code fragments, inserted independently at line 6, will compile? (Choose three.)
A. list.add("foo");
B. Object o = list;
C. String s = list.get(0);
D. list = new ArrayList<String>();
E. list = new ArrayList<Object>();
Answer: BCD
Explanation/Reference: A: List is an interface that cannot run method directly.
<br/>

<strong>Q12: PriorityQueue / collection*************************</strong>
Given that the elements of a PriorityQueue are ordered according to natural ordering, and:
[java]
import java.util.*;
public class GetInLine {
public static void main(String[] args) {
PriorityQueue<String> pq = new PriorityQueue<String>();
pq.add("banana");
pq.add("pear");
pq.add("apple");
System.out.println(pq.poll() + " " + pq.peek());
}
}
[/java]
What is the result?
A. apple pear
B. banana pear
C. apple apple
D. apple banana
E. banana banana
Answer: D
Explanation/Reference:
<br/>

<strong>Q14: HashSet / Collection</strong>
[java]
import java.util.*;
public class Mapit {
public static void main(String[] args) {
Set<Integer> set = new HashSet<Integer>();
Integer i1 = 45;
Integer i2 = 46;
set.add(i1);
set.add(i1);
set.add(i2); System.out.print(set.size() + " ");
set.remove(i1); System.out.print(set.size() + " ");
i2 = 47;
set.remove(i2); System.out.print(set.size() + " ");
}
}
[/java]
What is the result?
A. 2 1 0
B. 2 1 1
C. 3 2 1
D. 3 2 2
E. Compilation fails.
F. An exception is thrown at runtime.
Answer: B
Explanation/Reference: the statement set.remove(i2) means set.remove(47), it does not remove anything. Because there is no 47 in HashSet. 
<br/>

<strong>Q15: TreeSet / Collection</strong>
[java]
import java.util.*;
public class Explorer1 {
public static void main(String[] args) {
TreeSet<Integer> s = new TreeSet<Integer>();
TreeSet<Integer> subs = new TreeSet<Integer>();
for(int i = 606; i < 613; i++)
if(i%2 == 0) s.add(i);
subs = (TreeSet)s.subSet(608, true, 611, true);
s.add(609);
System.out.println(s + " " + subs);
}
}
[/java]
What is the result?
A. Compilation fails.
B. An exception is thrown at runtime.
C. [608, 609, 610, 612] [608, 610]
D. [608, 609, 610, 612] [608, 609, 610]
E. [606, 608, 609, 610, 612] [608, 610]
F. [606, 608, 609, 610, 612] [608, 609, 610]
Answer: F
Explanation/Reference: TreeSet is synchronized.
<br/>

<strong>Q16: binarySearch / Collection </strong>
[java]
import java.util.*;
public class Quest {
public static void main(String[] args) {
String[] colors = {"blue", "red", "green", "yellow", "orange"};
Arrays.sort(colors);
int s2 = Arrays.binarySearch(colors, "orange");
int s3 = Arrays.binarySearch(colors, "violet");
System.out.println(s2 + " " + s3);
}
}
[/java]
What is the result?
A. 2 -1
B. 2 -4
C. 2 -5
D. 3 -1
E. 3 -4
F. 3 -5
G. Compilation fails.
H. An exception is thrown at runtime.
Answer: C
Explanation/Reference:
	<li>public static int binarySearch(Object[] a, Object key)
Searches the specified array for the specified object using the binary search algorithm. The array must be sorted into ascending order according to the natural ordering of its elements (as by the sort(Object[]) method) prior to making this call. If it is not sorted, the results are undefined. (If the array contains elements that are not mutually comparable (for example, strings and integers), it cannot be sorted according to the natural ordering of its elements, hence results are undefined.) If the array contains multiple elements equal to the specified object, there is no guarantee which one will be found.</li>

	<li>Parameters:
a - the array to be searched
key - the value to be searched for</li>

	<li>Returns:
index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.</li>

	<li>Throws: ClassCastException - if the search key is not comparable to the elements of the array.</li>
<br/>

<strong>Q17: collection**********************</strong>
[java]
34. HashMap props = new HashMap();
35. props.put("key45", "some value");
36. props.put("key12", "some other value");
37. props.put("key39", "yet another value");
38. Set s = props.keySet();
39. //insert code here
[/java]
What, inserted at line 39, will sort the keys in the props HashMap?
A. Arrays.sort(s);
B. s = new TreeSet(s);
C. Collections.sort(s);
D. s = new SortedSet(s);
Answer: B
Explanation/Reference:
<br/>


<strong>Q51: collection / LinkedList</strong>
[java]
public static Collection get() {
Collection sorted = new LinkedList();
sorted.add("B"); sorted.add("C"); sorted.add("A");
return sorted;
}
public static void main(String[] args) {
for (Object obj: get()) {
System.out.print(obj + ", ");
}
}
[/java]
What is the result?
A. A, B, C,
B. B, C, A,
C. Compilation fails.
D. The code runs with no output.
E. An exception is thrown at runtime.
Answer: B
Explanation/Reference:
<br/>

<strong>Q55: collection / iterator*******************</strong>
[java]
public static Iterator reverse(List list) {
Collections.reverse(list);
return list.iterator();
}
public static void main(String[] args) {
List list = new ArrayList();
list.add("1"); list.add("2"); list.add("3");
for (Object obj: reverse(list))
System.out.print(obj + ", ");
}
[/java]
What is the result?
A. 3, 2, 1,
B. 1, 2, 3,
C. Compilation fails.
D. The code runs with no output.
E. An exception is thrown at runtime.
Answer: C
Explanation/Reference: Can only iterate over an array or an instance of java.lang.Iterable
<br/>

<strong>Q10: interface / collection*******************</strong>
[java]
interface A { void x(); }
class B implements A { public void x() {} public void y() {} }
class C extends B { public void x() {} }
and:
20. java.util.List<A> list = new java.util.ArrayList<A>();
21. list.add(new B());
22. list.add(new C());
23. for (A a : list) {
24. a.x();
25. a.y();
26. }
[/java]
What is the result?
A. The code runs with no output.
B. An exception is thrown at runtime.
C. Compilation fails because of an error in line 20.
D. Compilation fails because of an error in line 21.
E. Compilation fails because of an error in line 23.
F. Compilation fails because of an error in line 25.
Answer: F
Explanation/Reference:
<br/>


<strong>Q16: Collection</strong>
[java]
class Alligator {
public static void main(String[] args) {
int[] x[] = { { 1, 2 }, { 3, 4, 5 }, { 6, 7, 8, 9 } };
int[][] y = x;
System.out.println(y[2][1]);
}
}
[/java]
What is the result?
A. 2
B. 3
C. 4
D. 6
E. 7
F. Compilation fails.
Answer: E
Explanation/Reference:
<br/>


<strong>Q23: Collection / Object</strong>
11. public static void main(String[] args) {
12. Object obj = new int[] { 1, 2, 3 };
13. int[] someArray = (int[])obj;
14. for (int i : someArray) System.out.print(i + " ");
15. }
What is the result?
A. 1 2 3
B. Compilation fails because of an error in line 12.
C. Compilation fails because of an error in line 13.
D. Compilation fails because of an error in line 14.
E. A ClassCastException is thrown at runtime.
Answer: A
Explanation/Reference:
<br/>


<strong>Q30: Collection</strong>
[/java]
import java.util.*;
public class SortOf {
public static void main(String[] args) {
ArrayList<Integer> a = new ArrayList<Integer>();
a.add(1); a.add(5); a.add(3);
Collections.sort(a);
a.add(2);
Collections.reverse(a);
System.out.println(a);
}
}
[/java]
What is the result?
A. [1, 2, 3, 5]
B. [2, 1, 3, 5]
C. [2, 5, 3, 1]
D. [5, 3, 2, 1]
E. [1, 3, 5, 2]
F. Compilation fails.
G. An exception is thrown at runtime.
Answer: C
Explanation/Reference:
<br/>

<strong>Q31: Collection</strong>
[java]
public class Person {
private name;
public Person(String name) {
this.name = name;
}
public int hashCode() {
return 420;
}
}
[/java]
Which statement is true?
A. The time to find the value from HashMap with a Person key depends on the size of the map.
B. Deleting a Person key from a HashMap will delete all map entries for all keys of type Person.
C. Inserting a second Person object into a HashSet will cause the first Person object to be removed as a
duplicate.
D. The time to determine whether a Person object is contained in a HashSet is constant and does NOT
depend on the size of the map.
Answer: A
Explanation/Reference:
<br/>


<strong>Q32: Collection</strong>
[java]
import java.util.TreeSet;
public class Explorer2 {
public static void main(String[] args) {
TreeSet<Integer> s = new TreeSet<Integer>();
TreeSet<Integer> subs = new TreeSet<Integer>();
for(int i = 606; i < 613; i++)
if(i%2 == 0) s.add(i);
subs = (TreeSet)s.subSet(608, true, 611, true);
s.add(629);
System.out.println(s + " " + subs);
}
}
[/java]
What is the result?
A. Compilation fails.
B. An exception is thrown at runtime.
C. [608, 610, 612, 629] [608, 610]
D. [608, 610, 612, 629] [608, 610, 629]
E. [606, 608, 610, 612, 629] [608, 610]
F. [606, 608, 610, 612, 629] [608, 610, 629]
Answer: E
Explanation/Reference:
<br/>


<strong>Q33: collection / treeSet************************</strong>
[java]
public class Drink implements Comparable {
public String name;
public int compareTo(Object o) {
return 0;
}
}
and:
Drink one = new Drink();
Drink two = new Drink();
one.name= "Coffee";
two.name= "Tea";
TreeSet set = new TreeSet();
set.add(one);
set.add(two);
[/java]
A programmer iterates over the TreeSet and prints the name of each Drink object. What is the result?
A. Tea
B. Coffee
C. Coffee
Tea
D. Compilation fails.
E. The code runs with no output.
F. An exception is thrown at runtime.
Answer: B
Explanation/Reference: Only add the first element.
<br/>


<strong>Q35: Collection / set</strong>
[java]
01. import java.util.*;
02. public class Example {
03. public static void main(String[] args) {
04. // insert code here
05. set.add(new Integer(2));
06. set.add(new Integer(1));
07. System.out.println(set);
08. }
09. }
[/java]
Which code, inserted at line 4, guarantees that this program will output [1, 2]?
A. Set set = new TreeSet();
B. Set set = new HashSet();
C. Set set = new SortedSet();
D. List set = new SortedList();
E. Set set = new LinkedHashSet();
Answer: A
Explanation/Reference:
<br/>



### Multithreading
<strong>Q1: multithreading</strong>
[java]
public class Threads2 implements Runnable {
    public void run () {
	    System.out.println("run. ");
		throw new RuntimeException("Problem");
	}
	
	public static void main(String[] args) {
	    Thread t = new Thread (new Threads2());
		t.start();
		System.out.println("End of method.");
	}
}
[/java]
Which two can be results? (Choose two.)
<ul>A. java.lang.RuntimeException: Problem</ul>
<ul>B. run.
java.lang.RuntimeException: Problem</ul>
<ul>C. End of method.
java.lang.RuntimeException: Problem</ul>
<ul>D. End of method.
run.
java.lang.RuntimeException: Problem</ul>
<ul>E. run.
java.lang.RuntimeException: Problem
End of method.</ul>
Answer: DE
Explanation: Thread t and main thread are running independently.
<br/>

<strong>Q2: multithreading</strong>
Which two statements are true? (Choose two.)
<ul>A. It is possible for more than two threads to deadlock at once.</ul>
<ul>B. The JVM implementation guarantees that multiple threads cannot enter into a deadlocked state.</ul>
<ul>C. Deadlocked threads release once their sleep() method's sleep duration has expired.</ul>
<ul>D. Deadlocking can occur only when the wait(), notify(), and notifyAll() methods are used incorrectly.</ul>
<ul>E. It is possible for a single-threaded application to deadlock if synchronized blocks are used incorrectly </ul>
<ul>F. If a piece of code is capable of deadlocking, you cannot eliminate the possibility of deadlocking by inserting invocations of Thread.yield().</ul>
Answer: AF
Explanation: 
<br/>

<strong>Q3: multithreading</strong>
[java]
void waitForSignal() {
    Object obj = new Object();
    synchronized (Thread.currentThread()) {
        obj.wait();
        obj.notify();
    }
}
[/java]
Which statement is true?
<ul>A. This code can throw an InterruptedException.</ul>
<ul>B. This code can throw an IllegalMonitorStateException.</ul>
<ul>C. This code can throw a TimeoutException after ten minutes.</ul>
<ul>D. Reversing the order of obj.wait() and obj.notify() might cause this method to complete normally.</ul>
<ul>E. A call to notify() or notifyAll() from another thread might cause this method to complete normally.</ul>
<ul>F. This code does NOT compile unless "obj.wait()" is replaced with "((Thread) obj).wait()".</ul>
Answer: A
Explanation:
<br/>

<strong>Q4: multithreading</strong>
[java]
class PingPong2 {
synchronized void hit(long n) {
for(int i = 1; i < 3; i++)
System.out.print(n + "-" + i + " ");
}
}
public class Tester implements Runnable {
static PingPong2 pp2 = new PingPong2();
public static void main(String[] args) {
new Thread(new Tester()).start();
new Thread(new Tester()).start();
}
public void run() { pp2.hit(Thread.currentThread().getId()); }
}
[/java]
Which statement is true?
<ul>A. The output could be 5-1 6-1 6-2 5-2</ul>
<ul>B. The output could be 6-1 6-2 5-1 5-2</ul>
<ul>C. The output could be 6-1 5-2 6-2 5-1</ul>
<ul>D. The output could be 6-1 6-2 5-1 7-1</ul>
Answer: B
Explanation: 
<br/>

<strong>Q5: multithreading</strong>
[java]
public class Threads4 {
public static void main (String[] args) {
new Threads4().go();
}
public void go() {
Runnable r = new Runnable() {
public void run() {
System.out.print("foo");
}
};
Thread t = new Thread(r);
t.start();
t.start();
}
}
[/java]
What is the result?
<ul>A. Compilation fails.</ul>
<ul>B. An exception is thrown at runtime.</ul>
<ul>C. The code executes normally and prints "foo".</ul>
<ul>D. The code executes normally, but nothing is printed.</ul>
Answer: B
Explanation: 
<br/>

<strong>Q18: multithreading************************</strong>
Which two statements are true? (Choose two.)
A. It is possible to synchronize static methods.
B. When a thread has yielded as a result of yield(), it releases its locks.
C. When a thread is sleeping as a result of sleep(), it releases its locks.
D. The Object.wait() method can be invoked only from a synchronized context.
E. The Thread.sleep() method can be invoked only from a synchronized context.
F. When the thread scheduler receives a notify() request, and notifies a thread, that thread immediately releases its lock.
Answer: AD
Explanation/Reference:
<br/>

<strong>Q19: multithreading</strong>
[java]
public class TestOne implements Runnable {
public static void main (String[] args) throws Exception {
Thread t = new Thread(new TestOne());
t.start();
System.out.print("Started");
t.join();
System.out.print("Complete");
}
public void run() {
for (int i = 0; i < 4; i++) {
System.out.print(i);
}
}
}
[/java]
What can be a result?
A. Compilation fails.
B. An exception is thrown at runtime.
C. The code executes and prints "StartedComplete".
D. The code executes and prints "StartedComplete0123".
E. The code executes and prints "Started0123Complete".
Answer: E
Explanation/Reference: t.join(),  0123 must be printed before Complete.
<br/>

<strong>Q20: multithreading / synchronized</strong>
Which three will compile and run without exception? (Choose three.)
A. private synchronized Object o;
B. void go() {
synchronized() { /* code here */ }
}
C. public synchronized void go() { /* code here */ }
D. private synchronized(this) void go() { /* code here */ }
E. void go() {
synchronized(Object.class) { /* code here */ }
}
F. void go() {
Object o = new Object();
synchronized(o) { /* code here */ }
}
Answer: CEF
Explanation/Reference: synchronized method and synchronized block.
<br/>

<strong>Q21: multithreading</strong>
[java]
1. public class TestFive {
2. private int x;
3.
4. public void foo() {
5. int current = x;
6. x = current + 1;
7. }
8.
9. public void go() {
10. for(int i = 0; i < 5; i++) {
11. new Thread() {
12. public void run() {
13. foo();
14. System.out.print(x + ", ");
15. }
16. }.start();
17. }
18. }
19.}
[/java]
Which two changes, taken together, would guarantee the output: 1, 2, 3, 4, 5, ? (Choose two.)
A. move the line 14 print statement into the foo() method
B. change line 9 to public synchronized void go() {
C. change the variable declaration on line 2 to private volatile int x;
D. wrap the code inside the foo() method with a synchronized( this ) block
E. wrap the for loop code inside the go() method with a synchronized block synchronized(this) { // for loop
code here }
Answer: AD
Explanation/Reference:
<br/>

<strong>Q22: multithreading</strong>
Given that t1 is a reference to a live thread, which is true?
A. The Thread.sleep() method can take t1 as an argument.
B. The Object.notify() method can take t1 as an argument.
C. The Thread.yield() method can take t1 as an argument.
D. The Thread.setPriority() method can take t1 as an argument.
E. The Object.notify() method arbitrarily chooses which thread to notify.
Answer: E
Explanation/Reference:
<br/>

<strong>Q23: multithreading******************</strong>
[java]
Runnable r = new Runnable() {
public void run() {
System.out.print("Cat");
}
};
Thread t = new Thread(r) {
public void run() {
System.out.print("Dog");
}
};
t.start();
[/java]
What is the result?
A. Cat
B. Dog
C. Compilation fails.
D. The code runs with no output.
E. An exception is thrown at runtime.
Answer: B
Explanation/Reference: overriding run() method.
<br/>

<strong>Q24: multithreading</strong>
[java]
public class Threads5 {
public static void main (String[] args) {
new Thread(new Runnable() {
public void run() {
System.out.print("bar");
}}).start();
}
}
[/java]
What is the result?
A. Compilation fails.
B. An exception is thrown at runtime.
C. The code executes normally and prints "bar".
D. The code executes normally, but nothing prints.
Answer: C
Explanation/Reference:
<br/>

<strong>Q19: multithreading</strong>
Which two classes correctly implement both the java.lang.Runnable and the java.lang.Cloneable interfaces? (Choose two.)
[java]
A. public class Session implements Runnable, Cloneable {
public void run();
public Object clone();
}
B. public class Session extends Runnable, Cloneable {
public void run() { /* do something */ }
public Object clone() { /* make a copy */ }
}
C. public class Session implements Runnable, Cloneable {
public void run() { /* do something */ }
public Object clone() { /* make a copy */ }
}
D. public abstract class Session
implements Runnable, Cloneable {
public void run() { /* do something */ }
public Object clone() { /*make a copy */ }
}
E. public class Session implements Runnable, implements Cloneable {
public void run() { /* do something */ }
public Object clone() { /* make a copy */ }
}
[/java]
Answer: CD
Explanation/Reference: First, it needs keyword implements for interface. Second, the run()  and clone() methods in interfaces of Runnable and Cloneable must be overridden. 
<br/>

<strong>Q24: multithreading</strong>
Click the Exhibit button.
[java]
public class Threads1 {
int x = 0;
public class Runner implements Runnable {
public void run(){
int current = 0;
for(int i = 0; i<4; i++){
current = x;
System.out.println(current + ", ");
x = current + 2;
}
}
}
public static void main(String[] args) {
new Threads1().go();
}
public void go(){
Runnable r1 = new Runner();
new Thread(r1).start();
new Thread(r1).start();
}
}
[/java]
Which two are possible results? (Choose two.)
A. 0, 2, 4, 4, 6, 8, 10, 6,
B. 0, 2, 4, 6, 8, 10, 2, 4,
C. 0, 2, 4, 6, 8, 10, 12, 14,
D. 0, 0, 2, 2, 4, 4, 6, 6, 8, 8, 10, 10, 12, 12, 14, 14,
E. 0, 2, 4, 6, 8, 10, 12, 14, 0, 2, 4, 6, 8, 10, 12, 14,
Answer: AC
Explanation/Reference:
<br/>

<strong>Q25: multithreading</strong>
foo and bar are public references available to many other threads. foo refers to a Thread and bar is an Object. The thread foo is currently executing bar.wait(). From another thread, what provides the most reliable way to ensure that foo will stop executing wait()?
A. foo.notify();
B. bar.notify();
C. foo.notifyAll();
D. Thread.notify();
E. bar.notifyAll();
F. Object.notify();
Answer: E
Explanation/Reference:
<br/>

<strong>Q26: multithreading*************************</strong>
[java]
public class PingPong implements Runnable {
synchronized void hit(long n) {
for (int i = 1; i < 3; i++)
System.out.print(n + "-" + i + " ");
}
public static void main(String[] args) {
new Thread(new PingPong()).start();
new Thread(new PingPong()).start();
}
public void run() {
hit(Thread.currentThread().getId());
}
}
[/java]
Which two statements are true? (Choose two.)
A. The output could be 8-1 7-2 8-2 7-1
B. The output could be 7-1 7-2 8-1 6-1
C. The output could be 8-1 7-1 7-2 8-2
D. The output could be 8-1 8-2 7-1 7-2
Answer: CD
Explanation/Reference:
<br/>

<strong>Q27: multithreading</strong>
Click the Exhibit button.
[java]
class Computation extends Thread {
private int num;
private boolean isComplete;
private int result;
public Computation(int num){ this.num = num; }
public synchronized void run() {
result = num * 2;
isComplete = true;
notify();
}
public synchronized int getResult() {
while ( ! isComplete ){
try {
wait();
} catch (InterruptedException e) {
}
}
return result;
}
public static void main(String[] args) {
Computation[] computations = new Computation[4];
for (int i = 0; i < computations.length; i++) {
computations[i] = new Computation(i);
computations[i].start();
}
for (Computation c : computations) {
System.out.println(c.getResult() + " ");
}
}
}
[/java]
What is the result?
A. The code will deadlock.
B. The code may run with no output.
C. An exception is thrown at runtime.
D. The code may run with output "0 6".
E. The code may run with output "2 0 6 4".
F. The code may run with output "0 2 4 6".
Answer: F
Explanation/Reference:
<br/>

<strong>Q28: multithreading</strong>
Which two code fragments will execute the method doStuff() in a separate thread? (Choose two.)
[java]
A. new Thread() {
public void run() { doStuff(); }
};
B. new Thread() {
public void start() { doStuff(); }
};
C. new Thread() {
public void start() { doStuff(); }
}.run();
D. new Thread() {
public void run() { doStuff(); }
}.start();
E. new Thread(new Runnable() {
public void run() { doStuff(); }
}).run();
F. new Thread(new Runnable() {
public void run() { doStuff(); }
}).start();
[/java]
Answer: DF
Explanation/Reference:
<br/>

### Exception
<strong>Q30: Exception</strong>
[java]
static void test() throws RuntimeException {
try {
System.out.print("test ");
throw new RuntimeException();
}
catch (Exception ex) { System.out.print("exception "); }
}
public static void main(String[] args) {
try { test(); }
catch (RuntimeException ex) { System.out.print("runtime "); }
System.out.print("end ");
}
[/java]
What is the result?
<ul>A. test end</ul>
<ul>B. Compilation fails.</ul>
<ul>C. test runtime end</ul>
<ul>D. test exception end</ul>
<ul>E. A Throwable is thrown by main at runtime.</ul>
Answer: D
Explanation/Reference: the exception in test() is caught by itself catch(), try{test()} runs successfully and then move ignores the following catch().
<br/>

<strong>Q41: Exception</strong>
[java]
33. try {
34. //some code here
35. } catch (NullPointerException e1) {
36. System.out.print("a");
37. } catch (Exception e2) {
38. System.out.print("b");
39. } finally {
40. System.out.print("c");
41. }
[/java]
If some sort of exception is thrown at line 34, which output is possible?
<ul>A. a</ul>
<ul>B. b</ul>
<ul>C. c</ul>
<ul>D. ac</ul>
<ul>E. abc</ul>
Answer: D
Explanation/Reference:
<br/>

<strong>Q42: Exception</strong>
[java]
31. //some code here line 31
32. try {
33. //some code here line 33
34. } catch (NullPointerException e1) {
35. //some code here line 35
36. } finally {
37. //some code here line 37
38. }
[/java]
Under which three circumstances will the code on line 37 be executed? (Choose three.)
<ul>A. The instance gets garbage collected.</ul>
<ul>B. The code on line 33 throws an exception.</ul>
<ul>C. The code on line 35 throws an exception.</ul>
<ul>D. The code on line 31 throws an exception.</ul>
<ul>E. The code on line 33 executes successfully.</ul>
Answer: BCE
Explanation/Reference:
<br/>

<strong>Q44: Exception / assert ****************************</strong>
[java]
public class Donkey2 {
public static void main(String[] args) {
boolean assertsOn = true;
assert (assertsOn) : assertsOn = true;
if(assertsOn) {
System.out.println("assert is on");
}
}
}
[/java]
If class Donkey is invoked twice, the first time without assertions enabled, and the second time with assertions enabled, what are the results?
<ul>A. no output</ul>
<ul>B. no output
assert is on</ul>
<ul>C. assert is on</ul>
<ul>D. no output
An AssertionError is thrown.</ul>
<ul>E. assert is on
An AssertionError is thrown.</ul>
Answer: C
Explanation/Reference:
<br/>

<strong>Q45: Exception</strong>
[java]
01. public class A{
02. public void method1() {
03. try {
04. B b = new B();
05. b.method2();
06. //more code here
07. } catch (TestException te){
08. throw new RuntimeException(te);
09. }
10. }
11. }
01. public class B{
02. public void method2() throws TestException {
03. //more code here
04 }
05.}
01. class TestException extends Exception {
02. }
31. public void method() {
32. A a = new A();
33. a.method1();
34. }
[/java]
Which statement is true if a TestException is thrown on line 3 of class B?
<ul>A. Line 33 must be called within a try block.</ul>
<ul>B. The exception thrown by method1 in class A is not required to be caught.</ul>
<ul>C. The method declared on line 31 must be declared to throw a RuntimeException.</ul>
<ul>D. On line 5 of class A, the call to method2 of class B does not need to be placed in a try/catch block.</ul>
Answer: B
Explanation/Reference: When method2 throws an exception, the program will stay in method2 and won't be back.
<br/>


<strong>Q46: Exception</strong>
[java]
Float pi = new Float(3.14f);
if (pi > 3) {
System.out.print("pi is bigger than 3. ");
}
else {
System.out.print("pi is not bigger than 3. ");
}
finally {
System.out.println("Have a nice day.");
}
[/java]
What is the result?
<ul>A. Compilation fails.</ul>
<ul>B. pi is bigger than 3.</ul>
<ul>C. An exception occurs at runtime.</ul>
<ul>D. pi is bigger than 3. Have a nice day.</ul>
<ul>E. pi is not bigger than 3. Have a nice day.</ul>
Answer: A
Explanation/Reference: Syntax error on token finally--exception format: try-finally, try-catch-finally, try-catch...catch-finally.
<br/>


<strong>Q47: Exception / assert</strong>
[java]
public class Donkey {
public static void main(String[] args) {
boolean assertsOn = false;
assert (assertsOn) : assertsOn = true;
if(assertsOn) {
System.out.println("assert is on");
}
}
}
[/java]
If class Donkey is invoked twice, the first time without assertions enabled, and the second time with assertions enabled, what are the results?
A. no output
B. no output
assert is on
C. assert is on
D. no output
An AssertionError is thrown.
E. assert is on
An AssertionError is thrown.
Answer: D
Explanation/Reference:
<br/>


<strong>Q48: Exception</strong>
[java]
static void test() {
try {
String x = null;
System.out.print(x.toString() + " ");
}
finally { System.out.print("finally "); }
}
public static void main(String[] args) {
try { test(); }
catch (Exception ex) { System.out.print("exception "); }
}
[/java]
What is the result?
A. null
B. finally
C. null finally
D. Compilation fails.
E. finally exception
Answer: E
Explanation/Reference: If you don't instantiate an object, program will throw an java.lang.NullPointerException.
<br/>

<strong>Q49: Exception****************</strong>
[java]
static void test() throws Error {
if (true) throw new AssertionError();
System.out.print("test ");
}
public static void main(String[] args) {
try { test(); }
catch (Exception ex) { System.out.print("exception "); }
System.out.print("end ");
}
[/java]
What is the result?
A. end
B. Compilation fails.
C. exception end
D. exception test end
E. A Throwable is thrown by main.
F. An Exception is thrown by main.
Answer: E
Explanation/Reference: keyword: throw exception 
<br/>


<strong>Q50: Exception***********</strong>
[java]
01. class TestException extends Exception { }
02. class A {
03. public String sayHello(String name) throws TestException {
04. if(name == null) throw new TestException();
05 return "Hello " + name;
06. }
07. }
08. public class TestA {
09. public static void main(String[] args) {
10. new A().sayHello("Aiko");
11. }
12. }
[/java]
Which statement is true?
A. Compilation succeeds.
B. Class A does not compile.
C. The method declared on line 9 cannot be modified to throw TestException.
D. TestA compiles if line 10 is enclosed in a try/catch block that catches TestException.
Answer: D
Explanation: line 10-- Error: unreported exception TestException; must be caught or declared to be thrown
<br/>

<strong>Q53: Exception</strong>
[java]
public class Foo {
static int[] a;
static { a[0]=2; }
public static void main( String[] args ) {}
}
[/java]
Which exception or error will be thrown when a programmer attempts to run this code?
A. java.lang.StackOverflowError
B. java.lang.IllegalStateException
C. java.lang.ExceptionInInitializerError
D. java.lang.ArrayIndexOutOfBoundsException
Answer: C
Explanation/Reference: a is not instantiated in static block. If you add one line: a = new int[1]; the program will run successfully.
<br/>

<strong>Q58: Exceptinon</strong>
What is the output if the main() method is run?
[java]
public class Starter extends Thread {
private int x = 2;
public static void main(String[] args) throws Exception {
new Starter().makeItSo();
}
public Starter(){
x = 5;
start();
}
public void makeItSo() throws Exception {
join();
x = x - 1;
System.out.println(x);
}
public void run() { x *= 2; }
}
[/java]
A. 4
B. 5
C. 8
D. 9
E. Compilation fails.
F. An exception is thrown at runtime.
G. It is impossible to determine for certain.
Answer: D
Explanation/Reference:
<br/>


<strong>Q37: Exception</strong>
[java]
84. try {
85. ResourceConnection con = resourceFactory.getConnection();
86. Results r = con.query("GET INFO FROM CUSTOMER");
87. info = r.getData();
88. con.close();
89. } catch (ResourceException re) {
90. errorLog.write(re.getMessage());
91. }
92. return info;
[/java]
Which statement is true if a ResourceException is thrown on line 86?
A. Line 92 will not execute.
B. The connection will not be retrieved in line 85.
C. The resource connection will not be closed on line 88.
D. The enclosing method will throw an exception to its caller.
Answer: C
Explanation/Reference:
<br/>


<strong>Q39: Exception / assert*********************</strong>
[java]
11. public void go(int x) {
12. assert (x > 0);
13. switch(x) {
14. case 2: ;
15. default: assert false;
16. }
17. }
18. private void go2(int x) { assert (x < 0); }
[/java]
Which statement is true?
A. All of the assert statements are used appropriately.
B. Only the assert statement on line 12 is used appropriately.
C. Only the assert statement on line 15 is used appropriately.
D. Only the assert statement on line 18 is used appropriately.
E. Only the assert statements on lines 12 and 15 are used appropriately.
F. Only the assert statements on lines 12 and 18 are used appropriately.
G. Only the assert statements on lines 15 and 18 are used appropriately.
Answer: G
Explanation/Reference:
<br/>


<strong>Q40: Exception</strong>
[java]
public static void main(String[] args) {
try {
args = null;
args[0] = "test";
System.out.println(args[0]);
} catch (Exception ex) {
System.out.println("Exception");
} catch (NullPointerException npe) {
System.out.println("NullPointerException");
}
}
[/java]
What is the result?
A. test
B. Exception
C. Compilation fails.
D. NullPointerException
Answer: C
Explanation/Reference: Incorrect order of catch statements.
<br/>

<strong>Q42: Exception / inheritance</strong>
[java]
11. class X { public void foo() { System.out.print("X "); } }
12.
13. public class SubB extends X {
14. public void foo() throws RuntimeException {
15. super.foo();
16. if (true) throw new RuntimeException();
17. System.out.print("B ");
18. }
19. public static void main(String[] args) {
20. new SubB().foo();
21. }
22. }
[/java]
A. X, followed by an Exception.
B. No output, and an Exception is thrown.
C. Compilation fails due to an error on line 14.
D. Compilation fails due to an error on line 16.
E. Compilation fails due to an error on line 17.
F. X, followed by an Exception, followed by B.
Answer: A
Explanation/Reference:
X Exception in thread "main" java.lang.RuntimeException
at SubB.foo(SubB.java:5)
at SubB.main(SubB.java:9)
<br/>


<strong>Q44: Exception***********</strong>
Which can appropriately be thrown by a programmer using Java SE technology to create a desktop application?
A. ClassCastException
B. NullPointerException
C. NoClassDefFoundError
D. NumberFormatException
E. ArrayIndexOutOfBoundsException
Answer: D
Explanation/Reference:
<br/>

<strong>Q45: Exception</strong>
Which two code fragments are most likely to cause a StackOverflowError? (Choose two.)
[java]
A. int []x = {1,2,3,4,5};
for(int y = 0; y < 6; y++)
System.out.println(x[y]);
B. static int[] x = {7,6,5,4};
static { x[1] = 8;
x[4] = 3; }
C. for(int y = 10; y < 10; y++)
doStuff(y);
D. void doOne(int x) { doTwo(x); }
void doTwo(int y) { doThree(y); }
void doThree(int z) { doTwo(z); }
E. for(int x = 0; x < 1000000000; x++)
doStuff(x);
F. void counter(int i) { counter(++i); }
[/java]
Answer: DF
Explanation/Reference:
<br/>

### IO
 <strong>Q24: IO / inheritance¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á¡Á </strong>
Assuming that the serializeBanana() and the deserializeBanana() methods will correctly use Java serialization and given:
[java]
13. import java.io.*;
14. class Food implements Serializable {int good = 3;}
15. class Fruit extends Food {int juice = 5;}
16. public class Banana extends Fruit {
17. int yellow = 4;
18. public static void main(String [] args) {
19. Banana b = new Banana(); Banana b2 = new Banana();
20. b.serializeBanana(b); // assume correct serialization
21. b2 = b.deserializeBanana(); // assume correct
22. System.out.println("restore "+b2.yellow+ b2.juice+b2.good);
24. }
25. // more Banana methods go here
50. }
[/java]
What is the result?
<ul>A. restore 400</ul>
<ul>B. restore 403</ul>
<ul>C. restore 453</ul>
<ul>D. Compilation fails.</ul>
<ul>E. An exception is thrown at runtime.</ul>
Answer: C
Explanation/Reference:
<br/>


<strong>Q28: IO*********</strong>
Which capability exists only in java.io.FileWriter?
<ul>A. Closing an open stream.</ul>
<ul>B. Flushing an open stream.</ul>
<ul>C. Writing to an open stream.</ul>
<ul>D. Writing a line separator to an open stream.</ul>
Answer: D
Explanation/Reference:
<br/>

<strong>Q29: IO</strong>
Given that the current directory is empty, and that the user has read and write permissions, and the
following:
[java]
import java.io.*;
public class DOS {
public static void main(String[] args) {
File dir = new File("dir");
dir.mkdir();
File f1 = new File(dir, "f1.txt");
try {
f1.createNewFile();
} catch (IOException e) { ; }
File newDir = new File("newDir");
dir.renameTo(newDir);
}
}
[/java]
Which statement is true?
<ul>A. Compilation fails.</ul>
<ul>B. The file system has a new empty directory named dir.</ul>
<ul>C. The file system has a new empty directory named newDir.</ul>
<ul>D. The file system has a directory named dir, containing a file f1.txt.</ul>
<ul>E. The file system has a directory named newDir, containing a file f1.txt.</ul>
Answer: E
Explanation/Reference:
<br/>

<strong>Q36: I/O seriablize ************</strong>
Which code, inserted at line 14, will allow this class to correctly serialize and deserialize?
[java]
01. import java.io.*;
02. public class Foo implements Serializable {
03. public int x, y;
04. public Foo(int x, int y){
05. this.x = x; this.y = y;
06. }
07.
08. private void writeObject(ObjectOutputStream s)
09. throws IOException{
10. s.writeInt(x); s.writeInt(y);
11. }
12.
13. private void readObject(ObjectInputStream s)
14. throws IOException, ClassNotFoundException {
15. //insert code here
16. }
17. }
[/java]
<ul>A. s.defaultReadObject();</ul>
<ul>B. this = s.defaultReadObject();</ul>
<ul>C. y = s.readInt(); x = s.readInt();</ul>
<ul>D. x = s.readInt(); y = s.readInt();</ul>
Answer: D
Explanation/Reference:
<br/>

<strong>Q60: IO / console </strong>
Given that c is a reference to a valid java.io.Console object, which two code fragments read a line of text from the console? (Choose two.)
</ul>A. String s = c.readLine();</ul>
</ul>B. char[] c = c.readLine();</ul>
</ul>C. String s = c.readConsole();</ul>
</ul>D. char[] c = c.readConsole();</ul>
</ul>E. String s = c.readLine("%s", "name ");</ul>
</ul>F. char[] c = c.readLine("%s", "name ");</ul>
Answer: AE
Explanation/Reference: String readLine() method.



<strong>Q3: IO</strong>
[java]
import java.io.*;
public class Forest implements Serializable {
private Tree tree = new Tree();
public static void main(String [] args) {
Forest f = new Forest();
try {
FileOutputStream fs = new FileOutputStream("Forest.ser");
ObjectOutputStream os = new ObjectOutputStream(fs);
os.writeObject(f); os.close();
} catch (Exception ex) { ex.printStackTrace(); }
}
}
class Tree { }
[/java]
What is the result?
A. Compilation fails.
B. An exception is thrown at runtime.
C. An instance of Forest is serialized.
D. An instance of Forest and an instance of Tree are both serialized.
Answer: B
Explanation/Reference:
[java]
java.io.NotSerializableException: Tree
at java.io.ObjectOutputStream.writeObject0(Unknown Source)
at java.io.ObjectOutputStream.defaultWriteFields(Unknown Source)
at java.io.ObjectOutputStream.writeSerialData(Unknown Source)
at java.io.ObjectOutputStream.writeOrdinaryObject(Unknown Source)
at java.io.ObjectOutputStream.writeObject0(Unknown Source)
at java.io.ObjectOutputStream.writeObject(Unknown Source)
at Forest.main(Forest.java:9)
[/java]
<br/>

<strong>Q4: IO / console*****************</strong>
[java]
01. import java.io.*;
02.
03. public class Talk {
04. public static void main(String[] args) {
05. Console c = new Console();
06. String pw;
07. System.out.print("password: ");
08. pw = c.readLine();
09. System.out.println("got " + pw);
10. }
11. }
[/java]
If the user types the password aiko when prompted, what is the result?
A. password:
got
B. password:
got aiko
C. password: aiko
got aiko
D. An exception is thrown at runtime.
E. Compilation fails due to an error on line 5.
Answer: E
Explanation/Reference: Console doesn't have constructor. To get instance of Console you have to invoke: System.console()
<br/>


<strong>Q56: IO********************</strong>
Given that the current directory is empty, and that the user has read and write privileges to the current directory, and the following:
[java]
import java.io.*;
public class Maker {
public static void main(String[] args) {
File dir = new File("dir");
File f = new File(dir, "f");
}
}
[/java]
Which statement is true?
A. Compilation fails.
B. Nothing is added to the file system.
C. Only a new file is created on the file system.
D. Only a new directory is created on the file system.
E. Both a new file and a new directory are created on the file system.
Answer: B
Explanation/Reference:
<br/>

<strong>Q58: IO / seriablizable******************</strong>
Which three statements concerning the use of the java.io.Serializable interface are true? (Choose three.)
A. Objects from classes that use aggregation cannot be serialized.
B. An object serialized on one JVM can be successfully deserialized on a different JVM.
C. The values in fields with the volatile modifier will NOT survive serialization and deserialization.
D. The values in fields with the transient modifier will NOT survive serialization and deserialization.
E. It is legal to serialize an object of a type that has a supertype that does NOT implement java.io.Serializable.
Answer: BDE
Explanation/Reference:
<br/>


### Garbage Collection
<strong>Q56: Garbage Collection</strong>
Which statement is true?
<ul>A. A class's finalize() method CANNOT be invoked explicitly.</ul>
<ul>B. super.finalize() is called implicitly by any overriding finalize() method.</ul>
<ul>C. The finalize() method for a given object is called no more than once by the garbage collector.</ul>
<ul>D. The order in which finalize() is called on two objects is based on the order in which the two objects became finalizable.</ul>
Answer: C
Explanation/Reference:
A: finalize() method can be called explicitly.
B: If you are overriding finalize method than its your responsibility to call finalize() method of super-class, if you forgot to call then finalize of super class will never be called
C: finalize gets called only once by GC thread, if object revive itself from finalize method than finalize will not be called again.
D: JVM decides which finalize() be called first.
<br/>


<strong>Q46: GC*********************</strong>
[java]
04. public class Tahiti {
05. Tahiti t;
06.
07. public static void main(String[] args) {
08. Tahiti t = new Tahiti();
09. Tahiti t2 = t.go(t);
10. t2 = null;
11. // more code here
12. }
13.
14. Tahiti go(Tahiti t) {
15. Tahiti t1 = new Tahiti();
16. Tahiti t2 = new Tahiti();
17. t1.t = t2;
18. t2.t = t1;
19. t.t = t2;
20. return t1;
21. }
22. }
[/java]
When line 11 is reached, how many objects are eligible for garbage collection?
A. 0
B. 1
C. 2
D. 3
E. Compilation fails.
Answer: A
Explanation/Reference:
<br/>

<strong>Q41: GC************</strong>
[java]
class Snoochy {
Boochy booch;
public Snoochy() { booch = new Boochy(this); }
}
class Boochy {
Snoochy snooch;
public Boochy(Snoochy s) { snooch = s; }
}
And the statements:
21. public static void main(String[] args) {
22. Snoochy snoog = new Snoochy();
23. snoog = null;
24. // more code here
25. }
[/java]
Which statement is true about the objects referenced by snoog, snooch, and booch immediately after line
23 executes?
A. None of these objects are eligible for garbage collection.
B. Only the object referenced by booch is eligible for garbage collection.
C. Only the object referenced by snoog is eligible for garbage collection.
D. Only the object referenced by snooch is eligible for garbage collection.
E. The objects referenced by snooch and booch are eligible for garbage collection.
Answer: E
Explanation/Reference:
</br>

<strong>Q1: GC*****************</strong>
[java]
01. interface Animal { void makeNoise(); }
02. class Horse implements Animal {
03. Long weight = 1200L;
04. public void makeNoise() { System.out.println("whinny"); }
05. }
06.
07. public class Icelandic extends Horse {
08. public void makeNoise() { System.out.println("vinny"); }
09. public static void main(String[] args) {
10. Icelandic i1 = new Icelandic();
11. Icelandic i2 = new Icelandic();
12. Icelandic i3 = new Icelandic();
13. i3 = i1; i1 = i2; i2 = null; i3 = i1;
14. }
15. }
[/java]
When line 14 is reached, how many objects are eligible for the garbage collector?
A. 0
B. 1
C. 2
D. 3
E. 4
F. 6
Answer: E
Explanation/Reference:
<br/>


### ENUM
<strong>Q8: enum</strong>
[java]
class Nav{
public enum Direction { NORTH, SOUTH, EAST, WEST }
}
public class Sprite{
// insert code here
}
[/java]
Which code, inserted at line 14, allows the Sprite class to compile?
<ul>A. Direction d = NORTH;</ul>
<ul>B. Nav.Direction d = NORTH;</ul>
<ul>C. Direction d = Direction.NORTH;</ul>
<ul>D. Nav.Direction d = Nav.Direction.NORTH;</ul>
Answer: D
Explanation/Reference:
<br/>


<strong>Q11: enum</strong>
[java]
 public class Rainbow {
 public enum MyColor {
 RED(0xff0000), GREEN(0x00ff00), BLUE(0x0000ff);
 private final int rgb;
 MyColor(int rgb) { this.rgb = rgb; }
 public int getRGB() { return rgb; }
 };
 public static void main(String[] args) {
 //insert code here
 }
 }
[/java]
Which code fragment, inserted at line 9, allows the Rainbow class to compile?
<ul>A. MyColor skyColor = BLUE;</ul>
<ul>B. MyColor treeColor = MyColor.GREEN;</ul>
<ul>C. if(RED.getRGB() < BLUE.getRGB()) { }</ul>
<ul>D. Compilation fails due to other error(s) in the code.</ul>
<ul>E. MyColor purple = new MyColor(0xff00ff);</ul>
<ul>F. MyColor purple = MyColor.BLUE + MyColor.RED;</ul>
Answer: B
Explanation/Reference:
<br/>

<strong>Q13: Enum*********************</strong>
[java]enum Example { ONE, TWO, THREE }[/java]
Which statement is true?
A. The expressions (ONE == ONE) and ONE.equals(ONE) are both guaranteed to be true.
B. The expression (ONE < TWO) is guaranteed to be true and ONE.compareTo(TWO) is guaranteed to be less than one.
C. The Example values cannot be used in a raw java.util.HashMap; instead, the programmer must use a java.util.EnumMap.
D. The Example values can be used in a java.util.SortedSet, but the set will NOT be sorted because enumerated types do NOT implement java.lang.Comparable.
Answer: A
Explanation/Reference:
<br/>

<strong>Q34: enum</strong>
[java]
11. public enum Title {
12. MR("Mr."), MRS("Mrs."), MS("Ms.");
13. private final String title;
14. private Title(String t) { title = t; }
15. public String format(String last, String first) {
16. return title + " " + first + " " + last;
17. }
18. }
19.
20. public static void main(String[] args) {
21. System.out.println(Title.MR.format("Doe", "John"));
22. }
[/java]
What is the result?
A. Mr. John Doe
B. An exception is thrown at runtime.
C. Compilation fails because of an error in line 12.
D. Compilation fails because of an error in line 15.
E. Compilation fails because of an error in line 21.
Answer: A
Explanation/Reference:
<br/>

<strong>Q46: enum / switch*****************************</strong>
[java]
public class Test {
public enum Dogs {collie, harrier};
public static void main(String [] args) {
Dogs myDog = Dogs.collie;
switch (myDog) {
case collie:
System.out.print("collie ");
case harrier:
System.out.print("harrier ");
}
}
}
[/java]
What is the result?
A. collie
B. harrier
C. Compilation fails.
D. collie harrier
E. An exception is thrown at runtime.
Answer: D
Explanation:
<br/>

###Package
<strong>Q19: package</strong>
[java]
package test;
class Target {
public String name = "hello";
}
[/java]
What can directly access and change the value of the variable name?
<ul>A. any class</ul>
<ul>B. only the Target class</ul>
<ul>C. any class in the test package</ul>
<ul>D. any class that extends Target</ul>
Answer: C
Explanation/Reference:
<ul>
<li>Private : Private variables or methods may be used only by an instance of the same class that?declares the variable or method. A private feature may only be accessed by the class that owns the?feature.</li>
<li>Default :What you get by default , without any access modifier (ie, public private or protected).It?means that it is visible to all within a particular package.</li>
<li>Protected : is available to all classes in the same package and also available to all subclasses of the?class that owns the protected feature. This access is provided even to subclasses that reside in a?different package from the class that owns the protected feature.</li>
<li>Public : Public class is visible in other packages, field is visible everywhere (class must be public too)</li>
</ul>
<br/>

<strong>Q52: package****</strong>
package utils;
public class Repetition {
public static String twice(String s) { return s + s; }
}
and given another class Demo:
01. public class Demo {
02. public static void main(String[] args) {
03. System.out.println(twice("pizza"));
04. }
05. }
Which code should be inserted at line 1 of Demo.java to compile and run Demo to print "pizzapizza"?
A. import utils.*;
B. static import utils.*;
C. import utils.Repetition.*;
D. static import utils.Repetition.*;
E. import utils.Repetition.twice();
F. import static utils.Repetition.twice;
G. static import utils.Repetition.twice;
Answer: F
Explanation/Reference:
<br/>

<strong>Q53: package********************</strong>
A UNIX user named Bob wants to replace his chess program with a new one, but he is not sure where the old one is installed. Bob is currently able to run a Java chess program starting from his home directory / home/bob using the command:
java -classpath /test:/home/bob/downloads/*.jar games.Chess
Bob's CLASSPATH is set (at login time) to:
/usr/lib:/home/bob/classes:/opt/java/lib:/opt/java/lib/*.jar
What is a possible location for the Chess.class file?
<ul>A. /test/Chess.class</ul>
<ul>B. /home/bob/Chess.class</ul>
<ul>C. /test/games/Chess.class</ul>
<ul>D. /usr/lib/games/Chess.class</ul>
<ul>E. /home/bob/games/Chess.class</ul>
<ul>F. inside jarfile /opt/java/lib/Games.jar (with a correct manifest)</ul>
<ul>G. inside jarfile /home/bob/downloads/Games.jar (with a correct manifest)</ul>
Answer: C
Explanation/Reference:
<br/>


<strong>Q54: package</strong>
Given the following directory structure:
[java]
bigProject
|--source
| |--Utils.java
|
|--classes
[/java]
And the following command line invocation:
javac -d classes source/Utils.java
Assume the current directory is bigProject, what is the result?
<ul>A. If the compile is successful, Utils.class is added to the source directory.</ul>
<ul>B. The compiler returns an invalid flag error.</ul>
<ul>C. If the compile is successful, Utils.class is added to the classes directory.</ul>
<ul>D. If the compile is successful, Utils.class is added to the bigProject directory.</ul>
Answer: C
Explanation/Reference:
<br/>

<strong>Q55: package</strong>
[java]
package com.company.application;
public class MainClass {
public static void main(String[] args) {}
}
[/java]
and MainClass exists in the /apps/com/company/application directory. Assume the CLASSPATH environment variable is set to "." (current directory). Which two java commands entered at the command line will run MainClass? (Choose two.)
<ul>A. java MainClass if run from the /apps directory</ul>
<ul>B. java com.company.application.MainClass if run from the /apps directory</ul>
<ul>C. java -classpath /apps com.company.application.MainClass if run from any directory</ul>
<ul>D. java -classpath . MainClass if run from the /apps/com/company/application directory</ul>
<ul>E. java -classpath /apps/com/company/application:. MainClass if run from the /apps directory</ul>
<ul>F. java com.company.application.MainClass if run from the /apps/com/company/</ul>
application directory
Answer: BC
Explanation/Reference:
<br/>

<strong>Q2: package</strong>
Given two files, GrizzlyBear.java and Salmon.java:
[java]
01. package animals.mammals;
02.
03. public class GrizzlyBear extends Bear {
04. void hunt() {
05. Salmon s = findSalmon();
06. s.consume();
07. }
08. }
01. package animals.fish;
02.
03. public class Salmon extends Fish {
04. public void consume() { /* do stuff */ }
05. }
[/java]
If both classes are in the correct directories for their packages, and the Mammal class correctly defines the findSalmon() method, which change allows this code to compile?
A. add import animals.mammals.*; at line 2 in Salmon.java
B. add import animals.fish.*; at line 2 in GrizzlyBear.java
C. add import animals.fish.Salmon.*; at line 2 in GrizzlyBear.java
D. add import animals.mammals.GrizzlyBear.*; at line 2 in Salmon.java
Answer: B
Explanation/Reference:
<br/>


<strong>Q28: package***********</strong>
[java]
package com.sun.scjp;
public class Geodetics {
public static final double DIAMETER = 12756.32; // kilometers
}
[/java]
Which two correctly access the DIAMETER member of the Geodetics class? (Choose two.)
[java]
A. import com.sun.scjp.Geodetics;
public class TerraCarta {
public double halfway() { return Geodetics.DIAMETER/2.0; }
}
B. import static com.sun.scjp.Geodetics;
public class TerraCarta{
public double halfway() { return DIAMETER/2.0; }
}
C. import static com.sun.scjp.Geodetics.*;
public class TerraCarta {
public double halfway() { return DIAMETER/2.0; }
}
D. package com.sun.scjp;
public class TerraCarta {
public double halfway() { return DIAMETER/2.0; }
}
[/java]
Answer: AC
Explanation/Reference:
<br/>

<strong>Q31: package*******************</strong>
Click the Exhibit button. Given the fully-qualified class names:
com.foo.bar.Dog
com.foo.bar.blatz.Book
com.bar.Car
com.bar.blatz.Sun
Which graph represents the correct directory structure for a JAR file from which those classes can be used by the compiler and JVM?
<a href="http://blog.shubozhang.com/?attachment_id=795#main" rel="attachment wp-att-795"><img src="http://blog.shubozhang.com/wp-content/uploads/2014/02/exam.jpg" alt="exam" width="730" height="555" class="alignnone size-full wp-image-795" /></a>

A. Jar A
B. Jar B
C. Jar C
D. Jar D
E. Jar E
Answer: A
Explanation/Reference:
<br/>


<strong>Q39: package**********</strong>
Given classes defined in two different files:
[java]
package util;
public class BitUtils {
public static void process(byte[] b) { /* more code here */ }
}
1. package app;
2.
3. public class SomeApp {
4. public static void main(String[] args) {
5. byte[] bytes = new byte[256];
6. // insert code here
7. }
8. }
[/java]
What is required at line 6 in class SomeApp to use the process method of BitUtils?
A. process(bytes);
B. BitUtils.process(bytes);
C. util.BitUtils.process(bytes);
D. SomeApp cannot use methods in BitUtils.
E. import util.BitUtils.*;
process(bytes);
Answer: C
Explanation/Reference: the method is public, so you cannot use import. 
<br/>


<strong>Q44: package****************************</strong>
Given classes defined in two different files:
[java]
package util;
public class BitUtils {
private static void process(byte[] b) {}
}
01. package app;
02. public class SomeApp {
03. public static void main(String[] args) {
04. byte[] bytes = new byte[256];
05. // insert code here
06. }
07. }
[/java]
What is required at line 5 in class SomeApp to use the process method of BitUtils?
A. process(bytes);
B. BitUtils.process(bytes);
C. app.BitUtils.process(bytes);
D. util.BitUtils.process(bytes);
E. import util.BitUtils.*;
process(bytes);
F. SomeApp cannot use the process method in BitUtils.
Answer: F
Explanation/Reference:
<br/>

<strong>Q59: package********************</strong>
Given a correctly compiled class whose source code is:
[java]
1. package com.sun.sjcp;
2.
3. public class Commander {
4. public static void main(String[] args) {
5. // more code here
6. }
7. }
[/java]
Assume that the class file is located in /foo/com/sun/sjcp/, the current directory is /foo/, and that the classpath contains "." (current directory). Which command line correctly runs Commander?
A. java Commander
B. java com.sun.sjcp.Commander
C. java com/sun/sjcp/Commander
D. java -cp com.sun.sjcp Commander
E. java -cp com/sun/sjcp Commander
Answer: B
Explanation/Reference:
<br/>

<strong>Q14: package / inner class *****************</strong>
[java]
package geometry;
public class Hypotenuse {
public InnerTriangle it = new InnerTriangle();
class InnerTriangle {
public int base;
public int height;
}
}
[/java]
Which statement is true about the class of an object that can reference the variable base?
A. It can be any class.
B. No class has access to base.
C. The class must belong to the geometry package.
D. The class must be a subclass of the class Hypotenuse.
Answer: C
Explanation/Reference:
<br/>


<strong>Q49: package******</strong>
A developer is creating a class Book, that needs to access class Paper. The Paper class is deployed in a JAR named myLib.jar. Which three, taken independently, will allow the developer to use the Paper class while compiling the Book class? (Choose three.)
A. The JAR file is located at $JAVA_HOME/jre/classes/myLib.jar.
B. The JAR file is located at $JAVA_HOME/jre/lib/ext/myLib.jar..
C. The JAR file is located at /foo/myLib.jar and a classpath environment variable is set that includes /foo/ myLib.jar/Paper.class.
D. The JAR file is located at /foo/myLib.jar and a classpath environment variable is set that includes /foo/ myLib.jar.
E. The JAR file is located at /foo/myLib.jar and the Book class is compiled using javac - cp /foo/myLib.jar/ Paper Book.java.
F. The JAR file is located at /foo/myLib.jar and the Book class is compiled using javac -d /foo/myLib.jar Book.java
G. The JAR file is located at /foo/myLib.jar and the Book class is compiled using javac - classpath /foo/ myLib.jar Book.java
Answer: BDG
Explanation/Reference:
<br/>


<strong>Q53: package********</strong>
[java]
package com.company.application;
public class MainClass {
public static void main(String[] args) {
}
}
[java]
and MainClass exists in the /apps/com/company/application directory. Assume the CLASSPATH environment variable is set to "." (current directory). Which two java commands entered at the command line will run MainClass? (Choose two.)
A. java MainClass if run from the /apps directory
B. java com.company.application.MainClass if run from the /apps directory
C. java -classpath /apps com.company.application.MainClass if run from any directory
D. java -classpath . MainClass if run from the /apps/com/company/application directory
E. java -classpath /apps/com/company/application:. MainClass if run from the /apps directory
F. java com.company.application.MainClass if run from the /apps/com/company/application directory
Answer: BC
Explanation/Reference:
<br/>


### Others
<strong>Q12: main</strong>
[java]
 public class Mud {
 //insert code here
 System.out.println("hi");
 }
 }
[/java]
And the following five fragments:
[java]
public static void main(String...a) {
public static void main(String.* a) {
public static void main(String... a) {
public static void main(String[]... a) {
public static void main(String...[] a) {
[/java]
How many of the code fragments, inserted independently at line 2, compile?
<ul>A. 0</ul>
<ul>B. 1</ul>
<ul>C. 2</ul>
<ul>D. 3</ul>
<ul>E. 4</ul>
<ul>F. 5</ul>
Answer: D
Explanation/Reference:
public static void main(String...a) {
public static void main(String... a) {
public static void main(String[]... a) {
<br/>

<strong>Q25: Other******************</strong>
Given a valid DateFormat object named df, and
[java]
16. Date d = new Date(0L);
17. String ds = "December 15, 2004";
18. //insert code here
[/java]
What updates d's value with the date represented by ds?
<ul>A. d = df.parse(ds);</ul>
<ul>B. d = df.getDate(ds);</ul>
<ul>C. try {
d = df.parse(ds);
} catch(ParseException e) { };</ul>
<ul>D. try {
d = df.getDate(ds);
} catch(ParseException e) { };</ul>
Answer: C
Explanation/Reference:
<br/>

<strong>Q26: Other*******************</strong>
[java]
11. double input = 314159.26;
12. NumberFormat nf = NumberFormat.getInstance(Locale.ITALIAN);
13. String b;
14. //insert code here
[/java]
Which code, inserted at line 14, sets the value of b to 314.159,26?
<ul>A. b = nf.parse( input );</ul>
<ul>B. b = nf.format( input );</ul>
<ul>C. b = nf.equals( input );</ul>
<ul>D. b = nf.parseObject( input );</ul>
Answer: B
Explanation/Reference:
<br/>


<strong>Q37: other************</strong>
[java]
01. public class LineUp {
02. public static void main(String[] args) {
03. double d = 12.345;
04. // insert code here
05. }
06. }
[/java]
Which code fragment, inserted at line 4, produces the output | 12.345|?
<ul>A. System.out.printf("|%7d| \n", d);</ul>
<ul>B. System.out.printf("|%7f| \n", d);</ul>
<ul>C. System.out.printf("|%3.7d| \n", d);</ul>
<ul>D. System.out.printf("|%3.7f| \n", d);</ul>
<ul>E. System.out.printf("|%7.3d| \n", d);</ul>
<ul>F. System.out.printf("|%7.3f| \n", d);</ul>
Answer: F
Explanation/Reference:
<br/>

<strong>Q38: other</strong>
[java]
11. public class Test {
12. public static void main(String [] args) {
13. int x = 5;
14. boolean b1 = true;
15. boolean b2 = false;
16.
17. if ((x == 4) && !b2 )
18. System.out.print("1 ");
19. System.out.print("2 ");
20. if ((b2 = true) && b1 )
21. System.out.print("3 ");
22. }
23. }
[/java]
What is the result?
<ul>A. 2</ul>
<ul>B. 3</ul>
<ul>C. 1 2</ul>
<ul>D. 2 3</ul>
<ul>E. 1 2 3</ul>
<ul>F. Compilation fails.</ul>
<ul>G. An exception is thrown at runtime.</ul>
Answer: D
Explanation/Reference: Difference between &&, || and &, |. For &&, ||, if the left side is determined, the right side won't be executed. But &, | always run check two sides.
<br/>

<strong>Q40: other / break</strong>
[java]
public void go() {
String o = "";
z:
for(int x = 0; x < 3; x++) {
for(int y = 0; y < 2; y++) {
if(x==1) break;
if(x==2 && y==1) break z;
o = o + x + y;
}
}
System.out.println(o);
}
[/java]
What is the result when the go() method is invoked?
<ul>A. 00</ul>
<ul>B. 0001</ul>
<ul>C. 000120</ul>
<ul>D. 00012021</ul>
<ul>E. Compilation fails.</ul>
<ul>F. An exception is thrown at runtime.</ul>
Answer: C
Explanation/Reference:
	<li>An unlabeled break statement terminates the innermost switch, for, while, or do-while statement, but a labeled break terminates an outer statement. The following program, BreakWithLabelDemo, is similar to the previous program, but uses nested for loops to search for a value in a two-dimensional array. When the value is found, a labeled break terminates the outer for loop (labeled "search"):</li>
	<li>A labeled continue statement skips the current iteration of an outer loop marked with the given label. The following example program, ContinueWithLabelDemo, uses nested loops to search for a substring within another string. Two nested loops are required: one to iterate over the substring and one to iterate over the string being searched. The following program, ContinueWithLabelDemo, uses the labeled form of continue to skip an iteration in the outer loop.</li>
<br/>

<strong>Q43: other / do while</strong>
[java]
int x = 0;
int y = 10;
do {
y--;
++x;
} while (x < 5);
System.out.print(x + "," + y);
[/java]
What is the result?
<ul>A. 5,6</ul>
<ul>B. 5,5</ul>
<ul>C. 6,5</ul>
<ul>D. 6,6</ul>
Answer: B
Explanation/Reference:
<br/>

<strong>Q47: Other / object initialization</strong>
[java]
01. public class Boxer1{
02. Integer i;
03. int x;
04. public Boxer1(int y) {
05. x = i+y;
06. System.out.println(x);
07. }
08. public static void main(String[] args) {
09. new Boxer1(new Integer(4));
10. }
11. }
[/java]
What is the result?
<ul>A. The value "4" is printed at the command line.</ul>
<ul>B. Compilation fails because of an error in line 5.</ul>
<ul>C. Compilation fails because of an error in line 9.</ul>
<ul>D. A NullPointerException occurs at runtime.</ul>
<ul>E. A NumberFormatException occurs at runtime.</ul>
<ul>F. An IllegalStateException occurs at runtime.</ul>
Answer: D
Explanation/Reference:
	<li>D: The object references are all initialized to null in Java. However in order to do anything useful with these references, you must set them to a valid object, else you will get <strong>NullPointerException</strong> everywhere you try to use such default initialized references.</li>
	<li>E: <strong>NumberFormatException</strong> Thrown to indicate that the application has attempted to convert a string to one of the numeric types, but that the string does not have the appropriate format.</li>
	<li>F: <strong>IllegalStateException</strong> Signals that a method has been invoked at an illegal or inappropriate time. In other words, the Java environment or Java application is not in an appropriate state for the requested operation.</li>
<br/>

<strong>Q49: other / hashCode()************</strong>
Which two statements are true about the hashCode method? (Choose two.)
<ul>A. The hashCode method for a given class can be used to test for object equality and object inequality for that class.</ul>
<ul>B. The hashCode method is used by the java.util.SortedSet collection class to order the elements within that set.</ul>
<ul>C. The hashCode method for a given class can be used to test for object inequality, but NOT object equality, for that class.</ul>
<ul>D. The only important characteristic of the values returned by a hashCode method is that the distribution of values must follow a Gaussian distribution.</ul>
<ul>E. The hashCode method is used by the java.util.HashSet collection class to group the elements within that set into hash buckets for swift retrieval.</ul>
Answer: CE
Explanation/Reference:
	<li>Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application.</li>

	<li>If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.</li>

	<li>It is not required that if two objects are unequal according to the equals(java.lang.Object) method, then calling the hashCode method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.</li>

<br/>

<strong>Q50: Generic / unchecked warning</strong>
Given a pre-generics implementation of a method:
[java]
11. public static int sum(List list) {
12. int sum = 0;
13. for ( Iterator iter = list.iterator(); iter.hasNext(); ) {
14. int i = ((Integer)iter.next()).intValue();
15. sum += i;
16. }
17. return sum;
18. }
[/java]
What three changes allow the class to be used with generics and avoid an unchecked warning? (Choose three.)
<ul>A. Remove line 14.</ul>
<ul>B. Replace line 14 with int i = iter.next();</ul>
<ul>C. Replace line 13 with for (int i : intList) {</ul>
<ul>D. Replace line 13 with for (Iterator iter : intList) {</ul>
<ul>E. Replace the method declaration with sum(List<int> intList)</ul>
<ul>F. Replace the method declaration with sum(List<Integer> intList)</ul>
Answer: ACF
Explanation/Reference:
A: Correct?
B: int i =iter.next().intValue(); convert Integer to int, so B is wrong.
D: the enhanced for loop format is wrong.
E: List<object>, int is premitive type, so E is wrong.
F: is correct.
<br/>


<strong>Q57: other / variable scope</strong>
[java]
public class Batman {
int squares = 81;
public static void main(String[] args) {
new Batman().go();
}
void go() {
incr(++squares);
System.out.println(squares);
}
void incr(int squares) { squares += 10; }
}
[/java]
What is the result?
<ul>A. 81</ul>
<ul>B. 82</ul>
<ul>C. 91</ul>
<ul>D. 92</ul>
<ul>E. Compilation fails.</ul>
<ul>F. An exception is thrown at runtime.</ul>
Answer: B
Explanation/Reference: Java is pass by value.
<br/>

<strong>Q58: other</strong>
[java]
public class Yippee {
public static void main(String [] args) {
for(int x = 1; x < args.length; x++) {
System.out.print(args[x] + " ");
}
}
}
and two separate command line invocations:
java Yippee
java Yippee 1 2 3 4
[/java]
What is the result?
<ul>A. No output is produced.
1 2 3</ul>
<ul>B. No output is produced.
2 3 4</ul>
<ul>C. No output is produced.
1 2 3 4</ul>
<ul>D. An exception is thrown at runtime.
1 2 3</ul>
<ul>E. An exception is thrown at runtime.
2 3 4</ul>
<ul>F. An exception is thrown at runtime.
1 2 3 4</ul>
Answer: B
Explanation/Reference: Four elements and index from 1.
<br/>

<strong>Q59: other / variable scope</strong>
[java]
public class Pass {
public static void main(String [] args) {
int x = 5;
Pass p = new Pass();
p.doStuff(x);
System.out.print(" main x = " + x);
}
void doStuff(int x) {
System.out.print(" doStuff x = " + x++);
}
}
[/java]
What is the result?
<ul>A. Compilation fails.</ul>
<ul>B. An exception is thrown at runtime.</ul>
<ul>C. doStuff x = 6 main x = 6</ul>
<ul>D. doStuff x = 5 main x = 5</ul>
<ul>E. doStuff x = 5 main x = 6</ul>
<ul>F. doStuff x = 6 main x = 5</ul>
Answer: D
Explanation/Reference: Java is pass-by-value.
<br/>

<strong>Q30: other</strong>
[java]
35. String #name = "Jane Doe";
36. int $age = 24;
37. Double _height = 123.5;
38. double ~temp = 37.5;
[/java]
Which two statements are true? (Choose two.)
A. Line 35 will not compile.
B. Line 36 will not compile.
C. Line 37 will not compile.
D. Line 38 will not compile.
Answer: AD
Explanation/Reference: name can only start with letter, _, and $.
<br/>

<strong>Q35: other / GUI</strong>
Given the following six method names:
addListener
addMouseListener
setMouseListener
deleteMouseListener
removeMouseListener
registerMouseListener
How many of these method names follow JavaBean Listener naming rules?
A. 1
B. 2
C. 3
D. 4
E. 5
Answer: B
Explanation/Reference:
Listener method names used to "register" a listener with an event source must use the prefix add , followed by the listener type. For example, addActionzistener() is a valid name for a method that an event source will have to allow others to register for Action events. Listener method names used to remove ("unregister") a listener must use the prefix remove , followed by the listener type (using the same rules as the registration add method).
<br/>

<strong>Q43: other</strong>
[java]
public static void test(String str) {
int check = 4;
if (check = str.length()) {
System.out.print(str.charAt(check -= 1) +", ");
} else {
System.out.print(str.charAt(0) + ", ");
}
}
and the invocation:
test("four");
test("tee");
test("to");
[/java]
What is the result?
A. r, t, t,
B. r, e, o,
C. Compilation fails.
D. An exception is thrown at runtime.
Answer: C
Explanation/Reference:
<br/>

<strong>Q54: other / switch</strong>
[java]
11. public static void main(String[] args) {
12. Integer i = new Integer(1) + new Integer(2);
13. switch(i) {
14. case 3: System.out.println("three"); break;
15. default: System.out.println("other"); break;
16. }
17. }
[/java]
What is the result?
A. three
B. other
C. An exception is thrown at runtime.
D. Compilation fails because of an error on line 12.
E. Compilation fails because of an error on line 13.
F. Compilation fails because of an error on line 15.
Answer: A
Explanation/Reference:
<br/>


<strong>Q57: other / Date</strong>
1. d is a valid, non-null Date object
2. df is a valid, non-null DateFormat object set to the current locale
What outputs the current locale's country name and the appropriate version of d's date?
A. Locale loc = Locale.getLocale();
System.out.println(loc.getDisplayCountry()
+ " " + df.format(d));
B. Locale loc = Locale.getDefault();
System.out.println(loc.getDisplayCountry()
+ " " + df.format(d));
C. Locale loc = Locale.getLocale();
System.out.println(loc.getDisplayCountry()
+ " " + df.setDateFormat(d));
D. Locale loc = Locale.getDefault();
System.out.println(loc.getDisplayCountry()
+ " " + df.setDateFormat(d));
Answer: B
Explanation/Reference:
	<li>There is no getLocale method in class Locale.</li>

	<li>public static Locale getDefault()
Gets the current value of the default locale for this instance of the Java Virtual Machine.</li>

	<li>The Java Virtual Machine sets the default locale during startup based on the host environment. It is used by
many locale-sensitive methods if no locale is explicitly specified. It can be changed using the setDefault
method.</li>

	<li>Returns:
the default locale for this instance of the Java Virtual Machine
</li>
<br/>

<strong>Q1: Other / Date</strong>
[java]
import java.util.Date;
import java.text.DateFormat;
21. DateFormat df;
22. Date date = new Date();
23. //insert code here
24. String s = df.format(date);
[/java]
Which code fragment, inserted at line 23, allows the code to compile?
A. df = new DateFormat();
B. df = Date.getFormat();
C. df = date.getFormat();
D. df = DateFormat.getFormat();
E. df = DateFormat.getInstance();
Answer: E
Explanation/Reference:
<br/>
<strong>Q2: other / boolean</strong>
[java]
public class BuildStuff {
public static void main(String[] args) {
Boolean test = new Boolean(true);
Integer x = 343;
Integer y = new BuildStuff().go(test, x);
System.out.println(y);
}
int go(Boolean b, int i) {
if(b) return (i/7);
return (i/49);
}
}
[/java]
What is the result?
A. 7
B. 49
C. 343
D. Compilation fails.
E. An exception is thrown at runtime.
Answer: B
Explanation/Reference:
<br/>

<strong>Q38: other/break</strong>
public class Breaker {
static String o = "";
public static void main(String[] args) {
z: o = o + 2;
for (int x = 3; x < 8; x++) {
if (x == 4)
break;
if (x == 6)
break z;
o = o + x;
}
System.out.println(o);
}
}
What is the result?
A. 23
B. 234
C. 235
D. 2345
E. 2357
F. 23457
G. Compilation fails.
Answer: G
Explanation/Reference: Label placed incorrectly. Labeled break must be placed right before the outer loop.
<br/>


<strong>Q41: other / variable scope</strong>
public static void main(String[] args) {
for (int i = 0; i <= 10; i++) {
if (i > 6) break;
}
System.out.println(i);
}
What is the result?
A. 6
B. 7
C. 10
D. 11
E. Compilation fails.
F. An exception is thrown at runtime.
Answer: E
Explanation/Reference: i variable is not visible.
<br/>

<strong>Q47: other / command*****************</strong>
[java]
12. public class Commander {
13. public static void main(String[] args) {
14. String myProp = /* insert code here */
15. System.out.println(myProp);
16. }
17. }
and the command line: java -Dprop.custom=gobstopper Commander
[/java]
Which two, placed on line 13, will produce the output gobstopper? (Choose two.)
A. System.load("prop.custom");
B. System.getenv("prop.custom");
C. System.property("prop.custom");
D. System.getProperty("prop.custom");
E. System.getProperties().getProperty("prop.custom");
Answer: DE
Explanation/Reference:
<br/>
