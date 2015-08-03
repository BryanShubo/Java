package CodingHire.StringAndArray;

import org.junit.Assert;
import org.junit.Test;


public class IntToStringTest {

    @Test
    public void testIntToString() {
        IntToString intToString = new IntToString();
        Assert.assertEquals("129", intToString.intToString(129));
        Assert.assertEquals("-129", intToString.intToString(-129));

        Assert.assertNotEquals("129", intToString.intToString(-129));
        Assert.assertNotEquals("-129", intToString.intToString(129));

    }
}
