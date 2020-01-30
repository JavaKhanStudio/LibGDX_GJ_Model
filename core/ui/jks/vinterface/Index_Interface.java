package jks.vinterface;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import jks.tools.Enum_Timming;
import jks.tools.GlobalTimmer;

public class Index_Interface 
{

	public static final String frame = "ui/frame/";
	public static final String icon = "ui/icon/";
	public static final String menu = icon + "menu/";
	public static final String pausePath = icon + "pause/";
	public static final String preload = "ui/preload/" ;
	public static final String misc = "misc/" ;
	
	public static String maisMenus_Background = menu + "background.jpg" ;
	public static String mainMenus_Logo = menu + "logo.png";
	
	public static String pauseMenus_Background = pausePath + "pauseMenu.png";
	public static String pauseMenus_Back = pausePath + "boutonRetour.png";
	
	public static String label_CutSound = pausePath + "libelleCoupeSon.png";
	public static String checkbox_Ok = pausePath + "cocheOk.png";
	public static String checkBoxt_Empty = pausePath + "cocheVide.png";
	
	public static String empty = icon + "grayEmpty.png" ; 
	public static String frame_Gray = frame + "grayFrame.png" ; 
	public static String frame_GraySmoke = frame + "borderSmokeGray.png" ; 
	
	public static String introLogo_Jam = preload + "logo_jam.png" ; 
	public static String introLogo_LibGDX = preload + "logo_libGdx.png" ; 
	public static String introLogo_Team = preload + "logo_team.png" ; 
	
	
	
	
	public static AssetManager manager ; 
	
	public static void preInit()
	{
		manager = new AssetManager();
		initPreloading() ;	
	}
	

	public static void init()
	{
		if(manager == null)
			manager = new AssetManager();
		
		GlobalTimmer.registerTime(Enum_Timming.CONTROLLER_MOVE);
		
		initEnter() ;
		initBasic() ; 
		
		manager.finishLoading();
	
	}
	
	private static void initPreloading() 
	{
		manager.load(introLogo_Jam, Texture.class);
		manager.load(introLogo_LibGDX, Texture.class);
		manager.load(introLogo_Team, Texture.class);
		manager.finishLoading();
	}

	
	private static void initBasic() 
	{
		manager.load(empty, Texture.class);
		manager.load(frame_Gray, Texture.class);
		manager.load(frame_GraySmoke, Texture.class);
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