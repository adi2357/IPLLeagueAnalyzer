package com.bridgelabz.iplleagueanalyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bridgelabz.jarfile.opencsvbuilder.CSVBuilderFactory;
import com.bridgelabz.jarfile.opencsvbuilder.CSVException;
import com.bridgelabz.jarfile.opencsvbuilder.ICSVBuilder;

public class IPLAnalyzer {
	public Path csvBattingFilePath;
	public Path csvBowlingFilePath;
	List<IPLBattingCSV> iplBattingDataList;
	List<IPLBowlingCSV> iplBowlingDataList;

	public IPLAnalyzer(Path battingFilePath, Path bowlingFilePath) {
		csvBattingFilePath = battingFilePath;
		csvBowlingFilePath = bowlingFilePath;
	}

	public void readCSVData() throws IPLException {
		try (Reader reader = Files.newBufferedReader(csvBattingFilePath)) {
			ICSVBuilder<IPLBattingCSV> csvBuilder = CSVBuilderFactory.createCSVBuilder();
			Set<IPLBattingCSV> hashSet = new HashSet<IPLBattingCSV>(csvBuilder.getCSVList(reader, IPLBattingCSV.class));
			iplBattingDataList = new ArrayList<IPLBattingCSV>(hashSet);
		} catch (CSVException e) {
			throw new IPLException("Invalid state present", IPLException.ExceptionType.INVALID_STATE);
		} catch (NoSuchFileException e) {
			throw new IPLException("Invalid state present", IPLException.ExceptionType.INVALID_FILE);
		} catch (IOException e) {
			throw new IPLException("Invalid I/O present", IPLException.ExceptionType.INVALID_IO);
		}
	}
}
