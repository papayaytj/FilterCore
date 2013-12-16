package com.bestv.corefilter;

import static com.bestv.corefilter.util.LogUtil.*;

import com.bestv.corefilter.bean.*;
import com.bestv.corefilter.control.FlowControl;
import com.bestv.corefilter.control.GraghControl;

public class MainThread extends Thread {

	private String graghName;
	private String[] parameters;

	private static String LogTitle = "MainThread";

	public MainThread(String graghName, String[] parameters) {
		this.graghName = graghName;
		this.parameters = parameters;
		this.start();
	}

	@Override
	public void run() {
		try {
			Gragh g = GraghControl.createGragh(graghName);

			printArray(parameters);
			info(LogTitle, "parameters:" + parameters.length);
			info(LogTitle, g);

			/**
			 * single pin in many pin out
			 */
			FlowControl.runFlow(g, parameters);
		} catch (FilterException e) {
			error(LogTitle, e.getErrorMessage());
			e.printStackTrace();
		} catch (Exception e) {
			error(LogTitle, e.getMessage());
			e.printStackTrace();
		}

	}

}