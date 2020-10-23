package com.bridgelabz.iplleagueanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IPLBowlers {

	@CsvBindByName(column = "POS", required = true)
	int pos;
	@CsvBindByName(column = "PLAYER", required = true)
	String playerName;
	@CsvBindByName(column = "Mat", required = true)
	int matches;
	@CsvBindByName(column = "Inns", required = true)
	int innings;
	@CsvBindByName(column = "Ov", required = true)
	double overs;
	@CsvBindByName(column = "Runs", required = true)
	int runs;
	@CsvBindByName(column = "Wkts", required = true)
	int wickets;
	@CsvBindByName(column = "BBI", required = true)
	int bestBowling;
	@CsvBindByName(column = "Avg", required = true)
	String average;
	@CsvBindByName(column = "Econ", required = true)
	double economy;
	@CsvBindByName(column = "SR", required = true)
	String strikeRate;
	@CsvBindByName(column = "4w", required = true)
	int fourWickets;
	@CsvBindByName(column = "5w", required = true)
	int fiveWickets;

	public IPLBowlers() {
	}

	public int getPos() {
		return pos;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int getMatches() {
		return matches;
	}

	public int getInnings() {
		return innings;
	}

	public double getOvers() {
		return overs;
	}

	public int getRuns() {
		return runs;
	}

	public int getWickets() {
		return wickets;
	}

	public int getBestBowling() {
		return bestBowling;
	}

	public double getAverage() {
		if (average.equals("-"))
			return 200.0;
		else
			return Double.parseDouble(average);
	}

	public double getEconomy() {
		return economy;
	}

	public double getStrikeRate() {
		if (strikeRate.equals("-"))
			return 200.0;
		else
			return Double.parseDouble(strikeRate);
	}

	public int getFourWickets() {
		return fourWickets;
	}

	public int getFiveWickets() {
		return fiveWickets;
	}

	public int getFourAndFiveWickets() {
		return ((5 * fiveWickets) + (4 * fourWickets));
	}
}
