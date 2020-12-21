package textalign.generalutils;

import java.util.Arrays;

public class StringUtils {
	
	/**
	 * Indents each line of the given string n spaces
	 * @param inputString
	 * @param n
	 * @return
	 */
	private static String indentString( String inputString, int n ) {
	      char[] chars = new char[n];
	      Arrays.fill( chars, ' ' );
	      String indented = inputString.replaceAll( "(?m)^", new String( chars ) );
	      return indented;
	  }
	
	/**
	 * Indents each line of the given string 2 spaces
	 * @param inputString
	 * @return
	 */
	public static String indentOneLevel( String inputString ) {
		return indentString( inputString, 2 );
	}
	
}
