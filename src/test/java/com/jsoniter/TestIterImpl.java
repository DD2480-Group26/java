package com.jsoniter;

import junit.framework.TestCase;

public class TestIterImpl extends TestCase{

	public void testReadStringSlowPath4() throws Exception{
		JsonIterator iter = new JsonIterator();
		int j = 1;
		iter.tail = 1;
		iter.tail = 10;
		iter.buf = new byte[3];
		iter.buf[0]='\\';
		iter.buf[1]='b';
		iter.buf[2] = '"';
		IterImpl.readStringSlowPath(iter, j);		
	}
	
	public void testReadStringSlowPath5() throws Exception{
		JsonIterator iter = new JsonIterator();
		int j = 1;
		iter.tail = 1;
		iter.tail = 10;
		iter.buf = new byte[3];
		iter.buf[0]='\\';
		iter.buf[1]='n';
		iter.buf[2] = '"';
		IterImpl.readStringSlowPath(iter, j);		
	}
	
	public void testReadStringSlowPath6() throws Exception{
		JsonIterator iter = new JsonIterator();
		int j = 1;
		iter.tail = 1;
		iter.tail = 10;
		iter.buf = new byte[3];
		iter.buf[0]='\\';
		iter.buf[1]='t';
		iter.buf[2] = '"';
		assertEquals(IterImpl.readStringSlowPath(iter, j),++j);			
	}
	
	public void testReadStringSlowPath7() throws Exception{
		JsonIterator iter = new JsonIterator();
		int j = 1;
		iter.tail = 1;
		iter.tail = 10;
		iter.buf = new byte[3];
		iter.buf[0]='\\';
		iter.buf[1]='f';
		iter.buf[2] = '"';
		assertEquals(IterImpl.readStringSlowPath(iter, j),++j);		
	}
}
