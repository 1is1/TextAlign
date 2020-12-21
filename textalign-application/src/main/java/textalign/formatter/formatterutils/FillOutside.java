package textalign.formatter.formatterutils;

public class FillOutside {
	
	public enum FillOutsideMethods {
		FILL_ON_LEFT,
		FILL_ON_RIGHT,
		FILL_AROUND, 
		NONE
	}
	
	/**
	 * Fills space progressively evenly around the input string
	 * (Progressively since there may not be an even amount of spaces to give out, in which case there will be more spaces on the left side)
	 * @param line
	 * @param remainingWidth
	 * @return
	 */
	public static String fillAround(String line, int remainingWidth, String delimiter) {
		int fillCount = ( remainingWidth / 2 ) / delimiter.length();
		String fill = FormatterUtils.createFillString( fillCount, delimiter);
		line = fill + line + fill;
		
		if (fill.length() * 2 < remainingWidth) {
			line = line + " ";
		}
		
		return line;
	}
	
	/**
	 * Fills space on the left side of the string
	 * @param line
	 * @param remainingWidth
	 * @return
	 */
	public static String fillOnLeft(String line, int remainingWidth, String delimiter ) {
		int fillCount = remainingWidth / delimiter.length();
		String fill = FormatterUtils.createFillString( fillCount, delimiter );
		line = fill + line;
		
		return line;
	}
	
	/**
	 * Fill space on the right side of the string
	 * @param line
	 * @param remainingWidth
	 * @return
	 */
	public static String fillOnRight(String line, int remainingWidth, String delimiter ) {
		int fillCount = remainingWidth / delimiter.length();
		String fill = FormatterUtils.createFillString( fillCount, delimiter );
		line = line + fill;
		
		return line;
	}
	
	
}


