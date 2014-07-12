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
 * Class to store the quote data for a symbol from YahooFinance
 * 
 * @author Ryan Antkowiak (antkowiak@gmail.com)
 *
 */
public class YahooFinanceQuote implements Comparable<YahooFinanceQuote>
{
 
	/**
	 * Construct the YahooFinanceQuote object from a given string of quote data (that
	 * has already been retrieved from YahooFinance.)
	 * 
	 * @param str The string to parse the quote data from
	 */
    public YahooFinanceQuote(String str)
    {    
        String s = str.trim();
        s = s.replaceAll("\"", "");
        s = s.replaceAll("&nbsp;", "");
        s = s.replaceAll("<b>", "");
        s = s.replaceAll("</b>", "");
        s = s.replaceAll("\n", "");
        s = s.replaceAll("\\+", "");
        s = s.replaceAll("N/A", "0");
        
        m_rawData = s;
        
        StringTokenizer tok = new StringTokenizer(m_rawData, ",");
        try
        {
        	m_averageDailyVolume = Long.parseLong(tok.nextToken());
        	//System.out.println("m_averageDailyVolume: " + m_averageDailyVolume);

        	m_realTimeAsk = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_realTimeAsk: " + m_realTimeAsk);

        	m_realTimeBid = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_realTimeBid: " + m_realTimeBid);

        	m_changeAndPercentChange = tok.nextToken();
        	//System.out.println("m_changeAndPercentChange: " + m_changeAndPercentChange);

        	m_change = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_change: " + m_change);

        	m_realTimeChange = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_realTimeChange: " + m_realTimeChange);

        	m_realTimeAfterHoursChange = tok.nextToken();
        	//System.out.println("m_realTimeAfterHoursChange: " + m_realTimeAfterHoursChange);           

        	m_dividendPerShare = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_dividendPerShare: " + m_dividendPerShare);           

        	m_lastTradeDate = tok.nextToken(); // TODO - date
        	//System.out.println("m_lastTradeDate: " + m_lastTradeDate);           

        	m_tradeDate = tok.nextToken(); // TODO - date
        	//System.out.println("m_tradeDate: " + m_tradeDate);

        	m_earningsPerShare = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_earningsPerShare: " + m_earningsPerShare);

        	m_errorIndication = tok.nextToken();
        	//System.out.println("m_errorIndication: " + m_errorIndication);

        	m_currentYearEstimateEPS = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_currentYearEstimateEPS: " + m_currentYearEstimateEPS);

        	m_nextYearEstimateEPS = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_nextYearEstimateEPS: " + m_nextYearEstimateEPS);

        	m_nextQuarterEstimateEPS = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_nextQuarterEstimateEPS: " + m_nextQuarterEstimateEPS);

        	m_dailyLow = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_dailyLow: " + m_dailyLow);

        	m_dailyHigh = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_dailyHigh: " + m_dailyHigh);

        	m_fiftyTwoWeekLow = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_fiftyTwoWeekLow: " + m_fiftyTwoWeekLow);

        	m_fiftyTwoWeekHigh = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_fiftyTwoWeekHigh: " + m_fiftyTwoWeekHigh);

        	m_holdingsGainPercent = tok.nextToken();
        	//System.out.println("m_holdingsGainPercent: " + m_holdingsGainPercent);

        	m_annualizedGain = tok.nextToken();
        	//System.out.println("m_annualizedGain: " + m_annualizedGain);

        	m_holdingsGain = tok.nextToken();
        	//System.out.println("m_holdingsGain: " + m_holdingsGain);

        	m_realTimeHoldingsGainPercent = tok.nextToken();
        	//System.out.println("m_realTimeHoldingsGainPercent: " + m_realTimeHoldingsGainPercent);

        	m_realTimeHoldingsGain = tok.nextToken();
        	//System.out.println("m_realTimeHoldingsGain: " + m_realTimeHoldingsGain);

        	m_moreInfo = tok.nextToken();
        	//System.out.println("m_moreInfo: " + m_moreInfo);

        	m_realTimeOrderBook = tok.nextToken();
        	//System.out.println("m_realTimeOrderBook: " + m_realTimeOrderBook);

        	m_marketCapitalization = tok.nextToken();
        	//System.out.println("m_marketCapitalization: " + m_marketCapitalization);

        	m_realTimeMarketCapitalization = tok.nextToken();
        	//System.out.println("m_realTimeMarketCapitalization: " + m_realTimeMarketCapitalization);

        	m_EBITDA = tok.nextToken();
        	//System.out.println("m_EBITDA: " + m_EBITDA);

        	m_changeFrom52WeekLow = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_changeFrom52WeekLow: " + m_changeFrom52WeekLow);

        	m_percentChangeFrom52WeekLow = tok.nextToken();
        	//System.out.println("m_percentChangeFrom52WeekLow: " + m_percentChangeFrom52WeekLow);

        	m_realTimeLastTradeWithTime = tok.nextToken();
        	//System.out.println("m_realTimeLastTradeWithTime: " + m_realTimeLastTradeWithTime);

        	m_realTimeChangePercent = tok.nextToken();
        	//System.out.println("m_realTimeChangePercent: " + m_realTimeChangePercent);

        	m_changeFrom52WeekHigh = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_changeFrom52WeekHigh: " + m_changeFrom52WeekHigh);

        	m_percentChangeFrom52WeekHigh = tok.nextToken();
        	//System.out.println("m_percentChangeFrom52WeekHigh: " + m_percentChangeFrom52WeekHigh);

        	m_lastTradeWithTime = tok.nextToken();
        	//System.out.println("m_lastTradeWithTime: " + m_lastTradeWithTime);

        	m_lastTradePriceOnly = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_lastTradePriceOnly: " + m_lastTradePriceOnly);

        	m_highLimit = tok.nextToken();
        	//System.out.println("m_highLimit: " + m_highLimit);

        	m_lowLimit = tok.nextToken();
        	//System.out.println("m_lowLimit: " + m_lowLimit);

        	m_daysRange = tok.nextToken();
        	//System.out.println("m_daysRange: " + m_daysRange);

        	m_realTimeDaysRange = tok.nextToken();
        	//System.out.println("m_realTimeDaysRange: " + m_realTimeDaysRange);

        	m_50DayMovingAverage = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_50DayMovingAverage: " + m_50DayMovingAverage);

        	m_200DayMovingAverage = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_200DayMovingAverage: " + m_200DayMovingAverage);

        	m_changeFrom200DayMovingAverage = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_changeFrom200DayMovingAverage: " + m_changeFrom200DayMovingAverage);

        	m_percentChangeFrom200DayMovingAverage = tok.nextToken();
        	//System.out.println("m_percentChangeFrom200DayMovingAverage: " + m_percentChangeFrom200DayMovingAverage);

        	m_changeFrom50DayMovingAverage = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_changeFrom50DayMovingAverage: " + m_changeFrom50DayMovingAverage);

        	m_percentChangeFrom50DayMovingAverage = tok.nextToken();
        	//System.out.println("m_percentChangeFrom50DayMovingAverage: " + m_percentChangeFrom50DayMovingAverage);

        	m_notes = tok.nextToken();
        	//System.out.println("m_notes: " + m_notes);

        	m_open = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_open: " + m_open);

        	m_previousClose = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_previousClose: " + m_previousClose);

        	m_pricePaid = tok.nextToken();
        	//System.out.println("m_pricePaid: " + m_pricePaid);

        	m_changeInPercent = tok.nextToken();
        	//System.out.println("m_changeInPercent: " + m_changeInPercent);

        	m_priceToSalesRatio = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_priceToSalesRatio: " + m_priceToSalesRatio);

        	m_priceToBookRatio = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_priceToBookRatio: " + m_priceToBookRatio);

        	m_exDividendDate = tok.nextToken(); // TODO - date
        	//System.out.println("m_exDividendDate: " + m_exDividendDate);

        	m_priceToEarningsRatio = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_priceToEarningsRatio: " + m_priceToEarningsRatio);

        	m_dividendPayDate = tok.nextToken(); // TODO - date
        	//System.out.println("m_dividendPayDate: " + m_dividendPayDate);

        	m_realTimePriceToEarningsRatio = tok.nextToken();
        	//System.out.println("m_realTimePriceToEarningsRatio: " + m_realTimePriceToEarningsRatio);

        	m_pegRatio = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_pegRatio: " + m_pegRatio);

        	m_currentYearEstimatePriceToEPS = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_currentYearEstimatePriceToEPS: " + m_currentYearEstimatePriceToEPS);

        	m_nextYearEstimatePriceToEPS = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_nextYearEstimatePriceToEPS: " + m_nextYearEstimatePriceToEPS);

        	m_symbol = tok.nextToken();
        	//System.out.println("m_symbol: " + m_symbol);

        	m_sharesOwned = tok.nextToken();
        	//System.out.println("m_sharesOwned: " + m_sharesOwned);

        	m_shortRatio = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_shortRatio: " + m_shortRatio);

        	m_lastTradeTime = tok.nextToken();
        	//System.out.println("m_lastTradeTime: " + m_lastTradeTime);

        	m_tickerTrend = tok.nextToken();
        	//System.out.println("m_tickerTrend: " + m_tickerTrend);

        	m_oneYearTargetPrice = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_oneYearTargetPrice: " + m_oneYearTargetPrice);

        	m_volume = Long.parseLong(tok.nextToken());
        	//System.out.println("m_volume: " + m_volume);

        	m_holdingsValue = tok.nextToken();
        	//System.out.println("m_holdingsValue: " + m_holdingsValue);

        	m_realTimeHoldingsValue = tok.nextToken();
        	//System.out.println("m_realTimeHoldingsValue: " + m_realTimeHoldingsValue);

        	m_fiftyTwoWeekRange = tok.nextToken();
        	//System.out.println("m_fiftyTwoWeekRange: " + m_fiftyTwoWeekRange);

        	m_daysValueChange = tok.nextToken();
        	//System.out.println("m_daysValueChange: " + m_daysValueChange);

        	m_realTimeDaysValueChange = tok.nextToken();
        	//System.out.println("m_realTimeDaysValueChange: " + m_realTimeDaysValueChange);

        	m_stockExchange = tok.nextToken();
        	//System.out.println("m_stockExchange: " + m_stockExchange);            

        	m_dividendYield = Double.parseDouble(tok.nextToken());
        	//System.out.println("m_dividendYield: " + m_dividendYield);            

        	m_name = tok.nextToken();
        	//System.out.println("m_name: " + m_name);            
        }
        catch (Exception e)
        {
        	m_symbol = "";
            System.err.println("YahooFinanceQuote Parse error: '" + m_rawData + "'");
        }
    }
    
    
    /**
     * The raw data from YahooFinance
     */
    private String m_rawData;

