/**
 * Represents the administrators of Airports
 * @author Rahmet Ali Ölmez
 */
public class AirportAdmin implements User
{
    /**
     * Name of airport admin
     */
    private String name = "";

    /**
     * Surname of airport admin
     */
    private String surname = "";

    /**
     * Id number of airport admin
     */
    private int idt = 0;

    /**
     * Password to login
     */
    private String password = "Password1";

    /**
     * Initializes the information of airport admin
     * @param name Name of airport admin
     * @param surname Surname of airport admin
     * @param idt Id number of airport admin
     */
    AirportAdmin(String name, String surname, int idt)
    {
        this.name = name;
        this.surname = surname;
        this.idt = idt;
    }

    @Override
    public void menu()
    {
        System.out.println("*********************");
        System.out.println("*        MENU       *");
        System.out.println("*********************");

        System.out.println("(1) Add");
        System.out.println("(2) Remove");
        System.out.println("(3) See managers list");
        System.out.println("\nChoice: ");
    }

    @Override
    public void login()
    {
        if(password.equals(this.password))
        {
        }
        else
        {
        }
    }

    @Override
    public boolean add()
    {
        return false;
    }

    @Override
    public boolean remove()
    {
        return false;
    }

    @Override
    public void display()
    {

    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getSurname()
    {
        return surname;
    }

    @Override
    public int getIdt()
    {
        return idt;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    @Override
    public void setIdt(int idt)
    {
        this.idt = idt;
    }

    /**
     * Creates a new manager and adds it to the system
     */
    public void addManager()
    {

    }

    /**
     * Removes a manager from the system
     */
    public void removeManager()
    {

    }

    /**
     * Lists all the managers
     */
    public void seeManagersList()
    {

    }
}
