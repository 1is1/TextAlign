package textalign.formatter.formatterutils;

import java.util.ArrayList;
import java.util.List;

public class FillBetween {

	public enum FillBetweenMethods {
		ONE_SPACE_BETWEEN_WORDS,
		DISTRIBUTE_ALL_REMAINING_SPACE_BETWEEN_WORDS,
		NONE
	}
	
	private enum ProcessingDirection {
		START_TOWARDS_END,
		END_TOWARDS_START
	}
	
	/**
	 * Creates a string with space distributed progressively between the passed words
	 * (Progressively fills in spaces between words by adding a space between the words alternating from left to right until each word has received one space,
	 * then repeats indefinitely until no more spaces are left to give)
	 * @param words
	 * @param delimiter
	 * @param outputWidth
	 * @return
	 */
	public static String distributeAllRemainingSpaceBetweenWords(List<String> words, String delimiter, int outputWidth) {
		List<String> wordsWithSpaces = new ArrayList<String>( words );
		if (wordsWithSpaces.size() > 1) {
			int incrementingIndex = 0;
			int decrementingIndex = wordsWithSpaces.size() - 1;
			ProcessingDirection curSide = ProcessingDirection.START_TOWARDS_END;
			int remainderSpace = FormatterUtils.getSpacingLeft( wordsWithSpaces, outputWidth );
			while ( remainderSpace > 0 ) {
				
				if ( curSide.equals( ProcessingDirection.START_TOWARDS_END ) ) {
					String insert = wordsWithSpaces.get(incrementingIndex) + delimiter;
					wordsWithSpaces.set( incrementingIndex, insert );
					incrementingIndex++;
					curSide = ProcessingDirection.END_TOWARDS_START;
					if ( incrementingIndex > wordsWithSpaces.size() - 1 ) {
						incrementingIndex = 0;
					}
				} else {
					String insert = delimiter + wordsWithSpaces.get(decrementingIndex) ;
					wordsWithSpaces.set( decrementingIndex, insert );
					decrementingIndex--;
					curSide = ProcessingDirection.START_TOWARDS_END;
					if ( decrementingIndex < 0 ) {
						decrementingIndex = wordsWithSpaces.size() - 1;
					}
				}
				
				if ( incrementingIndex <= decrementingIndex ) {
					incrementingIndex = 0;
					decrementingIndex = wordsWithSpaces.size() - 1;
				}

				remainderSpace = FormatterUtils.getSpacingLeft( wordsWithSpaces, outputWidth );
			}
		}
		return String.join("", wordsWithSpaces);
	}
	
	/**
	 * Creates a string with all the words
	 * @param words
	 * @param delimiter
	 * @return
	 */
	public static String noSpaceBetweenWords(List<String> words, String delimiter) {
		return String.join("", words);
	}
	
	/**
	 * Creates a string with all the words separated by one space between them
	 * @param words
	 * @param delimiter
	 * @return
	 */
	public static String oneSpaceBetweenWords(List<String> words, String delimiter) {
		return String.join(delimiter, words);
	}
	
}
