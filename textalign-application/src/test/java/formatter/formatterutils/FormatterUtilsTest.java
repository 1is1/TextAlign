package formatter.formatterutils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import textalign.formatter.formatterutils.FormatterUtils;

public class FormatterUtilsTest {
	
	private String _delimiter;
	
	@Before
	public void setUp() {
		_delimiter = " ";
	}
	
	@After
	public void tearDown() {
		_delimiter = null;
	}

	@Test
	public void getMinimumInBetweenSpacingNeededTest_noWords_0() {
		// Arrange
		List<String> words = new ArrayList<String>();
		
		// Act
		int actual = FormatterUtils.getMinimumInBetweenSpacingNeeded(words, _delimiter);
		
		// Assert
		int expected = 0;
		assertEquals(actual, expected);
	}
	
	@Test
	public void getMinimumInBetweenSpacingNeededTest_oneWord_0() {
		// Arrange
		List<String> words = Arrays.asList("hi");
		
		// Act
		int actual = FormatterUtils.getMinimumInBetweenSpacingNeeded(words, _delimiter);
		
		// Assert
		int expected = 0;
		assertEquals(actual, expected);
	}
	

	@Test
	public void getMinimumInBetweenSpacingNeededTest_multipleWords_oneLessThanTotal() {
		// Arrange
		List<String> words = Arrays.asList("hi", "you", "there");
		
		// Act
		int actual = FormatterUtils.getMinimumInBetweenSpacingNeeded(words, _delimiter);
		
		// Assert
		int expected = 2;
		assertEquals(actual, expected);
	}
	
	@Test
	public void getSpaceOccupiedByWordsTest_emptyList_0() {
		// Arrange
		List<String> words = new ArrayList<String>();
		
		// Act
		int actual = FormatterUtils.getSpaceOccupiedByWords(words);
		
		// Assert
		int expected = 0;
		assertEquals(actual, expected);
	}
	
	@Test
	public void getSpaceOccupiedByWordsTest_oneElement_wordsLength() {
		// Arrange
		List<String> words = Arrays.asList("hi");
		
		// Act
		int actual = FormatterUtils.getSpaceOccupiedByWords(words);
		
		// Assert
		int expected = 2;
		assertEquals(actual, expected);
	}
	
	@Test
	public void getSpaceOccupiedByWordsTest_manyElement_wordsLength() {
		// Arrange
		List<String> words = Arrays.asList("hi","how","are","you?");
		
		// Act
		int actual = FormatterUtils.getSpaceOccupiedByWords(words);
		
		// Assert
		int expected = 12;
		assertEquals(actual, expected);
	}
	
	@Test
	public void getSpacingLeftTest() {
		// Arrange
		List<String> words = Arrays.asList("hi","how","are","you?");
		int outputWidth = 15;
		
		// Act
		int actual = FormatterUtils.getSpacingLeft(words, outputWidth);
		
		// Assert
		int expected = 3;
		assertEquals(actual, expected);
	}
	
	@Test
	public void getRemainderSpaceTest() {
		// Arrange
		List<String> words = Arrays.asList("hi","how","are","you?");
		int outputWidth = 15;
		
		// Act
		int actual = FormatterUtils.getRemainderSpace(words, outputWidth, _delimiter);
		
		// Assert
		int expected = 0;
		assertEquals(actual, expected);
	}
	
	@Test
	public void isValidToAddTest_noElementsAndNextWordSmallerThanOutputWidth_true() {
		// Arrange
		List<String> words = new ArrayList<String>();
		int outputWidth = 15;
		String nextWord = "hi";
		
		// Act
		boolean actual = FormatterUtils.isValidToAdd(words, outputWidth, _delimiter, nextWord);
		
		// Assert
		boolean expected = true;
		assertEquals(actual, expected);
	}
	
	@Test
	public void isValidToAddTest_noElementsAndNextWordLargerThanOutputWidth_true() {
		// Arrange
		List<String> words = new ArrayList<String>();
		int outputWidth = 15;
		String nextWord = "hithisisaverylongwordIjustmadeup";
		
		// Act
		boolean actual = FormatterUtils.isValidToAdd(words, outputWidth, _delimiter, nextWord);
		
		// Assert
		boolean expected = true;
		assertEquals(actual, expected);
	}
	
	@Test
	public void isValidToAddTest_elementsExistAndNextWordSmallerThanOutputWidthAndWillOverflowLine_false() {
		// Arrange
		List<String> words = Arrays.asList("hi","how","are","you?");
		int outputWidth = 15;
		String nextWord = "toobthisline";
		
		// Act
		boolean actual = FormatterUtils.isValidToAdd(words, outputWidth, _delimiter, nextWord);
		
		// Assert
		boolean expected = false;
		assertEquals(actual, expected);
	}
	
