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
}
