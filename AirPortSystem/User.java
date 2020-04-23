import java.util.*;

public interface User
    {
        public void menu();
        public void login();
        public boolean add();
        public boolean remove();
        public void display();
        public String getName();
        public String getSurname();
        public int getIdt();
        public void setName(String name);
        public void setSurname(String surname);
        public void setIdt(int idt);
    }
