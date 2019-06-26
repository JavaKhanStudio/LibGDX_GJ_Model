package jks.amain;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import jks.input.Player_Inputs;
import jks.vars.GVars_Heart;
import jks.vue.models.Vue_Game;

public class Main_Game extends ApplicationAdapter 
{


	@Override
	public void create () 
	{
		GVars_Heart.changeVue(new Vue_Game(),true) ; 
//		Gdx.graphics.setWindowedMode(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()) ; 
//		Gdx.graphics.setVSync(true);
//		Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode()) ; 
//		Gdx.graphics.setWindowedMode(width, height)
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
