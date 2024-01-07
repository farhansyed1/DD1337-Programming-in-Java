import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *  This is the main class of the "Steal the diamond" application.
 *  "Steal the diamond" is a simple text based game where the player
 *  must enter a house and find the hidden diamond before the police arrive.
 *
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 *
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 *
 * @author  Michael Kölling and David J. Barnes
 * @author  Farhan Syed
 * @version 2021.11.11
 */

public class Game {
    private Parser parser;
    private Room currentRoom;
    HashMap<String, Room> worldModel;

    int movesRemaining = 25;         //the player can make 25 moves before the time is up

    //boolean values that change to true if the players enters certain rooms or commands
    boolean foundKey;
    boolean foundHammer;
    boolean wallBroken;
    boolean doorOpened;
    boolean foundDiamond;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRoomsFromFile("rooms.txt");
        //createRooms();
        parser = new Parser();
    }

    /**
     * Creates the rooms using data from a text file.
     * @param filename the name of the file
     */
    public void createRoomsFromFile(String filename){
        worldModel = new HashMap<String, Room>();
        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader(filename));
            String line;
            String[] roomData;
            while ((line = inputStream.readLine()) != null) {
                roomData = line.split(",");
                if(roomData[0].equals("Room")){
                    worldModel.put(roomData[1], new Room(roomData[2]));
                }
                else if(roomData[0].equals("Exit")){
                   worldModel.get(roomData[1]).setExit(roomData[2],worldModel.get(roomData[3]));
                }
            }
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        currentRoom = worldModel.get("Outside");    //start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {
        printWelcome();
        boolean finished = false;
        // Enter the main command loop. Here we repeatedly read commands and
        // execute them until the game is over.
        while (! finished) {
            if(movesRemaining == 0){                          //The game quits if the player uses all their moves
                break;
            }
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("The police have arrived. You have failed your mission and have been arrested.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Jeff Bezos has hidden a diamond in his home.");
        System.out.println("Enter the house and steal the diamond. The police will arrive in 250 seconds...");
        System.out.println("Type 'help' to see which actions you can take.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("open")) {
            openDoor();
        }
        else if (commandWord.equals("break")) {
            breakWall();
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

     /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp()  {
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * Try to go in a certain direction. If there is an exit, enter the new
     * room and print additional messages specific to the room. Otherwise print an error message.
     * @param command the command that the player enters
     */
    private void goRoom(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            jumpOutOfWindowCheck(nextRoom);
            currentRoom = nextRoom;
            giveKeyOrHammer();
            additionalMessages();

            System.out.println(currentRoom.getLongDescription());
            movesRemaining--;
        }
    }

    /**
     * Checks if the player jumps out of the window in the bedroom
     * @param nextRoom the room that the player moves to
     */
    private void jumpOutOfWindowCheck(Room nextRoom){
        if (currentRoom.equals(worldModel.get("Bedroom")) && nextRoom.equals(worldModel.get("Outside"))){
            System.out.println("You jumped out of the window. Great job.");
        }
    }

    /**
     * Prints additional messages if the player enters certain rooms.
     */
    private void additionalMessages(){
        //If the player reaches the office and finds the diamond
        if(!foundDiamond && currentRoom.equals(worldModel.get("Office"))){
            foundDiamond = true;
            System.out.println("You found the diamond!");
            System.out.println("Now make your way out!!!");
        }
        //If the player enters the Living room and hasn't broken the wall
        else if (!wallBroken && currentRoom.equals(worldModel.get("Living room"))){
            System.out.println("The eastern wall seems quite weak...");
        }
        //If the player enters the Art room and hasn't unlocked the door
        else if(!doorOpened && currentRoom.equals(worldModel.get("Art room"))){
            System.out.println("Wow. A steel door to the south. It is locked.");
        }
        //If the player enters the Bedroom
        else if(currentRoom.equals(worldModel.get("Bedroom"))){
            System.out.println("Wow. There's an interesting window to your right");
        }
        //If the player has the diamond and goes outside they will win the game
        else if(foundDiamond && currentRoom.equals(worldModel.get("Outside"))){
            System.out.println("You made it!");
            System.exit(0);
        }
    }

    /**
     * Provides the player with a key/hammer if they enter the dining/games room for the first time.
     */
    private void giveKeyOrHammer(){
        if(!foundHammer){
            if (currentRoom.equals(worldModel.get("Games room"))) {
                System.out.println("You found a sledgehammer!");
                foundHammer = true;
            }
        }
        if(!foundKey){
            if (currentRoom.equals(worldModel.get("Dining room"))) {
                System.out.println("You found a key!");
                foundKey = true;
            }
        }
    }

    /**
     * Try to open a locked door. If the player has the key the door will unlock. Otherwise print an error message
     */
    private void openDoor(){
        if(!doorOpened && foundKey && currentRoom.equals(worldModel.get("Art room"))){
            worldModel.get("Art room").setExit("south",worldModel.get("Office"));
            System.out.println("Click!");
            doorOpened = true;
        }
        else if(!foundKey && currentRoom.equals(worldModel.get("Art room"))){
            System.out.println("The door is locked.");
        }
        else{
            System.out.println("There is nothing to open.");
        }
    }

    /**
     * Try to break a wall. The wall will be broken if the player has a hammer and is in the living room
     * Otherwise print an error message
     */
    private void breakWall(){
        if(!wallBroken && foundHammer && currentRoom.equals(worldModel.get("Living room"))){
            worldModel.get("Living room").setExit("east",worldModel.get("Art room"));
            System.out.println("BOOM. You broke the wall");
            wallBroken = true;
        }
        else if(!foundHammer && currentRoom.equals(worldModel.get("Living room"))){
            System.out.println("You need a tool.");
        }
        else{
            System.out.println("There is nothing to break.");
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
