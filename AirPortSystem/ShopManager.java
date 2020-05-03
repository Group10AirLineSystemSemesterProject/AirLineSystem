package AirportPackage;
import java.util.Scanner;

public class ShopManager /*implements Person*/{

    // private Airport associatedAirport;
	/*
	ShopManager(Airport o){
		associatedAirport = o;
		//THIS MEANS THIS MANAGER CAN USE AIRPORT'S SHOP LISTS?
	}
	*/
    public void menu() {

        Scanner in = new Scanner(System.in);
        int choice;

        login();

        while(true/*logStatus == true*/){

            System.out.printf("There goes Menu");
            System.out.printf("1- ");
            System.out.printf("2- ");
            System.out.printf("3- ");
            choice = in.nextInt();

            switch(choice) {

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default:
            }
        }
    }

    private void login() {
        //there happens logging in.. if succesful logStatus turns true;
        // maybe super.login();
        // logStatus = true;
    }

    private void logout() {
        // logStatus = false;
    }

    private void addShop() {

    }

    private void removeShop() {

    }

    private void seeShops() {

    }

    private void editShop(/*Shop a*/){

        Scanner in = new Scanner(System.in);
        int choice;
        boolean loop = true;

        while(loop== true){

            System.out.printf("There goes Menu");
            System.out.printf("1- Edit name");
            System.out.printf("2- Edit id");
            System.out.printf("3- Edit fee");
            System.out.printf("4- exit");
            choice = in.nextInt();

            switch(choice) {

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4: loop = false;
                    break;

                default:
            }
        }
    }

}