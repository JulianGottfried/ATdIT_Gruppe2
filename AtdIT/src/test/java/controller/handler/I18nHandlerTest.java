package test.java.controller.handler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.controller.handler.I18nHandler;

/**
 * The I18nHandler Test checks the link construction, that creates a link to the
 * required language file.
 * 
 * @author weilichsoheisse
 * @version 22.05.2021
 *
 */
public class I18nHandlerTest {
	@Test
	public void checkIfI18nHandlerConstructsTheRightLink() {
		String requiredLink = "main/resources/i18n/DateAnswer/DateAnswer";
		String generatedLink = I18nHandler.constructBundleLink("DateAnswer");
		assertEquals(requiredLink, generatedLink);
	}
}
