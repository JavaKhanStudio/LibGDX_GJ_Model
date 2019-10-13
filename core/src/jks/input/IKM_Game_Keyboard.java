package jks.input;

import static jks.input.GVars_Controller.getPlayer;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import jks.vars.GVars_Game;
import jks.vars.GVars_Heart;
import jks.vinterface.controlling.Utils_Controllable;

public class IKM_Game_Keyboard extends InputAdapter 
{
		// PC input
		@Override
		public boolean keyDown (int keycode) 
		{
			if(GVars_Game.inCinematic)
				return true; 
			
			Player_Inputs inputing = getPlayer(null) ; 
			return inputingControl(keycode, inputing, true);
		}

		
		@Override
		public boolean keyUp (int keycode) 
		{
			if(GVars_Game.inCinematic)
				return true; 
			
			Player_Inputs inputing = getPlayer(null) ;  			
			return inputingControl(keycode, inputing, false);
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
		
		private boolean inputingControl(int keycode, Player_Inputs inputing, boolean pressingDown) 
		{
			if(inputing == null)
				return false; 
			
			if(inputing.isAdmin && pressingDown)	
			{
				Utils_Controllable.decodeInterfaceKeybord(keycode);
				return true; 
			}
				
			if(pressingTop(keycode))
			{
				inputing.upPressed = pressingDown ;
				return true ;
			}
			else if(pressingDown(keycode))
			{
				inputing.downPressed = pressingDown ; 
				return true ; 
			}		
			else if(pressingLeft(keycode))
			{
				inputing.leftPressed = pressingDown ;
				return true ;
			}
			else if(pressingRight(keycode))
			{
				inputing.rightPressed = pressingDown ;
				return true ;
			}
			
			return false ;
		}
		
		public static boolean pressingTop(int keycode) 
		{
			if(GVars_Heart.isAzerty && Keys.Z == keycode)
				return true ; 
			else if(Keys.W == keycode)
				return true ;
				
			if(Keys.UP == keycode)
				return true ;
			
			return false; 
		}
		
		public static boolean pressingDown(int keycode) 
		{
			if(Keys.S == keycode)
				return true ; 
				
			if(Keys.DOWN == keycode)
				return true ;
			
			return false; 
		}
		
		public static boolean pressingLeft(int keycode) 
		{
			if(GVars_Heart.isAzerty && Keys.Q == keycode)
				return true ; 
			else if(Keys.A == keycode)
				return true ;
				
			if(Keys.LEFT == keycode)
				return true ;
			
			return false; 
		}
		
		public static boolean pressingRight(int keycode) 
		{
			if(Keys.D == keycode)
				return true ; 
			
			if(Keys.RIGHT == keycode)
				return true ;
			
			return false; 
		}
		
		public static boolean pressingEnter(int keycode) 
		{
			if(Keys.ENTER == keycode)
				return true ; 
			
			if(Keys.SPACE == keycode)
				return true ;
			
			return false; 
		}
		
		
}