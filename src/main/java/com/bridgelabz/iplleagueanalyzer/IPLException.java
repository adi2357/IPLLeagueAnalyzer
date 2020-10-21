package com.bridgelabz.iplleagueanalyzer;

public class IPLException extends Exception{

	public enum ExceptionType{
		INVALID_STATE, INVALID_IO, INVALID_FILE
	}
	ExceptionType type;
	
	public IPLException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}