package com.bridgelabz.analyzertest;

import java.nio.file.Paths;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.analyzer.IPLAnalyzer;
import com.bridgelabz.exception.IPLException;
import com.bridgelabz.operations.IPLOperations;

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
			iplAnalyzer.readAllRounderData();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void givenIPLBattingCSVData_WhenBestBattingAverages_ShouldReturnBattingAverages() {
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
	public void givenIPLBattingCSVData_WhenTopBattingStrikeRates_ShouldReturnStrikeRates() {
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
	public void givenIPLBattingCSVData_WhenMaximumSixes_ShouldReturnBatsmen() {
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
	public void givenIPLBattingCSVData_WhenMaximumFours_ShouldReturnBatsmen() {
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
	public void givenIPLBattingCSVData_WhenMaximumBoundaries_ShouldReturnBatsmen() {
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
	public void givenIPLBattingCSVData_WhenBestStrikeRatesAndMaximumBoundaries_ShouldReturnBatsmen() {
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
	public void givenIPLBattingCSVData_WhenBestAveragesWithBestStrikeRates_ShouldReturnBatsmen() {
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
	public void givenIPLBattingCSVData_WhenMaximumRunsWithBestAverages_ShouldReturnBatsmen() {
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
	public void givenIPLBowlingCSVData_WhenBestBowlingAverages_ShouldReturnBowlingAverages() {
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
	public void givenIPLBowlingCSVData_WhenTopBowlingStrikeRates_ShouldReturnStrikeRates() {
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
	public void givenIPLBowlingCSVData_WhenBestEconomy_ShouldReturnBowlers() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] bowlerNames = operationObject.getBowlersWithBestEconomy();
			String[] expectedBowlerNames = { "Shivam Dube", "Anukul Roy", "Suresh Raina", "Stuart Binny", "Ravindra Jadeja" };
			Assert.assertArrayEquals(expectedBowlerNames, bowlerNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBowlingCSVData_WhenBestStrikeRatesWithFourAndFiveWickets_ShouldReturnBowlers() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] bowlerNames = operationObject.getBowlersWithBestStrikeRatesWithFourAndFiveWickets();
			String[] expectedBowlerNames = {"Kagiso Rabada", "Imran Tahir", "Lasith Malinga", "Alzarri Joseph", "Yuzvendra Chahal"};
			Assert.assertArrayEquals(expectedBowlerNames, bowlerNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBowlingCSVData_WhenBestAveragesWithStrikeRates_ShouldReturnBowlers() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] bowlerNames = operationObject.getBowlersWithBestAveragesAndBestStrikeRates();
			String[] expectedBowlerNames = {"Alzarri Joseph", "Khaleel Ahmed", "Kagiso Rabada", "Anukul Roy",  "Jagadeesha Suchith"};
			Assert.assertArrayEquals(expectedBowlerNames, bowlerNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBowlingCSVData_WhenMaximumWicketsAndBestAverages_ShouldReturnBowlers() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] bowlerNames = operationObject.getBowlersWithMaximumWicketsAndBestAverages();
			String[] expectedBowlerNames = {"Kagiso Rabada", "Imran Tahir", "Shreyas Gopal", "Jasprit Bumrah", "Deepak Chahar"};
			Assert.assertArrayEquals(expectedBowlerNames, bowlerNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLAllRounderData_WhenBestBattingAndBowlingAverages_ShouldReturnCricketers() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] cricketerNames = operationObject.getCricketersWithBestBattingAndBowlingAverages();
			String[] expectedCricketerNames = {"Andre Russell", "Hardik Pandya", "Ravindra Jadeja", "Nitish Rana", "Mitchell Santner"};
			Assert.assertArrayEquals(expectedCricketerNames, cricketerNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLAllRounderData_WhenMostRunsAndWickets_ShouldReturnCricketers() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] cricketerNames = operationObject.getCricketersWithMostRunsAndWickets();
			String[] expectedCricketerNames = {"Hardik Pandya", "Andre Russell", "Krunal Pandya", "Ravindra Jadeja", "Sunil Narine"};
			Assert.assertArrayEquals(expectedCricketerNames, cricketerNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_WhenMaximumHundredsAndBestAverages_ShouldReturnBatsmen() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenNames = operationObject.getBatsmenWithMaximumHundredsAndBestAverages();
			String[] expectedBatsmenNames = {"David Warner", "Jonny Bairstow", "KL Rahul","Sanju Samson", "Virat Kohli"};
			Assert.assertArrayEquals(expectedBatsmenNames, batsmenNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void givenIPLBattingCSVData_WhenZeroHundredsAndFiftiesButBestAverages_ShouldReturnBatsmen() {
		IPLOperations operationObject = new IPLOperations(iplAnalyzer);
		try {
			String[] batsmenNames = operationObject.getBatsmenWithZeroHundredsAndFiftiesButBestAverages();
			String[] expectedBatsmenNames = {"Marcus Stoinis", "Mandeep Singh", "Ravindra Jadeja","Jofra Archer", "Mitchell Santner"};
			Assert.assertArrayEquals(expectedBatsmenNames, batsmenNames);
		} catch (IPLException e) {
			System.out.println(e.getMessage());
		}
	}
}
