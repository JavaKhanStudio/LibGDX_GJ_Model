package jks.vinterface;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import jks.personnage.Enum_AnimState;
import jks.personnage.SIW_Data;
import jks.personnage.SpriteModel;
import jks.tools.Vector2Int;
import jks.vinterface.controlling.ControleFairy;
import jks.vinterface.controlling.ControllableInterface;
import jks.vinterface.controlling.Utils_Controllable;
import jks.vinterface.overlay.OverlayPause;
import jks.vue.Utils_View;

public class GVars_Interface implements Runnable 
{

	public static Skin baseSkin;
	public static Stage mainInterface;
	public static Table interaction;
	
	public static Vector2Int cursorPos ; 
	
	public static ControllableInterface currentControllable;
	public static ArrayList<ArrayList<Button>> buttonMap ;

	
	public static void init() 
	{
		baseSkin = Init_UI.loadSkin();
		mainInterface = new Stage();
		Index_Interface.init();
		Gdx.input.setInputProcessor(mainInterface);
	}

	public static void reset()
	{
		mainInterface = new Stage();
		resetInterface();
		Gdx.input.setInputProcessor(mainInterface);
	}

	@Override
	public void run() {
		init();
	}
	
	public static void setPause(boolean setPause) 
	{
		if(setPause) 
		{
			Utils_View.setOverlay(new OverlayPause());
		}
		else
		{
			Utils_View.removeCurrentOverlay() ;
			Utils_View.removeFilter() ;
		}
	}
	
	public static void activedInterface(ControllableInterface newInterface)
	{
		currentControllable = newInterface ;
		buttonMap = newInterface.mapInterface() ; 
		cursorPos = newInterface.startAt() ;
		Button currentButton = Utils_Controllable.getCurrentButton() ;
		currentButton.getClickListener().enter(null, 0, 0, -1, null) ;
//		controlFairy.teleportAt(currentButton) ; 
	}
	
	public static void selectButton()
	{
		InputEvent event1 = new InputEvent();
		event1.setType(InputEvent.Type.touchDown);
		buttonMap.get(cursorPos.x).get(cursorPos.y).fire(event1);
		System.out.println("nothing");
	}
	
	public static void resetInterface()
	{
		if(currentControllable == null) return ;
		
		currentControllable = currentControllable.getClosingLink() ;
		if(currentControllable != null)
		{
			activedInterface(currentControllable) ;
		}
		else
		{
			buttonMap = null ; 
			cursorPos = null ; 
		}
	
	}

}