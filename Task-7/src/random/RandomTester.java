import java.util.ArrayList;
import java.util.Random;

/**
 * Class RandomTester - contains methods using the Random class
 *
 * @author Michael Kölling and David J. Barnes
 * @author Farhan Syed
 * @version 2021.04.11
 */
public class RandomTester {

    Random random = new Random();

    public static void main(String[] args){
        RandomTester tester = new RandomTester();
        tester.printOneRandom();
        tester.printMultiRandom(2);
        System.out.println(tester.throwDice());
        System.out.println(tester.getResponse());
        System.out.println(tester.randInRangeMinMax(10,12));
    }

    //Exercise 5.14
    /**
     * printOneRandom prints a random integer
     */
    private void printOneRandom() {
        int randomNumber = random.nextInt();
        System.out.println(randomNumber);
    }

    /**
     * printMultiRandom prints several random integers
     * @param howMany  number of integers that will be printed
     */
    private void printMultiRandom(int howMany){
        for (int i = 1; i <= howMany; i++) {
            int randomNumber = random.nextInt();
            System.out.println(randomNumber);
        }
    }

    //Exercise 5.16
    /**
     * throwDice simulates a dice throw
     * @return the outcome of the dice throw
     */
    private int throwDice(){
        int dice = random.nextInt(6) + 1;
        return dice;
    }

    //Exercise 5.17 + 5.18
    /**
     * getResponse creates a list of words and returns one chosen at random
     * @return a random word from the ArrayList
     */
    private String getResponse(){
        ArrayList<String> words = new ArrayList<String>();
        words.add("Volvo");
        words.add("Volkswagen");
        words.add("BMW");
        String randomWord = words.get(random.nextInt(words.size()));
        return randomWord;
    }

    //Exercise 5.20
    /**
     * randInRangeMinMax creates a random number within a given range
     * @param min the lower boundary
     * @param max the upper boundary
     * @return the random number within the range
     */
    private int randInRangeMinMax(int min, int max){
        int randomNumber = random.nextInt(max + 1 - min) + min;
        return randomNumber;
    }
}
