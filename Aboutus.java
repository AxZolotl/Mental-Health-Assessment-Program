import java.awt.*;
import javax.swing.*;

public class Aboutus extends JFrame {
    JPanel panel1;
    JPanel panel2;
    JLabel logo;
    JLabel ins;
    JLabel creators;
    JLabel inspo;
    JLabel line1;
    JLabel kreah;
    JLabel luis;
    JLabel naz;
    JLabel kreahdes;
    JLabel luisdes;
    JLabel nazdes;
    JLabel inspodes;
    JLabel copy;
    JLabel rights;
    JScrollPane sp;
    JLayeredPane pane;

    public Aboutus() {
        EventQueue.invokeLater(new Runnable() {
            @Override
                public void run() {
                    setTitle("About Us");
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    setResizable(false);
                    setLayout(null);
                    getContentPane().setBackground(new Color(255,255,255));

                    //set the program in the center of screen
                    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
                    int width = 320;
                    int height = 360;
                    setBounds(center.x - width / 2, center.y - height / 2, width, height);

                    //create and set a program icon
                    ImageIcon icon = new ImageIcon("ProjectIcon.png");
                    setIconImage(icon.getImage());
                    
                    add(pane);

                    setVisible(true);
                }
        });
        pane = new JLayeredPane();
        pane.setBounds(0,0,320,360);

        panel1 = new JPanel();
        panel1.setBounds(0,0,320,360);
        panel1.setBackground(Color.WHITE);
        panel1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        panel1.setLayout(null);

        ImageIcon framebackground = new ImageIcon("ProjectIconResized.png");
        logo = new JLabel(framebackground);
        logo.setBounds(20,20,50,50);
        panel1.add(logo);
        
        ins = new JLabel("<html><left> Mental Health Assessment 2021 </left></html>");
        ins.setFont(new Font("Baskerville Old Face", Font.PLAIN, 20));
        ins.setForeground(Color.BLACK);
        ins.setBounds(90,27,200,40);
        panel1.add(ins);

        panel2 = new JPanel();
        panel2.setBackground(new Color(224,224,224));
        panel2.setPreferredSize(new Dimension(265,893));
        panel2.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        panel2.setLayout(null);
        panel1.add(panel2);
    
        creators = new JLabel("ABOUT US");
        creators.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 20));
        creators.setForeground(Color.BLACK);
        creators.setBounds(20,20,100,20);
        panel2.add(creators);

        line1 = new JLabel("____________________");
        line1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        line1.setForeground(Color.BLACK);
        line1.setBounds(20,40,265,20);
        panel2.add(line1);

        kreah = new JLabel("Kreah Iazel Paglinawan");
        kreah.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
        kreah.setForeground(Color.BLACK);
        kreah.setBounds(19,80,210,15);
        panel2.add(kreah);

        kreahdes = new JLabel("""
        <html><p align = justify> She is a 1st-year Computer Science student at Xavier University. 
        She is an aspiring software engineer. She hopes to conquer the moon soon. </p></html>""");
        kreahdes.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 11));
        kreahdes.setForeground(Color.BLACK);
        kreahdes.setBounds(20,93,210,70);
        panel2.add(kreahdes);

        
        luis = new JLabel("Luis Miguel Tortola");
        luis.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
        luis.setForeground(Color.BLACK);
        luis.setBounds(19,173,120,15);
        panel2.add(luis);

        luisdes = new JLabel("""
        <html><p align = justify> He is an EMC freshman of Xavier University. 
        His motto in life is \"Set your heart ablaze.\" 
        Gaming has been a precious thing in his life. 
        As a programmer, he can aspire to create games that could bring the future youth the same happiness 
        and experience that he have experienced. </p></html>""");
        luisdes.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 11));
        luisdes.setForeground(Color.BLACK);
        luisdes.setBounds(20,194,210,100);
        panel2.add(luisdes);

        
        naz = new JLabel("Nazib Dimal");
        naz.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 15));
        naz.setForeground(Color.BLACK);
        naz.setBounds(19,309,210,15);
        panel2.add(naz);

        nazdes = new JLabel("""
        <html><p align = justify> He is a CompSci Freshman of Xavier University, dreaming to become a well-known software engineer. 
        Just like other aspiring programmers, he is dedicated to pursue his ideas to contribute something beneficial in the field of technology. 
        One of his proof is this program. </p></html>""");
        nazdes.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 11));
        nazdes.setForeground(Color.BLACK);
        nazdes.setBounds(20,328,210,115);
        panel2.add(nazdes);

        line1 = new JLabel("____________________");
        line1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        line1.setForeground(Color.BLACK);
        line1.setBounds(20,448,265,20);
        panel2.add(line1);

        inspo = new JLabel("THE INSPIRATION");
        inspo.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 20));
        inspo.setForeground(Color.BLACK);
        inspo.setBounds(20,488,150,20);
        panel2.add(inspo);

        inspodes = new JLabel("""
        <html><p align = justify> Mental health is a significant part of a person's well being, but is often overlooked by people. 
        Anxiety, depression, and body dysmorphia are some of the most common mental health disorders unknowingly suffered by individuals. 
        When an individual is unaware of their mental health state, they would think that their struggles are completely normal. 
        Dealing with these struggles alone can be detrimental to a person's well-being as time progresses. 
        The creators of this program decided to make a Mental Health Self-Assessment Program that can determine the individual's mental health state just by taking the test. 
        With this program, people can have awareness of their mental health and address their mental health issues as soon as possible. 
        The tests can also give recommendations to the user whether they should seek professional help. </p></html>""");
        inspodes.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 11));
        inspodes.setForeground(Color.BLACK);
        inspodes.setBounds(20,518,210,290);
        panel2.add(inspodes);

        line1 = new JLabel("____________________");
        line1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
        line1.setForeground(Color.BLACK);
        line1.setBounds(20,813,265,20);
        panel2.add(line1);

        copy = new JLabel("\u00A9" + "2021 MHA.");
        copy.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 11));
        copy.setForeground(Color.BLACK);
        copy.setBounds(20,703,210,290);
        panel2.add(copy);

        rights = new JLabel("All Rights Reserved.");
        rights.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 11));
        rights.setForeground(Color.BLACK);
        rights.setBounds(20,717,210,290);
        panel2.add(rights);


        sp = new JScrollPane(panel2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setBounds(20,90,265,215);
        sp.getVerticalScrollBar().setUnitIncrement(30);
        sp.getViewport().putClientProperty("EnableWindowBlit", Boolean.TRUE);
        sp.getViewport().setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);
        panel1.add(sp);
        
        pane.add(panel1);
    }
}
