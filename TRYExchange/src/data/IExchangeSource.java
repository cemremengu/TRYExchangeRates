package data;

import javax.swing.JTextArea;


public interface IExchangeSource 
{	
	public void parse();
	
	public void getData(String exchange, JTextArea ta);
}
