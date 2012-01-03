package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame {

	public MainFrame()
	{
		// init gui elements
		JFrame f = new JFrame("Currency Converter");
		JPanel p = new JPanel(new BorderLayout());
		final JComboBox l = new JComboBox(new String[]{"USD/TRY", "EUR/TRY", "GBP/TRY"});
		final JTextArea b = new JTextArea(); 
		b.setWrapStyleWord(true);
		b.setLineWrap(true);
		
		// place them and start up the GUI
		p.add(l, BorderLayout.NORTH);
		p.add(b, BorderLayout.CENTER);
		f.setPreferredSize(new Dimension(300, 300));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.add(p);
		l.setSelectedIndex(0);
		f.setVisible(true); 
	
	}
	
}
