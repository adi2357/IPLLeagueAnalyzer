package com.bridgelabz.operations;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bridgelabz.analyzer.IPLAnalyzer;
import com.bridgelabz.exception.IPLException;
import com.bridgelabz.players.IPLAllRounder;
import com.bridgelabz.players.IPLBatsmen;
import com.bridgelabz.players.IPLBowlers;

public class IPLOperations {
	IPLAnalyzer iplAnalyzerObject;

	public IPLOperations(IPLAnalyzer iplAnalyzerObject) {
		this.iplAnalyzerObject = iplAnalyzerObject;
	}

	public Double[] getBestBattingAverage() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		Comparator<IPLBatsmen> compareByAverage = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getAverage));
		return sort(compareByAverage, iplAnalyzerObject.iplBattingList, 5).map(player -> player.getAverage()).toArray(size -> new Double[size]);
	}

	public Double[] getTopBattingStrikeRates() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		Comparator<IPLBatsmen> compareByStrikeRate = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getStrikeRate));		
		return sort(compareByStrikeRate, iplAnalyzerObject.iplBattingList, 5).map(player -> player.getStrikeRate()).toArray(size -> new Double[size]);
	}

	public String[] getBatsmenWithMaximumSixes() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		Comparator<IPLBatsmen> compareBySixes = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getSixes));		
		return sort(compareBySixes, iplAnalyzerObject.iplBattingList, 5).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumFours() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		Comparator<IPLBatsmen> compareByFours = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getFours))
															  .thenComparing(Comparator.comparing(IPLBatsmen::getPlayerName));
		return sort(compareByFours, iplAnalyzerObject.iplBattingList, 5).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumBoundaries() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		Comparator<IPLBatsmen> compareByFours = Comparator.comparing(IPLBatsmen::getBoundaries).reversed();
		return sort(compareByFours, iplAnalyzerObject.iplBattingList, 5).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithBestStrikeRatesAndMaximumBoundaries() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		Comparator<IPLBatsmen> compareByStrikeRates = Comparator.comparing(IPLBatsmen::getStrikeRate).reversed();
		List<IPLBatsmen> battingListSortedByStrikeRates = sort(compareByStrikeRates, iplAnalyzerObject.iplBattingList, 5).collect(Collectors.toList());
		Comparator<IPLBatsmen> compareByBoundaries = Comparator.comparing(IPLBatsmen::getBoundaries).reversed();
		return sort(compareByBoundaries, battingListSortedByStrikeRates, 5).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithBestAveragesWithBestStrikeRates() throws IPLException{
		checkCSVData(iplAnalyzerObject.iplBattingList);
		Comparator<IPLBatsmen> compareByAverage = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getAverage));
		List<IPLBatsmen> battingListSortedByBestAverages = sort(compareByAverage, iplAnalyzerObject.iplBattingList, 5).collect(Collectors.toList());
		Comparator<IPLBatsmen> compareByStrikeRates = Comparator.comparing(IPLBatsmen::getStrikeRate).reversed();
		return sort(compareByStrikeRates, battingListSortedByBestAverages, 5).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumRunsWithBestAverages() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		Comparator<IPLBatsmen> compareByRuns = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getRuns));
		List<IPLBatsmen> battingListSortedByMaximumRuns = sort(compareByRuns, iplAnalyzerObject.iplBattingList, 5).collect(Collectors.toList());
		Comparator<IPLBatsmen> compareByAverage = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getAverage));
		return sort(compareByAverage, battingListSortedByMaximumRuns, 5).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public <E> Stream<E> sort(Comparator<E> iplComparator, List<E> iplDataList, int limit){
		return iplDataList.stream().sorted(iplComparator).limit(limit);
	}

	public <E> void checkCSVData(List<E> playerDataList) throws IPLException {
		if(playerDataList == null || playerDataList.size() ==0)
			throw new IPLException("Player data list is empty", IPLException.ExceptionType.NO_CSV_DATA);
	}

	public Double[] getBestBowlingAverage() throws IPLException{
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		Comparator<IPLBowlers> compareByAverage = Comparator.comparing(IPLBowlers::getAverage);		
		return sort(compareByAverage, iplAnalyzerObject.iplBowlingList, 5).map(player -> player.getAverage()).toArray(size -> new Double[size]);
	}

	public Double[] getTopBowlingStrikeRates() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		Comparator<IPLBowlers> compareByStrikeRate = Comparator.comparing(IPLBowlers::getStrikeRate).thenComparing(Comparator.comparing(IPLBowlers::getPlayerName));
		return sort(compareByStrikeRate, iplAnalyzerObject.iplBowlingList, 5).map(player -> player.getStrikeRate()).toArray(size -> new Double[size]);
	}

	public String[] getBowlersWithBestEconomy() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		Comparator<IPLBowlers> compareByEconomy = Comparator.comparing(IPLBowlers::getEconomy);
		return sort(compareByEconomy, iplAnalyzerObject.iplBowlingList, 5).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBowlersWithBestStrikeRatesWithFourAndFiveWickets() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		Comparator<IPLBowlers> compareByStrikeRate = Comparator.comparing(IPLBowlers::getStrikeRate);
		Comparator<IPLBowlers> compareByFourAndFiveWickets = Comparator.comparing(IPLBowlers::getFourAndFiveWickets).reversed();
		Comparator<IPLBowlers> compareByStrikeRateAnd4wAnd5w = compareByFourAndFiveWickets.thenComparing(compareByStrikeRate);
		return sort(compareByStrikeRateAnd4wAnd5w, iplAnalyzerObject.iplBowlingList, 5).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBowlersWithBestAveragesAndBestStrikeRates() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		Comparator<IPLBowlers> compareByAverage = Comparator.comparing(IPLBowlers::getAverage);
		List<IPLBowlers> bowlerListSortedByAverage = sort(compareByAverage, iplAnalyzerObject.iplBowlingList, 5).collect(Collectors.toList());
		Comparator<IPLBowlers> compareByStrikeRate = Comparator.comparing(IPLBowlers::getStrikeRate).thenComparing(IPLBowlers::getPlayerName);
		return sort(compareByStrikeRate, bowlerListSortedByAverage, 5).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBowlersWithMaximumWicketsAndBestAverages() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		Comparator<IPLBowlers> compareByWickets = Collections.reverseOrder(Comparator.comparing(IPLBowlers::getWickets)).thenComparing(IPLBowlers::getPlayerName);
		List<IPLBowlers> bowlerListSortedByWickets = sort(compareByWickets, iplAnalyzerObject.iplBowlingList, 5).collect(Collectors.toList());
		Comparator<IPLBowlers> compareByAverage = Comparator.comparing(IPLBowlers::getAverage);
		return sort(compareByAverage, bowlerListSortedByWickets, 5).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getCricketersWithBestBattingAndBowlingAverages() throws IPLException{
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		checkCSVData(iplAnalyzerObject.iplBattingList);
		checkCSVData(iplAnalyzerObject.iplAllRounderList);
		Comparator<IPLAllRounder> compareByAveragePerformance = Collections.reverseOrder(Comparator.comparing(IPLAllRounder::getPerformanceByAverage));
		return sort(compareByAveragePerformance, iplAnalyzerObject.iplAllRounderList, 5).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getCricketersWithMostRunsAndWickets() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		checkCSVData(iplAnalyzerObject.iplBattingList);
		checkCSVData(iplAnalyzerObject.iplAllRounderList);		
		Comparator<IPLAllRounder> compareByRunsAndWicketPerformance = Collections.reverseOrder(Comparator.comparing(IPLAllRounder::getPerformanceByRunsAndWickets));
		return sort(compareByRunsAndWicketPerformance, iplAnalyzerObject.iplAllRounderList, 5).map(player -> player.getPlayerName()).toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumHundredsAndBestAverages() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		Comparator<IPLBatsmen> compareByHundreds = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getHundres));
		List<IPLBatsmen> battingListSortedByHundreds = sort(compareByHundreds, iplAnalyzerObject.iplBattingList, 5).collect(Collectors.toList());
		Comparator<IPLBatsmen> compareByAverage = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getAverage));
		return sort(compareByAverage, battingListSortedByHundreds, 5).map(player -> player .getPlayerName()).toArray(size -> new String[size]);
	}
}
