package com.bestv.corefilter.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileUtil {
	
	public static void createDir(String path) throws IOException{
		File f = new File(path);
		if(!f.exists() && !f.isDirectory()){
			f.mkdirs();
		}
	}
	
	public static boolean checkFileOrDirExists(String path){
		File f = new File(path);
		return f.exists();
	}
	
	public static void writeStringToFile(String filePath, String text) throws Exception {
		BufferedWriter wb = null;
		try {
			wb = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
					new File(filePath))));
			wb.write(text);
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if(wb != null){
					wb.flush();
					wb.close();
				}
			} catch (Exception e2) {
			}
		}
	}
	
	public static void writeStringListToFile(String filePath, List<String> texts, boolean isAppend) throws Exception {
		BufferedWriter wb = null;
		try {
			wb = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
					new File(filePath) , isAppend)));
			Iterator<String> iter =  texts.iterator();
			while(iter.hasNext()){
				wb.append(iter.next());
				wb.newLine();
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if(wb != null){
					wb.flush();
					wb.close();
				}
			} catch (Exception e2) {
			}
		}
	}

	public static List<String> getLinesFromFile(String path) throws IOException {
		List<String> lines = new ArrayList<String>();
		File file = new File(path);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String line = "";
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				if (!"".equals(line)) {
					lines.add(line);
				}
			}
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
			}
		}
		return lines;
	}

	public static String getTextFromFile(String path) throws IOException {
		String a = "";
		for (String s : getLinesFromFile(path)) {
			a += s;
		}
		return a;
	}

}
