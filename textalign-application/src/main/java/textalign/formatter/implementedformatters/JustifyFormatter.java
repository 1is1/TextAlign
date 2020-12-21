package textalign.formatter.implementedformatters;

import textalign.formatter.Formatter;
import textalign.formatter.formatterutils.FillBetween.FillBetweenMethods;
import textalign.formatter.formatterutils.FillOutside.FillOutsideMethods;

public class JustifyFormatter extends Formatter {
	
	public static JustifyFormatter INSTANCE = new JustifyFormatter();

	public JustifyFormatter( ) {
		super( FillBetweenMethods.DISTRIBUTE_ALL_REMAINING_SPACE_BETWEEN_WORDS, FillOutsideMethods.FILL_AROUND );
	}
	
	
	
}
