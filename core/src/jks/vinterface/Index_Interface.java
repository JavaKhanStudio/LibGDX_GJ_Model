package jks.vinterface;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Index_Interface 
{
	
	public static final String menu = "ui/menu/";
	public static final String pausePath = "ui/pause/";
	public static final String misc = "misc/" ;
	
	
	//public static TextureRegionDrawable icon_LevelUp ;

	public static TextureRegionDrawable menuPrincipale ;
	public static TextureRegionDrawable menuLogo ;
	public static TextureRegionDrawable menuPrincipale_jouer ;
	public static TextureRegionDrawable menuPrincipale_credit ;
	public static TextureRegionDrawable menuPrincipale_quitter ;
	
	public static TextureRegionDrawable menuPause ;
	public static TextureRegionDrawable pauseRetour ;
	public static TextureRegionDrawable scoreBackground ;
	
	public static TextureRegionDrawable libelleCoupeSon ;
	public static TextureRegionDrawable cocheOk ;
	public static TextureRegionDrawable cocheVide ;
	
	public static TextureRegionDrawable nuageToxic ; 
	public static TextureRegionDrawable credit ;
	
	public static void init()
	{
		//icon_build = Utils_Interface.buildDrawingRegionTexture(standarPath + "build.png") ;
		menuPause  = Utils_Interface.buildDrawingRegionTexture(pausePath + "pauseMenu.png") ;
		pauseRetour = Utils_Interface.buildDrawingRegionTexture(pausePath + "boutonRetour.png") ;
		libelleCoupeSon = Utils_Interface.buildDrawingRegionTexture(pausePath + "libelleCoupeSon.png") ;
		scoreBackground = Utils_Interface.buildDrawingRegionTexture("ui/score/" + "scoreLabel.png") ;
		
		cocheOk = Utils_Interface.buildDrawingRegionTexture(pausePath + "cocheOk.png") ;
		cocheVide = Utils_Interface.buildDrawingRegionTexture(pausePath + "cocheVide.png") ;
		
		nuageToxic = Utils_Interface.buildDrawingRegionTexture(misc + "nuage_toxic.png") ;
		
		menuPrincipale = Utils_Interface.buildDrawingRegionTexture(menu + "ecran principal.jpg") ;
		menuLogo  = Utils_Interface.buildDrawingRegionTexture(menu + "logo.png") ;
		menuPrincipale_jouer  = Utils_Interface.buildDrawingRegionTexture(menu + "bouton_jouer.png") ;
		menuPrincipale_credit  = Utils_Interface.buildDrawingRegionTexture(menu + "bouton_credit.png") ;
		menuPrincipale_quitter  = Utils_Interface.buildDrawingRegionTexture(menu + "bouton_quitter.png") ;
		
		credit  = Utils_Interface.buildDrawingRegionTexture(menu + "credit.png") ;
	}
	
	
}
