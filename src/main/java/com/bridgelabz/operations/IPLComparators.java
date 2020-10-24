package com.bridgelabz.operations;

import java.util.Collections;
import java.util.Comparator;

import com.bridgelabz.players.IPLAllRounder;
import com.bridgelabz.players.IPLBatsmen;
import com.bridgelabz.players.IPLBowlers;

public class IPLComparators {
//COMPARATORS FOR SORTING BATSMEN
	public static final Comparator<IPLBatsmen> BATSMEN_COMPARE_BY_AVERAGE = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getAverage))
																					   .thenComparing(IPLBatsmen::getPlayerName);
	public static final Comparator<IPLBatsmen> BATSMEN_COMPARE_BY_STRIKE_RATE = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getStrikeRate));
	public static final Comparator<IPLBatsmen> BATSMEN_COMPARE_BY_SIXES = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getSixes));
	public static final Comparator<IPLBatsmen> BATSMEN_COMPARE_BY_FOURS = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getFours))
																		   			 .thenComparing(Comparator.comparing(IPLBatsmen::getPlayerName));
	public static final Comparator<IPLBatsmen> BATSMEN_COMPARE_BY_BOUNDARIES = Comparator.comparing(IPLBatsmen::getBoundaries).reversed();
	public static final Comparator<IPLBatsmen> BATSMEN_COMPARE_BY_RUNS = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getRuns));
	public static final Comparator<IPLBatsmen> BATSMEN_COMPARE_BY_HUNDREDS_AND_AVERAGES = Collections.reverseOrder(Comparator.comparing(IPLBatsmen::getHundres))
			 																						 .thenComparing(Comparator.comparing(IPLBatsmen::getAverage)
			 																						 .reversed());
//COMPARATORS FOR SORTING BOWLERS
	public static final Comparator<IPLBowlers> BOWLERS_COMPARE_BY_AVERAGE = Comparator.comparing(IPLBowlers::getAverage);
	public static final Comparator<IPLBowlers> BOWLERS_COMPARE_BY_STRIKE_RATE = Comparator.comparing(IPLBowlers::getStrikeRate)
																						  .thenComparing(Comparator.comparing(IPLBowlers::getPlayerName));
	public static final Comparator<IPLBowlers> BOWLERS_COMPARE_BY_ECONOMY = Comparator.comparing(IPLBowlers::getEconomy);
	public static final Comparator<IPLBowlers> BOWLERS_COMPARE_BY_FOUR_AND_FIVE_WICKETS_AND_STRIKE_RATE = Comparator.comparing(IPLBowlers::getFourAndFiveWickets)
																													.reversed()
																													.thenComparing(BOWLERS_COMPARE_BY_STRIKE_RATE);
	public static final Comparator<IPLBowlers> BOWLERS_COMPARE_BY_WICKETS = Collections.reverseOrder(Comparator.comparing(IPLBowlers::getWickets))
																			 .thenComparing(IPLBowlers::getPlayerName);
//COMPARATORS FOR SORTING ALLROUNDERS
	public static final Comparator<IPLAllRounder> ALLROUNDERS_COMPARE_BY_AVERAGE_PERFORMANCE = Comparator.comparing(IPLAllRounder::getPerformanceByAverage)
																										 .reversed();
	public static final Comparator<IPLAllRounder> ALLROUNDERS_COMPARE_BY_RUNS_AND_WICKET_PERFORMANCE = Comparator.comparing(IPLAllRounder::getPerformanceByRunsAndWickets)
																												 .reversed();
}
