package jks.vue.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import jks.tools2d.parallax.heart.Parallax_Heart;
import jks.vue.AVue_Model;

public class Vue_Game extends AVue_Model 
{
		
	boolean asBeenInit = false ; 

	@Override
	public void init() 
	{
		
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
		Parallax_Heart.act(delta) ; 
		
	}

	@Override
	public void render() 
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Parallax_Heart.renderMainPage() ;
		
		
		
		
	}

	public void drawDebug()
	{
	
	}
}