    /**
     * The average daily volume
     */    
    private long m_averageDailyVolume;
    
    /**
     * 
     */
    private double m_realTimeAsk;
    
    /**
     * The real time ask price
     */
    private double m_realTimeBid;
    
    /**
     * The real time bid price
     */
    private String m_changeAndPercentChange;
    
    /**
     * The stock price change and percent change
     */
    private double m_change;
    
    /**
     * The stock price change
     */
    private double m_realTimeChange;
    
    /**
     * The real time stock price change after hours
     */
    private String m_realTimeAfterHoursChange;
    
    /**
     * The annual dividends per share
     */
    private double m_dividendPerShare;
    
    /**
     * The date of the last trade
     */
    private String m_lastTradeDate; // TODO - date
    
    /**
     * The trade date
     */
    private String m_tradeDate; // TODO - date
    
    /**
     * The earnings per share
     */
    private double m_earningsPerShare;
    
    /**
     * The error indication
     */
    private String m_errorIndication;
    
    /**
     * The current year estimate for EPS
     */
    private double m_currentYearEstimateEPS;
    
    /**
     * The next year estimate for EPS
     */
    private double m_nextYearEstimateEPS;
    
    /**
     * The next quarter estimate for EPS
     */
    private double m_nextQuarterEstimateEPS;
    
