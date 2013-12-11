package com.bestv.corefilter.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtil{
	
	private static String LOG_FORMAT = "[%s] - %s - %s : %s";
	private static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void debug(String target , String text){
		log(target , text , "DEBUG");
	}
	
	public static void info(String target , String text){
		log(target , text , "INFO");
	}
	
	public static void warn(String target , String text){
		log(target , text , "WARN");
	}
	
	public static void error(String target , String text){
		log(target , text , "ERROR");
	}
	
	public static void log(String target , String text , String level){
		System.out.println(String.format(LOG_FORMAT, SDF.format(new Date()) , target , level , text));
	}
	
	
}
