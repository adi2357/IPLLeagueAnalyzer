package com.bridgelabz.iplleagueanalyzer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IPLOperations {
	IPLAnalyzer iplAnalyzerObject;

	public IPLOperations(IPLAnalyzer iplAnalyzerObject) {
		this.iplAnalyzerObject = iplAnalyzerObject;
	}

	public Double[] getBestAverage() throws IPLException {
		if(iplAnalyzerObject.iplBattingDataList == null || iplAnalyzerObject.iplBattingDataList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
		Comparator<IPLBattingCSV> compareByAverage = Collections.reverseOrder(Comparator.comparing(IPLBattingCSV::getAvgerage));
		return sort(compareByAverage, iplAnalyzerObject.iplBattingDataList).map(player -> player.getAvgerage()).toArray(size -> new Double[size]);
	}

	public Double[] getTopStrikingRates() throws IPLException {
		if(iplAnalyzerObject.iplBattingDataList == null || iplAnalyzerObject.iplBattingDataList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
		Comparator<IPLBattingCSV> compareByStrikeRate = Collections.reverseOrder(Comparator.comparing(IPLBattingCSV::getStrikeRate));		
		return sort(compareByStrikeRate, iplAnalyzerObject.iplBattingDataList).map(player -> player.getStrikeRate()).toArray(size -> new Double[size]);
	}

	public String[] getBatsmenWithMaximumSixes() throws IPLException {
		if(iplAnalyzerObject.iplBattingDataList == null || iplAnalyzerObject.iplBattingDataList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
		Comparator<IPLBattingCSV> compareBySixes = Collections.reverseOrder(Comparator.comparing(IPLBattingCSV::getSixes));		
		return sort(compareBySixes, iplAnalyzerObject.iplBattingDataList).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumFours() throws IPLException {
		if(iplAnalyzerObject.iplBattingDataList == null || iplAnalyzerObject.iplBattingDataList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
		Comparator<IPLBattingCSV> compareByFours = Comparator.comparing(IPLBattingCSV::getFours).reversed();
		return sort(compareByFours, iplAnalyzerObject.iplBattingDataList).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumBoundaries() throws IPLException {
		Comparator<IPLBattingCSV> compareByFours = Comparator.comparing(IPLBattingCSV::getBoundaries).reversed();
		return sort(compareByFours, iplAnalyzerObject.iplBattingDataList).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithBestStrikeRatesAndMaximumBoundaries() throws IPLException {
		Comparator<IPLBattingCSV> compareByStrikeRates = Comparator.comparing(IPLBattingCSV::getStrikeRate).reversed();
		List<IPLBattingCSV> battingListSortedByStrikeRates = sort(compareByStrikeRates, iplAnalyzerObject.iplBattingDataList).collect(Collectors.toList());
		Comparator<IPLBattingCSV> compareByBoundaries = Comparator.comparing(IPLBattingCSV::getBoundaries).reversed();
		return sort(compareByBoundaries, battingListSortedByStrikeRates).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithBestAveragesWithBestStrikeRates() throws IPLException{
		// TODO Auto-generated method stub
		return null;
	}

	public <E> Stream<E> sort(Comparator<E> iplComparator, List<E> iplDataList){
		return iplDataList.stream().sorted((Comparator<E>) Comparator.comparing(IPLBattingCSV::getPlayerName)).sorted(iplComparator).limit(5);
	}
}
