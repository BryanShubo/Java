I Basic Synchronization Questions: 
1) Describe synchronization in respect to multithreading 
  2)What is synchronization and why is it important? 
3) What are synchronized methods and synchronized statements? 
 
 II Tread related Questions: 
When a thread is created and started, what is its initial state? 
What is daemon thread and which method is used to create the daemon thread? 
What method must be implemented by all threads? 
Explain different way of using thread? 
What is the difference between processes and threads?  
Briefly explain high-level thread states?  
What is the difference between yield and sleeping? What is the difference between the methods sleep( ) and wait( )?  
 
III Java Concurrency Interview Questions 
What is atomic operation? What are atomic classes in Java Concurrency API? 
What is Lock interface in Java Concurrency API? What are it’s benefits over synchronization? 
What is Executors Framework? 
What is BlockingQueue? How can we implement Producer-Consumer problem using Blocking Queue? 
What is Callable and Future? 
What is FutureTask Class? 
What are Concurrent Collection Classes? 
What is Executors Class? 
IV More Questions: 
How does Java handle integer overflows and underflows? 
Does garbage collection guarantee that a program will not run out of memory? 
What is the difference between preemptive scheduling and time slicing? 
What is the purpose of finalization? 
 
 
 
Synchronization Questions 
 
1. Q: Describe synchronization in respect to multithreading. 
A: With respect to multithreading, synchronization is the capability to control the access of multiple threads to shared resources. Without synchonization, it is possible for one thread to modify a shared variable while another thread is in the process of using or updating same shared variable. This usually leads to significant errors. 
 
2.Q: What is synchronization and why is it important? 
A: With respect to multithreading, synchronization is the capability to control 
the access of multiple threads to shared resources. Without synchronization, it is possible for one thread to modify a shared object while another thread is in the process of using or updating that object's value. This often leads to significant errors. 
 
3.Q: What are synchronized methods and synchronized statements? 
A: Synchronized methods are methods that are used to control access to an object. A thread only executes a synchronized method after it has acquired the lock for the method's object or class. Synchronized statements are similar to synchronized methods. A synchronized statement can only be executed after a thread has acquired the lock for the object or class referenced in the synchronized statement. 
 
 
Thread related Questions: 
 
1. Q: When a thread is created and started, what is its initial state? 
A: A thread is in the ready state after it has been created and started. 
 
2.Q: What is daemon thread and which method is used to create the daemon thread? 
A: Daemon thread is a low priority thread which runs intermittently in the back ground doing the garbage collection operation for the java runtime system. setDaemon method is used to create a daemon thread. 
 
3.Q: What method must be implemented by all threads? 
A: All tasks must implement the run() method, whether they are a subclass of Thread or implement the Runnable interface. 
 
4. Q: Explain different way of using thread? 
A: The thread could be implemented by using runnable interface or by inheriting from the Thread class. 
The former is more advantageous, 'cause when you are going for multiple inheritance..the only 
interface can help. 
 
 
More Questions 
1.Q: How does Java handle integer overflows and underflows? 
A: It uses those low order bytes of the result that can fit into the size of the type allowed by the 
operation. 
 
2.Q: Does garbage collection guarantee that a program will not run out of memory? 
A: Garbage collection does not guarantee that a program will not run out of memory. It is possible for programs to use up memory resources faster than they are garbage collected. It is also possible for programs to create objects that are not subject to garbage collection 
. 
3.Q: What is the difference between preemptive scheduling and time slicing? 
A: Under preemptive scheduling, the highest priority task executes until it enters the waiting or dead states or a higher priority task comes into existence. Under time slicing, a task executes for a predefined slice of time and then reenters the pool of ready tasks. The scheduler then determines which task should execute next, based on priority and other factors. 
 
4.Q: What is the purpose of finalization? 
A: The purpose of finalization is to give an unreachable object the opportunity to perform any cleanup processing before the object is garbage collected. 
 
5.Q: What is the difference between processes and threads?  
A. A process is an execution of a program but a thread is a single execution sequence within the process. A process can contain multiple threads. A thread is sometimes called a lightweight process. 
 
6.Q: Briefly explain high-level thread states?  
 
