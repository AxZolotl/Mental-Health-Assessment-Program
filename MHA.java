import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.Timer;

public class MHA extends JFrame implements ActionListener {
    //layered pane
    JLayeredPane pane;
    
    //panels
    Panel intropanel;
    Panel testpanel;
    Panel rdesign1;
    Panel rdesign2;
    Panel rdesign3;
    Panel rdesign4;

    //labels
    JLabel message;
    Title introtitle;
    Title testtitle;
    JLabel test;
    JLabel description;
    ADes gaddes;
    ADes phqdes;
    ADes ocides;
    ADes aaides;

    //buttons
    PRButton proceed;
    PRButton ret;
    Testbutton gad;
    Testbutton phq;
    Testbutton oci;
    Testbutton aai;

    //scrollpanes
    JScrollPane sp1;
    JScrollPane sp2;

    //menubar
    JMenuBar mbar;

    //menu
    JMenu help;

    //menuitem
    JMenuItem aboutus;

    public static void main(String[] args) {
        new MHA();
    }

    public MHA() {
        EventQueue.invokeLater(new Runnable() {
            @Override
                public void run() {
                    setTitle("MHA");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setResizable(false);
                    setLayout(null);
                    setSize(640,720);
                    getContentPane().setBackground(new Color(255,255,255));

                    //set the program in the center of screen
                    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
                    int width = 640;
                    int height = 720;
                    setBounds(center.x - width / 2, center.y - height / 2, width, height);

                    //create and set a program icon
                    ImageIcon icon = new ImageIcon("ProjectIcon.png");
                    setIconImage(icon.getImage());

                    add(pane);
                    setJMenuBar(mbar);
                    setVisible(true);
                }
        });
        //create menubar
        mbar = new JMenuBar();
        mbar.add(Box. createHorizontalGlue());

        //create menu
        help = new JMenu("Help");
        help.setFont(new Font("Arial", Font.PLAIN,12));
        help.setMnemonic(KeyEvent.VK_H);
        mbar.add(help);

        //create menuitem
        aboutus = new JMenuItem("About Us");
        aboutus.setFont(new Font("Arial", Font.PLAIN,12));
        aboutus.setMnemonic(KeyEvent.VK_A);
        aboutus.addActionListener(this);
        help.add(aboutus);

        //create main pane
        pane = new JLayeredPane();
        pane.setBounds(0,0,640,720);

        //create a program background
        ImageIcon framebackground = new ImageIcon("Mental.gif");
        JLabel framebg = new JLabel(framebackground);
        framebg.setBounds(0,0,640,720);

        //create the first panel
        intropanel = new Panel(50, new Color(252,204,242));
        intropanel.setBounds(73,70,480,540);

        //create and add title to first panel
        introtitle = new Title("<html><center> Welcome to Mental Health Assessment! </center></html>");
        introtitle.setBounds(65,50,350,400);
        intropanel.add(introtitle);

        //create and add a message
        message = new JLabel("""
                            <html><p align = justify> Health is an asset that helps us maintain the balance of life and a sound mind. 
                            It's the true elixir for a happy life as it leads to a calm and composed mind. 
                            Mental Health Assessment is a program that contains four different mental health tests. 
                            The following questions in every test will elucidate the significance and vitality of being healthy in our lives and will aid us in improving the health of others. 
                            
                            <br><br> However, the assessments do not signifify as diagnostic tests, but rather, self-assessments. 
                            
                            <br><br><p align = center> Thank you! </p></p></html>
                            """);
        message.setFont(new Font("Calibri Light",Font.PLAIN,15));
        message.setForeground(Color.black);
        message.setBounds(65,150,350,400);
        message.setVerticalAlignment(JLabel.TOP);
        intropanel.add(message);

        //create and add proceed button
        //function: continue to second panel
        proceed = new PRButton("Proceed");
        proceed.setBounds(190,460,100,35);
        proceed.addActionListener(this);
        intropanel.add(proceed);

        //create the second panel
        testpanel = new Panel(50, new Color(252,204,242));
        testpanel.setBounds(73,70,480,540);
        testpanel.fadeOut();

        //create panel designs
        rdesign1 = new Panel(20, Color.BLACK);
        rdesign1.setBounds(20,20,20,20);
        testpanel.add(rdesign1);

        rdesign2 = new Panel(20, Color.BLACK);
        rdesign2.setBounds(440,20,20,20);
        testpanel.add(rdesign2);

        rdesign3 = new Panel(20, Color.BLACK);
        rdesign3.setBounds(20,500,20,20);
        testpanel.add(rdesign3);

        rdesign4 = new Panel(20, Color.BLACK);
        rdesign4.setBounds(440,500,20,20);
        testpanel.add(rdesign4);

        //create and add title to second panel
        testtitle = new Title("<html><center> Take your Desired Assessment Now! </center></html>");
        testtitle.setBounds(65,50,350,400);
        testpanel.add(testtitle); 

        //create assessment options
        test = new JLabel("Test Type");
        test.setFont(new Font("Calibri Light",Font.BOLD,15));
        test.setForeground(Color.WHITE);
        test.setBackground(new Color(140,64,148));
        test.setVerticalAlignment(JLabel.CENTER);
        test.setHorizontalAlignment(JLabel.CENTER);
        test.setBounds(50,130,100,30);
        test.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        test.setOpaque(true);
        testpanel.add(test);

        description = new JLabel("Description");
        description.setFont(new Font("Calibri Light",Font.BOLD,15));
        description.setForeground(Color.WHITE);
        description.setBackground(new Color(174,140,178));
        description.setBounds(150,130,283,30);
        description.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        description.setOpaque(true);
        testpanel.add(description);

        //create assessment descriptions
        gaddes = new ADes("""
                          <html><p align = justify> Self-administered 7 item instrument that uses some of the DSM-V criteria for GAD (General Anxiety
                          Disorder) to identify probable cases of GAD along with measuring anxiety symptom severity. It can
                          also be used as a screening measure of panic, social anxiety, and PTSD. </p></html>""");
        gaddes.setBackground(new Color(255,255,255));
        gaddes.setBounds(150,160,283,70);
        testpanel.add(gaddes);

        phqdes = new ADes("""
                            <html><p align = justify> The PHQ-9 is a clinically-validated screening tool that healthcare providers use to screen for depression, 
                            and also to diagnose and monitor the severity of the condition. </html></p>""");
        phqdes.setBackground(new Color(224,224,224));
        phqdes.setBounds(150,230,283,70);
        testpanel.add(phqdes);

        ocides = new ADes("""
                          <html><p align = justify> The OCI-R is a short version of the OCD and is a 
                          self-report scale for assessing symptoms of Obsessive-Compulsive Disorder (OCD). It is a psychometrically sound and valid self-report scale measuring the major symptoms of OCD on six dimensions. 
                          It consists of 18 questions that a person endorses on a 5-point Likert scale. </p></html>""");
        ocides.setBackground(new Color(255,255,255));
        ocides.setPreferredSize(new Dimension(245,85));
        testpanel.add(ocides);

        aaides = new ADes("""
                          <html><p align = justify> The Appearance Anxiety Inventory is a 10 question self-report scale that measures the cognitive and behavioural aspects of body image anxiety in general, 
                          and body dysmorphic disorder (BDD) in particular. This scale is useful as part of a diagnostic procedure for BDD as well as symptom monitoring during treatment.)""");
        aaides.setBackground(new Color(224,224,224));
        aaides.setPreferredSize(new Dimension(245,87));
        testpanel.add(aaides);

        //create assessment buttons
        //function: proceed to anxiety test
        gad = new Testbutton("GAD-7");
        gad.setBounds(50,160,100,70);
        gad.addActionListener(this);
        testpanel.add(gad);

        //create and add OCI-R scrollpane
        sp1 = new JScrollPane(ocides,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp1.setBounds(150,300,283,70);
        testpanel.add(sp1);

        //create and add AAI scrollpane
        sp2 = new JScrollPane(aaides,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp2.setBounds(150,370,283,70);
        testpanel.add(sp2);
            
        //function: proceed to depression test
        phq = new Testbutton("PHQ-9");
        phq.setBounds(50,230,100,70);
        phq.addActionListener(this);
        testpanel.add(phq);

        //function: proceed to OCD test
        oci = new Testbutton("OCI-R");
        oci.setBounds(50,300,100,70);
        oci.addActionListener(this);
        testpanel.add(oci);

        //function: proceed to BDD test
        aai = new Testbutton("AAI");
        aai.setFont(new Font("Calibri Light",Font.PLAIN,15));
        aai.setBounds(50,370,100,70);
        aai.addActionListener(this);
        testpanel.add(aai);

        //create and add return button
        //function: return to first panel
        ret = new PRButton("Return");
        ret.setBounds(190,460,100,35);
        ret.addActionListener(this);
        testpanel.add(ret);

        pane.add(framebg, Integer.valueOf(0));
        pane.add(intropanel, Integer.valueOf(2));
        pane.add(testpanel, Integer.valueOf(1));
    }
        
    @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==aboutus) {
                new Aboutus();
            }
            if (e.getSource()==proceed) {
                proceed.setVisible(false);
                ret.setVisible(true);
                intropanel.fadeOut();
                testpanel.fadeIn();
            }
            
            if(e.getSource()==ret) {
                ret.setVisible(false);
                proceed.setVisible(true);
                testpanel.fadeOut();
                intropanel.fadeIn();    
            }

            if(e.getSource()==gad) {
                dispose();
                new GAD7();
            }

            if(e.getSource()==phq) {
                dispose();
                new PHQ9();
            }

            if(e.getSource()==oci) {
                dispose();
                new OCIR();
            }
            if(e.getSource()==aai) {
                dispose();
                new AAI();
            }
        }
    
