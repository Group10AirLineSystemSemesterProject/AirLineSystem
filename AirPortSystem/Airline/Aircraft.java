package Airline;

/**
 * Informative class which has several properties about Aircraft.
 * @author Nevzat Seferoglu
 * @version 1.1
 */
public class Aircraft {

    /* --------------------------- */
    /* Properties */
    final String typeInfo;
    final String originAsCountry;
    final Integer registrationInfo;
    final String manufacturingDate;
    final String serialInfo;
    final String manufacturerInfo;
    final Double wingspan;
    final Double passengerCapacity;
    final Double emptyWeightAsKg;
    final Double maxFuelCapacity;
    /*-----------------------------*/

    Aircraft(String typeInfo, String originAsCountry, int registrationInfo, String manufacturingDate,
             String serialKey, String manufacturerInfo, Double wingspan, Double passengerCapacity, Double emptyWeightAsKg, Double maxFuelCapacity) {

        this.typeInfo = typeInfo;
        this.originAsCountry = originAsCountry;
        this.registrationInfo = registrationInfo;
        this.manufacturingDate = manufacturingDate;
        this.serialInfo = serialKey;
        this.manufacturerInfo = manufacturerInfo;
        this.wingspan = wingspan;
        this.passengerCapacity = passengerCapacity;
        this.emptyWeightAsKg = emptyWeightAsKg;
        this.maxFuelCapacity = maxFuelCapacity;

    }

    public Double getEmptyWeightAsKg() {
        return emptyWeightAsKg;
    }

    public Double getPassengerCapacity() {
        return passengerCapacity;
    }

    public Double getWingspan() {
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

    public int getRegistrationInfo() {
        return registrationInfo;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    @Override
    public String toString() {

        return " Type : " + getTypeInfo() + '\n' +
                " Registration : " + getRegistrationInfo() + '\n' +
                " Country of region : " + getOriginAsCountry() + '\n' +
                " Trademark of Manufacturer : " + getManufacturerInfo() + '\n' +
                " Manufacturing Date : " + getManufacturingDate() + '\n' +
                " Serial Number : " + getSerialInfo() + '\n' +
                " Wingspan length : " + getWingspan() + '\n' +
                " Passenger capacity : " + getPassengerCapacity() + '\n' +
                " Empty weight : " + getEmptyWeightAsKg() + '\n';
    }


    @Override
    public boolean equals(Object obj) {
        if( obj ==  this ) {
            return true;
        } else if( !(obj instanceof Aircraft) ) {
            return true;
        }

        return ((Aircraft) obj).typeInfo.equals( this.typeInfo ) &&
                ((Aircraft) obj).originAsCountry.equals( this.originAsCountry ) &&
                ((Aircraft) obj).registrationInfo.equals( this.registrationInfo ) &&
                ((Aircraft) obj).manufacturingDate.equals( this.manufacturingDate ) &&
                ((Aircraft) obj).serialInfo.equals( this.serialInfo ) &&
                ((Aircraft) obj).manufacturerInfo.equals( this.manufacturerInfo ) &&
                ((Aircraft) obj).wingspan.equals( this.wingspan ) &&
                ((Aircraft) obj).passengerCapacity.equals( this.passengerCapacity ) &&
                ((Aircraft) obj).emptyWeightAsKg.equals( this.emptyWeightAsKg ) &&
                ((Aircraft) obj).manufacturingDate.equals( this.manufacturingDate ) &&
                ((Aircraft) obj).maxFuelCapacity.equals( this.maxFuelCapacity );
    }
}
