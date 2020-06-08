package Airline;

public class AirlineAdmin extends AirlinePersonnel implements AirlineAdminDomain{


    AirlineSystemStorage airlineSystemStorage;


    public AirlineAdmin( String name , String surname , AirlineSystemStorage airlineSystemStorage ) {
        // super( name ,surname ); airline personel den tureyecek.
        this.airlineSystemStorage = airlineSystemStorage;
    }


    @Override
    public boolean recruitPersonnel(AirlinePersonnel personnel) {
        return false;
    }

    @Override
    public boolean addDestination(Destination destination) {
        return false;
    }

    @Override
    public boolean removeDestination(Destination destination) {
        return false;
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
    public boolean remove_aircraft(){
        return true;

    }
}
