package jks.launcher.settings;

import static jks.launcher.settings.GVars_Laucher.finalHeight;
import static jks.launcher.settings.GVars_Laucher.finalWidth;
import static jks.launcher.settings.GVars_Laucher.sample;
import static jks.launcher.settings.GVars_Laucher.tailleTest;

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import jks.vars.FVars_Heart;

public class Utils_Launcher 
{

	public static void basicConfig(LwjglApplicationConfiguration config)
	{
		config.samples = sample; 
		config.vSyncEnabled = true ;
		config.resizable = false ;
		config.useGL30 = false ;
		config.title = "La chasse galerie" ; 
		
	}
	
	public static void setFullScreen(LwjglApplicationConfiguration config)
	{

		config.width = finalWidth ;
		config.height = finalHeight ;
		config.fullscreen = true ;
		
	}
	
	public static void setSideTestScreen(LwjglApplicationConfiguration config)
	{
		config.width = (int) (FVars_Heart.screenXModel * tailleTest) ;
		config.height = (int) (FVars_Heart.screenYModel * tailleTest) ;
		config.x = 0 ;
		config.y = 0 ;
	}
}
