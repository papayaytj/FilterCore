package com.bestv.corefilter.bean;

import java.util.LinkedList;

public class Gragh {
	
	private LinkedList<Filter> filters;

	public LinkedList<Filter> getFilters() {
		if(filters == null){
			filters = new LinkedList<Filter>();
		}
		return filters;
	}
	
	public void createFilter(String filterName , int mVersion , int sVersion){
		getFilters().addLast(new Filter(filterName, mVersion, sVersion));
	}
	
	public Filter getFirstFilter(){
		return getFilters().getFirst();
	}
	
	public Filter getLastFilter(){
		return getFilters().getLast();
	}
	
	public Filter getFilterByName(String filterName){
		for(Filter f : getFilters()){
			if(f.getFilterName().equals(filterName)){
				return f;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String s = "";
		String tab = "    ";
		System.out.println("f:" + filters);
		for(Filter f : filters){
			s += f.getFilterName() + "/" + f.getMainVersion() + "/" + f.getSubVersion() ;
			s += "\n";
			PinIn pIn = f.getPinIn();
				s += tab  + pIn.getFilterFrom() + "/" + pIn.getPinFrom() + "/" + pIn.getPinLevel() + "/" + pIn.getPinName();
				s += "\n";
				for(Parameter pa : pIn.getList()){
					s += tab + tab + pa.getKey() + "/" + pa.getValue() + "/" + pa.getType();
					s += "\n";
				}
			for(PinOut p : f.getPinOutList()){
				s += tab  + p.getFilterTo() + "/" + p.getPinTo() + "/" + p.getPinLevel() + "/" + p.getPinName();
				s += "\n";
				for(Parameter pa : p.getList()){
					s += tab + tab + pa.getKey() + "/" + pa.getValue() + "/" + pa.getType();
					s += "\n";
				}
			}
		}
		s += "\n";
		return s;
	}
}
