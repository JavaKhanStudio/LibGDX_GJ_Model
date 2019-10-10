package jks.input;

import static jks.input.GVars_Controller.getPlayer;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

import jks.vars.GVars_Game;
import jks.vars.GVars_Heart;

public class IKM_Interface_Keyboard extends InputAdapter 
{
	// PC input
	@Override
	public boolean keyDown (int keycode) 
	{		
		Player_Inputs inputing = getPlayer(null) ; 
		
		if(inputing == null)
		{
			return false; 
		}
		
		switch (keycode) 
		{
			case Keys.SPACE :
			case Keys.UP :
				inputing.jumpPressed = true ; 
				return true ;
			case Keys.D :
				inputing.powerLeft = true ; 
				return true ;
			case Keys.Q :
				inputing.powerRight = true ; 
				return true ;
			case Keys.LEFT :
				inputing.leftPressed = true ; 
				inputing.rightPressed = false ;
				return true ;
			case Keys.RIGHT :
				inputing.rightPressed = true ; 
				inputing.leftPressed = false ;
				return true ;
			case Keys.ESCAPE :
				return true ;
			case Keys.BACKSPACE :
				return true ;	
		}

		return false ; 
	}
	
	@Override
	public boolean keyUp (int keycode) 
	{
		if(GVars_Game.inCinematic)
			return true; 
		
		Player_Inputs inputing = getPlayer(null) ;  
		
		if(inputing == null)
			return false ; 
		
		switch (keycode) 
		{
		case Keys.LEFT :
			inputing.leftPressed = false ; 
			return true ;
		case Keys.RIGHT :
			inputing.rightPressed = false ; 
			return true ;
		}
		
		return false;
	}
	
	private boolean debuggOptions(int keycode) 
	{
		switch(keycode)
		{
			case Keys.DEL :
				GVars_Heart.vue.restart(); return true ;
			case Keys.R :
			
			default :
				System.out.println("Nothing found for " + keycode);
				return false ; 
		}	
		
	}		
}