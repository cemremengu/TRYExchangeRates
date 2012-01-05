package data;

import view.MainFrame;

public interface IExchangeSource 
{
	
	public void update();
	
	public void getData(String exchange);
	
	public void setView(MainFrame f);

	
}
