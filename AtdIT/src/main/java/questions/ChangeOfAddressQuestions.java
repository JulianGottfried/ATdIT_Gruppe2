package main.java.questions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.java.controller.handler.languageHandler.I18nHandler;
import main.java.controller.handler.utilityHandler.InternalPathsHandler;

public class ChangeOfAddressQuestions extends QuestionHandler {
	public ChangeOfAddressQuestions() {
		readQuestions();
	}
	
	public void readQuestions() {
		JSONParser parser = new JSONParser();
		
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(LINK2QUESTIONS + "ChangeOfAddressQuestions.json"), "UTF-8"))) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);
            
            JSONObject questionObj;
            this.next = (String) jsonObject.get("initial");
            
            while (true) {
            	questionObj = (JSONObject) jsonObject.get(this.next);
            	this.next = (String) questionObj.getOrDefault("next", null);
            	
            	System.out.println(questionObj.get("q"));
            	
            	
            	if (this.next == null) {
            		break;
            	}
            }
            

//            String name = (String) jsonObject.get("name");
//            System.out.println(name);
//
//            long age = (Long) jsonObject.get("age");
//            System.out.println(age);
//
//            // loop array
//            JSONArray msg = (JSONArray) jsonObject.get("messages");
//            Iterator<String> iterator = msg.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }

        } catch (IOException e) {
            //TODO: logger
        } catch (ParseException e) {
        	//TODO: logger
        }
	}
}
