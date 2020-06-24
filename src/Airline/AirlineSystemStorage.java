package Airline;
import DataStructures.MapGraph;

import java.util.*;

public class AirlineSystemStorage {


    /**
     * aircraft counter.
     */
    int aircraft_counter;

    /**
     * Increment aircraft counter.
     * @return
     */
    public int increment_Aircraft_counter() {
        return ++aircraft_counter;
    }

    /**
     * General Airlien System Storage.
     * @param admin admin of airline.
     * @param nameOfTrademarkAsIdentifier trademark of airline.
     * @param uaid_key UADI_key of airline.
     * @param ways ways
     * @param dests dests
     */
    public AirlineSystemStorage( AirlineAdmin admin , String nameOfTrademarkAsIdentifier , final String uaid_key , MapGraph ways , ArrayList<Destination> dests)  {

        this.admin = admin;
        aircraft_counter = 0;

        mapOfTicket = new HashMap<Integer , Ticket>();
        pilots = new LinkedList<AirlinePersonnel>();
        cabin_crew = new LinkedList<AirlinePersonnel>();
        listOfAirCraft = new ArrayList<Aircraft>();
        listOfFlight = new ArrayList<Flight>();


        this.UAID_KEY = uaid_key;
        this.nameOfTrademarkAsIdentifier = nameOfTrademarkAsIdentifier;

        this.ways = ways;
        this.dests = dests;
    }

    /**
     * Vertex of dest.
     */
    public ArrayList<Destination> dests;

    /**
     * Trademark of airline.
     */
    private String nameOfTrademarkAsIdentifier;

    /**
     * MapGraph of destinations.
     * */
    public MapGraph ways;

    /**
     * <p> Unique Airline Identifier Key. </p>
     * <p> Each airline company has matchless one for each Airport.</p>
     */
    private final transient String UAID_KEY;

    /**
     * List of flight.
     */
    private ArrayList<Flight> listOfFlight;

    /**
     * Map of ticket.
     */
    private Map<Integer,Ticket>           mapOfTicket;

    /**
     * List of pilots.
     */
    private Queue<AirlinePersonnel>       pilots;

    /**
     * List of cabin_crew.
     */
    private Queue<AirlinePersonnel>       cabin_crew;


    /**
     * List of admin.
     */
    private AirlineAdmin admin;


    /**
     * Aircraft Container.
     */
    private ArrayList< Aircraft >   listOfAirCraft;


    /*------------------------------------------ Getters -------------------------------------*/



    /**
     * Get aircraft List
     * @return list of aircraft.
     */
    public ArrayList<Aircraft> getListOfAirCraft() {
        return listOfAirCraft;
    }


    /**
     * Ticket container.
     * @return Ticket container.
     */
    public Map<Integer,Ticket> getMapOfTicket() {
        return mapOfTicket;
    }

    /**
     * Aircraft counter.
     * @return Aircraft counter.
     */
    public int getAircraftCounter() {
        return aircraft_counter;
    }


    /**
     * Pilots Queue.
     * @return Pilot Queue.
     */
    public Queue<AirlinePersonnel> getPilots() {
        return pilots;
    }

    /**
     * CabinCrew Queue.
     * @return CabinCrew Queue..
     */
    public Queue<AirlinePersonnel> getCabin_crew() {
        return cabin_crew;
    }

    /**
     * List of flight.
     * @return List of flight.
     */
    public ArrayList<Flight> getListOfFlight() {
        return listOfFlight;
    }

    /**
     * Name of trademark.
     * @return Name of trademark.
     */
    public String getNameOfTrademarkAsIdentifier() {
        return nameOfTrademarkAsIdentifier;
    }

    /**
     * UAID_KEY
     * @return UAID_KEY
     */
    public String getUAID_KEY() {
        return UAID_KEY;
    }

    /**
     * Set name of identifier.
     * @param nameOfTrademarkAsIdentifier
     */
    public void setNameOfTrademarkAsIdentifier(String nameOfTrademarkAsIdentifier) {
        this.nameOfTrademarkAsIdentifier = nameOfTrademarkAsIdentifier;
    }

    /**
     * Retrun airport admin.
     * @return Retrun airport admin.
     */
    public AirlineAdmin getAdmin() {
        return admin;
    }

    public ArrayList<Destination> getListOfDestination(){
        return dests;
    }
    
}