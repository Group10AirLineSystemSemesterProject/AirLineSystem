package Airline;

import Airport.AirportPersonnel;
import Airport.Customer;
import Client.Person;
import Client.UserInterface;
import DataStructures.MapGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Airline management class.
 * @author Nevzat Seferoglu and Bilal Bayrakdar
 * @version 1.5
 */
public class Airline {

    /**
     * Current airport.
     */
    Destination localAirport;
    // bu field'ı tutmamıza gerek yok çünkü airline uçuş ayarlarken
    // erişebildiği destinationlarla rotasını belirlemeli.
    // destination has a airport gibi bir yapı oluşturulabilir.
    // veya bu class direkt airport'a append edilebilir.


    // System storage'ın final olması daha mantıklı çünkü bu class oluştuktan
    // sonra yalnızca kendi methodlar ı call edilerek işlem gerçekleşiyor,
    // bu obje yerine başka obje atamsı gibi işlemler gerçekleşmiyor.

    /**
     * General data storage of airline
     */
    private final AirlineSystemStorage airlineSystemStorage;

    private double commissionRate;


    public Queue<AirlinePersonnel> getPilots() {
        return airlineSystemStorage.getPilots();
    }
    public  Queue<AirlinePersonnel> getCabinCrew() {
        return airlineSystemStorage.getCabin_crew();
    }
    public  AirlineAdmin getAdmin() {
        return airlineSystemStorage.getAdmin();
    }


    /**
     * No parameter constructor.
     */
    public Airline(Destination localAirport , double commissionRate, AirlineAdmin admin , String nameOfTrademarkAsIdentifier, final String uaid_key,
                   MapGraph ways, ArrayList<Destination> dests) {

        this.localAirport = localAirport;
        airlineSystemStorage = new AirlineSystemStorage(admin,nameOfTrademarkAsIdentifier,uaid_key,ways,dests);
        this.commissionRate = commissionRate;

    }

    public Ticket createTicket(Customer customer,Flight flight) throws Exception {
        if(flight.isTicketAble())
            return new Ticket(flight,customer,airlineSystemStorage);
        else
            throw(new Exception("Choosen filght's tickets are currently unavailable! "));
    }

    public void deleteticket(Ticket ticket){
        ticket.deleteTicket();
    }

    private AirlineSystemStorage getAirlineSystemStorage() {
        return airlineSystemStorage;
    }


    public void setCommissionRate( double commissionRate ) throws Exception {
        if( commissionRate < 0 ) {
            throw new Exception("CommissionRate cannot be negative.");
        }

        this.commissionRate = commissionRate;
    }

    public String getUAID_KEY(){
        return airlineSystemStorage.getUAID_KEY();
    }

    public AirlineAdmin getAdminWithSSN(String SSN){
        if(getAdmin().getSSN().equals(SSN))
            return getAdmin();
        else
            return null;
    }

    public AirlinePersonnel getPersonWithSSN(String SSN){
        for(AirlinePersonnel ele:airlineSystemStorage.getPilots()){
            if(ele.getSSN().equals(SSN))
                return ele;
        }
        for(AirlinePersonnel ele: airlineSystemStorage.getCabin_crew()){
            if(ele.getSSN().equals(SSN))
                return ele;
        }
        return null;
    }

}
