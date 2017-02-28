
/**
 * Class Item - an item that can be found in a Room object
 * 
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * An "Item" represents an object that can be found in a "Room".  It is
 * connected to a room.  Each object has a name, a description, and a weight.
 * 
 * @author Doc Malone
 * @version 2017.01.29
 * 
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String itemName;
    private String description;
    private int weight;

    /**
     * Creates an object with a name, description and weight
     * 
     * @param   newName a String with the item name
     * @param   newDescription  a String with the item description
     * @param   newWeight   an int with the item weight
     */
    public Item(String newName, String newDescription, int newWeight)
    {
        itemName = newName;
        description = newDescription;
        weight = newWeight;
    }

    /**
     * returns a String with the itemName, description, and weight for display use
     * 
     * @return  fullDescription     a String with the full description line of text 
     */
    public String getFullDescription()
    {
        String fullDescription = "";
        
        fullDescription = itemName + ": " + description + " - " + weight + " pounds";
        
        return fullDescription;
    }
}
