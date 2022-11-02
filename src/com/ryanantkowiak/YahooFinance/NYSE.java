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
 * Contains static methods to query for the symbols in the NYSE
 * 
 * @author Ryan Antkowiak 
 */
public class NYSE
{
	private static List<String> NYSE_SYMBOLS = null;
	
	/**
	 * Get the list of symbols in the NYSE
	 * 
	 * @return
	 * 		The list of symbols in the NYSE
	 */
	public static List<String> getSymbols()
	{
		if (NYSE_SYMBOLS == null)
		{
			NYSE_SYMBOLS = new ArrayList<String>();
			String data = YahooFinance.grabPage("http://www.nasdaq.com/screening/companies-by-name.aspx?letter=0&exchange=nyse&render=download");

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
					NYSE_SYMBOLS.add(tok.nextToken());
				}
			}
			
			Collections.sort(NYSE_SYMBOLS);
		}
		
		return NYSE_SYMBOLS;
	}
	
	/**
	 * Print the list of symbols in the NYSE
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
