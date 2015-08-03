6、说出数据连接池的工作机制是什么?


J2EE 服务器启动时会建立一定数量的池连接，并一直维持不少于此数目的池连接。客 户端程序需要连接时，池驱动程序会返回一个未使用的池连接并将其表记为忙。如果 
当前没有空闲连接，池驱动程序就新建一定数量的连接，新建连接的数量有配置参数 决定。当使用的池连接调用完成后，池驱动程序将此连接表记为空闲，其他调用就可 以使用这个连接。
实现方式，返回的 Connection 是原始 Connection 的代理，代理 Connection 的 close 方法 不是真正关连接，而是把它代理的 Connection 
对象还回到连接池中。



、为什么要用 ORM?  和 JDBC 有何不一样?


orm 是一种思想，就是把 object 转变成数据库中的记录，或者把数据库中的记录转变成 objecdt，我们可以用 jdbc 来实现这种思想，其实，如果我们的项目是严格按照 oop 方 
式编写的话，我们的 jdbc 程序不管是有意还是无意，就已经在实现 orm 的工作了。 现在有许多 orm 工具，它们底层调用 jdbc 来实现了 orm 工作，我们直接使用这些工具， 
就省去了直接使用 jdbc 的繁琐细节，提高了开发效率，现在用的较多的 orm 工具是 hibernate。也听说一些其他 orm 工具，如 toplink,ojb 等。



谈谈你对 Struts 的理解。
答:
1. struts 是一个按 MVC 模式设计的 Web 层框架，其实它就是一个大大的 servlet，这个 Servlet
名为 ActionServlet，或是 ActionServlet 的子类。我们可以在 web.xml 文件中将符合某种特征 的 所 有 请 求 交 给 这 个  Servlet  处理，这个  
Servlet  再 参 照 一 个 配 置 文 件 （ 通 常 为
/WEB-INF/struts-config.xml）将各个请求分别分配给不同的 action 去处理。 一个扩展知识点：struts 的配置文件可以有多个，可以按模块配置各自的配置文件，这样可 
以防止配置文件的过度膨胀；
2. ActionServlet 把请求交给 action 去处理之前，会将请求参数封装成一个 formbean 对象（就 是一个 java 
类，这个类中的每个属性对应一个请求参数），封装成一个什么样的 formbean 对象呢？看配置文件。
3.要说明的是， ActionServlet 把 formbean 对象传递给 action 的 execute 方法之前，可能会调 用 formbean 的 validate 
方法进行校验，只有校验通过后才将这个 formbean 对象传递给 action 的 execute 方法，否则，它将返回一个错误页面，这个错误页面由 input 属性指定，（看配置 
文件）作者为什么将这里命名为 input 属性，而不是 error 属性，我们后面结合实际的运行效
果进行分析。
4.action 执行完后要返回显示的结果视图，这个结果视图是用一个 ActionForward 对象来表 示的，actionforward 对象通过 struts-config.xml 
配置文件中的配置关联到某个 jsp 页面，因为 程序中使用的是在 struts-config.xml 配置文件为 jsp 页面设置的逻辑名，这样可以实现 action 程序代码与返回的 jsp 
页面名称的解耦。

你对 struts 可能还有自己的应用方面的经验，那也要一并说出来。

Struts 优缺点
优点：

