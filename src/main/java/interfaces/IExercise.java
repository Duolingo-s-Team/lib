package interfaces;

import java.util.List;

import models.Exercise;

public interface IExercise {

	public List<Exercise> getAllExercises();
	
	public Exercise getExerciseById(long exercise_id);

	public Exercise getExerciseByName(String exercise_name);
	
	public boolean deleteExercise(Exercise exercise);
	
	public Exercise insertExercise(Exercise exercise);
	
	public Exercise updateExercise(Exercise exercise);
}
