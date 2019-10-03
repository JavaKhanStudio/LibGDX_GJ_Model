package jks.vue.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import jks.input.IKM_Game_XBoxController;
import jks.input.Player_Inputs;
import jks.sounds.Enum_Music;
import jks.sounds.GVars_AudioManager;
import jks.vinterface.GVars_Interface;
import jks.vinterface.Index_Interface;
import jks.vinterface.Page_Main;
import jks.vue.AVue_Model;


public class Vue_Enter extends AVue_Model
{
	Image background ;

	@Override
	public void init()
	{
		background = new Image(Index_Interface.maisMenus_Background);
		background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()) ;
		GVars_Interface.mainInterface.addActor(background);
		
		GVars_AudioManager.PlayMusic(Enum_Music.INTRO);

		Gdx.input.setInputProcessor(new InputMultiplexer(GVars_Interface.mainInterface));
		Controllers.clearListeners();
		Controllers.addListener(new IKM_Game_XBoxController()) ; 
		
		GVars_Interface.mainInterface.addActor(new Page_Main());
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
		Player_Inputs.updateInput_ControllingInterface() ;
	}

	@Override
	public void render()
	{
		clear() ;
		renderBeforeInterface() ;
		drawInterface() ;	
	}
}
