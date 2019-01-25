package jks.vinterface.controlling;

import com.badlogic.gdx.Input.Keys;

import com.badlogic.gdx.scenes.scene2d.ui.Button;

import jks.debug.GVars_Debug;
import jks.input.KeysXbox;
import jks.tools.Enum_Timming;
import jks.tools.GlobalTimmer;
import jks.vars.GVars_Heart;
import jks.vinterface.GVars_Interface;
import static jks.vinterface.GVars_Interface.* ; 
import static jks.input.GVars_Inputs.* ;

public class Utils_Controllable 
{

	public static void decodeInterfaceKeybord(int keycode)
	{
		switch(keycode)
		{
			case Keys.UP    : moveY(true) ; break ;
			case Keys.DOWN  : moveY(false) ; break ;
			case Keys.RIGHT : moveX(true) ; break ;
			case Keys.LEFT  : moveX(false) ; break ;
			case Keys.ENTER : GVars_Interface.selectButton() ; break ;
		}
	}
	
	static int neededTime = 180 ; 
	
	public static void decodeInterfaceController()
	{
		if(neededTime > GlobalTimmer.getElapse(Enum_Timming.CONTROLLER_MOVE, false))
			return ;
			
		if(leftPressed)
		{moveX(false) ;}
		else if(rightPressed)
		{moveX(true) ; }
		
		if(upPressed)
		{moveY(true) ; }
		else if(downPressed)
		{moveY(false) ; }
		
		GlobalTimmer.getElapse(Enum_Timming.CONTROLLER_MOVE, true);
	}
	
	public static boolean decodeInterfaceControllerButton(int buttonCode) 
	{
		switch (buttonCode) 
		{
			case KeysXbox.A :
				GVars_Interface.selectButton() ;
				return true ;
			case KeysXbox.START :
				return true ;
		}
		
		return false ; 
	}
	
	private static void moveY(boolean positif) 
	{
		if(positif)
		{
			if(cursorPos.y + 1 >= buttonMap.get(cursorPos.x).size())
			{cursorPos.y = 0 ;}
			else
			{cursorPos.y ++ ;}
		}
		else
		{
			if(cursorPos.y - 1 < 0)
			{cursorPos.y = buttonMap.get(cursorPos.x).size() - 1 ;}
			else
			{cursorPos.y -- ;}
		}
		
//		GVars_Interface.controlFairy.moveToo(getCurrentButton());
	}

	public static void moveX(boolean positif)
	{
		if(positif)
		{
			if(cursorPos.x + 1 >= buttonMap.size())
			{cursorPos.x = 0 ;}
			else
			{cursorPos.x ++ ;}		
		}
		else
		{
			if(cursorPos.x - 1 < 0 )
			{cursorPos.x = buttonMap.size() - 1;}
			else
			{cursorPos.x -- ;}	
		}
		
		checkForYCompatibility() ;
//		GVars_Interface.controlFairy.moveToo(getCurrentButton());
	}

	public static Button getCurrentButton()
	{return buttonMap.get(cursorPos.x).get(cursorPos.y);}
	
	private static void moveControleFairy()
	{
		
	}
	
	private static void checkForYCompatibility() 
	{
		// TODO Auto-generated method stub
	}
	
}