    /**
     * The daily low price
     */
    private double m_dailyLow;
    
    /**
     * The daily high price
     */
    private double m_dailyHigh;
    
    /**
     * The 52-week low price
     */
    private double m_fiftyTwoWeekLow;
    
    /**
     * The 52-week high price
     */
    private double m_fiftyTwoWeekHigh;
    
    /**
     * The holdings gain percentage
     */
    private String m_holdingsGainPercent;
    
    /**
     * The annualized gain
     */
    private String m_annualizedGain;
    
    /**
     * The holdings gain
     */
    private String m_holdingsGain;
    
    /**
     * The real time holdings gain percentage
     */
    private String m_realTimeHoldingsGainPercent;
    
    /**
     * The real time holdings gain
     */
    private String m_realTimeHoldingsGain;
    
    /**
     * The more information field
     */
    private String m_moreInfo;
    
    /**
     * The real time order book
     */
    private String m_realTimeOrderBook;
    
    /**
     * The market capitalization
     */
    private String m_marketCapitalization;
    
    /**
     * The real time market capitalization
     */
    private String m_realTimeMarketCapitalization;
    
    /**
     * The EBITDA
     */
    private String m_EBITDA;
    
    /**
     * The change from the 52-week low
     */
    private double m_changeFrom52WeekLow;
    
    /**
     * The percent change from the 52-week low
     */
    private String m_percentChangeFrom52WeekLow;
    
    /**
     * The real time last trade with time
     */
    private String m_realTimeLastTradeWithTime;
    
    /**
     * The real time change percentage
     */
    private String m_realTimeChangePercent;
    
    /**
     * 
     */
    private double m_changeFrom52WeekHigh;
    
    /**
     * The change from the 52-week high
     */
    private String m_percentChangeFrom52WeekHigh;
    
    /**
     * The percentage change from the 52-week high
     */
    private String m_lastTradeWithTime;
    
