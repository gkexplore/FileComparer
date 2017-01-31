package com.gk.filecomparison;

import java.util.Comparator;

public class FileDataComparator implements Comparator<String> {

	public int compare(String source, String target) {
	    String[] sourceList = source.split("\\|",-1);
	    String[] targetList = target.split("\\|",-1);
	    System.out.println(sourceList[0]+" - "+targetList[0]);
	    return 	sourceList[0].compareTo(targetList[0]);
	}

}
