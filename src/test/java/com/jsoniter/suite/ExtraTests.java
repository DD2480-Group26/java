package com.jsoniter.suite;

import com.jsoniter.extra.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Ignore
@Suite.SuiteClasses({TestBase64.class, TestNamingStrategy.class, TestPreciseFloat.class})
public class ExtraTests {

}