    /**
     * The last trade, price only
     */
    private double m_lastTradePriceOnly;
    
    /**
     * The high limit
     */
    private String m_highLimit;
    
    /**
     * The low limit
     */
    private String m_lowLimit;
    
    /**
     * The days price range
     */
    private String m_daysRange;
    
    /**
     * THe real time days price range
     */
    private String m_realTimeDaysRange;
    
    /**
     * The 50 day moving average
     */
    private double m_50DayMovingAverage;
    
    /**
     * The 200 day moving average
     */
    private double m_200DayMovingAverage;
    
    /**
     * The change from the 200 day moving average
     */
    private double m_changeFrom200DayMovingAverage;
    
    /**
     * The percent change from the 200 day moving average
     */
    private String m_percentChangeFrom200DayMovingAverage;
    
    /**
     * The change from the 50 day moving average
     */
    private double m_changeFrom50DayMovingAverage;
    
    /**
     * The percent change from the 50 day moving average
     */
    private String m_percentChangeFrom50DayMovingAverage;
    
    /**
     * The notes
     */
    private String m_notes;
    
    /**
     * The opening price
     */
    private double m_open;
    
    /**
     * The previous closing prince
     */
    private double m_previousClose;
    
    /**
     * The price paid
     */
    private String m_pricePaid;
    
    /**
     * The change in percent
     */
    private String m_changeInPercent;
    
    /**
     * The price to sales ratio
     */
    private double m_priceToSalesRatio;
    
    /**
     * The price to book ratio
     */
    private double m_priceToBookRatio;
    
    /**
     * The ex-dividend date
     */
    private String m_exDividendDate; // TODO - date
    
    /**
     * The price to earnings ratio
     */
    private double m_priceToEarningsRatio;
    
    /**
     * The dividend pay date
     */
    private String m_dividendPayDate; // TODO - date
    
    /**
     * The real time price to earnings ratio
     */
    private String m_realTimePriceToEarningsRatio;
    
    /**
     * The PEG ratio
     */
    private double m_pegRatio;
    
    /**
     * The current year estimate price to EPS
     */
    private double m_currentYearEstimatePriceToEPS;
    
    /**
     * The next year estimate price to EPS
     */
    private double m_nextYearEstimatePriceToEPS;
    
    /**
     * The symbol
     */
    private String m_symbol;
    
    /**
     * The shares owned
     */
    private String m_sharesOwned;
    
    /**
     * The short ratio
     */
    private double m_shortRatio;
    
    /**
     * The last trade time
     */
    private String m_lastTradeTime;
    
    /**
     * The ticker trend
     */
    private String m_tickerTrend;
    
    /**
     * The one year target price
     */
    private double m_oneYearTargetPrice;
    
    /**
     * The volume
     */
    private long m_volume;
    
    /**
     * The holdings value
     */
    private String m_holdingsValue;
    
    /**
     * The real time holdings value
     */
    private String m_realTimeHoldingsValue;
    
    /**
     * The 52-week range
     */
    private String m_fiftyTwoWeekRange;
    
    /**
     * The days value change
     */
    private String m_daysValueChange;
    
    /**
     * The real time days value change
     */
    private String m_realTimeDaysValueChange;
    
    /**
     * The stock exchange
     */
    private String m_stockExchange;
    
    /**
     * The dividend yield
     */
    private double m_dividendYield;
    
    /**
     * The company name
     */
    private String m_name;
    
    
    /**
     * Return the raw data
     * @return the raw data
     */
    public String getRawData()                              { return m_rawData; }
    
    /**
     * Return the average daily volume
     * @return the average daily volume
     */
    public long   getAverageDailyVolume()                   { return m_averageDailyVolume; }
    
    /**
     * Return the real time ask price
     * @return the real time ask price
     */
    public double getRealTimeAsk()                          { return m_realTimeAsk; }
    
    /**
     * Return the real time bid price
     * @return the real time bid price
     */
    public double getRealTimeBid()                          { return m_realTimeBid; }
    
    /**
     * Return the change and percentage change
     * @return the change and percentage change
     */
    public String getChangeAndPercentChange()               { return m_changeAndPercentChange; }
    
    /**
     * Return the change in price
     * @return the change in price
     */
    public double getChange()                               { return m_change; }
    
    /**
     * Return the real time change in price
     * @return the real time change in price
     */
    public double getRealTimeChange()                       { return m_realTimeChange; }
    
    /**
     * Return the real time after hours change in price
     * @return the real time after hours change in price
     */
    public String getRealTimeAfterHoursChange()             { return m_realTimeAfterHoursChange; }
    
    /**
     * Return the dividend per share
     * @return the dividend per share
     */
    public double getDividendPerShare()                     { return m_dividendPerShare; }
    
