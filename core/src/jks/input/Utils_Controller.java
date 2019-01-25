package jks.input;

import static jks.input.GVars_Inputs.downPressed;
import static jks.input.GVars_Inputs.leftPressed;
import static jks.input.GVars_Inputs.rightPressed;
import static jks.input.GVars_Inputs.upPressed;

import jks.vars.GVars_Game;
import jks.vinterface.GVars_Interface;
import jks.vinterface.controlling.Utils_Controllable;

public class Utils_Controller 
{
	static float minForceMoveX = 0.3f;
	static float minForceMoveY = 0.2f;
	
	public static boolean axisController(int axisCode, float value)
	{
		if(GVars_Game.inCinematic)
		{
			return true; 
		}
		
		if(axisCode == KeysXbox.AXIS_LEFT_X)
		{
			if(value > minForceMoveX)
			{
				leftPressed = false;
				rightPressed = true;
			}
			else if(value < -minForceMoveX)
			{
				leftPressed = true;
				rightPressed = false;
			}
			else
			{
				leftPressed = false;
				rightPressed = false;
			}
		}
		
		if(axisCode == KeysXbox.AXIS_LEFT_Y)
		{
			if(value > minForceMoveY)
			{
				upPressed = false;
				downPressed = true;
			}
			else if(value < -minForceMoveY)
			{
				upPressed = true;
				downPressed = false;
			}
			else
			{
				upPressed = false;
				downPressed = false;
			}
		}
	
		return false ; 
	}
	
}
