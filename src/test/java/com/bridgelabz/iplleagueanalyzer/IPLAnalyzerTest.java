package com.bridgelabz.iplleagueanalyzer;


import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPLAnalyzerTest {
	IPLAnalyzer battingAnalyzer;
	private static final String IPL_BATTING_CSV_DATA_FILE = "C:\\Users\\aaada\\Dev\\eclipse-workspace\\IPLLeagueAnalyzer\\IPLBattingCSV.csv";

	@Before
	public void initialize() {
		battingAnalyzer = new IPLAnalyzer(Paths.get(IPL_BATTING_CSV_DATA_FILE));
		try {
			battingAnalyzer.readCSVData();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void givenIPLBattingCSVData_ShouldReturnBestbattingAverages() {
		IPLOperations operationObject = new IPLOperations(battingAnalyzer);
		try {
			Double[] bestAverages = operationObject.getBestAverage();
			Double[] expectedbestAverages = { 83.2, 69.2, 56.66, 55.62, 53.9 };
			Assert.assertArrayEquals(expectedbestAverages, bestAverages);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnTopStrikingRates() {
		IPLOperations operationObject = new IPLOperations(battingAnalyzer);
		try {
			Double[] topStrikingRates = operationObject.getTopStrikingRates();
			Double[] expectedtopStrikingRates = { 333.33, 204.81, 200.0, 191.42, 175.0 };
			Assert.assertArrayEquals(expectedtopStrikingRates, topStrikingRates);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithMaximumSixes() {
		IPLOperations operationObject = new IPLOperations(battingAnalyzer);
		try {
			String[] batsmenWithMaximumSixes = operationObject.getBatsmenWithMaximumSixes();
			String[] expectedbatsmenWithMaximumSixes = { "Andre Russell", "Chris Gayle", "Hardik Pandya", "Rishabh Pant", "AB de Villiers" };
			Assert.assertArrayEquals(expectedbatsmenWithMaximumSixes, batsmenWithMaximumSixes);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithMaximumFours() {
		IPLOperations operationObject = new IPLOperations(battingAnalyzer);
		try {
			String[] batsmenWithMaximumFours = operationObject.getBatsmenWithMaximumFours();
			String[] expectedbatsmenWithMaximumFours = { "Shikhar Dhawan", "David Warner", "Rohit Sharma", "KL Rahul", "Jonny Bairstow" };
			Assert.assertArrayEquals(expectedbatsmenWithMaximumFours, batsmenWithMaximumFours);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithMaximumBoundaries() {
		IPLOperations operationObject = new IPLOperations(battingAnalyzer);
		try {
			String[] batsmenWithMaximumBoundaries = operationObject.getBatsmenWithMaximumBoundaries();
			String[] expectedbatsmenWithMaximumBoundaries = { "Andre Russell", "Chris Gayle", "David Warner", "Shikhar Dhawan", "KL Rahul" };
			Assert.assertArrayEquals(expectedbatsmenWithMaximumBoundaries, batsmenWithMaximumBoundaries);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithBestStrikeRatesAndMaximumBoundaries() {
		IPLOperations operationObject = new IPLOperations(battingAnalyzer);
		try {
			String[] batsmenWithBestStrikeRatesWithMaximumBoundaries = operationObject.getBatsmenWithBestStrikeRatesAndMaximumBoundaries();
			String[] expectedBatsmenWithBestStrikeRatesWithMaximumBoundaries = { "Andre Russell", "Hardik Pandya", "Stuart Binny", "Ishant Sharma", "Shardul Thakur" };
			Assert.assertArrayEquals(expectedBatsmenWithBestStrikeRatesWithMaximumBoundaries, batsmenWithBestStrikeRatesWithMaximumBoundaries);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_ShouldReturnBatsmenWithMaximumRunsWithBestAverages() {
		IPLOperations operationObject = new IPLOperations(battingAnalyzer);
		try {
			String[] batsmenWithMaximumRunsWithBestAverages = operationObject.getBatsmenWithMaximumRunsWithBestAverages();
			String[] expectedBatsmenWithMaximumRunsWithBestAverages = { "David Warner", "Andre Russell", "KL Rahul", "Quinton de Kock", "Shikhar Dhawan" };
			Assert.assertArrayEquals(expectedBatsmenWithMaximumRunsWithBestAverages, batsmenWithMaximumRunsWithBestAverages);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	
	
}
