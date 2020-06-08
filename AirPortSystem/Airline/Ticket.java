package Airline;

/**
 * Ticket Information.
 */
public class Ticket {


    AirlineSystemStorage airlineSystemStorage;

    private Flight flight;
    private Customer customer;
    private TicketType typeOfTicket;
    private boolean isReady;

    protected static class PNR {

        private Flight flight;
        private Customer customer;

        String getUniquePNR() {
            return  "";
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return super.toString();
        }

    }

    public Ticket( Flight flight , Customer customer , AirlineSystemStorage airlineSystemStorage) throws Exception {

        if( flight == null || customer == null || airlineSystemStorage == null ) {
             throw new Exception("Flight or customer or systemStorage cannot be null.");
        }

        this.flight = flight;
        this.customer = customer;
        this.airlineSystemStorage = airlineSystemStorage;
        this.isReady = false;

    }
    public Ticket getActualTicket( ) { return null; }


    /**
     * Check whether flight is valid.
     * @return true if flight does exist otherwise return false.
     */
    private boolean isValidFlight() {

        /* Check the destination via systemStorage */

        return false;
    }

    /**
     * Query the customer personal information.
     * @return true if flight does exist otherwise return false.
     */
    private boolean isValidCustomer() {
        /* Check the customer */
        return false;
    }

    public Customer getCustomer() {
        return customer;
    }
    public Flight getFlight() {
        return flight;
    }
    public AirlineSystemStorage getAirlineSystemStorage() {
        return airlineSystemStorage;
    }
    public TicketType getTypeOfTicket() {
        return typeOfTicket;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public void setReady(boolean ready) {
        isReady = ready;
    }
    public void setAirlineSystemStorage(AirlineSystemStorage airlineSystemStorage) {
        this.airlineSystemStorage = airlineSystemStorage;
    }
    public void setTypeOfTicket(TicketType typeOfTicket) {
        this.typeOfTicket = typeOfTicket;
    }
}
