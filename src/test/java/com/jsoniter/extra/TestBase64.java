package com.jsoniter.extra;

import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;
import junit.framework.TestCase;

public class TestBase64 extends TestCase {
    static {
        Base64Support.enable();
    }

    public void test_encode() {
        assertEquals("\"YWJj\"", JsonStream.serialize("abc".getBytes()));
    }

    public void test_decode() {
        assertEquals("abc", new String(JsonIterator.deserialize("\"YWJj\"", byte[].class)));
    }
    
    
    // added test cases for testing decodeFast uncovered branches 
    public void test_illegal_chars_from_start() {
    	assertEquals("abc", new String(JsonIterator.deserialize("\"YWJj\"", byte[].class)));    	
    }
    
    public void test_illegal_chars_from_end() {
    	assertEquals("abc", new String(JsonIterator.deserialize("\"YWJj\"", byte[].class)));    	
    }
    
    public void test_empty() {
    	assertEquals("", new String(JsonIterator.deserialize("\"\"", byte[].class)));    	
    }
    
    public void test_decode_last_1_to_3_bytes() {
    	assertEquals("~;", new String(JsonIterator.deserialize("\"fjs\"", byte[].class)));    	
    }
    
    public void test_two_equals() {
    	assertEquals("abcd", new String(JsonIterator.deserialize("\"YWJjZA==\"", byte[].class)));    	
    }
    
    public void test_one_equals() {
    	assertEquals("abcde", new String(JsonIterator.deserialize("\"YWJjZGU=\"", byte[].class)));    	
    }
    
    public void test_more_than_76_bytes() {
    	assertEquals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", new String(JsonIterator.deserialize("\"YWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFhYWFh\"", byte[].class)));    	
    }
}
