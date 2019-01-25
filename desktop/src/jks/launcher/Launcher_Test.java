package jks.launcher;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import jks.amain.Main_Game;
import jks.debug.GVars_Debug;
import jks.launcher.settings.Utils_Launcher; 

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
		Utils_Launcher.setSideTestScreen(config);
		GVars_Debug.debugMode = true;
		new LwjglApplication(new Main_Game(), config);
	}
	
	
}
