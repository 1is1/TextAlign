package textalign.formatter.formatterutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import textalign.generalutils.ListUtils;

public class FormatterUtils {
	
	/**
	 * Get's the minimumSpacingNeededed with the given delimiter
	 * @param words
	 * @param delimiter TODO
	 * @return
	 */
	public static int getMinimumInBetweenSpacingNeeded( List<String> words, String delimiter ) {
		int size = words.size();
		return size == 0 ? 0 : ( size - 1 ) * delimiter.length();
	}
	
	/**
	 * Get's space occupied by words in a string
	 * @param words
	 * @return
	 */
	public static int getSpaceOccupiedByWords( List<String> words ) {
		return words.stream().map( String::length ).reduce(0, Integer::sum);
	}
	
	/**
	 * Get's the amount space left once the words are occupied
	 * @param words
	 * @param outputWidth
	 * @return
	 */
	public static int getSpacingLeft( List<String> words, int outputWidth ) {
		return outputWidth - getSpaceOccupiedByWords( words );
	}
	
	/**
	 * Get's the amount of space left once the words and their minimumSpacingNeeded is occupied
	 * @param words
	 * @param outputWidth
	 * @return
	 */
	public static int getRemainderSpace( List<String> words, int outputWidth, String delimiter ) {
		int occupiedSpace = getMinimumInBetweenSpacingNeeded(words, delimiter) + getSpaceOccupiedByWords(words);
		
		return outputWidth - occupiedSpace;
	}
	
	/**
	 * Evaluates if the list of strings can add the next word given the passed outputWidth
	 * @param currentlyAddedWords
	 * @param outputWidth
	 * @param nextWord
	 * @return
	 */
	public static boolean isValidToAdd( List<String> currentlyAddedWords, int outputWidth, String delimiter, String nextWord ) {
		List<String> wordsWithNextWord = ListUtils.union( currentlyAddedWords, nextWord );
		boolean addingNextWordWillNotExceedWidth = getRemainderSpace(wordsWithNextWord, outputWidth, delimiter ) >= 0;
		boolean atStartOfLine = currentlyAddedWords.size() == 0;
		boolean wordIsLargerThanMaximumWidth = nextWord.length() > outputWidth;
		
		return (addingNextWordWillNotExceedWidth || (atStartOfLine && wordIsLargerThanMaximumWidth) );
	}

	/**
	 * Creates a string with n new delimiters
	 * @param n
	 * @return
	 */
	public static String createFillString(int n, String delimiter) {
		return new String(new char[n]).replace("\0", delimiter);
	}

	/**
	 * Splits a string into a list of strings based on where there's a whitespace
	 * @param inputString
	 * @return
	 */
	public static List<String> turnStringIntoWords( String inputString ) {
		return Arrays.asList(inputString.split("\\s"));
	}

	/**
	 * Processes a list of words into a list with lists of words, where each of the inner lists is formatted to accord with the outputWidth and the delimiter
	 * @param words
	 * @param outputWidth
	 * @param delimiter
	 * @return
	 */
	public static List<List<String>> turnWordsIntoWordsPerLine(List<String> words, int outputWidth, String delimiter) {
		if (words.isEmpty()) {
			return new ArrayList<List<String>>();
		} else {
			LinkedList<String> unprocessedWords = new LinkedList<String>(words);
			ArrayList<List<String>> newLines = new ArrayList<List<String>>();
			
			ArrayList<String> wordsInCurrentLine = new ArrayList<String>();
			while (unprocessedWords.peek() != null) {
				if ( isValidToAdd( wordsInCurrentLine, outputWidth, delimiter, unprocessedWords.peek() ) ) {
					wordsInCurrentLine.add( unprocessedWords.pop() );
				} else {
					newLines.add( new ArrayList<String>(wordsInCurrentLine) );
					wordsInCurrentLine.clear();
				}
			}
			newLines.add( new ArrayList<String>(wordsInCurrentLine) );
			return newLines;
		}
	}
	


}
