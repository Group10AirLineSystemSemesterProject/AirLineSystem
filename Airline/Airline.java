package Airline;

import java.util.Collection;

/**
 * Airline management class.
 * @author Nevzat Seferoglu
 * @version 1.0
 */
public class Airline {

    /**
     * <p> Unique Airline Identifier Key. </p>
     * <p> Each airline company has matchless one for each Airport.</p>
     */
    private final transient String UAID_KEY;

    /**
     * Trademark of airline.
     */
    private String nameOfTrademarkAsIdentifier;

    /**
     * Aircraft Container.
     */
    private Collection< Aircraft > listOfAirCraft;

    /**
     * Destination Container.
     */
    private Collection< Destination > listOfDestination;

    /**
     * AirlinePersonnel Container.
     */
    private Collection< AirlinePersonnel > personnelList;

    /**
     * No parameter constructor.
     * @param nameOfTrademarkAsIdentifier trademark of airline.
     * @param uaid_key UUAD key value.
     */
    public Airline( String nameOfTrademarkAsIdentifier , final String uaid_key ) {
        UAID_KEY = uaid_key;
    }

    /**
     * Get a new aircraft.
     * @param ac Aircraft
     * @return Not clear and specified.
     */
    private boolean purchaseAnAircraft( final Aircraft ac ) { return true; }

    /**
     * Recruit a personnel.
     * @param personnel Airline Personnel.
     * @return Not clear and specified.
     */
    private boolean recruitPersonnel( AirlinePersonnel personnel ) { return true; }

    /**
     * Add a new Destination.
     * @param destination a new destination.
     * @return Not clear and specified.
     */
    private boolean addDestination( Destination destination ) { return true; }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
