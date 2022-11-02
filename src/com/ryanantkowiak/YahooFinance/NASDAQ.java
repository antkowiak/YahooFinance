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
import java.util.StringTokenizer;

/**
 * Contains static methods to query for the symbols in the NASDAQ
 * 
 * @author Ryan Antkowiak 
 */
public class NASDAQ
{
	private static List<String> NASDAQ_SYMBOLS = null;
	
	/**
	 * Get the list of symbols in the NASDAQ
	 * 
	 * @return
	 * 		The list of symbols in the NASDAQ
	 */
	public static List<String> getSymbols()
	{
		if (NASDAQ_SYMBOLS == null)
		{
			NASDAQ_SYMBOLS = new ArrayList<String>();
			String data = YahooFinance.grabPage("http://www.nasdaq.com/screening/companies-by-industry.aspx?exchange=NASDAQ&render=download");

			StringTokenizer companies = new StringTokenizer(data, "\n");
			
			// Discard the header
			if (companies.hasMoreTokens())
				companies.nextToken();
			
			while (companies.hasMoreTokens())
			{
				String c = companies.nextToken().replaceAll("\"", "");
				StringTokenizer tok = new StringTokenizer(c, ",");
				
				if (tok.hasMoreTokens())
				{
					NASDAQ_SYMBOLS.add(tok.nextToken());
				}
			}
			
			Collections.sort(NASDAQ_SYMBOLS);
		}
		
		return NASDAQ_SYMBOLS;
	}
	
	/**
	 * Print the list of symbols in the NASDAQ
	 */
	public static void printSymbols()
	{
		List<String> companies = getSymbols();
	
		int count = 1;
		
		for (String c : companies)
		{
			System.out.println("" + count + ": " + c);
			++count;
		}
	}
}
