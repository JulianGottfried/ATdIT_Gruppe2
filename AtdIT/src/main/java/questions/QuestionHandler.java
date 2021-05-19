package main.java.questions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.java.controller.handler.utilityHandler.InternalPathsHandler;
import main.java.model.ModelFactory;
import main.java.view.guiElements.JPanelElems.QALabel;

public class QuestionHandler {
	public String next;
	public String previous;
	private final String LINK2QUESTIONS = new InternalPathsHandler().getProperty("questions");

	
	public JSONObject getQuestionsFromJSON(String filename) {
		JSONParser parser = new JSONParser();
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(LINK2QUESTIONS + filename), "UTF-8"))) {
        	JSONObject jsonObject = (JSONObject) parser.parse(reader);
        	return jsonObject;
        } catch (IOException e) {
            //TODO: logger
        } catch (ParseException e) {
        	System.out.println("position: " + e.getPosition());
        }
        return null;
	}
	
	public String getString(JSONObject obj, String key) {
		return (String) obj.get(key);
	}
	
	public JSONObject getJSON(JSONObject obj, String key) {
		return (JSONObject) obj.get(key);
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
		
		return mf.turnToJSON(baseModelClass);
	}
	
	public void safeAnswerAt(JSONObject baseModel, String answer, String saveLocation) {
		String[] mapToLocation = saveLocation.split("\\.");
		for (int i=0; i<mapToLocation.length-1; i++) {
			baseModel = this.getJSON(baseModel, mapToLocation[i]);
		}
		String key = mapToLocation[mapToLocation.length - 1];
		baseModel.put(key, answer);
	}
}
