package com.bridgelabz.iplleagueanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IPLBattingCSV {

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
	
	
	public IPLBattingCSV() {
	}


	public int getPos() {
		return pos;
	}


	public void setPos(int pos) {
		this.pos = pos;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public int getMatches() {
		return matches;
	}


	public void setMatches(int matches) {
		this.matches = matches;
	}


	public int getInnings() {
		return innings;
	}


	public void setInnings(int innings) {
		this.innings = innings;
	}


	public int getNotOuts() {
		return notOuts;
	}


	public void setNotOuts(int notOuts) {
		this.notOuts = notOuts;
	}


	public int getRuns() {
		return runs;
	}


	public void setRuns(int runs) {
		this.runs = runs;
	}


	public String getHighestScore() {
		return highestScore;
	}


	public void setHighestScore(String highestScore) {
		this.highestScore = highestScore;
	}


	public Double getAvgerage() {
		if(average.equals("-"))
			return 0.0;
		else
			return Double.parseDouble(average);
	}


	public void setAverage(String average) {
		this.average = average;
	}


	public int getBallsFetched() {
		return ballsFetched;
	}


	public void setBallsFetched(int ballsFetched) {
		this.ballsFetched = ballsFetched;
	}


	public double getStrikeRate() {
		return strikeRate;
	}


	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}


	public int getHundres() {
		return hundres;
	}


	public void setHundres(int hundres) {
		this.hundres = hundres;
	}


	public int getFifties() {
		return fifties;
	}


	public void setFifties(int fifties) {
		this.fifties = fifties;
	}


	public int getFours() {
		return fours;
	}


	public void setFours(int fours) {
		this.fours = fours;
	}


	public int getSixes() {
		return sixes;
	}


	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	
}
