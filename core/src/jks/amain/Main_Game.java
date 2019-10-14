package jks.amain;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.graphics.GL20;

import jks.camera.GVars_Camera;
import jks.input.GVars_Controller;
import jks.input.Player_Inputs;
import jks.vars.GVars_Heart;
import jks.vinterface.GVars_UI;
import jks.vinterface.Index_Interface;
import jks.vue.models.Vue_StartScreen;

public class Main_Game extends ApplicationAdapter 
{


	@Override
	public void create () 
	{
//		GVars_UI.init() ; 
//		GVars_Camera.init();
//		Index_Interface.init();
//		GVars_Controller.init();
//		
//		GVars_Heart.changeVue(new Vue_StartScreen(),true) ; 
//
//		if(GVars_Heart.isFullScreen)
//		{
//			DisplayMode mode = Gdx.graphics.getDisplayMode();
//			Gdx.graphics.setFullscreenMode(mode);
//		}
		
		GVars_UI.init() ; 
		GVars_Camera.init();
		Index_Interface.init();
		GVars_Controller.init();
		
		GVars_Heart.changeVue(new Vue_StartScreen(),true) ; 

		if(GVars_Heart.isFullScreen)
		{
			DisplayMode mode = Gdx.graphics.getDisplayMode();
			Gdx.graphics.setFullscreenMode(mode);
		}
		
		Index_Interface.init();
	}

	@Override
	public void render () 
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	float delta = Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f);
    
    	if (delta > 0) 
    	{
    		Player_Inputs.updateInput_ControllingInterface() ;
    		
    		if(!GVars_Heart.isPaused)
    			GVars_Heart.vue.update(delta);
        	
    		GVars_Heart.vue.render();
    	}
	}
	
    @Override
	public void resize(int width, int height) 
	{

	}

    @Override
    public void pause()
    {}

    @Override
    public void resume()
    {}

    @Override
	public void dispose() 
	{
    
    }
}
