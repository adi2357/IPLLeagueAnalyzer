package com.bridgelabz.interfaces;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.bridgelabz.exception.IPLException;

public interface IOperations {

	public <E> Stream<E> sort(Comparator<E> iplComparator, List<E> iplDataList, int limit);

	public <E> void checkCSVData(List<E> playerDataList) throws IPLException;
}
