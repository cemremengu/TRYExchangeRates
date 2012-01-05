package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import data.IExchangeSource;
import data.TCMB;

public class MainFrame {

    private final JTextArea textArea = new JTextArea();


    public static void main(final IExchangeSource s) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame(s);
            }
        });
    }
    public MainFrame(final IExchangeSource s) {
        //build gui
    	s.setView(this);
		s.update();
        final JComboBox comboBox = new JComboBox();

        comboBox.addItem("USD/TRY");
        comboBox.addItem("EUR/TRY");
        comboBox.addItem("GBP/TRY");

        JFrame f = new JFrame("TRY Exchange Rates");
        JPanel p = new JPanel(new BorderLayout());
        textArea.setName("textarea");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);

        comboBox.setSelectedIndex(-1);
        comboBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                s.getData(comboBox.getSelectedItem().toString());
            }
        });

        p.add(comboBox, BorderLayout.NORTH);
        p.add(textArea, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setSize(new Dimension(300, 300));
        f.add(p);
        f.setVisible(true);
    }

	
	public void setTextArea(String text)
	{
		textArea.setText(text);
	}
	

	
	
}