    /**
     * Return the last trade date
     * @return the last trade date
     */
    public String getLastTradeDate()                        { return m_lastTradeDate; }
    
    /**
     * Return the trade date
     * @return the trade date
     */
    public String getTradeDate()                            { return m_tradeDate; }
    
    /**
     * Return the earnings per share (EPS)
     * @return the earnings per share
     */
    public double getEarningsPerShare()                     { return m_earningsPerShare; }
    
    /**
     * Return the error indication
     * @return the error indication
     */
    public String getErrorIndication()                      { return m_errorIndication; }
    
    /**
     * Return the current year estimate EPS
     * @return the current year estimate EPS
     */
    public double getCurrentYearEstimateEPS()               { return m_currentYearEstimateEPS; }
    
    /**
     * Return the next year estimate EPS
     * @return the next year estimate EPS
     */
    public double getNextYearEstimateEPS()                  { return m_nextYearEstimateEPS; }
    
    /**
     * Return the next quarter estimate EPS
     * @return the next quarter estimate EPS
     */
    public double getNextQuarterEstimateEPS()               { return m_nextQuarterEstimateEPS; }
    
    /**
     * Return the daily low price
     * @return the daily low price
     */
    public double getDailyLow()                             { return m_dailyLow; }
    
    /**
     * Return the daily high price
     * @return the daily high price
     */
    public double getDailyHigh()                            { return m_dailyHigh; }
    
    /**
     * Return the 52-week low price
     * @return the 52-week low price
     */
    public double getFiftyTwoWeekLow()                      { return m_fiftyTwoWeekLow; }
    
    /**
     * Return the 52-week high price
     * @return the 52-week high price
     */
    public double getFiftyTwoWeekHigh()                     { return m_fiftyTwoWeekHigh; }
    
    /**
     * Return the holdings gain percentage
     * @return the holdings gain percentage
     */
    public String getHoldingsGainPercent()                  { return m_holdingsGainPercent; }
    
    /**
     * Return the annualized gain
     * @return the annualized gain
     */
    public String getAnnualizedGain()                       { return m_annualizedGain; }
    
    /**
     * Return the holdings gain
     * @return the holdings gain
     */
    public String getHoldingsGain()                         { return m_holdingsGain; }
    
    /**
     * Return the real time holdings gain percentage
     * @return the real time holdings gain percentage
     */
    public String getRealTimeHoldingsGainPercent()          { return m_realTimeHoldingsGainPercent; }
    
    /**
     * Return the real time holdings gain percentage
     * @return the real time holdings gain percentage
     */
    public String getRealTimeHoldingsGain()                 { return m_realTimeHoldingsGain; }
    
    /**
     * Return more info
     * @return more info
     */
    public String getMoreInfo()                             { return m_moreInfo; }
    
    /**
     * Return real time order book
     * @return the real time order book
     */
    public String getRealTimeOrderBook()                    { return m_realTimeOrderBook; }
    
    /**
     * Return market capitalization
     * @return the market capitalization
     */
    public String getMarketCapitalization()                 { return m_marketCapitalization; }
    
    /**
     * Return the real time market capitalization
     * @return the real time market capitalization
     */
    public String getRealTimeMarketCapitalization()         { return m_realTimeMarketCapitalization; }
    
    /**
     * Return the earnings before interest, taxes, depreciation, and amortization (EBITDA)
     * @return the EBITDA
     */
    public String getEBITDA()                               { return m_EBITDA; }
    
    /**
     * Return the change from the 52-week low
     * @return the change from the 52-week low
     */
    public double getChangeFrom52WeekLow()                  { return m_changeFrom52WeekLow; }
    
    /**
     * Return the percentage change from the 52-week low
     * @return the percentage change from the 52-week low
     */
    public String getPercentChangeFrom52WeekLow()           { return m_percentChangeFrom52WeekLow; }
    
    /**
     * Return the real time last trade with time
     * @return the real time last trade with time
     */
    public String getRealTimeLastTradeWithTime()            { return m_realTimeLastTradeWithTime; }
    
    /**
     * Return the real time change percentage
     * @return the real time change percentage
     */
    public String getRealTimeChangePercent()                { return m_realTimeChangePercent; }
    
    /**
     * Return the change from the 52-week high
     * @return the change from the 52-week high
     */
    public double getChangeFrom52WeekHigh()                 { return m_changeFrom52WeekHigh; }
    
    /**
     * Return the percentage change from the 52-week high
     * @return the percentage change from the 52-week high
     */
    public String getPercentChangeFrom52WeekHigh()          { return m_percentChangeFrom52WeekHigh; }
    
    /**
     * Return the last trade with time
     * @return the last trade with time
     */
    public String getLastTradeWithTime()                    { return m_lastTradeWithTime; }
    
