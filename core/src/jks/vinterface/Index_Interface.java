package jks.vinterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Index_Interface 
{
	
	public static final String menu = "ui/icon/menu/";
	public static final String pausePath = "ui/icon/pause/";
	public static final String misc = "misc/" ;
	

	public static TextureRegionDrawable maisMenus_Background ;
	public static TextureRegionDrawable mainMenus_Logo ;
	public static TextureRegionDrawable mainMenus_PlayButton ;
	public static TextureRegionDrawable mainMenus_CreditButton ;
	public static TextureRegionDrawable mainMenus_Quit ;
	
	public static TextureRegionDrawable pauseMenus ;
	public static TextureRegionDrawable pauseMenus_Back ;
	
	public static TextureRegionDrawable scoreBackground ;
	
	public static TextureRegionDrawable label_CutSound ;
	public static TextureRegionDrawable checkbox_Ok ;
	public static TextureRegionDrawable checkBoxt_Empty ;
	
	public static TextureRegionDrawable credit ;
	
	public static void init()
	{
		pauseMenus  = Utils_Interface.buildDrawingRegionTexture(pausePath + "pauseMenu.png") ;
		pauseMenus_Back = Utils_Interface.buildDrawingRegionTexture(pausePath + "boutonRetour.png") ;
		label_CutSound = Utils_Interface.buildDrawingRegionTexture(pausePath + "libelleCoupeSon.png") ;
		scoreBackground = Utils_Interface.buildDrawingRegionTexture("ui/score/" + "scoreLabel.png") ;
		
		checkbox_Ok = Utils_Interface.buildDrawingRegionTexture(pausePath + "cocheOk.png") ;
		checkBoxt_Empty = Utils_Interface.buildDrawingRegionTexture(pausePath + "cocheVide.png") ;
		
		maisMenus_Background = Utils_Interface.buildDrawingRegionTexture(menu + "startScreen2.jpg") ;
		
		mainMenus_Logo  = Utils_Interface.buildDrawingRegionTexture(menu + "logo.png") ;
		mainMenus_PlayButton  = Utils_Interface.buildDrawingRegionTexture(menu + "bouton_jouer.png") ;
		mainMenus_CreditButton  = Utils_Interface.buildDrawingRegionTexture(menu + "bouton_credit.png") ;
		mainMenus_Quit  = Utils_Interface.buildDrawingRegionTexture(menu + "bouton_quitter.png") ;
		
		credit  = Utils_Interface.buildDrawingRegionTexture(menu + "credit.png") ;
	
		
	
	}
	
	
}
