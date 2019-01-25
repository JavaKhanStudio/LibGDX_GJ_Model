package jks.input;

import static jks.input.GVars_Inputs.* ; 

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import jks.debug.GVars_Debug;
import jks.vars.GVars_Game;
import jks.vars.GVars_Heart;
import jks.vinterface.GVars_Interface;
import jks.vinterface.controlling.Utils_Controllable;

public class IKM_Game_Keyboard extends InputAdapter 
{
		// PC input
		@Override
		public boolean keyDown (int keycode) 
		{
	
			
			switch (keycode) 
			{
//				case Keys.W:
				case Keys.UP:
				case Keys.SPACE:
					jumpPressed = true ; 
					return true;
//				case Keys.A:
				case Keys.LEFT:
					leftPressed = true;
					return true;
//				case Keys.D:
				case Keys.RIGHT:
					rightPressed = true;
					return true ; 
//				case Keys.S :
				case Keys.DOWN :
					downPressed = true ;
					return true;
				case Keys.ESCAPE :
					GVars_Heart.togglePauseMenu();
					return true ; 
				default : 
					if(GVars_Debug.coreInformationDebug)
						return debuggOptions(keycode) ;
					else 
						return false ; 
				
			}
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

		@Override
		public boolean keyUp (int keycode) 
		{
			if(GVars_Game.inCinematic)
				return true; 
			
			switch (keycode) 
			{
				case Keys.W:
				case Keys.UP:
				case Keys.SPACE:
					jumpPressed = false ; 
					jumpSupression = true ;
					return true;
				case Keys.A:
				case Keys.LEFT:
					leftPressed = false;
					return true;
				case Keys.D:
				case Keys.RIGHT:
					rightPressed = false;
					return true;
				case Keys.DOWN :
				case Keys.S :
					downPressed = false ;
					return true ; 
				case Keys.PLUS : 
				case Keys.Q : 
					zoomInPressed = false ;
					return true ; 
				case Keys.MINUS : 
				case Keys.E : 
					zoomOutPressed = false ;
					return true ; 
			}
			return false;
		}
}
