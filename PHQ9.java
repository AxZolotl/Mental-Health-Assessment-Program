import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.Timer;

public class PHQ9 extends JFrame implements ActionListener {
    //layered panes
    JLayeredPane pane;

    //panel
    JPanel mainPanel;
    JPanel phqpanel;
    JPanel qpanel;
    JPanel design;
    Panel rpanel;

    //labels
    JLabel logobearer;
    JLabel introtitle;
    JLabel testtitle;
    JLabel resulttitle;
    
    //texts
    Text1 zero;
    Text1 one;
    Text1 two;
    Text1 three;
    Text1 description;
    Text1 mainq;
    Text2 res;
    Text2 sug;
    Text2 result;

    //questions
    Question q1;
    Question q2;
    Question q3;
    Question q4;
    Question q5;
    Question q6;
    Question q7;
    Question q8;
    Question q9;

    //buttonpanels
    Buttonpanel bpanel1;
    Buttonpanel bpanel2;
    Buttonpanel bpanel3;
    Buttonpanel bpanel4;
    Buttonpanel bpanel5;
    Buttonpanel bpanel6;
    Buttonpanel bpanel7;
    Buttonpanel bpanel8;
    Buttonpanel bpanel9;

    //buttons
    JButton submit;
    JButton ret;
    Fbutton finish;
    Sbutton save;

    //checkboxes
    JCheckBox check;

    //integers
    int total;
    int opt;

    //scrollpanes
    JScrollPane sp1;
    JScrollPane sp2;