1.  实现 MVC 模式，结构清晰,使开发者只关注业务逻辑的实现.
2．有丰富的 tag 可以用 ,Struts 的标记库(Taglib)，如能灵活动用，则能大大提高开发效率
3.  页面导航 使系统的脉络更加清晰。通过一个配置文件，即可把握整个系统各部分之间的联系，这
对于后期的维护有着莫大的好处。尤其是当另一批开发者接手这个项目时，这种优势体现得 更加明显。
4.  提供 Exception 处理机制 .
5.  数据库链接池管理
6.  支持 I18N
缺点
一、 转到展示层时，需要配置 forward，如果有十个展示层的 jsp，需要配置十次 struts，而 且还不包括有时候目录、文件变更，需要重新修改 forward，注意，每次修改配置之后， 
要求重新部署整个项目，而 tomcate 这样的服务器，还必须重新启动服务器
二、 二、 Struts 的 Action 必需是 thread－safe 方式，它仅仅允许一个实例去处理所有的请 求。所以 action 
用到的所有的资源都必需统一同步，这个就引起了线程安全的问题。
三、   测试不方便. Struts 的每个 Action 都同 Web 层耦合在一起，这样它的测试依赖于 Web 容器，单元测试也很难实现。不过有一个 Junit 的扩展工具 Struts 
TestCase 可以实现它 的单元测试。
四、   类型的转换.  Struts 的 FormBean 把所有的数据都作为 String 类型，它可以使用工具 Commons-Beanutils 进行类型转化。但它的转化都是在 Class 
级别，而且转化的类型是 不可配置的。类型转化时的错误信息返回给用户也是非常困难的。
五、 对  Servlet  的 依 赖 性 过 强 .  Struts  处理  Action  时 必 需 要 依 赖  ServletRequest  和
ServletResponse，所有它摆脱不了 Servlet 容器。
六、   前端表达式语言方面.Struts 集成了 JSTL，所以它主要使用 JSTL 的表达式语言来获取 数据。可是 JSTL 的表达式语言在 Collection 和索引属性方面处理显得很弱。
七、   对 Action 执行的控制困难.  Struts 创建一个 Action，如果想控制它的执行顺序将会非 常困难。甚至你要重新去写 Servlet 来实现你的这个功能需求。
八、   对 Action  执行前和后的处理. Struts 处理 Action 的时候是基于 class 的 hierarchies，很 难在 action 处理前和后进行操作。
九、   对 事 件 支 持 不 够 .  在  struts  中 ， 实 际 是 一 个 表 单  Form  对 应 一 个  Action  类 ( 或 
DispatchAction)，换一句话说：在 Struts 中实际是一个表单只能 对应一个事件，struts 这种事件方式称为 application event，application 
event 和 component event 相比是一种 粗粒度的事件


2、谈谈你对 Hibernate 的理解。
答:
1. 面向对象设计的软件内部运行过程可以理解成就是在不断创建各种新对象、建立对象之 间的关系，调用对象的方法来改变各个对象的状态和对象消亡的过程，不管程序运行的过程 
和操作怎么样，本质上都是要得到一个结果，程序上一个时刻和下一个时刻的运行结果的差 异就表现在内存中的对象状态发生了变化。
2.为了在关机和内存空间不够的状况下，保持程序的运行状态，需要将内存中的对象状态保 存到持久化设备和从持久化设备中恢复出对象的状态，通常都是保存到关系数据库来保存大 量对象信息。从 Java 
程序的运行功能上来讲，保存对象状态的功能相比系统运行的其他功 能来说，应该是一个很不起眼的附属功能，java 采用 jdbc 来实现这个功能，这个不起眼的 
功能却要编写大量的代码，而做的事情仅仅是保存对象和恢复对象，并且那些大量的 jdbc 代码并没有什么技术含量，基本上是采用一套例行公事的标准代码模板来编写，是一种苦活
和重复性的工作。
3.通过数据库保存 java 程序运行时产生的对象和恢复对象，其实就是实现了 java 对象与关 系数据库记录的映射关系，称为 ORM（即 Object Relation 
Mapping），人们可以通过封装 JDBC 代码来实现了这种功能，封装出来的产品称之为 ORM 框架，Hibernate 就是其中的一种流行 ORM 框架。使用 Hibernate 框架，不用写 
JDBC 代码，仅仅是调用一个 save 方法，就可以 将对象保存到关系数据库中，仅仅是调用一个 get 方法，就可以从数据库中加载出一个对象。
4.使用 Hibernate 的基本流程是：配置 Configuration 对象、产生 SessionFactory、创建 session
对象，启动事务，完成 CRUD 操作，提交事务，关闭 session。
5.使用 Hibernate 时，先要配置 hibernate.cfg.xml 文件，其中配置数据库连接信息和方言等， 还要为每个实体配置相应的 hbm.xml 
文件，hibernate.cfg.xml 文件中需要登记每个 hbm.xml 文件。
6.在应用 Hibernate 时，重点要了解 Session 的缓存原理，级联，延迟加载和 hql 查询。




1.Spring  实现了工厂模式的工厂类（在这里有必要解释清楚什么是工厂模式），这个类名为
BeanFactory（实际上是一个接口），在程序中通常 BeanFactory 的子类 ApplicationContext。
Spring 相当于一个大的工厂类，在其配置文件中通过<bean>元素配置用于创建实例对象的类
名和实例对象的属性。
2.  Spring 提供了对 IOC 良好支持，IOC 是一种编程思想，是一种架构艺术，利用这种思想 可以很好地实现模块之间的解耦。IOC 也称为 DI（Depency 
Injection），什么叫依赖注入呢？ 譬如，Class Programmer
{








Computer computer = null;
public void code()
{













//Computer computer = new IBMComputer();
//Computer computer = beanfacotry.getComputer();
computer.write();
}



















public void setComputer(Computer computer)
{
this.computer = computer;
}
}

