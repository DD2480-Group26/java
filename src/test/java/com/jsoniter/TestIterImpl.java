package com.jsoniter;

import junit.framework.TestCase;

public class TestIterImpl extends TestCase{

	public void testReadStringSlowPath4() throws Exception{
		JsonIterator iter = new JsonIterator();
		int j = 0;
		iter.tail = 1;
		iter.tail = 10;
		iter.buf = new byte[2];
		iter.buf[0]='\\';
		iter.buf[1]='b';
		IterImpl.readStringSlowPath(iter, j);		
	}
	
	public void testReadStringSlowPath5() throws Exception{
		JsonIterator iter = new JsonIterator();
		int j = 0;
		iter.tail = 1;
		iter.tail = 10;
		iter.buf = new byte[2];
		iter.buf[0]='\\';
		iter.buf[1]='n';
		IterImpl.readStringSlowPath(iter, j);		
	}
	
	public void testReadStringSlowPath6() throws Exception{
		JsonIterator iter = new JsonIterator();
		int j = 0;
		iter.tail = 1;
		iter.tail = 10;
		iter.buf = new byte[2];
		iter.buf[0]='\\';
		iter.buf[1]='t';
		IterImpl.readStringSlowPath(iter, j);		
	}
	
	public void testReadStringSlowPath7() throws Exception{
		JsonIterator iter = new JsonIterator();
		int j = 0;
		iter.tail = 1;
		iter.tail = 10;
		iter.buf = new byte[2];
		iter.buf[0]='\\';
		iter.buf[1]='f';
		IterImpl.readStringSlowPath(iter, j);		
	}
}
