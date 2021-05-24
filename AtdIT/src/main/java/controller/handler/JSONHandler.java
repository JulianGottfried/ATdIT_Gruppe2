package main.java.controller.handler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.java.controller.handler.utilityHandler.InternalPathsHandler;
import main.java.model.ModelFactory;

/**
 * This handler gets the JSON structure that is required for the database and
 * for the questions set.
 * 
 * @author weilichsoheisse
 * @version 24.05.2021
 *
 */
public class JSONHandler {
	public String next;
	public String previous;
	private final String LINK2QUESTIONS = new InternalPathsHandler().getProperty("questions");

	/**
	 * Used to get the JSON Objects from the .properties file.
	 * 
	 * @param filename .properties file name
	 * @return Returns the JSON Objects or null.
	 */
	public JSONObject getBaseJSON(String filename) {
		JSONParser parser = new JSONParser();
		try (Reader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(LINK2QUESTIONS + filename), "UTF-8"))) {
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			return jsonObject;
		} catch (IOException e) {
			// TODO: logger
		} catch (ParseException e) {
			System.out.println("position: " + e.getPosition());
		}
		return null;
	}

	public String getString(JSONObject obj, String key) {
		try {
			return (String) obj.get(key);
		} catch (NullPointerException npe) {
			return null;
		}
	}

	public Boolean getBoolean(JSONObject obj, String key) {
		try {
			return (Boolean) obj.get(key);
		} catch (NullPointerException npe) {
			return null;
		}
	}

	public Date getDate(JSONObject obj, String key) {
		try {
			Date date = new SimpleDateFormat("dd-MM-yyyy").parse((String) obj.get(key));
			return date;
		} catch (NullPointerException npe) {
			return null;
		} catch (java.text.ParseException pe) {
			// TODO: logger
			return null;
		}
	}

	public int getInt(JSONObject obj, String key) {
		try {
			return (int) Double.parseDouble((String) obj.get(key));
		} catch (ClassCastException cce) {
			return (int) ((long) obj.get(key));
		} catch (NullPointerException npe) {
			// TODO: logger
			return 0;
		} catch (NumberFormatException nfe) {
			// TODO: logger
			return 0;
		}
	}

	public JSONObject getJSON(JSONObject obj, String key) {
		try {
			return (JSONObject) obj.get(key);
		} catch (ClassCastException cce) {
			// TODO: logger
			return new JSONObject();
		}
	}

	public JSONArray getJSONArray(JSONObject obj, String key, String language) {
		obj = this.getJSON(obj, key);
		try {
			return (JSONArray) obj.get(language);
		} catch (NullPointerException npe) {
			return null;
		}
	}

	public JSONObject getBaseModel(JSONObject initObj) {
		ModelFactory mf = new ModelFactory();

		String baseModelString = this.getString(initObj, "baseModel");
		Class<?> baseModelClass = null;
		try {
			baseModelClass = Class.forName(baseModelString);
		} catch (ClassNotFoundException e) {
			// TODO logger
		}

		return mf.modelToJSON(baseModelClass);
	}

	/**
	 * 
	 * @param baseModel    JSON Object from .properties
	 * @param answer       The Answer fro the question as String
	 * @param saveLocation The Location of the user. (not null)
	 */
	public void safeAnswerAt(JSONObject baseModel, String answer, String saveLocation) {
		if (saveLocation == null) {
			return;
		}
		String[] mapToLocation = saveLocation.split("\\.");
		for (int i = 0; i < mapToLocation.length - 1; i++) {
			baseModel = this.getJSON(baseModel, mapToLocation[i]);
		}
		String key = mapToLocation[mapToLocation.length - 1];
		baseModel.put(key, answer);
	}
}
