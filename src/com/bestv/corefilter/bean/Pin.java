package com.bestv.corefilter.bean;

import java.util.ArrayList;
import java.util.List;

public class Pin {
	
	protected List<Parameter> list;
	protected String pinName;
	protected int pinLevel;
	
	public Pin() {
	}
	
	public Pin(String pinName, int pinLevel) {
		this.pinName = pinName;
		this.pinLevel = pinLevel;
	}
	
	public void addParameter(String key , String value , String type){
		Parameter p = new Parameter(key, value, type);
		List<Parameter> thisList = getList();
		thisList.add(p);
	};
	
	public boolean setParameter(String key , String value){
		for(Parameter p : getList()){
			if(p.getKey().equals(key)){
				p.setValue(value);
				return true;
			}
		}
		return false;
	}
	
	public void addParameter(Parameter p){
		getList().add(p);
	};

	public List<Parameter> getList() {
		if(list == null)
			list = new ArrayList<Parameter>();
		return list;
	}
	
	public String[] getParameterKeys(){
		String[] arr = new String[getList().size()];
		for(int i = 0 ; i< arr.length ; i++){
			arr[i] = getList().get(i).getKey();
		}
		return arr;
	}
	
	public String[] getParameterValues(){
		String[] arr = new String[getList().size()];
		for(int i = 0 ; i< arr.length ; i++){
			arr[i] = getList().get(i).getValue();
		}
		return arr;
	}

	public String getPinName() {
		return pinName;
	}

	public void setPinName(String pinName) {
		this.pinName = pinName;
	}

	public int getPinLevel() {
		return pinLevel;
	}

	public void setPinLevel(int pinLevel) {
		this.pinLevel = pinLevel;
	}

}
