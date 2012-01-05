package data;

import javax.swing.JTextArea;

import view.MainFrame;

public interface IExchangeSource 
{
	
	public void update();
	
	public void getData(String exchange, JTextArea ta);
	

	
}
