package jks.personnage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import jks.vars.GVars_Heart; 

public class SpriteModel extends AnimationModel
{

	public SIW_Data index ;
	public Vector2 velocity = new Vector2();
	public Animation<TextureRegion> currentState ; 
	public TextureRegion currentFrame ; 
	public Enum_AnimState currentAnimState ; 


	public SpriteModel(SIW_Data index)
	{
		this.index = index ;
		changeAnimationState(Enum_AnimState.IDLE, true) ; 
		TextureRegion texture = index.animationList.get(Enum_AnimState.IDLE).getKeyFrame(0) ; 
	}
	
	
	float WIDTH ,HEIGHT;
	
	@Override
	public void draw(Batch batch) 
	{
		
		if((!GVars_Heart.isPaused || currentAnimState == Enum_AnimState.DEATH)) 
		{
			stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
		}
		
		if(currentState != null )
		{
			
			currentFrame = currentState.getKeyFrame(stateTime, PlayMode.LOOP == currentState.getPlayMode());

			WIDTH = getFrameWidth(currentFrame) ; 
			HEIGHT = getFrameHeight(currentFrame) ;
			
			batch.draw(currentFrame, position.x + (reverse ? 0 : WIDTH), position.y,WIDTH * (reverse ? 1 : -1),HEIGHT); 	
		}
		else 
		{
			System.out.println("impossible de trouver state pour");
		}
		
	}
	
	public float getFrameWidth(TextureRegion frame)
	{return (frame.getRegionWidth() * index.scale);}
	
	public float getFrameHeight(TextureRegion frame)
	{return (frame.getRegionHeight() * index.scale);}
	// Si en ortho 
	/*
	public float getFrameWidth(TextureRegion frame)
	{return ((1f / FVars_Map.tileSizeInPixel) * frame.getRegionWidth() * index.scale);}
	
	public float getFrameHeight(TextureRegion frame)
	{return ((1f / FVars_Map.tileSizeInPixel) * frame.getRegionHeight() * index.scale);}
	*/
	public void changeAnimationState(Enum_AnimState state, boolean repeat)
	{
		currentState = index.animationList.get(state) ;
		if(currentState == null)
		{
			currentState = index.animationList.values().iterator().next() ;
			System.out.println("Impossible de trouver l'animation - " + state.toString() +  " - dans SpriteModel");
		}
		currentAnimState = state  ;

		if (repeat) {
			currentState.setPlayMode(PlayMode.LOOP);
		} else {
			currentState.setPlayMode(PlayMode.NORMAL);
		}
	}
	
}
