package formatter.implementedformatters;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import textalign.formatter.Formatter;
import textalign.formatter.implementedformatters.RightAlignFormatter;

public class RightAlignFormatterTest {

	private Formatter _formatter;
	private int _outputWidth;

	@Before
	public void setUp() {
		_formatter = RightAlignFormatter.INSTANCE;
		_outputWidth = 10;
	}
	
	@After
	public void tearDown() {
		_formatter = null;
	}
	
	@Test
	public void formatStringTest_emptyString_stringFullOfSpaces() {
		// Arrange
		String inputString = "";
		
		// Act
		String actual = _formatter.formatString(inputString, _outputWidth);
		
		// Assert
		String expected = "          ";
		assertEquals(expected, actual);
	}
	
	@Test
	public void formatStringTest_oneLineString_formattedString() {
		// Arrange
		String inputString = "hey you";
		
		// Act
		String actual = _formatter.formatString(inputString, _outputWidth);
		
		// Assert
		String expected = "   hey you";
		assertEquals(expected, actual);
	}
	
	@Test
	public void formatStringTest_multiLineString_formattedString() {
		// Arrange
		String inputString = "hey you there";
		
		// Act
		String actual = _formatter.formatString(inputString, _outputWidth);
		
		// Assert
		String expected =
				"   hey you" + System.lineSeparator() +
				"     there" ;
		assertEquals(expected, actual);
	}
	

}
