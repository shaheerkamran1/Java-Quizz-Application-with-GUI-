package quiz.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener
{
    String name;
    JButton start, back;
    Rules(String name)
    {
        this.name=name;
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome "+ name + " to Quiz Application");
        heading.setBounds(50,20,700,30);
        heading.setFont(new Font("Times New Roman",Font.BOLD,18));
        heading.setForeground(new Color(0,0,128));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20,90,700,350);
        rules.setFont(new Font("Calibri",Font.PLAIN,16));
        rules.setForeground(new Color(0,0,0));
        rules.setText("<html>"+ 
                "1. Answer point to point" + "<br><br>" +
                "2. You have limited time for each question, use your time wisely" + "<br><br>" +
                "3. You'll be given 4 choices, select the best possible option." + "<br><br>" +
                "4. No cheating allowed" + "<br><br>" +
                "5. Use of internet is not allowed" + "<br><br>" +
                "6. Use your lifeline wisely" + "<br><br>" +
                "7. Complete the quiz thoroughly" + "<br><br>" +
                "8. Use your concepts and understanding to solve the questions, Good Luck" + "<br><br>" + "<html>");       
        add(rules);
        
        back= new JButton("Back");
        back.setBounds(400,500,120,25);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        start= new JButton("Start");
        start.setBounds(200,500,120,25);
        start.setBackground(new Color(30,144,254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
                    
                
        
        setSize(800,650);
        setLocation(350,100);
        setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == start)
        {
            setVisible(false);
            new Quiz(name);
        }
        else if(ae.getSource() == back)
        {
           setVisible(false); 
           new Login();
        }
    }
    
    public static void main (String[] args)
    {
        new Rules("User");
    }
}
