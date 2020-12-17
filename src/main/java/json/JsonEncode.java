package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")
public class JsonEncode {

	
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
		
		return null;
	}

	public static String jsonContentInsertOpenTraduct(String exercise_type, int exerciseExp, int exerciseCoins, String question, String[] answers) {
		
		String content;

		JSONObject objectManager = new JSONObject();
		JSONArray objectArray = new JSONArray();
		
		if (exercise_type.equals("TRADUCCIO_OBERTA")) {
			objectManager.put("exerciseType", exercise_type);
			objectManager.put("exerciseExp", exerciseExp);
			objectManager.put("exerciseCoins", exerciseCoins);
			objectManager.put("sentenceToTranslate", question);
			
			
			for (int i = 0; i < answers.length; i++) {
				objectArray.add(answers[i]);
			}
			objectManager.put("traductedSentences", objectArray);
			
			content = objectManager.toString();
			return content;
			
		}
		
		return null;
	}

}
