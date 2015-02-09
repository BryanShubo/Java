package com.javase.jUnit4.ParameterizedTest;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class DomainUtilsTest {

    private String domain;
    private boolean expected;

    public DomainUtilsTest(String domain, boolean expected) {
        this.domain = domain;
        this.expected = expected;
    }

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                        { "google.com", true },
                        { "mkyong.com", true },
                        { "-mkyong.com", false },
                        { "mkyong-.com", false },
                        { "3423kjk", false },
                        { "mk#$kdo.com", false }
                }
        );
    }

    @Test
    public void test_validDomains() {
        assertEquals(expected,DomainUtils.isValidDomainName(domain));
    }

}