package main.java.controller.handler.utilityHandler;

import java.io.IOException;
import java.util.Properties;
/**
 * Interface used for the different properties handlers.
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public interface UtilityHandlerInterface {
	String propsPath = "AtdIT/src/main/resources/utilities/";
	
	public Properties retrieveProperties(String propName) throws IOException;
	
	public void setProp(Properties prop);
	
	public Properties getProp();
	
	public String getProperty(String key);
}
