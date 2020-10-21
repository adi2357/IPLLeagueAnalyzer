package com.bridgelabz.iplleagueanalyzer;

import java.util.Comparator;
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
		return null;
	}

}
