package AirportPackage;

/** SHOP CLASS
 * @author Group 10, by ilkan mert okul
 * */
public class Shop {

    /**Represents name of the shop.*/
    private String shopName;

    /**ID, helps for searching by id.*/
    private String id;

    /**Fee represents monthly fee of the shop.*/
    private int fee;

    Shop(){

        shopName = "unnamed";
        id = "-1";
        fee= -1;

        System.err.print("Shop created without a name, id and fee");
    }

    Shop(String newName, String newID, int newFee){

        shopName = newName;
        id = newID;
        fee = newFee;
    }

    //GET//

    /**get method for shopName
     * @return shopName*/
    public String getName() {
        return shopName;
    }

    /**get method for id
     * @return id*/
    public String getID() {
        return id;
    }

    /**get method for fee
     * @return fee*/
    public int getFee() {
        return fee;
    }

    //SET//

    /**set method for shopName
     * @param newName to change old shopname*/
    public void setName(String newName) {
        shopName = newName;
    }

    /**set method for id
     * @param newID to change old id*/
    public void setID(String newID) {
        id = newID;
    }

    /**set method for fee
     * @param newFee to change old fee*/
    public void setName(int newFee) {
        fee = newFee;
    }

}