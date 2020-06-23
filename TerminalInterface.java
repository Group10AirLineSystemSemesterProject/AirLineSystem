import Airport.Airport;
import Airport.AirportAdmin;
import Airport.AirportSystemStorage;
import Airport.Place;
import Airport.PlaceType;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TerminalInterface {
    public static final String AirportName = "Tacettin Kennedy Airport";
    public static final String portAdminName = "Şükrü";
    public static final String portAdminSurname = "Ufkabakar";
    public static final String portAdmiSSN = "12345678";
    public static final String portAdminPassword = "12345678";

    public static void main(String[] args) {
        try{
            Airport airport = new Airport(AirportName);
            AirportSystemStorage portStorage = new AirportSystemStorage();
            AirportAdmin portAdmin = new AirportAdmin(portAdminName,portAdminSurname,portAdmiSSN,portAdminPassword,portStorage);
            


        }catch (Exception e){
            System.out.println(e);
        }

    }
}
