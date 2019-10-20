package jks.vue.models;

import static jks.camera.GVars_Camera.camera;
import static jks.camera.GVars_Camera.screenMovementSpeed;
import static jks.camera.GVars_Camera.staticBatch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;

import jks.debug.GVars_Debug;
import jks.input.GVars_Controller;
import jks.input.IKM_Game_Keyboard;
import jks.input.IKM_Game_XBoxController;
import jks.sounds.Enum_Music;
import jks.sounds.GVars_AudioManager;
import jks.tools2d.parallax.heart.Parallax_Heart;
import jks.vars.GVars_Game;
import jks.vars.GVars_Heart;
import jks.vinterface.GVars_UI;
import jks.vinterface.ToRender;
import jks.vue.AVue_Model;

public class Vue_Game extends AVue_Model
{
    
    boolean inDebug = true ; 
    Box2DDebugRenderer debugRenderer ;
    public static Sprite star1 ; 
    
    @Override
    public void init() 
    {
    	GVars_Heart.init();
    	GVars_Game.init();
    	
    	if(GVars_Debug.collisionDebug)
    		debugRenderer = new Box2DDebugRenderer() ; 
    	
    	Gdx.input.setInputProcessor(new InputMultiplexer(GVars_UI.mainUi, new IKM_Game_Keyboard()));
		Controllers.clearListeners();
		Controllers.addListener(new IKM_Game_XBoxController()) ; 
		GVars_AudioManager.PlayMusic(Enum_Music.GAME_INTRO);
    }

    @Override
    public void render() 
    {
    	camera.update();
    	Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        staticBatch.setProjectionMatrix(camera.combined);
    	
    	Parallax_Heart.worldCamera.position.add(screenMovementSpeed, 0, 0);
    	Parallax_Heart.renderMainPage();
		
    	staticBatch.begin();
  
    	staticBatch.end();
    	
    	Parallax_Heart.renderSecondePage();
    	   	
    	for (ToRender rende : toRender) 
			rende.render();
    }

	@Override
	public void destroy() 
	{}

	@Override
	public void restart() 
	{}

	@Override
	public void update(float delta) 
	{
		cleanUp() ; 
    	
    	GVars_Controller.act(delta);
    	
    	Parallax_Heart.act(delta);	
	}
	
	public void cleanUp()
	{
		
	}

	@Override
	public void resize(int x, int y) 
	{
		
	}
}