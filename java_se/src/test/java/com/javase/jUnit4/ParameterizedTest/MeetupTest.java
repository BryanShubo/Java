package com.javase.jUnit4.ParameterizedTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MeetupTest {
    private int N;
    @Parameterized.Parameters
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {0},{1},{2},{-3},{4},{-5}
        });
    }

    public MeetupTest(int N) {
        this.N = N;
    }

    @Test
    public void testMeetup(){
        System.out.println("parameter: " + N);
        new Meetup(N);
    }
}