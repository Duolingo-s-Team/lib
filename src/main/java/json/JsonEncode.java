package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonEncode {

	@SuppressWarnings("unchecked")
	public static String jsonContentInsertTest(String exercise_type, int exerciseExp, int exerciseCoins, String question, String correct_answer, String answers) {
		
		String content;

		JSONObject objectManager = new JSONObject();
		JSONArray objectArray = new JSONArray();
		
		if (exercise_type.equals("TIPUS_TEST")) {
			objectManager.put("exerciseType", exercise_type);
			objectManager.put("exerciseExp", exerciseExp);
			objectManager.put("exerciseCoins", exerciseCoins);
			objectManager.put("sentenceToTranslate", question);
			objectManager.put("correctAnswer", correct_answer);
			
			String[] totalAnswers = answers.split(";");
			for (int i = 0; i < totalAnswers.length; i++) {
				objectArray.add(totalAnswers[i]);
			}
			objectManager.put("wrongAnswers", objectArray);
			
			content = objectManager.toString();
			return content;
		}
		
		// Futuros ELSE IF para crear una condicion para cada tipo de ejercicio
		
		return null;
	}

}
