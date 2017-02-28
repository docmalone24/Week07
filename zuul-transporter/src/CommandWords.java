/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes and Doc Malone
 * @version 2017.01.29
 * Modifications
 * - add look to the array of valid command words
 * - add rest to the array of valid command words
 * - add showAll method
 * - add getCommandList method
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "go", "quit", "help", "look", "rest"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
    
    /**
     * Print all valid commands to System.out.
     */
    public void showAll()
    {
        for(String command : validCommands) {
            System.out.print(command + " ");
        }
        System.out.println();
    }
    
    /**
     * Creates a string of all of the vaild command words
     * 
     * @return commandWords String of all vaild command words
     */
    public String getCommandList()
    {
        String commandWords = "";
        
        for (String command : validCommands) {
            commandWords += command + " ";
        }
        
        return commandWords;
    }
}
