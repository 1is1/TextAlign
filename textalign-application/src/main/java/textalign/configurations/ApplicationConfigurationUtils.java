package textalign.configurations;

import java.util.List;
import java.util.Optional;

public class ApplicationConfigurationUtils {
	
	/***
	 * Attempts to match if the passed string represents any of the implemented formatting methods
	 * @param formattingArgument
	 * @param implementedFormattingMethods
	 * @return an optional formatting method
	 */
	public static Optional<FormattingMethods> matchFormattingArgument( String formattingArgument, List<FormattingMethods> implementedFormattingMethods ) {
		Optional<FormattingMethods> optionalMatch = implementedFormattingMethods.stream()
			.filter( x -> x.getMatchString().equals( formattingArgument ) )
			.findAny();
		
		return optionalMatch;
	}
	
	/***
	 *  Try to parse a value, throws exception if it doesn't successfully manage to do so
	 * @param value
	 * @return value
	 * @throws NumberFormatException
	 */
	public static int parseStringToInt( String value ) throws NumberFormatException {
		return Integer.parseInt(value);	
	}
	
	/***
	 * Ensures that the width value is meaningful for formatting
	 * @param value
	 * @return true if the width is valid
	 */
	public static boolean widthIsValid( int value ) {
		return value > 0;
	}
		
}
