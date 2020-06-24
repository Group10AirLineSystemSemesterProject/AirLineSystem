package Airport;

import Airline.*;
import Client.User;
import Client.UserInterface;
import DataStructures.Edge;
import DataStructures.MapGraph;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/** AirportAdmin class for Admins of airport. Extended from Person Class.
 * This class administrates Airport business as flights, shops.. */
public class AirportAdmin extends User implements UserInterface , AirportAdminInterface {

    /**Social security number, stored as String.*/
    private String SSN;

    /**Password to log in, stored as String.*/
    private String password;

    /**Helps to reach AirportSystemStorage class' data.*/
    private AirportSystemStorage airportSystemStorage;

    /** AirportAdmin constructor.
     * @param name As the name of user.
     * @param surname As the surname of user.
     * @param password As the password of the user, that helps logging in.
     * @param airportSystemStorage As current airport to be in.
     * @param SSN As the SSN of the user.
     * */
    public AirportAdmin(String name , String surname , final String SSN , final String password
            , final AirportSystemStorage airportSystemStorage  ) throws Exception {

        super(name, surname , SSN , password );
        this.airportSystemStorage = airportSystemStorage;

    }

    public void menu() throws Exception {

        int choice;
        Scanner in = new Scanner(System.in);
        boolean loop = true, loop2 = true;


        while(loop){
            System.out.printf("1- Personal info menu \n");
            System.out.printf("2- Set SSN\n");
            System.out.printf("3- Set password.\n");
            System.out.printf("4- Airline administration.\n");
            System.out.printf("5- Airport Personnel administration.\n");
            System.out.printf("6- Shop administration.\n");
            System.out.printf("7- Destination administration.\n");
            System.out.printf("8- Exit.\n");

            choice = in.nextInt();

            switch (choice){
                case 1:
                    System.out.println(this);
                    break;
                case 2:
                    airportSystemStorage.changeSSNwithMenu(in);
                    break;
                case 3:
                    airportSystemStorage.changePasswordwithMenu(in);
                    break;
                case 4:
                    loop2 = true;
                    while (loop2){
                        System.out.printf("1- See all airlines.\n");
                        System.out.printf("2- Add an airline.\n");
                        System.out.printf("3- Remove an airline.\n");
                        System.out.printf("4- Set commission rate.\n");
                        System.out.printf("5- Exit.\n");

                        choice = in.nextInt();

                        switch (choice){
                            case 1:
                                for(Map.Entry<String,Airline> ele:airportSystemStorage.getAirlines().entrySet())
                                    System.out.println(ele);
                            case 2:


                                System.out.print("Enter the name of admin : ");
                                String nameOfAdmin = in.nextLine();

                                while (  nameOfAdmin == null || nameOfAdmin.equals("") ) {
                                    System.out.print("Enter the name of admin : ");
                                    nameOfAdmin = in.nextLine();
                                }

                                System.out.print("Enter the surname of admin : ");
                                String surnameOfAdmin = in.nextLine();

                                while (  surnameOfAdmin == null || surnameOfAdmin.equals("") ) {
                                    System.out.print("Enter the surname of admin : ");
                                    surnameOfAdmin = in.nextLine();
                                }

                                System.out.print("Enter the SSN of admin : ");
                                String SSN = in.nextLine();

                                while (  SSN == null || SSN.equals("") ) {
                                    System.out.print("Enter the SSN of admin : ");
                                    SSN = in.nextLine();
                                }

                                User isExist = airportSystemStorage.getUserWithSSN( SSN );

                                if( isExist != null ) {
                                    System.out.println("There already exists an given SSN !");
                                    System.out.print("Enter the SSN of admin : ");
                                    SSN = in.nextLine();
                                    while (  SSN == null || SSN.equals("") ) {
                                        System.out.print("Enter the SSN of admin : ");
                                        SSN = in.nextLine();
                                    }
                                }

                                System.out.print("Enter the password of admin : ");
                                String password = in.nextLine();

                                while (  password == null || password.equals("") ) {
                                    System.out.print("Enter the password of admin : ");
                                    password = in.nextLine();
                                }

                                System.out.print("Enter the name of trademark of airline : ");
                                String nameOfAirline = in.nextLine();

                                while (  nameOfAirline == null || nameOfAirline.equals("") ) {
                                    System.out.print("Enter the name of trademark of airline : ");
                                    nameOfAirline = in.nextLine();
                                }

                                while ( airportSystemStorage.getAirlines().containsKey( nameOfAirline ) ) {
                                    System.out.println("There is already an airline with this trademark.");
                                    System.out.print("Enter the name of trademark of airline : ");
                                    nameOfAirline = in.nextLine();
                                }

                                System.out.print("Enter the commission rateof airline : ");
                                double comissionRate = in.nextDouble();

                                Airline newAirline = new Airline( airportSystemStorage.destinations.get(0) , comissionRate , null
                                    , nameOfAirline , airportSystemStorage.ways , airportSystemStorage.destinations , airportSystemStorage );

                                newAirline.getAirlineSystemStorage().setAdmin( new AirlineAdmin(new User( nameOfAdmin , surnameOfAdmin, SSN , password ) , newAirline ));
                                break;

                            case 3:
                                System.out.print("Enter the name of trademark of airline : ");
                                String removedAirlineName = in.nextLine();

                                while (  removedAirlineName == null || removedAirlineName.equals("") ) {
                                    System.out.print("Enter the name of trademark of airline : ");
                                    removedAirlineName = in.nextLine();
                                }

                                Airline tempAirline1 = new Airline( airportSystemStorage.destinations.get(0) , 0 , null
                                        , removedAirlineName , airportSystemStorage.ways , airportSystemStorage.destinations , airportSystemStorage );

                                if( airportSystemStorage.getAirlines().containsKey( removedAirlineName ) ) {
                                    airportSystemStorage.getAirlines().remove( tempAirline1 );
                                } else {
                                    System.out.println("There is no airline with this name.");
                                }
                                break;

                            case 4:

                                System.out.print("Commission rate : ");
                                Double commissionRate = in.nextDouble();

                                System.out.print("Enter the name of trademark of airline : ");
                                String forNewCommissionRate = in.nextLine();

                                while (  forNewCommissionRate == null || forNewCommissionRate.equals("") ) {
                                    System.out.print("Enter the name of trademark of airline : ");
                                    forNewCommissionRate = in.nextLine();
                                }

                                Airline tempAirline2 = new Airline( airportSystemStorage.destinations.get(0) , 0 , null
                                        , forNewCommissionRate , airportSystemStorage.ways , airportSystemStorage.destinations , airportSystemStorage );

                                if( airportSystemStorage.getAirlines().containsKey( forNewCommissionRate ) ) {
                                    airportSystemStorage.getAirlines().remove( tempAirline2 );
                                } else {
                                    System.out.println("There is no airline with this name.");
                                }

                                break;

                            case 5: loop2 = false;
                                break;
                            default: System.out.printf("Error. Your input is invalid..\n");
                        }
                    }
                    break;
                case 5:
                    loop2 = true;
                    while (loop2){
                        System.out.printf("1- Add an airport personnel.\n");
                        System.out.printf("2- Remove an airport personnel.\n");
                        System.out.printf("3- See all airport personals.\n");
                        System.out.printf("4- Exit.\n");

                        choice = in.nextInt();

                        switch (choice){
                            case 1:
                                System.out.print("Enter the name of Airport Personnel : ");
                                String nameOfAirportPersonnel = in.nextLine();

                                while (  nameOfAirportPersonnel == null || nameOfAirportPersonnel.equals("") ) {
                                    System.out.print("Enter the name of Airport Personnel : ");
                                    nameOfAirportPersonnel = in.nextLine();
                                }

                                System.out.print("Enter the surname of Airport Personnel : ");
                                String surnameOfAirportPersonnel = in.nextLine();

                                while (  surnameOfAirportPersonnel == null || surnameOfAirportPersonnel.equals("") ) {
                                    System.out.print("Enter the surname of Airport Personnel : ");
                                    surnameOfAirportPersonnel = in.nextLine();
                                }

                                System.out.print("Enter the SSN of Airport Personnel : ");
                                String SSN = in.nextLine();

                                while (  SSN == null || SSN.equals("") ) {
                                    System.out.print("Enter the SSN of Airport Personnel : ");
                                    SSN = in.nextLine();
                                }

                                User isExist = airportSystemStorage.getUserWithSSN( SSN );

                                if( isExist != null ) {
                                    System.out.println("There already exists an given SSN !");
                                    System.out.print("Enter the SSN of Airport Personnel : ");
                                    SSN = in.nextLine();
                                    while (  SSN == null || SSN.equals("") ) {
                                        System.out.print("Enter the SSN of Airport Personnel : ");
                                        SSN = in.nextLine();
                                    }
                                }

                                System.out.print("Enter the password of Airport Personnel : ");
                                String password = in.nextLine();

                                while (  password == null || password.equals("") ) {
                                    System.out.print("Enter the password of Airport Personnel : ");
                                    password = in.nextLine();
                                }

                                airportSystemStorage.getAirportPersonnel().add( new AirportPersonnel( nameOfAirportPersonnel , surnameOfAirportPersonnel
                                        , SSN , password , airportSystemStorage ) );
                                break;

                            case 2:

                                System.out.print("Enter the SSN of Airport Personnel : ");
                                String dismissSSN = in.nextLine();

                                while (  dismissSSN == null || dismissSSN.equals("") ) {
                                    System.out.print("Enter the SSN of Airport Personnel : ");
                                    dismissSSN = in.nextLine();
                                }

                                AirportPersonnel removedPersonnel = new AirportPersonnel("null" , "null" ,dismissSSN
                                        , "null" ,airportSystemStorage);

                                if( airportSystemStorage.getAirportPersonnel().remove( removedPersonnel ) ) {
                                    System.out.println("Airport personnel have been removed.");
                                } else {
                                    System.out.println("There is no Airport personnel with given name.");
                                }
                                break;

                            case 3:

                                for( AirportPersonnel airportPersonnel : airportSystemStorage.getAirportPersonnel() ) {
                                    System.out.println( airportPersonnel );
                                }
                                System.out.println();
                                break;

                            case 4: loop2 = false;
                                break;

                            default: System.out.printf("Error. Your input is invalid..\n");
                        }
                    }
                    break;
                case 6:
                    loop2 = true;
                    while (loop2){
                        System.out.printf("1- See all shops.\n");
                        System.out.printf("2- Add a shop.\n");
                        System.out.printf("3- Remove a shop.\n");
                        System.out.printf("4- Exit.\n");

                        choice = in.nextInt();

                        switch (choice){
                            case 1:
                                for( Place shop : airportSystemStorage.getPlaces() ) {
                                    if( shop instanceof Shop ) {
                                        System.out.println( shop );
                                    }
                                }
                                System.out.println();
                                break;

                            case 2:
                                System.out.print("Enter a name for the shop: ");
                                String shopName = in.nextLine();
                                System.out.print("Please enter shop manager name: ");
                                String perName = in.nextLine();
                                System.out.print("Please enter shop manager surname: ");
                                String perSurname = in.nextLine();
                                System.out.print("Please enter an SSN: ");
                                String perSSN = in.nextLine();
                                System.out.println("Please enter a password: ");
                                String perPass = in.nextLine();
                                System.out.print("Please neter fee of the shop: ");
                                double shopFee = in.nextDouble();
                                ShopManager temp;
                                if(perName != null && perSurname!=null && !perName.equals("") && !perSurname.equals("")&& airportSystemStorage.getUserWithSSN(perSSN)==null){
                                    temp = new ShopManager(perName,perSurname,SSN,perPass,shopFee,airportSystemStorage);
                                    airportSystemStorage.getPlaces().add(new Shop(shopName,temp,(int)shopFee,"14"));
                                }

                                break;

                            case 3:

                                System.out.print("Enter the shop name : ");
                                String shopName = in.nextLine();
                                while (  shopName == null || shopName.equals("") ) {
                                    System.out.print("Enter the shop name : ");
                                    shopName = in.nextLine();
                                }

                                for( Place place : airportSystemStorage.getPlaces() ) {
                                    if( place instanceof Shop || ((Shop)place).getName().equals(shopName)) {
                                        airportSystemStorage.getPlaces().remove( place );
                                        break;
                                    }
                                }

                                break;
                            case 4: loop2 = false;
                                break;
                            default: System.out.printf("Error. Your input is invalid..\n");
                        }
                    }
                    break;
                case 7: loop = false;
                    break;
                default: System.out.printf("Error. Your input is invalid..\n");
            }
        }
    }