	@Test
	public void isValidToAddTest_elementsExistAndNextWordSmallerThanOutputWidthAndWontOverflowLine_true() {
		// Arrange
		List<String> words = Arrays.asList("hi","how","are","you?");
		int outputWidth = 15;
		String nextWord = "ok";
		
		// Act
		boolean actual = FormatterUtils.isValidToAdd(words, outputWidth, _delimiter, nextWord);
		
		// Assert
		boolean expected = false;
		assertEquals(actual, expected);
	}
	
	@Test
	public void isValidToAddTest_elementsExistAndNextWordLargerThanOutputWidth_false() {
		// Arrange
		List<String> words = Arrays.asList("hi","how","are","you?");
		int outputWidth = 15;
		String nextWord = "hithisisaverylongwordIjustmadeup";
		
		// Act
		boolean actual = FormatterUtils.isValidToAdd(words, outputWidth, _delimiter, nextWord);
		
		// Assert
		boolean expected = false;
		assertEquals(actual, expected);
	}
	
	@Test
	public void createFillStringTest_n0_emptyString() {
		// Arrange
		int n = 0;
		
		// Act
		String actual = FormatterUtils.createFillString(n, _delimiter);
		
		// Assert
		String expected = "";
		assertEquals(actual, expected);
	}
	
	@Test
	public void createFillStringTest_n1_space() {
		// Arrange
		int n = 1;
		
		// Act
		String actual = FormatterUtils.createFillString(n, _delimiter);
		
		// Assert
		String expected = " ";
		assertEquals(actual, expected);
	}
	
	@Test
	public void createFillStringTest_n3_3spaces() {
		// Arrange
		int n = 3;
		
		// Act
		String actual = FormatterUtils.createFillString(n, _delimiter);
		
		// Assert
		String expected = "   ";
		assertEquals(actual, expected);
	}
	
	@Test
	public void turnStringIntoWordsTest_emptyString_listWithEmptyString() {
		// Arrange
		String inputString = "";
		
		// Act
		List<String> actual = FormatterUtils.turnStringIntoWords( inputString );
		
		// Assert
		List<String> expected = Arrays.asList("");
		assertLists(actual, expected);
	}
	
	@Test
	public void turnStringIntoWordsTest_singleWordString_listWithSaidWord() {
		// Arrange
		String inputString = "Hi";
		
		// Act
		List<String> actual = FormatterUtils.turnStringIntoWords( inputString );
		
		// Assert
		List<String> expected = Arrays.asList("Hi");
		assertLists(actual, expected);
	}
	
	@Test
	public void turnStringIntoWordsTest_manyWordString_listOfAllWordsSeparatedByWhitespaceInString() {
		// Arrange
		String inputString = "Hi how are you doing?";
		
		// Act
		List<String> actual = FormatterUtils.turnStringIntoWords( inputString );
		
		// Assert
		List<String> expected = Arrays.asList("Hi", "how", "are", "you", "doing?");
		assertLists(actual, expected);
	}
	
	@Test
	public void turnWordsIntoWordsPerLineTest_wordsThatWouldRequireTwoLines_listOfTwoListsOfWords() {
		// Arrange
		List<String> words = Arrays.asList("123", "567", "901");
		int outputWidth = 10;
		
		// Act
		List<List<String>> actual = FormatterUtils.turnWordsIntoWordsPerLine( words, outputWidth, _delimiter );
		
		// Assert
		List<List<String>> expected = Arrays.asList(
				Arrays.asList("123", "567"),
				Arrays.asList("901")
				);
		assertEquals(expected.size(), 2);
		assertEquals(actual.size(), expected.size());
		assertLists(actual.get(0), expected.get(0));
		assertLists(actual.get(1), expected.get(1));
	}
	
	@Test
	public void turnWordsIntoWordsPerLineTest_wordsThatWouldRequireOneLine_listOfOneListsOfWords() {
		// Arrange
		List<String> words = Arrays.asList("123", "567");
		int outputWidth = 10;
		
		// Act
		List<List<String>> actual = FormatterUtils.turnWordsIntoWordsPerLine( words, outputWidth, _delimiter );
		
		// Assert
		List<List<String>> expected = Arrays.asList(
				Arrays.asList("123", "567")
				);
		assertEquals(expected.size(), 1);
		assertEquals(actual.size(), expected.size());
		assertLists(actual.get(0), expected.get(0));
	}
	
	@Test
	public void turnWordsIntoWordsPerLineTest_emptyListOfWords_emptyListOfLists() {
		// Arrange
		List<String> words = new ArrayList<String>();
		int outputWidth = 10;
		
		// Act
		List<List<String>> actual = FormatterUtils.turnWordsIntoWordsPerLine( words, outputWidth, _delimiter );
		
		// Assert
		List<List<String>> expected = new ArrayList<List<String>>();
		assertEquals(expected.size(), 0);
		assertEquals(actual.size(), expected.size());
	}
	
	
	private <T> void assertLists( List<T> actual, List<T> expected ) {
		if (actual.size() != expected.size()) {
			fail();
		} else {
			for (int i = 0; i < actual.size(); i++) {
				assertEquals(actual, expected);
			}
		}
	}
	
	

	
	
}
