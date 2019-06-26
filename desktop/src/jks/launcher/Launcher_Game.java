package jks.launcher;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import jks.amain.Main_Game;
import jks.debug.GVars_Debug;
import jks.launcher.settings.Utils_Launcher;
import jks.sounds.GVars_Audio;

public class Launcher_Game 
{

	public static void main (String[] arg) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		Utils_Launcher.basicConfig(config) ; 
		finalModelGame(config);
	}
	
	public static void finalModelGame(LwjglApplicationConfiguration config)
	{
		GVars_Audio.muted = false ;
		GVars_Debug.debugMode = false;
		Utils_Launcher.setFullScreen(config);
		new LwjglApplication(new Main_Game(), config);
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
