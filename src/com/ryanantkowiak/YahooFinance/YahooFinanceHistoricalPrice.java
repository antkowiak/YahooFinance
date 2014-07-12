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
 * Class that stores a historical price on a certain date by a symbol, from YahooFinance
 * 
 * @author Ryan Antkowiak (antkowiak@gmail.com)
 *
 */
public class YahooFinanceHistoricalPrice implements Comparable<YahooFinanceHistoricalPrice>
{
	/**
	 * The date of the historical price
	 */
	private YahooFinanceDate m_date;

	/**
	 * The opening price
	 */
	private double m_open;
	
	/**
	 * The daily high price
	 */
	private double m_high;
	
	/**
	 * The daily low price
	 */
	private double m_low;
	
	/**
	 * The closing price
	 */
	private double m_close;
	
	/**
	 * The volume
	 */
	private int m_volume;
	
	/**
	 * The closing price, adjusted for dividends, splits, and spinoffs
	 */
	private double m_adjustedClose;
	
	/**
	 * Return the date
	 * 
	 * @return The date
	 */
	public YahooFinanceDate getDate()
	{
		return m_date;
	}
	
	/**
	 * Return the opening price
	 * 
	 * @return The opening price
	 */
	public double getOpen()
	{
		return m_open;
	}
	
	/**
	 * Return the daily high price
	 * 
	 * @return The daily high price
	 */
	public double getHigh()
	{
		return m_high;
	}
	
	/**
	 * Return the daily low price
	 * 
	 * @return The daily low price
	 */
	public double getLow()
	{
		return m_low;
	}
	
	/**
	 * Return the closing price
	 * 
	 * @return The closing price
	 */
	public double getClose()
	{
		return m_close;
	}
	
	/**
	 * Return the volume
	 * 
	 * @return The volume
	 */
	public int getVolume()
	{
		return m_volume;
	}
	
	/**
	 * Return the closing price, adjusted for dividends, splits, and spin-offs
	 * 
	 * @return The closing price, adjusted for dividends, splits, and spin-offs
	 */
	public double getAdjustedClose()
	{
		return m_adjustedClose;
	}
	
	/**
	 * Construct a YahooFinanceHistoricalPrice object from a string in the expected
	 * format: "Date,Open,High,Low,Close,Volume,AdjClose"
	 * 
	 * @param str The date from which to construct the object
	 */
	public YahooFinanceHistoricalPrice(String str)
	{
		// Expecting the string format "Date,Open,High,Low,Close,Volume,Adj Close"
		
		String s = str.trim();
		
		StringTokenizer tok = new StringTokenizer(s, ",");
		try
		{
			m_date = new YahooFinanceDate(tok.nextToken());
			m_open = Double.parseDouble(tok.nextToken());
			m_high = Double.parseDouble(tok.nextToken());
			m_low = Double.parseDouble(tok.nextToken());
			m_close = Double.parseDouble(tok.nextToken());
			m_volume = Integer.parseInt(tok.nextToken());
			m_adjustedClose = Double.parseDouble(tok.nextToken());
		}
		catch (Exception e)
		{
			System.err.println("YahooFinanceHistoricalPrice Parse error: '" + str + "'");
			m_date = new YahooFinanceDate();
			m_open = 0;
			m_high = 0;
			m_low = 0;
			m_close = 0;
			m_volume = 0;
			m_adjustedClose = 0;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(YahooFinanceHistoricalPrice rhs)
	{
		return m_date.compareTo(rhs.m_date);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String s = m_date.toString() + ","
				+ m_open + ","
				+ m_high + ","
				+ m_low + ","
				+ m_close + ","
				+ m_volume + ","
				+ m_adjustedClose;

		return s;
	}

}
