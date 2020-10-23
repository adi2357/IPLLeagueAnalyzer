package com.bridgelabz.players;

public class IPLAllRounder {

	String playerName;
	double battingAverage;
	double bowlingAverage;
	int runs;
	int wickets;

	public IPLAllRounder(String playerName, double battingAverage, double bowlingAverage, int runs, int wickets) {
		this.playerName = playerName;
		this.battingAverage = battingAverage;
		this.bowlingAverage = bowlingAverage;
		this.runs = runs;
		this.wickets = wickets;
	}

	public String getPlayerName() {
		return playerName;
	}

	public double getBattingAverage() {
		return battingAverage;
	}

	public double getBowlingAverage() {
		return bowlingAverage;
	}

	public int getRuns() {
		return runs;
	}

	public int getWickets() {
		return wickets;
	}

	public double getPerformanceByAverage() {
		return (this.battingAverage + 200 - this.bowlingAverage);
	}

	@Override
	public String toString() {
		return "IPLAllRounder [playerName=" + playerName + ", battingAverage=" + battingAverage + ", bowlingAverage="
				+ bowlingAverage + ", runs=" + runs + ", wickets=" + wickets + "]";
	}
}