    public void addWay(Destination destination) throws Exception {
        Edge e = new Edge(0,airportSystemStorage.destinations.indexOf(destination));
        airportSystemStorage.ways.insertEdge(e);
    }

    @Override
    public boolean addAirportPersonnel( AirportPersonnel airportPersonnel) throws Exception {

        if( airportPersonnel == null ) {
            throw new Exception("AirportPersonnel cannot be null.");
        }

        if( airportSystemStorage.airportPersonnel.contains( airportPersonnel ) ) {
            return false;
        } else {
            airportSystemStorage.airportPersonnel.add( airportPersonnel );
            return true;
        }

    }

    @Override
    public boolean removeAirportPersonnel(AirportPersonnel airportPersonnel) throws Exception {

        if( airportPersonnel == null ) {
            throw new Exception("AirportPersonnel cannot be null.");
        }

        return airportSystemStorage.airportPersonnel.remove(airportPersonnel);
    }

    @Override
    public boolean addShop(Shop shop) throws Exception {

        if( shop == null ) {
            throw new Exception("Shop cannot be null.");
        }

        if( airportSystemStorage.places.contains( shop ) ) {
            return false;
        } else {
            airportSystemStorage.places.add( shop );
            return true;
        }

    }

    @Override
    public boolean removeShop(Shop shop) throws Exception {

        if( shop == null ) {
            throw new Exception("Shop cannot be null.");
        }

        return airportSystemStorage.places.remove(shop);
    }