A: The state chart diagram below describes the thread states. 
Image 
Runnable — A thread becomes runnable when you call the start( ), but does  not necessarily start running immediately.  It will be pooled waiting for its turn to be picked for execution by the thread scheduler based on thread priorities.  
Running: The processor is actively executing the thread code. It runs until it becomes blocked, or voluntarily gives up its turn with this static method Thread.yield( ). Because of context switching overhead, yield( ) should not be used very frequently 
Waiting: A thread is in a blocked state while it waits for some external processing such as file I/O to finish.A call to currObject.wait( ) method causes the current thread to wait until some other thread invokescurrObject.notify( ) or the currObject.notifyAll( ) is executed. 
Sleeping: Java threads are forcibly put to sleep (suspended) with this overloaded method: Thread.sleep(milliseconds), Thread.sleep(milliseconds, nanoseconds); 
Blocked on I/O: Will move to runnable after I/O condition like reading bytes of data etc changes. 
Blocked on synchronization: will move to running when a lock is acquired.  
Dead: The thread is finished working. 
7. Q. What is the difference between yield and sleeping? What is the difference between the methods sleep( ) and wait( )?  
A. When a task invokes yield( ), it changes from running state to runnable state. When a task invokes sleep ( ), it changes from running state to waiting/sleeping state. 
The method wait(1000) causes the current thread to wait up to one second a signal from other threads. A thread could wait less than 1 second if it receives the notify( ) or notifyAll( ) method call. The call to sleep(1000) causes the current thread to sleep for t least 1 second. 
 
Java Concurrency Interview Questions 
Q.What is atomic operation? What are atomic classes in Java Concurrency API? 
A. Atomic operations are performed in a single unit of task without interference from other operations. Atomic operations are necessity in multi-threaded environment to avoid data inconsistency. 
For example  int++ is not an atomic operation. So by the time one threads read it’s value and increment it by one, other thread has read the older value leading to wrong result. 
To solve this issue, we will have to make sure that increment operation on count is atomic, we can do that using Synchronization but Java 5 java.util.concurrent.atomic provides wrapper classes for int and long that can be used to achieve this atomically without usage of Synchronization.  
Q.What is Lock interface in Java Concurrency API? What are it’s benefits over synchronization? 
A. Lock interface provide more extensive locking operations than can be obtained using synchronized methods and statements. They allow more flexible structuring, may have quite different properties, and may support multiple associated Condition objects. 
The advantages of a lock are 
it’s possible to make them fair 
it’s possible to make a thread responsive to interruption while waiting on a Lock object. 
it’s possible to try to acquire the lock, but return immediately or after a timeout if the lock can’t be acquired 
it’s possible to acquire and release locks in different scopes, and in different orders 
 
Q.What is Executors Framework? 
A.The Executor framework is a framework for standardizing invocation, scheduling, execution, and control of asynchronous tasks according to a set of execution policies. 
Creating a lot many threads with no bounds to the maximum threshold can cause application to run out of heap memory. So, creating a ThreadPool is a better solution as a finite number of threads can be pooled and reused. Executors framework facilitate process of creating Thread pools in java. 
Q.What is BlockingQueue? How can we implement Producer-Consumer problem using Blocking Queue? 
A.BlockingQueue is a Queue that supports operations that wait for the queue to become non-empty when retrieving and removing an element, and wait for space to become available in the queue when adding an element. 
BlockingQueue doesn’t accept null values and throw NullPointerException if you try to store null value in the queue. 
BlockingQueue implementations are thread-safe. All queuing methods are atomic in nature and use internal locks or other forms of concurrency control. 
BlockingQueue interface is part of java collections framework and it’s primarily used for implementing producer consumer problem. 
Q.What is Callable and Future? 
A.Callable interface in concurrency package that is similar to Runnable interface but it can return any Object and able to throw Exception. 
Callable interface use Generic to define the return type of Object. Executors class provide useful methods to execute Callable in a thread pool. Since callable tasks run in parallel, we have to wait for the returned Object. Callable tasks return java.util.concurrent.Future object. Using Future we can find out the status of the Callable task and get the returned Object. It provides get() method that can wait for the Callable to finish and then return the result. 
Q.What is FutureTask Class? 
A. FutureTask is the base implementation class of Future interface and we can use it with Executors for asynchronous processing. Most of the time we don’t need to use FutureTask class but it comes real handy if we want to override some of the methods of Future interface and want to keep most of the base implementation. We can just extend this class and override the methods according to our requirements. 
 
Q.What are Concurrent Collection Classes? 
Scenarios:http://www.journaldev.com/378/how-to-avoid-concurrentmodificationexception-when-using-an-iterator 
A. Java Collection classes are fail-fast which means that if the Collection will be changed while some thread is traversing over it using iterator, the iterator.next() will throw ConcurrentModificationException. 
Concurrent Collection classes support full concurrency of retrievals and adjustable expected concurrency for updates. 
Major classes are ConcurrentHashMap, CopyOnWriteArrayList and CopyOnWriteArraySet 
Q.What is Executors Class? 
A. Executors class provide utility methods for Executor, ExecutorService, ScheduledExecutorService, ThreadFactory, and Callable classes. 
Executors class can be used to easily create Thread Pool in java, also this is the only class supporting execution of Callable implementations. 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
