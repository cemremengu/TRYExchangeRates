package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import data.IExchangeSource;

public class MainFrame {

    private final JTextArea textArea = new JTextArea();
    private final JComboBox comboBox = new JComboBox();
    
    public static final int WIDTH = 250;
    public static final int HEIGHT = 200;

    public static void main(final IExchangeSource s) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame(s);
            }
        });
    }
    
    public MainFrame(final IExchangeSource s) {

        comboBox.addItem("USD/TRY");
        comboBox.addItem("EUR/TRY");
        comboBox.addItem("GBP/TRY");
        
        JFrame f = new JFrame("TRY Exchange Rates");
        
        JPanel p = new JPanel(new BorderLayout());
        textArea.setName("textarea");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEnabled(false);

        comboBox.setSelectedIndex(-1);
        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                s.getData(comboBox.getSelectedItem().toString(), textArea); // query the source to update the text area
            }
        });

        p.add(comboBox, BorderLayout.NORTH);
        p.add(textArea, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);
        f.pack(); 

        f.setSize(new Dimension(WIDTH, HEIGHT));
        
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Determine the new location of the window
        int w = f.getSize().width;
        int h = f.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
         
        // Move the window
        f.setLocation(x, y);
        
        f.setVisible(true);
    }	
}
