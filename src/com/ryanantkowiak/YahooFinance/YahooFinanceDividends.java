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
import java.util.StringTokenizer;

/**
 * Class that stores and manages a collection of YahooFinanceDividend objects
 * pertaining to a particular trading symbol
 * 
 * @author Ryan Antkowiak (antkowiak@gmail.com)
 *
 */
public class YahooFinanceDividends
{
	/**
	 * The stock or ETF symbol that pays dividends
	 */
	private String m_symbol;
	
	/**
	 * The collection of dividends (ex-date and amount)
	 */
	private ArrayList<YahooFinanceDividend> m_dividends;
	
	/**
	 * Returns the symbol that pays dividends
	 * 
	 * @return The symbol that pays dividends
	 */
	public String getSymbol()
	{
		return m_symbol;
	}
	
	/**
	 * Return the collection of dividends (ex-dates and amounts)
	 * @return
	 */
	public ArrayList<YahooFinanceDividend> getDividends()
	{
		return m_dividends;
	}
	
	/**
	 * Constructs the collection of dividends for the given symbol. This constructor
	 * will actually request all the data from YahooFinance and populate the class fields.
	 *  
	 * @param symbol The symbol that pays dividends
	 */
	public YahooFinanceDividends(String symbol)
	{
		String location = YahooFinance.generateUrlForDividends(symbol);
		String data = YahooFinance.grabPage(location);
		initialize(symbol, data);
	}
	
	/**
	 * Constructs the collection of dividends for the given symbol, using data
	 * that has already been retrieved from YahooFinance.
	 * 
	 * @param symbol The symbol that pays dividends
	 * 
	 * @param data The textual data that has been provided by YahooFinance
	 */
	public YahooFinanceDividends(String symbol, String data)
	{
		initialize(symbol, data);
	}
	
	/**
	 * Populates this class with provided data from YahooFinance
	 * 
	 * @param symbol The symbol that pays dividends
	 * 
	 * @param data The textual data that has been provided by YahooFinance
	 */
	private void initialize(String symbol, String data)
	{
		m_symbol = symbol;
		m_dividends = new ArrayList<YahooFinanceDividend>();
		
		StringTokenizer tok = new StringTokenizer(data, "\n");

		// Skip the first token (the "headers")
		if (tok.hasMoreTokens())
			tok.nextToken();
		
		int count = 0;
		while (tok.hasMoreTokens() && count < YahooFinanceDebug.getMaxDataElements())
		{
			m_dividends.add(new YahooFinanceDividend(tok.nextToken()));
			++count;
		}
		
		Collections.sort(m_dividends);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String s = "Symbol: '" + m_symbol + "'\n";
		
		for (int i = 0 ; i < m_dividends.size() ; ++i)
		{
			s += m_dividends.get(i);
			s+= "\n";
		}
		
		return s;
	}
	
}
