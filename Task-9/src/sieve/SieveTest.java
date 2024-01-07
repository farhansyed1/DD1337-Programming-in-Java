import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
/**
 * Test class the Sieve class.
 *
 * @author Tobias Hansson
 * @author Farhan Syed
 * @version 2021-11-17
 */
public class SieveTest {

    private Sieve sieve;
    private static final int maxValue = (int) Math.pow(2,26);

    @Before
    public void setUp() {
        sieve = new Sieve();
    }

    //Exercise S.1
    /**
     * Test that 1 is rejected as a number to consider for prime status
     */
    @Test(expected=IllegalArgumentException.class)
    public void isPrimeExceptionWhenNumberIsOne(){
        sieve.isPrime(1);
    }

    /**
     * Test that negative numbers are rejected as numbers to consider for prime status
     */
    @Test(expected=IllegalArgumentException.class)
    public void isPrimeExceptionWhenNumberIsMinusTen(){
        sieve.isPrime(-10);
    }

    //Exercise S.3
    /**
     * Test that a number equal to the upper (excluded) boundary is rejected
     */
    @Test
    public void isPrimeFalseWhenNumberIs2Pow26(){
        assertFalse(sieve.isPrime(maxValue));
    }

    /**
     * Test that a number greater than the upper boundary is rejected
     */
    @Test(expected=IllegalArgumentException.class)
    public void isPrimeExceptionWhenNumberIs2Pow26Plus1(){
        sieve.isPrime((maxValue + 1));
    }

    /**
     * Test that a number much larger than the upper boundary is rejected
     */
    @Test(expected=IllegalArgumentException.class)
    public void isPrimeExceptionWhenNumberIs2Pow28(){
        sieve.isPrime((int) Math.pow(2,28));
    }

    //Other tests
    @Test
    public void isPrimeTrueWhenNumberIsTwo() {
        assertTrue(sieve.isPrime(2));
    }

    @Test
    public void isPrimeTrueWhenNumberIsPrime() {
        boolean threeIsPrime = sieve.isPrime(3);
        boolean ninetySevenIsPrime = sieve.isPrime(97);
        boolean sevenIsPrime = sieve.isPrime(7);
        boolean fiveIsPrime = sieve.isPrime(5);

        assertTrue(threeIsPrime);
        assertTrue(ninetySevenIsPrime);
        assertTrue(sevenIsPrime);
        assertTrue(fiveIsPrime);
    }

    @Test
    public void isPrimeFalseWhenNumberIsComposite() {
        boolean fourIsPrime = sieve.isPrime(4);
        boolean nineHundredThreeIsPrime = sieve.isPrime(903);
        boolean sixIsPrime = sieve.isPrime(6);
        boolean thirtyFiveIsPrime = sieve.isPrime(35);

        assertFalse(fourIsPrime);
        assertFalse(nineHundredThreeIsPrime);
        assertFalse(sixIsPrime);
        assertFalse(thirtyFiveIsPrime);
    }

    @Test
    public void isPrimeWorksWhenPassedIncrementingValues() {
        boolean twoIsPrime = sieve.isPrime(2);
        boolean threeIsPrime = sieve.isPrime(3);
        boolean fourIsPrime = sieve.isPrime(4);
        boolean fiveIsPrime = sieve.isPrime(5);
        boolean sixIsPrime = sieve.isPrime(6);
        boolean sevenIsPrime = sieve.isPrime(7);
        boolean eightIsPrime = sieve.isPrime(8);
        boolean nineIsPrime = sieve.isPrime(9);

        assertTrue(twoIsPrime);
        assertTrue(threeIsPrime);
        assertFalse(fourIsPrime);
        assertTrue(fiveIsPrime);
        assertFalse(sixIsPrime);
        assertTrue(sevenIsPrime);
        assertFalse(eightIsPrime);
        assertFalse(nineIsPrime);
    }
}
