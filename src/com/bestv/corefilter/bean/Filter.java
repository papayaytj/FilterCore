package com.bestv.corefilter.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Filter {
	
	private String filterName;
	
	private int mainVersion;
	
	private int subVersion;
	
	private LinkedList<PinIn> pinInList;
	
	private LinkedList<PinOut> pinOutList;

	public Filter() {
	}
	
	public Filter(String filterName, int mainVersion, int subVersion) {
		this.filterName = filterName;
		this.mainVersion = mainVersion;
		this.subVersion = subVersion;
	}
	
	public void addPinIn(int pinLevel , String pinName){
		getPinInList().add(new PinIn(null , null, pinLevel, pinName));
	}
	
	public void addPinOut(int pinLevel , String pinName){
		getPinOutList().add(new PinOut(null ,null, pinLevel, pinName));
	}
	
	public void setLastPinIn(String filterFrom , String pinFrom , Integer pinLevel , String pinName , Parameter parameter){
		if(filterFrom != null)
			getPinInList().getLast().setFilterFrom(filterFrom);
		if(pinFrom != null)
			getPinInList().getLast().setPinFrom(pinFrom);
		if(pinLevel != null)
			getPinInList().getLast().setPinLevel(pinLevel);
		if(pinName != null)
			getPinInList().getLast().setPinName(pinName);
		if(parameter!=null)
			getPinInList().getLast().addParameter(parameter);
	}
	
	public void setLastPinOut(String filterTo , String pinTo , Integer pinLevel , String pinName , Parameter parameter){
		if(filterTo != null)
			getPinOutList().getLast().setFilterTo(filterTo);
		if(pinTo != null)
			getPinOutList().getLast().setPinTo(pinTo);
		if(pinLevel != null)
			getPinOutList().getLast().setPinLevel(pinLevel);
		if(pinName != null)
			getPinOutList().getLast().setPinName(pinName);
		if(parameter!=null)
			getPinOutList().getLast().addParameter(parameter);
	}
	
//	public void setLastPin(LinkedList<Pin> list, Integer pinLevel , String pinName , Parameter parameter){
//		if(pinLevel != null)
//			list.getLast().setPinLevel(pinLevel);
//		if(pinName != null)
//			list.getLast().setPinName(pinName);
//		if(parameter!=null)
//			getPinInList().getLast().addParameter(parameter);
//	}

	public LinkedList<PinIn> getPinInList() {
		if(pinInList == null)
			pinInList = new LinkedList<PinIn>();
		return pinInList;
	}

	public LinkedList<PinOut> getPinOutList() {
		if(pinOutList == null)
			pinOutList = new LinkedList<PinOut>();
		return pinOutList;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public int getMainVersion() {
		return mainVersion;
	}

	public void setMainVersion(int mainVersion) {
		this.mainVersion = mainVersion;
	}

	public int getSubVersion() {
		return subVersion;
	}

	public void setSubVersion(int subVersion) {
		this.subVersion = subVersion;
	}
	
}
