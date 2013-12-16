package com.bestv.corefilter.bean;

import java.util.LinkedList;

public class Filter {
	
	private String filterName;
	
	private int mainVersion;
	
	private int subVersion;
	
	private PinIn pinIn;
	
	private LinkedList<PinOut> pinOutList;

	public Filter() {
	}
	
	public Filter(String filterName, int mainVersion, int subVersion) {
		this.filterName = filterName;
		this.mainVersion = mainVersion;
		this.subVersion = subVersion;
	}
	
	public void addPinIn(int pinLevel , String pinName){
		this.pinIn = new PinIn(null , null, pinLevel, pinName);
	}
	
	public void addPinOut(int pinLevel , String pinName){
		getPinOutList().add(new PinOut(null ,null, pinLevel, pinName));
	}
	
	public void setLastPinIn(String filterFrom , String pinFrom , Integer pinLevel , String pinName , Parameter parameter){
		if(filterFrom != null)
			getPinIn().setFilterFrom(filterFrom);
		if(pinFrom != null)
			getPinIn().setPinFrom(pinFrom);
		if(pinLevel != null)
			getPinIn().setPinLevel(pinLevel);
		if(pinName != null)
			getPinIn().setPinName(pinName);
		if(parameter!=null)
			getPinIn().addParameter(parameter);
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

	public LinkedList<PinOut> getPinOutList() {
		if(pinOutList == null)
			pinOutList = new LinkedList<PinOut>();
		return pinOutList;
	}

	public PinIn getPinIn() {
		if(this.pinIn == null)
			this.pinIn = new PinIn();
		return pinIn;
	}

	public void setPinIn(PinIn pinIn) {
		this.pinIn = pinIn;
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
