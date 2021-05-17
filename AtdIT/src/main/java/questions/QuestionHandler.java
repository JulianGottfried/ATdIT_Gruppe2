package main.java.questions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.java.controller.handler.utilityHandler.InternalPathsHandler;

public class QuestionHandler {
	public String next;
	public String previous;
	final String LINK2QUESTIONS = new InternalPathsHandler().getProperty("questions");

	
	public JSONObject getQuestion(String filename) {
		JSONParser parser = new JSONParser();
		System.out.println(LINK2QUESTIONS + filename);
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
}
