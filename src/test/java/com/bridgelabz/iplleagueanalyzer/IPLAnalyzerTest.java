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
			iplAnalyzer.readCSVData();
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
	public void givenIPLBattingCSVData_ShouldReturnTopStrikingRates() {
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
			String[] batsmenWithMaximumSixes = operationObject.getBatsmenWithMaximumSixes();
			String[] expectedBatsmenWithMaximumSixes = { "Andre Russell", "Chris Gayle", "Hardik Pandya", "Rishabh Pant", "AB de Villiers" };
			Assert.assertArrayEquals(expectedBatsmenWithMaximumSixes, batsmenWithMaximumSixes);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithMaximumFours() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenWithMaximumFours = operationObject.getBatsmenWithMaximumFours();
			String[] expectedBatsmenWithMaximumFours = { "Shikhar Dhawan", "David Warner", "Rohit Sharma", "KL Rahul", "Jonny Bairstow" };
			Assert.assertArrayEquals(expectedBatsmenWithMaximumFours, batsmenWithMaximumFours);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithMaximumBoundaries() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenWithMaximumBoundaries = operationObject.getBatsmenWithMaximumBoundaries();
			String[] expectedBatsmenWithMaximumBoundaries = { "Andre Russell", "Chris Gayle", "David Warner", "Shikhar Dhawan", "KL Rahul" };
			Assert.assertArrayEquals(expectedBatsmenWithMaximumBoundaries, batsmenWithMaximumBoundaries);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithBestStrikeRatesAndMaximumBoundaries() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenWithBestStrikeRatesWithMaximumBoundaries = operationObject.getBatsmenWithBestStrikeRatesAndMaximumBoundaries();
			String[] expectedBatsmenWithBestStrikeRatesWithMaximumBoundaries = { "Andre Russell", "Hardik Pandya", "Stuart Binny", "Ishant Sharma", "Shardul Thakur" };
			Assert.assertArrayEquals(expectedBatsmenWithBestStrikeRatesWithMaximumBoundaries, batsmenWithBestStrikeRatesWithMaximumBoundaries);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithBestAveragesWithBestStrikeRates() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenWithBestStrikeRatesWithBestStrikeRates = operationObject.getBatsmenWithBestAveragesWithBestStrikeRates();
			String[] expectedBatsmenWithBestStrikeRatesWithBestStrikeRates = { "Andre Russell", "Jonny Bairstow", "David Warner", "KL Rahul", "MS Dhoni" };
			Assert.assertArrayEquals(expectedBatsmenWithBestStrikeRatesWithBestStrikeRates, batsmenWithBestStrikeRatesWithBestStrikeRates);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithMaximumRunsWithBestAverages() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenWithMaximumRunsWithBestAverages = operationObject.getBatsmenWithMaximumRunsWithBestAverages();
			String[] expectedBatsmenWithMaximumRunsWithBestAverages = { "David Warner", "Andre Russell", "KL Rahul", "Quinton de Kock", "Shikhar Dhawan" };
			Assert.assertArrayEquals(expectedBatsmenWithMaximumRunsWithBestAverages, batsmenWithMaximumRunsWithBestAverages);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBowlingCSVData_ShouldReturnBestBowlingAverages() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			Double[] bestBowlingAverages = operationObject.getBestBowlingAverage();
			Double[] expectedBestBowlingAverages = { 166.0, 118.0, 94.25, 91.5, 77.6 };
			Assert.assertArrayEquals(expectedBestBowlingAverages, bestBowlingAverages);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}
}
