package textalign.formatter.implementedformatters;

import textalign.formatter.Formatter;
import textalign.formatter.formatterutils.FillBetween.FillBetweenMethods;
import textalign.formatter.formatterutils.FillOutside.FillOutsideMethods;

public class LeftAlignFormatter extends Formatter {
	
	public static LeftAlignFormatter INSTANCE = new LeftAlignFormatter();

	public LeftAlignFormatter( ) {
		super( FillBetweenMethods.ONE_SPACE_BETWEEN_WORDS, FillOutsideMethods.FILL_ON_RIGHT);
	}
	
}
