import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Displays data about the players
 *
 * @author Farhan Syed
 * @version 2021.11.11
 */
public class HighScore {

    //Tasks IO.1 - 3

    /**
     * Prints the high scores for all the players
     * @param filename the name of the file containing the player names, country and score
     */
    public static void printHighScores(String filename) {
        BufferedReader inputStream = null;

        ArrayList<Player> players = new ArrayList<Player>();

        //IO.2 Version
        try {
            inputStream = new BufferedReader(new FileReader(filename));
            String line;
            String[] playerData;
            while ((line = inputStream.readLine()) != null) {
                playerData = line.split(",");
                System.out.println("Player " + playerData[0] + " from "+ playerData[1] + " scored " + playerData[2] + " points");
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        System.out.println();

        //IO.3 Version
        try {
            inputStream = new BufferedReader(new FileReader(filename));
            String line;
            String[] playerData;
            while ((line = inputStream.readLine()) != null) {
                playerData = line.split(",");
                String name = playerData[0];
                String country = playerData[1];
                int score = Integer.parseInt(playerData[2]);
                players.add(new Player(name,country,score));
            }
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        for(Player player: players ){
            System.out.println(player.toString());
        }
    }

    public static void main(String[] args) {
        printHighScores("scores.txt");
    }
}
