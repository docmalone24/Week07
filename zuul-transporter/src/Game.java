/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes and Doc Malone
 * @version 2017.02.27
 * Modifications:
 * - add main method
 * -
 * -
 * -
 * 
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Scenario scenario;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Starts the Game class
     * @param args  Takes in any arguments provided at run time.
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
        /**
         * Create all the rooms and link their exits together.
         */
    private void createRooms()
    {
        scenario = new Scenario();
        currentRoom = scenario.getStartRoom();  // start game in parking lot
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Mountain Adventure!");
        System.out.println("Make it to the Summit and back down to the car without falling.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
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
        else if (commandWord.equals("look")) {
            look();
        }
        else if (commandWord.equals("rest")) {
            rest();
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are traveling on a snow and ice covered mountain.");
        System.out.println("You are attempting to make it to the summit and then");
        System.out.println("back to the car without falling.");
        System.out.println();
        System.out.println("Your command words are:");
//         System.out.println("   go look rest quit help");
        System.out.println(parser.getCommandList());
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("That path is blocked");
        }
        else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    /**
     * This method prints the long description of the current room to the screen
     */
    private void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }
    
    /** 
     * This method prints the rested message to the screen
     */
    private void rest()
    {
        System.out.println("Mountaineering is hard work.  It's important not to over exert yourself.");
        System.out.println("You take a break and feel rested enough to continue.");
    }
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
//     /**
//      * This method lists the available directions of travel for the current room.
//      */
//     private void printLocationInfo()
//     {
//         System.out.println(currentRoom.getDescription());
//         System.out.print("You can travel: ");
//         if(currentRoom.northExit != null) {
//             System.out.print("north ");
//         }
//         if(currentRoom.eastExit != null) {
//             System.out.print("east ");
//         }
//         if(currentRoom.southExit != null) {
//             System.out.print("south ");
//         }
//         if(currentRoom.westExit != null) {
//             System.out.print("west ");
//         }
//         System.out.println();
//     }    
    
    /**
     * This method lists the available directions of travel for the current room.
     */
    private void printLocationInfo()
    {
        System.out.println(currentRoom.getLongDescription());
    }
}
