package com.bridgelabz.iplleagueanalyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import com.bridgelabz.jarfile.opencsvbuilder.CSVBuilderFactory;
import com.bridgelabz.jarfile.opencsvbuilder.CSVException;
import com.bridgelabz.jarfile.opencsvbuilder.ICSVBuilder;


public class IPLBattingAnalyzer {
	public Path csvFilePath;
	List<IPLBattingCSV> iplBattingDataList;

	public IPLBattingAnalyzer(Path filePath) {
		csvFilePath = filePath;
	}
	
	public void readCSVData() throws IOException, CSVException {
		try(Reader reader = Files.newBufferedReader(csvFilePath)){
		ICSVBuilder<IPLBattingCSV> csvBuilder = CSVBuilderFactory.createCSVBuilder();
		iplBattingDataList = csvBuilder.getCSVList(reader, IPLBattingCSV.class);
		}catch(IOException e) {
			throw new CSVException("Invalid path entered", CSVException.ExceptionType.INCORRECT_STATE);
		}
	}

	public Double[] getBestAverage() throws IOException, CSVException {
		Double[] sortedByAverage = iplBattingDataList.stream().map(player -> player.getAvgerage()).sorted(Comparator.reverseOrder()).toArray(size -> new Double[size]);
		return ArrayUtils.subarray(sortedByAverage,0,5);
	}

}
