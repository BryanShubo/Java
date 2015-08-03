package CodingHire.StringAndArray;


import org.junit.Assert;
import org.junit.Test;

public class StringToIntegerTest {

    @Test
    public void testStringToInteger() {
        StringToInteger convertStringToInteger = new StringToInteger();
        Assert.assertEquals(129, convertStringToInteger.stringToInteger("129"));
        Assert.assertEquals(-129, convertStringToInteger.stringToInteger("-129"));

        Assert.assertNotEquals(-129, convertStringToInteger.stringToInteger("129"));
        Assert.assertNotEquals(129, convertStringToInteger.stringToInteger("-129"));

    }
}
