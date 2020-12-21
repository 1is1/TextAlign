package textalign.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import textalign.configurations.ApplicationConfigurations;
import textalign.generalutils.StringUtils;
import textalign.interfaces.isPresentable;

public class TextFormatterClient implements isPresentable{
	
	private ApplicationConfigurations _configs;
	
	public TextFormatterClient( ApplicationConfigurations configs ) {
		_configs = configs;
	}
	
	/**
	 * Formats the string based on the client's configurations
	 * @param inputString
	 * @return
	 */
	public String formatString( String inputString ) {
		return _configs.getFormattingMethod().getFormatter().formatString(inputString, _configs.getOutputWidth());
	}
	
	/**
	 * Handles the user input loop and progressively formats strings provided by the user - or exits if empty string is given
	 */
	public void handleUserInput( ) {
		System.out.println(getInstanceDetails() + "\n");
		System.out.println("Input:");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    try {
			while ((s = in.readLine()) != null && s.length() != 0) {
				String formattedString = formatString(s);
				System.out.println("\nOutput: ");
				System.out.println(formattedString);
				System.out.println("\nInput: ");
			}
			if ( s.length() == 0) {
				System.out.println("Empty input received; exiting.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getInstanceDetails() {
		String configDetails = _configs.getInstanceDetails();
		String compositeString =
				"TextFormatterClient:" + "\n"
				+ "[" + "\n"
				+ StringUtils.indentOneLevel( configDetails ) + "\n"
				+ "]";
		
		return compositeString;
	}

}
