package interfaces;

import java.util.List;

import models.Language;
import models.User;

public interface ILanguage {

	public List<Language> getAllLanguages();
	
	public Language getLanguageById(long language_id);
	
	public User getLanguageByName(String language_name);
	
	public boolean deleteLanguage(Language language);
	
	public Language insertLanguage(Language language);
	
	public Language updateLanguage(Language language);
}
