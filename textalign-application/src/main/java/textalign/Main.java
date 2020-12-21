package textalign;

import textalign.client.TextFormatterClient;
import textalign.configurations.ApplicationConfigurations;

public class Main {
	
	public static void main( String[] args ) {
		if (args.length > 1) {
			String formattingMethodArgument = args[0];
			String outputWidthArgument = args[1];
			try {
				TextFormatterClient client = setupClient( formattingMethodArgument, outputWidthArgument );
				client.handleUserInput();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println( "Please supply the application with a formatting type and an output width.");
		}
		
		
	}
	
	private static TextFormatterClient setupClient( String formattingMethodArgument, String outputWidthArgument ) throws Exception {
		System.out.println("TextFormatter 0.1.0" + "\n"
				+ "..." + "\n"
				+ "Setting up client ..." + "\n");
		
		ApplicationConfigurations appConfigs = new ApplicationConfigurations( formattingMethodArgument, outputWidthArgument );
		TextFormatterClient client = new TextFormatterClient(appConfigs);
		
		return client;
		
	}

	

}
