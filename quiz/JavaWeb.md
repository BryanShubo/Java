1、Tomcat 的优化经验


答:去掉对 web.xml 的监视，把 jsp 提前编辑成 Servlet。 有富余物理内存的情况，加大 tomcat 使用的 jvm 的内存


1、HTTP 请求的 GET 与 POST 方式的区别


答:servlet 有良好的生存期的定义，包括加载和实例化、初始化、处理请求以及服务结束。 这个生存期由 javax.servlet.Servlet 接口的 init,service 和 
destroy 方法表达。

62、解释一下什么是 servlet;


答:servlet 有良好的生存期的定义，包括加载和实例化、初始化、处理请求以及服务结束。 这个生存期由 javax.servlet.Servlet 接口的 init,service 和 
destroy 方法表达。

1、说一说 Servlet 的生命周期?


答:servlet 有良好的生存期的定义，包括加载和实例化、初始化、处理请求以及服务结束。 这个生存期由 javax.servlet.Servlet 接口的 init,service 和 
destroy 方法表达。


Servlet 被服务器实例化后，容器运行其 init 方法，请求到达时运行其 service 方法，service 方法自动派遣运行与请求对应的 doXXX 
方法（doGet，doPost）等，当服务器决定将实例销 毁的时候调用其 destroy 方法。
web 容器加载 servlet，生命周期开始。通过调用 servlet 的 init()方法进行 servlet 的初始化。 通过调用 service()方法实现，根据请求的不同调用不同的 
do***()方法。结束服务，web 容 器调用 servlet 的 destroy()方法。


4、Servlet 的基本架构


public class ServletName extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
}
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
}
}

3、SERVLET API 中 forward() 与 redirect()的区别？


答:前者仅是容器中控制权的转向，在客户端浏览器地址栏中不会显示出转向后的地址；后 者则是完全的跳转，浏览器将会得到跳转的地址，并重新发送请求链接。这样，从浏览器的 
地址栏中可以看到跳转后的链接地址。所以，前者更加高效，在前者可以满足需要时，尽量 使用 forward()方法，并且，这样也有助于隐藏实际的链接。在有些情况下，比如，需要跳 
转到一个其它服务器上的资源，则必须使用
sendRedirect()方法。



60、什么情况下调用 doGet()和 doPost()？


Jsp 页面中的 FORM 标签里的 method 属性为 get 时调用 doGet()，为 post 时调用
doPost()。



66、Request 对象的主要方法：


setAttribute(String name,Object)：设置名字为 name 的 request 的参数值
getAttribute(String name)：返回由 name 指定的属性值
getAttributeNames()：返回 request 对象所有属性的名字集合，结果是一个枚举的实例 getCookies()：返回客户端的所有 Cookie 对象，结果是一个 Cookie 
数组 getCharacterEncoding()：返回请求中的字符编码方式
getContentLength()：返回请求的 Body 的长度
getHeader(String name)：获得 HTTP 协议定义的文件头信息
getHeaders(String name)：返回指定名字的 request Header 的所有值，结果是一个枚举 的实例
getHeaderNames()：返回所以 request Header 的名字，结果是一个枚举的实例
getInputStream()：返回请求的输入流，用于获得请求中的数据
getMethod()：获得客户端向服务器端传送数据的方法
getParameter(String name)：获得客户端传送给服务器端的有 name 指定的参数值 
getParameterNames()：获得客户端传送给服务器端的所有参数的名字，结果是一个枚 举的实例
getParametervalues(String name)：获得有 name 指定的参数的所有值 getProtocol()：获取客户端向服务器端传送数据所依据的协议名称 
getQueryString()：获得查询字符串 getRequestURI()：获取发出请求字符串的客户端地址 getRemoteAddr()：获取客户端的 IP 地址 
getRemoteHost()：获取客户端的名字
getSession([Boolean create])：返回和请求相关 Session
getServerName()：获取服务器的名字 getServletPath()：获取客户端所请求的脚本文件的路径 getServerPort()：获取服务器的端口号 
removeAttribute(String name)：删除请求中的一个属性
19、forward 和 redirect 的区别


forward 是服务器请求资源，服务器直接访问目标地址的 URL，把那个 URL 的响应内容 读取过来，然后把这些内容再发给浏览器，浏览器根本不知道服务器发送的内容是从 
哪儿来的，所以它的地址栏中还是原来的地址。
redirect 就是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址，一般来 说浏览器会用刚才请求的所有参数重新请求，所以 session,request 参数都可以获取。

4、request.getAttribute() 和 request.getParameter() 有何区 别?

