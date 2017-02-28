import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a game scenario including connected rooms and items
 *
 * @author Cara Tang and Doc Malone
 * @version 2017.02.27
 *
 * Modifications:
 * - separate the game setting logic from the game playing logic in the Game class
 *
 */
public class Scenario
{
    private ArrayList<Room> rooms;
    private Room startRoom;
    private Random random;

    /**
     * Constructor for objects of class Scenario
     */
    public Scenario()
    {
    random = new Random();

    // Set up your rooms, exits, and items
    // Move code from Game.createRooms here
    Room parkingLot, lowerSnowField, westGlacier, eastGlacier, iceAxe,
            upperSnowField, upperGlacier, summit, crevasseFall, corniceFall;

    // create the rooms
    parkingLot = new Room("You are in the parking lot at the base of the mountain.");
    lowerSnowField = new Room("You are standing on the lower snow field.");
    eastGlacier = new Room("You are looking at the sun rise while on the east glacier.");
    westGlacier = new Room("You stare down into the valley from the west glacier.");
    iceAxe = new Room("There is an ice axe on this part of the mountain.");
    upperSnowField = new Room("You have made it to the upper snow field.");
    upperGlacier = new Room("The wind blows hard here on the upper glacier.");
    summit = new Room("Congratulations, you are standing on the summit!");
    crevasseFall = new Room("You have fallen into a crevasse.  Nothing to do but hope for a rescue.");
    corniceFall = new Room("You have fallen through a cornice.  Your mountaineering days have come to an abrupt end.");

    // initialise room exits
    parkingLot.setExit("north", lowerSnowField);
    lowerSnowField.setExit("east", eastGlacier);
    lowerSnowField.setExit("south", parkingLot);
    lowerSnowField.setExit("west", westGlacier);
    westGlacier.setExit("north", iceAxe);
    westGlacier.setExit("south", crevasseFall);
    westGlacier.setExit("west", crevasseFall);
    eastGlacier.setExit("north", upperSnowField);
    eastGlacier.setExit("east", corniceFall);
    eastGlacier.setExit("south", crevasseFall);
    eastGlacier.setExit("west", lowerSnowField);
    iceAxe.setExit("north", upperSnowField);
    iceAxe.setItem("Ice Axe", "An old ice axe.  Clearly weathered, but still functional.", 3);
    upperSnowField.setExit("north", upperGlacier);
    upperSnowField.setExit("east", crevasseFall);
    upperSnowField.setExit("south", eastGlacier);
    upperSnowField.setExit("west", crevasseFall);
    upperGlacier.setExit("north", summit);
    upperGlacier.setExit("east", corniceFall);
    upperGlacier.setExit("south", upperSnowField);
    upperGlacier.setExit("west", corniceFall);
    summit.setExit("east", upperSnowField);
    summit.setExit("west", upperSnowField);

    // Set the start room
    startRoom = parkingLot;

    // Create the rooms ArrayList and add all your rooms to it
    for (Room room : rooms = new ArrayList<Room>() {{
        add(parkingLot);
        add(lowerSnowField);
        add(westGlacier);
        add(eastGlacier);
        add(iceAxe);
        add(upperSnowField);
        add(upperGlacier);
        add(summit);
        add(crevasseFall);
        add(corniceFall);
    }});
};

    /**
     * @return  the start room for this scenario
     */
    public Room getStartRoom()
    {
        // complete this method
        return startRoom;
    }

    /**
     * @return  a random room from this scenario
     */
//    public Room getRandomRoom()
//    {
//        // complete this method
//    }
}
