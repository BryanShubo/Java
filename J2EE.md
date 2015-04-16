1. Java Mail API vs JMS 
Java Mail is an API for sending emails, emails with attachment, reading emails, etc. This API is meant as an API for sending automated emails like the one you receive when you register for an account.  
 
The JMS is the Java Messaging Service which is capable of exchanging messages between applications. An example would be my automated ordering system will find the JMS queue for my Vendor and places an XML message that contains an order. In this case the receiving party is another application. Similarly an application that displays quotes may be listening to a JMS queue to update the status of a stock. JMS is more like a database - the messages (can be configured) to be drained if and only if the recipient system reads it. In other words the delivery can be guaranteed.  
 
In simple:  
JMS - Inter and Intra Company Application to Application Messaging. Delivery can be guaranteed  
Java Mail - Application to a person or person to application. Delivery not guaranteed 
 
 
version 2: 
You would use this mechanism in a large application for 2 reasons: 
1) You don't want your clients to have to wait for the mail to be sent. 
2) You don't want to lose mails if you lose connectivity to your mail server for any reason. 
 
2. Forward vs Redirect 
* forward: request once and request data is saved. 
* redirect: request twice and first request data is lost. 
 
3. POJO VS JavaBean 
POJO: plain old Java object, is mainly used to denote a Java object which does not follow any of the major Java object models, conventions, or frameworks. 
JavaBean: A JavaBean is a POJO that is serializable, has a no-argument constructor, and allows access to properties using getter and setter methods that follow a simple naming convention.  
 
4. EAR vs JAR vs WAR  
In J2EE application modules are packaged as EAR, JAR and WAR based on their functionality 
JAR: EJB modules which contains enterprise java beans class files and EJB deployment descriptor are packed as JAR files with .jar extenstion 
WAR: Web modules which contains Servlet class files,JSP FIles,supporting files, GIF and HTML files are packaged as JAR file with .war (web achive) extension 
EAR: All above files (.jar and .war) are packaged as JAR file with .ear (enterprise archive) extension and deployed into Application Server. 
 
5. Following are some of the key differences in features of Web Server and Application Server: 
1)Web Server is designed to serve HTTP Content. App Server can also serve other protocol support such as RMI/RPC 
2) Web Server is mostly designed to serve static content, though most Web Servers have plugins to support scripting languages like Perl, PHP, ASP, JSP etc. through which these servers can generate dynamic HTTP content. 
3) Most of the application servers have Web Server as integral part of them, that means App Server can do whatever Web Server is capable of. Additionally App Server have components and features to support Application level services such as Connection Pooling, Object Pooling, Transaction Support, Messaging services etc. 
4) As web servers are well suited for static content and app servers for dynamic content, most of the production environments have web server acting as reverse proxy to app server. That means while servicing a page request, static contents (such as images/Static HTML) are served by web server that interprets the request. Using some kind of filtering technique (mostly extension of requested resource) web server identifies dynamic content request and transparently forwards to app server 
 
 
 
