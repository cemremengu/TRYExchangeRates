package data;

import java.math.BigDecimal;
import java.util.HashMap;

public interface ICurrencySource {

	
	public HashMap<String, String> parse();
	
	public void update();
	
	
}