    /**
     * Return the last trade price only
     * @return the last trade price only
     */
    public double getLastTradePriceOnly()                   { return m_lastTradePriceOnly; }
    
    /**
     * Return the high limit
     * @return the high limit
     */
    public String getHighLimit()                            { return m_highLimit; }
    
    /**
     * Return the low limit
     * @return the low limit
     */
    public String getLowLimit()                             { return m_lowLimit; }
    
    /**
     * Return the days range
     * @return the days range
     */
    public String getDaysRange()                            { return m_daysRange; }
    
    /**
     * Return the real time days range
     * @return the real time days range
     */
    public String getRealTimeDaysRange()                    { return m_realTimeDaysRange; }
    
    /**
     * Return the 50 day moving average
     * @return the 50 day moving average
     */
    public double get50DayMovingAverage()                   { return m_50DayMovingAverage; }
    
    /**
     * Return the 200 day moving average
     * @return the 200 day moving average
     */
    public double get200DayMovingAverage()                  { return m_200DayMovingAverage; }
    
    /**
     * Return the change from the 200 day moving average
     * @return the change from the 200 day moving average
     */
    public double getChangeFrom200DayMovingAverage()        { return m_changeFrom200DayMovingAverage; }
    
    /**
     * Return the percentage change from the 200 day moving average
     * @return the percentage change from the 200 day moving average
     */
    public String getPercentChangeFrom200DayMovingAverage() { return m_percentChangeFrom200DayMovingAverage; }
    
    /**
     * Return the change from the 50 day moving average
     * @return the change from the 50 day moving average
     */
    public double getChangeFrom50DayMovingAverage()         { return m_changeFrom50DayMovingAverage; }
    
    /**
     * Return the percentage change from the 50 day moving average
     * @return the percentage change from the 50 day moving average
     */
    public String getPercentChangeFrom50DayMovingAverage()  { return m_percentChangeFrom50DayMovingAverage; }
    
    /**
     * Return the notes
     * @return the notes
     */
    public String getNotes()                                { return m_notes; }
    
    /**
     * Return the opening price
     * @return the opening price
     */
    public double getOpen()                                 { return m_open; }
    
    /**
     * Return the previous closing price
     * @return the previous closing price
     */
    public double getPreviousClose()                        { return m_previousClose; }
    
    /**
     * Return the price paid
     * @return the price paid
     */
    public String getPricePaid()                            { return m_pricePaid; }
    
    /**
     * Return the change in percent
     * @return the change in percent
     */
    public String getChangeInPercent()                      { return m_changeInPercent; }
    
    /**
     * Return the price to sales ratio
     * @return the price to sales ratio
     */
    public double getPriceToSalesRatio()                    { return m_priceToSalesRatio; }
    
    /**
     * Return the price to book ratio
     * @return the price to book ratio
     */
    public double getPriceToBookRatio()                     { return m_priceToBookRatio; }
    
    /**
     * Return the ex-dividend date
     * @return the ex-dividend date
     */
    public String getExDividendDate()                       { return m_exDividendDate; }
    
    /**
     * Return the price to earnings ratio
     * @return the price to earnings ratio
     */
    public double getPriceToEarningsRatio()                 { return m_priceToEarningsRatio; }
    
    /**
     * Return the dividend pay date
     * @return the dividend pay date
     */
    public String getDividendPayDate()                      { return m_dividendPayDate; }
    
    /**
     * Return the real time price to earnings ratio
     * @return the real time price to earnings ratio
     */
    public String getRealTimePriceToEarningsRatio()         { return m_realTimePriceToEarningsRatio; }
    
    /**
     * Return the PEG ratio
     * @return the PEG ratio
     */
    public double getPegRatio()                             { return m_pegRatio; }
    
    /**
     * Return the current year estimate price to EPS
     * @return the current year estimate price to EPS
     */
    public double getCurrentYearEstimatePriceToEPS()        { return m_currentYearEstimatePriceToEPS; }
    
    /**
     * Return the next year estimate price to EPS
     * @return the next year estimate price to EPS
     */
    public double getNextYearEstimatePriceToEPS()           { return m_nextYearEstimatePriceToEPS; }
    
    /**
     * Return the symbol
     * @return the symbol
     */
    public String getSymbol()                               { return m_symbol; }
    
    /**
     * Return the shares owned
     * @return the shares owned
     */
    public String getSharesOwned()                          { return m_sharesOwned; }
    
    /**
     * Return the short ratio
     * @return the short ratio
     */
    public double getShortRatio()                           { return m_shortRatio; }
    
    /**
     * Return the last trade time
     * @return the last trade time
     */
    public String getLastTradeTime()                        { return m_lastTradeTime; }
    
