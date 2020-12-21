package textalign.formatter.implementedformatters;

import textalign.formatter.Formatter;
import textalign.formatter.formatterutils.FillBetween.FillBetweenMethods;
import textalign.formatter.formatterutils.FillOutside.FillOutsideMethods;

public class CenterAlignFormatter extends Formatter {
	
	public static CenterAlignFormatter INSTANCE = new CenterAlignFormatter();

	public CenterAlignFormatter( ) {
		super( FillBetweenMethods.ONE_SPACE_BETWEEN_WORDS, FillOutsideMethods.FILL_AROUND);
	}
	
}
