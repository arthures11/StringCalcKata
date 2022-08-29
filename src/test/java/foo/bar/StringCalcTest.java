package foo.bar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import org.junit.Test;

public class StringCalcTest
{
    @Test
    public void shouldThrowAnException(){
        StringCalc calc = new StringCalc();
        try {
            calc.add("-1,-2");
            fail("exception should have been thrown");
        }
        catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed -1,-2", e.getMessage());
        }
    }
    @Test
    public void shouldRetZero(){
        StringCalc calc = new StringCalc();
        Integer sum = calc.add("");
        assertEquals(new Integer(0),sum);
    }
    @Test
    public void shouldRetNumber(){
        StringCalc calc = new StringCalc();
        Integer sum =calc.add("33");
        assertEquals(new Integer(33),sum);
    }

    @Test
    public void shouldRetSumOfTwoNumbers(){
        StringCalc calc = new StringCalc();
        Integer sum = calc.add("8,33");
        assertEquals(new Integer(41),sum);
    }

    @Test
    public void shouldRetSumOfSomeNumbers(){
        StringCalc calc = new StringCalc();
        Integer sum = calc.add("8,33,1,1,1");
        assertEquals(new Integer(44),sum);
    }
    @Test
    public void shouldRetSumWithNewLiner(){
        StringCalc calc = new StringCalc();
        Integer sum = calc.add("8\n11,1");
        assertEquals(new Integer(20),sum);
    }
    @Test
    public void shouldRetWithCustomDelimiter(){
        StringCalc calc = new StringCalc();
        Integer sum = calc.add("//;\n8;11;1");
        assertEquals(new Integer(20),sum);
    }
    @Test
    public void shouldRetWithCustomDelimiterWithoutOptionalNewLiner(){
        StringCalc calc = new StringCalc();
        Integer sum = calc.add("//.8.11.1.9.1");
        assertEquals(new Integer(30),sum);
    }
}
