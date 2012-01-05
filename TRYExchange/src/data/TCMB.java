package data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.swing.JTextArea;

import view.MainFrame;

public class TCMB implements IExchangeSource {

	private String url;
	private HashMap<String, String> buy;
	private HashMap<String, String> sell;
	
	
	public TCMB(String url)
	{
		this.url = url;
		buy = new HashMap<String,String>();
		sell = new HashMap<String,String>();

	}
	
	public void update() 
	{
		try 
		{
			URL u = new URL(url);
	        
			BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));

	        boolean firstLine = true;

            String line;
            while ((line = br.readLine()) != null) {
                
            	StringTokenizer st = new StringTokenizer(line);

                while (st.hasMoreTokens()) {
                    String token = st.nextToken();

                    if (firstLine) 
                    {
                        if (token.equals("15:30")) 
                        {
                            token = st.nextToken();
                            token = st.nextToken();

                            String[] a = token.split("/");

                            firstLine = false;
                        }
                    }

                    else if (token.equals("EUR/TRY")) // EURO
                    {
                        token = st.nextToken();
                        token = st.nextToken();
                        token = st.nextToken();
                        token = st.nextToken();
                        
                        buy.put("EUR/TRY", st.nextToken());
                        sell.put("EUR/TRY", st.nextToken());

                    }

                    else if (token.equals("GBP/TRY"))  // GB POUNDS
                    {
                        token = st.nextToken();
                        token = st.nextToken();
                        token = st.nextToken();
                        token = st.nextToken();
                        token = st.nextToken();

                        buy.put("GBP/TRY", st.nextToken());
                        sell.put("GBP/TRY", st.nextToken());
                    }

                    else if (token.equals("USD/TRY")) // US DOLLAR
                    {
                        token = st.nextToken();
                        token = st.nextToken();
                        token = st.nextToken();
                        token = st.nextToken();
                        token = st.nextToken();

                        buy.put("USD/TRY", st.nextToken());
                        sell.put("USD/TRY", st.nextToken());
                    }
                    else
                    {
                    	// do nothing
                    }
                }
            }
            br.close();
            
        } catch (Exception e) 
          {
            System.err.printf("Something went wrong while connecting! Error: %s\n", e.getMessage());
          }
	}
	
	
	// this is called by the GUI when the user chooses a value from the
	// combo box
	public void getData(String exchange, JTextArea ta)
	{
		String result;

		if(exchange.equals("EUR/TRY"))
		{
			result = "BUY : " + buy.get("EUR/TRY") + "\n" + "SELL : " + sell.get("EUR/TRY");
		}
		else if(exchange.equals("GBP/TRY"))
		{
			result = "BUY : " + buy.get("GBP/TRY") + "\n" + "SELL : " + sell.get("GBP/TRY");
		}
		else
		{
			result = "BUY : " + buy.get("USD/TRY") + "\n" + "SELL : " + sell.get("USD/TRY");
		}
		
		ta.setText(result);
	}
	

}