    /**
     * Return the ticker trend
     * @return the ticker trend
     */
    public String getTickerTrend()                          { return m_tickerTrend; }
    
    /**
     * Return the one year target price
     * @return the one year target price
     */
    public double getOneYearTargetPrice()                   { return m_oneYearTargetPrice; }
    
    /**
     * Return the volume
     * @return the volume
     */
    public long   getVolume()                               { return m_volume; }
    
    /**
     * Return the holdings value
     * @return the holdings value
     */
    public String getHoldingsValue()                        { return m_holdingsValue; }
    
    /**
     * Return the real time holdings value
     * @return the real time holdings value
     */
    public String getRealTimeHoldingsValue()                { return m_realTimeHoldingsValue; }
    
    /**
     * Return the 52-week range
     * @return the 52-week range
     */
    public String getFiftyTwoWeekRange()                    { return m_fiftyTwoWeekRange; }
    
    /**
     * Return the days value change
     * @return the days value change
     */
    public String getDaysValueChange()                      { return m_daysValueChange; }
    
    /**
     * Return the real time days value change
     * @return the real time days value change
     */
    public String getRealTimeDaysValueChange()              { return m_realTimeDaysValueChange; }
    
    /**
     * Return the stock exchange
     * @return the stock exchange
     */
    public String getStockExchange()                        { return m_stockExchange; }
    
    /**
     * Return the dividend yield
     * @return the dividend yield
     */
    public double getDividendYield()                        { return m_dividendYield; }
    
    /**
     * Return the company name
     * @return the company name
     */
    public String getName()                                 { return m_name; }


    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        String s = "";
 
