package jks.launcher;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import jks.amain.Main_Game;
import jks.launcher.settings.Utils_Launcher;
import jks.sounds.GVars_Audio; 

public class Launcher_Test 
{

	public static void main (String[] arg) 
	{
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		Utils_Launcher.basicConfig(config) ; 
		testingMode(config);
	}
	
	public static void testingMode(Lwjgl3ApplicationConfiguration config)
	{
		GVars_Audio.muted = false ;
//		GVars_Debug.activatedDebug() ;
		Utils_Launcher.setSideTestScreen(config);
		new Lwjgl3Application(new Main_Game(), config);
	}
	
	
}
