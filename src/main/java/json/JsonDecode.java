package json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDecode {
	
	public static JSONObject JsonGetContent(String contentJson) {

		JSONParser parser = new JSONParser();
		
		try {
			return (JSONObject) parser.parse(contentJson);
		} catch (ParseException e) {
			System.out.println("Parse error with content");
		}
		return null;
	}
}