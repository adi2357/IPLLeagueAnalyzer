package com.bridgelabz.iplleagueanalyzer;

import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPLAnalyzerTest {
	IPLAnalyzer iplAnalyzer;
	private static final String IPL_BATTING_CSV_DATA_FILE = "C:\\Users\\aaada\\Dev\\eclipse-workspace\\IPLLeagueAnalyzer\\IPLBattingCSV.csv";
	private static final String IPL_BOWLING_CSV_DATA_FILE = "C:\\Users\\aaada\\Dev\\eclipse-workspace\\IPLLeagueAnalyzer\\IPLBowlingCSV.csv";

	@Before
	public void initialize() {
		iplAnalyzer = new IPLAnalyzer(Paths.get(IPL_BATTING_CSV_DATA_FILE),Paths.get(IPL_BOWLING_CSV_DATA_FILE));
		try {
			iplAnalyzer.readBattingCSVData();
			iplAnalyzer.readBowlingCSVData();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void givenIPLBattingCSVData_ShouldReturnBestBattingAverages() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			Double[] bestAverages = operationObject.getBestBattingAverage();
			Double[] expectedBestAverages = { 83.2, 69.2, 56.66, 55.62, 53.9 };
			Assert.assertArrayEquals(expectedBestAverages, bestAverages);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnTopBattingStrikeRates() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			Double[] topStrikingRates = operationObject.getTopBattingStrikeRates();
			Double[] expectedTopStrikingRates = { 333.33, 204.81, 200.0, 191.42, 175.0 };
			Assert.assertArrayEquals(expectedTopStrikingRates, topStrikingRates);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithMaximumSixes() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenNames = operationObject.getBatsmenWithMaximumSixes();
			String[] expectedBatsmenNames = { "Andre Russell", "Chris Gayle", "Hardik Pandya", "Rishabh Pant", "AB de Villiers" };
			Assert.assertArrayEquals(expectedBatsmenNames, batsmenNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithMaximumFours() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenNames = operationObject.getBatsmenWithMaximumFours();
			String[] expectedBatsmenNames = { "Shikhar Dhawan", "David Warner", "Rohit Sharma", "KL Rahul", "Jonny Bairstow" };
			Assert.assertArrayEquals(expectedBatsmenNames, batsmenNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithMaximumBoundaries() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenNames = operationObject.getBatsmenWithMaximumBoundaries();
			String[] expectedBatsmenNames = { "Andre Russell", "Chris Gayle", "David Warner", "Shikhar Dhawan", "KL Rahul" };
			Assert.assertArrayEquals(expectedBatsmenNames, batsmenNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithBestStrikeRatesAndMaximumBoundaries() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenNames = operationObject.getBatsmenWithBestStrikeRatesAndMaximumBoundaries();
			String[] expectedBatsmenNames = { "Andre Russell", "Hardik Pandya", "Stuart Binny", "Ishant Sharma", "Shardul Thakur" };
			Assert.assertArrayEquals(expectedBatsmenNames, batsmenNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithBestAveragesWithBestStrikeRates() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenNames = operationObject.getBatsmenWithBestAveragesWithBestStrikeRates();
			String[] expectedBatsmenNames = { "Andre Russell", "Jonny Bairstow", "David Warner", "KL Rahul", "MS Dhoni" };
			Assert.assertArrayEquals(expectedBatsmenNames, batsmenNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithMaximumRunsWithBestAverages() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenNames = operationObject.getBatsmenWithMaximumRunsWithBestAverages();
			String[] expectedBatsmenNames = { "David Warner", "Andre Russell", "KL Rahul", "Quinton de Kock", "Shikhar Dhawan" };
			Assert.assertArrayEquals(expectedBatsmenNames, batsmenNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBowlingCSVData_ShouldReturnBestBowlingAverages() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			Double[] bestBowlingAverages = operationObject.getBestBowlingAverage();
			Double[] expectedBestBowlingAverages = { 11.0, 14.0, 14.5, 14.72, 15.1 };
			Assert.assertArrayEquals(expectedBestBowlingAverages, bestBowlingAverages);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void givenIPLBowlingCSVData_ShouldReturnTopBowlingStrikeRates() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			Double[] topBowlingStrikeRates = operationObject.getTopBowlingStrikeRates();
			Double[] expectedTopBowlingStrikeRates = { 8.66, 10.75, 11.0, 11.28, 12.0 };
			Assert.assertArrayEquals(expectedTopBowlingStrikeRates, topBowlingStrikeRates);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBowlingCSVData_ShouldReturnBowlersWithBestEconomy() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] bowlerNames = operationObject.getBowlersWithBestEconomy();
			String[] expectedBowlerNames = { "Shivam Dube", "Anukul Roy", "Suresh Raina", "Stuart Binny", "Ravindra Jadeja" };
			Assert.assertArrayEquals(expectedBowlerNames, bowlerNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}
}
