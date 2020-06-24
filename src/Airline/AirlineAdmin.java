package Airline;

import Client.UserInterface;
import Client.User;
import java.util.*;

public class AirlineAdmin extends User implements AirlineAdminDomain , UserInterface {

    Airline airline;

    public AirlineAdmin( String name , String surname , Airline airline ) throws Exception {

        super( name , surname );
        if( airline == null ) {
            throw new Exception("Airline cannot be null.");
        }
        this.airline = airline;
    }

    public void menu(){

        int choice;
        Scanner in = new Scanner(System.in);
        boolean loop = true;

        while(loop){

            System.out.printf("1- Recruit Personnel.\n");
            System.out.printf("2- Dismiss Personnel\n");
            System.out.printf("3- Add Destination.\n");
            System.out.printf("4- Remove Destination.\n");
            System.out.printf("5- Add Aircraft.\n");
            System.out.printf("6- Remove Aircraft\n");
            System.out.printf("7- Add Flight.\n");
            System.out.printf("8- Remove Flight.\n");
            System.out.printf("9 -Exit from administration page.\n");

            choice = in.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Please enter personnel name: ");
                    String perName = in.nextLine();
                    System.out.print("Please enter personnel surname: ");
                    String perSurname = in.nextLine();
                    System.out.print("Please enter an SSN: ");
                    String perSSN = in.nextLine();
                    System.out.println("Please enter a password: ");
                    String perPass = in.nextLine();
                    if(perName != null && perSurname!=null && !perName.equals("") && !perSurname.equals("")&& getAirline().getAirportSystemStorage().getUserWithSSN(perSSN)==null)
                        try{
                            System.out.println("Is the new employee pilot? (Y/N)");
                            String ans = in.nextLine();
                            AirlinePersonnel airlinePersonnel;
                            if(ans.equals("Y") || ans.equals("y"))
                                airlinePersonnel = new AirlinePersonnel(perName,perSurname,true,perSSN,perPass);
                            else
                                airlinePersonnel = new AirlinePersonnel(perName,perSurname,false,perSSN,perPass);
                                recruitPersonnel(airlinePersonnel);
                        }catch (Exception e){
                            System.out.println(e);
                        }
                    break;
                case 2:
                    System.out.println("Is the employee who will be removed pilot ?");
                    for(AirlinePersonnel ele:getAirline().getAirlineSystemStorage().getCabin_crew())
                        System.out.println(ele);
                    getAirline().getAirlineSystemStorage().getCabin_crew().removeIf(k->{

                    });

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9: loop = false;
                    break;
                default: System.out.printf("Error. Your input is invalid..\n");

            }
        }
        System.out.printf("Exiting...\n");
    }

    public Airline getAirline() {
        return airline;
    }

    public boolean dismissPersonnel(AirlinePersonnel airlinePersonnel ) throws Exception {

        if( airlinePersonnel == null ) {
            throw new Exception("AirlinePersonnel cannot be null.");
        }

        if( !(airline.getAirlineSystemStorage().getCabin_crew().contains( airlinePersonnel ) ||
                airline.getAirlineSystemStorage().getPilots().contains( airlinePersonnel )) ) {
            return false;
        }

        if( airlinePersonnel.isPilot ) {

            try {
                airline.getAirlineSystemStorage().getPilots().remove(airlinePersonnel);
            }
            catch ( Throwable t ) {
                return false;
            }
        } else {
            try {
                airline.getAirlineSystemStorage().getCabin_crew().remove(airlinePersonnel);
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

        if( airline.getAirlineSystemStorage().getCabin_crew().contains( airlinePersonnel ) ||
                airline.getAirlineSystemStorage().getPilots().contains( airlinePersonnel ) ) {
            return false;
        }

        if( airlinePersonnel.isPilot ) {

            try {
                airline.getAirlineSystemStorage().getPilots().add( airlinePersonnel );
            }
            catch ( Throwable t ) {
                return false;
            }
        } else {
            try {
                airline.getAirlineSystemStorage().getCabin_crew().add( airlinePersonnel );
            }
            catch ( Throwable t ) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addDestination(Destination destination) {
        return airline.getAirlineSystemStorage().getListOfDestination().add(destination);
    }

    @Override
    public boolean removeDestination(Destination destination) {
        return airline.getAirlineSystemStorage().getListOfDestination().removeIf(ele ->ele.equals(destination));
    }

    /**
     * Get a new aircraft.
     * @param originAsCountry
     * @return Not clear and specified.
     */
    @Override
    public boolean add_aircraft( String originAsCountry ,Double wingspan,Double passengerCapacity,Double emptyWeightAsKg , Double maxFuelCapacity ) {

        Aircraft temp = new Aircraft(null, originAsCountry, airline.getAirlineSystemStorage().increment_Aircraft_counter()
                ,  null,null, null,wingspan,passengerCapacity, emptyWeightAsKg, maxFuelCapacity);

        if(passengerCapacity<0 || emptyWeightAsKg<0 || maxFuelCapacity>0)
            return false;

        for(Aircraft ele : airline.getAirlineSystemStorage().getListOfAirCraft() ){
            if(ele.equals(temp))
                return false;
        }

        return airline.getAirlineSystemStorage().getListOfAirCraft().add( temp );
    }


    @Override
    public boolean remove_aircraft(Aircraft aircraft){
        return airline.getAirlineSystemStorage().getListOfAirCraft().removeIf(ele->ele.equals(aircraft));
    }

    /**
     * @inheritDoc
     */
    public void addFlight(Destination target,int capacity,int price) {

        if( airline.getAirlineSystemStorage().ways.isEdge(0,airline.getAirlineSystemStorage().dests.indexOf(target)));

        String company = airline.getAirlineSystemStorage().getNameOfTrademarkAsIdentifier();
        String UAID_KEY = airline.getAirlineSystemStorage().getNameOfTrademarkAsIdentifier();
        DateTime dateTime = new DateTime();
        Aircraft aircraft;
        // Collection<AirlinePersonnel> pilots, cabin_crew;

        Flight flight = new Flight(company,UAID_KEY,airline.getAirlineSystemStorage().dests.get(0),target,dateTime,capacity,price,assignPilot(),assingCabincrew());
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
        return airline.getAirlineSystemStorage().getListOfFlight().removeIf(ele -> ele.equals(flight));
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
        if(airline.getAirlineSystemStorage().getListOfAirCraft().size()!=0){
            Aircraft.setFlightScore(flight.getScore());
            for(Aircraft ele:airline.getAirlineSystemStorage().getListOfAirCraft())
                ele.assignCompare();
            airline.getAirlineSystemStorage().getListOfAirCraft().sort(Aircraft.getComparator());
            return airline.getAirlineSystemStorage().getListOfAirCraft().get(0);
        }
        else
            throw(new Exception("There is no aircraft in stock"));

    }

    private List<AirlinePersonnel> assignPilot(){
      List<AirlinePersonnel> pilots = new LinkedList<AirlinePersonnel>();

      AirlinePersonnel temp = airline.getAirlineSystemStorage().getPilots().poll();
      pilots.add(temp);
      airline.getAirlineSystemStorage().getPilots().offer(temp);

      temp = airline.getAirlineSystemStorage().getPilots().poll();
      pilots.add(temp);
      airline.getAirlineSystemStorage().getPilots().offer(temp);

      return pilots;
    }

    private List<AirlinePersonnel> assingCabincrew(){
        List<AirlinePersonnel> crew = new LinkedList<AirlinePersonnel>();

        AirlinePersonnel temp = airline.getAirlineSystemStorage().getCabin_crew().poll();
        crew.add(temp);
        airline.getAirlineSystemStorage().getCabin_crew().offer(temp);

        temp = airline.getAirlineSystemStorage().getCabin_crew().poll();
        crew.add(temp);
        airline.getAirlineSystemStorage().getCabin_crew().offer(temp);

        return crew;
    }

}
