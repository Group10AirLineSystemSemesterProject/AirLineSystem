package User;

import java.util.Scanner;

public class Personnel extends Person {

    Personnel(String newName, String newSurname) {
        super(newName,newSurname);
    }

    public void menu()
    {
        System.out.println("Menu:");
    }

    public void login() {
        super.login();
    }

    public void display() { }

    public String getName() { return name; }
    public String getSurname() { return surname; }

    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) {this.surname = surname; }

    public boolean add(Object obj) { return false; }
    public boolean remove(Object obj) { return false; }
}
