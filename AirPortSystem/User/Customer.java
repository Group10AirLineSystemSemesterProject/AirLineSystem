package User;

import java.util.Collection;
import java.util.Scanner;

public class Customer extends Person
{
    Collection<Flight> flights;
    Collection<Ticket> tickets;
    Ticket ticket;

    Customer(String newName, String newSurname) {
        super(newName, newSurname);
    }

    public void menu() { System.out.println("Menu:"); }

    public void login()
    {
        super.login();
    }

    public boolean add(Object obj) { return false; }
    public boolean remove(Object obj) { return false; }

    public void display() { /*valid flights info*/ }

    public String getName() { return name; }
    public String getSurname() { return surname; }

    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) {this.surname = surname; }

    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }
}
