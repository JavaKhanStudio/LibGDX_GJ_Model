package jks.launcher;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import jks.amain.Main_Game;
import jks.launcher.settings.Utils_Launcher;
import jks.sounds.GVars_Audio; 

public class Launcher_Test 
{

	public static void main (String[] arg) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		Utils_Launcher.basicConfig(config) ; 
		testingMode(config);
	}
	
	public static void testingMode(LwjglApplicationConfiguration config)
	{
		GVars_Audio.muted = false ;
//		GVars_Debug.activatedDebug() ;
		Utils_Launcher.setSideTestScreen(config);
		new LwjglApplication(new Main_Game(), config);
	}
	
	
}
