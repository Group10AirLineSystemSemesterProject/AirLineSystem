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
        int indx = -1;
        String nname = null , nid = null;

        login();

        while(true/*logStatus == true*/){

            System.out.printf("There goes Menu");
            System.out.printf("1- Show Shops");
            System.out.printf("2- Add Shop");
            System.out.printf("3- Edit / Remove Shop");
            System.out.printf("4- Check Personal Settings");
            System.out.printf("5- Exit");
            choice = in.nextInt();

            switch(choice) {

                case 1:
                	seeShops();
                    break;

                case 2:
                	
                	System.out.printf("Please enter a name for new shop.\n");
                	nname = in.next();
                	
                	do {
                		
                		System.out.printf("Please enter a id for %d.\n", nname);
                    	nid = in.next();
                    	
                	}while( idAvaible(nid) == false);
                	
                	
                	System.out.printf("Please enter a fee for %d.\n",nname);
                	choice = in.nextInt();
                	
                	shops.add(new Shop(nname,nid,choice));
                	//adds new shop to the list.
                	
                    break;

                case 3:
                	
                	indx = -1;
                	System.out.printf("Please enter an id to edit shop.\n");
                	nid = in.next();
                	
                	indx = indexOf(nid);
                	if(indx == -1) System.out.printf("Could not find the shop..\n");
                	else editShop(shops.get(indx));
                	
                    break;

                case 4:
                    break;
                    
                case 5: logout();
                    break;

                default: System.out.printf("Wrong input...");
            }
        }
    }

    /**indexOf method gets index of given id.
    * @param id as String to search.
    * @return int , as index, -1 if not found..*/
    private int indexOf(String id) {
    	
    	int i = 0;
    
    	for(i = 0 ; i < shops.size() ; i++) {
    		if (shops.get(i).getId() == id ) return i;
    	}

    	return -1;
    }
    
    /** idAvaiable returns false if id is already used.
    * @param id to check
    * @return true if avaiable.*/
    private boolean idAvaible(String id) {
    	return indexOf(id) == -1;
    }
    
    private void login() {
        //there happens logging in.. if succesful logStatus turns true;
        // super.login();
        // logStatus = true;
    }

    private void logout() {
        // logStatus = false;
    }

    /**seeShops method for Showing all avaiable shops
     * in our list.
     * */
    private void seeShops() {

    	//Shows Shops with iterator.
    	
    	int i = 0;
    	
    	/*
  
    	while(it.hasNext()) {
    		System.out.print("i - ")
    		it.toString();
    		i++;
    	}
    	
    	*/
    }

	/**Edit screen for shops
	* @param a As shop to edit.*/
    private void editShop(Shop a){

        Scanner in = new Scanner(System.in);
        int choice;
		String str;
        boolean loop = true;

        while(loop== true){

            System.out.printf("-Edit menu of: %d-",a.toString);
            System.out.printf("1- Edit name");
            System.out.printf("2- Edit id");
            System.out.printf("3- Edit fee");
            System.out.printf("4- Delete shop");
			System.out.printf("5- Exit");
            choice = in.nextInt();

            switch(choice) {

                case 1:
					System.out.printf("Enter a new name.");
					str = in.next();
					a.setName(str);
                    break;

                case 2:
					
				    do {
                		System.out.printf("Please enter a id for %d.\n", a.getName());
                    	str = in.next();
                	}while( idAvaible(str) == false);
					
					a.setId(str);
                    break;

                case 3:
					
					System.out.printf("Enter a new fee.");
					choice = in.next();
					a.setName(choice);
                    break;

				case 4: shop.remove(a);
                case 5: loop = false;
                    break;

                default: System.out.printf("Wrong input...");
            }
        }
    }
}
