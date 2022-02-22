package com.jsoniter;

public class switchCaseContext{
	int bc;
	JsonIterator iter;
	int i;
	int j; 
	boolean isExpectingLowSurrogate;
	
	public switchCaseContext(int bc, JsonIterator iter, int i, int j, boolean isExpectingLowSurrogate) {
		super();
		this.bc = bc;
		this.iter = iter;
		this.i = i;
		this.j = j;
		this.isExpectingLowSurrogate = isExpectingLowSurrogate;
	}
	
	
}