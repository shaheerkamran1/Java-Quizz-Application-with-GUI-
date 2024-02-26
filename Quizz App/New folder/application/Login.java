package quiz.application;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Login  extends JFrame implements ActionListener
{
    JButton back,rules;
    JTextField tfname;
    public static JLabel name;
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));        
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,600,450);
        add(image);
        
        JLabel heading = new JLabel("Quiz Application");
        heading.setBounds(825,60,300,45);
        heading.setFont(new Font("Times New Roman",Font.BOLD,40));
        heading.setForeground(new Color(0,0,128));
        add(heading);
        
        name = new JLabel("Enter your name:");
        name.setBounds(850,150,300,20);
        name.setFont(new Font("Calibri",Font.BOLD,18));
        name.setForeground(Color.BLACK);
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(775, 200, 300, 25);
        tfname.setFont(new Font("Calibri",Font.BOLD,18));
        add(tfname);
        
        rules= new JButton("Rules");
        rules.setBounds(735,270,120,25);
        rules.setBackground(new Color(30,144,254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        back= new JButton("Back");
        back.setBounds(975,270,120,25);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(1200,500);
        setLocation(150,150);
        setVisible(true );
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==rules)
        {
            String name=tfname.getText();
            setVisible(false);
            new Rules(name);
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
        }
    }
    public static void main(String[] args) 
    {
        new Login();                 //Anonymous object 
    }
}