    @Override
    public boolean addAirline(Airline airline) throws Exception {

        if( airline == null ) {
            throw new Exception("Airline cannot be null.");
        }

        if( airportSystemStorage.airlines.containsValue( airline ) ) {
            return false;
        } else {
            airportSystemStorage.airlines.put( airline.getAirlineSystemStorage().getNameOfTrademarkAsIdentifier() , airline );
            return true;
        }

    }

    @Override
    public boolean removeAirline(Airline airline) throws Exception {

        if( airline == null ) {
            throw new Exception("Airline cannot be null.");
        } else {
            return airportSystemStorage.airlines.remove( airline.getNameofTradeMark() , airline );
        }
    }

    @Override
    public double getAirportFund() {
        return airportSystemStorage.airportFund;
    }

    @Override
    public boolean setCommissionRate( Airline airline , final double commissionRate ) throws Exception {

        if( airline == null ) {
            throw new Exception("Airline cannot be null.");
        }

        if( commissionRate < 0 ) {
            throw new Exception("Commission-Rate cannot be negative number.");
        }

        if( !airportSystemStorage.airlines.containsValue( airline ) ) {
            return false;
        } else {
            airline.setCommissionRate( commissionRate );
            return true;
        }
    }

    @Override
    public boolean addDestination(Destination destination) throws Exception {

        if( destination == null ) {
            throw new Exception("Destination cannot be null.");
        }
        else {
            airportSystemStorage.destinations.add(destination);
            return true;
        }

    }

    @Override
    public boolean removeDestination(Destination destination) throws Exception {

        if( destination == null ) {
            throw new Exception("Destination cannot be null.");
        }
        else {
            airportSystemStorage.destinations.remove(destination);
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        AirportAdmin that = (AirportAdmin) o;

        return SSN.equals(that.SSN);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), SSN);
    }

    @Override
    public String toString() {
        return "AirportAdmin{" +
                "SSN='" + SSN + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
