package jks.input;

import jks.vinterface.GVars_UI;
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
//		
//		if (leftPressed)
//		{GVars_Game.player.velocity.x -= GVars_Player.velocityAccelerationX * delta ;} 
//		
//		if (rightPressed)
//		{GVars_Game.player.velocity.x += GVars_Player.velocityAccelerationX * delta ;}
//		
//		if(jumpPressed)
//		{if(GVars_Game.player.isGrounded()) GVars_Game.player.jump();}
//		
//		if(jumpSupression)
//		{
//			GVars_Game.player.jumpSuppresion();
//			jumpSupression = false ; 
//		}
	}
	
	public static void updateInput_ControllingInterface()
	{
		if(GVars_UI.currentControllable != null)
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
