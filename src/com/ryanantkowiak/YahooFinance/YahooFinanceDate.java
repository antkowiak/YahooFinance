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
 * Class to represent a date used by YahooFinance (Tracking year, month, day).
 * The first month of the year (January) is represented by a 1, and the first
 * day of the month is represented by a 1.
 * 
 * @author Ryan Antkowiak (antkowiak@gmail.com)
 *
 */
public class YahooFinanceDate implements Comparable<YahooFinanceDate>
{
	/**
	 * The Year
	 */
	private int m_year;
	
	/**
	 * The Month
	 */
	private int m_month;
	
	/**
	 * The day
	 */
	private int m_day;
	
	/**
	 * Default constructor. Initializes date to 1/1/1900
	 */
	public YahooFinanceDate()
	{
		m_year = 1900;
		m_month = 1;
		m_day = 1;
	}
	
	/**
	 * Construct a YahooFinance date from a given string
	 * 
	 * @param str a String of a YahooFinance date, expected in the
	 * 			format YYYY-MM-D
	 */
	public YahooFinanceDate(String str)
	{	
		// Expecting the string format "YYYY-MM-DD"
		
		String s = str.trim();
		
		StringTokenizer tok = new StringTokenizer(s, "-");
		try
		{
			m_year = Integer.parseInt(tok.nextToken());
			m_month = Integer.parseInt(tok.nextToken());
			m_day = Integer.parseInt(tok.nextToken());
		}
		catch (Exception e)
		{
			System.err.println("Yahoo Date Parse error: '" + str + "'");
			m_year = 1900;
			m_month = 1;
			m_day = 1;
		}
	}
	
	/**
	 * Construct a YahooFinance date from a given year, month, day
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public YahooFinanceDate(int year, int month, int day)
	{
		m_year = year;
		m_month = month;
		m_day = day;
	}
	
	/**
	 * Construct a YahooFinance date from an existing YahooFinanceDate (clone)
	 * 
	 * @param date The YahooFinance date to make a copy of
	 */
	public YahooFinanceDate(YahooFinanceDate date)
	{
		m_year = date.m_year;
		m_month = date.m_month;
		m_day = date.m_day;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(YahooFinanceDate rhs)
	{
		// check for this object equaling rhs, and return zero
		if ( (m_year==rhs.m_year) && (m_month==rhs.m_month) && (m_day==rhs.m_day) )
			return 0;
		
		// check for this object being less than (earlier than) rhs, and return 1
		if (m_year < rhs.m_year)
			return 1;
		
		if (m_year==rhs.m_year && m_month < rhs.m_month)
			return 1;
		
		if (m_year==rhs.m_year && m_month==rhs.m_month && m_day < rhs.m_day)
			return 1;
		
		// this object is later than rhs
		return -1;
	}
	
	/**
	 * Return a string representation
	 * 
	 * @return
	 * 			String representation of the YahooFinanceDate
	 */
	@Override
	public String toString()
	{
		String s = m_year + "-" + m_month + "-" + m_day;
		return s;
	}

}