另外两种方式都由依赖，第一个直接依赖于目标类，第二个把依赖转移到工厂上，第三个彻
底与目标和工厂解耦了。在 spring 的配置文件中配置片段如下：
<bean id=”computer” class=”cn.itcast.interview.Computer”>
</bean>


<bean id=”programmer” class=”cn.itcast.interview.Programmer”>
<property name=”computer”    ref=”computer”></property>
</bean>
3.  Spring 提供了对 AOP 技术的良好封装， AOP 称为面向切面编程，就是系统中有很多各 不相干的类的方法，在这些众多方法中要加入某种系统功能的代码，例如，加入日志，加入 
权限判断，加入异常处理，这种应用称为 AOP。实现 AOP 功能采用的是代理技术，客户端 程序不再调用目标，而调用代理类，代理类与目标类对外具有相同的方法声明，有两种方式 
可以实现相同的方法声明，一是实现相同的接口，二是作为目标的子类在，JDK 中采用 Proxy 类产生动态代理的方式为某个接口生成实现类，如果要为某个类生成子类，则可以用 CGLI 
B。在生成的代理类的方法中加入系统功能和调用目标类的相应方法，系统功能的代理以 Advice 对象进行提供，显然要创建出代理对象，至少需要目标类和 Advice 类。spring 提供 
了这种支持，只需要在 spring 配置文件中配置这两个元素即可实现代理和 aop 功能，例如，
<bean id=”proxy” type=”org.spring.framework.aop.ProxyBeanFactory”>
<property name=”target” ref=””></property>
<property name=”advisor” ref=””></property>


</bean>
110、hibernate 中的 update()和 saveOrUpdate()的区别，
session 的 load()和 get()的区别。


110、简述 Hibernate 和 JDBC  的优缺点? 如何书写一个
one to many 配置文件.


7、iBatis 与 Hibernate 有什么不同?


相同点：屏蔽 jdbc api 的底层访问细节，使用我们不用与 jdbc api 打交道，就可以访问数据。 jdbc api 编程流程固定，还将 sql 语句与 java 
代码混杂在了一起，经常需要拼凑 sql 语句，细 节很繁琐。
ibatis 的好处：屏蔽 jdbc  api 的底层访问细节；将 sql 语句与 java 代码进行分离;提供了将结 果 集 自 动 封 装 称 为 实 体 对 象 和 对 象 的 集 合 的 功 
能 ， queryForList  返 回 对 象 集 合 ， 用
queryForObject 返回单个对象；提供了自动将实体对象的属性传递给 sql 语句的参数。


Hibernate 是一个全自动的 orm 映射工具，它可以自动生成 sql 语句,ibatis 需要我们自己在 xml 配置文件中写 sql 语句，hibernate 要比 ibatis 
功能负责和强大很多。因为 hibernate 自动生成 sql 语句，我们无法控制该语句，我们就无法去写特定的高效率的 sql。对于一些不太复杂的 sql 查询，hibernate 
可以很好帮我们完成，但是，对于特别复杂的查询，hibernate 就很难适 应了，这时候用 ibatis 就是不错的选择，因为 ibatis 还是由我们自己写 sql 语句。
7、写 Hibernate 的一对多和多对一双向关联的 orm 配置?


9、hibernate 的 inverse 属性的作用?


解决方案一，按照 Object[]数据取出数据，然后自己组 bean
解决方案二，对每个表的 bean 写构造函数，比如表一要查出 field1,field2 两个字段，那么有 一个构造函数就是 Bean(type1 filed1,type2
field2)  ，然后在 hql 里面就可以直接生成这个 bean 了。



10、在 DAO 中如何体现 DAO 设计模式?


解决方案一，按照 Object[]数据取出数据，然后自己组 bean
解决方案二，对每个表的 bean 写构造函数，比如表一要查出 field1,field2 两个字段，那么有 一个构造函数就是 Bean(type1 filed1,type2
field2)  ，然后在 hql 里面就可以直接生成这个 bean 了。



10、spring+Hibernate 中委托方案怎么配置?


