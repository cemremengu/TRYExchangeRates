import data.IExchangeSource;
import data.TCMB;
import view.*;

public class Main 
{
		/**
		 * Main class which inits the data source and passes it to the view.
		 * @param args
		 */
		public static void main(String[] args)
		{
			IExchangeSource s  = new TCMB("http://www.tcmb.gov.tr/kurlar/today.html", "TCMB"); // init
			
			s.parse(); // populate the data structures
			
			MainFrame.main(s);  // pass it to the GUI
		}

}
