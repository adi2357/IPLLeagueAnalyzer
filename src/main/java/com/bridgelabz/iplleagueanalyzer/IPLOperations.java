package com.bridgelabz.iplleagueanalyzer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

public class IPLOperations {
	IPLAnalyzer iplAnalyzerObject;

	public IPLOperations(IPLAnalyzer iplAnalyzerObject) {
		this.iplAnalyzerObject = iplAnalyzerObject;
	}

	public Double[] getBestAverage() throws IPLException {
		Double[] sortedByAverage = iplAnalyzerObject.iplBattingDataList.stream()
													 .map(player -> player.getAvgerage())
													 .sorted(Comparator.reverseOrder())
													 .toArray(size -> new Double[size]);
		return ArrayUtils.subarray(sortedByAverage, 0, 5);
	}

	public Double[] getTopStrikingRates() throws IPLException {
		Double[] sortedByStrikeRates = iplAnalyzerObject.iplBattingDataList.stream()
														.map(player -> player.getStrikeRate())
														.sorted(Comparator.reverseOrder())
														.toArray(size -> new Double[size]);		
		return ArrayUtils.subarray(sortedByStrikeRates, 0, 5);
	}

	public String[] getBatsmenWithMaximumSixes() throws IPLException {
		Comparator<IPLBattingCSV> compareBySixes = Collections.reverseOrder(Comparator.comparing(player -> player.sixes));
		String[] sortedBySixes = iplAnalyzerObject.iplBattingDataList.stream()
														.sorted(compareBySixes)
														.map(player -> player.getPlayerName())
														.toArray(size -> new String[size]);
														
		return ArrayUtils.subarray(sortedBySixes, 0, 5);
	}

	public String[] getBatsmenWithMaximumFours() throws IPLException {
		Comparator<IPLBattingCSV> compareByFours = Collections.reverseOrder(Comparator.comparing(player -> player.fours));
		String[] sortedByFours = iplAnalyzerObject.iplBattingDataList.stream()
														.sorted(compareByFours)
														.map(player -> player.getPlayerName())
														.toArray(size -> new String[size]);
														
		return ArrayUtils.subarray(sortedByFours, 0, 5);
	}

}
