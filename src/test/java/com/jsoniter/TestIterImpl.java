package com.jsoniter;

import junit.framework.TestCase;

public class TestIterImpl extends TestCase{

	/*Contract:
	 * Here we are testing the buffer "\\b""
	 * This buffer should go through the loop once and increase 
	 * j by one
	 * Expected output: j++
	 */
	public void testReadStringSlowPath4() throws Exception{
		JsonIterator iter = new JsonIterator();
		int j = 1;
		iter.tail = 1;
		iter.tail = 10;
		iter.buf = new byte[3];
		iter.buf[0]='\\';
		iter.buf[1]='b';
		iter.buf[2] = '"';
		assertEquals(IterImpl.readStringSlowPath(iter, j),++j);	
	}
	
	/*Contract:
	 * Here we are testing the buffer "\\n""
	 * This buffer should go through the loop once and increase 
	 * j by one
	 * Expected output: j++
	 */
	public void testReadStringSlowPath5() throws Exception{
		JsonIterator iter = new JsonIterator();
		int j = 1;
		iter.tail = 1;
		iter.tail = 10;
		iter.buf = new byte[3];
		iter.buf[0]='\\';
		iter.buf[1]='n';
		iter.buf[2] = '"';	
		assertEquals(IterImpl.readStringSlowPath(iter, j),++j);	
	}
	
	/*Contract:
	 * Here we are testing the buffer "\\t""
	 * This buffer should go through the loop once and increase 
	 * j by one
	 * Expected output: j++
	 */
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
	
	
	/*Contract:
	 * Here we are testing the buffer "\\f""
	 * This buffer should go through the loop once and increase 
	 * j by one
	 * Expected output: j++
	 */
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
