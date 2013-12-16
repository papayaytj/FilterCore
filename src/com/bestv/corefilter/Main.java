package com.bestv.corefilter;

import static com.bestv.corefilter.util.LogUtil.*;

import java.util.Arrays;

public class Main {
	
	//graghName test -packagingtoken 20131209000001 -chname testhar -bandwidth 400000 -streamindex 5 -filename /dev/shm/ftp/live/testhar//workflow05/20131204T123456-5-39258.ts -sequence 138651830;
	public static void main(String[] args) {
		printArray(args);
		String paras[] = Arrays.copyOfRange(args, 2, args.length);
		info(""  , "thread start*************************");
		new MainThread(args[1], paras);
		info("" , "thread end*************************");
	}
}
