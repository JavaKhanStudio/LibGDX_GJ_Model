package jks.vars;

import java.util.Random;

import com.badlogic.gdx.assets.AssetManager;

import jks.camera.GVars_Camera;
import jks.input.GVars_Controller;
import jks.sounds.GVars_AudioManager;
import jks.tools.Enum_Timming;
import jks.tools.GlobalTimmer;
import jks.vinterface.GVars_Interface;
import jks.vue.AVue_Model;

public class GVars_Heart 
{
	
	public static boolean debug = true;
	public static boolean isPaused = false ; 
	public static AVue_Model vue;
	public static final Random random = new Random();
	public static AssetManager assetManager = new AssetManager();
	public static boolean isFullScreen = false;

	public static void init() 
	{
		loadAssets() ; 
	
		GVars_Camera.init();
		GVars_Interface.init();
		GVars_Controller.init();
		GVars_Interface.init();
		
		GlobalTimmer.purge() ;
	}
 
	
	public static void loadAssets()
	{
		GlobalTimmer.registerTime(Enum_Timming.ASSETS);
		
//		Index_Sprite.init();
		GlobalTimmer.getElapse(Enum_Timming.ASSETS, "Sprite", true);
		
		GVars_AudioManager.init();
		GlobalTimmer.getElapse(Enum_Timming.ASSETS, "Sounds", true);
	}
	
	public static void changeVue(AVue_Model View,boolean cleanAll) 
	{
		if(cleanAll) {
			GVars_AudioManager.StopAndDisposeMusic();
			GVars_Heart.isPaused = false ; 
		}
		if (View != null) {
			vue = View;
			vue.init();
		} else {
			System.out.println("Aucune view?");
		}
	}

	public static void togglePauseMenu() 
	{
		GVars_Heart.isPaused = !GVars_Heart.isPaused ; 
		GVars_Interface.setPause(GVars_Heart.isPaused) ; 
	}

}
