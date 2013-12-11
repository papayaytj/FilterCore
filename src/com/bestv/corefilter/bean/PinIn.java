package com.bestv.corefilter.bean;

public class PinIn extends Pin{
	private String filterFrom;
	private String pinFrom;

	public PinIn() {
		super();
	}
	
	public PinIn(String filterFrom , int pinLevel , String pinName) {
		super(pinName, pinLevel);
		this.filterFrom = filterFrom;
	}
	

	public PinIn(String filterFrom, String pinFrom, int pinLevel , String pinName) {
		super(pinName, pinLevel);
		this.filterFrom = filterFrom;
		this.pinFrom = pinFrom;
	}

	public String getFilterFrom() {
		return filterFrom;
	}

	public void setFilterFrom(String filterFrom) {
		this.filterFrom = filterFrom;
	}

	public String getPinFrom() {
		return pinFrom;
	}

	public void setPinFrom(String pinFrom) {
		this.pinFrom = pinFrom;
	}
	
}
