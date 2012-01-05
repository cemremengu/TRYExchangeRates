import data.IExchangeSource;
import data.TCMB;
import view.*;

public class Main 
{

		public static void main(String[] args)
		{
			IExchangeSource s  = new TCMB("http://www.tcmb.gov.tr/kurlar/today.html");
			MainFrame.main(s) ; 
				
			

		}

}
