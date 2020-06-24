package Airline;

import java.util.Comparator;

/**
 * Informative class which has several properties about Aircraft.
 * @author Nevzat Seferoglu
 * @version 1.1
 */
public class Aircraft {

    /* --------------------------- */
    /* Properties */

    /**Holds the type as String.*/
    final String typeInfo;

    /**Origin of Country*/
    final String originAsCountry;

    /***/
    final Integer registrationInfo;

    /**Holds the date that plane has been manufactured.*/
    final String manufacturingDate;

    /**Serial information of aircraft. As string format.*/
    final String serialInfo;

    /***/
    final String manufacturerInfo;

    /**Span of wing, affects flight score.*/
    final Double wingspan;

    /**Number of passengers, that can be in the plane at the same time.*/
    final Double passengerCapacity;

    /**Empy weight (kg) affects flight score.*/
    final Double emptyWeightAsKg;

    /**Max fuel cap can tell us how that plane can go far.*/
    final Double maxFuelCapacity;
    /*-----------------------------*/

    int compareScore;
    static int flightScore;

    /**Aircraft Constructor
     * @param typeInfo
     * @param originAsCountry
     * @param registrationInfo
     * @param manufacturingDate
     * @param serialKey
     * @param manufacturerInfo
     * @param wingspan
     * @param passengerCapacity
     * @param emptyWeightAsKg
     * @param maxFuelCapacity
     * */
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

    /**Returns the compareScore.
     * @return compareScore, as integer.*/
    public int getCompareScore() {
        return compareScore;
    }

    /**Returns the flightScore.
     * @return flightScore, as integer.*/
    public static int getFlightScore() {
        return flightScore;
    }

    /**Returns the emptyWeightAsKg.
     * @return emptyWeightAsKg, as double.*/
    public Double getEmptyWeightAsKg() {
        return emptyWeightAsKg;
    }

    /**Returns the passengerCapacity.
     * @return passengerCapacity, as double.*/
    public Double getPassengerCapacity() {
        return passengerCapacity;
    }

    /**Returns the wingspan.
     * @return wingspan, as double.*/
    public Double getWingspan() {
        return wingspan;
    }

    /**Returns the manufacturerInfo.
     * @return manufacturerInfo, as String.*/
    public String getManufacturerInfo() {
        return manufacturerInfo;
    }

    /**Returns the originAsCountry.
     * @return originAsCountry, as String.*/
    public String getOriginAsCountry() {
        return originAsCountry;
    }

    /**Returns the serialInfo.
     * @return serialInfo, as String.*/
    public String getSerialInfo() {
        return serialInfo;
    }

    /**Returns the manufacturingDate.
     * @return manufacturingDate, as String.*/
    public String getManufacturingDate() {
        return manufacturingDate;
    }

    /**Returns the registrationInfo.
     * @return registrationInfo, as integer.*/
    public int getRegistrationInfo() {
        return registrationInfo;
    }

    /**Returns the type.
     * @return this.typeInfo, as string.*/
    public String getTypeInfo() {
        return typeInfo;
    }

    /**Sets a new score to aircraft's score.
     * @param flightScore to set.*/
    public static void setFlightScore(int flightScore) {Aircraft.flightScore = flightScore;}

    /**Method to see compare score to flight score.*/
    public void assignCompare(){
        compareScore=Math.abs(getFlightScore()-getScore());
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

    /**
     * To get Comparator for using sort algorithms.
     * Switch structure used to determine which feature is
     * gonna be used in sorting
     * @return Comparator to make sorting
     */
    public static Comparator<Aircraft> getComparator(){
        Comparator<Aircraft> comparator = new Comparator<Aircraft>() {
            @Override
            public int compare(Aircraft aircraft, Aircraft t1) {
                return Math.abs(aircraft.getCompareScore()-t1.getCompareScore());
            }
        };
        return comparator;
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

    /**Method for getting score.
     * Score is calculated from wingspan, capacity etc.
     * it is between 0 and 30.
     * @return the total score.*/
    public int getScore(){

        int score = 0;
        int temp = 0;

        temp = (int)(maxFuelCapacity - 20)/15 ;
        if(temp < 0 ) temp = 0;
        else if(temp > 10) temp = 10;
        score +=  temp;

        temp = (int)(getPassengerCapacity() - 100) / 40;
        if(temp < 0 ) temp = 0;
        else if(temp > 10) temp = 10;
        score +=  temp;

        temp = (int)(getEmptyWeightAsKg() - 50) / 15;
        if(temp < 0 ) temp = 0;
        else if(temp > 10) temp = 10;
        score +=  temp;

        return score;
    }
}

