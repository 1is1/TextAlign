package textalign.formatter.implementedformatters;

import textalign.formatter.Formatter;
import textalign.formatter.formatterutils.FillBetween.FillBetweenMethods;
import textalign.formatter.formatterutils.FillOutside.FillOutsideMethods;

public class RightAlignFormatter extends Formatter {
	
	public static RightAlignFormatter INSTANCE = new RightAlignFormatter();

	public RightAlignFormatter( ) {
		super( FillBetweenMethods.ONE_SPACE_BETWEEN_WORDS, FillOutsideMethods.FILL_ON_LEFT);
	}
	
}
