/*
 * Copyright (c) 2014 Ryan Antkowiak .
 * All rights reserved.
 * It is provided AS-IS, WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, and modify it for any non-commercial purpose.
 * You may distribute it non-commercially as long as you retain this notice.
 * For a commercial use license, contact .
 */
package com.ryanantkowiak.YahooFinance;

/**
 * Functions to set debugging info and limits to how YahooFinance data is requested
 * 
 * @author Ryan Antkowiak 
 *
 */
public class YahooFinanceDebug
{
	/**
	 * The maximum number of times to retry at retrieving data from YahooFinance
	 */
	private static int MAX_WEBSITE_RETRIES = 10;
	
	/**
	 * The maximum number of data elements to process from a request to YahooFinance
	 */
	private static int MAX_DATA_ELEMENTS = Integer.MAX_VALUE;
	
	/**
	 * The maximum number of quotes allowed per request
	 */
	private static int MAX_QUOTES_PER_REQUEST = 50;
	
	
	/**
	 * Set the maximum number of times to retry at retrieving data from YahooFinance
	 * 
	 * @param maxWebsiteRetries The maximum number of retries
	 */
	public static void setMaxWebsiteRetries(int maxWebsiteRetries)
	{
		MAX_WEBSITE_RETRIES = maxWebsiteRetries;
	}
	
	/**
	 * Get the maximum number of times to retry at retrieving data from YahooFinance
	 * 
	 * @return The maximum number of retries
	 */
	public static int getMaxWebsiteRetries()
	{
		return MAX_WEBSITE_RETRIES;
	}
	
	/**
	 * Set the maximum number of data elements to process from a request to YahooFinance
	 * 
	 * @param maxDataElements The maximum number of data elements to process from a request to YahooFinance
	 */
	public static void setMaxDataElements(int maxDataElements)
	{
		MAX_DATA_ELEMENTS = maxDataElements;
	}
	
	/**
	 * Get the maximum number of data elements to process from a request to YahooFinance
	 * 
	 * @return The maximum number of data elements to process from a request to YahooFinance
	 */
	public static int getMaxDataElements()
	{
		return MAX_DATA_ELEMENTS;
	}

	/**
	 * Set the maximum number of quotes allowed per request
	 * 
	 * @param maxQuotesPerRequest The maximum number of quotes allowed per request
	 */
	public static void setMaxQuotesPerRequest(int maxQuotesPerRequest)
	{
		MAX_QUOTES_PER_REQUEST = maxQuotesPerRequest;
	}
	
	/**
	 * Get the maximum number of quotes allowed per request
	 * 
	 * @return The maximum number of quotes allowed per request
	 */
	public static int getMaxQuotesPerRequest()
	{
		return MAX_QUOTES_PER_REQUEST;
	}
	
}
