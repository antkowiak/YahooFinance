/*
 * Copyright (c) 2014 Ryan Antkowiak (antkowiak@gmail.com).
 * All rights reserved.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
 * For a commercial use license, contact antkowiak@gmail.com.
 */
package com.ryanantkowiak.YahooFinance;

import java.util.StringTokenizer;

/**
 * This class represents the data for a YahooFinance dividend. It is a data class that
 * simply stores the date and the dividend amount.
 * 
 * @author Ryan Antkowiak (antkowiak@gmail.com)
 *
 */
public class YahooFinanceDividend implements Comparable<YahooFinanceDividend>
{
	/**
	 * The ex-dividend date
	 */
	private YahooFinanceDate m_date;
	
	/**
	 * The dividend amount
	 */
	private double m_dividend;
	
	/**
	 * Return the ex-dividend date
	 * 
	 * @return The ex-dividend date
	 */
	public YahooFinanceDate getDate()
	{
		return m_date;
	}
	
	/**
	 * Return the dividend amount
	 * 
	 * @return The dividend amount
	 */
	public double getDividend()
	{
		return m_dividend;
	}
	
	/**
	 * Construct a YahooFinanceDividend from a given string, in the expected format:
	 * "YYYY-MM-DD,DIVIDENDAMOUNT"
	 * 
	 * @param str The string from which to construct a YahooFinanceDividend object
	 */
	public YahooFinanceDividend(String str)
	{
		// Expecting the string format "YYYY-MM-DD,DIVIDENDAMOUNT"
		
		String s = str.trim();
		
		StringTokenizer tok = new StringTokenizer(s, ",");
		try
		{
			m_date = new YahooFinanceDate(tok.nextToken());
			m_dividend = Double.parseDouble(tok.nextToken());
		}
		catch (Exception e)
		{
			System.err.println("YahooFinanceDividend Parse error: '" + str + "'");
			m_date = new YahooFinanceDate();
			m_dividend = 0;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(YahooFinanceDividend rhs)
	{
		return m_date.compareTo(rhs.m_date);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String s = m_date.toString() + "," + m_dividend;
		return s;
	}

}
