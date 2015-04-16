1. Singleton 
2. Simple Factory 
3. Factory Method  
4. Abstract Factory 
5. MVC 
6. DAO 
7. Proxy, 
8. Front Controller 
9. Intercepting Filter 
10. Service Locator 
11. Business Delegate 
12. Session Facade 
13. Facade 
 
1. Singleton: 
 
First: lazy instantiation, thread unsafe 
public class Singleton {   
    private static Singleton instance;   
    private Singleton (){}   
   
    public static Singleton getInstance() {   
    if (instance == null) {   
        instance = new Singleton();   
    }   
    return instance;   
    }   
}   
  
Second: Lazy instantiation, thread safe 
public class Singleton {   
    private static Singleton instance;   
    private Singleton (){}   
    public static synchronized Singleton getInstance() {   
    if (instance == null) {   
        instance = new Singleton();   
    }   
    return instance;   
    }   
}   
 It has low efficient. 
 
Third：eager instantiation 
public class Singleton {   
    private static Singleton instance = new Singleton();   
    private Singleton (){}   
    public static Singleton getInstance() {   
    return instance;   
    }   
}   
  
 这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用getInstance方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化instance显然没有达到lazy loading的效果。 
Fourth: eager instantiation 2： 
public class Singleton {   
    private Singleton instance = null;   
    static {   
    instance = new Singleton();   
    }   
    private Singleton (){}   
    public static Singleton getInstance() {   
    return this.instance;   
    }   
}   
  
 表面上看起来差别挺大，其实更第三种方式差不多，都是在类初始化即实例化instance。 
Fifth:（静态内部类）： 
public class Singleton {   
    private static class SingletonHolder {   
    private static final Singleton INSTANCE = new Singleton();   
    }   
    private Singleton (){}   
    public static final Singleton getInstance() {   
    return SingletonHolder.INSTANCE;   
    }   
}   
  
这种方式同样利用了classloder的机制来保证初始化instance时只有一个线程，它跟第三种和第四种方式不同的是（很细微的差别）：第三种和第四种方式是只要Singleton类被装载了，那么instance就会被实例化（没有达到lazy loading效果），而这种方式是Singleton类被装载了，instance不一定被初始化。因为SingletonHolder类没有被主动使用，只有显示通过调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance。想象一下，如果实例化instance很消耗资源，我想让他延迟加载，另外一方面，我不希望在Singleton类加载时就实例化，因为我不能确保Singleton类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化instance显然是不合适的。这个时候，这种方式相比第三和第四种方式就显得很合理。 
第六种（枚举）： 
public enum Singleton {   
    INSTANCE;   
    public void whateverMethod() {   
    }   
}   
  
 这种方式是Effective Java作者Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象，可谓是很坚强的壁垒啊，不过，个人认为由于1.5中才加入enum特性，用这种方式写不免让人感觉生疏，在实际工作中，我也很少看见有人这么写过。 
第七种（双重校验锁）： 
public class Singleton {   
    private volatile static Singleton singleton;   
    private Singleton (){}   
    public static Singleton getSingleton() {   
    if (singleton == null) {   
        synchronized (Singleton.class) {   
        if (singleton == null) {   
            singleton = new Singleton();   
        }   
        }   
    }   
    return singleton;   
    }   
}   
  
 这个是第二种方式的升级版，俗称双重检查锁定 
在JDK1.5之后，双重检查锁定才能够正常达到单例效果。 
  
总结 
有两个问题需要注意： 
1.如果单例由不同的类装载器装入，那便有可能存在多个单例类的实例。假定不是远端存取，例如一些servlet容器对每个servlet使用完全不同的类装载器，这样的话如果有两个servlet访问一个单例类，它们就都会有各自的实例。 
2.如果Singleton实现了java.io.Serializable接口，那么这个类的实例就可能被序列化和复原。不管怎样，如果你序列化一个单例类的对象，接下来复原多个那个对象，那你就会有多个单例类的实例。 
对第一个问题修复的办法是： 
  
Java代码  Image 
private static Class getClass(String classname)       
                                         throws ClassNotFoundException {      
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();      
       
      if(classLoader == null)      
         classLoader = Singleton.class.getClassLoader();      
       
      return (classLoader.loadClass(classname));      
   }      
}   
 对第二个问题修复的办法是： 
  
Java代码   
public class Singleton implements java.io.Serializable {      
   public static Singleton INSTANCE = new Singleton();      
       
   protected Singleton() {      
         
   }      
   private Object readResolve() {      
            return INSTANCE;      
      }     
}    
  
对我来说，我比较喜欢第三种和第五种方式，简单易懂，而且在JVM层实现了线程安全（如果不是多个类加载器环境），一般的情况下，我会使用第三种方式，只有在要明确实现lazy loading效果时才会使用第五种方式，另外，如果涉及到反序列化创建对象时我会试着使用枚举的方式来实现单例，不过，我一直会保证我的程序是线程安全的，而且我永远不会使用第一种和第二种方式，如果有其他特殊的需求，我可能会使用第七种方式，毕竟，JDK1.5已经没有双重检查锁定的问题了。 
======================================================================== 
 superheizai同学总结的很到位： 
  
