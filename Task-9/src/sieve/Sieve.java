import java.util.Arrays;
/**
 * Implementation of the Sieve of Eratosthenes algorithm for checking if a
 * number is prime or not. The implementation is lacking in error-checking
 * and optimization, and needs some patching up!
 *
 * @author  Farhan Syed
 * @version 2021-11-17
 */
public class Sieve {

    private static final int maxValue = (int) Math.pow(2,26);
    private boolean[] primeCache = new boolean[0];

    //Exercises S.4, S.5
    /**
     * Check if a number is prime or not!
     * Note that prime[n] denotes the primality of number n.
     *
     * @param   number  An integer value to be checked for primality.
     * @return  true if number is prime, false otherwise.
     */
    public boolean isPrime(int number) {
        exceptionIfIllegalArg(number);

        if(number >= primeCache.length){
            boolean[] prime = sieve(number);
            primeCache = prime;
            return prime[number];
        }
        else{
            return primeCache[number];
        }
    }

    //Exercises S.2, S.3
    /**
     * Checks if the number is within the range of prime numbers and smaller than the max value
     * @param number An integer value to be checked for primality.
     */
    private void exceptionIfIllegalArg(int number){
        if(number < 2){
            System.out.println("The number cannot be less than 2!");
            throw new IllegalArgumentException();
        }
        else if(number > (maxValue)){
            System.out.println("The number cannot be greater than 2^26.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * The sieve algorithm that checks for prime status
     * @param number An integer value to be checked for primality.
     * @return an array containing the prime status of numbers up to the given parameter number
     */
    private boolean[] sieve(int number){
        boolean[] prime = new boolean[number + 1]; // + 1 because of 0-indexing
        Arrays.fill(prime, true); // assume all numbers are prime
        int sqrt = (int) Math.floor(Math.sqrt(number));
        for (int i = 2; i <= sqrt; i++) {
            if (prime[i]) {
                for (int j = i*2; j < prime.length; j+=i) {
                    prime[j] = false; // mark multiples of i as not prime
                }
            }
        }
        return prime;
    }
}
