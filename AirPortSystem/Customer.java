import java.util.Scanner;
/**
* Biletli musteri 
* User
* Farklı olarak Ticket bilgisi var
*/
public class Customer implements User
    {
        String name = null;
        String surname = null;
        int idt = 0;
        static int ticket = 0; // hash map düşünülebilir
        int capacity; //şirket, havaalani belirlesin.
                        // kapasite doluysa bilet alma seçeneklerinde o uçuş gösterilmesin.

        @Override
        public void menu()
        {
            System.out.println("Menu:");
        }

        @Override
        public void login()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user name:");
            setName(sc.nextLine());
            System.out.println("Enter user surname:");
            setSurname(sc.nextLine());
            System.out.println("Enter user id:");
            setIdt(sc.nextInt());
            System.out.println("User: "+name+" "+surname);
            System.out.println("User Id: "+idt);
        }

        @Override
        public boolean add() {
            return false;
        }

        @Override
        public boolean remove() {
            return false;
        }

        @Override
        public void display() {

        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public int getIdt() {
            return idt;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSurname(String surname) {this.surname = surname; }

        public void setIdt(int idt) {
            this.idt = idt;
        }

        public static int getTicket() { return ticket; }

        public static void setTicket(int ticket) { Customer.ticket = ticket; }
    }
