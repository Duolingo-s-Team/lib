package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonEncode {

	@SuppressWarnings("unchecked")
	public static String jsonContentInsertTest(String exercise_type, String question, String correct_answer, String answers) {
		
		String content;

		JSONObject objectManager = new JSONObject();
		JSONArray objectArray = new JSONArray();
		
		if (exercise_type.equals("TIPUS_TEST")) {
			objectManager.put("Exercise_Type", exercise_type);
			objectManager.put("sentenceToTranslate", question);
			objectManager.put("Correct_Answer", correct_answer);
			
			String[] totalAnswers = answers.split(";");
			for (int i = 0; i < totalAnswers.length; i++) {
				objectArray.add(totalAnswers[i]);
			}
			objectManager.put("Wrong_Answers", objectArray);
			
			content = objectManager.toString();
			return content;
		}
		
		// Futuros ELSE IF para crear una condicion para cada tipo de ejercicio
		
		return null;
		
	}

}