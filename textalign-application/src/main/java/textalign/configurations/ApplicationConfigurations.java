package textalign.configurations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import textalign.generalutils.StringUtils;
import textalign.interfaces.isPresentable;

public class ApplicationConfigurations implements isPresentable {
	
	// An unmodifiable list of the presently implemented formatting methods
	private static final List<FormattingMethods> implementedFormattingMethods = Collections.unmodifiableList(Arrays.asList(
		FormattingMethods.LEFT,
		FormattingMethods.RIGHT,
		FormattingMethods.CENTER,
		FormattingMethods.JUSTIFY
	));
	
	private FormattingMethods _formattingMethod;
	private int _outputWidth;
	
	public ApplicationConfigurations( String formattingMethodArgument, String outputWidthArgument ) throws Exception {
		setFormattingMethod(formattingMethodArgument);
		setOutputWidth(outputWidthArgument);
	}
	
	public FormattingMethods getFormattingMethod() {
		return _formattingMethod;
	}
	
	public int getOutputWidth() {
		return _outputWidth;
	}
	
	/**
	 * Sets outputWidth if the inputted string is valid, otherwise throws exception
	 * @param outputWidthArgument
	 * @throws Exception
	 */
	private void setOutputWidth(String outputWidthArgument) throws Exception {
		try {
			int widthValue = ApplicationConfigurationUtils.parseStringToInt(outputWidthArgument);
			if (ApplicationConfigurationUtils.widthIsValid(widthValue)) {
				_outputWidth = widthValue;
			} else {
				throw new Exception("An output width \"" + widthValue + "\" is not supported");
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Sets formatting method if any one matching the inputted string is found, otherwise throws exception
	 * @param formattingMethodArgument
	 * @throws Exception
	 */
	private void setFormattingMethod( String formattingMethodArgument ) throws Exception {
		Optional<FormattingMethods> optionFormattingMethod = ApplicationConfigurationUtils.matchFormattingArgument( formattingMethodArgument, ApplicationConfigurations.implementedFormattingMethods );
		boolean matchFound = optionFormattingMethod.isPresent();
		if ( matchFound ) {
			_formattingMethod = optionFormattingMethod.get();
		} else {
			throw new Exception("The formatting method \"" + formattingMethodArgument + "\" is not supported");
		}
		
	}
	
	@Override
	public String getInstanceDetails() {
		String formattingMethod = "FormattingMethod : " + _formattingMethod.getMatchString();
		String outputWidth = "OutputWidth      : " + _outputWidth;
		
		String compositeString = "AppConfigurations:" + "\n"
				+ "[" + "\n"
				+ StringUtils.indentOneLevel( formattingMethod ) + "\n"
				+ StringUtils.indentOneLevel( outputWidth ) + "\n"
				+ "]";
		
		return compositeString;
				
	}
	
	

}
