package com.bestv.corefilter.control;

import static com.bestv.corefilter.util.LogUtil.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bestv.corefilter.GlobalSettings;
import com.bestv.corefilter.bean.Filter;
import com.bestv.corefilter.bean.Gragh;
import com.bestv.corefilter.bean.Parameter;
import com.bestv.corefilter.util.FileUtil;

public class GraghControl {
	
	private static String logTitle = "GraghControl";
	
	public static Gragh createGragh(String graghName){
	
		List<String> lines = null;
		
		try {
			lines = FileUtil.getLinesFromFile(GlobalSettings.GRAGH_PACKAGE + "/" + graghName + GlobalSettings.GRAGH_SUFFIX);
		} catch (Exception e) {
			error(logTitle , e.getMessage());
		}
		Gragh g = new Gragh();
		for(String line : lines){
			if(line != null && line.trim().length() > 0){
				line = line.trim();
//				debug(logTitle , "readline:" + line);
				if(line.startsWith("@LPGSTART")){
					continue;
				}else if(line.startsWith("@LPGVERSION")){
					continue;
				}else if(line.startsWith("@LPG-FILTER:")){
//					debug(logTitle , "get FILTER");
					Pattern p = Pattern.compile("@LPG-FILTER:(.*),(\\d),(\\d)");
					Matcher m = p.matcher(line);
					if(m.matches()){
						info(logTitle , m.group(1));
						String filterName = m.group(1);
						int mVersion = Integer.parseInt(m.group(2));
						int sVersion = Integer.parseInt(m.group(3));
						debug(logTitle , "create FILTER");
						g.createFilter(filterName, mVersion, sVersion);
					}
					else
						warn(logTitle , "match " + line + " with @LPG-FILTER failed");
				}else if(line.startsWith("@LPG-INPIN:")){
					Pattern p = Pattern.compile("@LPG-INPIN:(.*),(.*)");
					Matcher m = p.matcher(line);
					if(m.matches()){
						Filter f = g.getLastFilter();
						int pinLevel = Integer.parseInt(m.group(1));
						String pinName = m.group(2);
						f.addPinIn(pinLevel, pinName);
					}else{
						warn(logTitle , "match " + line + " with @LPG-INPIN failed ");
					}
				}else if(line.startsWith("@LPG-INPIN-FROM:")){
					//@LPG-INPIN-FROM:source_v1,op1
					Pattern p = Pattern.compile("@LPG-INPIN-FROM:(.*),(.*)");
					Matcher m = p.matcher(line);
					if(m.matches()){
						Filter f = g.getLastFilter();
						String filterName = m.group(1);
						String pinName = m.group(2);
						f.setLastPinIn(filterName, pinName , null , null , null);
					}else{
						warn(logTitle , "match " + line + " with @LPG-INPIN-FROM failed");
					}
				}else if(line.startsWith("@LPG-INPIN-PARAM:")){
					Pattern p = Pattern.compile("@LPG-INPIN-PARAM:(\\d),(.*),(.*)");
					Matcher m = p.matcher(line);
					if(m.matches()){
						Filter f = g.getLastFilter();
						String paraName = m.group(2);
						String paraType = m.group(3);
						Parameter para = new Parameter(paraName , null , paraType);
						f.setLastPinIn(null, null , null , null , para);
					}else{
						warn(logTitle , "match " + line + " with @LPG-INPIN-FROM failed");
					}
				}else if(line.startsWith("@LPG-OUTPIN:")){
					Pattern p = Pattern.compile("@LPG-OUTPIN:(.*),(.*)");
					Matcher m = p.matcher(line);
					if(m.matches()){
						Filter f = g.getLastFilter();
						int pinLevel = Integer.parseInt(m.group(1));
						String pinName = m.group(2);
						f.addPinOut(pinLevel, pinName);
					}else{
						warn(logTitle , "match " + line + " with @LPG-OUTPIN failed");
					}
				}else if(line.startsWith("@LPG-OUTPIN-TO:")){
					Pattern p = Pattern.compile("@LPG-OUTPIN-TO:(.*),(.*)");
					Matcher m = p.matcher(line);
					if(m.matches()){
						Filter f = g.getLastFilter();
						String filterName = m.group(1);
						String pinName = m.group(2);
						f.setLastPinOut(filterName, pinName , null , null , null);
					}else{
						warn(logTitle , "match " + line + " with @LPG-INPIN-FROM failed");
					}
				}else if(line.startsWith("@LPG-OUTPIN-PARAM:")){
					Pattern p = Pattern.compile("@LPG-OUTPIN-PARAM:(\\d),(.*),(.*)");
					Matcher m = p.matcher(line);
					if(m.matches()){
						Filter f = g.getLastFilter();
						String paraName = m.group(2);
						String paraType = m.group(3);
						Parameter para = new Parameter(paraName , null , paraType);
						f.setLastPinOut(null, null , null , null , para);
					}else{
						warn(logTitle , "match " + line + " with @LPG-OUTPIN-FROM failed");
					}
				}else if(line.startsWith("@LPGEND")){
					break;
				}
			}
		}
		return g;
	}
	
}
