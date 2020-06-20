package User;
import java.util.*;

public interface User
{
    public String getName();
    public String getSurname();
    public long getIdt();
    public void setName(String name);
    public void setSurname(String surname);
    public void setIdt(long idt);
    public void login();
    public boolean add(Object obj);
    public boolean remove(Object obj);
}
