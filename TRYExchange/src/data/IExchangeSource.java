package data;

import javax.swing.JTextArea;


public interface IExchangeSource 
{
	
	public void update();
	
	public void getData(String exchange, JTextArea ta);
	

	
}
