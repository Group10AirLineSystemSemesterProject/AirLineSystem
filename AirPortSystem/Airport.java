import Airline.Airline;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents airports
 */
public class Airport
{
    // includes instances of customers, airlines, shops,
    // company managers, shop managers and airport admins

    List<Customer> customers = new ArrayList<>();
    List<Airline> airlines = new ArrayList<>();
    List<AirportPackage.Shop> shops = new ArrayList<>();
    List<CompanyManager> companyManagers = new ArrayList<>();
    List<AirportPackage.ShopManager> shopManagers = new ArrayList<>();
    List<AirportAdmin> airportAdmins = new ArrayList<>();

}
