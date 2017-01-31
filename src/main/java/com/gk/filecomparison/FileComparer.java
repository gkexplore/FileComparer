package com.gk.filecomparison;

import java.io.IOException;
import java.util.Arrays;

public class FileComparer 
{
	private static FileDataComparator fileDataComparator;
	
    public static void main( String[] args ) throws IOException
    {
    	fileDataComparator = new FileDataComparator();
    	FileOperator sourceFile = new FileOperator("TestFile1.txt");
    	FileOperator targetFile = new FileOperator("TestFile2.txt");
    	String src = "";
    	String tgt = "";
    	boolean sourceHasRecord = true;
    	boolean targetHasRecord = true;
    	boolean srcHasScroll = true;
    	boolean tgtHasScroll = true;
    	
        while(true){
        	if(srcHasScroll){
            	if((src=sourceFile.getReader().readLine())==null){
            		sourceHasRecord = false;
            	}
        	}
        	if(tgtHasScroll){
        		if((tgt=targetFile.getReader().readLine())==null){
            		targetHasRecord = false;
            	}
        	}

        	if(!sourceHasRecord || !targetHasRecord) 
        		break;
        	
        	int comparissonResult =  fileDataComparator.compare(src, tgt);
        	
        	if(comparissonResult==0){
        		System.out.println("Data matched!!");
        		System.out.println(src + " " + tgt);
        		String[] sourceRecord = src.split("\\|",-1);
        		String[] targetRecord = tgt.split("\\|",-1);
        		for(int i=1;i<sourceRecord.length;i++){
        			if(!sourceRecord[i].equalsIgnoreCase(targetRecord[i])){
        				System.out.println("Data mismatched:"+Arrays.toString(sourceRecord)+"-"+Arrays.toString(targetRecord));
        			}
        		}
        		srcHasScroll = true;
        		tgtHasScroll = true;
        	}else if(comparissonResult<0){
        		System.out.println("Target missing!!");
        		System.out.println(src + " " + tgt);
        		srcHasScroll = true;
        		tgtHasScroll = false;
        	}else{
        		System.out.println("Source missing!!");
        		System.out.println(src + " " + tgt);
        		srcHasScroll = false;
        		tgtHasScroll = true;
        	}
        }
        if(src!=null){
        	do{
            	System.out.println("missing in target");
            	System.out.println(src + " " + tgt);
        	}while((src=sourceFile.getReader().readLine())!=null);
        }
        
        if(tgt!=null){
        	do{
            	System.out.println("missing in source");
            	System.out.println(src + " " + tgt);
        	}while((tgt=targetFile.getReader().readLine())!=null);
        }
    }
}
