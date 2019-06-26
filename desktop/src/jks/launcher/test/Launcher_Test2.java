package jks.launcher.test;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import jks.amain.Main_Game;
import jks.amain.test.Physics1;
import jks.amain.test.Physics2;
import jks.amain.test.Physics3;
import jks.debug.GVars_Debug;
import jks.launcher.settings.Utils_Launcher;
import jks.vue.models.Vue_Game;
import testing.GdxJoints; 

public class Launcher_Test2 
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
//		new LwjglApplication(new PhysicsTest(), config);
		new LwjglApplication(new GdxJoints(), config);
	}
	
	
}
