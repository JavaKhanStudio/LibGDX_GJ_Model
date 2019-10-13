package jks.vinterface.controlling;

import static jks.vinterface.GVars_UI.buttonMap;
import static jks.vinterface.GVars_UI.cursorPos;
import static jks.input.GVars_Inputs.* ; 

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

import jks.input.KeysXbox;
import jks.tools.Enum_Timming;
import jks.tools.GlobalTimmer;
import jks.vinterface.GVars_UI;
import static jks.input.IKM_Game_Keyboard.* ; 

public class Utils_Controllable 
{

	
	public static void decodeInterfaceKeybord(int keycode)
	{
		System.out.println("key " + keycode);
		
		if(pressingTop(keycode))
			moveY(true) ; 
		else if(pressingDown(keycode))
			moveY(false) ;
		else if(pressingRight(keycode))
			moveX(true) ;
		else if(pressingLeft(keycode))
			moveX(false) ;
		else if(pressingEnter(keycode))
			 GVars_UI.selectButton() ; 
	}
	
	static int neededTime = 100 ; 
	
	public static void decodeInterfaceController()
	{
		if(neededTime > GlobalTimmer.getElapse(Enum_Timming.CONTROLLER_MOVE, false))
			return ;
		///*	
		if(leftPressed)
		{moveX(false) ;}
		else if(rightPressed)
		{moveX(true) ; }
		
		if(upPressed)
		{moveY(true) ; }
		else if(downPressed)
		{moveY(false) ; }
		//*/
		GlobalTimmer.getElapse(Enum_Timming.CONTROLLER_MOVE, true);
	}
	
	public static boolean decodeInterfaceControllerButton(int buttonCode) 
	{
		switch (buttonCode) 
		{
			case KeysXbox.A :
				GVars_UI.selectButton() ;
				return true ;
			case KeysXbox.START :
				return true ;
		}
		
		return false ; 
	}
	
	private static void moveY(boolean positif) 
	{
		exitButton() ; 
		
		if(positif)
		{
			if(cursorPos.y - 1 < 0)
			{cursorPos.y = buttonMap.get(cursorPos.x).size() - 1 ;}
			else
			{cursorPos.y -- ;}
		}
		else
		{
			if(cursorPos.y + 1 >= buttonMap.get(cursorPos.x).size())
			{cursorPos.y = 0 ;}
			else
			{cursorPos.y ++ ;}
		}
		
		
		enterButton();
//		GVars_Interface.controlFairy.moveToo(getCurrentButton());
	}

	public static void moveX(boolean positif)
	{
		exitButton() ; 
		
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
		getCurrentButton() ;
		
		enterButton() ; 
//		GVars_Interface.controlFairy.moveToo(getCurrentButton());
	}
	
	public static void exitButton()
	{
		Button before = buttonMap.get(cursorPos.x).get(cursorPos.y) ; 
		
		InputEvent exitLast = new InputEvent();
		exitLast.setType(InputEvent.Type.exit);
		before.fire(exitLast);
	}
	
	public static void enterButton()
	{
		Button after = buttonMap.get(cursorPos.x).get(cursorPos.y) ; 
		InputEvent entering = new InputEvent();
		entering.setType(InputEvent.Type.enter);
		after.fire(entering);
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