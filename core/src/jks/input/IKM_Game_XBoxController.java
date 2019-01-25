package jks.input;

import static jks.input.GVars_Inputs.*;
import static jks.input.GVars_Inputs.jumpPressed;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;

import jks.debug.GVars_Debug;
import jks.vars.GVars_Game;
import jks.vars.GVars_Heart;
import jks.vinterface.GVars_Interface;
import jks.vinterface.controlling.Utils_Controllable;

public class IKM_Game_XBoxController implements ControllerListener
{
	
	@Override
	public void connected(Controller controller) 
	{
		if(GVars_Debug.coreInformationDebug)
			System.out.println("Connecte controller");
		
	}

	@Override
	public void disconnected(Controller controller) 
	{
		if(GVars_Debug.coreInformationDebug)
			System.out.println("Disconnected controller");
		
		GVars_Heart.togglePauseMenu();
	}

	@Override
	public boolean buttonDown(Controller controller, int buttonCode) 
	{
		switch (buttonCode) 
		{
			case KeysXbox.A :
				jumpPressed = true ; 
				return true ;
			case KeysXbox.START :
				GVars_Heart.togglePauseMenu();
				return true ;
			case KeysXbox.BACK :
				if(GVars_Debug.coreInformationDebug)
				{
					GVars_Heart.vue.restart();
				}
				return true ;
		}
		return false;
	}

	@Override
	public boolean buttonUp(Controller controller, int buttonCode) 
	{
		if(GVars_Game.inCinematic)
			return true; 
		
		switch (buttonCode) 
		{
			case KeysXbox.A :
				jumpPressed = false ;
				jumpSupression = true ; 
				return true ;
			case KeysXbox.BACK :
				return true ;
		}
		return false;
	}
	
	@Override
	public boolean axisMoved(Controller controller, int axisCode, float value) 
	{return Utils_Controller.axisController(axisCode,value) ;}

	@Override
	public boolean povMoved(Controller controller, int povCode, PovDirection value) 
	{
		return false;
	}

	@Override
	public boolean xSliderMoved(Controller controller, int sliderCode, boolean value) 
	{
		return false;
	}

	@Override
	public boolean ySliderMoved(Controller controller, int sliderCode, boolean value) 
	{
		return false;
	}

	@Override
	public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value) 
	{
		return false;
	}

}
