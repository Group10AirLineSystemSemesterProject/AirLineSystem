import Airport.*;
import Airline.*;
import Client.Person;
import Client.User;
import java.util.*;

public class TerminalInterface {


    Person SSNtoPerson(String SSN , AirportSystemStorage airportSystemStorage ) throws Exception {

        try {

            if( SSN == null ) {
                throw new Exception("SSN cannot be null.");
            }
            if( airportSystemStorage == null ) {
                throw new Exception("airportSystemStorage cannot be null.");
            }

            Person person = null;
            person = airportSystemStorage.getCustomers().get( SSN );

            if( person != null ) {
                return person;
            }

            AirportPersonnel authenticateAirportPersonnel = new AirportPersonnel("","",SSN,"" ,null);
            Iterator<AirportPersonnel> airportPersonnelIterator = airportSystemStorage.getAirportPersonnel().iterator();
            while ( airportPersonnelIterator.hasNext() ) {
                AirportPersonnel airportPersonnel = airportPersonnelIterator.next();
                if( airportPersonnel.equals( authenticateAirportPersonnel ) ) {
                    return airportPersonnel;
                }
            }
            if( airportSystemStorage.getAirportAdmin().getSSN().equals( SSN )) {
                return airportSystemStorage.getAirportAdmin();
            }


            // airline calisanlarindan SSN match ederse match eden kisiyi dondurme yoksa null donecek fonk.
            airportSystemStorage.getAirlines().forEach((k,v) -> {


                    Iterator<AirlinePersonnel> airlinePersonnelIterator1 = v.getPilots().iterator();
                    while ( airlinePersonnelIterator1.hasNext() ) {
                        AirlinePersonnel airlinePersonnel = airlinePersonnelIterator1.next();
                        if( airlinePersonnel.getSSN().equals( SSN ) ) {
                            return airlinePersonnel;
                        }
                    }

                    if( airportSystemStorage.getAirportAdmin().getSSN().equals( SSN )) {
                        return airportSystemStorage.getAirportAdmin();
                    }

                    Iterator<AirlinePersonnel> airlinePersonnelIterator2 = v.getCabinCrew().iterator();
                    while ( airlinePersonnelIterator2.hasNext() ) {
                        AirlinePersonnel airlinePersonnel = airlinePersonnelIterator2.next();
                        if( airlinePersonnel.getSSN().equals( SSN ) ) {
                            return airlinePersonnel;
                        }
                    }

                    if( airportSystemStorage.getAirportAdmin().getSSN().equals( SSN )) {
                        return airportSystemStorage.getAirportAdmin();
                    }

            });

            return null;
        }
        catch ( Exception inAuthentication ) {
            inAuthentication.printStackTrace();
            System.exit(1);
        }

        return null;
    }




    public static void main(String[] args) {


        try{

            Scanner in = new Scanner(System.in);

            System.out.print("Name of airport : ");
            String nameOfAirport = in.nextLine();
            while( nameOfAirport ==null || nameOfAirport.equals("") ) {
                System.out.print("Name of airport : ");
                nameOfAirport = in.nextLine();
            }
            System.out.println();

            System.out.print("Admin Name : ");
            String nameOfAdmin = in.nextLine();
            while( nameOfAdmin ==null || nameOfAdmin.equals("") ) {
                System.out.print("Admin Name : ");
                nameOfAdmin = in.nextLine();
            }

            System.out.print("Admin Surname : ");
            String surnameOfAdmin = in.nextLine();
            while( surnameOfAdmin ==null || surnameOfAdmin.equals("") ) {
                System.out.print("Admin Surname : ");
                surnameOfAdmin = in.nextLine();
            }

            System.out.print("SSN of Admin : ");
            String SSNofAdmin = in.nextLine();
            while ( SSNofAdmin ==null || SSNofAdmin.equals("") ) {
                System.out.print("SSN Surname : ");
                SSNofAdmin = in.nextLine();
            }

            System.out.print("Password of Admin : ");
            String passwordOfAdmin = in.nextLine();
            while( passwordOfAdmin ==null || passwordOfAdmin.equals("") ) {
                System.out.print("Password of Admin : ");
                passwordOfAdmin = in.next();
            }

            System.out.println();
            Airport airport = new Airport( nameOfAirport , new User(nameOfAdmin , surnameOfAdmin , SSNofAdmin , passwordOfAdmin));
            System.out.println("System has been initialized.");
            System.out.println();



            boolean loginPageLoop = true;
            while(loginPageLoop){

                System.out.printf("\nWelcome to the Airport-Management-System Logic Page, %s.\n");

                System.out.printf("1- Login \n");
                System.out.printf("2- Enroll the system.\n");
                System.out.printf("3- View Airport-Map\n");
                System.out.printf("4- Exit\n");

                int loginPageChoice = in.nextInt();

                switch ( loginPageChoice ){

                    case 1:
                        break;

                    case 2:
                        break;

                    case 3:
                        break;

                    case 4: loginPageLoop = false;
                        break;
                    default: System.out.printf("Error. Your input is invalid..\n");
                }
            }


        } catch ( Throwable overAllException ){
            overAllException.printStackTrace();
        }
    }
}
