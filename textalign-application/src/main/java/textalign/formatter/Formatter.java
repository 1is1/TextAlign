package textalign.formatter;

import java.util.List;
import java.util.stream.Collectors;

import textalign.formatter.formatterutils.FillBetween;
import textalign.formatter.formatterutils.FillOutside;
import textalign.formatter.formatterutils.FormatterUtils;
import textalign.formatter.formatterutils.FillBetween.FillBetweenMethods;
import textalign.formatter.formatterutils.FillOutside.FillOutsideMethods;

public abstract class Formatter {
	
	
	private static String _delimiter = " ";
	
	private FillBetweenMethods _fillBetweenMethod;
	private FillOutsideMethods _fillOutsideMethod;
	
	public Formatter( FillBetweenMethods fillBetweenMethod, FillOutsideMethods fillOutsideMethod ) {
		_fillBetweenMethod = fillBetweenMethod;
		_fillOutsideMethod = fillOutsideMethod;
	}
	
	/**
	 * Formats an input string based on passed outputWidth and the formatters configurations
	 * @param inputString
	 * @param outputWidth
	 * @return
	 */
	public String formatString( String inputString, int outputWidth ) {
		return formatString( inputString, outputWidth, _delimiter, _fillBetweenMethod, _fillOutsideMethod );
	}
	
	/**
	 * Formats an input string into a formatted string by using the passed configurations
	 * @param inputString
	 * @param outputWidth
	 * @param delimiter
	 * @param fillBetweenMethod
	 * @param fillOutsideMethod
	 * @return
	 */
	private String formatString( String inputString, int outputWidth, String delimiter, FillBetweenMethods fillBetweenMethod, FillOutsideMethods fillOutsideMethod ) {
		List<String> words = FormatterUtils.turnStringIntoWords(inputString);
		List<List<String>> wordsPerLine = FormatterUtils.turnWordsIntoWordsPerLine(words, outputWidth, delimiter);
		String formattedString = wordsPerLine.stream()
			.map( lineWords -> turnWordsIntoLine( lineWords, outputWidth, delimiter, fillBetweenMethod, fillOutsideMethod ) )
			.collect(Collectors.joining(System.lineSeparator()));
		
		return formattedString;
	};
	
	
	/**
	 * Turns a list of words into a formatted line by using the passed configurations
	 * @param words
	 * @param outputWidth
	 * @param delimiter
	 * @param fillBetweenMethod
	 * @param fillOutsideMethod
	 * @return
	 */
	public String turnWordsIntoLine(List<String> words, int outputWidth, String delimiter, FillBetweenMethods fillBetweenMethod, FillOutsideMethods fillOutsideMethod) {
		String line = fillBetween( words, delimiter, outputWidth, fillBetweenMethod );
		line = fillOutside(line, outputWidth, fillOutsideMethod, delimiter);
		return line;
	}
	
	/**
	 * Fills the spaces in between the passed words by using the passed configurations
	 * @param words
	 * @param delimiter
	 * @param outputWidth
	 * @param fillMethod
	 * @return
	 */
	public String fillBetween( List<String> words, String delimiter, int outputWidth, FillBetweenMethods fillMethod ) {
		switch ( fillMethod ) {
		case DISTRIBUTE_ALL_REMAINING_SPACE_BETWEEN_WORDS:
			return FillBetween.distributeAllRemainingSpaceBetweenWords(words, delimiter, outputWidth);
		case NONE:
			return FillBetween.noSpaceBetweenWords(words, delimiter);
		case ONE_SPACE_BETWEEN_WORDS:
			return FillBetween.oneSpaceBetweenWords(words, delimiter);
		default:
			return FillBetween.oneSpaceBetweenWords(words, delimiter);
		}
	}
	
	/**
	 * Fills the spaces around the passed string by using the passed configurations
	 * @param line
	 * @param outputWidth
	 * @param fillMethod
	 * @param delimiter 
	 * @return
	 */
	public String fillOutside( String line, int  outputWidth, FillOutsideMethods fillMethod, String delimiter ) {
		int remainingWidth = outputWidth - line.length();
		if (remainingWidth > 0) {
			switch ( fillMethod ) {
			case FILL_AROUND:
				return FillOutside.fillAround(line, remainingWidth, delimiter);
			case FILL_ON_LEFT:
				return FillOutside.fillOnLeft(line, remainingWidth, delimiter);
			case FILL_ON_RIGHT:
				return FillOutside.fillOnRight(line, remainingWidth, delimiter);
			case NONE:
				break;
			}
			return line;
		} else {
			return line;
		}
		
	}
	
}
