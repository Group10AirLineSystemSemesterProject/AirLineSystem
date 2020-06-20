package User;

import java.util.Collection;

public class UserSystemStorage {
    /*
    Customer Container.
     */
    public Collection< Person > listOfPerson;
    /*
    Guest Container.
     */
    private Collection< Customer > listOfCustomer;
    /*
    Ticketed Container
     */
    private Collection< Personnel > listOfPersonnel;


    /**
     * Get Person List
     * @return list of person.
     */
    public Collection<Person> getListOfPerson() { return listOfPerson; }

    /**
     * Get Customer List
     * @return list of customer.
     */
    public Collection<Customer> getListOfCustomer() { return listOfCustomer; }

    /**
     * Get Personnel List
     * @return list of personnel.
     */
    public Collection<Personnel> getListOfPersonnel() { return listOfPersonnel; }

    /**
     * Set list of Person.
     * @param listOfPerson Person list.
     */
    public void setListOfPerson(Collection<Person> listOfPerson) { this.listOfPerson = listOfPerson; }

    /**
     * Set list of Customer.
     * @param listOfCustomer Customer list.
     */
    public void setListOfCustomer(Collection<Customer> listOfCustomer) { this.listOfCustomer = listOfCustomer; }

    /**
     * Set list of Personnel.
     * @param listOfPersonnel Personnel list.
     */
    public void setListOfPersonnel(Collection<Personnel> listOfPersonnel) { this.listOfPersonnel = listOfPersonnel; }
}

