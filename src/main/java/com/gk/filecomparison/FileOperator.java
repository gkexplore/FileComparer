package com.gk.filecomparison;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileOperator {
	
	private String fileName;
	private BufferedReader bufferedReader;
	
	FileOperator(String fileName) throws FileNotFoundException{
		this.fileName = fileName;
		this.bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
	}
	
	public BufferedReader getReader(){
		return this.bufferedReader;
	}
	
}
