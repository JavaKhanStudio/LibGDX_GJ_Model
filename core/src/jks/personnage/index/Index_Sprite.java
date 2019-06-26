package jks.personnage.index;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import jks.debug.GVars_Debug;

public class Index_Sprite 
{
	public static ArrayList<Boolean> colorSelected ; 
	public static ArrayList<SIW_Data> persoModel ; 
	
	public static ArrayList<SIW_Data> monsterModel ; 
	public static Sprite hpBottle ; 
	private static float scale = 0.5f; 
	private static float scaleMonster = 0.3f; 
	private static Random random = new Random() ; 
	
	private static float bottleScaling = 3.6f ;
	
	public static void init()
	{
		colorSelected = new ArrayList<Boolean>() ;
		persoModel = new ArrayList<SIW_Data>() ; 
		monsterModel = new ArrayList<SIW_Data>() ; 
		addColor("Red",Color.RED) ; 
		addColor("Blue",Color.BLUE) ;
		addMonster(1) ; 
		hpBottle = new Sprite(new Texture("tools/healing_1.png"));
		hpBottle.setSize(hpBottle.getWidth()/bottleScaling, hpBottle.getHeight()/bottleScaling) ; 

		if(!GVars_Debug.debugMode)
		{
			addMonster(2) ; 
			addMonster(4) ; 
			addMonster(5) ;
			
			addColor("Green",Color.GREEN) ; 
			addColor("Teal",Color.TEAL) ; 
			addColor("Yellow",Color.YELLOW) ; 
			addColor("Gris",Color.GRAY) ; 
		}

		
	}
	
	private static void addColor(String colorName,Color color)
	{
		persoModel.add(SIW_Data.getHeroData(scale,colorName,color)) ;
		colorSelected.add(false) ;
	}
	
	private static void addMonster(int number)
	{
		monsterModel.add(SIW_Data.getMonsterData(scaleMonster, number)) ; 
	}
	
	public static SIW_Data getRandomEnnemy()
	{
		return monsterModel.get(random.nextInt(monsterModel.size())) ;
	}

	
	public static SIW_Data getRandomHeroColor()
	{
		int value = random.nextInt(persoModel.size()) ; 
		return gettingData(value) ; 
	}

	private static SIW_Data gettingData(int value) 
	{
		if(colorSelected.get(value))
		{
			value++ ;
			if(value == persoModel.size())
			{value = 0 ;}	
			return gettingData(value) ; 
		}
		else
		{
			colorSelected.set(value, Boolean.TRUE)  ;
			return persoModel.get(value) ; 
		}

	}
	
}
