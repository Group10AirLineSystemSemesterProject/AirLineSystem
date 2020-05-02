package Airline;

/**
 * Informative class which has several properties about Aircraft.
 * @author Nevzat Seferoglu
 * @version 1.0
 */
public class Aircraft {

    /* --------------------------- */
    /* Properties */
    final String typeInfo;
    final String originAsCountry;
    final String registrationInfo;
    final String manufacturingDate;
    final String serialInfo;
    final String manufacturerInfo;
    final short wingspan;
    final short passengerCapacity;
    final short emptyWeightAsKg;
    /*-----------------------------*/

    private Aircraft(String typeInfo, String originAsCountry, String registrationInfo, String manufacturingDate,
                     String serialKey, String manufacturerInfo, short wingspan, short passengerCapacity, short emptyWeightAsKg) {

        this.typeInfo = typeInfo;
        this.originAsCountry = originAsCountry;
        this.registrationInfo = registrationInfo;
        this.manufacturingDate = manufacturingDate;
        this.serialInfo = serialKey;
        this.manufacturerInfo = manufacturerInfo;
        this.wingspan = wingspan;
        this.passengerCapacity = passengerCapacity;
        this.emptyWeightAsKg = emptyWeightAsKg;

    }

    public short getEmptyWeightAsKg() {
        return emptyWeightAsKg;
    }

    public short getPassengerCapacity() {
        return passengerCapacity;
    }

    public short getWingspan() {
        return wingspan;
    }

    public String getManufacturerInfo() {
        return manufacturerInfo;
    }

    public String getOriginAsCountry() {
        return originAsCountry;
    }

    public String getSerialInfo() {
        return serialInfo;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public String getRegistrationInfo() {
        return registrationInfo;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    @Override
    public String toString() {

        StringBuilder sb =  new StringBuilder();

        sb.append(" Type : ").append( getTypeInfo() ).append('\n');
        sb.append(" Registration : ").append( getRegistrationInfo() ).append('\n');
        sb.append(" Country of region : ").append( getOriginAsCountry() ).append('\n');
        sb.append(" Trademark of Manufacturer : ").append( getManufacturerInfo() ).append('\n');
        sb.append(" Manufacturing Date : ").append( getManufacturingDate() ).append('\n');
        sb.append(" Serial Number : ").append( getSerialInfo() ).append('\n');
        sb.append(" Wingspan length : ").append( getWingspan() ).append('\n');
        sb.append(" Passenger capacity : ").append( getPassengerCapacity() ).append('\n');
        sb.append(" Empty weight : ").append( getEmptyWeightAsKg() ).append('\n');

        return sb.toString();
    }
}
