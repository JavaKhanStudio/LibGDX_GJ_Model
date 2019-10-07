package jks.vinterface;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Index_Interface 
{
	
	public static final String icon = "ui/icon/";
	public static final String menu = icon + "menu/";
	public static final String pausePath = icon + "pause/";
	public static final String misc = "misc/" ;
	
	public static String maisMenus_Background = menu + "background.jpg" ;
	public static String mainMenus_Logo = menu + "logo.png";
	
	public static String pauseMenus_Background = pausePath + "pauseMenu.png";
	public static String pauseMenus_Back = pausePath + "boutonRetour.png";
	
	public static String label_CutSound = pausePath + "libelleCoupeSon.png";
	public static String checkbox_Ok = pausePath + "cocheOk.png";
	public static String checkBoxt_Empty = pausePath + "cocheVide.png";
	
	public static String empty = icon + "grayEmpty.png" ; 
	
	public static AssetManager manager ; 
	
	public static void init()
	{
		manager = new AssetManager();
		
		initEnter() ;
		initBasic() ; 
		
		manager.finishLoading();
	
	}
	
	private static void initBasic() 
	{
		manager.load(empty, Texture.class);
		
	}

	public static void initEnter()
	{
		manager.load(maisMenus_Background, Texture.class);
		manager.load(mainMenus_Logo, Texture.class);
		manager.load(pauseMenus_Background, Texture.class);
		manager.load(pauseMenus_Back, Texture.class);
		manager.load(label_CutSound, Texture.class);
		manager.load(checkbox_Ok, Texture.class);
		manager.load(checkBoxt_Empty, Texture.class);
		manager.finishLoading();
	}

	
}