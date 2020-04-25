import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompanyManager implements User{
    private String name,surname;
    private int Idt;
    private static JLabel userLabel,password;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JButton Login=new JButton();
    private JTextField LoginText;
    private static JFrame frame=new JFrame();
    /**
     * CompanyManager GUI will be generated here!
     */
    @Override
    public void menu() {
        System.out.println("Jumped to MENU method");
        //ALL METHODS BUTTON WILL ADD HERE
    }

    @Override
    public void login() {
        JPanel panel=new JPanel();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        JLabel CM=new JLabel("Company Manager Login Interface");
        CM.setBounds(150,50,200,25);
        panel.add(CM);
        userLabel=new JLabel("UserID");
        userLabel.setBounds(100,100,80,25);
        panel.add(userLabel);
        password=new JLabel("Password");
        password.setBounds(100,130,80,25);
        panel.add(password);
        LoginText=new JTextField();
        LoginText.setBounds(180,100,160,25);
        panel.add(LoginText);

        passwordText=new JPasswordField();
        passwordText.setBounds(180,130,160,25);
        panel.add(passwordText);
        Login = new JButton("Login");
        Login.setBounds(200,160,80,25);
        panel.add(Login);
        Login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(LoginText.getText().equals("alp") &&passwordText.getText().equals("123")){
                    menu();
                }
            }
        });
        frame.setVisible(true);
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname=surname;
    }

    @Override
    public int getIdt() {
        return Idt;
    }

    @Override
    public void setIdt(int idt) {
        this.Idt=idt;
    }
}
