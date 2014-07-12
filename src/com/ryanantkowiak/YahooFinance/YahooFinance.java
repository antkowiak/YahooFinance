/*
 * Copyright (c) 2014 Ryan Antkowiak (antkowiak@gmail.com).
 * All rights reserved.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
 * For a commercial use license, contact antkowiak@gmail.com.
 */
package com.ryanantkowiak.YahooFinance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;


/**
 * Collection of helper functions for scraping data from YahooFinance
 * 
 * @author Ryan Antkowiak (antkowiak@gmail.com)
 *
 */
public class YahooFinance
{

	/**
	 * Main entry point (for testing purposes)
	 * 
	 * @param args
	 * 			Program arguments (unused)
	 */
	/*
	public static void main(String [] args)
	{
		//YahooFinanceDebug.setMaxDataElements(10);
		
		System.out.println("AMEX:");
		AMEX.printSymbols();
		//System.out.println(new YahooFinanceQuotes(AMEX.getSymbols()));
		
		System.out.println("Dow30:");
		Dow30.printSymbols();
		//System.out.println(new YahooFinanceQuotes(Dow30.getSymbols()));

		System.out.println("NASDAQ:");
		NASDAQ.printSymbols();
		//System.out.println(new YahooFinanceQuotes(NASDAQ.getSymbols()));

		System.out.println("NYSE:");
		NYSE.printSymbols();
		//System.out.println(new YahooFinanceQuotes(NYSE.getSymbols()));

		System.out.println("SP500:");
		SP500.printSymbols();
		//System.out.println(new YahooFinanceQuotes(SP500.getSymbols()));
	}
	*/
	
	/**
	 * Generate the URL for getting dividend data from YahooFinance
	 * 
	 * @param sym
	 * 			The symbol name
	 * @return
	 * 			The URL
	 */
    public static String generateUrlForDividends(String sym)
    {
        String url = "http://ichart.finance.yahoo.com/table.csv?s="
        		+ sym
        		+ "&a=02&b=13&c=1900&d=00&e=27&f=2014&g=v&ignore=.csv";
        
        return url;
    }
    
	/**
	 * Generate the URL for getting historical price data from YahooFinance
	 * 
	 * @param sym
	 * 			The symbol name
	 * @return
	 * 			The URL
	 */
    public static String generateUrlForHistoricalPrices(String sym)
    {    	
    	String url = "http://ichart.finance.yahoo.com/table.csv?s="
    			+ sym
    			+ "&a=02&b=13&c=1900&d=00&e=27&f=2014&g=d&ignore=.csv";
    	return url;
    }
    
	/**
	 * Generate the URL for getting quote data from YahooFinance
	 * 
	 * @param sym
	 * 			The symbol name
	 * @return
	 * 			The URL
	 */
    public static String generateUrlForQuote(String sym)
    {
        String s =
            "http://finance.yahoo.com/d/quotes.csv?s=" + sym +
            "&f=a2b2b3cc1c6c8dd1d2ee1e7e8e9ghjkg1g3" +
            "g4g5g6ii5j1j3j4j5j6k1k2k4k5ll1l2l3mm2m3m4m5m6m7m8" +
            "n4opp1p2p5p6qrr1r2r5r6r7ss1s7t1t7t8vv1v7ww1w4xyn";

        return s;
    }
    
	/**
	 * Generate the URL for getting quote data for multiple symbols from YahooFinance
	 * 
	 * @param symbols
	 * 			The list of symbols
	 * @return
	 * 			The URL
	 */
    public static String generateUrlForQuotes(List<String> symbols)
    {
        String s =
                "http://finance.yahoo.com/d/quotes.csv?s=";
                
        for (int i = 0 ; i < symbols.size() ; ++i)
        {
        	if (i != 0)
        	{
        		s += "+";
        	}
        	
        	s += symbols.get(i);
        }
                
        s +="&f=a2b2b3cc1c6c8dd1d2ee1e7e8e9ghjkg1g3" +
            "g4g5g6ii5j1j3j4j5j6k1k2k4k5ll1l2l3mm2m3m4m5m6m7m8" +
            "n4opp1p2p5p6qrr1r2r5r6r7ss1s7t1t7t8vv1v7ww1w4xyn";

            return s;
    }
    
    /**
     * Retrieve the data at a given URL location
     * 
     * @param location
     * 			The URL location
     * 
     * @return
     * 			The text downloaded from the URL location
     */
    public static String grabPage(String location)
    {
        String output = "";

        int maxRetries = YahooFinanceDebug.getMaxWebsiteRetries();
        boolean success = false;
        int tryNumber = 0;

        while ( (!success) && (tryNumber < maxRetries) )
        {
            ++tryNumber;

            try
            {
                URL url = new URL(location);
                URLConnection con = url.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                while ((line = br.readLine()) != null)
                {
                    output += line + "\n";
                }
                success = true;
            }
            catch (Exception e)
            {
            	System.err.println("Grab Page Error: '" + location + "'");
            }
        }
        
        if (!success)
        {
        	output = "";
        }

        return output;
    }


}
