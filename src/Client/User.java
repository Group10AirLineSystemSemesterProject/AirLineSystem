package Client;

import java.util.Objects;

/**
 * Class that represent user of the system.
 */
public class User extends Person implements UserInterface  {

    private String SSN;
    private String password;

    /**
     * Constructor of the User.
     * @param name As the name of the user.
     * @param surname as the surname of the user.
     */
    public User(String name, String surname) {
        super(name, surname);
    }

    /**
     * Constructor of the User.
     * @param name As the name of the user.
     * @param surname as the surname of the user.
     */
    public User(String name, String surname, String SSN, String password ) throws Exception {
        this( name , surname );

        if( SSN == null ) {
            throw new Exception("SSN cannot be null.");
        }

        if( password == null ) {
            throw new Exception("Password cannot be null.");
        }

        this.SSN = SSN;
        this.password = password;
    }

    /**
     * Method for receiving SSN.
     * @return SSN as string.
     */
    @Override
    public String getSSN(){
        return SSN;
    }

    /**
     * Method for setting a new SSN.
     * @param SSN as a new SSN to assign.
     */
    @Override
    public void setSSN(String SSN) throws Exception {
        if( SSN == null ) {
            throw new Exception("SSN cannot be null.");
        }

        this.SSN = SSN;
    }

    /**
     * Method for receiving password.
     * @return password as String.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Method for setting a new password.
     * @param password as a new password to assign.
     */
    @Override
    public void setPassword(String password) throws Exception {
        if( password == null ) {
            throw new Exception("Password cannot be null.");
        }

        this.password = password;
    }

    /**
     * Equal method.
     * @param o Object to compare.
     * @return return true if SSN mathch otherwise return false.
     *
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return SSN.equals(user.SSN);
    }

    /**
     * Hash Code.
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), SSN);
    }

    /**
     * To string of user.
     * @return String representation of User.
     */
    @Override
    public String toString() {
        return super.toString()+" SSN:"+getSSN()+" Password:"+getPassword();
    }

}
