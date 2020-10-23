package com.bridgelabz.players;

import com.opencsv.bean.CsvBindByName;

public class IPLBatsmen {

	@CsvBindByName(column = "POS", required = true)
	int pos;
	@CsvBindByName(column = "PLAYER", required = true)
	String playerName;
	@CsvBindByName(column = "Mat", required = true)
	int matches;
	@CsvBindByName(column = "Inns", required = true)
	int innings;
	@CsvBindByName(column = "NO", required = true)
	int notOuts;
	@CsvBindByName(column = "Runs", required = true)
	int runs;
	@CsvBindByName(column = "HS", required = true)
	String highestScore;
	@CsvBindByName(column = "Avg", required = true)
	String average;
	@CsvBindByName(column = "BF", required = true)
	int ballsFetched;
	@CsvBindByName(column = "SR", required = true)
	double strikeRate;
	@CsvBindByName(column = "100", required = true)
	int hundres;
	@CsvBindByName(column = "50", required = true)
	int fifties;
	@CsvBindByName(column = "4s", required = true)
	int fours;
	@CsvBindByName(column = "6s", required = true)
	int sixes;

	public IPLBatsmen() {
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

	public int getNotOuts() {
		return notOuts;
	}

	public int getRuns() {
		return runs;
	}

	public String getHighestScore() {
		return highestScore;
	}

	public Double getAverage() {
		if (average.equals("-"))
			return 0.0;
		else
			return Double.parseDouble(average);
	}

	public int getBallsFetched() {
		return ballsFetched;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public int getHundres() {
		return hundres;
	}

	public int getFifties() {
		return fifties;
	}

	public int getFours() {
		return fours;
	}

	public int getSixes() {
		return sixes;
	}

	public int getBoundaries() {
		return (sixes + fours);
	}

}
