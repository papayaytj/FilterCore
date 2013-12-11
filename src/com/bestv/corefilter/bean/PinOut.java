package com.bestv.corefilter.bean;

public class PinOut extends Pin{
	private String filterTo;
	private String pinTo;

	public PinOut() {
		super();
	}

	public PinOut(String filterTo , int pinLevel , String pinName) {
		super(pinName, pinLevel);
		this.filterTo = filterTo;
	}

	public PinOut(String filterTo, String pinTo, int pinLevel , String pinName) {
		super(pinName, pinLevel);
		this.filterTo = filterTo;
		this.pinTo = pinTo;
	}

	public String getFilterTo() {
		return filterTo;
	}

	public void setFilterTo(String filterTo) {
		this.filterTo = filterTo;
	}

	public String getPinTo() {
		return pinTo;
	}

	public void setPinTo(String pinTo) {
		this.pinTo = pinTo;
	}

}
