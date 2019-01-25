package jks.personnage;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SIW_Data 
{
	public HashMap<Enum_AnimState,Animation<TextureRegion>> animationList ;
	public float scale ;
	
	public SIW_Data(TextureAtlas textureAtlas, HashMap<Enum_AnimState,String> animationName, float animationSpeed, float Scale)
	{
		animationList = new HashMap<Enum_AnimState,Animation<TextureRegion>>() ;
		
		for(Enum_AnimState finalName : animationName.keySet())
		{
			animationList.put(finalName, new Animation(animationSpeed, textureAtlas.findRegions(animationName.get(finalName)))) ;
		}
	
		scale = Scale ;
	}
	
	public static SIW_Data getHeroData(float scale)
	{
		TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("perso/doggy.atlas"));
		HashMap<Enum_AnimState,String> animationList = new HashMap<Enum_AnimState,String>() ; 
		animationList.put(Enum_AnimState.RUN, "Run") ; 
		animationList.put(Enum_AnimState.DEATH, "Dead") ; 
		animationList.put(Enum_AnimState.JUMP, "Jump") ; 
		animationList.put(Enum_AnimState.HURT, "Hurt") ; 
		animationList.put(Enum_AnimState.IDLE, "Idle") ; 
		animationList.put(Enum_AnimState.WALK, "Walk") ; 
		
		return new SIW_Data(textureAtlas,animationList,0.06f,scale) ; 
	}
	
	public static SIW_Data getChienData(float scale)
	{
		TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("perso/Chinchilla.atlas"));
		HashMap<Enum_AnimState,String> animationList = new HashMap<Enum_AnimState,String>() ; 
		animationList.put(Enum_AnimState.RUN, "chinchilla_course") ; 
		animationList.put(Enum_AnimState.DEATH, "chinchilla_mort") ; 
		animationList.put(Enum_AnimState.JUMP, "chinchillasaut") ;  
		animationList.put(Enum_AnimState.IDLE, "chinchilla_arret") ; 
		animationList.put(Enum_AnimState.WALK, "chinchilla_depart") ; 
		animationList.put(Enum_AnimState.FALL, "chinchillafall") ; 
		
		return new SIW_Data(textureAtlas,animationList,0.062f,scale) ; 
	}
	
	public static SIW_Data getLoup() 
	{
		TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("perso/Chinchilla.atlas"));
		HashMap<Enum_AnimState,String> animationList = new HashMap<Enum_AnimState,String>() ; 
		animationList.put(Enum_AnimState.RUN, "chinchilla_course") ; 
		animationList.put(Enum_AnimState.DEATH, "chinchilla_mort") ; 
		animationList.put(Enum_AnimState.JUMP, "chinchillasaut") ;  
		animationList.put(Enum_AnimState.IDLE, "chinchilla_arret") ; 
		animationList.put(Enum_AnimState.WALK, "chinchilla_depart") ; 
		animationList.put(Enum_AnimState.FALL, "chinchillafall") ; 
		
		return new SIW_Data(textureAtlas,animationList,0.055f,1f) ; 
	}
	
	public static SIW_Data getPlante() 
	{
		TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("perso/plante.atlas"));
		HashMap<Enum_AnimState,String> animationList = new HashMap<Enum_AnimState,String>() ; 
		animationList.put(Enum_AnimState.IDLE, "herbe") ; 
		
		return new SIW_Data(textureAtlas,animationList,0.1f,0.25f) ; 
	}
	
}
