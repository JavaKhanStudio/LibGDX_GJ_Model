package jks.launcher.settings;

import static jks.launcher.settings.GVars_Laucher.finalHeight;
import static jks.launcher.settings.GVars_Laucher.finalWidth;
import static jks.launcher.settings.GVars_Laucher.tailleTest;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import jks.vars.FVars_Heart;
import jks.vars.GVars_Heart;

public class Utils_Launcher 
{

	public static void basicConfig(Lwjgl3ApplicationConfiguration config)
	{
		config.setBackBufferConfig(8, 8, 8, 8, 32, 2, 4);
		config.useVsync(true) ;
		config.setResizable(false); ;
		config.setTitle("generic") ; 
		
	}
	
	public static void setFullScreen(Lwjgl3ApplicationConfiguration config)
	{
		basicConfig(config) ; 
		config.setWindowedMode(finalWidth, finalHeight);
		GVars_Heart.isFullScreen = true ; 
	}
	
	public static void setSideTestScreen(Lwjgl3ApplicationConfiguration config)
	{
		config.setWindowedMode((int) (FVars_Heart.screenXModel * tailleTest), (int) (FVars_Heart.screenYModel * tailleTest));
		config.setWindowPosition(45, 45);
	}
}
