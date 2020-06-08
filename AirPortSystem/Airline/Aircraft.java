package Airline;

/**
 * Informative class which has several properties about Aircraft.
 * @author Nevzat Seferoglu && Bilal Bayrakdar
 * @version 1.2
 */
public class Aircraft {

    /* --------------------------- */
    /* Properties */
    final String typeInfo;          // uçak tipi
    final String originAsCountry;   // üretim yeri
    final String registrationInfo;  // kayıt numarası
    final String manufacturingDate; // üretim tarihi
    final String serialInfo;        // seri numarası
    final String manufacturerInfo;  // üreten firme
    final short wingspan;           // kanat genişliği
    final short passengerCapacity;  // yolcu kapasitesi
    final short emptyWeightAsKg;    // boş ağırlık
    final int maxFuelCapacity;      // maksimum benzin kapasitesi
    /*-----------------------------*/

    Aircraft(String typeInfo, String originAsCountry, String registrationInfo, String manufacturingDate,
             String serialKey, String manufacturerInfo, short wingspan, short passengerCapacity, short emptyWeightAsKg, int maxFuelCapacity) {
        // negatif değerler için exception handling eklenecek
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

    public int getMaxFuelCapacity() {
        return maxFuelCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        Aircraft temp = (Aircraft)obj;
        return this.registrationInfo.equals(temp.registrationInfo);
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
