import data.TCMB;
import view.*;

public class Main {

		public static void main(String[] args)
		{
			MainFrame f = new MainFrame();
			TCMB t = new TCMB("http://www.tcmb.gov.tr/kurlar/today.html");
			t.parse();
		}
}