        s += "RAW DATA                                       : " + m_rawData + "\n";
        s += "Average Daily Volume                       [a2]: " + m_averageDailyVolume + "\n";
        s += "Ask (Real-time)                            [b2]: " + m_realTimeAsk + "\n";
        s += "Bid (Real-time)                            [b3]: " + m_realTimeBid + "\n";
        s += "Change & Percent Change                     [c]: " + m_changeAndPercentChange + "\n";
        s += "Change                                     [c1]: " + m_change + "\n";
        s += "Change (Real-time)                         [c6]: " + m_realTimeChange + "\n";
        s += "After Hours Change (Real-time)             [c8]: " + m_realTimeAfterHoursChange + "\n";
        s += "Dividend/Share                              [d]: " + m_dividendPerShare + "\n";
        s += "Last Trade Date                            [d1]: " + m_lastTradeDate + "\n";
        s += "Trade Date                                 [d2]: " + m_tradeDate + "\n";
        s += "Earnings/Share                              [e]: " + m_earningsPerShare + "\n";
        s += "Error Indication                           [e1]: " + m_errorIndication + "\n";
        s += "EPS Estimate Current Year                  [e7]: " + m_currentYearEstimateEPS + "\n";
        s += "EPS Estimate Next Year                     [e8]: " + m_nextYearEstimateEPS + "\n";
        s += "ESP Estimate Next Quarter                  [e9]: " + m_nextQuarterEstimateEPS + "\n";
        s += "Day's Low                                   [g]: " + m_dailyLow + "\n";
        s += "Day's High                                  [h]: " + m_dailyHigh + "\n";
        s += "52-week Low                                 [j]: " + m_fiftyTwoWeekLow + "\n";
        s += "52-week High                                [k]: " + m_fiftyTwoWeekHigh + "\n";
        s += "Holdings Gain Percent                      [g1]: " + m_holdingsGainPercent + "\n";
        s += "Annualized Gain                            [g3]: " + m_annualizedGain + "\n";
        s += "Holdings Gain                              [g4]: " + m_holdingsGain + "\n";
        s += "Holdings Gain Percent (Real-time)          [g5]: " + m_realTimeHoldingsGainPercent + "\n";
        s += "Holdings Gain (Real-time)                  [g6]: " + m_realTimeHoldingsGain + "\n";
        s += "More Info                                   [i]: " + m_moreInfo + "\n";
        s += "Order Book (Real-time)                     [i5]: " + m_realTimeOrderBook + "\n";
        s += "Market Capitalization                      [j1]: " + m_marketCapitalization + "\n";
        s += "Market Cap (Real-time)                     [j3]: " + m_realTimeMarketCapitalization + "\n";
        s += "EBITDA                                     [j4]: " + m_EBITDA + "\n";
        s += "Change From 52-week Low                    [j5]: " + m_changeFrom52WeekLow + "\n";
        s += "Percent Change From 52-week Low            [j6]: " + m_percentChangeFrom52WeekLow + "\n";
        s += "Last Trade (Real-time) With Time           [k1]: " + m_realTimeLastTradeWithTime + "\n";
        s += "Change Percent (Real-time)                 [k2]: " + m_realTimeChangePercent + "\n";
        s += "Change From 52-week High                   [k4]: " + m_changeFrom52WeekHigh + "\n";
        s += "Change Percent From 52-week High           [k5]: " + m_percentChangeFrom52WeekHigh + "\n";
        s += "Last Trade (With Time)                      [l]: " + m_lastTradeWithTime + "\n";
        s += "Last Trade (Price Only)                    [l1]: " + m_lastTradePriceOnly + "\n";
        s += "High Limit                                 [l2]: " + m_highLimit + "\n";
        s += "Low Limit                                  [l3]: " + m_lowLimit + "\n";
        s += "Day's Range                                 [m]: " + m_daysRange + "\n";
        s += "Day's Range (Real-time)                    [m2]: " + m_realTimeDaysRange + "\n";
        s += "50-day Moving Average                      [m3]: " + m_50DayMovingAverage + "\n";
        s += "200-day Moving Average                     [m4]: " + m_200DayMovingAverage + "\n";
        s += "Change from 200-day Moving Average         [m5]: " + m_changeFrom200DayMovingAverage + "\n";
        s += "Percent Change From 200-day Moving Average [m6]: " + m_percentChangeFrom200DayMovingAverage + "\n";
        s += "Change From 50-day Moving Average          [m7]: " + m_changeFrom50DayMovingAverage + "\n";
        s += "Percent Change From 50-day Moving Average  [m8]: " + m_percentChangeFrom50DayMovingAverage + "\n";
        s += "Notes                                      [n4]: " + m_notes + "\n";
        s += "Open                                        [o]: " + m_open + "\n";
        s += "Previous Close                              [p]: " + m_previousClose + "\n";
        s += "Price Paid                                 [p1]: " + m_pricePaid + "\n";
        s += "Change in Percent                          [p2]: " + m_changeInPercent + "\n";
        s += "Price/Sales                                [p5]: " + m_priceToSalesRatio + "\n";
        s += "Price/Book                                 [p6]: " + m_priceToBookRatio + "\n";
        s += "Ex-Dividend Date                            [q]: " + m_exDividendDate + "\n";
        s += "P/E Ratio                                   [r]: " + m_priceToEarningsRatio + "\n";
        s += "Dividend Pay Date                          [r1]: " + m_dividendPayDate + "\n";
        s += "P/E Ratio (Real-time)                      [r2]: " + m_realTimePriceToEarningsRatio + "\n";
        s += "PEG Ratio                                  [r5]: " + m_pegRatio + "\n";
        s += "Price/EPS Estimate Current Year            [r6]: " + m_currentYearEstimatePriceToEPS + "\n";
        s += "Price/EPS Estimate Next Year               [r7]: " + m_nextYearEstimatePriceToEPS + "\n";
        s += "Symbol                                      [s]: " + m_symbol + "\n";
        s += "Shares Owned                               [s1]: " + m_sharesOwned + "\n";
        s += "Short Ratio                                [s7]: " + m_shortRatio + "\n";
        s += "Last Trade Time                            [t1]: " + m_lastTradeTime + "\n";
        s += "Ticker Trend                               [t7]: " + m_tickerTrend + "\n";
        s += "1 yr Target Price                          [t8]: " + m_oneYearTargetPrice + "\n";
        s += "Volume                                      [v]: " + m_volume + "\n";
        s += "Holdings Value                             [v1]: " + m_holdingsValue + "\n";
        s += "Holdings Value (Real-time)                 [v7]: " + m_realTimeHoldingsValue + "\n";
        s += "52-week Range                               [w]: " + m_fiftyTwoWeekRange + "\n";
        s += "Day's Value Change                         [w1]: " + m_daysValueChange + "\n";
        s += "Day's Value Change (Real-time)             [w4]: " + m_realTimeDaysValueChange + "\n";
        s += "Stock Exchange                              [x]: " + m_stockExchange + "\n";
        s += "Dividend Yield                              [y]: " + m_dividendYield + "\n";
        s += "Name                                        [n]: " + m_name + "\n";

        return s;
    }
    
    
    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(YahooFinanceQuote rhs)
    {
        if (m_symbol.equals(rhs.m_symbol))
            return m_rawData.compareTo(rhs.m_rawData);
        
        return (m_symbol.compareTo(rhs.m_symbol));
    }
    
    /**
     * Returns if the quote data is valid (and actually has been retrieved)
     * 
     * @return true if the data is valid
     */
    public boolean isValid()
    {
    	if (m_symbol == null)
    		return false;
    	
    	if (m_symbol.isEmpty())
    		return false;
    	
    	return true;
    }

}