解决方案一，按照 Object[]数据取出数据，然后自己组 bean
解决方案二，对每个表的 bean 写构造函数，比如表一要查出 field1,field2 两个字段，那么有 一个构造函数就是 Bean(type1 filed1,type2
field2)  ，然后在 hql 里面就可以直接生成这个 bean 了。



10、spring+Hibernate 中委托方案怎么配置?


解决方案一，按照 Object[]数据取出数据，然后自己组 bean
解决方案二，对每个表的 bean 写构造函数，比如表一要查出 field1,field2 两个字段，那么有 一个构造函数就是 Bean(type1 filed1,type2
field2)  ，然后在 hql 里面就可以直接生成这个 bean 了。



8. hibernate 进行多表查询每个表中各取几个字段，也就是说 查询出来的结果集没有一个实体类与之对应如何解决；



解决方案一，按照 Object[]数据取出数据，然后自己组 bean
解决方案二，对每个表的 bean 写构造函数，比如表一要查出 field1,field2 两个字段，那么有 一个构造函数就是 Bean(type1 filed1,type2
field2)  ，然后在 hql 里面就可以直接生成这个 bean 了。

8.介绍一下 Hibernate 的二级缓存


按照以下思路来回答：（1）首先说清楚什么是缓存，（2）再说有了 hibernate 的 Session 就是 一级缓存，即有了一级缓存，为什么还要有二级缓存，（3）最后再说如何配置 
Hibernate 的 二级缓存。
（1）缓存就是把以前从数据库中查询出来和使用过的对象保存在内存中（一个数据结构中），
这个数据结构通常是或类似 Hashmap，当以后要使用某个对象时，先查询缓存中是否有这个
对象，如果有则使用缓存中的对象，如果没有则去查询数据库，并将查询出来的对象保存在 缓存中，以便下次使用。下面是缓存的伪代码：
引出 hibernate 的第二级缓存，用下面的伪代码分析了 Cache 的实现原理
D
{
hashmap map = new map();
User getUser(integer id)
{





User user = map.get(id)
if(user == null)
{









user = session.get(id);
map.put(id,user);
}














return user;
}
}



