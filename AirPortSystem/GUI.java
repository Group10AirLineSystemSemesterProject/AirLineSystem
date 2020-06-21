import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static final Color Main = new Color(188, 242, 252, 154);
    public static final Color Guest_COLOR = new Color(180, 246, 164, 154);
    public static final Color Login_COLOR = new Color(157, 211, 253, 255);
    JFrame frame=new JFrame();
    public  void LOGIN(){
        frame.setVisible(false);
        JFrame frame1=new JFrame();
        JPanel panel=new JPanel();
        frame1.setSize(750,750);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel);
        panel.setLayout(null);
        panel.setBackground(Login_COLOR);
        JPasswordField passwordText =new JPasswordField();
        ImageIcon icon = new ImageIcon("login.jpg");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 685, 400); // for example, you can use your own values
        panel.add(label);
        JLabel UserID=new JLabel("UserID");
        UserID.setBounds(180,300,80,25);
        panel.add(UserID);
        JTextField UserIDText=new JTextField();
        UserIDText.setBounds(265,300,160,25);
        panel.add(UserIDText);
        JLabel Password=new JLabel("Password");
        Password.setBounds(180,325,80,25);
        panel.add(Password);
        passwordText.setBounds(265,325,160,25);
        panel.add(passwordText);
        JButton Login=new JButton("LOGIN");
        Login.setBounds(300,360,80,25);
        panel.add(Login);
        frame1.setVisible(true);
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(UserIDText.getText().equals("---") && passwordText.getText().equals("123")){
                    frame1.setVisible(false);
                    JFrame TrueFrame=new JFrame();
                    JPanel TruePanel=new JPanel();
                    TrueFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    TrueFrame.setSize(750,750);
                    TrueFrame.add(TruePanel);
                    JLabel text=new JLabel("TRUE");
                    text.setBounds(0,0,200,25);
                    TruePanel.add(text);
                    TrueFrame.setVisible(true);
                }
            }
        });
    }
    public  void GUEST(){
        frame.setVisible(false);
        JFrame frameGuest=new JFrame();
        JPanel panelGuest=new JPanel();
        frameGuest.setSize(750,750);
        frameGuest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelGuest.setBackground(Guest_COLOR);
        frameGuest.add(panelGuest);
        panelGuest.setLayout(null);
        JTextField SearchText=new JTextField();
        SearchText.setBounds(180,100,160,25);
        panelGuest.add(SearchText);
        JButton search=new JButton("Search");
        search.setBounds(350,100,80,25);
        panelGuest.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel output=new JLabel("OUTPUT WILL BE PRINTED HERE");
                output.setBounds(180,120,200,25);
                panelGuest.add(output);
            }
        });
        frameGuest.setVisible(true);
    }
    GUI(){
        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        frame.setSize(750,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Main);
        Icon icon = new ImageIcon("3.gif");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 200, 400, 200); // for example, you can use your own values
        panel.add(label);
        JButton Login=new JButton("LOGIN");
        Login.setBounds(470,330,150,25);
        panel.add(Login);
        frame.setVisible(true);
        Login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                LOGIN();

            }
        });
        JButton Guest=new JButton("GUEST");
        Guest.setBounds(470,300,150,25);
        panel.add(Guest);
        Guest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUEST();
            }
        });
    }
}
