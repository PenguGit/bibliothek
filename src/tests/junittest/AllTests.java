package tests.junittest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ TestCase1.class, TestCase2.class })
public class AllTests {

}
