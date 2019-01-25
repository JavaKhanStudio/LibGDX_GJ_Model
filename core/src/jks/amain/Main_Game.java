package jks.amain;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import jks.camera.GVars_Camera;
import jks.input.GVars_Inputs;
import jks.vars.GVars_Heart;
import jks.vue.models.Vue_Enter;
import jks.vue.models.Vue_Game;

public class Main_Game extends ApplicationAdapter 
{


	@Override
	public void create () 
	{
		GVars_Heart.init();
		GVars_Heart.changeVue(new Vue_Enter(),true) ;    
		Gdx.graphics.setVSync(true);
	}

	@Override
	public void render () 
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	float delta = Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f);
    
    	if (delta > 0) 
    	{
    		GVars_Inputs.updateInput_ControllingInterface() ;
    		
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
    	try
    	{
    		System.out.println("EMERGENCY SAVE");
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println("faild to emergency save!");
    	}
    	
    }
}