    public PHQ9() {
        EventQueue.invokeLater(new Runnable() {
            @Override
                public void run() {
                    setTitle("MHA");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setResizable(false);
                    setLayout(new BorderLayout());
                    getContentPane().setBackground(new Color(255,255,255));

                    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
                    int width = 640;
                    int height = 720;
                    setBounds(center.x - width / 2, center.y - height / 2, width, height);

                    //create and set a program icon
                    ImageIcon icon = new ImageIcon("ProjectIcon.png");
                    setIconImage(icon.getImage());
                    
                    setLayeredPane(pane);

                    setVisible(true);
                }
        });
        //create main pane
        pane = new JLayeredPane();
        pane.setBounds(0,0,640,720);

        //create main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(102,161,250));
        mainPanel.setBounds(0,0,640,720);
        mainPanel.setLayout(null);

        //create PHQ-9 panel
        phqpanel = new JPanel();
        phqpanel.setBackground(Color.WHITE);
        phqpanel.setBounds(14,14,600,655);
        phqpanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        phqpanel.setLayout(null);

        //create and add test title
        testtitle = new JLabel("<html><center> PHQ - 9 DEPRESSION </center></html>");
        testtitle.setFont(new Font("Times New Roman",Font.PLAIN,25));
        testtitle.setVerticalAlignment(JLabel.TOP);
        testtitle.setForeground(Color.BLACK);
        testtitle.setBounds(180,25,560,30);
        phqpanel.add(testtitle);

        //create and add test description
        description = new Text1();
        description.setText("""
        <html><p align = justify> This questionnaire, called the PHQ-9 screening tool can help you find out if you might have a
        depression that needs treatment. It calculates how many common symptoms you have and based
        on your answers suggests where you might be on a scale, from mild to severe depression. </p></html>""");
        description.setBounds(20,65,560,100);
        phqpanel.add(description);

        //create and add questions panel
        qpanel = new JPanel();
        qpanel.setBackground(new Color(255,250,250));
        qpanel.setPreferredSize(new Dimension(576,815));
        qpanel.setLayout(null);
        qpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        phqpanel.add(qpanel);

        //create and add main question
        mainq = new Text1();
        mainq.setText("""
        <html><p align = justify> Over the last 2 weeks, 
        how often have you been bothered by the following problems? </p></html>""");
        mainq.setBounds(20,20,250,100);
        qpanel.add(mainq);

        //create and add weights
        zero = new Text1();
        zero.setText("<html><center> Not at all </center></html>");
        zero.setBounds(293,20,50,100);
        qpanel.add(zero);

        one = new Text1();
        one.setText("<html><center> Several days </center></html>");
        one.setBounds(364,20,50,100);
        qpanel.add(one);

        two = new Text1();
        two.setText("<html><center> More than half the days </center></html>");
        two.setBounds(427,20,70,100);
        qpanel.add(two);

        three = new Text1();
        three.setText("<html><center> Nearly every day </center></html>");
        three.setBounds(515,20,40,100);
        qpanel.add(three);

        //create and add questions
        q1 = new Question();
        q1.setText("<html><p align = justify> 1. Little interest or pleasure in doing things </p></html>");
        q1.setBounds(20,100,250,100);
        qpanel.add(q1);

        q2 = new Question();
        q2.setText("<html><p align = justify> 2. Feeling down, depressed, or hopeless </p></html>");
        q2.setBounds(20,150,250,100);
        qpanel.add(q2);

        q3 = new Question();
        q3.setText("<html><p align = justify> 3. Trouble falling or staying asleep, or sleeping too much </p></html>");
        q3.setBounds(20,200,250,100);
        qpanel.add(q3);

        q4 = new Question();
        q4.setText("<html><p align = justify> 4. Feeling tired or having little energy </p></html>");
        q4.setBounds(20,250,250,100);
        qpanel.add(q4);

        q5 = new Question();
        q5.setText("<html><p align = justify> 5. Poor appetite or overeating </p></html>");
        q5.setBounds(20,300,250,100);
        qpanel.add(q5);
            
        q6 = new Question();
        q6.setText("<html><p align = justify> 6. Feeling bad about yourself or that you are a failure or have let yourself or your family down </p></html>");
        q6.setBounds(20,350,250,100);
        qpanel.add(q6);

        q7 = new Question();
        q7.setText("<html><p align = justify> 7. Trouble concentrating on things, such as reading the newspaper or watching television </p></html>");
        q7.setBounds(20,430,250,100);
        qpanel.add(q7);

        q8 = new Question();
        q8.setText("<html><p align = justify> 8. Moving or speaking so slowly that other people could have noticed. Or the opposite being so figety or restless that you have been moving around a lot more than usual </p></html>");
        q8.setBounds(20,520,250,100);
        qpanel.add(q8);

        q9 = new Question();
        q9.setText("<html><p align = justify> 9. Thoughts that you would be better off dead, or of hurting yourself </p></html>");
        q9.setBounds(20,640,250,100);
        qpanel.add(q9);

        //create and add buttonpanels
        bpanel1 = new Buttonpanel(1);
        bpanel1.setBounds(257,100,340,20);
        qpanel.add(bpanel1);

        bpanel2 = new Buttonpanel(2);
        bpanel2.setBounds(257,150,340,20);
        qpanel.add(bpanel2);

        bpanel3 = new Buttonpanel(3);
        bpanel3.setBounds(257,200,340,20);
        qpanel.add(bpanel3);

        bpanel4 = new Buttonpanel(4);
        bpanel4.setBounds(257,250,340,20);
        qpanel.add(bpanel4);

        bpanel5 = new Buttonpanel(5);
        bpanel5.setBounds(257,300,340,20);
        qpanel.add(bpanel5);

        bpanel6 = new Buttonpanel(6);
        bpanel6.setBounds(257,350,340,20);
        qpanel.add(bpanel6);

        bpanel7 = new Buttonpanel(7);
        bpanel7.setBounds(257,430,340,20);
        qpanel.add(bpanel7);

        bpanel8 = new Buttonpanel(8);
        bpanel8.setBounds(257,520,340,20);
        qpanel.add(bpanel8);

        bpanel9 = new Buttonpanel(9);
        bpanel9.setBounds(257,640,340,20);
        qpanel.add(bpanel9);

        //create and add checkbox

        check = new JCheckBox("<html><center> I affirm the truthfulness of my answers </center></html>");
        check.setFont(new Font("Times New Roman",Font.PLAIN,14));
        check.setForeground(Color.black);
        check.setVerticalTextPosition(JButton.CENTER);
        check.setFocusable(false);
        check.setOpaque(false);
        check.setBounds(195,700,200,50);
        check.addActionListener(this);
        qpanel.add(check);

        //create and add return button
        ret = new JButton("Return");
        ret.setFont(new Font("Times New Roman",Font.PLAIN,14));
        ret.setForeground(Color.black);
        ret.setVerticalTextPosition(JButton.CENTER);
        ret.setBackground(new Color(216,214,214));
        ret.setFocusable(false);
        ret.setBounds(188,765,100,35);
        ret.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        ret.addActionListener(this);
        qpanel.add(ret);

        //create and add submit button
        submit = new JButton("Submit");
        submit.setFont(new Font("Times New Roman",Font.PLAIN,14));
        submit.setForeground(Color.black);
        submit.setVerticalTextPosition(JButton.CENTER);
        submit.setBackground(new Color(216,214,214));
        submit.setFocusable(false);
        submit.setBounds(298,765,100,35);
        submit.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        submit.addActionListener(this);
        submit.setEnabled(false);
        qpanel.add(submit);

        //create and add qpanel scrollpane
        sp1 = new JScrollPane(qpanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp1.setBounds(12,135,576,510);
        sp1.getVerticalScrollBar().setUnitIncrement(30);
        sp1.getViewport().putClientProperty("EnableWindowBlit", Boolean.TRUE);
        sp1.getViewport().setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);
        phqpanel.add(sp1);
            
        //create the result panel
        rpanel = new Panel();
        rpanel.fadeOut();
            
        //create the design for the result panel
        design = new JPanel();
        design.setBackground(Color.WHITE);
        design.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        design.setLayout(null);

        //create and add result panel title
        resulttitle = new JLabel("<html><left> Results </left></html>");
        resulttitle.setFont(new Font("Baskerville Old Face",Font.BOLD,30));
        resulttitle.setForeground(Color.black);
        resulttitle.setBounds(36,36,350,400);
        resulttitle.setVerticalAlignment(JLabel.TOP);
        design.add(resulttitle);

        //create and add design scrollpane
        sp2 = new JScrollPane(design,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp2.setBounds(20,20,440,500);
        sp2.getVerticalScrollBar().setUnitIncrement(30);
        sp2.getViewport().putClientProperty("EnableWindowBlit", Boolean.TRUE);
        sp2.getViewport().setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);
        rpanel.add(sp2);

        pane.add(mainPanel,Integer.valueOf(0));
        pane.add(phqpanel, Integer.valueOf(2));
        pane.add(rpanel, Integer.valueOf(1));
    }

