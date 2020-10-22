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

	public Double[] getBestBattingAverage() throws IPLException {
		if(iplAnalyzerObject.iplBattingDataList == null || iplAnalyzerObject.iplBattingDataList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
	
		Comparator<IPLBattingCSV> compareByAverage = Collections.reverseOrder(Comparator.comparing(IPLBattingCSV::getAvgerage));
		return sort(compareByAverage, iplAnalyzerObject.iplBattingDataList).map(player -> player.getAvgerage()).toArray(size -> new Double[size]);
	}

	public Double[] getTopBattingStrikeRates() throws IPLException {
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
	
		Comparator<IPLBattingCSV> compareByFours = Collections.reverseOrder(Comparator.comparing(IPLBattingCSV::getFours))
															  .thenComparing(Comparator.comparing(IPLBattingCSV::getPlayerName));
		return sort(compareByFours, iplAnalyzerObject.iplBattingDataList).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumBoundaries() throws IPLException {
		if(iplAnalyzerObject.iplBattingDataList == null || iplAnalyzerObject.iplBattingDataList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
	
		Comparator<IPLBattingCSV> compareByFours = Comparator.comparing(IPLBattingCSV::getBoundaries).reversed();
		return sort(compareByFours, iplAnalyzerObject.iplBattingDataList).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithBestStrikeRatesAndMaximumBoundaries() throws IPLException {
		if(iplAnalyzerObject.iplBattingDataList == null || iplAnalyzerObject.iplBattingDataList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
	
		Comparator<IPLBattingCSV> compareByStrikeRates = Comparator.comparing(IPLBattingCSV::getStrikeRate).reversed();
		List<IPLBattingCSV> battingListSortedByStrikeRates = sort(compareByStrikeRates, iplAnalyzerObject.iplBattingDataList).collect(Collectors.toList());
		Comparator<IPLBattingCSV> compareByBoundaries = Comparator.comparing(IPLBattingCSV::getBoundaries).reversed();
		return sort(compareByBoundaries, battingListSortedByStrikeRates).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithBestAveragesWithBestStrikeRates() throws IPLException{
		if(iplAnalyzerObject.iplBattingDataList == null || iplAnalyzerObject.iplBattingDataList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
	
		Comparator<IPLBattingCSV> compareByAverage = Collections.reverseOrder(Comparator.comparing(IPLBattingCSV::getAvgerage));
		List<IPLBattingCSV> battingListSortedByBestAverages = sort(compareByAverage, iplAnalyzerObject.iplBattingDataList).collect(Collectors.toList());
		Comparator<IPLBattingCSV> compareByStrikeRates = Comparator.comparing(IPLBattingCSV::getStrikeRate).reversed();
		return sort(compareByStrikeRates, battingListSortedByBestAverages).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumRunsWithBestAverages() throws IPLException {
		if(iplAnalyzerObject.iplBattingDataList == null || iplAnalyzerObject.iplBattingDataList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
		
		Comparator<IPLBattingCSV> compareByRuns = Collections.reverseOrder(Comparator.comparing(IPLBattingCSV::getRuns));
		List<IPLBattingCSV> battingListSortedByMaximumRuns = sort(compareByRuns, iplAnalyzerObject.iplBattingDataList).collect(Collectors.toList());
		Comparator<IPLBattingCSV> compareByAverage = Collections.reverseOrder(Comparator.comparing(IPLBattingCSV::getAvgerage));
		return sort(compareByAverage, battingListSortedByMaximumRuns).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public <E> Stream<E> sort(Comparator<E> iplComparator, List<E> iplDataList){
		return iplDataList.stream().sorted(iplComparator).limit(5);
	}

	public Double[] getBestBowlingAverage() throws IPLException{
		if(iplAnalyzerObject.iplBowlingDataList == null || iplAnalyzerObject.iplBowlingDataList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
		
		Comparator<IPLBowlingCSV> compareByAverage =  Collections.reverseOrder(Comparator.comparing(IPLBowlingCSV::getAverage));		
		return sort(compareByAverage, iplAnalyzerObject.iplBowlingDataList).map(player -> player.getAverage()).toArray(size -> new Double[size]);
	}

	public Double[] getTopBowlingStrikeRates() throws IPLException {
		// TODO Auto-generated method stub
		return null;
	}
}
