package com.bestv.corefilter.control;

import static com.bestv.corefilter.util.LogUtil.*;

import com.bestv.corefilter.FilterException;
import com.bestv.corefilter.GlobalSettings;
import com.bestv.corefilter.bean.Filter;
import com.bestv.corefilter.bean.Gragh;
import com.bestv.corefilter.bean.PinIn;
import com.bestv.corefilter.bean.PinOut;
import com.bestv.corefilter.plugin.ScriptRun;

public class FlowControl {

	private static String LogTitle = "FlowControl";

	public static boolean runFlow(Gragh g, String[] parameterIn) throws FilterException {

		String filterName = g.getFirstFilter().getFilterName();
		
		for(int i = 0 ; i < parameterIn.length ; i += 2){
			parameterIn[i] = parameterIn[i].substring(1, parameterIn[i].length());
		}
		
		runFilter(g , filterName , parameterIn);

		return true;
	}
	
	public static void runFilter(Gragh g , String filterName , String[] parameterIn) throws FilterException {
		Filter filter = g.getFilterByName(filterName);
		if(filter == null)
			throw new FilterException("filter name " + filterName + " not found");
		PinIn pinIn = filter.getPinIn();
		for (int i = 0; i < parameterIn.length; i += 2) {
			if (pinIn.setParameter(parameterIn[i], parameterIn[i + 1])) {
				debug(LogTitle, "set parameter success " + parameterIn[i] + "="
						+ parameterIn[i + 1]);
			} else {
				debug(LogTitle, "set parameter failed " + parameterIn[i] + "="
						+ parameterIn[i + 1]);
			}
		}

		String[] keys = pinIn.getParameterKeys();
		String[] values = pinIn.getParameterValues();

		String scriptPath = GlobalSettings.FILTER_PACKAGE + "/"
				+ filter.getFilterName() + "_" + filter.getMainVersion()
				+ "_" + filter.getSubVersion() + "/"
				+ GlobalSettings.SCRIPT_MAIN_NAME;
		
		
		debug("", "keys");
		printArray(keys);
		debug("", "values");
		printArray(values);

		String[] arr = ScriptRun.runScriptAndGetArr(values, keys, scriptPath);
		
		info(LogTitle , scriptPath + " return " );
		printArray(arr);
		
		for(PinOut pinOut : filter.getPinOutList()){
			if(pinOut.getFilterTo() != null){
				runFilter(g , pinOut.getFilterTo() , arr);
			}else{
				
			}
		}
	}
	
	
	// runScript(Object[] args, String[] keys, String scriptPath)

}
