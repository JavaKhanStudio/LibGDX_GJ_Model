package jks.input;

import jks.vinterface.GVars_Interface;
import jks.vinterface.controlling.Utils_Controllable; 

public class GVars_Inputs 
{
	public static boolean 
		touched, 
		jumpPressed,
		upPressed, downPressed,
		leftPressed, rightPressed,
		zoomInPressed, zoomOutPressed,
		jumpSupression
		;
	
	public static int startSelection_X ;
	public static int startSelection_Y ;
	

	
	public static boolean blockActionForClick ; // Considere s'il faut annuler toute autre action de click

	public static void updateInput_Game (float delta) 
	{
		
		if (leftPressed)
		{} 
		
		if (rightPressed)
		{}
		
		if(jumpPressed)
		{}
		
		if(jumpSupression)
		{

		}
	}
	
	public static void updateInput_ControllingInterface()
	{
		if(GVars_Interface.currentControllable != null)
		{Utils_Controllable.decodeInterfaceController();}
	}

	public static void resetInputs()
	{
		touched = false ;
		jumpPressed = false ;
		upPressed = false ;
		downPressed = false ;
		leftPressed  = false ;
		rightPressed = false ;
		zoomInPressed = false ;
		zoomOutPressed = false ;
	}

	
	
}
