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
import java.util.StringTokenizer;

/**
 * Class that manages a collection of YahooFinanceHistoricalPrice objects
 * 
 * @author Ryan Antkowiak 
 *
 */
public class YahooFinanceHistoricalPrices
{
	/**
	 * The stock/ETF symbol for which the historical prices pertain
	 */
	private String m_symbol;
	
	/**
	 * The collection of historical prices
	 */
	private ArrayList<YahooFinanceHistoricalPrice> m_prices;
	
	/**
	 * Return the symbol
	 * 
	 * @return The symbol
	 */
	public String getSymbol()
	{
		return m_symbol;
	}
	
	/**
	 * Return the collection of historical prices
	 * 
	 * @return The collection of historical prices
	 */
	public ArrayList<YahooFinanceHistoricalPrice> getPrices()
	{
		return m_prices;
	}
	
	/**
	 * Construct a collection of historical prices for a given symbol. This constructor
	 * will retrieve the data from YahooFinance.
	 * 
	 * @param symbol The symbol for which to retrieve historical price data
	 */
	public YahooFinanceHistoricalPrices(String symbol)
	{
		String location = YahooFinance.generateUrlForHistoricalPrices(symbol);
		String data = YahooFinance.grabPage(location);
		initialize(symbol, data);
	}
	
	/**
	 * Construct a collection of historical prices for a given symbol and given
	 * price data.
	 * 
	 * @param symbol The symbol for which to construct historical prices
	 * 
	 * @param data Text data to be parsed and placed into the data structure
	 */
	public YahooFinanceHistoricalPrices(String symbol, String data)
	{
		initialize(symbol, data);
	}
	
	/**
	 * Populate a collection of historical prices for a given symbol and given
	 * price data.
	 * 
	 * @param symbol The symbol for which to construct historical prices
	 * 
	 * @param data Text data to be parsed and placed into the data structure
	 */
	private void initialize(String symbol, String data)
	{
		m_symbol = symbol;
		m_prices = new ArrayList<YahooFinanceHistoricalPrice>();
		
		StringTokenizer tok = new StringTokenizer(data, "\n");

		// Skip the first token (the "headers")
		if (tok.hasMoreTokens())
			tok.nextToken();
		
		int count = 0;
		while (tok.hasMoreTokens() && count < YahooFinanceDebug.getMaxDataElements())
		{
			m_prices.add(new YahooFinanceHistoricalPrice(tok.nextToken()));
			++count;
		}
		
		Collections.sort(m_prices);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String s = "Symbol: '" + m_symbol + "'\n";
		
		for (int i = 0 ; i < m_prices.size() ; ++i)
		{
			s += m_prices.get(i);
			s+= "\n";
		}
		
		return s;
	}
	
}
