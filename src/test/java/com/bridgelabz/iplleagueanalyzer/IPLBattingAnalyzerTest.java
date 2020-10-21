package com.bridgelabz.iplleagueanalyzer;

import java.nio.file.Paths;
import org.junit.Test;

import junit.framework.Assert;

public class IPLBattingAnalyzerTest {
	private static final String IPL_BATTING_CSV_DATA_FILE = "C:\\Users\\aaada\\Dev\\eclipse-workspace\\IPLLeagueAnalyzer\\IPLBattingCSV.csv";

	@Test
	public void givenIPLBatting_ShouldReturnBestbattingAverages() {
		IPLBattingAnalyzer battingAnalyzer = new IPLBattingAnalyzer(Paths.get(IPL_BATTING_CSV_DATA_FILE));
		double bestAverage = battingAnalyzer.getBestAverage();
		Assert.assertEquals(83.2, bestAverage);
		
	}
}
