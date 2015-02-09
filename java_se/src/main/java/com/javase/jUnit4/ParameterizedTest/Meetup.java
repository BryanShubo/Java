package com.javase.jUnit4.ParameterizedTest;

/**
 * Parameterized testing is about testing exactly the same functionality with multiple inputs. Those should be independent and the order should not matter.
 * 
 * The easiest (as in least amount of new code required) way to do this is to run the test as a parametrized test
 * (annotate with an @RunWith(Parameterized.class) and add a method to provide 10 empty parameters).
 * That way the framework will run the test 10 times.

 This test would need to be the only test in the class, or better put all test methods should
 need to be run 10 times in the class.

 EDIT: With the above, it is possible to even do it with a parameterless constructor,
 but I'm not sure if the framework authors intended that, or if that will break in the future.

 EDIT (in response to comment): If you are implementing your own runner,
 then you could have the runner run the test 10 times. If you are using a third party runner,
 then with 4.7, you can use the new @Rule annotation and implement the MethodRule interface
 so that it takes the statement and executes it 10 times in a for loop.
 The current disadvantage of this approach is that @Before and @After get run only once.
 This will likely change in the next version of JUnit (the @Before will run after the @Rule),
 but regardless you will be acting on the same instance of the object
 (something that isn't true of the Parameterized runner).
 This assumes that whatever runner you are running the class with correctly recognizes the @Rule annotations.
 That is only the case if it is delegating to the JUnit runners.

 If you are running with a custom runner that does not recognize the @Rule annotation,
 then you are really stuck with having to write your own runner that delegates appropriately to that Runner and runs it 10 times.

 Note that there are other ways to potentially solve this (such as the Theories runner) but they all require a runner. Unfortunately JUnit does not currently support layers of runners. That is a runner that chains other runners.
 */
public class Meetup {
    public Meetup(int N) {
        if(N <= 0) { throw  new IllegalArgumentException();}
        System.out.println("Meetup is created !");
    }
}