1.  jsp  有哪些内置对象? 作用分别是什么? 分别有什么方
法？
答:JSP 共有以下 9 个内置的对象：
request 用户端请求，此请求会包含来自 GET/POST 请求的参数
response 网页传回用户端的回应 pageContext 网页的属性是在这里管理 session  与请求有关的会话期 application servlet 正在执行的内容
out 用来传送回应的输出
config servlet 的构架部件
page JSP 网页本身
exception 针对错误网页，未捕捉的例外


request 表示 HttpServletRequest 对象。它包含了有关浏览器请求的信息，并且提供了几 个用于获取 cookie, header,  和 session 数据的有用的方法。
response 表示 HttpServletResponse 对象，并提供了几个用于设置送回 浏览器的响应 的方法（如 cookies,头信息等）
out 对象是 javax.jsp.JspWriter 的一个实例，并提供了几个方法使你能用于向浏览器回 送输出结果。
pageContext 表示一个 javax.servlet.jsp.PageContext 对象。它是用于方便存取各种范围 的名字空间、servlet 相关的对象的 API，并且包装了通用的 
servlet 相关功能的方法。 session 表示一个请求的 javax.servlet.http.HttpSession 对象。Session 可以存贮用户的 状态信息
applicaton 表示一个 javax.servle.ServletContext 对象。这有助于查找有关 servlet 引擎 和 servlet 环境的信息
config 表示一个 javax.servlet.ServletConfig 对象。该对象用于存取 servlet 实例的初始 化参数。
page 表示从该页面产生的一个 servlet 实例



2. jsp 有哪些动作?作用分别是什么?


（这个问题似乎不重要，不明白为何有此题） 答:JSP 共有以下 6 种基本动作 jsp:include：在页面被请求的时候引入一个文件。 jsp:useBean：寻找或者实例化一个 
JavaBean。 jsp:setProperty：设置 JavaBean 的属性。 jsp:getProperty：输出某个 JavaBean 的属性。 
jsp:forward：把请求转到一个新的页面。
jsp:plugin：根据浏览器类型为 Java 插件生成 OBJECT 或 EMBED 标记

59、JSP 的常用指令


isErrorPage(是否能使用 Exception 对象)，isELIgnored(是否忽略表达式)



3. JSP 中动态 INCLUDE 与静态 INCLUDE 的区别？

答：动态 INCLUDE 用 jsp:include 动作实现
<jsp:include page=included.jsp flush=true />它总是会检查所含文件中的变化，适合用于包含动
态页面，并且可以带参数 静态 INCLUDE 用 include 伪码实现,定不会检查所含文件的变化， 适用于包含静态页面 <%@ include file=included.htm %>



4、两种跳转方式分别是什么?有什么区别?


（下面的回答严重错误，应该是想问 forward 和 sendRedirect 的区别，毕竟出题的人不是专 业搞文字艺术的人，可能表达能力并不见得很强，用词不一定精准，加之其自身的技术面也 
可能存在一些问题，不一定真正将他的意思表达清楚了，严格意思上来讲，一些题目可能根 本就无人能答，所以，答题时要掌握主动，只要把自己知道的表达清楚就够了，而不要去推 
敲原始题目的具体含义是什么，不要一味想着是在答题）
答：有两种，分别为：
<jsp:include page=included.jsp flush=true>
<jsp:forward page= nextpage.jsp/>
前者页面不会转向 include 所指的页面，只是显示该页的结果，主页面还是原来的页面。执 行完后还会回来，相当于函数调用。并且可以带参数.后者完全转向新页面，不会再回来。 相当于 go to 
语句。



63、页面间对象传递的方法


request，session，application，cookie 等

64、JSP 和 Servlet 有哪些相同点和不同点，他们之间的联
系是什么？


JSP 是 Servlet 技术的扩展，本质上是 Servlet 的简易方式，更强调应用的外表表达。 JSP 编译后是"类 servlet"。Servlet 和 JSP 
最主要的不同点在于，Servlet 的应用逻辑是 在 Java 文件中，并且完全从表示层中的 HTML 里分离开来。而 JSP 的情况是 Java 和 HTML 可以组合成一个扩展名为.jsp 
的文件。JSP 侧重于视图，Servlet 主要用于 控制逻辑。



1、MVC 的各个部分都有那些技术来实现?如何实现?


答:MVC 是 Model－View－Controller 的简写。Model 代表的是应用的业务逻辑（通过 JavaBean，EJB 组件实现）， View 是应用的表示面（由 JSP 
页面产生），Controller  是提供 应用的处理过程控制（一般是一个 Servlet），通过这种设计模型把应用逻辑，处理过程和显

