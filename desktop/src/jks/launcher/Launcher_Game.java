package jks.launcher;

import java.io.File;

import org.lwjgl.opengl.Display;

import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import jks.amain.GameConfigs;
import jks.amain.Main_Application;
import jks.debug.GVars_Debug;
import jks.launcher.settings.Utils_Launcher;
import jks.sounds.GVars_Audio;
import jks.vars.GVars_Heart;

public class Launcher_Game 
{
	
	
	public static void main (String[] arg) 
	{
			
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		
		Utils_Launcher.loadConfig(config) ; 
		
		config.setWindowedMode(1280, 720);
		config.useOpenGL3(true, 1, 1);
		config.setTitle("GENERIC");
		config.setResizable(false);
		
//		config.setBackBufferConfig(8, 8, 8, 8, 32, 2, 4);
		
		Lwjgl3Application application = new Lwjgl3Application(new Main_Application(), config);
	
	}
	
	public static void finalModelGame(Lwjgl3ApplicationConfiguration config)
	{
		GVars_Audio.muted = false ;
		GVars_Debug.debugMode = false;
		new Lwjgl3Application(new Main_Application(), config);
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
