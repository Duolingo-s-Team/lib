package interfaces;

import java.util.List;

import models.Level;

public interface ILevel {

	public List<Level> getAllLevels();
	
	public Level getLevelById(long level_id);
	
	public Level getLevelByName(String level_name);
	
	public boolean deleteLevel(Level level);
	
	public Level insertLevel(Level level);
	
	public Level updateLevel(Level level);
}
