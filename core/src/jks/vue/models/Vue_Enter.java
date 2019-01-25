package jks.vue.models;

import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import jks.input.GVars_Inputs;
import jks.input.IKM_Game_XBoxController;
import jks.sounds.Enum_Music;
import jks.sounds.GVars_AudioManager;
import jks.vinterface.Page_Main;
import jks.vue.AVue_Model;



public class Vue_Enter extends AVue_Model
{
	Image background ;

	@Override
	public void init()
	{
		new Page_Main() ;
		GVars_AudioManager.PlayMusic(Enum_Music.Menu_House);
		
//		Gdx.input.setInputProcessor(new InputMultiplexer(GVars_Interface.mainInterface, new IKM_StartingScreen_Keyboard()));
		Controllers.clearListeners();
		Controllers.addListener(new IKM_Game_XBoxController()) ; 
	}

	@Override
	public void destroy()
	{
		
		
	}

	@Override
	public void restart()
	{
		
		
	}

	@Override
	public void update(float delta)
	{
		GVars_Inputs.updateInput_ControllingInterface() ;
	}

	@Override
	public void render()
	{
		clear() ;
		renderBeforeInterface() ;
		drawInterface() ;	

	}
}
