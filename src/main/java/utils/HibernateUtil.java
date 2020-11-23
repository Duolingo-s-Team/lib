package utils;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import models.Category;
import models.Course;
import models.Exercise;
import models.ExerciseType;
import models.Language;
import models.League;
import models.Level;
import models.Shop;
import models.User;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/Duolingo");
                
                settings.put(Environment.USER, "DuolingoManager");
                settings.put(Environment.PASS, "NoSeProgramar0.");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);
                
                // Clases:
                configuration.addAnnotatedClass(Category.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(Exercise.class);
                configuration.addAnnotatedClass(ExerciseType.class);
               	configuration.addAnnotatedClass(Language.class);
                configuration.addAnnotatedClass(League.class);
                configuration.addAnnotatedClass(Level.class);
                configuration.addAnnotatedClass(Shop.class);
                configuration.addAnnotatedClass(User.class);
                

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
