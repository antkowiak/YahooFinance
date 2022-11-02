/*
 * Copyright (c) 2014 Ryan Antkowiak .
 * All rights reserved.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
 * For a commercial use license, contact .
 */
package com.ryanantkowiak.YahooFinance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains static methods to query for the symbols in the Dow30
 * 
 * @author Ryan Antkowiak 
 */
public class Dow30
{
	private static List<String> DOW30_SYMBOLS = null;
	
	/**
	 * Get the list of symbols in the Dow30
	 * 
	 * @return
	 * 		The list of symbols in the Dow30
	 */
	public static List<String> getSymbols()
	{
		if (DOW30_SYMBOLS == null)
		{
			DOW30_SYMBOLS = new ArrayList<String>();
			
			String data = YahooFinance.grabPage("http://finance.yahoo.com/q/cp?s=%5EDJI");
			
			Pattern p = Pattern.compile("\\<b\\>\\<a href\\=\\\"/q\\?s\\=([A-Z]+)");
			Matcher m = p.matcher(data);
			
			while (m.find())
			{
				String symbol = m.group(1);
				DOW30_SYMBOLS.add(symbol);
			}
			
			Collections.sort(DOW30_SYMBOLS);
		}
		
		return DOW30_SYMBOLS;
	}
	
	/**
	 * Print the list of symbols in the Dow30
	 */
    public static void printSymbols()
    {
    	List<String> components = getSymbols();
    	
    	int count = 1;
    	
    	for (String component : components)
    	{
    		System.out.println("" + count + ": " + component);
    		++count;
    	}
    }

}
