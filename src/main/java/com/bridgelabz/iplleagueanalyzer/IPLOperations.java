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
		if(iplAnalyzerObject.iplBattingList == null || iplAnalyzerObject.iplBattingList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
	
		Comparator<IPLBatsmen> compareByAverage = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getAvgerage));
		return sort(compareByAverage, iplAnalyzerObject.iplBattingList).map(player -> player.getAvgerage()).toArray(size -> new Double[size]);
	}

	public Double[] getTopBattingStrikeRates() throws IPLException {
		if(iplAnalyzerObject.iplBattingList == null || iplAnalyzerObject.iplBattingList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
	
		Comparator<IPLBatsmen> compareByStrikeRate = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getStrikeRate));		
		return sort(compareByStrikeRate, iplAnalyzerObject.iplBattingList).map(player -> player.getStrikeRate()).toArray(size -> new Double[size]);
	}

	public String[] getBatsmenWithMaximumSixes() throws IPLException {
		if(iplAnalyzerObject.iplBattingList == null || iplAnalyzerObject.iplBattingList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
	
		Comparator<IPLBatsmen> compareBySixes = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getSixes));		
		return sort(compareBySixes, iplAnalyzerObject.iplBattingList).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumFours() throws IPLException {
		if(iplAnalyzerObject.iplBattingList == null || iplAnalyzerObject.iplBattingList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
	
		Comparator<IPLBatsmen> compareByFours = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getFours))
															  .thenComparing(Comparator.comparing(IPLBatsmen::getPlayerName));
		return sort(compareByFours, iplAnalyzerObject.iplBattingList).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumBoundaries() throws IPLException {
		if(iplAnalyzerObject.iplBattingList == null || iplAnalyzerObject.iplBattingList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
	
		Comparator<IPLBatsmen> compareByFours = Comparator.comparing(IPLBatsmen::getBoundaries).reversed();
		return sort(compareByFours, iplAnalyzerObject.iplBattingList).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithBestStrikeRatesAndMaximumBoundaries() throws IPLException {
		if(iplAnalyzerObject.iplBattingList == null || iplAnalyzerObject.iplBattingList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
	
		Comparator<IPLBatsmen> compareByStrikeRates = Comparator.comparing(IPLBatsmen::getStrikeRate).reversed();
		List<IPLBatsmen> battingListSortedByStrikeRates = sort(compareByStrikeRates, iplAnalyzerObject.iplBattingList).collect(Collectors.toList());
		Comparator<IPLBatsmen> compareByBoundaries = Comparator.comparing(IPLBatsmen::getBoundaries).reversed();
		return sort(compareByBoundaries, battingListSortedByStrikeRates).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithBestAveragesWithBestStrikeRates() throws IPLException{
		if(iplAnalyzerObject.iplBattingList == null || iplAnalyzerObject.iplBattingList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
	
		Comparator<IPLBatsmen> compareByAverage = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getAvgerage));
		List<IPLBatsmen> battingListSortedByBestAverages = sort(compareByAverage, iplAnalyzerObject.iplBattingList).collect(Collectors.toList());
		Comparator<IPLBatsmen> compareByStrikeRates = Comparator.comparing(IPLBatsmen::getStrikeRate).reversed();
		return sort(compareByStrikeRates, battingListSortedByBestAverages).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumRunsWithBestAverages() throws IPLException {
		if(iplAnalyzerObject.iplBattingList == null || iplAnalyzerObject.iplBattingList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
		
		Comparator<IPLBatsmen> compareByRuns = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getRuns));
		List<IPLBatsmen> battingListSortedByMaximumRuns = sort(compareByRuns, iplAnalyzerObject.iplBattingList).collect(Collectors.toList());
		Comparator<IPLBatsmen> compareByAverage = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getAvgerage));
		return sort(compareByAverage, battingListSortedByMaximumRuns).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public <E> Stream<E> sort(Comparator<E> iplComparator, List<E> iplDataList){
		return iplDataList.stream().sorted(iplComparator).limit(5);
	}

	public Double[] getBestBowlingAverage() throws IPLException{
		if(iplAnalyzerObject.iplBowlingList == null || iplAnalyzerObject.iplBowlingList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
		
		Comparator<IPLBowlers> compareByAverage = Comparator.comparing(IPLBowlers::getAverage);		
		return sort(compareByAverage, iplAnalyzerObject.iplBowlingList).map(player -> player.getAverage()).toArray(size -> new Double[size]);
	}

	public Double[] getTopBowlingStrikeRates() throws IPLException {
		if(iplAnalyzerObject.iplBowlingList == null || iplAnalyzerObject.iplBowlingList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
		
		Comparator<IPLBowlers> compareByStrikeRate = Comparator.comparing(IPLBowlers::getStrikeRate).thenComparing(Comparator.comparing(IPLBowlers::getPlayerName));
		return sort(compareByStrikeRate, iplAnalyzerObject.iplBowlingList).map(player -> player.getStrikeRate()).toArray(size -> new Double[size]);
	}

	public String[] getBowlersWithBestEconomy() throws IPLException {
		if(iplAnalyzerObject.iplBowlingList == null || iplAnalyzerObject.iplBowlingList.size() ==0)
			throw new IPLException("Batting data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
		
		Comparator<IPLBowlers> compareByEconomy = Comparator.comparing(IPLBowlers::getEconomy);
		return sort(compareByEconomy, iplAnalyzerObject.iplBowlingList).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}
}
