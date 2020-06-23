package Airline;

import Airport.AirportSystemStorage;
import Client.UserInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AirlineAdmin extends AirlinePersonnel implements AirlineAdminDomain , UserInterface {

    AirlineSystemStorage airlineSystemStorage;

    public AirlineAdmin( String name , String surname , AirlineSystemStorage airlineSystemStorage ) throws Exception {

        super( name , surname , false );
        if( airlineSystemStorage == null ) {
            throw new Exception("AirlineSystemStorage cannot be null.");
        }
        this.airlineSystemStorage = airlineSystemStorage;
    }


    public boolean dismissPersonnel( AirlinePersonnel airlinePersonnel ) throws Exception {

        if( airlinePersonnel == null ) {
            throw new Exception("AirlinePersonnel cannot be null.");
        }

        if( !(airlineSystemStorage.getCabin_crew().contains( airlinePersonnel ) ||
                airlineSystemStorage.getPilots().contains( airlinePersonnel )) ) {
            return false;
        }

        if( airlinePersonnel.isPilot ) {

            try {
                airlineSystemStorage.getPilots().remove(airlinePersonnel);
            }
            catch ( Throwable t ) {
                return false;
            }
        } else {
            try {
                airlineSystemStorage.getCabin_crew().remove(airlinePersonnel);
            }
            catch ( Throwable t ) {
                return false;
            }
        }

        return true;

    }

    @Override
    public boolean recruitPersonnel( AirlinePersonnel airlinePersonnel ) throws Exception {

        if( airlinePersonnel == null ) {
            throw new Exception("AirlinePersonnel cannot be null.");
        }

        if( airlineSystemStorage.getCabin_crew().contains( airlinePersonnel ) ||
                airlineSystemStorage.getPilots().contains( airlinePersonnel ) ) {
            return false;
        }

        if( airlinePersonnel.isPilot ) {

            try {
                airlineSystemStorage.getPilots().add( airlinePersonnel );
            }
            catch ( Throwable t ) {
                return false;
            }
        } else {
            try {
                airlineSystemStorage.getCabin_crew().add( airlinePersonnel );
            }
            catch ( Throwable t ) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addDestination(Destination destination) {
        return airlineSystemStorage.getListOfDestination().add(destination);
    }

    @Override
    public boolean removeDestination(Destination destination) {
        return airlineSystemStorage.getListOfDestination().removeIf(ele ->ele.equals(destination));
    }

    /**
     * Get a new aircraft.
     * @param originAsCountry
     * @return Not clear and specified.
     */
    @Override
    public boolean add_aircraft( String originAsCountry ,Double wingspan,Double passengerCapacity,Double emptyWeightAsKg , Double maxFuelCapacity ) {

        Aircraft temp = new Aircraft(null, originAsCountry, airlineSystemStorage.increment_Aircraft_counter()
                ,  null,null, null,wingspan,passengerCapacity, emptyWeightAsKg, maxFuelCapacity);

        if(passengerCapacity<0 || emptyWeightAsKg<0 || maxFuelCapacity>0)
            return false;

        for(Aircraft ele : airlineSystemStorage.getListOfAirCraft() ){
            if(ele.equals(temp))
                return false;
        }

        return airlineSystemStorage.getListOfAirCraft().add( temp );
    }


    @Override
    public boolean remove_aircraft(Aircraft aircraft){
        return airlineSystemStorage.getListOfAirCraft().removeIf(ele->ele.equals(aircraft));
    }

    /**
     * @inheritDoc
     */
    public void addFlight(Destination source, Destination target,int capacity,int price) {
        String company = airlineSystemStorage.getNameOfTrademarkAsIdentifier();
        String UAID_KEY = airlineSystemStorage.getUAID_KEY();
        DateTime dateTime = new DateTime();
        Aircraft aircraft;
        // Collection<AirlinePersonnel> pilots, cabin_crew;

        Flight flight = new Flight(company,UAID_KEY,source,target,dateTime,capacity,price,assignPilot(),assingCabincrew());
        try {
            flight.setAircraft(assignAircraft(flight));
        }catch (Exception e){
            System.out.println(e);
            removeFlight(flight);
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean removeFlight(Flight flight) {
        return airlineSystemStorage.getListOfFlight().removeIf(ele -> ele.equals(flight));
    }

    /**
     * Sets the argument flight's to aircrafts static flight score,
     * then re-calculate aircraft's score then sorts them according to
     * this scores. In the end assigns the top value in the list to the
     * given flight as aircraft
     * @param flight Flight which we look up for most optimum aircraft
     * @return the found aircraft if there are aircraft
     * @throws Exception Throws an exception when there is no aircraft in the hangar
     */
    private Aircraft assignAircraft(Flight flight) throws Exception {
        if(airlineSystemStorage.getListOfAirCraft().size()!=0){
            Aircraft.setFlightScore(flight.getScore());
            for(Aircraft ele:airlineSystemStorage.getListOfAirCraft())
                ele.assignCompare();
            airlineSystemStorage.getListOfAirCraft().sort(Aircraft.getComparator());
            return airlineSystemStorage.getListOfAirCraft().get(0);
        }
        else
            throw(new Exception("There is no aircraft in stock"));

    }

    private List<AirlinePersonnel> assignPilot(){
      List<AirlinePersonnel> pilots = new LinkedList<AirlinePersonnel>();

      AirlinePersonnel temp = airlineSystemStorage.getPilots().poll();
      pilots.add(temp);
      airlineSystemStorage.getPilots().offer(temp);

      temp = airlineSystemStorage.getPilots().poll();
      pilots.add(temp);
      airlineSystemStorage.getPilots().offer(temp);

      return pilots;
    }

    private List<AirlinePersonnel> assingCabincrew(){
        List<AirlinePersonnel> crew = new LinkedList<AirlinePersonnel>();

        AirlinePersonnel temp = airlineSystemStorage.getCabin_crew().poll();
        crew.add(temp);
        airlineSystemStorage.getCabin_crew().offer(temp);

        temp = airlineSystemStorage.getCabin_crew().poll();
        crew.add(temp);
        airlineSystemStorage.getCabin_crew().offer(temp);

        return crew;
    }

}
