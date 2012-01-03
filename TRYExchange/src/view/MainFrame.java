package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainFrame {

	private final JTextArea textArea = new JTextArea(); 
	private final JComboBox comboBox = new JComboBox(new String[]{"USD/TRY", "EUR/TRY", "GBP/TRY"});


	
	public MainFrame()
	{
		//build gui
		JFrame f = new JFrame("Currency Converter");
		JPanel p = new JPanel(new BorderLayout());
		textArea.setName("textarea");
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		comboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String exchange = (String) comboBox.getSelectedItem();	
				
			}
		});
		
		// place them and start up the GUI
		p.add(comboBox, BorderLayout.NORTH);
		p.add(textArea, BorderLayout.CENTER);
		f.setPreferredSize(new Dimension(300, 300));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.add(p);
		comboBox.setSelectedIndex(0);
		f.setVisible(true); 
	}
//	
//	public JTextArea getTextArea(){	return textArea;}
//	public JComboBox comboBox(){return comboBox;}
	
	public void setTextArea(String text)
	{
		textArea.setText(text);
	}
	

	
}
