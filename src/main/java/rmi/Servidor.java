package rmi;

import java.io.IOException;
import java.net.Socket;

import implementations.CategoryImpl;
import implementations.CourseImpl;
import implementations.ExerciseImpl;
import implementations.ExerciseTypeImpl;
import implementations.FollowerImpl;
import implementations.FollowingImpl;
import implementations.LanguageImpl;
import implementations.LeagueImpl;
import implementations.LevelImpl;
import implementations.ShopImpl;
import implementations.UserImpl;
import interfaces.ICategory;
import interfaces.ICourse;
import interfaces.IExercise;
import interfaces.IExerciseType;
import interfaces.IFollower;
import interfaces.IFollowing;
import interfaces.ILanguage;
import interfaces.ILeague;
import interfaces.ILevel;
import interfaces.IShop;
import interfaces.IUser;
import net.sf.lipermi.exception.LipeRMIException;
import net.sf.lipermi.handler.CallHandler;
import net.sf.lipermi.net.IServerListener;
import net.sf.lipermi.net.Server;

public class Servidor {
	
	private static final int port = 25565;
	
	public static void main(String args[]) {
		CallHandler callHandler = new CallHandler();
		
		try {
			// Se registra el objeto en callHandler con la clase de la interfaz y el objeto de su implementacion
			callHandler.registerGlobal(ICategory.class, new CategoryImpl());
			callHandler.registerGlobal(ICourse.class, new CourseImpl());
			callHandler.registerGlobal(IExercise.class, new ExerciseImpl());
			callHandler.registerGlobal(IExerciseType.class, new ExerciseTypeImpl());
			callHandler.registerGlobal(IFollower.class, new FollowerImpl());
			callHandler.registerGlobal(IFollowing.class, new FollowingImpl());
			callHandler.registerGlobal(ILanguage.class, new LanguageImpl());
			callHandler.registerGlobal(ILeague.class, new LeagueImpl());
			callHandler.registerGlobal(ILevel.class, new LevelImpl());
			callHandler.registerGlobal(IShop.class, new ShopImpl());
			callHandler.registerGlobal(IUser.class, new UserImpl());
			
		} catch (LipeRMIException e) {
			System.out.println("Error al registrar el objecto" + e.getCause());
		}
		
		// Se inicia el servidor
		initComponents(port, callHandler);
	}
	
	/**Inicia el servidor en el puerto pasado como parametro con el objeto registrado en callHandler
	 * 
	 * @param port un entero con el puerto
	 * @param callHandler un CallHandler con el objeto registrado
	 */
	public static void initComponents(int port, CallHandler callHandler) {
		try {
			Server server = new Server();
			server.bind(port, callHandler);
			System.out.println("LipeRMI server initiated succesfully.");
			
			// Controlar la conexion de clientes al servidor
			server.addServerListener(new IServerListener() {
				@Override
				public void clientDisconnected(Socket arg0) {
					System.out.println("\nCliente desconectado.");
				}
				@Override
				public void clientConnected(Socket arg0) {
					System.out.println("\nCliente conectado en " + arg0.getInetAddress() + ":" + arg0.getPort());
				}
			});

		} catch (IOException e) {
			System.out.println("Error al iniciar el servidor. " + e.getMessage());
		}
	}

}
