package jks.launcher.settings;

import static jks.launcher.settings.GVars_Laucher.finalHeight;
import static jks.launcher.settings.GVars_Laucher.finalWidth;
import static jks.launcher.settings.GVars_Laucher.sample;
import static jks.launcher.settings.GVars_Laucher.tailleTest;

import org.lwjgl.util.Display;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import jks.vars.FVars_Heart;

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
		config.width = finalWidth ;
		config.height = finalHeight ;
		config.setFullscreenMode(Display.().());
		config.setFullscreenMode(DisplayMode);
		
	}
	
	public static void setSideTestScreen(Lwjgl3ApplicationConfiguration config)
	{
		config.width = (int) (FVars_Heart.screenXModel * tailleTest) ;
		config.height = (int) (FVars_Heart.screenYModel * tailleTest) ;
		config.x = 0 ;
		config.y = 0 ;
	}
}