    @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==ret) {
                opt = JOptionPane.showConfirmDialog(null, "Are you sure?", "Returning", JOptionPane.YES_NO_OPTION);
                    if (opt==JOptionPane.YES_OPTION) {
                        dispose();
                        new MHA();
                    }
            }

            if (e.getSource()==check) {
                if (bpanel1.getValue()==bpanel2.getValue() && bpanel2.getValue()==bpanel3.getValue() && 
                bpanel3.getValue()==bpanel4.getValue() && bpanel4.getValue()==bpanel5.getValue() && 
                bpanel5.getValue()==bpanel6.getValue() && bpanel6.getValue()==bpanel7.getValue() &&
                bpanel7.getValue()==bpanel8.getValue() && bpanel8.getValue()==bpanel9.getValue()) {
                    submit.setEnabled(true);
                }
            }
                
            if (e.getSource()==submit) {
                total = bpanel1.Value() + bpanel2.Value() + bpanel3.Value() + bpanel4.Value() + bpanel5.Value() + bpanel6.Value() + bpanel7.Value() + bpanel8.Value() + bpanel9.Value();
                    if (total > 14) {
                        design.setPreferredSize(new Dimension(440,706));
                        res = new Text2();
                        res.setText("<html><p align = justify> The result of your test shows that you have: </p></html>");
                        res.setBounds(36,107,350,400);
                        design.add(res);

                        result = new Text2();
                        result.setText("MODERATELY SEVERE TO SEVERE DEPRESSION");
                        result.setBackground(Color.RED);
                        result.setBounds(36,133,282,15);
                        result.setOpaque(true);
                        design.add(result);

                        sug = new Text2();
                        sug.setText("""
                                    <html><p align = justify> Signs of severe depression can include feelings of hopelessness, increased irritability, loss of pleasure, trouble concentrating or sleeping, or thoughts of death of suicide. 
                                    Technically, severe depression isn't a formal mental health diagnosis. Rather, it refers to depression that is more debilitating in nature. With severe depression, the signs are generally noticeable to friends and family. 
                                    The symptoms for severe depression can last for months-an average of six months or longer. Although not common, people with major depression can also experience hallucinations, delusions and suicidal thoughts. 
                                    If someone has severe depression, they may self-harm, have suicidal thoughts, or be at risk for attempting suicide. If you are severely depressed, help is available to help you manage your symptoms and ensure your safety and well-being.
                                    
                                    <br><br> If you've taken self-help steps and made positive lifestyle changes and still find your depression getting worse, seek professional help.
                                    
                                    <br><br> Thank you! </p></html>""");
                        sug.setBounds(36,164,350,450);
                        design.add(sug);

                        finish = new Fbutton();
                        finish.setBounds(241,635,100,35);
                        design.add(finish);

                        save = new Sbutton();
                        save.setBounds(101,635,100,35);
                        design.add(save);
                    }
                    
                    else if (total > 9 && total < 15) {
                        design.setPreferredSize(new Dimension(440,610));
                        res = new Text2();
                        res.setText("<html><p align = justify> The result of your test shows that you have: </p></html>");
                        res.setBounds(36,107,380,400);
                        design.add(res);

                        result = new Text2();
                        result.setText("MODERATE DEPRESSION");
                        result.setBackground(Color.ORANGE);
                        result.setBounds(36,133,151,15);
                        result.setOpaque(true);
                        design.add(result);

                        sug = new Text2();
                        sug.setText("""
                                    <html><p align = justify> Someone with moderate depression may experience symptoms that are more serious in terms of severity and duration than someone with mild depression. 
                                    They may also experience more symptoms than a person with mild depression does. People with moderate depression are more likely to experience primary symptoms of low mood, sleep difficulties, weight or appetite changes, and increased/slowed psychomotor activity. 
                                    However, moderate depression is not listed as a diagnosis in the Diagnostic and Statistical Manual of Mental Disorders, Fifth Edition (DSM-5).  
                                    
                                    <br><br> If you've taken self-help steps and made positive lifestyle changes and still find your depression getting worse, seek professional help.
                                    
                                    <br><br> Thank you! </p></html>""");
                        sug.setBounds(36,164,350,400);
                        design.add(sug);

                        finish = new Fbutton();
                        finish.setBounds(241,539,100,35);
                        design.add(finish);

                        save = new Sbutton();
                        save.setBounds(101,539,100,35);
                        design.add(save);
                    }

                    else if (total > 0 && total < 10) {
                        design.setPreferredSize(new Dimension(440,588));
                        res = new Text2();
                        res.setText("<html><p align = justify> The result of your test shows that you have: </p></html>");
                        res.setBounds(36,107,350,400);
                        design.add(res);

                        result = new Text2();
                        result.setText("MINIMAL TO MILD DEPRESSION");
                        result.setBackground(Color.YELLOW);
                        result.setBounds(36,133,195,15);
                        result.setOpaque(true);
                        design.add(result);

                        sug = new Text2();
                        sug.setText("""
                                    <html><p align = justify> When someone experiences a mild, low-grade episode of depression, 
                                    the symptoms can be subtle enough that the patient doesn't realize that what they're experiencing are signs of the clinical mood disorder dysthymia. 
                                    They may mistakenly believe that their long-term feelings of sadness and displays of low mood and energy are normal parts of their personality. 
                                    But what patients and their loved ones need to realize in order to seek treatment is that feeling down, sad, negative, and fatigued all of the time is not a normal part of life. 
                                    
                                    <br><br> If you've taken self-help steps and made positive lifestyle changes and still find your depression getting worse, seek professional help. 
                                    
                                    <br><br> Thank you! </p></html>""");
                        sug.setBounds(36,164,350,400);
                        design.add(sug);

                        finish = new Fbutton();
                        finish.setBounds(241,517,100,35);
                        design.add(finish);

                        save = new Sbutton();
                        save.setBounds(101,517,100,35);
                        design.add(save);
                    }

                    else if (total == 0) {
                        design.setPreferredSize(new Dimension(440,546));
                        res = new Text2();
                        res.setText("<html><p align = justify> The result of your test shows that you have: </p></html>");
                        res.setBounds(36,107,350,400);
                        design.add(res);

                        result = new Text2();
                        result.setText("NO DEPRESSION");
                        result.setBackground(Color.GREEN);
                        result.setBounds(36,133,101,15);
                        result.setOpaque(true);
                        design.add(result);

                        sug = new Text2();
                        sug.setText("""
                                    <html><p align = justify> Get rid of that depression! 
                                    
                                    <br><br> Taking the first step is always the hardest. But going for a walk or getting up and dancing to your favorite music, 
                                    for example, is something you can do right now. And it can substantially boost your mood and energy for several hours—long enough to put a second recovery step into action, 
                                    such as preparing a mood-boosting meal or arranging to meet an old friend. 
                                    By taking the following small but positive steps day by day, you'll soon lift the heavy fog of depression and find yourself feeling happier, healthier, and more hopeful again.  
                                    
                                    <br><br> Thank you! </p></html>""");
                        sug.setBounds(36,164,350,400);
                        design.add(sug);

                        finish = new Fbutton();
                        finish.setBounds(241,475,100,35);
                        design.add(finish);

                        save = new Sbutton();
                        save.setBounds(101,475,100,35);
                        design.add(save);
                    }
                pane.remove(rpanel);
                pane.remove(phqpanel);
                pane.add(phqpanel, Integer.valueOf(1));
                pane.add(rpanel, Integer.valueOf(2));
                rpanel.fadeIn();
                submit.setEnabled(false);
            }
        }

    class Text1 extends JLabel {
        Text1() {
            setFont(new Font("Times New Roman",Font.PLAIN,14));
            setVerticalAlignment(JLabel.TOP);
            setForeground(Color.BLACK);
        }
    }

    class Text2 extends JLabel {
        Text2() {
            setFont(new Font("Calibri Light",Font.PLAIN,15));
            setVerticalAlignment(JLabel.TOP);
            setForeground(Color.BLACK);
        }
    }

    class Question extends JLabel {
        Question() {
            setFont(new Font("Times New Roman", Font.PLAIN, 15));
            setVerticalAlignment(JLabel.TOP);
            setForeground(Color.BLACK);
        }
    }

    class Buttonpanel extends JPanel implements ActionListener {
        private int value;
        int num;
        int i = 4;
        String weight;
        JRadioButton [] options = new JRadioButton[i];

        Buttonpanel(int value) {
            setValue(value);
            setOpaque(false);
            setBackground(null);
            setLayout(new FlowLayout(FlowLayout.CENTER,52,0));

            options[0] = new JRadioButton();
            options[1] = new JRadioButton();
            options[2] = new JRadioButton();
            options[3] = new JRadioButton();

            ButtonGroup group = new ButtonGroup();
                for(int i = 0; i < 4; i++) {
                    group.add(options[i]);
                    options[i].addActionListener(this);
                    options[i].setBackground(null);
                    add(options[i]);
                }
        }

        @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < 4; i++) {
                    if(e.getSource()==options[0]) {
                        num = 0;
                        weight = "Not at all";
                        value = 0;
                    } else if (e.getSource()==options[1]) {
                        num = 1;
                        weight = "Several Days";
                        value = 0;
                    } else if (e.getSource()==options[2]) {
                        num = 2;
                        weight = "More than half the days";
                        value = 0;
                    } else if (e.getSource()==options[3]) {
                        num = 3;
                        weight = "Nearly everyday";
                        value = 0;
                    }
                }
                Value();
            }

        private int Value() {
            return num;
        }

        private String Text() {
            return weight;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    class Fbutton extends JButton implements ActionListener {
        Fbutton() {
            setText("Finish");
            setFont(new Font("Times New Roman",Font.PLAIN,14));
            setForeground(Color.black);
            setVerticalTextPosition(JButton.CENTER);
            setBackground(new Color(216,214,214));
            setFocusable(false);
            setBorder(BorderFactory.createRaisedSoftBevelBorder());
            addActionListener(this);
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            if (e.getSource()==this) {
                dispose();
                new MHA();
            }
        }
    }

    class Sbutton extends JButton {
        Sbutton() {
            setText("Save");
            setFont(new Font("Times New Roman",Font.PLAIN,14));
            setForeground(Color.black);
            setVerticalTextPosition(JButton.CENTER);
            setBackground(new Color(216,214,214));
            setFocusable(false);
            setBorder(BorderFactory.createRaisedSoftBevelBorder());
            addActionListener(new SaveHandler());
        }
    }

    class SaveHandler implements ActionListener {

        public void actionPerformed(ActionEvent e){
            final JFileChooser fc = new JFileChooser();
            int returnVal = fc.showSaveDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    String filename = file.getAbsolutePath();
                        if (!filename.endsWith(".txt"))
                            file = new File(filename + ".txt");

                                try (PrintWriter out = new PrintWriter(file)) {
                                    out.println("Result");
                                    out.println("\nBased on your test:");
                                    out.println("\nOver the last 2 weeks, how often have you been bothered by the following problems?: \n");
                                    out.println("   1. Little interest or pleasure in doing things:              " + bpanel1.Text());
                                    out.println("   2. Feeling down, depressed, or hopeless:                     " + bpanel2.Text());
                                    out.println("   3. Trouble falling or staying asleep, or sleeping too much:  " + bpanel3.Text());
                                    out.println("   4. Feeling tired or having little energy:                    " + bpanel4.Text());
                                    out.println("   5. Poor appetite or overeating:                              " + bpanel5.Text());
                                    out.println("   6. Feeling bad about yourself or that you are a failure      " + bpanel6.Text());
                                    out.println("      or have let yourself or your family down:");
                                    out.println("   7. Trouble concentrating on things, such as reading the:     " + bpanel7.Text());
                                    out.println("      newspaper or watching television:");
                                    out.println("   8. Moving or speaking so slowly that other people could:     " + bpanel8.Text());
                                    out.println("      have noticed. Or the opposite being so figety or");
                                    out.println("      restless that you have been moving around a lot");
                                    out.println("      than usual: ");
                                    out.println("   9. Thoughts that you would be better off dead                " + bpanel9.Text());
                                    out.println("      or of hurting yourself:" );
                                    out.println("\nIt shows that you have:\n" + result.getText());
                                    out.println("\nIf you've taken self-help steps and made positive lifestyle changes and still find your depression getting worse, seek professional help.\n \nThank you!");
                                } catch (FileNotFoundException e1) {
                                    e1.printStackTrace();
                                }
                    JOptionPane.showMessageDialog(null, "Saved Successfully!", "Saved", JOptionPane.PLAIN_MESSAGE);
                } 
                
                else {
                    JOptionPane.showMessageDialog(null, "Save Cancelled!", "Cancelled", JOptionPane.PLAIN_MESSAGE);
                }
        }
    } 
    
    public interface FaderListener {
        public void fadeDidComplete(Panel panel);
    }

    public class Panel extends JPanel {

        private double alpha = 1;
        private boolean fadingIn = true;
        private DoubleAnimatable animatable;
        private Duration duration = Duration.ofSeconds(1);
        private List<FaderListener> listeners = new ArrayList<>(1);
        private Color backgroundColor;
        private int cornerRadius = 15;

        public Panel() {
        setBackground(new Color(252,204,242));
        setBounds(73,70,480,540);
        setBorder(BorderFactory.createRaisedSoftBevelBorder());
        setLayout(null);
        setOpaque(false);
        }

        public Panel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
            setOpaque(false);
        }
    
        public Panel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
            setOpaque(false);
        }
    
        public Panel(int radius) {
            super();
            cornerRadius = radius;
            setLayout(null);
            setOpaque(false);
        }
    
        public Panel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
            setLayout(null);
            setOpaque(false);
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }

        public double getAlpha() {
            return alpha;
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.SrcOver.derive((float)getAlpha()));
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
            super.paint(g2d);
            g2d.dispose();
        }

        protected void fadeTo(double to) {
            double currentAlpha = getAlpha();
            if (animatable != null) {
                animatable.stop();
                animatable = null;
            }

            if (currentAlpha == to) {
                fadeDidComplete();
                return;
            }

            DoubleRange animationRange = new DoubleRange(currentAlpha, to);
            double maxFrom = to == 1 ? 1 : 0;
            double maxTo = to == 1 ? 0 : 1;
            DoubleRange maxRange = new DoubleRange(maxFrom, maxTo);

            animatable = new DoubleAnimatable(animationRange, maxRange, duration, new AnimatableListener<Double>() {
                @Override
                public void animationChanged(Animatable<Double> animatable) {
                    alpha = animatable.getValue();
                    repaint();
                }
            }, new AnimatableLifeCycleListenerAdapter<Double>() {
                @Override
                public void animationCompleted(Animatable<Double> animatable) {
                    fadeDidComplete();
                }
            });

            Animator.INSTANCE.add(animatable);
        }

        public void fadeIn() {
            fadingIn = true;
            fadeTo(1);
        }

        public void fadeOut() {
            fadingIn = false;
            fadeTo(0);
        }

        protected void fadeDidComplete() {            
            for (FaderListener listener : listeners) {
                listener.fadeDidComplete(this);
            }
        }
    }

    public class DoubleAnimatable extends AbstractAnimatable<Double> {

        public DoubleAnimatable(DoubleRange animationRange, DoubleRange maxRange, Duration duration, AnimatableListener<Double> listener, AnimatableLifeCycleListener<Double> lifeCycleListener) {
            super(animationRange, duration, listener, lifeCycleListener);

            double maxDistance = maxRange.getDistance();
            double aniDistance = animationRange.getDistance();

            double progress = Math.min(100, Math.max(0, Math.abs(aniDistance / maxDistance)));
            Duration remainingDuration = Duration.ofMillis((long) (duration.toMillis() * progress));
            setDuration(remainingDuration);
        }

    }

    public interface AnimatableListener<T> {
        public void animationChanged(Animatable<T> animatable);
    }

    public interface AnimatableLifeCycleListener<T> {
        public void animationStopped(Animatable<T> animatable);
        public void animationCompleted(Animatable<T> animatable);
        public void animationStarted(Animatable<T> animatable);
        public void animationPaused(Animatable<T> animatable);        
    }

    public class AnimatableLifeCycleListenerAdapter<T> implements AnimatableLifeCycleListener<T> {

        @Override
        public void animationStopped(Animatable<T> animatable) {
        }

        @Override
        public void animationCompleted(Animatable<T> animatable) {
        }

        @Override
        public void animationStarted(Animatable<T> animatable) {
        }

        @Override
        public void animationPaused(Animatable<T> animatable) {
        }

    }

    public abstract class AbstractAnimatable<T> implements Animatable<T> {

        private Range<T> range;
        private LocalDateTime startTime;
        private Duration duration = Duration.ofSeconds(5);
        private T value;
        private AnimatableListener<T> animatableListener;
        private AnimatableLifeCycleListener<T> lifeCycleListener;
        private double rawOffset;

        public AbstractAnimatable(Range<T> range, Duration duration, AnimatableListener<T> listener) {
            this.range = range;
            this.value = range.getFrom();
            this.animatableListener = listener;
        }

        public AbstractAnimatable(Range<T> range, Duration duration, AnimatableListener<T> listener, AnimatableLifeCycleListener<T> lifeCycleListener) {
            this(range, duration, listener);
            this.lifeCycleListener = lifeCycleListener;
        }

        public Duration getDuration() {
            return duration;
        }

        public Range<T> getRange() {
            return range;
        }

        public void setRange(Range<T> range) {
            this.range = range;
        }

        @Override
        public T getValue() {
            return value;
        }

        protected void setDuration(Duration duration) {
            this.duration = duration;
        }

        public double getCurrentProgress(double rawProgress) {
            double progress = Math.min(1.0, Math.max(0.0, getRawProgress()));
            return Math.min(1.0, Math.max(0.0, progress));
        }

        public double getRawProgress() {
            if (startTime == null) {
                return 0.0;
            }
            Duration duration = getDuration();
            Duration runningTime = Duration.between(startTime, LocalDateTime.now());
            double progress = rawOffset + (runningTime.toMillis() / (double) duration.toMillis());

            return Math.min(1.0, Math.max(0.0, progress));
        }

        @Override
        public void tick() {
            if (startTime == null) {
                startTime = LocalDateTime.now();
                fireAnimationStarted();
            }
            double rawProgress = getRawProgress();
            double progress = getCurrentProgress(rawProgress);
            if (rawProgress >= 1.0) {
                progress = 1.0;
            }
            value = getRange().valueAt(progress);
            fireAnimationChanged();
            if (rawProgress >= 1.0) {
                fireAnimationCompleted();
            }
        }

        @Override
        public void start() {
            if (startTime != null) {
                return;
            }
            Animator.INSTANCE.add(this);
        }

        @Override
        public void stop() {
            stopWithNotification(true);
        }

        @Override
        public void pause() {
            rawOffset += getRawProgress();
            stopWithNotification(false);

            double remainingProgress = 1.0 - rawOffset;
            Duration remainingTime = getDuration().minusMillis((long) remainingProgress);
            setDuration(remainingTime);

            lifeCycleListener.animationStopped(this);
        }

        protected void fireAnimationChanged() {
            if (animatableListener == null) {
                return;
            }
            animatableListener.animationChanged(this);
        }

        protected void fireAnimationCompleted() {
            stopWithNotification(false);
            if (lifeCycleListener == null) {
                return;
            }
            lifeCycleListener.animationCompleted(this);
        }

        protected void fireAnimationStarted() {
            if (lifeCycleListener == null) {
                return;
            }
            lifeCycleListener.animationStarted(this);
        }

        protected void fireAnimationPaused() {
            if (lifeCycleListener == null) {
                return;
            }
            lifeCycleListener.animationPaused(this);
        }

        protected void stopWithNotification(boolean notify) {
            Animator.INSTANCE.remove(this);
            startTime = null;
            if (notify) {
                if (lifeCycleListener == null) {
                    return;
                }
                lifeCycleListener.animationStopped(this);
            }
        }

    }

    public interface Animatable<T> {

        public Range<T> getRange();

        public T getValue();

        public void tick();

        public Duration getDuration();

        public void start();

        public void stop();

        public void pause();
    }

    public abstract class Range<T> {

        private T from;
        private T to;

        public Range(T from, T to) {
            this.from = from;
            this.to = to;
        }

        public T getFrom() {
            return from;
        }

        public T getTo() {
            return to;
        }

        @Override
        public String toString() {
            return "From " + getFrom() + " to " + getTo();
        }

        public abstract T valueAt(double progress);

    }

    public class DoubleRange extends Range<Double> {

        public DoubleRange(Double from, Double to) {
            super(from, to);
        }

        public Double getDistance() {
            return getTo() - getFrom();
        }

        @Override
        public Double valueAt(double progress) {
            double distance = getDistance();
            double value = distance * progress;
            value += getFrom();
            return value;
        }
    }

    public enum Animator {
        INSTANCE;
        private Timer timer;
        private List<Animatable> properies;

        private Animator() {
            properies = new ArrayList<>(5);
            timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<Animatable> copy = new ArrayList<>(properies);
                    Iterator<Animatable> it = copy.iterator();
                    while (it.hasNext()) {
                        Animatable ap = it.next();
                        ap.tick();
                    }
                    if (properies.isEmpty()) {
                        timer.stop();
                    }
                }
            });
        }

        public void add(Animatable ap) {
            properies.add(ap);
            timer.start();
        }

        protected void removeAll(List<Animatable> completed) {
            properies.removeAll(completed);
        }

        public void remove(Animatable ap) {
            properies.remove(ap);
            if (properies.isEmpty()) {
                timer.stop();
            }
        }
    }
}
