package main.java.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
		
		JSONObject testJSON = test.getBaseJSON("test.json");
		
		System.out.println(
				(JSONArray) testJSON.get("s")
				);
	}
	
	public JSONObject getBaseJSON(String filename) {
		JSONParser parser = new JSONParser();
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream("AtdIT/src/main/java/test/" + filename), "UTF-8"))) {
        	JSONObject jsonObject = (JSONObject) parser.parse(reader);
        	return jsonObject;
        } catch (IOException e) {
            //TODO: logger
        } catch (ParseException e) {
        	System.out.println("position: " + e.getPosition());
        }
        return null;
	}

}
