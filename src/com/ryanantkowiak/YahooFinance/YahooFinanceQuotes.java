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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * This class stores a collection of YahooFinanceQuote objects
 * 
 * @author Ryan Antkowiak 
 *
 */
public class YahooFinanceQuotes
{
	/**
	 * The raw data retrieved from YahooFinance
	 */
	private String m_rawData;
	
	/**
	 * The collection of quote data (mapping from symbol to the quote data)
	 */
	private Map<String, YahooFinanceQuote> m_quotes;
	
	/**
	 * Constructs and populates the YahooFinanceQuotes object with quote data from
	 * the list of provided symbols
	 * 
	 * @param symbols The list of symbols to retrieve quote data for
	 */
	public YahooFinanceQuotes(List<String> symbols)
	{
		m_quotes = new HashMap<String, YahooFinanceQuote>();

		int maxPerRequest = YahooFinanceDebug.getMaxQuotesPerRequest();
		
		List<String> remainingSymbols = new ArrayList<String>(symbols);

		while (remainingSymbols.isEmpty() == false)
		{
			List<String> symbolsForRequest = new ArrayList<String>();
			
			for (int i = 0 ; (i < maxPerRequest) && (remainingSymbols.isEmpty() == false) ; ++i)
			{
				String symbolToAdd = remainingSymbols.get(0);
				symbolToAdd = symbolToAdd.replaceAll(" ", "");
				symbolToAdd = symbolToAdd.replaceAll("\\^", "");
				
				symbolsForRequest.add(symbolToAdd);
				remainingSymbols.remove(0);
			}
			
			if (symbolsForRequest.isEmpty() == false)
			{
				addSymbolsToMap(symbolsForRequest);
			}
		}
		
	}
	
	/**
	 * Add a list of symbols to the quote data
	 * 
	 * @param symbols The symbols to add to the quote data
	 */
	private void addSymbolsToMap(List<String> symbols)
	{
		String location = YahooFinance.generateUrlForQuotes(symbols);
		
		m_rawData = YahooFinance.grabPage(location);
		
		StringTokenizer tok = new StringTokenizer(m_rawData, "\n");
		
		while (tok.hasMoreTokens())
		{
			String quoteString = tok.nextToken();
			YahooFinanceQuote quote = new YahooFinanceQuote(quoteString);
			if (quote.isValid())
			{
				m_quotes.put(quote.getSymbol(), quote);
			}
		}
	}
	
	/**
	 * Return the quote data for a provided symbol
	 * 
	 * @param symbol the symbol for which quote data is returned
	 * @return the quote data
	 */
	public YahooFinanceQuote get(String symbol)
	{
		return m_quotes.get(symbol);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String s = "----------------------------------------------------------\n";
		
		Set<String> keys = m_quotes.keySet();
		
		ArrayList<String> sortedKeys = new ArrayList<String>();
		
		for (String k : keys)
		{
			sortedKeys.add(k);
		}
		
		Collections.sort(sortedKeys);
		
		for (String k : sortedKeys)
		{
			s += m_quotes.get(k).toString();
			s += "----------------------------------------------------------\n";
		}
		
		return s;
	}

}
