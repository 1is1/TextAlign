package textalign.configurations;

import textalign.formatter.Formatter;
import textalign.formatter.implementedformatters.CenterAlignFormatter;
import textalign.formatter.implementedformatters.JustifyFormatter;
import textalign.formatter.implementedformatters.LeftAlignFormatter;
import textalign.formatter.implementedformatters.RightAlignFormatter;

/*
 * Enum to ensure strict-ish handling of formatting methods
 */
public enum FormattingMethods {
	
	// Enum listing
	LEFT("left align", LeftAlignFormatter.INSTANCE),
	RIGHT("right align", RightAlignFormatter.INSTANCE ),
	CENTER("center", CenterAlignFormatter.INSTANCE ),
	JUSTIFY("justify", JustifyFormatter.INSTANCE ),
	HARD("hard", null );
	
	private String _matchString;
	private Formatter _formatter;
	
	private FormattingMethods( String matchString, Formatter formatter ) {
		_matchString = matchString;
		_formatter = formatter;
	}
	
	public String getMatchString() {
		return _matchString;
	}
	
	public Formatter getFormatter() {
		return _formatter;
	}
}
