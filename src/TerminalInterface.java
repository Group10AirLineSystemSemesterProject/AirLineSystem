import Airport.*;
import Airline.*;
import Client.Person;
import Client.User;
import Client.UserInterface;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class TerminalInterface {


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

                System.out.printf("\nWelcome to the Airport-Management-System Logic Page, %s.\n",nameOfAdmin+" "+surnameOfAdmin);

                System.out.println("1- Login ");
                System.out.println("2- Enroll the system.");
                System.out.println("3- View Airport-Map");
                System.out.println("4- Exit");

                int loginPageChoice = in.nextInt();

                switch ( loginPageChoice ){

                    case 1:
                        System.out.print("Enter SSN:\t");
                        String logSSN = in.nextLine();
                        User logUser = airport.getAirportSystemStorage().getUserWithSSN(logSSN);
                        if(logUser!=null){
                            System.out.println("Enter password:\n");
                            String logPas = in.nextLine();
                            if(logPas.equals(logUser.getPassword())){
                                System.out.println("Logged in Successfully");
                                if(logUser instanceof Customer )
                                    ((Customer)logUser).menu();
                                else if(logUser instanceof  AirlinePersonnel)
                                    ((AirlinePersonnel)logUser).menu();
                                else if(logUser instanceof AirlineAdmin)
                                    ((AirlineAdmin)logUser).menu();
                                else if(logUser instanceof AirportPersonnel)
                                    ((AirportPersonnel)logUser).menu();
                                else if(logUser instanceof AirportAdmin)
                                    ((AirportAdmin)logUser).menu();
                                else
                                    throw (new Exception("There is no logged person for given SSN"));
                            }
                            else{
                                System.out.println("Wrong password or SSN number!");
                                break;
                            }
                        }

                    case 2:
                        break;

                    case 3:
                        break;

                    case 4: loginPageLoop = false;
                        break;
                    default: System.out.println("Error. Your input is invalid..");
                }
            }


        } catch ( Throwable overAllException ){
            overAllException.printStackTrace();
        }
    }
}
