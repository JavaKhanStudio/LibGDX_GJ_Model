package jks.vue.models;

import static jks.vinterface.Index_Interface.maisMenus_Background;
import static jks.vinterface.Index_Interface.manager;

import java.util.ArrayList;

import org.lwjgl.opengl.GL20;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import jks.camera.GVars_Camera;
import jks.input.IKM_Game_XBoxController;
import jks.input.Player_Inputs;
import jks.sounds.Enum_Music;
import jks.sounds.GVars_AudioManager;
import jks.vinterface.GVars_Ui;
import jks.vinterface.SmoothSideSelect;
import jks.vue.AVue_Model; 

public class Vue_Enter extends AVue_Model
{
	Texture background ;
	public Texture sourceTexture ;
	TextButton incrementOnce ;
	
	@Override
	public void init()
	{
		toRender = new ArrayList<>() ;
		
		background = manager.get(maisMenus_Background, Texture.class) ;
	

//		GVars_Ui.mainUi.addActor(background);
		
		GVars_AudioManager.PlayMusic(Enum_Music.INTRO);

		Gdx.input.setInputProcessor(new InputMultiplexer(GVars_Ui.mainUi));
		Controllers.clearListeners();
		Controllers.addListener(new IKM_Game_XBoxController()) ; 
		
//		GVars_Ui.mainUi.addActor(new Page_Main());
		GVars_Ui.mainUi.addActor(new SmoothSideSelect());
		incrementOnce = new TextButton("increment Once +",GVars_Ui.baseSkin) ; 
//		GVars_Ui.mainUi.addActor(incrementOnce);
	
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
		GVars_Ui.mainUi.act(delta);
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		GVars_Camera.staticBatch.begin() ;
		GVars_Camera.staticBatch.draw(background,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		GVars_Camera.staticBatch.end() ;
		
		renderBeforeInterface() ;
		drawInterface() ;
	}
}
