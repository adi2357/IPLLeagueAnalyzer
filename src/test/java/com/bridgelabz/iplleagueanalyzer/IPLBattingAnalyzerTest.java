package com.bridgelabz.iplleagueanalyzer;


import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPLBattingAnalyzerTest {
	IPLBattingAnalyzer battingAnalyzer;
	private static final String IPL_BATTING_CSV_DATA_FILE = "C:\\Users\\aaada\\Dev\\eclipse-workspace\\IPLLeagueAnalyzer\\IPLBattingCSV.csv";

	@Before
	public void initialize() {
		battingAnalyzer = new IPLBattingAnalyzer(Paths.get(IPL_BATTING_CSV_DATA_FILE));
	}
	
	@Test
	public void givenIPLBatting_ShouldReturnBestbattingAverages() {
		try {		
			battingAnalyzer.readCSVData();
			Double[] bestAverages = battingAnalyzer.getBestAverage();
			Double[] expectedbestAverages = {83.2,69.2,56.66,55.62,53.9};			
			Assert.assertArrayEquals(expectedbestAverages, bestAverages);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
