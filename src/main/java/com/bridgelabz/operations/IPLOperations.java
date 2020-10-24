package com.bridgelabz.operations;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bridgelabz.analyzer.IPLAnalyzer;
import com.bridgelabz.exception.IPLException;
import com.bridgelabz.interfaces.IOperations;
import com.bridgelabz.players.IPLBatsmen;
import com.bridgelabz.players.IPLBowlers;

public class IPLOperations implements IOperations{
	IPLAnalyzer iplAnalyzerObject;

	public IPLOperations(IPLAnalyzer iplAnalyzerObject) {
		this.iplAnalyzerObject = iplAnalyzerObject;
	}

	public Double[] getBestBattingAverage() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		return sort(IPLComparators.BATSMEN_COMPARE_BY_AVERAGE, iplAnalyzerObject.iplBattingList, 5).map(player -> player.getAverage())
																								   .toArray(size -> new Double[size]);
	}

	public Double[] getTopBattingStrikeRates() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		return sort(IPLComparators.BATSMEN_COMPARE_BY_STRIKE_RATE, iplAnalyzerObject.iplBattingList, 5).map(player -> player.getStrikeRate())
																									   .toArray(size -> new Double[size]);
	}

	public String[] getBatsmenWithMaximumSixes() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		return sort(IPLComparators.BATSMEN_COMPARE_BY_SIXES, iplAnalyzerObject.iplBattingList, 5).map(player -> player.getPlayerName())
																								 .toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumFours() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		return sort(IPLComparators.BATSMEN_COMPARE_BY_FOURS, iplAnalyzerObject.iplBattingList, 5).map(player -> player.getPlayerName())
																								 .toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumBoundaries() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);	
		return sort(IPLComparators.BATSMEN_COMPARE_BY_BOUNDARIES, iplAnalyzerObject.iplBattingList, 5).map(player -> player.getPlayerName())
																									  .toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithBestStrikeRatesAndMaximumBoundaries() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		List<IPLBatsmen> battingListSortedByStrikeRates = sort(IPLComparators.BATSMEN_COMPARE_BY_STRIKE_RATE, iplAnalyzerObject.iplBattingList, 5)
																			 .collect(Collectors.toList());
		return sort(IPLComparators.BATSMEN_COMPARE_BY_BOUNDARIES, battingListSortedByStrikeRates, 5).map(player -> player.getPlayerName())
																									.toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithBestAveragesWithBestStrikeRates() throws IPLException{
		checkCSVData(iplAnalyzerObject.iplBattingList);
		List<IPLBatsmen> battingListSortedByAverage = sort(IPLComparators.BATSMEN_COMPARE_BY_AVERAGE, iplAnalyzerObject.iplBattingList, 5)
																		 .collect(Collectors.toList());
		return sort(IPLComparators.BATSMEN_COMPARE_BY_STRIKE_RATE, battingListSortedByAverage, 5).map(player -> player.getPlayerName())
																								 .toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumRunsWithBestAverages() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);
		List<IPLBatsmen> battingListSortedByMaximumRuns = sort(IPLComparators.BATSMEN_COMPARE_BY_RUNS, iplAnalyzerObject.iplBattingList, 5)
																			 .collect(Collectors.toList());
		return sort(IPLComparators.BATSMEN_COMPARE_BY_AVERAGE, battingListSortedByMaximumRuns, 5).map(player -> player.getPlayerName())
																								 .toArray(size -> new String[size]);
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
		return sort(IPLComparators.BOWLERS_COMPARE_BY_AVERAGE, iplAnalyzerObject.iplBowlingList, 5).map(player -> player.getAverage())
																								   .toArray(size -> new Double[size]);
	}

	public Double[] getTopBowlingStrikeRates() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		return sort(IPLComparators.BOWLERS_COMPARE_BY_STRIKE_RATE, iplAnalyzerObject.iplBowlingList, 5).map(player -> player.getStrikeRate())
																									   .toArray(size -> new Double[size]);
	}

	public String[] getBowlersWithBestEconomy() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		return sort(IPLComparators.BOWLERS_COMPARE_BY_ECONOMY, iplAnalyzerObject.iplBowlingList, 5).map(player -> player.getPlayerName())
																								   .toArray(size -> new String[size]);
	}

	public String[] getBowlersWithBestStrikeRatesWithFourAndFiveWickets() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		return sort(IPLComparators.BOWLERS_COMPARE_BY_FOUR_AND_FIVE_WICKETS_AND_STRIKE_RATE, iplAnalyzerObject.iplBowlingList, 5)
								  .map(player -> player.getPlayerName())
								  .toArray(size -> new String[size]);
	}

	public String[] getBowlersWithBestAveragesAndBestStrikeRates() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		List<IPLBowlers> bowlerListSortedByAverage = sort(IPLComparators.BOWLERS_COMPARE_BY_AVERAGE, iplAnalyzerObject.iplBowlingList, 5)
																		.collect(Collectors.toList());
		return sort(IPLComparators.BOWLERS_COMPARE_BY_STRIKE_RATE, bowlerListSortedByAverage, 5).map(player -> player.getPlayerName())
																								.toArray(size -> new String[size]);
	}

	public String[] getBowlersWithMaximumWicketsAndBestAverages() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		List<IPLBowlers> bowlerListSortedByWickets = sort(IPLComparators.BOWLERS_COMPARE_BY_WICKETS, iplAnalyzerObject.iplBowlingList, 5)
																		.collect(Collectors.toList());
		return sort(IPLComparators.BOWLERS_COMPARE_BY_AVERAGE, bowlerListSortedByWickets, 5).map(player -> player.getPlayerName())
																							.toArray(size -> new String[size]);
	}

	public String[] getCricketersWithBestBattingAndBowlingAverages() throws IPLException{
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		checkCSVData(iplAnalyzerObject.iplBattingList);
		checkCSVData(iplAnalyzerObject.iplAllRounderList);
		return sort(IPLComparators.ALLROUNDERS_COMPARE_BY_AVERAGE_PERFORMANCE, iplAnalyzerObject.iplAllRounderList, 5).map(player -> player.getPlayerName())
																													  .toArray(size -> new String[size]);
	}

	public String[] getCricketersWithMostRunsAndWickets() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBowlingList);
		checkCSVData(iplAnalyzerObject.iplBattingList);
		checkCSVData(iplAnalyzerObject.iplAllRounderList);
		return sort(IPLComparators.ALLROUNDERS_COMPARE_BY_RUNS_AND_WICKET_PERFORMANCE, iplAnalyzerObject.iplAllRounderList, 5).map(player -> player.getPlayerName())
																															  .toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithMaximumHundredsAndBestAverages() throws IPLException {
		checkCSVData(iplAnalyzerObject.iplBattingList);		
		return sort(IPLComparators.BATSMEN_COMPARE_BY_HUNDREDS_AND_AVERAGES, iplAnalyzerObject.iplBattingList, 5).map(player -> player .getPlayerName())
																												 .toArray(size -> new String[size]);
	}

	public String[] getBatsmenWithZeroHundredsAndFiftiesButBestAverages() throws IPLException{
		checkCSVData(iplAnalyzerObject.iplBattingList);
		Predicate<IPLBatsmen> fiteredByZeroHundredAndFifty = player -> (player.getHundres() == 0 && player.getFifties() == 0);
		List<IPLBatsmen> listFilteredByHundredsAndFifties = iplAnalyzerObject.iplBattingList.stream().filter(fiteredByZeroHundredAndFifty).collect(Collectors.toList());
		return sort(IPLComparators.BATSMEN_COMPARE_BY_AVERAGE, listFilteredByHundredsAndFifties, 5).map(player -> player.getPlayerName())
																								   .toArray(size -> new String[size]);
	}
}
