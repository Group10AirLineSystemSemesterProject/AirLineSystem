package Airline;
import java.util.Collection;

public class AirlineSystemStorage {


    int aircraft_counter;

    /**
     * Admin list of airline.
     */
    private Collection<AirlineAdmin> admins;

    public int increment_Aircraft_counter() {
        return ++aircraft_counter;
    }

    public AirlineSystemStorage() {

        aircraft_counter = 0;
        /* Initialization of containers */

        /*
        Collection< Aircraft > listOfTicket;
        Collection< Aircraft > listOfAirCraft;
        Collection< Destination > listOfDestination;
        Collection< AirlinePersonnel > personnelList;
        */

    }

    /**
     * Aircraft Container.
     */
    private Collection< Aircraft > listOfTicket;

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

    /*
    Customer Container.
     */
    public Collection< Customer > listOfCustomer;
    /*
    Guest Container.
     */
    private Collection< Guest > listOfGuest;
    /*
    Ticketed Container
     */
    private Collection< Ticketed > listOfTicketed;

    /**
     * Get aircraft List
     * @return list of aircraft.
     */
    public Collection<Aircraft> getListOfAirCraft() {
        return listOfAirCraft;
    }

    /**
     * Get personnel List
     * @return list of personnel.
     */
    public Collection<AirlinePersonnel> getPersonnelList() {
        return personnelList;
    }

    /**
     * Get Destination List
     * @return list of destination.
     */
    public Collection<Destination> getListOfDestination() {
        return listOfDestination;
    }

    /**
     * Get Customer List
     * @return list of customer.
     */
    public Collection<Customer> getListOfCustomer() { return listOfCustomer; }
    
    /**
     * Get Guest List
     * @return list of guest.
     */
    public Collection<Guest> getListOfGuest() { return listOfGuest; }
    
    /**
     * Get Ticketed List
     * @return list of ticketed.
     */
    public Collection<Ticketed> getListOfTicketed() { return listOfTicketed; }

    /**
     * Set list of aircraft.
     * @param listOfAirCraft Aircraft list.
     */
    public void setListOfAirCraft(Collection<Aircraft> listOfAirCraft) {
        this.listOfAirCraft = listOfAirCraft;
    }

    /**
     * Set list of destination.
     * @param listOfDestination destination list.
     */
    public void setListOfDestination(Collection<Destination> listOfDestination) {
        this.listOfDestination = listOfDestination;
    }

    /**
     * Set the aircraft counter.
     * @param aircraft_counter unique aircraft counter.
     */
    public void setAircraft_counter(int aircraft_counter) {
        this.aircraft_counter = aircraft_counter;
    }

    /**
     * Set list of personnel.
     * @param personnelList personnel list.
     */
    public void setPersonnelList(Collection<AirlinePersonnel> personnelList) {
        this.personnelList = personnelList;
    }

    /**
     * Set list of Customer.
     * @param listOfCustomer Customer list.
     */
    public void setListOfCustomer(Collection<Customer> listOfCustomer) { this.listOfCustomer = listOfCustomer; }

    /**
     * Set list of Guest.
     * @param listOfGuest Guest list.
     */
    public void setListOfGuest(Collection<Guest> listOfGuest) { this.listOfGuest = listOfGuest; }

    /**
     * Set list of Ticketed.
     * @param listOfTicketed Ticketed list.
     */
    public void setListOfTicketed(Collection<Ticketed> listOfTicketed) { this.listOfTicketed = listOfTicketed; }

    public Collection<Aircraft> getListOfTicket() {
        return listOfTicket;
    }

    public int getAircraftCounter() {
        return aircraft_counter;
    }

    public Collection<AirlineAdmin> getAdmins() {
        return admins;
    }
    public void setAdmins(Collection<AirlineAdmin> admins) {
        this.admins = admins;
    }
}
