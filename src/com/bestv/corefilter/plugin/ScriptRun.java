package com.bestv.corefilter.plugin;

import java.util.HashMap;
import java.util.Map;

import org.python.core.PyDictionary;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

public class ScriptRun {
	
	public static PyDictionary runScript(PyObject[] pyArgs, String[] keys, String scriptPath){
		PythonInterpreter interp = new PythonInterpreter();
		interp.execfile(scriptPath);
		PyFunction runFunc = (PyFunction) interp.get("run", PyFunction.class);
		PyObject pyobj = runFunc.__call__(pyArgs, keys);
		PyDictionary dict = (PyDictionary) pyobj;
		return dict;
	}

	public static Map<String, String> runScriptAndGetMap(Object[] args, String[] keys, String scriptPath) {
		PyObject[] pyArgs = ObjectArrayToPyArray(args);
		PyDictionary dict = runScript(pyArgs, keys, scriptPath);
		return pyDictToJavaMap(dict);
	}
	
	public static String[] runScriptAndGetArr(Object[] args, String[] keys, String scriptPath) {
		PyObject[] pyArgs = ObjectArrayToPyArray(args);
		PyDictionary dict = runScript(pyArgs, keys, scriptPath);
		return pyDictToStringArray(dict);
	}
	
	public static String[] pyDictToStringArray(PyDictionary dict) {
		String arr[] = new String[dict.size() * 2];
		int i = 0;
		for(Object key : dict.keySet()){
			arr[i] = String.valueOf(key);
			arr[i+1] = String.valueOf(dict.get(String.valueOf(key)));
			i += 2;
		}
		return arr;
	}

	public static PyObject[] ObjectArrayToPyArray(Object[] args){
		PyObject[] pyArgs = new PyObject[args.length];
		for (int i = 0; i < args.length; i++) {
			pyArgs[i] = new PyString(String.valueOf(args[i]));
		}
		return pyArgs;
	}
	
	public static Map<String, String> pyDictToJavaMap(PyDictionary dict){
		Map<String, String> retMap = new HashMap<String, String>();
		for(Object key : dict.keySet()){
			retMap.put(String.valueOf(key), String.valueOf(dict.get(key)));
		}
		return retMap;
	}

}
