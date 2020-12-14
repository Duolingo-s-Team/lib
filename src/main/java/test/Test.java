package test;

import implementations.CourseImpl;
import interfaces.ICourse;
import models.Category;
import models.Course;

public class Test {

	public static void main(String[] args) {
		ICourse courseManager = new CourseImpl();
		Course spanishEnglish = new Course("Spanish", "English");
		Course spanishCatalan = new Course("Spanish", "Catalan");
		
		Category viajes = new Category("viajes");			// Spanish
		Category comida = new Category("comida");			// Spanish
		Category animales = new Category("animales");		// Spanish
		Category vegetacio = new Category("vegetacio");		// Spanish
		Category tecnologia = new Category("tecnologia");	// Spanish
		Category familia = new Category("familia");			// Spanish
		
		spanishEnglish.addCategory(viajes);
		spanishEnglish.addCategory(comida);
		spanishEnglish.addCategory(animales);
		
		spanishCatalan.addCategory(vegetacio);
		spanishCatalan.addCategory(tecnologia);
		spanishCatalan.addCategory(familia);
		
		courseManager.insertCourse(spanishEnglish);
		courseManager.insertCourse(spanishCatalan);
		
	}

}
