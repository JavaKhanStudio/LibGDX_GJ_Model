package jks.vue.models;

import static jks.vinterface.Index_Interface.*;

import static jks.vinterface.Index_Interface.manager;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.btree.branch.Sequence;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RemoveAction;
import com.badlogic.gdx.scenes.scene2d.actions.RemoveActorAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.kotcrab.vis.ui.widget.VisImage;

import jks.camera.GVars_Camera;
import jks.sounds.Enum_Music;
import jks.sounds.GVars_AudioManager;
import jks.vars.GVars_Heart;
import jks.vinterface.GVars_UI;
import jks.vue.AVue_Model;

public class Vue_Preloading extends AVue_Model
{
	
	public Texture logo_Team ;
	public Texture logo_Engine ;
	public Texture logo_Jam ;
	
	//public Texture currentDrawing ; 
	
	VisImage showingLogo ; 
	
	int logoSize ; 
	
	ArrayList<Texture> imageSequence ; 
	
	@Override
	public void init() 
	{
		resize(0,0) ; 
		imageSequence = new ArrayList<Texture>() ; 
		GVars_AudioManager.PlayMusic(Enum_Music.GAME_INTRO);
		logo_Team = manager.get(introLogo_Team, Texture.class) ;
		logo_Engine = manager.get(introLogo_LibGDX, Texture.class) ;
		logo_Jam = manager.get(introLogo_Jam, Texture.class) ;
		
		imageSequence.add(logo_Engine) ; 
		imageSequence.add(logo_Jam) ; 
		
		goInSequence(logo_Team) ; 
	}
	
	
	private void goInSequence(Texture meTexutre)
	{
		showingLogo = new VisImage(meTexutre) ; 
		showingLogo.setSize(logoSize, logoSize);
		
		GVars_UI.mainUi.addActor(showingLogo);
		fadeInAndOut(showingLogo) ;
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
		GVars_UI.mainUi.act(delta);
		
		if(showingLogo.getActions().size == 0)
		{
			
			System.out.println("Bad ass");
			if(imageSequence.size() > 0)
			{
				goInSequence(imageSequence.get(0)) ; 
				imageSequence.remove(0) ; 
			}
			else
			{
				GVars_Heart.changeVue(new Vue_StartScreen(),true) ; 
			}
		}
	}

	@Override
	public void render() 
	{
		drawInterface() ;
//		GVars_Camera.staticBatch.begin() ;
//		GVars_Camera.staticBatch.draw(currentDrawing);
//		GVars_Camera.staticBatch.end() ;
	}

	@Override
	public void resize(int x, int y) 
	{
		logoSize = Gdx.graphics.getWidth()/5 ; 
	}
	
	private final float relativeWidth = 0.9f ;
	private final float timeToGetUp = 1.0f ;
	
	private final float waiting = 2 ; 
	
	public void fadeInAndOut(Actor actor)
	{
		actor.setPosition(Gdx.graphics.getWidth()/2 - actor.getWidth()/2, Gdx.graphics.getHeight()/2 - actor.getHeight() * relativeWidth);
		actor.setColor(1, 1, 1, 0);
		
		MoveToAction sceneEnter_Movement = new MoveToAction();
		sceneEnter_Movement.setPosition(actor.getX(), Gdx.graphics.getHeight()/2 - actor.getHeight()/2);
	    sceneEnter_Movement.setDuration(timeToGetUp);
	    
	    AlphaAction sceneEnter_Alpha = new AlphaAction() ; 
	    sceneEnter_Alpha.setAlpha(1);
	    sceneEnter_Alpha.setDuration(timeToGetUp);
	    
	    DelayAction delay = new DelayAction(waiting) ; 
	    
	    RemoveActorAction remove = new RemoveActorAction() ; 
	    
	    SequenceAction sequence = new SequenceAction() ; 
	    sequence.addAction(sceneEnter_Alpha);
	    sequence.addAction(delay);
	    sequence.addAction(remove);
	    
	    
	    actor.addAction(sceneEnter_Movement);
	    actor.addAction(sequence);
	}
	
}
