package com.bridgelabz.interfaces;

import com.bridgelabz.exception.IPLException;

public interface IIPLAnalyzer {
		
	public void readBattingCSVData() throws IPLException;

	public void readBowlingCSVData() throws IPLException;

	public void readAllRounderData() throws IPLException;

}
