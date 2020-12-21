package formatter.formatterutils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import textalign.formatter.formatterutils.FillBetween;

public class FillBetweenTest {

	private String _delimiter;
	private int _outputWidth;
	
	@Before
	public void setUp() {
		_delimiter = " ";
		_outputWidth = 10;
	}
	
	@After
	public void tearDown() {
		_delimiter = null;
	}
	
	@Test
	public void noSpaceBetweenWordsTest_emptyList_emptyString() {
		// Arrange
		List<String> input = new ArrayList<String>();
		
		// Act
		String actual = FillBetween.noSpaceBetweenWords(input, _delimiter);
		
		// Assess
		String expected = "";
		assertEquals(expected, actual);
	}
	
	@Test
	public void noSpaceBetweenWordsTest_oneElement_elementAsString() {
		// Arrange
		String element = "Hi";
		List<String> input = Arrays.asList(element);
		
		// Act
		String actual = FillBetween.noSpaceBetweenWords(input, _delimiter);
		
		// Assess
		String expected = "Hi";
		assertEquals(expected, actual);
	}
	
	@Test
	public void noSpaceBetweenWordsTest_multipleElements_elementsWithNoSpace() {
		// Arrange
		String element1 = "Hi";
		String element2 = "How";
		String element3 = "Are";
		String element4 = "You?";
		List<String> input = Arrays.asList(element1, element2, element3, element4);
		
		// Act
		String actual = FillBetween.noSpaceBetweenWords(input, _delimiter);
		
		// Assess
		String expected = "HiHowAreYou?";
		assertEquals(expected, actual);
	}
	
	@Test
	public void oneSpaceBetweenWordsTest_emptyList_emptyString() {
		// Arrange
		List<String> input = new ArrayList<String>();
		
		// Act
		String actual = FillBetween.oneSpaceBetweenWords(input, _delimiter);
		
		// Assess
		String expected = "";
		assertEquals(expected, actual);
	}
	
	@Test
	public void oneSpaceBetweenWordsTest_oneElement_elementAsString() {
		// Arrange
		String element = "Hi";
		List<String> input = Arrays.asList(element);
		
		// Act
		String actual = FillBetween.oneSpaceBetweenWords(input, _delimiter);
		
		// Assess
		String expected = "Hi";
		assertEquals(expected, actual);
	}
	
	@Test
	public void oneSpaceBetweenWordsTest_multipleElements_elementsWithOneSpaceSeparatingThem() {
		// Arrange
		String element1 = "Hi";
		String element2 = "How";
		String element3 = "Are";
		String element4 = "You?";
		List<String> input = Arrays.asList(element1, element2, element3, element4);
		
		// Act
		String actual = FillBetween.oneSpaceBetweenWords(input, _delimiter);
		
		// Assess
		String expected = "Hi How Are You?";
		assertEquals(expected, actual);
	}
	
	@Test
	public void distributeAllRemainingSpaceBetweenWordsTest_emptyList_emptyString() {
		// Arrange
		List<String> input = new ArrayList<String>();
		
		// Act
		String actual = FillBetween.distributeAllRemainingSpaceBetweenWords(input, _delimiter, _outputWidth);
		
		// Assess
		String expected = "";
		assertEquals(expected, actual);
	}
	
	@Test
	public void distributeAllRemainingSpaceBetweenWordsTest_oneElement_elementAsString() {
		// Arrange
		String element = "Hi";
		List<String> input = Arrays.asList(element);
		
		// Act
		String actual = FillBetween.distributeAllRemainingSpaceBetweenWords(input, _delimiter, _outputWidth);
		
		// Assess
		String expected = "Hi";
		assertEquals(expected, actual);
	}
	
	@Test
	public void distributeAllRemainingSpaceBetweenWordsTest_twoElements_elementsOnSidesWithRemainingSpaceBetweenThem() {
		// Arrange
		String element1 = "123";
		String element2 = "890";
		List<String> input = Arrays.asList(element1, element2);
		
		// Act
		String actual = FillBetween.distributeAllRemainingSpaceBetweenWords(input, _delimiter, _outputWidth);
		
		// Assess
		String expected = "123    890";
		assertEquals(expected, actual);
	}
	
	@Test
	public void distributeAllRemainingSpaceBetweenWordsTest_multipleElementsUneven_elementsWithMoreSpacingBetweenThemAroundTheEdges() {
		// Arrange
		String element1 = "Hi";
		String element2 = "my";
		String element3 = "friend!";
		List<String> input = Arrays.asList(element1, element2, element3);
		
		// Act
		String actual = FillBetween.distributeAllRemainingSpaceBetweenWords(input, _delimiter, 20);
		
		// Assess
		//String expected = "12345678901234567890";
		String expected = "Hi     my    friend!";
		assertEquals(expected, actual);
	}
	
	@Test
	public void distributeAllRemainingSpaceBetweenWordsTest_multipleElementsEven_elementsWithMoreSpacingBetweenThemAroundTheEdges() {
		// Arrange
		String element1 = "Hi";
		String element2 = "my";
		String element3 = "dear";
		String element4 = "friend";
		List<String> input = Arrays.asList(element1, element2, element3, element4);
		
		// Act
		String actual = FillBetween.distributeAllRemainingSpaceBetweenWords(input, _delimiter, 25);
		
		// Assess
		//String expected = "1234567890123456789012345";
		String expected = "Hi    my    dear   friend";
		assertEquals(expected, actual);
	}
	
		

}
