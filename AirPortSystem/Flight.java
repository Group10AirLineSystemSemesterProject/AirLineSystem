package AirportPackage;

import AirportPackage.AirlinePackage.AirlinePersonnel;

public class Flight {

    String plane_type;
    String destination;
    String company;
    Time time;
    int capacity;
    int price;
    AirlinePersonnel[] pilots;
    AirlinePersonnel[] cabin_crew;

    public Flight(String company,String plane_type, String destination, int hour, int minute, int capacity, int price, AirlinePersonnel[] pilots, AirlinePersonnel[] cabin_crew){
        this.company = company;
        this.plane_type=plane_type;
        this.destination=destination;
        this.time = new Time(hour,minute);
        this.capacity=capacity;
        this.price=price;
//        this.pilots=pilots;// array copy should be performed
//        this.cabin_crew=cabin_crew; // array copy should be performed
    }

    public String getPlane_type() {
        return plane_type;
    }

    public String getDestination() {
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

    public AirlinePersonnel[] getCabin_crew() {
        return cabin_crew;
    }

    public AirlinePersonnel[] getPilots() {
        return pilots;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public void setPlane_type(String plane_type){
        this.plane_type=plane_type;
    }
    public void setDestination(String destination) {
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
    public void setPilots(AirlinePersonnel[] pilots) {
        this.pilots = pilots;
    }
    public void setCabin_crew(AirlinePersonnel[] cabin_crew) {
        this.cabin_crew = cabin_crew;
    }

    @Override
    public boolean equals(Object obj) {
        try{
            Flight temp = (Flight)obj;
            if(temp.company.equals(company) && temp.plane_type.equals(plane_type) && temp.capacity ==capacity && temp.time.equals(time))
                return true;
            return false;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

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