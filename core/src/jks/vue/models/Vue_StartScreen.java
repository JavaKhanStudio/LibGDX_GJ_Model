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
import jks.input.IKM_Game_Keyboard;
import jks.input.IKM_Game_XBoxController;
import jks.input.Player_Inputs;
import jks.sounds.Enum_Music;
import jks.sounds.GVars_AudioManager;
import jks.vinterface.GVars_UI;
import jks.vinterface.StartScreen_SmoothSideSelect;
import jks.vue.AVue_Model; 

public class Vue_StartScreen extends AVue_Model
{
	Texture background ;
	public Texture sourceTexture ;
	TextButton incrementOnce ;
	StartScreen_SmoothSideSelect smoothSideSelect ; 
	
	private float gettingUpPercent = 0 ; 
	private final float gettingUpInXSec = 2 ; 
	
	@Override
	public void init()
	{
		toRender = new ArrayList<>() ;
		
		background = manager.get(maisMenus_Background, Texture.class) ;
		
		GVars_AudioManager.PlayMusic(Enum_Music.STARTING_SCREEN);
		
		Gdx.input.setInputProcessor(new InputMultiplexer(GVars_UI.mainUi, new IKM_Game_Keyboard()));
		Controllers.clearListeners();
		Controllers.addListener(new IKM_Game_XBoxController()) ; 
		
		smoothSideSelect = new StartScreen_SmoothSideSelect() ; 
		GVars_UI.mainUi.addActor(smoothSideSelect);
		incrementOnce = new TextButton("increment Once +",GVars_UI.baseSkin) ; 
		GVars_UI.resize();
		smoothSideSelect.enterScene(gettingUpInXSec/2);
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
		GVars_UI.mainUi.act(delta);
		gettingUpPercent += (1/gettingUpInXSec * delta) ; 
		
		if(gettingUpPercent > 1)
			gettingUpPercent = 1 ; 
	}
	
	

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		GVars_Camera.staticBatch.begin() ;
		GVars_Camera.staticBatch.setColor(gettingUpPercent, gettingUpPercent, gettingUpPercent, gettingUpPercent);
		GVars_Camera.staticBatch.draw(background,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		GVars_Camera.staticBatch.end() ;
		
		renderBeforeInterface() ;
		drawInterface() ;
	}
	
	@Override
	public void resize(int x, int y) 
	{
		super.resize(x,y) ; 
	}
}
