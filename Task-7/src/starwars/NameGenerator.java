/**
 * Class NameGenerator - creates Star Wars names
 *
 * @author Farhan Syed
 * @version 2021.04.11
 */
public class NameGenerator {

    //Exercise 5.71
    public static void main(String[] args){
        NameGenerator generator = new NameGenerator();
        String myStarWarsName = generator.generateStarWarsName("Farhan", "Syed", "Awan", "Stockholm");
        System.out.println(myStarWarsName);
    }

    /**
     * generateStarWarsName creates a person's Star Wars first and last names
     * @param firstName the person's first name
     * @param lastName the person's last name
     * @param maidenName the person's maiden name
     * @param city the city where the person was born
     * @return the person's Star Wars first and last names
     */
    public String generateStarWarsName(String firstName, String lastName, String maidenName, String city){
        String starWarsFirstName = lastName.substring(0,3) + firstName.toLowerCase().substring(0,2);
        String starWarsLastName = maidenName.substring(0,2) + city.toLowerCase().substring(0,3);
        return starWarsFirstName + " " + starWarsLastName;
    }
}