    class Title extends JLabel {
        private String text;

        Title(String text) {
            setText(text);
            setFont(new Font("Baskerville Old Face",Font.PLAIN,30));
            setForeground(Color.black);
            setVerticalAlignment(JLabel.TOP);
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    class Testbutton extends JButton {
        private String text;

        Testbutton(String text) {
            setText(text);
            setFont(new Font("Calibri Light",Font.PLAIN,15));
            setForeground(Color.BLACK);
            //gad.setBackground(new Color(237,236,238));
            setVerticalAlignment(JLabel.CENTER);
            setHorizontalAlignment(JLabel.CENTER);
            setBorder(BorderFactory.createRaisedSoftBevelBorder());
            setFocusable(false);
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    class PRButton extends JButton {
        String text;

        PRButton (String text) {
            setText(text);
            setFont(new Font("Baskerville Old Face",Font.PLAIN,14));
            setForeground(Color.black);
            setVerticalTextPosition(JButton.CENTER);
            setBackground(new Color(216,214,214));
            setFocusable(false);
            setBorder(BorderFactory.createRaisedSoftBevelBorder());
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    class ADes extends JLabel {
        String text;

        ADes(String text) {
            setText(text);
            setFont(new Font("Calibri Light",Font.PLAIN,10));
            setForeground(Color.BLACK);
            setVerticalAlignment(JLabel.TOP);
            setBorder(BorderFactory.createLoweredBevelBorder());
            setOpaque(true); 
        }
    }
    
    public interface FaderListener {
        public void fadeDidComplete(Panel panel);
    }

    protected class Panel extends JPanel {

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
