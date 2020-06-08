package Airline;
import java.lang.Math.*;

/**
 * Destination properties class which is designed
 * according to perspective of current airport.
 * @author Nevzat Seferoglu and Bilal Bayrakdar
 * @version 1.0
 */
public class Destination {

    private String name;
    private Double latitude;
    private Double longitude;
    private Double altitude;

    public Destination( String name , Double latitude , Double longitude , Double altitude ) {

        //exception handling.
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;

    }
    public Double calculateDistance( Destination targetDestination ) {

        return Math.sqrt( Math.pow(targetDestination.getAltitude() - getAltitude(),2 )
                + Math.pow(targetDestination.getLongitude() - getLongitude(),2)
                + Math.pow(targetDestination.getAltitude() - getAltitude(),2));
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public String getName() {
        return name;
    }
    public double getAltitude() {
        return altitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object obj) {

        if( obj == this ) {
            return true;
        }

        if( !(obj instanceof Destination) ) {
            return false;
        }

        return ((Destination) obj).name.equals(name) &&
                ((Destination) obj).latitude.equals(latitude) &&
                ((Destination) obj).longitude.equals(longitude) &&
                ((Destination) obj).altitude.equals(altitude);

    }

    @Override
    public String toString() {
        return "Name : " + name + " \n" +
                "Latitude : " + latitude + " \n" +
                "Longitude : " + longitude + " \n" +
                "Altitude : " + altitude + " \n";
    }
}
