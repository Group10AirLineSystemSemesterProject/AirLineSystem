package Airline;

import java.util.Collection;

/**
 * Class for flight representation
 * @author Bilal Bayrakdar
 * version 1.0
 */
public class Flight {

    Aircraft aircraft;
    Destination destination;
    String company;
    Time time;
    int capacity;
    int price;
    Collection<AirlinePersonnel> pilots;
    Collection<AirlinePersonnel> cabin_crew;

    /**
     * Flight Constructor which requires all parameters
     * @param company company name
     * @param aircraft
     * @param destination
     * @param hour
     * @param minute
     * @param capacity
     * @param price
     * @param pilots    
     * @param cabin_crew
     */
    public Flight(String company,Aircraft aircraft, Destination destination, int hour, int minute, int capacity, int price, Collection<AirlinePersonnel> pilots, Collection<AirlinePersonnel> cabin_crew){

        this.company = company;
        this.aircraft=aircraft;
        this.destination=destination;
        this.time = new Time(hour,minute);
        this.capacity=capacity;
        this.price=price;

        // this.pilots=pilots;// array copy should be performed
        // this.cabin_crew=cabin_crew; // array copy should be performed
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public Destination getDestination() {
        return destination;
    }

    public String getCompany() {
        return company;
    }

    public Time getTime() {
        return time;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public Collection<AirlinePersonnel> getCabin_crew() {
        return cabin_crew;
    }

    public Collection<AirlinePersonnel> getPilots() {
        return pilots;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public void setAircraft(Aircraft aircraft){
        this.aircraft = aircraft;
    }
    public void setDestination(Destination destination) {
        this.destination = destination;
    }
    public void setTime(Time time) {
        this.time = time;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setPilots(Collection<AirlinePersonnel> pilots) {
        this.pilots = pilots;
    }
    public void setCabin_crew(Collection<AirlinePersonnel> cabin_crew) {
        this.cabin_crew = cabin_crew;
    }

    @Override
    public boolean equals(Object obj) {
        try{
            Flight temp = (Flight)obj;
            if(temp.company.equals(company) && temp.aircraft.equals(aircraft) && temp.capacity ==capacity && temp.time.equals(time))
                return true;
            return false;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Company:\t" + company + "\n" +
                "Plane type:\t" + aircraft + "\n" +
                "Destination:\t" + destination + "\n" +
                "Time:\t" + time + "\n" +
                "Capacity:\t" + capacity + "\n" +
                "Price:\t" + price + "\n" +
                "Pilots:\t" + pilots + "\n" +
                "Cabin Crew:\t" + cabin_crew + "\n";
    }

    /**
     * Time class for operating flight time issues
     * which implements comparable for managing time
     * comparing issues
     * @author Bilal Bayrakdar
     */
    private static class Time implements Comparable<Time>{
        int hour,minute;
        Time(int hour,int minute){
            this.hour=hour;
            this.minute=minute;
        }

        @Override
        public int compareTo(Time time) {
            return 60*(hour-time.hour)+minute-minute;
        }

        @Override
        public boolean equals(Object obj) {
            try{
                Time temp = (Time) obj;
                return temp.hour==hour && temp.minute==minute;
            }catch (Exception e){
                System.out.println(e);
                return false;
            }
        }

        @Override
        public String toString() {
            return String.format("%d:%d",hour,minute);
        }
    }
}