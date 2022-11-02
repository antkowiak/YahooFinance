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
 * Contains static methods to query for the symbols in the AMEX
 * 
 * @author Ryan Antkowiak 
 */
public class AMEX
{
	private static List<String> AMEX_SYMBOLS = null;
	
	/**
	 * Get the list of symbols in the AMEX
	 * 
	 * @return
	 * 		The list of symbols in the AMEX
	 */
	public static List<String> getSymbols()
	{
		if (AMEX_SYMBOLS == null)
		{
			AMEX_SYMBOLS = new ArrayList<String>();
			String data = YahooFinance.grabPage("http://www.nasdaq.com/screening/companies-by-name.aspx?letter=0&exchange=amex&render=download");

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
					AMEX_SYMBOLS.add(tok.nextToken());
				}
			}
			
			Collections.sort(AMEX_SYMBOLS);
		}
		
		return AMEX_SYMBOLS;
	}
	
	/**
	 * Print the list of symbols in the AMEX
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
