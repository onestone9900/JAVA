package calculatetest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import calculate.Calculator;


public class CalculatorTest {
	
	Calculator calculator;
	String numFilepath;
	String stringFilepath;
	
	@Before
	public void setUp() throws UnsupportedEncodingException {
		this.calculator = new Calculator();
		this.numFilepath = URLDecoder.decode(getClass().getResource("/test/numbers.txt").getPath(),"UTF-8");
		this.stringFilepath = URLDecoder.decode(getClass().getResource("/test/string.txt").getPath(),"UTF-8");
	}
	
	@Test
	public void calcSum() throws IOException {
		assertThat(calculator.calcSum(this.numFilepath), equalTo(10));
	}
	
	@Test
	public void multiplyOfNumbers() throws IOException {
		assertThat(calculator.calcMultiply(this.numFilepath), equalTo(24));
	}
	
	@Test
	public void appendStringTest() throws IOException {
		assertThat(calculator.appendString(this.stringFilepath),equalTo("abcd"));
	}
}
