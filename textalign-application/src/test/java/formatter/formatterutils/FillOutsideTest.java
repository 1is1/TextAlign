package formatter.formatterutils;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import textalign.formatter.formatterutils.FillOutside;

public class FillOutsideTest {
	
	private String _delimiter;
	private int _remainingWidth;

	
	@Before
	public void setUp() {
		_delimiter = " ";
		_remainingWidth = 10;
	}
	
	@After
	public void tearDown() {
		_delimiter = null;
	}
	
	@Test
	public void fillAroundTest_noRemainingWidth_inputStringUnchanged() {
		// Arrange
		String inputString = "hey";
		int remainingWidth = 0;
		
		// Act
		String actual = FillOutside.fillAround(inputString, remainingWidth, _delimiter);
		
		// Assert
		String expected = "hey";
		assertEquals(actual, expected);
		
	}
	
	@Test
	public void fillAroundTest_emptyInputString_nSpaces() {
		// Arrange
		String inputString = "";
		
		// Act
		String actual = FillOutside.fillAround(inputString, _remainingWidth, _delimiter);
		
		// Assert
		String expected = "          "; // 10 spaces to match the _remainingWidth value
		assertEquals(actual, expected);
		
	}
	
	@Test
	public void fillAroundTest_evenRemaningWidth_evenSpaceOnEachSide() {
		// Arrange
		String inputString = "hi";
		
		// Act
		String actual = FillOutside.fillAround(inputString, _remainingWidth, _delimiter);
		
		// Assert
		String expected = "     hi     ";
		assertEquals(actual, expected);
		
	}
	
	@Test
	public void fillAroundTest_unevenRemaningWidth_oneMoreSpaceOnTheRightSide() {
		// Arrange
		String inputString = "hi";
		int remainingWidth = 9;
		
		// Act
		String actual = FillOutside.fillAround(inputString, remainingWidth, _delimiter);
		
		// Assert
		String expected = "    hi     ";
		assertEquals(actual, expected);
		
	}
	
	@Test
	public void fillOnLeftTest_noRemainingWidth_inputStringUnchanged() {
		// Arrange
		String inputString = "hey";
		int remainingWidth = 0;
		
		// Act
		String actual = FillOutside.fillOnLeft(inputString, remainingWidth, _delimiter);
		
		// Assert
		String expected = "hey";
		assertEquals(actual, expected);
		
	}
	
	@Test
	public void fillOnLeftTest_emptyInputString_nSpaces() {
		// Arrange
		String inputString = "";
		
		// Act
		String actual = FillOutside.fillOnLeft(inputString, _remainingWidth, _delimiter);
		
		// Assert
		String expected = "          "; // 10 spaces to match the _remainingWidth value
		assertEquals(actual, expected);
		
	}
	
	@Test
	public void fillOnLeftTest_remaningWidth_evenSpaceOnEachSide() {
		// Arrange
		String inputString = "hi";
		
		// Act
		String actual = FillOutside.fillOnLeft(inputString, _remainingWidth, _delimiter);
		
		// Assert
		String expected = "          hi";
		assertEquals(actual, expected);
		
	}
	
	//-----------------------------
	
	@Test
	public void fillOnRightTest_noRemainingWidth_inputStringUnchanged() {
		// Arrange
		String inputString = "hey";
		int remainingWidth = 0;
		
		// Act
		String actual = FillOutside.fillOnRight(inputString, remainingWidth, _delimiter);
		
		// Assert
		String expected = "hey";
		assertEquals(actual, expected);
		
	}
	
	@Test
	public void fillOnRightTest_emptyInputString_nSpaces() {
		// Arrange
		String inputString = "";
		
		// Act
		String actual = FillOutside.fillOnRight(inputString, _remainingWidth, _delimiter);
		
		// Assert
		String expected = "          "; // 10 spaces to match the _remainingWidth value
		assertEquals(actual, expected);
		
	}
	
	@Test
	public void fillOnRightTest_remaningWidth_evenSpaceOnEachSide() {
		// Arrange
		String inputString = "hi";
		
		// Act
		String actual = FillOutside.fillOnRight(inputString, _remainingWidth, _delimiter);
		
		// Assert
		String expected = "hi          ";
		assertEquals(actual, expected);
		
	}
	

}
