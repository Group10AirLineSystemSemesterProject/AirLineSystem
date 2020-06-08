package Airline;

public interface AirlineAdminDomain {

    /**
     * Recruit a personnel.
     * @param personnel Airline Personnel.
     * @return Not clear and specified.
     */
    public boolean recruitPersonnel( AirlinePersonnel personnel );

    /**
     * Add a new Destination.
     * @param destination a new destination.
     * @return Not clear and specified.
     */
    public boolean addDestination( Destination destination );

    /**
     * Remove a destination from the system.
     * @param destination destination.
     * @return
     */
    public boolean removeDestination(Destination destination);

    /**
     * Get a new aircraft.
     * @param originAsCountry
     * @return Not clear and specified.
     */
    public boolean add_aircraft( String originAsCountry ,Double wingspan,Double passengerCapacity,Double emptyWeightAsKg , Double maxFuelCapacity );

    /**
     * Remove an aircraft from the system.
     * @return true if airline does exist otherwise return false.
     */
    public boolean remove_aircraft();

}
