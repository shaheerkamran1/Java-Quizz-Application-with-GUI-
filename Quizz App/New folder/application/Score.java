package quiz.application;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import static quiz.application.Quiz.score;
import static quiz.application.Login.name;
public class Score extends JFrame implements ActionListener
{
    Score(String name, int score)
    {
        setBounds(400,150,750,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));        
        Image i2=i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,175,300,250);
        add(image);
        
        
        
       JLabel heading = new JLabel("Thank you " + name + " for attempting your quiz.");
        heading.setBounds(45,30,700,30);
        heading.setFont(new Font("Calibri", Font.PLAIN,26));
        add(heading);
       
        JLabel lblscore = new JLabel("Your Score is " + score);
        lblscore.setBounds(480,200,300,30);
        lblscore.setFont(new Font("Calibri", Font.PLAIN,26));
        add(lblscore);
        
         
        JButton attempt= new JButton("Attempt Again ");
        attempt.setBounds(500,250,120,30);
        attempt.setForeground(Color.WHITE);
        attempt.setBackground(new Color(30,144,255));
        attempt.addActionListener(this);
     
        add(attempt);
        
        setVisible(true);
    }
    
   private void saveResultToFile() {
//    try {
//        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
//        File file = new File(desktopPath,"Quiz_Score.txt");
//
//        
//        if (!file.exists()) 
//        {
//            file.createNewFile();
//        }
//
//        
//        FileWriter writer = new FileWriter(file,true);
//        writer.write("Name: " + name + "\n");
//        writer.write("Score: " + score + "\n");
//        writer.close();
//    } 
try {
            String currentDir = System.getProperty("user.dir");
            File file = new File(currentDir, "Quiz_Score.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write("Name: " + name + "\n");
            bufferedWriter.write("Score: " + score + "\n");
            
            bufferedWriter.close(); // This also closes the underlying FileWriter
        } 
catch (IOException e) 
    
    {
        e.printStackTrace();
    }
}
    
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) 
    {
        new Score("User",0);
    }
    
}
       
