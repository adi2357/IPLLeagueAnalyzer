package com.bridgelabz.analyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bridgelabz.exception.IPLException;
import com.bridgelabz.jarfile.opencsvbuilder.CSVBuilderFactory;
import com.bridgelabz.jarfile.opencsvbuilder.CSVException;
import com.bridgelabz.jarfile.opencsvbuilder.ICSVBuilder;
import com.bridgelabz.players.IPLBatsmen;
import com.bridgelabz.players.IPLBowlers;

public class IPLAnalyzer {
	public Path csvBattingFilePath;
	public Path csvBowlingFilePath;
	public List<IPLBatsmen> iplBattingList;
	public List<IPLBowlers> iplBowlingList;

	public IPLAnalyzer(Path battingFilePath, Path bowlingFilePath) {
		csvBattingFilePath = battingFilePath;
		csvBowlingFilePath = bowlingFilePath;
	}

	public void readBattingCSVData() throws IPLException {
		try (Reader reader = Files.newBufferedReader(csvBattingFilePath)) {
			ICSVBuilder<IPLBatsmen> csvBuilder = CSVBuilderFactory.createCSVBuilder();
			iplBattingList = new ArrayList<IPLBatsmen>(new HashSet<IPLBatsmen>(csvBuilder.getCSVList(reader, IPLBatsmen.class)));
		} catch (CSVException e) {
			throw new IPLException("Invalid state present", IPLException.ExceptionType.INVALID_STATE);
		} catch (NoSuchFileException e) {
			throw new IPLException("Invalid state present", IPLException.ExceptionType.INVALID_FILE);
		} catch (IOException e) {
			throw new IPLException("Invalid I/O present", IPLException.ExceptionType.INVALID_IO);
		}
	}

	public void readBowlingCSVData() throws IPLException {
		try (Reader reader = Files.newBufferedReader(csvBowlingFilePath)) {
			ICSVBuilder<IPLBowlers> csvBuilder = CSVBuilderFactory.createCSVBuilder();
			iplBowlingList = new ArrayList<IPLBowlers>( new HashSet<IPLBowlers>(csvBuilder.getCSVList(reader, IPLBowlers.class)));
		} catch (CSVException e) {
			throw new IPLException("Invalid state present", IPLException.ExceptionType.INVALID_STATE);
		} catch (NoSuchFileException e) {
			throw new IPLException("Invalid state present", IPLException.ExceptionType.INVALID_FILE);
		} catch (IOException e) {
			throw new IPLException("Invalid I/O present", IPLException.ExceptionType.INVALID_IO);
		}
	}
}
