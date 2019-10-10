package jks.input;

import static jks.input.GVars_Controller.getPlayer;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import jks.vars.GVars_Game;
import jks.vars.GVars_Heart;

public class IKM_Game_Keyboard extends InputAdapter 
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
			
			if(pressingTop(keycode))
			{
				inputing.upPressed = true ; 
				return true ;
			}
			else if(pressingDown(keycode))
			{
				inputing.downPressed = true ; 
				return true ; 
			}		
			else if(pressingLeft(keycode))
			{
				inputing.leftPressed = true ; 
				inputing.rightPressed = false ;
				return true ;
			}
			else if(pressingRight(keycode))
			{
				inputing.rightPressed = true ; 
				inputing.leftPressed = false ;
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
		
		private boolean pressingTop(int keycode) 
		{
			if(GVars_Heart.isAzerty && Keys.Z == keycode)
				return true ; 
			else if(Keys.W == keycode)
				return true ;
				
			if(Keys.UP == keycode)
				return true ;
			
			return false; 
		}
		
		private boolean pressingDown(int keycode) 
		{
			if(Keys.S == keycode)
				return true ; 
				
			if(Keys.DOWN == keycode)
				return true ;
			
			return false; 
		}
		
		private boolean pressingLeft(int keycode) 
		{
			if(GVars_Heart.isAzerty && Keys.Q == keycode)
				return true ; 
			else if(Keys.A == keycode)
				return true ;
				
			if(Keys.LEFT == keycode)
				return true ;
			
			return false; 
		}
		
		private boolean pressingRight(int keycode) 
		{
			if(Keys.D == keycode)
				return true ; 
			
			if(Keys.RIGHT == keycode)
				return true ;
			
			return false; 
		}
}