package jks.launcher;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import jks.amain.Main_Game;
import jks.debug.GVars_Debug;
import jks.sounds.GVars_Audio;

public class Launcher_Game 
{

	public static void main (String[] arg) 
	{
//		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
//		Utils_Launcher.basicConfig(config) ; 
//		finalModelGame(config);
		
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(1300, 800);
		config.useOpenGL3(true, 1, 1);
		config.setTitle("Parallax");
		//config.setWindowIcon("skins/uis/parallaxIcon.png");

		config.useVsync(true);
		
		config.setBackBufferConfig(8, 8, 8, 8, 32, 2, 4);
		
		Lwjgl3Application application = new Lwjgl3Application(new Main_Game(), config);
	
	}
	
	public static void finalModelGame(Lwjgl3ApplicationConfiguration config)
	{
		GVars_Audio.muted = false ;
		GVars_Debug.debugMode = false;
		new Lwjgl3Application(new Main_Game(), config);
	}
	
	/*
	public static void activateGame(LwjglApplicationConfiguration config)
	{
		config.width = (int) (16 * taille) ;
		config.height = (int) (9 * taille) ;
		new LwjglApplication(new Main_Game(), config);
	}
	*/
	
}
