package interfaces;

import java.util.List;

import models.ExerciseType;

public interface IExerciseType {

	public List<ExerciseType> getAllExerciseTypes();
	
	public ExerciseType getExerciseTypeById(long exerciseType_id);
	
	public boolean deleteExerciseType(ExerciseType exerciseType);
	
	public ExerciseType insertExerciseType(ExerciseType exerciseType);
	
	public ExerciseType updateExerciseType(ExerciseType exerciseType);
}
