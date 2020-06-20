package User;

import java.util.Scanner;

public class Person implements User
{
    UserSystemStorage userSystemStorage;
    private static long idt = 0;
    String name = null;
    String surname = null;

    Person(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user name:");
        setName(sc.nextLine());
        System.out.println("Enter user surname:");
        setSurname(sc.nextLine());
        String.valueOf(idt++);
        setIdt(idt);
    }

    Person(String newName, String newSurname){
        setName(newName);
        setSurname(newSurname);
        String.valueOf(idt++);
        setIdt(idt);
    }

    public void login()
    {
        long tempId = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("-LOGIN-");
        System.out.println("Enter user id to login system:");
        tempId = sc.nextLong();
        try {
            if (this.getIdt() == tempId) {
                System.out.println("id is valid");
                System.out.println("id:" + tempId);
            }
            else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("id is invalid");
        }
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public long getIdt() { return idt; }

    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) {this.surname = surname; }
    public void setIdt(long idt) { this.idt = idt; }

    public boolean add(Object obj) { return false; }
    public boolean remove(Object obj) { return false; }
}