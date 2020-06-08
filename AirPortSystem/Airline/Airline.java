package Airline;

import java.util.Collection;

/**
 * Airline management class.
 * @author Nevzat Seferoglu
 * @version 1.0
 */
public class Airline {

    /**
     * Current airport.
     */
    Destination localAirport;

    /**
     * General data storage of airline
     */
    private AirlineSystemStorage airlineSystemStorage;

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
     * No parameter constructor.
     * @param nameOfTrademarkAsIdentifier trademark of airline.
     * @param uaid_key UUAD key value.
     */
    public Airline( String nameOfTrademarkAsIdentifier , final String uaid_key , Destination localAirport ) {

        UAID_KEY = uaid_key;
        this.localAirport = localAirport;
        airlineSystemStorage = new AirlineSystemStorage();

    }


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


    private AirlineSystemStorage getAirlineSystemStorage() {
        return airlineSystemStorage;
    }
    private void setAirlineSystemStorage( AirlineSystemStorage airlineSystemStorage) {
        this.airlineSystemStorage = airlineSystemStorage;
    }

    public String getUAID_KEY() {
        return UAID_KEY;
    }

}
