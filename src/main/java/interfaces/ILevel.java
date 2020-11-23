package interfaces;

import java.util.List;

import models.Level;

public interface ILevel {

	public List<Level> getAllLevels();
	
	public Level getLevelById(long level_id);
	
	public boolean deleteLevel(Level level);
	
	public Level insertLevel(Level level);
	
	public Level updateLevel(Level level);
}
