package Airline;

import Client.Person;
import Client.UserInterface;

import java.util.Objects;

/**
 * Backbone of airline personnel .
 * In case of needed  other personnel type can be derived.
 * @author Nevzat Seferoglu
 * @version 1.0
 */
public class AirlinePersonnel extends Person implements UserInterface {

    private String SSN;
    private String password;
    boolean isPilot;


    public AirlinePersonnel(String name, String surname , boolean isPilot) {
        super(name, surname);
        this.isPilot = isPilot;
    }

    @Override
    public String getSSN() {
        return SSN;
    }

    @Override
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AirlinePersonnel that = (AirlinePersonnel) o;
        return SSN.equals(that.SSN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), SSN);
    }

    @Override
    public String toString() {
        return "AirlinePersonnel{" +
                "SSN='" + SSN + '\'' +
                ", password='" + password + '\'' +
                ", isPilot=" + isPilot +
                '}';
    }

}