不过一般来说，第一种不算单例，第四种和第三种就是一种，如果算的话，第五种也可以分开写了。所以说，一般单例都是五种写法。懒汉，恶汉，双重校验锁，枚举和静态内部类。 
我很高兴有这样的读者，一起共勉。 
 
. 工厂模式：主要用来实例化有共同接口的类，工厂模式可以动态决定应该实例化那一个类。  
工厂模式的形态  
工厂模式主要用一下几种形态：  
1：简单工厂（Simple Factory）。  
2：工厂方法（Factory Method）。  
3：抽象工厂（Abstract Factory）。  
 
2. Simple Factory  
又叫静态工厂，是工厂模式三中状态中结构最为简单的。主要有一个静态方法，用来接受参数，并根据参数来决定返回实现同一接口的不同类的实例。我们来看一个具体的例子：  
假设一家工厂，几生产洗衣机，有生产冰箱，还有空调等等..  
我们先为所有产品定义一个共同的产品接口  
Java代码   
public interface Product{}   
 
接着我们让这个工厂的所有产品都必须实现此接口  
Java代码   
public class Washer implements Product{   
   public Washer(){   
       System.out.println("洗衣机被制造了");   
   }   
}   
   
public class Icebox implements Product{   
   public Icebox(){   
       System.out.println("冰箱被制造了");   
   }   
}   
   
public class AirCondition implements Product{   
   public Icebox(){   
       System.out.println("空调被制造了");   
   }   
}   
 
接下来我们来写一个工厂类，有它来负责生产以上的产品  
Java代码   
public class SimpleFactory {   
       
    public static Product factory(String productName) throws Exception{   
        if(productName.equals("Washer")){   
            return new Washer();   
        }else if(productName.equals("Icebox")){   
            return new Icebox();   
        }else if(productName.equals("AirCondition")){   
            return new AirCondition();   
        }else{   
            throw new Exception("没有该产品");   
        }   
    }   
}   
 
好了，有了这个工厂类，我们就可以开始下定单了，SimpleFactory将根据不同的定单类决定生产什么产品。  
Java代码   
public static void main(String[] args) {   
    try {   
              SimpleFactory.factory("Washer");   
              SimpleFactory.factory("Icebox");   
              SimpleFactory.factory("AirCondition");   
            } catch (Exception e) {   
        e.printStackTrace();   
    }   
}   
 
由上面的代码可以看出，简单工厂的核心就是一个SimpleFactory类，他拥有必要的逻辑判断能力和所有产品的创建权利，我们只需要向把定单给他，就能得到我们想要的产品。这使用起来似乎非常方便。  
但，实际上，这个SimpleFactory有很多的局限。首先，我们每次想要增加一种新产品的时候，都必须修改SimpleFactory的原代码。其次，当我们拥有很多很多产品的时候，而且产品之间又存在复杂的层次关系的时候，这个类必须拥有复杂的逻辑判断能力，其代码量也将不断地激增，这对以后的维护简直就是恐怖两个字...  
还有就是，整个系统都严重依赖SimpleFactory类，只要SimpleFactory类一出问题，系统就进入不能工作的状态，这也是最为致命的一点....  
以上的不足将在工厂模式的另外两种状态中得到解决。  
 
3. Factory Method  
上面的代码告诉我们，简单工厂并不简单，它是整个模式的核心，一旦他出了问题，整个模式都将受影响而不能工作，为了降低风险和为日后的维护、扩展做准备，我们需要对它进行重构，引入工厂方法。  
工厂方法为工厂类定义了接口，用多态来削弱了工厂类的职能，以下是工厂接口的定义：  
Java代码   
public interface Factory{   
  public Product create();   
}   
 
我们再来定义一个产品接口  
Java代码   
public interface Product{}   
 
一下是实现了产品接口的产品类  
Java代码   
public class Washer implements Product{   
   public Washer(){   
       System.out.println("洗衣机被制造了");   
   }   
}   
   
public class Icebox implements Product{   
   public Icebox(){   
       System.out.println("冰箱被制造了");   
   }   
}   
   
public class AirCondition implements Product{   
   public Icebox(){   
       System.out.println("空调被制造了");   
   }   
}   
 
接下来，就是工厂方法的核心部分，也就是具体创建产品对象的具体工厂类，  
Java代码   
//创建洗衣机的工厂   
public class CreateWasher implements Factory{   
    public Product create(){   
          return new Washer();   
    }   
}   
   
//创建冰箱的工厂   
public class CreateIcebox implements Factory{   
    public Product create(){   
          return new Icebox();   
    }   
}   
   
//创建空调的工厂   
public class CreateAirCondition implements Factory{   
    public Product create(){   
          return new AirCondition();   
    }   
}   
 