D
{
Cache cache = null setCache(Cache cache)
{





this.cache = cache
}
User getUser(int i
{
if(cache!=null)
{
User user = cache.get(id);
if(user ==null)
{





user = session.get(id);
cache.put(id,user);
}









return user;
}
return session.get(id);
}
}
（2）Hibernate 的 Session 就是一种缓存，我们通常将之称为 Hibernate 的一级缓存，当想使
用 session 从数据库中查询出一个对象时，Session 也是先从自己内部查看是否存在这个对象， 存在则直接返回，不存在才去访问数据库，并将查询的结果保存在自己内部。由于 Session 
代表一次会话过程，一个 Session 与一个数据库连接相关连，所以 Session 最好不要长时间 保持打开，通常仅用于一个事务当中，在事务结束时就应关闭。并且 Session 是线程不安全 
的，被多个线程共享时容易出现问题。通常只有那种全局意义上的缓存才是真正的缓存应用， 才有较大的缓存价值，因此，Hibernate 的 Session 这一级缓存的缓存作用并不明显，应用价 
值不大。Hibernate 的二级缓存就是要为 Hibernate 配置一种全局缓存，让多个线程和多个事 务都可以共享这个缓存。我们希望的是一个人使用过，其他人也可以使用，session  没有这 
种效果。
（3）二级缓存是独立于 Hibernate 的软件部件，属于第三方的产品，多个厂商和组织都提供
有缓存产品，例如，EHCache 和 OSCache 等等。在 Hibernate 中使用二级缓存，首先就要在 hibernate.cfg.xml 
配置文件中配置使用哪个厂家的缓存产品，接着需要配置该缓存产品自己 的配置文件，最后要配置 Hibernate 中的哪些实体对象要纳入到二级缓存的管理中。明白了 
二级缓存原理和有了这个思路后，很容易配置起 Hibernate 的二级缓存。扩展知识：一个 SessionFactory 可以关联一个二级缓存，也即一个二级缓存只能负责缓存一个数据库中的数 
据，当使用 Hibernate 的二级缓存后，注意不要有其他的应用或 SessionFactory 来更改当前 数据库中的数据，这样缓存的数据就会与数据库中的实际数据不一致。



111 、 Spring  的 依 赖 注 入 是 什 么 意 思 ?  给 一 个  Bean  的 message  属性 ,  字符串类型 ,  注入值为  "Hello"  的  XML 
配置文件该怎么写?
120、Jdo 是什么?


JDO 是 Java 对象持久化的新的规范，为 java data object 的简称,也是一个用于存取某种 数据仓库中的对象的标准化 API。JDO 提供了透明的对象存储，因此对开发人员来说， 
存储数据对象完全不需要额外的代码（如 JDBC API 的使用）。这些繁琐的例行工作已 经转移到 JDO 产品提供商身上，使开发人员解脱出来，从而集中时间和精力在业务逻 辑上。另外，JDO 
很灵活，因为它可以在任何数据底层上运行。JDBC 只是面向关系 数据库（RDBMS）JDO 更通用，提供到任何数据底层的存储功能，比如关系数据库、 文件、XML 
以及对象数据库（ODBMS）等等，使得应用可移植性更强。




95、请对以下在 J2EE 中常用的名词进行解释(或简单描述)


web 容器：给处于其中的应用程序组件（JSP，SERVLET）提供一个环境，使 JSP,SERVLET 直接更容器中的环境变量接口交互，不必关注其它系统问题。主要有 WEB 服务器来 
实现。例如：TOMCAT,WEBLOGIC,WEBSPHERE 等。该容器提供的接口严格遵守 J2EE 规范中的 WEB APPLICATION  标准。我们把遵守以上标准的 WEB 服务器就叫做 
J2EE 中的 WEB 容器。
EJB 容器：Enterprise java bean 容器。更具有行业领域特色。他提供给运行在其中的组 件 EJB 各种管理功能。只要满足 J2EE 规范的 EJB 放入该容器，马上就会被容器进行 
高效率的管理。并且可以通过现成的接口来获得系统级别的服务。例如邮件服务、事 务管理。
JNDI：（Java Naming & Directory Interface）JAVA 命名目录服务。主要提供的功能是： 提供一个目录系统，让其它各地的应用程序在其上面留下自己的索引，从而满足快速 
查找和定位分布式应用程序的功能。
JMS：（Java Message Service）JAVA 消息服务。主要实现各个应用程序之间的通讯。包 括点对点和广播。
JTA：（Java Transaction API）JAVA 事务服务。提供各种分布式事务服务。应用程序只需 调用其提供的接口即可。
JAF：（Java Action FrameWork）JAVA 安全认证框架。提供一些安全控制方面的框架。 让开发者通过各种部署和自定义实现自己的个性安全控制策略。
RMI/IIOP:（Remote Method Invocation /internet 对象请求中介协议）他们主要用于通过远程 
调用服务。例如，远程有一台计算机上运行一个程序，它提供股票分析服务，我们可以在本
地计算机上实现对其直接调用。当然这是要通过一定的规范才能在异构的系统之间进行通 信。RMI 是 JAVA 特有的。



8、EJB  是基于哪些技术实现的？并说出 SessionBean 和
EntityBean 的区别，StatefulBean 和 StatelessBean 的区别。


EJB 包括 Session Bean、Entity Bean、Message Driven Bean，基于 JNDI、RMI、JAT 等技 术实现。
SessionBean 在 J2EE 应用程序中被用来完成一些服务器端的业务操作，例如访问数据库、调 用其他 EJB 组件。EntityBean 被用来代表应用系统中用到的数据。 
对于客户机，SessionBean 是一种非持久性对象，它实现某些在服务器上运行的业务逻辑。 对于客户机，EntityBean 是一种持久性对象，它代表一个存储在持久性存储器中的实体的对 
象视图，或是一个由现有企业应用程序实现的实体。
Session Bean 还可以再细分为 Stateful Session Bean 与 Stateless Session Bean ，这两种的 Session Bean 都可以将系统逻辑放在 
method 之中执行，不同的是 Stateful Session Bean 可 以记录呼叫者的状态，因此通常来说，一个使用者会有一个相对应的 Stateful Session Bean
的实体。Stateless Session Bean  虽然也是逻辑组件，但是他却不负责记录使用者状态，也就 是 说 当 使 用 者 呼 叫  Stateless  Session  Bean  的 
时 候 ， EJB  Container  并 不 会 找 寻 特 定 的 Stateless Session Bean 的实体来执行这个 method。换言之，很可能数个使用者在执行某个 
Stateless Session Bean 的 methods  时，会是同一个 Bean 的 Instance  在执行。从内存方面 来看， Stateful Session Bean  与 
Stateless Session Bean  比较， Stateful Session Bean 会消耗 J2EE Server  较多的内存，然而 Stateful Session Bean 
的优势却在于他可以维持使用者的状
态。


3、EJB 与 JAVA BEAN 的区别？


Java Bean 是可复用的组件，对 Java Bean 并没有严格的规范，理论上讲，任何一个 Java 类都可以是一个 Bean。但通常情况下，由于 Java Bean 是被容器所创建（如 
Tomcat） 的，所以 Java Bean 应具有一个无参的构造器，另外，通常 Java Bean 还要实现 Serializable 接口用于实现 Bean 的持久性。Java  Bean 
实际上相当于微软 COM 模型中 的本地进程内 COM 组件，它是不能被跨进程访问的。Enterprise Java Bean 相当于 DCOM，即分布式组件。它是基于 Java 
的远程方法调用（RMI）技术的，所以 EJB 可 以被远程访问（跨进程、跨计算机）。但 EJB 必须被布署在诸如 Webspere、WebLogic 这样的容器中，EJB 客户从不直接访问真正的 
EJB 组件，而是通过其容器访问。EJB 容器是 EJB 组件的代理，EJB 组件由容器所创建和管理。客户通过容器来访问真正的 EJB 组件。

31、EJB 包括（SessionBean,EntityBean）说出他们的生命 周期，及如何管理事务的？

SessionBean：Stateless Session Bean 的生命周期是由容器决定的，当客户机发出请求要 建立一个 Bean 的实例时，EJB 容器不一定要创建一个新的 Bean 
的实例供客户机调用， 而是随便找一个现有的实例提供给客户机。当客户机第一次调用一个 Stateful Session Bean 时，容器必须立即在服务器中创建一个新的 Bean 
实例，并关联到客户机上，以 后此客户机调用 Stateful Session  Bean  的方法时容器会把调用分派到与此客户机相关 联的 Bean 实例。
EntityBean：Entity Beans 能存活相对较长的时间，并且状态是持续的。只要数据库中的 数据存在，Entity beans 就一直存活。而不是按照应用程序或者服务进程来说的。即使 
EJB 容器崩溃了，Entity beans 也是存活的。Entity Beans 生命周期能够被容器或者 Beans 自己管理。
EJB  通过以下技术管理实务：对象管理组织（OMG）的对象实务服务（OTS），Sun Microsystems 的 Transaction Servic（e
的 XA 接口。
JTS）、Java Transaction AP（I
JTA），开发组（X/Open）


73、EJB 容器提供的服务

主要提供声明周期管理、代码产生、持续性管理、安全、事务管理、锁和并发行管理等服务。

7、EJB 的激活机制


以 Stateful Session Bean 为例：其 Cache 大小决定了内存中可以同时存在的 Bean 实例的 数量，根据 MRU 或 NRU 
算法，实例在激活和去激活状态之间迁移，激活机制是当客 户端调用某个 EJB 实例业务方法时，如果对应 EJB Object 发现自己没有绑定对应的 Bean 实例则从其去激活 Bean 
存储中（通过序列化机制存储实例）回复（激活）此实 例。状态变迁前会调用对应的 ejbActive 和 ejbPassivate 方法。


8、EJB 的几种类型


会话（Session）Bean  ，实体（Entity）Bean 消息驱动的（Message Driven）Bean
会话 Bean 又可分为有状态（Stateful）和无状态（Stateless）两种
实体 Bean 可分为 Bean 管理的持续性（BMP）和容器管理的持续性（CMP）两种
79、客服端调用 EJB 对象的几个基本步骤


设置 JNDI 服务工厂以及 JNDI 服务地址系统属性，查找 Home 接口，从 Home 接口调用 Create
方法创建 Remote 接口，通过 Remote 接口调用其业务方法。


5、四种会话跟踪技术

会话作用域 ServletsJSP 页面描述
page 否是代表与一个页面相关的对象和属性。一个页面由一个编译好的 Java servlet 类
（可以带有任何的 include 指令，但是没有 include 动作）表示。这既包括 servlet  又 包括被编译成 servlet 的 JSP 页面
request 是是代表与 Web 客户机发出的一个请求相关的对象和属性。一个请求可能跨越 多个页面，涉及多个 Web 组件（由于 forward 指令和 include 动作的关系）
session 是是代表与用于某个 Web  客户机的一个用户体验相关的对象和属性。一个 Web
会话可以也经常会跨越多个客户机请求
application  是是代表与整个 Web  应用程序相关的对象和属性。这实质上是跨越整个
Web 应用程序，包括多个页面、请求和会话的一个全局作用域



