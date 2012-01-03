package data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TCMB implements ICurrencySource {

	private String url;
	private String euroBuy;
	private String euroSell;
	private String usdBuy;
	private String usdSell;
	private String gbpBuy;
	private String gbpSell;


	
	public TCMB(String url)
	{
		this.url = url;
	}
	
	@Override
	public HashMap<String, String> parse() 
	{
		try 
		{
			URL u = new URL(url);
	        
			BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));

	        String eurb = null, eurs = null, gbpb = null, gbps = null, usdb = null, usds = null;

	            boolean firstLine = true;

	            String line;
	            while ((line = br.readLine()) != null) {
	                StringTokenizer st = new StringTokenizer(line);

	                while (st.hasMoreTokens()) {
	                    String token = st.nextToken();

	                    if (firstLine) {
	                        if (token.equals("15:30")) {
	                            token = st.nextToken();
	                            token = st.nextToken();

	                            String[] a = token.split("/");

	                            firstLine = false;
	                        }
	                    }

	                    if (token.equals("EUR/TRY")) {
	                        token = st.nextToken();
	                        token = st.nextToken();
	                        token = st.nextToken();
	                        token = st.nextToken();

	                        euroBuy = st.nextToken();
	                        euroSell = st.nextToken();
	                    }

	                    if (token.equals("GBP/TRY")) {
	                        token = st.nextToken();
	                        token = st.nextToken();
	                        token = st.nextToken();
	                        token = st.nextToken();
	                        token = st.nextToken();

	                        gbpBuy = st.nextToken();
	                        gbpSell = st.nextToken();
	                    }

	                    if (token.equals("USD/TRY")) {
	                        token = st.nextToken();
	                        token = st.nextToken();
	                        token = st.nextToken();
	                        token = st.nextToken();
	                        token = st.nextToken();

	                        usdBuy = st.nextToken();
	                        usdSell = st.nextToken();
	                    }
	                }
	            }
	            br.close();
	            System.out.println(usdb);
	            
	        } catch (Exception e) {
	            System.err.printf("Something went wrong while connecting! Error: %s\n", e.getMessage());
	        }
		 
		 return null;
		 
	    }
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
