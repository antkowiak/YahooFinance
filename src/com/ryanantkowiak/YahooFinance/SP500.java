/*
 * Copyright (c) 2014 Ryan Antkowiak (antkowiak@gmail.com).
 * All rights reserved.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
 * For a commercial use license, contact antkowiak@gmail.com.
 */
package com.ryanantkowiak.YahooFinance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Contains static methods to query for the symbols in the SP500
 * 
 * @author Ryan Antkowiak (antkowiak@gmail.com)
 */
public class SP500
{
	private static List<String> SP500_SYMBOLS = null;

	/**
	 * Get the list of symbols in the SP500
	 * 
	 * @return
	 * 		The list of symbols in the SP500
	 */    
    public static List<String> getSymbols()
    {
    	if (SP500_SYMBOLS == null)
    	{
	    	SP500_SYMBOLS = new ArrayList<String>();
	    
	    	String location = "https://raw.github.com/datasets/s-and-p-500-companies/master/data/constituents.csv";
	    	
	    	String data = YahooFinance.grabPage(location);
	    	
	    	StringTokenizer lines = new StringTokenizer(data, "\n");
	    	
	    	// remove header
	    	if (lines.hasMoreTokens())
	    		lines.nextToken();
	    	
	    	while (lines.hasMoreTokens())
	    	{
	    		StringTokenizer company = new StringTokenizer(lines.nextToken(), ",");
	    		
	    		if (company.hasMoreTokens())
	    			SP500_SYMBOLS.add(company.nextToken());
	    	}
	    	
	    	Collections.sort(SP500_SYMBOLS);
    	}
    	
    	return SP500_SYMBOLS;
    }
    
	/**
	 * Print the list of symbols in the SP500
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