从上面创建产品对象的代码可以看出，工厂方法和简单工厂的主要区别是，简单工厂是把创建产品的职能都放在一个类里面，而工厂方法则把不同的产品放在实现了工厂接口的不同工厂类里面，这样就算其中一个工厂类出了问题，其他工厂类也能正常工作，互相不受影响，以后增加新产品，也只需要新增一个实现工厂接口工厂类，就能达到，不用修改已有的代码。但工厂方法也有他局限的地方，那就是当面对的产品有复杂的等级结构的时候，例如，工厂除了生产家电外产品，还生产手机产品，这样一来家电是手机就是两大产品家族了，这两大家族下面包含了数量众多的产品，每个产品又有多个型号，这样就形成了一个复杂的产品树了。如果用工厂方法来设计这个产品家族系统，就必须为每个型号的产品创建一个对应的工厂类，当有数百种甚至上千种产品的时候，也必须要有对应的上百成千个工厂类，这就出现了传说的类爆炸，对于以后的维护来说，简直就是一场灾难.....  
 
4. Abstract Factory Method  
抽象工厂：意的意图在于创建一系列互相关联或互相依赖的对象。<<Java设计模式>>  
我自己觉得抽象工厂是在工厂方法的基础上引进了分类管理的概念....  
工厂方法用来创建一个产品，它没有分类的概念，而抽象工厂则用于创建一系列产品，所以产品分类成了抽象工厂的重点，  
我们继续用上面的例子来说明：  
工厂生产的所有产品都用都用大写字母来标明它们的型号，比如冰箱，就有“冰箱-A",“冰箱-B",同样，其他的产品也都是遵守这个编号规则，于是就有了一下产品家族树  
 
冰箱：  
 
  冰箱-A 
  冰箱-B 
 
 
洗衣机：  
 
  洗衣机-A 
  洗衣机-B 
 
我们可以为冰箱和洗衣机分别定义两个产品接口，以对他们进行分类，  
Java代码  Image 
//洗衣机接口   
public interface Washer{   
}   
   
//冰箱接口   
public interface Icebox{   
}   
 
接着，我们分别创建这两个接口的具体产品  
Java代码  Image 
//洗衣机-A   
public class WasherA implements Washer{   
   public WasherA(){   
       System.out.println("洗衣机-A被制造了");   
   }   
}   
   
//洗衣机-B   
public class WasherB implements Washer{   
   public WasherB(){   
       System.out.println("洗衣机-B被制造了");   
   }   
}   
   
//冰箱-A   
public class IceboxA implements Icebox{   
   public IceboxA(){   
       System.out.println("冰箱-A被制造了");   
   }   
}   
   
//冰箱-B   
public class IceboxB implements Icebox{   
   public IceboxB(){   
       System.out.println("冰箱-B被制造了");   
   }   
}   
 
到此，产品部分我们准备好了，接下来我们来处理工厂部分，我们先来定义工厂行为接口  
Java代码  Image 
public interface Factory{   
       public Washer createWasher();   
       public Icebox createIcebox();   
}   
 
接下来我创造具体的工厂类，我们根据上面产品的接口，把型号A的产品分为一类，由一个工厂来管理，把型号为B的产品有另一个工厂管理，根据这个分类，我们可以实现如下的两个具体工厂类  
Java代码  Image 
//创建型号为A的产品工厂   
public class FactoryA implements Factory{   
       //创建洗衣机-A   
       public Washer createWasher(){   
            return new WasherA();   
       }   
   
       //创建冰箱-A   
       public Icebox createIcebox(){   
            return new IceboxA();   
       }   
}   
   
//创建型号为B的产品工厂   
public class FactoryB implements Factory{   
       //创建洗衣机-B   
       public Washer createWasher(){   
            return new WasherB();   
       }   
   
       //创建冰箱-B   
       public Icebox createIcebox(){   
            return new IceboxB();   
       }   
}   
 
这样，我们的抽象工厂就完成了。有上面可以看出，在运用上我觉得工厂方法和抽象工厂，都有自己的应用场景，并没有什么优劣之分，但在应用抽象工厂之前，要先对创建的对象进行系统的分类，这点很重要，好的产品分类规则能为具体工厂类的选择调用和以后的扩展提供清晰的思路. 
 
 
4. facade ? 
    A facade is an object that provides a simplified interface to a larger body of code, such as a class library 
 
5 MVC design pattern  
It divides a given software application into three interconnected parts, so as to separate internal representations of information from the ways that information is presented to or accepted from the user.The central component, the model, consists of application data, business rules, logic and functions. A view can be any output representation of information, such as a chart or a diagram. Multiple views of the same information are possible, such as a bar chart for management and a tabular view for accountants. The third part, the controller, accepts input and converts it to commands for the model or view. 
 
6 DAO 
 is an object that provides an abstract interface to some type of database or other persistence mechanism. By mapping application calls to the persistence layer, DAO provide some specific data operations without exposing details of the database. This isolation supports the Single responsibility principle. It separates what data accesses the application needs 
 
7 proxy 
Provide a surrogate or placeholder for another object to control access to it. Use an extra level of indirection to support distributed, controlled, or intelligent access.Add a wrapper and delegation to protect the real component from undue complexity. 
8 Front Controller 
 
The front controller may be implemented as a Java object which would handle all tasks that are common to the application or the framework, such as session handling, caching, and input filtering. Based on the specific request, it would then instantiate further objects and call methods to handle the particular task(s) required. 
