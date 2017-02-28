import java.util.HashMap;
import java.util.Set;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes and Doc Malone
 * @version 2017.01.22
 * Modifications:
 * - Add getExit method
 * - Add getExitString method
 * - Update class with a HashMap
 * - Update getExit method
 * - Update getExitString method
 * - Add getLongDescription method
 * - Add an Item option to each room
 * - Add setItem method
 * - Add getItemFullDescription method
 * - Update getLongDescription method
 * 
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private Item roomItem;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        roomItem = null;
    }

    /**
     * Define the exits of this room.  
     * @param   direction   The direction of the exit.
     * @param   neighbor    The room in the given direction.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

//     /**
//      * This method takes in a direction and a parameter and returns the corresponding Room 
//      *  object.
//      *  
//      *  @param  direction   string description of the desired direction
//      *  @return the appropriate Room object
//      */
//     public Room getExit(String direction)
//     {
//         if(direction.equals("north")){
//             return northExit;
//         }
//         if(direction.equals("east")){
//             return eastExit;
//         }
//         if(direction.equals("south")){
//             return southExit;
//         }
//         if(direction.equals("west")){
//             return westExit;
//         }
//         return null;
//     }

    /**
     * This method takes in a direction and a parameter and returns the corresponding Room 
     *  object.
     *  
     *  @param  direction   string description of the desired direction
     *  @return the appropriate Room object
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);            
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
     
    /**
     * this method will define the fields of the optionan Item
     * 
     * @param   newName  name of the item found in the room
     * @param   newDescription  description of the item found in the room.
     * @param   newWeight   weight of the item found in the room.
     */
    public void setItem(String newName, String newDescription, int newWeight)
    {
        roomItem = new Item(newName, newDescription, newWeight);
    }
    
    /**
     * this method will return a string containing the full description of roomItem
     * 
     * @return  itemFullDescription a String containing the item's description
     */
    private String getItemFullDescription()
    {
        return roomItem.getFullDescription();
    }
//     /**
//      * Return a description of the room's exits.
//      * for example, "Exits: north west".
//      * @return A description of the available exits.
//      */
//     public String getExitString()
//     {
//         String returnString = "You can travel:";
//         
//         if (northExit != null) {
//             returnString += " north";
//         }
//         if (eastExit != null) {
//             returnString += " east";
//         }
//         if (southExit != null) {
//             returnString += " south";
//         }
//         if (westExit != null) {
//             returnString += " west";
//         }
//         return returnString;
//     }
    
    /**
     * Return a description of the room's exits.
     * for example, "Exits: north west".
     * @return A description of the available exits.
     */
    public String getExitString()
    {
        String returnString = "You can travel:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        
        return returnString;
    }
    
    /**
     * Return a long description of this room, of the form:
     *  You are in the kitchen.
     *  Exits: north west
     * @return  A description of the room, including exits.
     */
    public String getLongDescription() {
        if (roomItem == null) {
            return description + "\n" + getExitString();
        } else {
            return description + "\nThis room contains:\n\t" + getItemFullDescription() + "\n" + getExitString();
        }
    }
}
